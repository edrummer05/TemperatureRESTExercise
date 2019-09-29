package com.temperatures.temperatures;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.temperatures.temperatures.Temperature;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
	
	
	  //@Procedure(procedureName = "insertTemperature")
	  //@Query(nativeQuery = true, value = "call insertTemperature(:temperature)")
	  //public int insertTemperature(@Param("temperature") float temperature);
	  
	/*
	 * //@Procedure(procedureName = "deleteTemperature")
	 * 
	 * @Query(nativeQuery = true, value = "call deleteTemperature(:id)") public void
	 * deleteTemperature(@Param("id") int id);
	 * 
	 * //@Procedure(procedureName = "updateTemperature")
	 * 
	 * @Query(nativeQuery = true, value =
	 * "call updateTemperature(:id, :temperature)") public void
	 * updateTemperature(@Param("id") int id, @Param("temperature") float
	 * temperature);
	 */
	 
	
	//@Procedure(procedureName = "getAllTemperatures")
	@Query(nativeQuery = true, value = "call getAllTemperatures")
	public List<Temperature> getAllTemperatures();

}
