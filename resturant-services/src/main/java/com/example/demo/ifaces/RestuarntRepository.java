package com.example.demo.ifaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Restuarnt;

public interface RestuarntRepository extends JpaRepository<Restuarnt, Integer> {
	public List<Restuarnt> findByRestaurntName(String name);
	
	@Query (value="select* from restuarnt_sep_2022 where location=:loc",nativeQuery=true)
	public List<Restuarnt> fetchUsingLocation (@Param("loc") String location);
	@Query(value ="from Resturant  where rating=:reqRating")
	public List<Restuarnt>fetchUsingRating(@Param("reqRating") double rating);
	@Modifying
	@Transactional
	@Query(value="update Restuarnt set rating=:newRating where resturantID=:id")
	public int updateRating(@Param("id")int id,@Param("newRating")double revisedRating);
	

}
