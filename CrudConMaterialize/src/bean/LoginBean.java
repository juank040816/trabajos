package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ProductoDao;
import vo.ProductoVo;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private ProductoVo productoVo;
	ProductoDao productoDao;
	private String mensaje;
	private String navegacion;
	private boolean validado=false;
	
	public LoginBean(){
		productoVo=new ProductoVo();
		productoDao=new ProductoDao();
	}
	
	public String validarUsuario(){
		
		String resp="";
		
		System.out.println("*****************************************************");
		System.out.println("Id: "+productoVo.getId());
		System.out.println("Nombre: "+productoVo.getPass());
		
		ProductoVo producto=productoDao.consultarUsuarioLogin(productoVo.getId(), productoVo.getPass());
		
		if (producto!=null) {
			resp="bienvenido.jsf";
			mensaje="";
			productoVo=producto;
			System.out.println("USUARIO VALIDO: "+productoVo.getNombre());
		}else{
			resp="#";
			mensaje="El usuario no es Valido, Verifique nuevamente...";
			System.out.println("USUARIO NO VALIDO");
		}
		System.out.println("*****************************************************");
		return resp;
	}
	
	public void registrarUsuario(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<SE CONECTÓ>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<Desde Registrar usuario>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	public void OtroMetodoUsuario(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<Desde otro metodo usuario>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	public ProductoVo getProductoVo() {
		return productoVo;
	}

	public void setProductoVo(ProductoVo productoVo) {
		this.productoVo = productoVo;
	}

	public ProductoDao getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNavegacion() {
		return navegacion;
	}

	public void setNavegacion(String navegacion) {
		this.navegacion = navegacion;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}
}
