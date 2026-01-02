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
        .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
        .cpf(usuario.getCpf() != null ? usuario.getCpf() : usuarioEntity.getCpf())
        .contato(usuario.getContato() != null ? usuario.getContato() : usuarioEntity.getContato())
        .ultima_atualizacao(usuario.getUltima_atualizacao() != null ? usuario.getUltima_atualizacao() : usuarioEntity.getUltima_atualizacao())
        .build();

        return usuarioRepository.save(usuarioUpdated);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
