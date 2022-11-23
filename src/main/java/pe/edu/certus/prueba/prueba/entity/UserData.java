package pe.edu.certus.prueba.prueba.entity;

public class UserData {
	private long id;
	private String nombre;
	private String usuario;
	private String contrasena;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", nombre=" + nombre + ", usuario=" + usuario + ", contrasena=" + contrasena
				+ "]";
	}
}
