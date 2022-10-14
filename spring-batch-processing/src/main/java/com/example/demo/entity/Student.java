package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level =AccessLevel.PRIVATE)
@Table(name="Student_sep_2022")
public class Student {
@Id
@Column(name="roll_number")
int rollNumber;
@Column(name="Student_name")
String StudentName;
@Column(name ="mark_scored")
int markScored;
}
