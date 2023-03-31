package com.lcwd.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
    private HotelService hotelService;
	//get All
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHostList() {
		return ResponseEntity.ok(this.hotelService.getAllHotelList());
	}
	//Create hotel
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
	}
	//get single hotel list
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.hotelService.getHotelById(hotelId));
	}
}
