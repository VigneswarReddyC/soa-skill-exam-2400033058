package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Ambulance;
import java.util.List;


@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Long> 
{

	List<Ambulance> findByName(String name);
    List<Ambulance> findByType(String type);
}
