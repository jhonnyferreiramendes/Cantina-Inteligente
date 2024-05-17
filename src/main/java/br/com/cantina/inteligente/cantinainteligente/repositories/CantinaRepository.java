package br.com.cantina.inteligente.cantinainteligente.repositories;

import br.com.cantina.inteligente.cantinainteligente.model.Administrador;
import br.com.cantina.inteligente.cantinainteligente.model.Cantina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CantinaRepository extends JpaRepository<Cantina, Long> {

    Optional<Cantina> findById(Long id);

    Optional <List<Cantina>> findByNome(String nome);

}
