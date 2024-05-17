package br.com.cantina.inteligente.cantinainteligente.repositories;

import br.com.cantina.inteligente.cantinainteligente.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findById (Long id);
    Optional <List<Produto>> findByNome (String nome);


}
