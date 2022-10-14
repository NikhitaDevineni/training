package com.example.demo.entity;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level =AccessLevel.PRIVATE)


@Entity
@Table(name="restarunt_sep_2022")
public class Restuarnt {
	@Id
	@Column(name="restuarnt_name",length=5)
	int resturantId;
	@Column(name="resturant_name",length=45)
	String resturantName;
	@Column(name="location",length=30)
	String location;
	@Column(name="rating",precision=2,scale=5)
	double rating;
	@Column(name="opening_date")
	LocalDate opringDate;

}
