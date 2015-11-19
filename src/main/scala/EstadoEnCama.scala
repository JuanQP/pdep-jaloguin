/**
  * Created by juan on 18/11/15.
  */
class EstadoEnCama extends Estado {
    override def comerCaramelos(unNino : Nino, cantidad : Int): Unit = {
        //No hace nada.
    }

    override def capacidadDeSusto(unNino : Nino) : Int = {
        0
    }
}
