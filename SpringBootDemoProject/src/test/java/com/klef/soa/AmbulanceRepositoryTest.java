
package com.klef.soa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Ambulance;
import com.klef.soa.repository.AmbulanceRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AmbulanceRepositoryTest {

    @Autowired
    private AmbulanceRepository repository;

    private Long id;

    @BeforeEach
    void setUp() {

        repository.deleteAll();

        Ambulance a1 = new Ambulance();
        a1.setName("CityCare Ambulance");
        a1.setType("BLS");
        a1.setStatus(true);
        a1.setLocation("Vijayawada");

        id = repository.save(a1).getAmbulanceid();

        Ambulance a2 = new Ambulance();
        a2.setName("HealthExpress");
        a2.setType("ALS");
        a2.setStatus(true);
        a2.setLocation("Guntur");

        repository.save(a2);

        Ambulance a3 = new Ambulance();
        a3.setName("EmergencyCare");
        a3.setType("Patient Transport");
        a3.setStatus(false);
        a3.setLocation("Tenali");

        repository.save(a3);
    }

  
    @Test
    void testFindAll() {

        List<Ambulance> list = repository.findAll();

        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());

        System.out.println("Total Ambulances: " + list.size());
    }

    
    @Test
    void testFindById() {

        Optional<Ambulance> ambulance = repository.findById(id);

        assertTrue(ambulance.isPresent());
        assertEquals(id, ambulance.get().getAmbulanceid());

        Optional<Ambulance> invalid =
                repository.findById(Long.MAX_VALUE);

        assertFalse(invalid.isPresent());

        System.out.println("Ambulance ID: " + id);
    }


    @Test
    void testFindByName() {

        List<Ambulance> list =
                repository.findByName("CityCare Ambulance");

        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("CityCare Ambulance", list.get(0).getName());

        System.out.println("Ambulance Name: " + list.get(0).getName());
    }

    @Test
    void testCount() {

        long count = repository.count();

        assertEquals(3L, count);

        System.out.println("Total Count: " + count);
    }

    @Test
    void testAmbulanceDetails() {

        Optional<Ambulance> ambulance = repository.findById(id);

        assertTrue(ambulance.isPresent());

        Ambulance a = ambulance.get();

        assertNotNull(a.getName());
        assertNotNull(a.getType());
        assertNotNull(a.getLocation());
        assertNotNull(a.getCreatedAt());

        assertTrue(a.isStatus());

        System.out.println("Name: " + a.getName());
        System.out.println("Type: " + a.getType());
        System.out.println("Location: " + a.getLocation());
        System.out.println("Status: " + a.isStatus());
    }
}
