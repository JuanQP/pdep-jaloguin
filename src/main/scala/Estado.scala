/**
  * Created by juan on 18/11/15.
  */
trait Estado {
    def comerCaramelos(unNino : Nino, cantidad : Int): Unit = {
        unNino.caramelos -= cantidad
    }
    def capacidadDeSusto(unNino : Nino) : Int = {
        unNino.capacidadDeSustoDelDisfraz() * unNino.actitud
    }
}
