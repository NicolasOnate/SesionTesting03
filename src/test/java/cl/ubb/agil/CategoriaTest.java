/**
 * Nombre: Nicolas Oñate
 * Asignatura: Testing en desarrollo ágil
 * Fecha: 20/04/2016
 */
package cl.ubb.agil;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CategoriaTest {
	
	//objeto de pruebas
	private Categoria categoria;
	
	@Test
	public void categoriaGetName(){	
		/* Arrange */
		categoria = new Categoria("Guitarras Electricas", "0001");
		
		/* Act */
		String resultado = categoria.getNombre();
		
		/* Assert */
		assertThat(resultado,is("Guitarras Electricas"));
	}
	
	@Test
	public void categoriaGetCode(){	
		/* Arrange */
		categoria = new Categoria("Guitarras Electricas", "0001");
		
		/* Act */
		String resultado = categoria.getCodigo();
		
		/* Assert */
		assertThat(resultado,is("0001"));
	}
	
	@Test
	public void categoriaGetCodeLengthGreaterThanFive(){
		/* Arrange */
		categoria = new Categoria("Guitarras Electricas", "000001");
		
		/* Act */
		String resultado = categoria.getCodigo();
		
		/* Assert */
		assertThat(resultado,is("00000"));
	}
	
	@Test(expected = NullPointerException.class)
	public void categoriaNullPointerException(){
		/* Arrange */
		categoria = new Categoria("Guitarras Electricas", null);
		
		/* Act */
		String resultado = categoria.getCodigo();
	}
	
	@Test
	public void categoriaSetName(){	
		/* Arrange */
		categoria = new Categoria("Guitarras Electricas", "0001");
		
		/* Act */
		categoria.setNombre("Guitarras Acústicas");
		String resultado = categoria.getNombre();
		
		/* Assert */
		assertThat(resultado,is("Guitarras Acústicas"));
	}
	
	@Test
	public void categoriaSetCode(){	
		/* Arrange */
		categoria = new Categoria("Guitarras Electricas", "0001");
		
		/* Act */
		categoria.setCodigo("0002");
		String resultado = categoria.getCodigo();
		
		/* Assert */
		assertThat(resultado,is("0002"));
	}

}
