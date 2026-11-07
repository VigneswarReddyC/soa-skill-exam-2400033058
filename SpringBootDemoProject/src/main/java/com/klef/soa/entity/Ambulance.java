package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ambulance_table")
public class Ambulance 
{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long ambulanceid;
	@Column(length=100,nullable=false)
	private String name;
	//     Healthcare Highways Care Convoy Medic Express Blue Light Brigade Compassion Cruise Hope on Wheels CareLink Transport Vital Vehicle Services Emergency Essentials
	@Column(length=100,nullable=false)
	private String type;
	// BLS-Basic Life Support , ALS-Advanced Life Support, patient-Patient Transport Ambulance , transport, air,
	@Column(nullable=false)
	private boolean status;
	@Column(length=100,nullable=false)
	private String location;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime UpdatedAt;
	public long getAmbulanceid() {
		return ambulanceid;
	}
	public void setAmbulanceid(long ambulanceid) {
		this.ambulanceid = ambulanceid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return UpdatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		UpdatedAt = updatedAt;
	}
	
	
	
}
