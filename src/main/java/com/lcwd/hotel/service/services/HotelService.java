package com.lcwd.hotel.service.services;

import java.util.List;

import com.lcwd.hotel.service.entities.Hotel;

public interface HotelService {
    //Get all hotel list
	List<Hotel> getAllHotelList();
	//Save Hotel list
	Hotel createHotel(Hotel hotel);
	//Get single hotel list
	Hotel getHotelById(String hotelId);
}
