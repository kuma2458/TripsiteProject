package com.Tripsite.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.CountryDTO;

@Mapper
public interface CountryMapper {

	CountryDTO selectCountry(String nCode);

}
