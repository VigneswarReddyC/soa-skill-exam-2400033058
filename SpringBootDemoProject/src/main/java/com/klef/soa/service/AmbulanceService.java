package com.klef.soa.service;

import java.util.List;


import com.klef.soa.entity.Ambulance;

public interface AmbulanceService 
{

	List<Ambulance> finbyname(String name);
	List<Ambulance> finbytype(String type);
	Ambulance addAmbulance(Ambulance ambulance);
	Ambulance updateAmbulance(Ambulance a);
	String deleteAmbulanceById(long id);
	
	List<Ambulance>displayallAmbulances();
	
	Ambulance displayAmbulanceById(long id);
	
}
