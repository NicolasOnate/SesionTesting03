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
