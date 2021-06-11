package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;

import org.junit.Test;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class ClientePersistenceTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void ValidarBuscarUnCliente(){
        Cliente cliente = givenExisteCliente();
        Long id = whenSeGuardoCliente(cliente);
        thenLoPuedoBuscarPorId(id);

    }

    private void thenLoPuedoBuscarPorId(Long id) {
        Cliente clienteBuscado = session().get(Cliente.class, id);
        assertThat(clienteBuscado).isNotNull();

    }

    private Long whenSeGuardoCliente(Cliente cliente) {
        session().save(cliente);
        return cliente.getId();
    }

    private Cliente givenExisteCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Maria");
        cliente.setEmail("maria@mail.com");
        cliente.setPassword("2189");
        return cliente;
    }
}
