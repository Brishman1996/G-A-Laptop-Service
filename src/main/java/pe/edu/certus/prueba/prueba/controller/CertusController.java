package pe.edu.certus.prueba.prueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.certus.prueba.prueba.data.*;
import pe.edu.certus.prueba.prueba.entity.RoomData;
import pe.edu.certus.prueba.prueba.services.RoomServices;


@Controller
public class CertusController {
	@Autowired
	private RoomServices roomServices;

	@GetMapping("/views/rooms")
	public String Saludar(@RequestParam(name = "id", required = false, defaultValue = "1") Long id, Model model) {

		RoomData bean = new RoomData();
		Optional<Room> r = roomServices.obtenerRoom(id);

		if (!r.isEmpty()) {
			//Los gets no son errores
			bean.setId( r.get().getId() );
			bean.setName(r.get().getName());
			bean.setBedInfo(r.get().getBedInfo());
			bean.setRoomNumber(r.get().getRoomNumber());
			/*
			model.addAttribute("IDCuarto", r.get().getId());
			model.addAttribute("nombre", r.get().getName());
			model.addAttribute("numCuarto", r.get().getRoomNumber());
			model.addAttribute("InfoCama", r.get().getBedInfo());
			*/
			model.addAttribute("Room", bean);
			model.addAttribute("mensaje", "OK");
		} else {
			model.addAttribute("mensaje", "No existe Habitacion con el ID");
		}

		return "Saludar";
	}
	
	@GetMapping("/views/newRoom")
	public String NewRoom(
			Model model) {
		model.addAttribute("mensaje","OK");
		model.addAttribute("Room", new RoomData());
		return "NewRoom";
	}
	
	@PostMapping("/views/guardar")
	public String SaveRoom( @ModelAttribute RoomData  room) {
		System.out.println(room);
		//Creo el objeto a almacenar
		Room r = new Room();
		//Seteo los objetos
		//Los gets no son errores
		r.setBedInfo(room.getBedInfo());
		r.setName(room.getName());
		r.setRoomNumber(room.getRoomNumber());
		//Guardo el objeto creado
		roomServices.guardarRoom(r);
		return "redirect:/views/rooms";
	}
	
	@PostMapping("/views/modificar")
	public String ModifyRoom( @ModelAttribute RoomData room) {
		System.out.println(room);
		//Creo el objeto a almacenar
		Room r = new Room();
		//Seteo los objetos
		//Los gets no son errores
		r.setBedInfo(room.getBedInfo());
		r.setName(room.getName());
		r.setRoomNumber(room.getRoomNumber());
		r.setId(room.getId());
		//Guardo el objeto creado
		roomServices.guardarRoom(r);
		return "redirect:/views/rooms?id=" + r.getId();
	}
	
}
