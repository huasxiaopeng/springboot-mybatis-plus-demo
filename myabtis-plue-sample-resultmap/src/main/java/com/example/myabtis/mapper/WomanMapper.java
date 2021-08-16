package com.example.myabtis.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myabtis.entity.Woman;

/**
 * @author miemie
 * @since 2019-11-27
 */
public interface WomanMapper extends BaseMapper<Woman> {

    Woman selectLinkWoById(Long id);
}
