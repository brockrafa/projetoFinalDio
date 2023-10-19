package dio.projetoFinal.service.impl;

import dio.projetoFinal.model.FundosImobiliarios;
import dio.projetoFinal.model.Usuario;
import dio.projetoFinal.repository.UsuarioRepository;
import dio.projetoFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario findById(Long id){
        return this.usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> buscarTodosPorFiis(String nome_fiis) {

        return usuarioRepository.findByFundosNomeContaining (nome_fiis);
    }

    @Override
    public Usuario adicionarFundo(Long userId, FundosImobiliarios fundo) {
        Usuario user = usuarioRepository.findById(userId).orElseThrow(RuntimeException::new);
        user.getFundos().add(fundo);
        return usuarioRepository.save(user);
    }


}
