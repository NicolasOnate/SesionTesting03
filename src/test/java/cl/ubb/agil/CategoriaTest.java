package cl.ubb.agil;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CategoriaTest {
	
	//objeto de pruebas
	private Categoria categoria;
	
	@Test
	public void addTwoPlusThreeIsFive(){	
		/* Arrange */
		categoria = new Categoria("Guitarras Electricas", "0001");
		
		/* Act */
		String resultado = categoria.getNombre();
		
		/* Assert */
		assertThat(resultado,is("Guitarras Electricas"));
	}
	

}
