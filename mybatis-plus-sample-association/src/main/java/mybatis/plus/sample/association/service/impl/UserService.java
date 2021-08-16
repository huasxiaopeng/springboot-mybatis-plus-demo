package mybatis.plus.sample.association.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mybatis.plus.sample.association.entity.User;
import mybatis.plus.sample.association.mapper.UserMapper;
import mybatis.plus.sample.association.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
