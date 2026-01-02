package com.igor_dev.GreenTrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_dev.GreenTrace.model.Usuario;
import com.igor_dev.GreenTrace.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> findAllUser(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findUserById(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario updateUser (Long id, Usuario usuario){
        Usuario usuarioEntity = findUserById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        Usuario usuarioUpdated = Usuario.builder()
        .id(id)
        .name(usuario.getName() != null ? usuario.getName() : usuarioEntity.getName())
        .document(usuario.getDocument() != null ? usuario.getDocument() : usuarioEntity.getDocument())
        .contact(usuario.getContact() != null ? usuario.getContact() : usuarioEntity.getDocument())
        .lastUpdate(usuario.getLastUpdate() != null ? usuario.getLastUpdate() : usuarioEntity.getLastUpdate())
        .build();

        return usuarioRepository.save(usuarioUpdated);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
