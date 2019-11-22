package psp.proyectogrupo2.modelo;

import java.util.List;

import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

public interface TorgeDAO {

	public List<UsuarioVO> cargarListaElementos() throws ExcepcionTorge;

	public UsuarioVO getElemento(int i) throws ExcepcionTorge;

	public void guardarElemento(UsuarioVO p) throws ExcepcionTorge;

	public void modificarElemento(UsuarioVO p) throws ExcepcionTorge;

	public void borrarElemento(UsuarioVO p) throws ExcepcionTorge;

}
