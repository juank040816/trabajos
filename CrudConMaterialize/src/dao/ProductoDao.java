package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.ProductoVo;

public class ProductoDao {

	public String agregarProducto(ProductoVo producto) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO producto (id,nombre,precio,tipo,descripcion)"
				+ "  VALUES (?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setInt(1, producto.getId());
			preStatement.setString(2, producto.getNombre());
			preStatement.setDouble(3, producto.getPrecio());
			preStatement.setString(4, producto.getTipo());
			preStatement.setString(5, producto.getDescripcion());
			preStatement.execute();

			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registra el producto: " + e.getMessage());
			resultado = "No se pudo registrar";
		} finally {
			conexion.desconectar();
		}

		return resultado;
	}

	public ArrayList<ProductoVo> obtenerListaProductos() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ProductoVo producto = new ProductoVo();
		ArrayList<ProductoVo> listaProductos = null;

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM producto ";

		try {
			if (connection != null) {
				listaProductos = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					producto = new ProductoVo();
					producto.setId(result.getInt("id"));
					producto.setNombre(result.getString("nombre"));
					producto.setPrecio(result.getDouble("precio"));
					producto.setTipo(result.getString("tipo"));
					producto.setDescripcion(result.getString("descripcion"));
					listaProductos.add(producto);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del producto: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaProductos;
	}

	public String editarProducto(ProductoVo producto) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE producto "
					+ " SET id = ? , nombre=? , precio=? , tipo=? , descripcion= ? "
					+ " WHERE id= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, producto.getNombre());
			preStatement.setDouble(2, producto.getPrecio());
			preStatement.setString(3, producto.getTipo());
			preStatement.setString(4, producto.getDescripcion());
			preStatement.setInt(5, producto.getId());
			preStatement.executeUpdate();
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado el producto satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar el producto";
		}
		return resultado;
	}

	public String eliminarProducto(ProductoVo producto) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();

		String resp = "";
		try {
			String sentencia = "DELETE FROM producto WHERE id= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setInt(1, producto.getId());

			statement.executeUpdate();

			resp = "Se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar";
		}
		return resp;
	}
	
	public ProductoVo consultarUsuarioLogin(int id, String pass) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ProductoVo producto = null;

		connection = miConexion.getConnection();
		
		System.out.println("Id: "+id+" , pass: "+pass);
		
		try {
			if (connection != null) {
				
				String consulta = "SELECT * FROM producto where id = ? and password = ? ";

				statement = connection.prepareStatement(consulta);

				statement.setInt(1, id);
				statement.setString(2, pass);
								
				result = statement.executeQuery();
				System.out.println("continua...");
				if (result.next() == true) {
					producto = new ProductoVo();
					producto.setId(result.getInt("id"));
					producto.setNombre(result.getString("nombre"));
					producto.setPrecio(result.getDouble("precio"));
					producto.setTipo(result.getString("tipo"));
					producto.setDescripcion(result.getString("descripcion"));
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del producto: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return producto;
	}


	public ProductoVo consultarProductoIndividual(int id) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ProductoVo producto = null;
		System.out.println("Id: "+id);

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM producto where id = "+id;

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				if (result.next() == true) {
					producto = new ProductoVo();
					producto.setId(result.getInt("id"));
					producto.setNombre(result.getString("nombre"));
					producto.setPrecio(result.getDouble("precio"));
					producto.setTipo(result.getString("tipo"));
					producto.setDescripcion(result.getString("descripcion"));
					producto.setPass(result.getString("password"));
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return producto;
	}
}
