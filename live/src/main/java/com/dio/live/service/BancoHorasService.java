package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;

@Service
public class BancoHorasService {

	@Autowired
	BancoHorasRepository bancoHorasRepository;

	public BancoHoras saveHoras(BancoHoras bancoHoras) {
		return bancoHorasRepository.save(bancoHoras);
	}

	public List<BancoHoras> findAll() {
		return bancoHorasRepository.findAll();
	}

	public Optional<BancoHoras> getById(Long idHoras) {
		return bancoHorasRepository.findById(idHoras);
	}

	public BancoHoras updateHoras(BancoHoras bancoHoras) {
		return bancoHorasRepository.save(bancoHoras);
	}

	public void deleteHoras(Long idHoras) {
		bancoHorasRepository.deleteById(idHoras);		
	}
}
