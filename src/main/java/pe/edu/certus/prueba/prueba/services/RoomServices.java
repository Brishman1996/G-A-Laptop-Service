package pe.edu.certus.prueba.prueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.certus.prueba.prueba.data.Room;
import pe.edu.certus.prueba.prueba.data.RoomRepository;



@Service
public class RoomServices {
	@Autowired
	RoomRepository roomRepository;
	
	
	public Optional<Room> obtenerRoom(Long id){
		return this.roomRepository.findById(id);
	}
	
	public void guardarRoom(Room r) {
		roomRepository.save(r);
	}
	
}
