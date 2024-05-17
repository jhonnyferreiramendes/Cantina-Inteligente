package br.com.cantina.inteligente.cantinainteligente.controller;


import br.com.cantina.inteligente.cantinainteligente.dto.ComprarDTO;
import br.com.cantina.inteligente.cantinainteligente.dto.ProdutoDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Cantina;
import br.com.cantina.inteligente.cantinainteligente.model.Comprar;
import br.com.cantina.inteligente.cantinainteligente.model.Login;
import br.com.cantina.inteligente.cantinainteligente.model.Produto;
import br.com.cantina.inteligente.cantinainteligente.services.CantinaService;
import br.com.cantina.inteligente.cantinainteligente.services.ComprarService;
import br.com.cantina.inteligente.cantinainteligente.services.LoginService;
import br.com.cantina.inteligente.cantinainteligente.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cantina")
public class CantinaController {

    private final ProdutoService produtoService;
    private final ComprarService comprarService;
    private final LoginService loginService;
    private final CantinaService cantinaService;

    @PostMapping("criar/produto")
    public ResponseEntity save (@RequestBody ProdutoDTO produtoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoDTO));
    }

    @PostMapping("criar/VendasProduto/")
    public ResponseEntity save (@RequestBody ComprarDTO comprarDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(comprarService.save(comprarDTO));
    }

    @GetMapping("/buscarIdProduto/{id}")
    public ResponseEntity <Produto> findByIdProduto(@PathVariable("id") Long id){
        return ResponseEntity.ok(produtoService.findById(id));
    }
    @GetMapping("/buscarNomeProduto/{nome}")
    public ResponseEntity<Optional<List<Produto>>> findByNomeProduto(@PathVariable("nome") String nome){
        return ResponseEntity.ok(produtoService.findByNome(nome));
    }

    @GetMapping("/buscarIdVendasProduto/{id}")
    public ResponseEntity <Comprar> findByIdVendassProduto(@PathVariable("id") Long id){
        return ResponseEntity.ok(comprarService.findById(id));
    }
    @GetMapping("/buscarListaCompras")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(comprarService.findAll());
    }
    @GetMapping("/buscarLoginCantina/{login}")
    public ResponseEntity <Login> findByIdLogin(@PathVariable("login") Long id){
        return ResponseEntity.ok(loginService.findById(id));
    }
    @PutMapping("/editarProduto{produto}")
    public ResponseEntity updateProduto(@RequestBody Produto produto) {
        Produto produtoUPD = produtoService.update(produto);
        return ResponseEntity.ok().body(produtoUPD);
    }

    @PutMapping("/editarLoginCantina{login}")
    public ResponseEntity update(@RequestBody Login login) {
        Login loginUPD = loginService.update(login);
        return ResponseEntity.ok().body(login);
    }

    @PutMapping("/editarCantina{cantina}")
    public ResponseEntity update(@RequestBody Cantina cantina) {
        Cantina cantinaUPD = cantinaService.update(cantina);
        return ResponseEntity.ok().body(cantina);
    }
    @DeleteMapping("removerProduto{id}")
    public ResponseEntity <Produto> removerProdutoPeloCodigo (@PathVariable Long id) {
        produtoService.remover(id);
        return ResponseEntity.ok().build();
    }

}
