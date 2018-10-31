package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import dao.ProductoDao;
import vo.ProductoVo;

@ManagedBean
@ViewScoped
public class ProductoBean {
	
	private ProductoVo productoVo;
	private List<ProductoVo> listaProductos;
	ProductoDao productoDao;
	private String mensaje;
	private String navegacion;
	
	public ProductoBean(){
		productoVo=new ProductoVo();
		productoDao=new ProductoDao();
	}
	
	
	public void registrarProducto(){
		System.out.println("Registro de producto");
			mensaje=productoDao.agregarProducto(productoVo);
			if (mensaje.equalsIgnoreCase("Registro Exitoso")) {
				mensaje="Se ha registrado exitosamente!";	
			}else{
				mensaje="Ocurrió un problema al registrar, verifique nuevamente";	
			}
	}
	
	public void consultarProducto(){
		System.out.println("Consulta de producto: "+productoVo.getId());
		productoVo=productoDao.consultarProductoIndividual(productoVo.getId());
		if (productoVo!=null) {
			setMensaje("");
		}else{
			setMensaje("No se encuentra el producto");
			productoVo=new ProductoVo();
		}
	}
	
	public void consultar(){
		System.out.println("Consulta la lista de productos: "+productoVo.getId());
		
		productoDao=new ProductoDao();
		
		setListaProductos(productoDao.obtenerListaProductos());
	}
	
	public void actualizarProducto(){
		System.out.println("Actualizar producto");
		setMensaje(productoDao.editarProducto(productoVo));
	}
	
	public void eliminarProducto(){
		System.out.println("Eliminar producto");
		setMensaje(productoDao.eliminarProducto(productoVo));
		productoVo=new ProductoVo();
	}

	public List<ProductoVo> getListaProductos() {
		return listaProductos;
	}
	
	public void setListaProductos(List<ProductoVo> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public ProductoVo getProductoVo() {
		return productoVo;
	}

	public void setProductoVo(ProductoVo miPersonaVo) {
		this.productoVo = miPersonaVo;
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

}
