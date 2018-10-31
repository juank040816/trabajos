package vo;

public class ProductoVo {
	
	private int id;
	private String nombre;
	private double precio;
	private String tipo;
	private String descripcion;
	private boolean editar;
	private String pass;
	
	public ProductoVo(){ 	}
	
	public ProductoVo(int id,String nombre, double precio, String tipo, 
			String descripcion, boolean editar) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.editar=editar;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isEditar() {
		return editar;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
