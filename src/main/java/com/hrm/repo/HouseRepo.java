package com.hrm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrm.model.House;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface HouseRepo extends JpaRepository<House, Integer> {
	
	List<House>findBylocation(String location);
	
	
	
	@Query("select DISTINCT location from House order by location")
	public List<String> getLocationList();
	
	@Query("select DISTINCT rent from House order by rent")
	public List<Integer> getRentList();
	
	@Query("select DISTINCT bedroom from House order by bedroom")
	public List<String> getBedroomList();
	
	

	 @Query("SELECT h FROM House h WHERE (h.location IS NULL OR h.location = :location) OR (h.rent < 1 OR h.rent = :rent) OR (h.bedroom IS NULL OR h.bedroom = :bedroom)")
	  List<House> filterHouseList(@Param("location") String location, @Param("rent") double rent, @Param("bedroom") String bedroom);

	List<House> findByLocationAndRentAndBedroom(String location, double rent, String bedroom);
}
