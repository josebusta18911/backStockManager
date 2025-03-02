package logica.negocio.parametros;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ve.com.negocio.parametros.LogicaParametros;
import ve.com.persistencia.entidades.EntityParametros;
import ve.com.persistencia.repositorios.RepositoryParametros;


@ExtendWith(MockitoExtension.class)
public class TestLogicaParametros  {

    @Mock
    private RepositoryParametros repositoryParametros;

    @InjectMocks
    private LogicaParametros logicaParametros;

    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test
    public void testObtenerParametrosPorGrupoId() {
        List<EntityParametros> parametrosList = new ArrayList<>();
        EntityParametros parametros = new EntityParametros();
        parametros.setPargrpId("002");
        parametros.setPartipNombreParametro("CCYSACCT");
        parametrosList.add(parametros);

        when(repositoryParametros.findByPargrpId("002")).thenReturn(parametrosList);

        List<EntityParametros> result = logicaParametros.obtenerParametrosPorGrupoId("002");

        assertEquals(1, result.size());
        assertEquals("CCYSACCT", result.get(0).getPartipNombreParametro());

        verify(repositoryParametros, times(1)).findByPargrpId("002");
    }
}
