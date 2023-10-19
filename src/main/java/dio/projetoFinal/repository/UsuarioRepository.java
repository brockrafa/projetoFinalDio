package dio.projetoFinal.repository;

import dio.projetoFinal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    boolean existsById(Long id);

    List<Usuario> findByFundosNomeContaining (String nome);
}
