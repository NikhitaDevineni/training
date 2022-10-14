package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Restuarnt;
import com.example.demo.ifaces.RestuarntRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class RestaurntService {
	public RestuarntRepository repo;
	
	private Restuarnt add(Restuarnt entity) {
	return this.repo.save(entity);

}
public List<Restuarnt> findAll(){
	return this.repo.findAll();
}
public Restuarnt findById(int id) {
	String message="Element with"+ id+"Not Found";
	return this.repo.findById(id).orElseThrow(()-> new RuntimeException(message));
	
}
public Restuarnt remove(int id) {
	Restuarnt obj=findById(id);	
	this.repo.deleteById(id);
	return obj;
}
public List<Restuarnt> findByName(String name) {
	
	return this.repo.findByRestaurntName(name);
}
public List<Restuarnt>fetchUsingLocation(String location){
	
	return this.repo.fetchUsingLocation(location);
}
public int updateRating(int i,double d) {
	return this.repo.updateRating(i, d);
	
	
}
public List<Restuarnt> fetchUsingRating(double dou){
	return this.repo.fetchUsingRating(dou);
	
}
public Restuarnt update(Restuarnt entity){
	return this.repo.save(entity);	
}
}
