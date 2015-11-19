/**
  * Created by juan on 17/11/15.
  */
class Traje extends Elemento {
  var capacidadDeSusto : Int = 0

  def this(capacidadDeSusto : Int) {
    this()
    this.capacidadDeSusto = capacidadDeSusto
  }
}

object Traje {
  def tierno(): Traje = {
    new Traje(2)
  }

  def terrorifico(): Traje = {
    new Traje(5)
  }
}