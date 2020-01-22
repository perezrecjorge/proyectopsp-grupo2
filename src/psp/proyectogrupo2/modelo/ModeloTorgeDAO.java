package psp.proyectogrupo2.modelo;

import java.util.List;

import psp.proyectogrupo2.modelo.tipos.NoticiaVO;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

public interface ModeloTorgeDAO {


	//Métodos para implementar en la clase UsuarioVO

	 List<UsuarioVO> cargarListaUsuarios() throws ExcepcionTorge;

	 UsuarioVO getUsuario(Integer i) throws ExcepcionTorge;

	 void guardarUsuario(UsuarioVO p) throws ExcepcionTorge;

	 void modificarUsuario(UsuarioVO p) throws ExcepcionTorge;

	 void borrarUsuario(Integer id) throws ExcepcionTorge;

	//Métodos para implementar en la clase NoticiaVO

	 List<NoticiaVO> cargarListaNoticias() throws ExcepcionTorge;

	 NoticiaVO getNoticia(Integer i) throws ExcepcionTorge;

	 void guardarNoticia(NoticiaVO p) throws ExcepcionTorge;

	 void modificarNoticia(NoticiaVO p) throws ExcepcionTorge;

	 void borrarNoticia(Integer id) throws ExcepcionTorge;

}
