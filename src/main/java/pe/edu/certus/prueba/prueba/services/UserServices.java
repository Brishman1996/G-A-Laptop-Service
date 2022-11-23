package pe.edu.certus.prueba.prueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.certus.prueba.prueba.data.User;
import pe.edu.certus.prueba.prueba.data.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> obtenerUser(Long id){
		return this.userRepository.findById(id);
	}
	
	public void ValidarAcceso(User r) {
		userRepository.save(r);
	}
}
