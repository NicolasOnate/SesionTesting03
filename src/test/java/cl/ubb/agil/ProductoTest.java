/**
 * Nombre: Nicolas Oñate
 * Asignatura: Testing en desarrollo ágil
 * Fecha: 20/04/2016
 */

package cl.ubb.agil;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProductoTest {
	
	//objetos de pruebas
	private Producto producto;
	private Categoria categoria;
	
	@Test(expected = NegativeArraySizeException.class)
	public void productoStockMaximoIsNegative() throws NegativeArraySizeException{
		/* arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, -5);
	}
	
	
	@Test
	public void productoGetStockIsZero(){
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 20);
		
		/* Act */
		int resultado = producto.getStock();
		
		/* Assert */
		assertThat(resultado, is(0));
	}
	
	@Test
	public void productoIsBajoStockIsTrue(){
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 20);
		
		/* Act */
		boolean resultado = producto.isBajoStock();
		
		/* Assert */
		assertThat(resultado, is(true));
	}
	
	@Test
	public void productoIsBajoStockIsFalse(){
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 20);
		Existencia existencia = new Existencia("990012");
		
		/* Act */
		
		//esto deberia añadir una existencia al producto y aumentar el stock
		producto.addExistencia(existencia);
		
		boolean resultado = producto.isBajoStock();
		
		/* Assert */
		assertThat(resultado, is(false));
	}
	
	@Test
	public void productoIsBajoStockWithStockMinimoNegative(){
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", -5, 20);
		Existencia existencia = new Existencia("990012");
		
		/* Act */
		producto.addExistencia(existencia);
		boolean resultado = producto.isBajoStock();
		
		/* Assert */
		assertThat(resultado, is(false));
	}
	
	@Test
	public void productoGetStockFaltanteIsFive(){
		
		/* Arrange */
		categoria = new Categoria("Guitarras Eléctricas", "00001");
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 7);
		
		Existencia existencia = new Existencia("990012");
		Existencia existencia2 = new Existencia("990013");
		
		/* Act */
		
		//aumentar el stock
		producto.addExistencia(existencia);
		producto.addExistencia(existencia2);
				
		int resultado = producto.getStockFaltante();
		
		/* Assert */
		assertThat(resultado, is(5));
	}
	
	@Test
	public void productoGetProximaExistencia() throws ExcepcionDeProducto{
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 7);
		
		Existencia existencia = new Existencia("990012");
		Existencia existencia2 = new Existencia("990013");

		/* Act */
		
		//aumentar el stock
		producto.addExistencia(existencia);
		producto.addExistencia(existencia2);
		
		Existencia resultado = producto.getProximaExistencia();
		
		/* Assert */
		assertThat(resultado, is(existencia2));
		
	}
	
	@Test(expected = ExcepcionDeProducto.class)
	public void productoGetProximaExistenciaThrowExcepcionDeProducto() throws ExcepcionDeProducto{
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 7);
		
		Existencia existencia = new Existencia("990012");
		Existencia existencia2 = new Existencia("990013"); //stock 2
		
		/* Act */
		
		//aumentar el stock
		producto.addExistencia(existencia);
		producto.addExistencia(existencia2);
		
		producto.getProximaExistencia();
		producto.getProximaExistencia();
		
		//stock == 0
		Existencia resultado = producto.getProximaExistencia();
		
		/* Assert */
		//se espera una excepcion	
	}
	
	@Test
	public void productoAddExistenciaIsTrue(){
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 7);		
		Existencia existencia = new Existencia("990012");
		
		/* Act */
		boolean resultado = producto.addExistencia(existencia);
		
		/* Assert */
		assertThat(resultado, is(true));
	}

	/**
	 * ACLARACION:
	 * Este test genera un error, no un fallo, lo dejé para evidenciar
	 * el error en el metodo de la clase producto.
	 * El error es que se produce un ArrayIndexOutOfBoundsException porque en 
	 * el metodo addExistencia se permite añadir mas existencias al arreglo que el stock maximo
	 */
	@Test
	public void productoAddExistenciaIsFalse(){
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2);		
		Existencia existencia = new Existencia("990012");
		Existencia existencia2 = new Existencia("990013");
		Existencia existencia3 = new Existencia("990014");
		Existencia existencia4 = new Existencia("990015");
		
		/* Act */
		producto.addExistencia(existencia);
		producto.addExistencia(existencia2);
		producto.addExistencia(existencia3);
		boolean resultado = producto.addExistencia(existencia4);
		
		/* Assert */
		assertThat(resultado, is(false));
	}

	/**
	 * En este caso se espera la excepcion
	 * @throws ArrayIndexOutOfBoundsException
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void productoAddExistenciaThrowException() throws ArrayIndexOutOfBoundsException{
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2);		
		Existencia existencia = new Existencia("990012");
		Existencia existencia2 = new Existencia("990013");
		Existencia existencia3 = new Existencia("990014");
		
		/* Act */
		producto.addExistencia(existencia);
		producto.addExistencia(existencia2);
		producto.addExistencia(existencia3); //lanza excepcion
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void productoAddExistenciaConStockMaximoCero() throws ArrayIndexOutOfBoundsException{
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 0);
		Existencia existencia = new Existencia("990012");
		
		/* Act */
		producto.addExistencia(existencia);
		
	}
	
	@Test
	public void productoGetCategoria(){
		
		/* Arrange */
		categoria = new Categoria("Guitarras Eléctricas", "00001");
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2, categoria);	
		
		/* Act */
		Categoria resultado = producto.getCategoria();
		
		/* Assert */
		assertThat(resultado, is(categoria));
		
	}
	
	@Test
	public void productoSetCategoria(){
		
		/* Arrange */
		categoria = new Categoria("Guitarras Eléctricas", "00001");
		
		//creo el objeto producto con una categoria
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2, categoria);	
		
		Categoria categoria2 = new Categoria("Guitarras Acústicas", "00002");
		
		/* Act */
		producto.setCategoria(categoria2); //se setea una nueva categoria al producto
		Categoria resultado = producto.getCategoria();
		
		/* Assert */
		assertThat(resultado, is(categoria2));
		
	}
	
	@Test
	public void productoGetNombre(){
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2);	
		
		/* Act */
		String resultado = producto.getNombre();
		
		/* Assert */
		assertThat(resultado, is("Guitarra Gibson Les Paul Studio"));
	}
	
	@Test
	public void productoSetNombre(){
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2);
		String nombre2 = "Guitarra Gibson SG '61 Reissue";
		String nombre3 = "Guitarra Gibson SG Specia";
		
		/* Act */
		producto.setNombre(nombre2);
		producto.setNombre(nombre3);
		producto.setNombre(nombre2);
		
		String resultado = producto.getNombre();
		
		/* Assert */
		assertThat(resultado, is(nombre2));
		
	}
	
	@Test(expected = ExcepcionDeProducto.class)
	public void productoGetCodigoProximaExistenciaThrowExcepcionDeProducto() throws ExcepcionDeProducto{
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2);
		
		/* Act */
		String resultado = producto.getCodigoProximaExistencia();
	}
	
	@Test
	public void productoGetCodigoProximaExistenciaSinCategoria() throws ExcepcionDeProducto{
		
		/* Arrange */
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2);
		Existencia existencia = new Existencia("990012");
		String codigoExistencia = "XXXXX-"+existencia.getNumero();
		
		/* Act */
		producto.addExistencia(existencia);
		String resultado = producto.getCodigoProximaExistencia();
		
		/* Assert */
		assertThat(resultado, is(codigoExistencia));
	}
	
	@Test
	public void productoGetCodigoProximaExistenciaConCategoria() throws ExcepcionDeProducto{
		
		/* Arrange */
		categoria = new Categoria("Guitarras Eléctricas", "00001");
		producto = new Producto("Guitarra Gibson Les Paul Studio", 1, 2, categoria);
		Existencia existencia = new Existencia("990012");
		String codigoExistencia = categoria.getCodigo() + "-" + existencia.getNumero();
		
		/* Act */
		producto.addExistencia(existencia);
		String resultado = producto.getCodigoProximaExistencia();
		
		/* Assert */
		assertThat(resultado, is(codigoExistencia));	
	}
	
}
