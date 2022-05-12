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

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
	
	@Autowired
	JornadaService jornadaService;

	@PostMapping
	public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaService.saveJornada(jornadaTrabalho);
	}
	
	@GetMapping
	public List<JornadaTrabalho> getJornadaList(){
		return jornadaService.findAll();
	}
	
	@GetMapping("/{idJornada}")
	public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception{
		return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new Exception("jornada não encontrada.")));
	}
	
	@PutMapping
	public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaService.updateJornada(jornadaTrabalho);
	}
	
	@DeleteMapping("/{idJornada}")
	public ResponseEntity deleteById(@PathVariable("idJornada") Long idJornada) throws Exception{
		try {
			jornadaService.deleteJornada(idJornada);			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
	}
	
}
