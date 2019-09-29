package com.temperatures.temperatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
//@RequestMapping(path="/temperature")
public class MainController {
	@Autowired
	private final TemperatureRepository temperatureRepository;
	
	MainController(TemperatureRepository temperatureRepository)
	{
		this.temperatureRepository = temperatureRepository;
	}
	
	
	  //@PostMapping(path="/temperature/insert?temperature={temperature}")
//	  @PostMapping(path="/temperature/insert") 
//	  public @ResponseBody String insertTemperature(@RequestParam(value = "temperature") float temperature) 
//	  {
//	    //int outputVariableId = 0; //Temperature t = new Temperature();
//	    //t.setTemperature(temperature); //temperatureRepository.save(t); 
//		  
////		Temperature t = new Temperature();
////		t.setTemperature(temperature);  //set temperature
////		
////		//String dateString = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(Calendar.getInstance().getTime());
////		t.setCreateDate(Calendar.getInstance().getTime());  //set create_date
////		t.setUpdateDate(null);  //set update_date to null
////		
////		//insert the temperature
////		temperatureRepository.save(t);
//		  
//		  int returnId = temperatureRepository.insertTemperature(temperature); 
//		  return "Saved Id: " + String.valueOf(returnId); 
//	  }
	  
	  //@PutMapping(path="/temperature/update?id={id}&temperature={temperature}")
	  
//	  @PutMapping(path="/temperature/update") public @ResponseBody String
//	  updateTemperature(@RequestParam(value = "id") int id, @RequestParam(value =
//	  "temperature") float temperature) {
//	  temperatureRepository.updateTemperature(id, temperature); return
//	  "Updated Id: " + String.valueOf(id); }
//	  
//	  //@DeleteMapping(path="/temperature/delete?id={id}")
//	  
//	  @DeleteMapping(path="/temperature/delete") public @ResponseBody String
//	  deleteTemperature(@RequestParam(value = "id") int id) {
//	  temperatureRepository.deleteTemperature(id); return "Deleted Id: " +
//	  String.valueOf(id); }
	 
	
	@GetMapping(path="/temperature/get")
	public @ResponseBody List<Temperature> getAllTempeatures()
	{
		return temperatureRepository.getAllTemperatures();
	}
	
	@PostMapping(path="/temperature/insert")
	public Temperature createTemperature(@RequestParam(value = "temperature") float temperature)
	{
		Temperature t = new Temperature();
		t.setTemperature(temperature);  //set temperature
		
		//String dateString = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(Calendar.getInstance().getTime());
		t.setCreateDate(Calendar.getInstance().getTime());  //set create_date
		t.setUpdateDate(null);  //set update_date to null
		
		//insert the temperature
		return temperatureRepository.save(t);
	}
	
	@PutMapping(path="/temperature/update")
	public Temperature updateTemperature(@RequestParam(value = "id") int id, @RequestParam(value = "temperature") float temperature)
	{
		//find temperature by Id using default JpaRepository call
		Temperature t = temperatureRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Temperature", "id", id));
		
		//set temperature and update_date
		t.setTemperature(temperature);
		t.setCreateDate(t.getCreateDate());  //ensure create_date doesn't change
		t.setUpdateDate(Calendar.getInstance().getTime());
		
		//update the temperature
		Temperature updatedTemperature = temperatureRepository.save(t);
		return updatedTemperature;
	}

	@DeleteMapping(path="/temperature/delete")
	public ResponseEntity<?> deleteTemperature(@RequestParam(value = "id") int id)
	{
		//find temperature by Id using default JpaRepository call
		Temperature t = temperatureRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Temperature", "id", id));
		
		//delete the temperature
		temperatureRepository.delete(t);
		
		return ResponseEntity.ok().build();
	}
	
}
