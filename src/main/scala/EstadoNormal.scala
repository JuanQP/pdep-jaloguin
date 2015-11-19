/**
  * Created by juan on 18/11/15.
  */
class EstadoNormal extends Estado {
    override def comerCaramelos(unNino : Nino, cantidad : Int): Unit = {
        super.comerCaramelos(unNino, cantidad)
        if(cantidad >= 10) {
            unNino.estado = new EstadoEmpachado()
        }
    }

}
