package repository;

import model.Cliente;
import model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepo extends JpaRepository<Produto, Integer> {
    @Query(value = "SELECT a FROM Produto a WHERE a.descricao LIKE %?1%")
    List<Cliente> findByParteDescricao(String descricao);

    @Query(value = "SELECT a FROM Produto a WHERE a.preco > ?1")
    List<Produto> findByPreco(Double preco);

    List<Produto> findByMarca(String marca);

    @Query(value = "ELECT a FROM Produto a WHERE a.marca LIKE %?1% and a.preco > ?2")
    List<Produto> findByMarcaPreco(String marca, Double preco);
}
