package br.com.cantina.inteligente.cantinainteligente.controller;


import br.com.cantina.inteligente.cantinainteligente.dto.AlunoDTO;
import br.com.cantina.inteligente.cantinainteligente.dto.CartaoDTO;
import br.com.cantina.inteligente.cantinainteligente.dto.ComprarDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Aluno;
import br.com.cantina.inteligente.cantinainteligente.model.Comprar;
import br.com.cantina.inteligente.cantinainteligente.model.Login;
import br.com.cantina.inteligente.cantinainteligente.services.AlunoService;
import br.com.cantina.inteligente.cantinainteligente.services.ComprarService;
import br.com.cantina.inteligente.cantinainteligente.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")

public class AlunoController {

    private final ComprarService comprarService;
    private final LoginService loginService;
    private final AlunoService alunoService;

    @PostMapping("comprar")
    public ResponseEntity save (@RequestBody ComprarDTO comprarDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(comprarService.save(comprarDTO));
    }
    @GetMapping("/buscarCompra/{compra}")
    public ResponseEntity <Comprar> findByIdVendassProduto(@PathVariable("compra") Long id){
        return ResponseEntity.ok(comprarService.findById(id));
    }
    @GetMapping("/buscarLoginAluno/{login}")
    public ResponseEntity <Login> findByIdLogin(@PathVariable("login") Long id){
        return ResponseEntity.ok(loginService.findById(id));
    }

    @PutMapping("/editarAluno{aluno}")
    public ResponseEntity update(@RequestBody Aluno aluno) {
        Aluno alunoUPD = alunoService.update(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping("/editarLoginPaisDeAluno{login}")
    public ResponseEntity update(@RequestBody Login login) {
        Login loginUPD = loginService.update(login);
        return ResponseEntity.ok().body(login);
    }

}
