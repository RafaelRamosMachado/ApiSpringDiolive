package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.CategoriaUsuarioRepository;

@Service
public class CategoriaUsuarioService {

	CategoriaUsuarioRepository categoriaUsuarioRepository;

	@Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository) {
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }
	
	public CategoriaUsuario saveCategoria(CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioRepository.save(categoriaUsuario);
	}

	public List<CategoriaUsuario> findAll() {
		return categoriaUsuarioRepository.findAll();
	}
	
	public Optional<CategoriaUsuario> getById(Long idCategoria) {
		return categoriaUsuarioRepository.findById(idCategoria);
	}

	public CategoriaUsuario updateCategoria(CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioRepository.save(categoriaUsuario);
	}

	public void deleteCategoria(Long idCategoria) {
		categoriaUsuarioRepository.deleteById(idCategoria);
	}
}
