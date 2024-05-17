package br.com.cantina.inteligente.cantinainteligente.repositories;

import br.com.cantina.inteligente.cantinainteligente.model.PaisDeAluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaisDeAlunoRepository  extends JpaRepository<PaisDeAluno, Long> {

    Optional <PaisDeAluno> findById(Long id);

    Optional <List<PaisDeAluno>> findByNome(String nome);
}
