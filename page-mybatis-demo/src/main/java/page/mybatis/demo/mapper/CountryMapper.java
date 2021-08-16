package page.mybatis.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import page.mybatis.demo.entity.Country;

import java.util.List;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc
 */
@Mapper
public interface CountryMapper {

    /**
     * 分页之查询全部数据
     * @return
     */
   List<Country> selectAll();
}
