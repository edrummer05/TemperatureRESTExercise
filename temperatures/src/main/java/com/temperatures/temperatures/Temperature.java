package com.temperatures.temperatures;

import org.hibernate.annotations.GenerationTime;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.annotation.Generated;
import javax.persistence.*;

import java.util.*;
import java.io.Serializable;

@Entity
@Table(name="temperature")
//@EntityListeners(AuditingEntityListener.class)
/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "getAllTemperatures",
								procedureName = "getAllTemperatures",
	resultClasses = {Temperature.class}
	),
	
	@NamedStoredProcedureQuery(name = "deleteTemperature",
								procedureName = "deleteTemperature",
	resultClasses = {Temperature.class},
	parameters= {
			@StoredProcedureParameter(direction=ParameterMode.IN, queryParameter="id", type=Integer.class)}
	),
	
	@NamedStoredProcedureQuery(name = "insertTemperature",
								procedureName = "insertTemperature",
	resultClasses = {Temperature.class},
	parameters= {
	@StoredProcedureParameter(direction=ParameterMode.IN, queryParameter="temperature", type=Float.class)}
	),
	
	@NamedStoredProcedureQuery(name = "updateTemperature",
								procedureName = "updateTemperature",
	resultClasses = {Temperature.class},
	parameters= {
	@StoredProcedureParameter(direction=ParameterMode.IN, queryParameter="id", type=Integer.class),
	@StoredProcedureParameter(direction=ParameterMode.IN, queryParameter="temperature", type=Float.class)})
})*/
/*@NamedNativeQueries({
	@NamedNativeQuery(
			name = "insertTemperature",
			query = "call insertTemperature(:temperature)",
			resultClass = Temperature.class
	)
})
*/
public class Temperature implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Float temperature;
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(columnDefinition = "AS ((temperature * (9.0)/(5.0) + 32.0)")
	private Float temperature_fahrenheit;
	
	@CreatedDate
	private Date create_date;
	
	@LastModifiedDate
	private Date update_date;
	
	Temperature() {}
	
	Temperature(Float temperature, Float temperature_fahrenheit, Date create_date, Date update_date)
	//Temperature(Float temperature, Date create_date, Date update_date)
	{
		this.temperature = temperature;
		this.temperature_fahrenheit = temperature_fahrenheit;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Float getTemperature()
	{
		return temperature;
	}
	
	public void setTemperature(Float temperature)
	{
		this.temperature = temperature;
	}
	
	
	public Float getTemperatureFahrenheit() 
	{
		return temperature_fahrenheit; 
	}
	  
	public void setTemperatureFahrenheit(Float temperature) 
	{
	  this.temperature_fahrenheit = temperature; 
	}
	 
	
	public Date getCreateDate()
	{
		return create_date;
	}
	
	public void setCreateDate(Date date)
	{
		this.create_date = date;
	}
	
	public Date getUpdateDate()
	{
		return update_date;
	}
	
	public void setUpdateDate(Date date)
	{
		this.update_date = date;
	}
	
}
