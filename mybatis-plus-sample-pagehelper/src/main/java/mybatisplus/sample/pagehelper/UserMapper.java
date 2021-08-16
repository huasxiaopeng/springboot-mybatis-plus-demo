package mybatisplus.sample.pagehelper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/16
 * @desc
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
