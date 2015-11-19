/**
  * Created by juan on 17/11/15.
  */
class Abuelo extends AdultoComun {
    override def teAsusta(unAsustador : Asustador): Boolean = {
        true
    }

    override def cantidadDeCaramelosADar() : Int = {
        super.cantidadDeCaramelosADar() / 2
    }
}
