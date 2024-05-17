package br.com.cantina.inteligente.cantinainteligente.controller;


import br.com.cantina.inteligente.cantinainteligente.dto.*;
import br.com.cantina.inteligente.cantinainteligente.model.*;
import br.com.cantina.inteligente.cantinainteligente.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paisDeAluno")

public class PaisDeAlunoController {

    private final ComprarService comprarService;
    private final DepositoService depositoService;
    private final PaisDeAlunoService paisDeAlunoService;
    private final LoginService loginService;


    @PostMapping("comprar")
    public ResponseEntity save (@RequestBody ComprarDTO comprarDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(comprarService.save(comprarDTO));
    }

    @PostMapping("depositar")
    public ResponseEntity save (@RequestBody DepositoDTO depositoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(depositoService.save(depositoDTO));
    }

    @PostMapping("/paisdealunos/{paisDeAlunoId}/produtospermitidos/{produtoId}")
    public ResponseEntity adicionarProduto(@PathVariable Long paisDeAlunoId, @PathVariable Long produtoId) {
        paisDeAlunoService.adicionarProduto(paisDeAlunoId, produtoId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/buscarCompra/{compra}")
    public ResponseEntity <Comprar> findByIdVendassProduto(@PathVariable("compra") Long id){
        return ResponseEntity.ok(comprarService.findById(id));
    }
    @GetMapping("/buscarLoginPaisDeAluno/{login}")
    public ResponseEntity <Login> findByIdLogin(@PathVariable("login") Long id){
        return ResponseEntity.ok(loginService.findById(id));
    }

    @DeleteMapping("/{paisDeAlunoId}/produtospermitidos/{produtoId}")
    public ResponseEntity<String> removerProduto(@PathVariable Long paisDeAlunoId, @PathVariable Long produtoId) {
        paisDeAlunoService.removerProduto(paisDeAlunoId, produtoId);
        return ResponseEntity.ok("Produto removido com sucesso da lista de produtos permitidos.");
    }

    @PutMapping("/editar{paisDeAluno}")
    public ResponseEntity update(@RequestBody PaisDeAluno paisDeAluno) {
        PaisDeAluno paisDeAlunoUPD = paisDeAlunoService.update(paisDeAluno);
        return ResponseEntity.ok().body(paisDeAluno);
    }
    @DeleteMapping("removerPaisDeAluno{id}")
    public ResponseEntity < PaisDeAluno> removerPaisDeAlunosPeloId (@PathVariable Long id) {
        paisDeAlunoService.remover(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editarLoginPaisDeAluno{login}")
    public ResponseEntity update(@RequestBody Login login) {
        Login loginUPD = loginService.update(login);
        return ResponseEntity.ok().body(login);
    }

}
