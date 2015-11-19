/**
  * Created by juan on 18/11/15.
  */
class EstadoEmpachado extends Estado {
    override def comerCaramelos(unNino : Nino, cantidad : Int): Unit = {
        super.comerCaramelos(unNino, cantidad)
        if(cantidad >= 10) {
            unNino.estado = new EstadoEnCama()
        }
    }

    override def capacidadDeSusto(unNino : Nino) : Int = {
        super.capacidadDeSusto(unNino) / 2 //Disminuye a la mitad.
    }
}
