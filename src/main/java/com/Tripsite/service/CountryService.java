package com.Tripsite.service;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import com.Tripsite.dto.CountryDTO;
>>>>>>> 61c0b93b5c1612d6eff2d70e5e2d7bd4ebfaa23f
import com.Tripsite.mapper.CountryMapper;

@Service
public class CountryService {
	
	CountryMapper mapper;

	public CountryService(CountryMapper mapper) {
		this.mapper = mapper;
		
	}

<<<<<<< HEAD
=======
	public CountryDTO selectCountry(String nCode) {
		return mapper.selectCountry(nCode);
	}

>>>>>>> 61c0b93b5c1612d6eff2d70e5e2d7bd4ebfaa23f
}
