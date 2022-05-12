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

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;

@RestController
@RequestMapping("/horas")
public class BancoHorasController {

	@Autowired
	BancoHorasService bancoHorasService;
	
	@PostMapping
	public BancoHoras createHoras(@RequestBody BancoHoras bancoHoras) {
		return bancoHorasService.saveHoras(bancoHoras);
	}
	
	@GetMapping
	public List<BancoHoras> getHorasList(){
		return bancoHorasService.findAll();
	}
	
	@GetMapping("/{idHoras}")
	public ResponseEntity<BancoHoras> getHorasById(@PathVariable("idHoras") Long idHoras) throws Exception{
		return ResponseEntity.ok(bancoHorasService.getById(idHoras).orElseThrow(() -> new Exception("Horas não encontrada.")));
	}
	
	@PutMapping
	public BancoHoras updateHoras(@RequestBody BancoHoras bancoHoras) {
		return bancoHorasService.updateHoras(bancoHoras);		
	}
	
	@DeleteMapping("/{idHoras}")
	public ResponseEntity deleteById(@PathVariable("idHoras") Long idHoras) throws Exception {
		try {
			bancoHorasService.deleteHoras(idHoras);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (ResponseEntity<BancoHoras>) ResponseEntity.ok();
	}
}
