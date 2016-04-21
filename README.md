# SesionTesting03

####Nombre: Nicolas Oñate 
####Asignatura: Testing en desarrollo ágil

####Pruebas realizadas


	- Categoria
	- Existencia
	- Producto
	
####Resumen de las pruebas :punch:

#####Clase Categoria
	
Se crearon 6 pruebas en total, todas las pruebas pasaron. :+1:
	
#####Clase Existencia

Se crearon 3 pruebas en total, una prueba falló, debido a que se consideró que el número de la existencia no deberia considerar caracteres no numéricos, por lo tanto en la prueba realizada se esperó que el método `getNumero()` devolviese un string solo con numeros y no con caracteres no numericos como se pasó en el constructor de la clase.
	
#####Clase Producto

Se crearon 19 pruebas en total, ninguna prueba falló, se encontró un error en el metodo `addExistencia`, dicho error se produce porque se genera una excepción ArrayIndexOutOfBoundsException, debido a que en el metodo `addExistencia` se permite añadir mas existencias al arreglo que el stock máximo que se ingresa como parametro en el constructor de la clase.
	
####Cobertura de las pruebas

Se utilizó el plugin de eclipse **EclEmma Java Code Coverage** para ver la cobertura de las pruebas realizadas el resultado fue el siguiente:
	
![alt text](http://oi66.tinypic.com/qyip1k.jpg)
	
se puede observar que la cobertura de todas las clases es 100% a excepción de la clase Producto ya que por el error antes descrito de esta clase, nunca se logra cubrir todo el código del método `addExistencia`