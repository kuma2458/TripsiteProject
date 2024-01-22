package com.Tripsite.mapper;

import org.apache.ibatis.annotations.Mapper;

<<<<<<< HEAD
@Mapper
public interface CountryMapper {

=======
import com.Tripsite.dto.CountryDTO;

@Mapper
public interface CountryMapper {

	CountryDTO selectCountry(String nCode);

>>>>>>> 61c0b93b5c1612d6eff2d70e5e2d7bd4ebfaa23f
}
