package controller;

import model.Cliente;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ProdutoRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/apiProduto")
public class ProdutoControl {

    @Autowired
    ProdutoRepo prodRepo;

    @GetMapping(value = "/todos")
    public List<Produto> listaProdutos(){
        return prodRepo.findAll();
    }

    @PostMapping("/inserirProduto")
    public void inserirProduto(@RequestBody Produto prod) {
        prodRepo.save(prod);
    }

    @GetMapping("/cliente/{cod}")
    public Optional<Produto> buscarProdutoPorCodigo(@PathVariable int cod) {
        return prodRepo.findById(cod);
    }

    @GetMapping ("/buscar/parteDescricao/{descricao}")
    public List<Cliente> findByParteNome(@PathVariable String descricao){
        return prodRepo.findByParteDescricao(descricao);
    }

    @GetMapping ("/buscar/preco/{preco}")
    public List<Produto> buscarPorPreco(@PathVariable Double preco){
        return prodRepo.findByPreco(preco);
    }

    @GetMapping ("/buscar/marca/{marca}")
    public List<Produto> buscarPorMarca(@PathVariable String marca){
        return prodRepo.findByMarca(marca);
    }

    @GetMapping ("buscar/marcaPreco/{marca}/{preco}")
    public List<Produto> buscarPorEmailENome(@PathVariable String marca, @PathVariable Double preco){
        return prodRepo.findByMarcaPreco(marca, preco);
    }

                                        /*Métodos de delete*/

    @DeleteMapping("/removerProduto")
    public void revomerProduto(@RequestBody Produto prod) {
        prodRepo.delete(prod);
    }

    @DeleteMapping("/removerId/{codProd}")
    public void removerPorID(@PathVariable int codProd){
        prodRepo.deleteById(codProd);
    }

                                        /*Método de update*/

    @PutMapping ("/atualizar")
    public void atualizarProduto (@RequestBody Produto prod){
        prodRepo.save(prod);
    }
}
