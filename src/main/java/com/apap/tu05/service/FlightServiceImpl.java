package com.apap.tu05.service;

import java.util.List;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.repository.FlightDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;

	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}

	@Override
	public List<FlightModel> getAllFlight() {
		return flightDb.findAll();
	}

	@Override
	public void deleteFlight(String flightNumber) {
		flightDb.delete(this.getFlightDetailByFlightNumber(flightNumber));
	}

	@Override
	public void updateFlight(String flightNumber, FlightModel updatedFlight) {
		FlightModel flight = this.getFlightDetailByFlightNumber(flightNumber);
		flight.setFlightNumber(updatedFlight.getFlightNumber());
		flight.setOrigin(updatedFlight.getOrigin());
		flight.setDestination(updatedFlight.getDestination());
		flight.setTime(updatedFlight.getTime());
	}

	@Override
	public void deleteFlightById(long id) {
		flightDb.delete(this.getFlightById(id));

	}

	@Override
	public FlightModel getFlightById(long id) {
		return flightDb.findById(id);
	}
}
