package br.com.cantina.inteligente.cantinainteligente.repositories;

import br.com.cantina.inteligente.cantinainteligente.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findById(Long id);

    List<Login> findAll();
}
