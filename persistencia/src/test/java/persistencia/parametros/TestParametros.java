package persistencia.parametros;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import junit.framework.TestCase;
import ve.com.persistencia.entidades.EntityParametros;
import ve.com.persistencia.repositorios.RepositoryParametros;
/**
 * Clase para pruebas de persistencia de Parametros
 *
 */

public class TestParametros extends TestCase{

    @Autowired
    private RepositoryParametros parametroRepository;

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void buscar() {

        List<EntityParametros> found = parametroRepository.findByPargrpId("002");
        found.forEach(item -> {
            System.out.println(item);
            // Add assertions here
            assertThat(item).isNotNull();
        });
    }

}
