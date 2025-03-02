package servicio.rest.parametros;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import ve.com.negocio.parametros.LogicaParametros;
import ve.com.persistencia.entidades.EntityParametros;
import ve.com.persistencia.repositorios.RepositoryParametros;
import ve.com.servicio.rest.DTO.request.DTOReqParametros;
import ve.com.servicio.rest.DTO.response.parametros.DTORespParametros;
import ve.com.servicio.rest.DTO.response.parametros.Parametros;
import ve.com.servicio.rest.configuracion.Configuracion;
import ve.com.servicio.rest.utils.EnumRespuesta;

@SpringBootTest(classes = Configuracion.class)
@AutoConfigureMockMvc
public class TestServicioParametros {

	   @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private RepositoryParametros repositoryParametros;

	    @MockBean
	    private LogicaParametros logicaParametros;

	    @BeforeEach
	    public void setUp() {
	        // Inicializar mocks si es necesario
	        MockitoAnnotations.openMocks(this);    
	    }
	    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test
    public void testBuscarParametrosGrupo() throws Exception {
        DTOReqParametros request = new DTOReqParametros();
        request.setPargrpId("002");
        request.setPartipNombreParametro("CCYSACCT");
        request.setPartipDescripcion("");
        request.setPartipValorDefecto("");
        request.setParvalValor("");

        List<EntityParametros> parametrosList = new ArrayList<>();
        EntityParametros parametros = new EntityParametros();
        parametros.setPargrpId("002");
        parametros.setPartipNombreParametro("CCYSACCT");
        parametros.setPartipDescripcion("");
        parametros.setPartipValorDefecto("");
        parametros.setParvalValor("");
        parametrosList.add(parametros);

        when(logicaParametros.obtenerParametrosPorGrupoId("002")).thenReturn(parametrosList);

        Parametros expectedResponse = new Parametros();
        expectedResponse.setCodigo(EnumRespuesta.Aprobada.getCodigo());
        expectedResponse.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
        expectedResponse.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());
        List<DTORespParametros> parametro = parametrosList.stream()
                .map(p -> new DTORespParametros(p.getPartipNombreParametro(), p.getPartipDescripcion(),
                        p.getPargrpId(), p.getPartipValorDefecto(), p.getParvalValor()))
                .collect(Collectors.toList());
        expectedResponse.setParametros(parametro);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/notinfi/parametrosGrupo")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(request)))       		
                .andExpect(status().isNotFound());
                //.andExpect(content().json(new ObjectMapper().writeValueAsString(expectedResponse)));

    }

}
