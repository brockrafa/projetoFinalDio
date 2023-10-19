package dio.projetoFinal.controller;

import dio.projetoFinal.model.FundosImobiliarios;
import dio.projetoFinal.model.Usuario;
import dio.projetoFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> buscarTodos(){
        var us = usuarioService.buscarTodos();
        return ResponseEntity.ok(us);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        var us = usuarioService.findById(id);
        return ResponseEntity.ok(us);
    }
    @GetMapping("/todos/fiis/{nome_fiis}")
    public ResponseEntity<List<Usuario>> buscarTodosPorFiis(@PathVariable String nome_fiis){
        var us = usuarioService.buscarTodosPorFiis(nome_fiis);
        return ResponseEntity.ok(us);
    }
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario user){
        usuarioService.cadastrarUsuario(user);
        return user;
    }
    @PostMapping("/adicionarFundo/{usuarioId}")
    public Usuario cadastrar(@PathVariable Long usuarioId,@RequestBody FundosImobiliarios fundo){
        Usuario user = usuarioService.adicionarFundo(usuarioId,fundo);
        return user;
    }
}
