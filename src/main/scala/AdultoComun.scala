/**
  * Created by juan on 16/11/15.
  */
class AdultoComun {
    //Cantidad de chicos a los que les dio mas de 15 caramelos.
    var ninosHeavys : List[Asustador] = List()

    def recibirSustoDe(asustador: Asustador): Unit = {
        if (teAsusta(asustador)) {
            asustador.agregarCaramelos(cantidadDeCaramelosADar())
            if (asustador.esHeavy) {
                agregarNinoHeavy(asustador)
            }
        }
    }

    def teAsusta(asustador : Asustador): Boolean = {
        tolerancia < asustador.capacidadDeSusto
    }

    def tolerancia: Int = {
        10 * cantidadDeNinosHeavys()
    }

    def cantidadDeCaramelosADar(): Int = {
        tolerancia / 2
    }

    def agregarNinoHeavy(asustador : Asustador): Unit = {
        ninosHeavys :+= asustador
    }

    def cantidadDeNinosHeavys() : Int = {
        ninosHeavys.size
    }
}
