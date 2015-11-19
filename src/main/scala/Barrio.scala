/**
  * Created by juan on 17/11/15.
  */
class Barrio {
    var ninos : List[Nino] = List()

    def this(ninos : List[Nino]) {
        this()
        this.ninos = ninos
    }

    def ninosConMasCaramelos() : List[Nino] = {
        ninosPorMasCaramelos.take(3)
    }

    def elementosNinosConMuchosCaramelos() : Set[Elemento] = {
        var elementosUsados = Set[Elemento]()
        val ninosOrdenados = ninosPorMasCaramelos.filter(nino => nino.cantidadDeCaramelos > 10)
        for(nino <- ninosOrdenados) {
            for(elemento <- nino.disfraces) {
                elementosUsados += elemento
            }
        }
        return elementosUsados
    }

    def ninosPorMasCaramelos() : List[Nino] = {
        //Los ordena por cantidad de caramelos (de menor a mayor por defecto),
        //asi que luego los invierto para que queden de mayor a menor.
        ninos.sortBy(nino => nino.cantidadDeCaramelos()).reverse
    }
}
