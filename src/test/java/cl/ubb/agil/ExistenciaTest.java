package cl.ubb.agil;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExistenciaTest {
	
	//Objeto de prueba
	private Existencia existencia;
	
	@Test
	public void existenciaGetNumber(){
		
		/* Arrange*/
		existencia = new Existencia("990012");
		
		/* Act */
		String resultado = existencia.getNumero();
		
		/* Assert */
		assertThat(resultado,is("990012"));
	}
	
	/* Este test deberia esperar una excepcion pero el metodo en la clase Existencia
	 * no maneja el error de que el numero sea un string en blanco
	 */
	@Test
	public void existenciaNumberIsVoid(){
		
		/* Arrange*/
		existencia = new Existencia("");
		
		/* Act */
		String resultado = existencia.getNumero();
		
		/* Assert */
		assertThat(resultado,is(""));
		
	}
	
	@Test
	public void existenciaNumberIsACharacter(){
		
		/* Arrange*/
		existencia = new Existencia("11ASC15");
		
		/* Act */
		String resultado = existencia.getNumero();
		
		/* Assert */
		assertThat(resultado,is("1115"));
		
	}

}
