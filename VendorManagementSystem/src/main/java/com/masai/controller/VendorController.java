package com.masai.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.masai.DTO.VendorDTO;
import com.masai.DTO.VendorResponseDto;

import com.masai.entities.Vendor;

import com.masai.service.ProductServiceIntr;
import com.masai.service.VendorServiceIntr;

@RestController
public class VendorController {

	@Autowired
	private VendorServiceIntr vService;
		
	@Autowired
	private ProductServiceIntr pService;
	
	@PostMapping("/vendor")
	public ResponseEntity<Vendor> saveVendorDetails(@RequestBody VendorDTO vendor){
		Vendor v = vService.createVendor(vendor);	
		return new ResponseEntity<Vendor>(v,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/vendor/name/{vendorName}")
	public ResponseEntity<List<VendorResponseDto>> getVendorDetailsByName(@PathVariable("vendorName") String vendorName){
		List<VendorResponseDto> vlist = vService.getVendorByName(vendorName);	
		return new ResponseEntity<List<VendorResponseDto>>(vlist,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/vendor")
	public ResponseEntity<List<Vendor>> getVendorDetails(){
		List<Vendor> vlist = vService.getVendorList();	
		return new ResponseEntity<List<Vendor>>(vlist,HttpStatus.ACCEPTED);
	}
	
	
}
