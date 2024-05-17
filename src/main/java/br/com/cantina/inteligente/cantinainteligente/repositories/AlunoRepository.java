package br.com.cantina.inteligente.cantinainteligente.repositories;

import br.com.cantina.inteligente.cantinainteligente.model.Aluno;
import br.com.cantina.inteligente.cantinainteligente.model.PaisDeAluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findById(Long id);

    Optional <List<Aluno>> findByNome(String nome);
}
