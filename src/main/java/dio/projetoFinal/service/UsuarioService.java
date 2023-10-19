package dio.projetoFinal.service;

import dio.projetoFinal.model.FundosImobiliarios;
import dio.projetoFinal.model.Usuario;

import java.util.List;

public interface UsuarioService {
    public Usuario findById(Long id);
    public Usuario cadastrarUsuario(Usuario usuario);
    public List<Usuario> buscarTodos();
    public List<Usuario> buscarTodosPorFiis(String nome_fiis);
    public Usuario adicionarFundo(Long userId, FundosImobiliarios fundo);

}
