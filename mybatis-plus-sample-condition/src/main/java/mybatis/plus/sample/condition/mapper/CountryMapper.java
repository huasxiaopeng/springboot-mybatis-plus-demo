package mybatis.plus.sample.condition.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mybatis.plus.sample.condition.domain.Country;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/16
 * @desc  很多数据的准备
 */
@Mapper
public interface CountryMapper extends BaseMapper<Country> {
}
