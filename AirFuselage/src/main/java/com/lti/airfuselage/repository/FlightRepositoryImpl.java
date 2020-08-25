package com.lti.airfuselage.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airfuselage.exception.FlightServiceException;
import com.lti.airfuselage.model.Flight;

@Repository
public class FlightRepositoryImpl implements FlightRepository {

	@PersistenceContext
	EntityManager em;
	    
	@Override
	@Transactional
	public int add(Flight flight) {
		Flight u=em.merge(flight);
		return u.getFlightNumber();
	}

	@Override
	public List<Flight> viewRespectiveFlights(String Source,String Destination) {
		String sql = "select f from Flight f where f.Source= :source and f.Destination= :destination";
        Query qry = em.createQuery(sql);
        qry.setParameter("source", Source);
        qry.setParameter("destination", Destination);
        List<Flight> flight=qry.getResultList();
        return flight;
	}

	@Override
	@Transactional
	public boolean updateFlight(Flight flight) {
		Flight f =em.find(Flight.class, flight.getFlightNumber());
		if(f!=null){	
			em.merge(flight);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteFlight(int flightNumber) {
		Flight flight = em.find(Flight.class, flightNumber);
		 if(flight != null) {
		     em.remove(flight);
		          return true;
		        }
		return false;
	}
	
	@Override
	@Transactional
	public Flight findAFlight(int flightNumber) {
		 Flight flight = em.find(Flight.class, flightNumber);
	      return flight;
	}

	@Override
	public boolean isFlightPresent(int flightId) {
		return (Long) em.createQuery("select count(f.flightId) from Flight f where f.flightId =:fn") 
				.setParameter("fn", flightId) 
				.getSingleResult() == 1 ? true : false;
	}
	
}

