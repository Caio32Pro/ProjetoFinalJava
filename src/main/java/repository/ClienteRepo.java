package repository;

import model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByEmail(String email);

    @Query(value = "SELECT a FROM Cliente a WHERE a.nome LIKE %?1%")
    List<Cliente> findByParteNome(String nome);

    @Query(value = "SELECT a FROM Cliente a WHERE a.email LIKE %?1% and a.nome LIKE %?2%")
    public List<Cliente> findByEmailNome(String email, String nome);
}
