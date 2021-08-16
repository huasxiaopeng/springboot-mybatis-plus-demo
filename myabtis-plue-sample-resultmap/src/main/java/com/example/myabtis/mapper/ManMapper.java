package com.example.myabtis.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myabtis.entity.Man;

/**
 * @author miemie
 * @since 2019-11-27
 */
public interface ManMapper extends BaseMapper<Man> {

    Man selectLinkManById(Long id);
}
