/**
  * Created by juan on 16/11/15.
  */
class Nino extends Asustador {
    //Propiedades de la clase.
    var actitud : Int = 0
    var disfraces : List[Elemento] = List()
    var caramelos : Int = 0
    var estado : Estado = new EstadoNormal()

    //Constructor de la clase Nino.
    def this(actitud : Int, disfraces : List[Elemento]) = {
        this()
        this.actitud = actitud
        this.disfraces = disfraces
    }

    override def cantidadDeCaramelos() : Int = {
        caramelos
    }

    //Sobrescribe la función toString para poder mostrar sus valores.
    override def toString() = {
        "La actitud del nino es " + actitud
    }

    override def asustarA(unaPersona : AdultoComun): Unit = {
        unaPersona.recibirSustoDe(this)
    }

    override def capacidadDeSusto(): Int = {
        //Capacidad total.
        estado.capacidadDeSusto(this)
    }

    def capacidadDeSustoDelDisfraz() : Int = {
        //Usamos la función map de las listas que recibe una función anónima como
        //parámetro para obtener de la lista de disfraces, una lista de niveles de susto.
        //Luego, utilizamos sum para hacer la sumatoria de eso.
        disfraces.map(x => x.capacidadDeSusto).sum
    }

    override def agregarCaramelos(cantidad : Int): Unit = {
        caramelos += cantidad
    }

    override def esHeavy() : Boolean = {
        caramelos > 15
    }

    override def comerCaramelos(unaCantidad : Int): Unit = {
        if(caramelos < unaCantidad) {
            throw new Exception("Se intento comer mas caramelos de los que habian.")
        }
        estado.comerCaramelos(this, unaCantidad)
    }
}
