/**
  * Created by juan on 17/11/15.
  */
class Legion extends Asustador {
    var ninos : List[Asustador] = List()

    def this(ninos : List[Asustador]) {
        this()
        if(ninos.size < 2) {
            throw new IllegalArgumentException("Deben haber al menos 2 ninos en una legion")
        }
        this.ninos = ninos
    }

    override def capacidadDeSusto(): Int = {
        ninos.map(x => x.capacidadDeSusto).sum
    }

    override def cantidadDeCaramelos(): Int = {
        ninos.map(nino => nino.cantidadDeCaramelos).sum
    }

    def lider(): Asustador = {
        ninos.maxBy(nino => nino.cantidadDeCaramelos)
    }

    override def asustarA(unaPersona : AdultoComun): Unit = {
        unaPersona.recibirSustoDe(this)
    }

    override def esHeavy() : Boolean = {
        false
    }

    override def agregarCaramelos(unaCantidad : Int): Unit = {
        lider.agregarCaramelos(unaCantidad)
    }

    override def comerCaramelos(unaCantidad : Int): Unit = {
        lider.comerCaramelos(unaCantidad)
    }

}
