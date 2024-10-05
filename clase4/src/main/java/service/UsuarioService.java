package service;


import exception.UsuarioNoEncontradoException;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utils.Utilidades;
import utils.log.Log;

import java.util.ArrayList;
import java.util.List;


@Service//En esta clase va la logica de negocios
public class UsuarioService {
    private final List<Usuario> usuariosList = new ArrayList<>();
    private final Utilidades utilidades;
    private final Log log;

    @Autowired

    public UsuarioService(Utilidades utilidades, @Qualifier("consoleLog") Log logService) {
        this.utilidades = utilidades;
        this.log = logService;
        usuariosList.add(new Usuario(1L, "Leonardo Perez", "leonardo@example.com", 20));
        usuariosList.add(new Usuario(2L, "Constanza Garcia", "constanza@example.com", 18));
        usuariosList.add(new Usuario(3L, "Carmen Gardel", "carmen@example.com", 35));
        usuariosList.add(new Usuario(4L, "Roberto Aguirre", "roberto@example.com", 67));
        usuariosList.add(new Usuario(5L, "Carlos Suarez", "carlos@example.com", 23));
        usuariosList.add(new Usuario(6L, "Patricia Barreto", "maria@example.com", 27));
        usuariosList.add(new Usuario(7L, "Juan Pablo Villa", "jpv@example.com", 44));
    }
    //obtener usuarios
    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }
    //crear un nuevo Usuario
    public Usuario crearUsuario(Usuario usuario){
        usuario.setId((long)(usuariosList.size()+1));
        String nombre = utilidades.formatearTexto(usuario.getNombre());
        usuario.setNombre(nombre);
        usuariosList.add(usuario);
        return usuario;
    }
    // Método para actualizar un usuario existente. Si el usuario no existe, se lanzará una excepción UsuarioNoEncontradoException.
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) throws UsuarioNoEncontradoException {
        return usuariosList.stream().filter(usuario -> usuario.getId() == id).peek(usuario -> {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setEdad(usuarioActualizado.getEdad());
        }).findFirst().orElseThrow(() -> new UsuarioNoEncontradoException(id));
    }
    // Método para eliminar un usuario por ID. Devuelve true si el usuario fue eliminado, false en caso contrario.
    public boolean eliminarUsuario(Long id) {
        return usuariosList.removeIf(usuario -> usuario.getId() == id);
    }



}


