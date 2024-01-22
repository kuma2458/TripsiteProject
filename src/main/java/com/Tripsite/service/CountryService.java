package com.Tripsite.service;

import org.springframework.stereotype.Service;

import com.Tripsite.dto.CountryDTO;

import com.Tripsite.mapper.CountryMapper;

@Service
public class CountryService {
	
	CountryMapper mapper;

	public CountryService(CountryMapper mapper) {
		this.mapper = mapper;
		
	}

	public CountryDTO selectCountry(String nCode) {
		return mapper.selectCountry(nCode);
	}

}
