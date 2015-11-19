/**
  * Created by juan on 18/11/15.
  */
import org.scalatest._

class NinoPruebas extends FlatSpec {
    var maquillaje = new Maquillaje()
    var nino = new Nino(5, List(maquillaje))
    var adulto = new AdultoComun()

    "Un nino" should "mostrar su capacidad de asustar" in {
        //La capacidad de asustar deberia ser maquillaje * actitud.
        assert(nino.capacidadDeSusto() == (3 * 5))
    }

    it should "obtener caramelos al asustar a alguien" in {
        //Le agrego un Niño Heavy porque si no su tolerancia es 10*0
        //y por lo tanto siempre da 0 caramelos.
        adulto.agregarNinoHeavy(nino)
        nino.asustarA(adulto)
        assert(nino.cantidadDeCaramelos() == 5)
    }
}

class LegionPruebas extends FlatSpec {
    var maquillaje = new Maquillaje()
    var trajeTerrorifico = Traje.terrorifico()
    var trajeTierno = Traje.tierno()
    var ninoA = new Nino(5, List(maquillaje))
    var ninoB = new Nino(6, List(trajeTerrorifico))
    var ninoC = new Nino(3, List(trajeTierno))
    var legion = new Legion(List(ninoA, ninoB))
    var adulto = new AdultoComun()

    "Una legion" should "fallar si hay menos de dos ninos" in {
        //Va a interceptar una excepcion.
        intercept[IllegalArgumentException] {
            var legionFalla = new Legion(List(ninoA))
        }
    }

    it should "obtener caramelos al asustar a una persona" in {
        val caramelosAntes = legion.cantidadDeCaramelos()
        adulto.agregarNinoHeavy(ninoA)
        legion.asustarA(adulto)
        assert(legion.cantidadDeCaramelos() > caramelosAntes)
    }

    it should "poder estar conformada tanto ninos como legiones" in {
        val legionDeLegiones = new Legion(List(legion, ninoC))
    }
}

class BarrioPruebas extends FlatSpec {
    var maquillaje = new Maquillaje()
    var trajeTerrorifico = Traje.terrorifico()
    var trajeTierno = Traje.tierno()
    var ninoA = new Nino(5, List(maquillaje))
    var ninoB = new Nino(6, List(trajeTerrorifico))
    var ninoC = new Nino(7, List(maquillaje, trajeTierno))
    var ninoD = new Nino(8, List(trajeTierno))
    var ninoE = new Nino(4, List(trajeTerrorifico))
    var barrio = new Barrio(List(ninoA, ninoB, ninoC, ninoD, ninoE))

    ninoA.caramelos = 2
    ninoB.caramelos = 5
    ninoC.caramelos = 8
    ninoD.caramelos = 12
    ninoE.caramelos = 15

    "Un barrio" should "mostrar los tres ninos con mas caramelos" in {
        val ninosConMasCaramelos = barrio.ninosConMasCaramelos()
        assert(ninosConMasCaramelos.size == 3 &&
            ninosConMasCaramelos.contains(ninoC) &&
            ninosConMasCaramelos.contains(ninoD) &&
            ninosConMasCaramelos.contains(ninoE))
    }

    it should "mostrar los elementos sin repetir usados por los ninos con mas de 10 caramelos" in {
        var elementosNinosConMuchosCaramelos = barrio.elementosNinosConMuchosCaramelos()
        assert(elementosNinosConMuchosCaramelos.size == 2 &&
            elementosNinosConMuchosCaramelos.contains(trajeTerrorifico) &&
            elementosNinosConMuchosCaramelos.contains(trajeTierno))
    }
}

class AlimentacionPruebas extends FlatSpec {
    var maquillaje = new Maquillaje()
    var ninoA = new Nino(1, List(maquillaje))

    "Un nino" should "disminuir sus caramelos luego de comerlos" in {
        ninoA.caramelos = 5
        ninoA.comerCaramelos(3)
        assert(ninoA.cantidadDeCaramelos() == 2)
    }

    it should "fallar si no tiene suficientes caramelos" in {
        ninoA.caramelos = 1
        intercept[Exception] {
            ninoA.comerCaramelos(2)
        }
    }
}

class IndigestionPruebas extends FlatSpec {
    var trajeTerrorifico = Traje.terrorifico()
    //El nino Higuain se bajaba todos los caramelos.
    var ninoHiguain = new Nino(2, List(trajeTerrorifico))
    ninoHiguain.caramelos = 100

    "Un nino" should "seguir en estado sano si comen menos de 10 caramelos" in {
        ninoHiguain.estado = new EstadoNormal()
        assert(ninoHiguain.estado.isInstanceOf[EstadoNormal])
        ninoHiguain.comerCaramelos(8)
        assert(ninoHiguain.estado.isInstanceOf[EstadoNormal])
    }

    it should "pasar a estado empachado al comer mas de diez caramelos" in {
        ninoHiguain.estado = new EstadoNormal()
        ninoHiguain.comerCaramelos(15)
        assert(ninoHiguain.estado.isInstanceOf[EstadoEmpachado])
        //Actitud 2 * Traje 5 = 10 de susto... Pero como esta empachado
        //deberia bajar a la mitad. Por eso preguntamos si su nueva
        //capacidad de susto es 5.
        assert(ninoHiguain.capacidadDeSusto() == 5)
    }

    it should "pasar a estar en cama al comer mas de diez y estando empachado" in {
        ninoHiguain.estado = new EstadoEmpachado()
        ninoHiguain.comerCaramelos(11)
        assert(ninoHiguain.estado.isInstanceOf[EstadoEnCama])
        assert(ninoHiguain.capacidadDeSusto() == 0)
    }

    it should "no comer cuando esta en cama" in {
        ninoHiguain.estado = new EstadoEnCama()
        val caramelosAntes = ninoHiguain.cantidadDeCaramelos()
        ninoHiguain.comerCaramelos(5)
        assert(ninoHiguain.cantidadDeCaramelos() == caramelosAntes)
    }
}
