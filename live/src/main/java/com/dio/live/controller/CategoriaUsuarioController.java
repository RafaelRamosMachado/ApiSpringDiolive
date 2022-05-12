package com.dio.live.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.CategoriaUsuarioService;

@RestController
@RequestMapping("/categoria")
public class CategoriaUsuarioController {

	@Autowired
	CategoriaUsuarioService categoriaUsuarioService;
	
	@PostMapping
	public CategoriaUsuario createCategoria(@RequestBody CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioService.saveCategoria(categoriaUsuario);
	}
	
	@GetMapping
	public List<CategoriaUsuario> getUsuarioList(){
		return categoriaUsuarioService.findAll();
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<CategoriaUsuario> getCategoriaById(@PathVariable("idCategoria") Long idCategoria) throws Exception{
		return ResponseEntity.ok(categoriaUsuarioService.getById(idCategoria).orElseThrow(() -> new Exception("categoria não encontrada.")));
	}
	
	@PutMapping
	public CategoriaUsuario updateCategoria(@RequestBody CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioService.updateCategoria(categoriaUsuario);
	}
	
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity deleteById(@PathVariable("idCategoria") Long idCategoria) throws Exception{
		try {
			categoriaUsuarioService.deleteCategoria(idCategoria);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();
	}
}
