package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Ambulance;
import com.klef.soa.service.AmbulanceService;

@RestController
@RequestMapping("/ambulance")
public class AmbulanceController 
{
    @Autowired
	private AmbulanceService service;
    
	@GetMapping("/")
	public String home()
	{
		return "Ambulance Project";
	}
	@PostMapping("/insert")
	public ResponseEntity<Ambulance> addAmbulance(@RequestBody Ambulance a)
	{
		
		Ambulance ambulance=service.addAmbulance(a);
		//String msg="Ambulance Added Successfully";
		return ResponseEntity.status(201).body(ambulance);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateAmbulance(@RequestBody Ambulance ambulance)
	{
		Ambulance a=service.updateAmbulance(ambulance);
		if(a!=null)
		{
			return ResponseEntity.ok(a);
		}
		else
		{
			return ResponseEntity.status(404).body("Ambulance Id Not Found");
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAmbulanceById(@PathVariable long id)

	{
		String Msg=service.deleteAmbulanceById(id);
		return new ResponseEntity<>(Msg,HttpStatus.OK);
	}
	
	@GetMapping("/displayAll")
	public ResponseEntity<List<Ambulance>> displayAllAmbulances()
	{
		List<Ambulance> ambulances=service.displayallAmbulances();
		return ResponseEntity.status(200).body(ambulances);
		
	}
	
	@GetMapping("/display")
	public ResponseEntity<?> displayAmbulnaceById(@RequestParam long  id)
	{
		
		Ambulance ambulnace=service.displayAmbulanceById(id);
		if(ambulnace!=null)
		{
			return ResponseEntity.status(200).body(ambulnace);
			
		}
		else
		{
			return ResponseEntity.status(404).body("Ambulance Id not found");
			
		}
	}
	
	@GetMapping("/findbyname")
	public ResponseEntity<?> findbyname(@RequestParam String name)

	{
		List<Ambulance> a=service.finbyname(name);
		return ResponseEntity.status(200).body(a);
	}
	@GetMapping("/findbytype")
	public ResponseEntity<List<Ambulance>> findbytype(@RequestParam String type)

	{
		List<Ambulance> a=service.finbytype(type);
		return ResponseEntity.status(200).body(a);
	}
	
}
