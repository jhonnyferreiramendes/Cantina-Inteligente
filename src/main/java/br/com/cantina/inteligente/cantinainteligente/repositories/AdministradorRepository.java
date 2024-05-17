package br.com.cantina.inteligente.cantinainteligente.repositories;

import br.com.cantina.inteligente.cantinainteligente.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    @Override
    Optional<Administrador> findById(Long id);

    Optional<Administrador> findByNome(String nome);

    Optional<Administrador> findByCodigo(String codigo);
}
