package com.lcwd.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.exception.ResourceNotFoundException;
import com.lcwd.hotel.service.repository.HotelRepository;
import com.lcwd.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
    private HotelRepository hotelRepository;
	@Override
	public List<Hotel> getAllHotelList() {
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return this.hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return this.hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found !!"));
	}

}
