package ProjetoFinal.demoCaio.controller;

import ProjetoFinal.demoCaio.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ProjetoFinal.demoCaio.repository.ClienteRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/apiCliente")
public class ClienteControl {

    @Autowired
    ClienteRepo cliRepo;

    @GetMapping (value = "/todos")
    public List<Cliente> listaClientes(){
        return cliRepo.findAll();
    }

    @PostMapping("/inserirCliente")
    public void inserirCliente(@RequestBody Cliente cli) {
        cliRepo.save(cli);
    }

    @GetMapping("/cliente/{cod}")
    public Optional<Cliente> buscarClientePorCodigo(@PathVariable int cod) {
        return cliRepo.findById(cod);
    }

    @GetMapping ("/buscar/parteNome/{nome}")
    public List<Cliente> findByParteNome(@PathVariable String nome){
        return cliRepo.findByParteNome(nome);
    }

    @GetMapping ("/buscar/email/{email}")
    public List<Cliente> buscarPorEmail(@PathVariable String email){
        return cliRepo.findByEmail(email);
    }

    @GetMapping ("buscar/emailNome/{email}/{nome}")
    public List<Cliente> buscarPorEmailENome(@PathVariable String email, @PathVariable String nome){
        return cliRepo.findByEmailNome(email, nome);
    }
                                        /*Métodos de delete*/

    @DeleteMapping("/removerCliente")
    public void revomerCliente(@RequestBody Cliente cli) {
        cliRepo.delete(cli);
    }

    @DeleteMapping("/removerId/{codCli}")
    public void removerPorID(@PathVariable int codCli){
        cliRepo.deleteById(codCli);
    }

                                        /*Método de update*/

    @PutMapping ("/atualizar")
    public void atualizarCliente (@RequestBody Cliente cli){
        cliRepo.save(cli);
    }
}
