# Introducción

Hay que realizar el TP Grupal Integrador de Paradigmas de Programación. Es necesario aprobar el parcial para firmar la materia.

A continuación las consignas.

|Consigna|Descripción|
|------|---------|
|TP a Realizar | [Jalogüin][1] |
|Lenguaje | [Scala][2] |
|Tipos de Datos | Cómo se tipan las variables en Scala |
|Orden Superior | Scala es funcional, enumerar características
|Orientación a Objetos | Qué diferencias tiene con Smalltalk
|Polimorfismo | Tiene polimorfismo paramétrico y adhoc (Haskell y Smalltalk). ¿Cómo se pueden combinar estas cosas?
|Plazo de Pre-Entrega | Miércoles 18 de Noviembre
|Plazo de Presentación | Sábado 21 de Noviembre

[1]: http://pdep.com.ar/Parcial%20-%20Jalog%C3%BCin.pdf?attredirects=0&d=1
[2]: http://www.scala-lang.org/

# Desarrollo

Vamos a utilizar [IntelliJ IDEA][3] (es una IDE para Java y otros lenguajes) que permite soporte para utilizar Scala. Una vez que descargamos IntelliJ IDEA, seguimos los pasos de la primera ejecución. En un momento nos va a preguntar si queremos instalar el soporte para Scala, a lo cual **hay que responder que si**.

Luego, abrimos un nuevo proyecto y seleccionamos Scala. Le ponemos un nombre al proyecto y luego tenemos dos campos que podrían estar vacíos

* Project SDK: Al seleccionar en `New...` nos debería mandar al path donde estén las máquinas virtuales de Java (recordemos que Scala puede ejecutar en la máquina virtual de Java, tiene una relación directa con este lenguaje). Seleccionamos alguna, yo personalmente seleccioné la que decía `java-7-openjdk` ya que Linux venía con ésa.
* Scala SDK: Hay que decirle dónde está instalado Scala. En caso de no aparecer automáticamente, hay que hacer click en `Create...`. Si no detectó ninguna automáticamente, hay que hacerle click en `Download...` para descargar de internet Scala. **Tengan paciencia, puede tardar bastante**.

Una vez seleccionados ambos campos, se abre el workspace de la IDE.

Ahí dentro a la izquierda tienen el directorio de archivos.

Si siguen [esta guía][4] (a partir de **Creating an Object**), van a ver cómo crear un *Hola Mundo* en Scala para ver cómo ejecutarlo.

El código que podrían usar en el archivo de prueba es el siguiente (es el Hola Mundo de Scala)

```scala
object main {
  def main(args: Array[String]) {
    println("Hola mundo!")
    //Acá iría el resto del código...
  }
}
```

Hecho esto, deberían poder ver la ejecución de ese programa. Eso sería todo.

[3]: https://www.jetbrains.com/idea/
[4]: https://www.jetbrains.com/idea/help/creating-and-running-your-scala-application.html

# Tutoriales

Algunos tutoriales que estuve leyendo para entender Scala y que me parecieron recomendados.

http://tutorials.jenkov.com/scala/overview.html

http://www.tutorialspoint.com/scala/scala_overview.htm