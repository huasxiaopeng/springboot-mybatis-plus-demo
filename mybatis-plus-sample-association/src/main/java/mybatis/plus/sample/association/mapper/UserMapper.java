package mybatis.plus.sample.association.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mybatis.plus.sample.association.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc
 */
@Mapper
public interface UserMapper  extends BaseMapper<User> {
}
