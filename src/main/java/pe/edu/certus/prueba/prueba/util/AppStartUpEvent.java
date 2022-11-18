package pe.edu.certus.prueba.prueba.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import pe.edu.certus.prueba.prueba.data.Room;
import pe.edu.certus.prueba.prueba.data.RoomRepository;
@Component
public class AppStartUpEvent implements ApplicationListener<ApplicationReadyEvent> {
	//private final RoomRepository roomRepository;
	
	public AppStartUpEvent(RoomRepository roomRepository) {
	//	this.roomRepository = roomRepository;
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		
	//	System.out.println(this.roomRepository.count());
	//	Iterable<Room> rooms = this.roomRepository.findAll();
	//	rooms.forEach(System.out::println);
	}

}
