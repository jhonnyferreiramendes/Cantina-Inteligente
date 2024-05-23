package br.com.cantina.inteligente.cantinainteligente.controller;

import br.com.cantina.inteligente.cantinainteligente.dto.*;
import br.com.cantina.inteligente.cantinainteligente.model.*;
import br.com.cantina.inteligente.cantinainteligente.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adm")
public class AdministradorController {

    private final AdministradorService administradorService;
    private final CantinaService cantinaService;
    private final PaisDeAlunoService paisDeAlunoService;
    private final DepositoService depositoService;
    private final ComprarService comprarService;
    private final AlunoService alunoService;
    private final CartaoService cartaoService;
    private final LoginService loginService;
    @PostMapping("criar/adm")
    public ResponseEntity save (@RequestBody AdministradorDTO administradorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.save(administradorDTO));
    }
    @PostMapping("criar/cantina")
    public ResponseEntity save (@RequestBody CantinaDTO cantinaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cantinaService.save(cantinaDTO));
    }
    @PostMapping("criar/paisDeAluno")
    public ResponseEntity save (@RequestBody PaisDeAlunoDTO paisDeAlunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(paisDeAlunoService.save(paisDeAlunoDTO));
    }

    @PostMapping("criar/aluno")
    public ResponseEntity save (@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoDTO));
    }

    @PostMapping("criar/cartao")
    public ResponseEntity save (@RequestBody CartaoDTO cartaoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoService.save(cartaoDTO));
    }

    @GetMapping("/buscarNome/{adm}")
    public ResponseEntity <Administrador> findByNomeNomeAdm(@PathVariable("adm")String nome){
        return ResponseEntity.ok(administradorService.findByNome(nome));
    }

    @GetMapping("/buscarCodigo/{adm}")
    public ResponseEntity <Administrador> findByCodigoAdm(@PathVariable("adm")String codigo){
        return ResponseEntity.ok(administradorService.findByCodigo(codigo));
    }

    @GetMapping("/buscarNomeCantina/{nome}")
    public ResponseEntity<Optional<List<Cantina>>> findByNomeCantina(@PathVariable("nome") String nome){
        return ResponseEntity.ok(cantinaService.findByNome(nome));
    }

    @GetMapping("/buscarIdCantina/{id}")
    public ResponseEntity<Cantina> findByIdCantina(@PathVariable("id") Long id){
        return ResponseEntity.ok(cantinaService.finById(id));
    }

    @GetMapping("/buscarNomePaisDeAluno/{nome}")
    public ResponseEntity<Optional<List<PaisDeAluno>>> paisDeAlunoResponseEntity(@PathVariable("nome") String nome){
        return ResponseEntity.ok(paisDeAlunoService.findByNome(nome));
    }

    @GetMapping("/buscarIdPaisDeAluno/{id}")
    public ResponseEntity<PaisDeAluno> findByIdPaisDeAluno(@PathVariable("id") Long id){
        return ResponseEntity.ok(paisDeAlunoService.findById(id));
    }

    @GetMapping("/buscarNomeAluno/{nome}")
    public ResponseEntity<Optional<List<Aluno>>> findByNomeAluno(@PathVariable("nome") String nome){
        return ResponseEntity.ok(alunoService.findByNome(nome));
    }

    @GetMapping("/buscarDeposito/{id}")
    public ResponseEntity <Deposito> findByIdDeposito(@PathVariable("id")Long id){
        return ResponseEntity.ok(depositoService.finById(id));
    }

    @GetMapping("/buscarCompra/{compra}")
    public ResponseEntity <Comprar> findByIdVendassProduto(@PathVariable("compra") Long id){
        return ResponseEntity.ok(comprarService.findById(id));
    }
    @GetMapping("/buscarCartao/{cartao}")
    public ResponseEntity <Cartao> findByIdCartao(@PathVariable("cartao") Long id){
        return ResponseEntity.ok(cartaoService.findById(id));
    }

    @GetMapping("/buscarListaCartao")
    public ResponseEntity getAllCartao() {
        return ResponseEntity.ok().body(cartaoService.findAll());
    }

    @GetMapping("/buscarListaLogin")
    public ResponseEntity getAllLogin() {
        return ResponseEntity.ok().body(loginService.findAll());
    }

    @GetMapping("/buscarComprasCantinaID/{cantinaId}")
    public ResponseEntity<List<Comprar>> getAllComprasCantina(@PathVariable("cantinaId") Long cantinaId) {
        return ResponseEntity.ok().body(comprarService.findComprasByCantinaId(cantinaId));
    }

    @PutMapping("/editar{adm}")
    public ResponseEntity update(@RequestBody Administrador administrador) {
        Administrador administradorUPD = administradorService.update(administrador);
        return ResponseEntity.ok().body(administrador);
    }

    @PutMapping("/editarCantina{cantina}")
    public ResponseEntity update(@RequestBody Cantina cantina) {
        Cantina cantinaUPD = cantinaService.update(cantina);
        return ResponseEntity.ok().body(cantina);
    }

    @PutMapping("/editarPaisDeAluno/{paisDeAluno}")
    public ResponseEntity update(@RequestBody PaisDeAluno paisDeAluno) {
        PaisDeAluno paisDeAlunoUPD = paisDeAlunoService.update(paisDeAluno);
        return ResponseEntity.ok().body(paisDeAluno);
    }

    @PutMapping("/editar{aluno}")
    public ResponseEntity update(@RequestBody Aluno aluno) {
        Aluno alunoUPD = alunoService.update(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping("/editarLoginPaisDeAluno{login}")
    public ResponseEntity update(@RequestBody Login login) {
        Login loginUPD = loginService.update(login);
        return ResponseEntity.ok().body(login);
    }
    @DeleteMapping("removerAdm{id}")
    public ResponseEntity < Administrador> removerAdmPeloCodigo (@PathVariable Long id) {
        administradorService.remover(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("removerCantina{id}")
    public ResponseEntity < Cantina> removerCantinaPeloId (@PathVariable Long id) {
        cantinaService.remover(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("removerPaisDeAluno{id}")
    public ResponseEntity <PaisDeAluno> removerPaisDeAlunoId (@PathVariable Long id) {
        paisDeAlunoService.remover(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("removerAluno{id}")
    public ResponseEntity <Aluno> removerAlunoId(@PathVariable Long id) {
        alunoService.remover(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("removerCartao/{id}") // Corrigido para "removerCartao/{id}"
    public ResponseEntity<Cartao> removerCartaoPeloId(@PathVariable Long id) {
        cartaoService.remover(id);
        return ResponseEntity.ok().build();
    }

}
