package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.klef.soa.entity.Ambulance;
import com.klef.soa.repository.AmbulanceRepository;

@Service
public class AmbulanceServiceImpl implements AmbulanceService
{
    @Autowired
	private AmbulanceRepository repo;
	
	@Override
	public Ambulance addAmbulance(Ambulance ambulance) {
		
		return repo.save(ambulance);
	}

	@Override
	public Ambulance updateAmbulance(Ambulance a) {
		
		Optional<Ambulance> optional=repo.findById(a.getAmbulanceid());
		if(optional.isPresent())
		{
			Ambulance ambulance=optional.get();
			
			ambulance.setName(a.getName());
			ambulance.setStatus(a.isStatus());
			ambulance.setLocation(a.getLocation());
			ambulance.setType(a.getType());
			return repo.save(ambulance);
		}
		else
		{
			return null;
		}
	}

	@Override
	public String deleteAmbulanceById(long id) {
	
		boolean status=repo.existsById(id);
		if(status)
		{
			repo.deleteById(id);;
			return "Ambulance Deleted Successfully";
			
		}
		else
		{
			return "Ambulance Id not found";
		}
	}

	@Override
	public List<Ambulance> displayallAmbulances() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Ambulance displayAmbulanceById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Ambulance> finbyname(String name) {
		
		return repo.findByName(name);
	}

	@Override
	public List<Ambulance> finbytype(String type) {
	
		return repo.findByType(type);
	}

	
}
