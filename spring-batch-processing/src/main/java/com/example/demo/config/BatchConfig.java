package com.example.demo.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.entity.Student;
import com.example.demo.repos.StudentRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Bean
	public ItemWriter<Student> Writer(StudentRepository repo){
		return Students-> repo.saveAll(Students);
	}
	@Bean
	public ItemProcessor<Student,Student> processor(){
		return Student ->{
			if(Student.getMarkScored()<60) {
				Student.setMarkScored(Student.getMarkScored()+7);
				
				
			}
			return Student;
		};
	}
@Bean
public DefaultLineMapper<Student> mapper(){
	DefaultLineMapper<Student> mapper =new DefaultLineMapper();
	DelimitedLineTokenizer tokenizer=
			new DelimitedLineTokenizer();
	tokenizer.setNames("rollNumber","studentName","markScored");
	BeanWrapperFieldSetMapper<Student> fieldMapper=
			new BeanWrapperFieldSetMapper<>();
	
	mapper.setFieldSetMapper(fieldMapper);
	mapper.setLineTokenizer(tokenizer);
	return mapper;
	
}
@Bean
public FlatFileItemReader<Student> reader(){
	FlatFileItemReader<Student> reader =new FlatFileItemReader<>();
	reader.setResource(new ClassPathResource("/Student.csv"));
	reader.setLinesToSkip(1);
	reader.setLineMapper(mapper());
	return reader;
	
}
@Bean
public Step stepOne(StepBuilderFactory sbf,StudentRepository repo) {
	return sbf.get("StudentJob")
        .<Student,Student>chunk(2)
        .reader(reader())
        .processor(processor())
        .writer(Writer(repo))
        .build();
}
@Bean
public Job jobOne(JobBuilderFactory jbf,Step stepOne) {
     return jbf.get("studentJob")
              .start(stepOne)
             .build();



}




}

