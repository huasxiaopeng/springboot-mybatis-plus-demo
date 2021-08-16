package com.example.mapper;

import com.example.model.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc
 */
@Mapper
public interface CountryMapper {
    List<Country>selectAll();
}
