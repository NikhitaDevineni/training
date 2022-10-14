package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBatchProcessingApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringBatchProcessingApplication.class, args);
        JobLauncher launcher=ctx.getBean(JobLauncher.class);
        Job jobOne =ctx.getBean(Job.class);
        JobParameters jobParameters =
                    new JobParametersBuilder()
                      .addLong("time", System.currentTimeMillis())
                      .toJobParameters();



            try {
                launcher.run(jobOne, jobParameters);
            } catch (Exception e) {
                
                e.printStackTrace();
            }
             
             System.out.println("Job Completed");
             
             ctx.close();
    }
    
		
	}


