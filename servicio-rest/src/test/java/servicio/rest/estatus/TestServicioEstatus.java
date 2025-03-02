package servicio.rest.estatus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import ve.com.servicio.rest.DTO.response.ModeloRespBase;
import ve.com.servicio.rest.controlador.estatus.ControladorRestEstatusServicio;
import ve.com.servicio.rest.utils.EnumRespuesta;

class TestServicioEstatus {

    @InjectMocks
    private ControladorRestEstatusServicio controlador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

	   @Test
	    public void testEstatus() {

	        // Llamar al método a probar
	        ModeloRespBase respuesta = controlador.estatus();

	        // Verificar la respuesta
	        assertNotNull(respuesta);
	        assertEquals(EnumRespuesta.Aprobada.getCodigo(), respuesta.getCodigo());
	        assertEquals(EnumRespuesta.Aprobada.getMensajeCliente(), respuesta.getMensajeCliente());
	        assertEquals("Servicio ACTIVO", respuesta.getMensajeSistema());
	    }
}
