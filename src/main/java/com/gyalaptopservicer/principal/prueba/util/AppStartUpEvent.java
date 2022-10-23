package com.gyalaptopservicer.principal.prueba.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.gyalaptopservicer.principal.prueba.data.*;

@Component
public class AppStartUpEvent implements ApplicationListener<ApplicationReadyEvent>{

	private final RoomRepository roomRepository;
	private final ReservationRepository reservationRepository;
	
	public AppStartUpEvent(RoomRepository roomRepository, ReservationRepository reservationRepository) {
		this.roomRepository=roomRepository;
		this.reservationRepository=reservationRepository;
	}
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Mensaje de Ejecución");
		
		Iterable<Room> rooms=this.roomRepository.findAll();    
		rooms.forEach(System.out::println);
		
		Iterable<Reservation> reservations=this.reservationRepository.findAll();
		reservations.forEach(System.out::println);
	}

}
