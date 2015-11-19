/**
  * Created by juan on 17/11/15.
  */
trait Asustador {
    def capacidadDeSusto : Int

    def cantidadDeCaramelos : Int

    def asustarA(unaPersona : AdultoComun): Unit

    def esHeavy : Boolean

    def agregarCaramelos(unaCantidad : Int): Unit

    def comerCaramelos(unaCantidad : Int): Unit
}
