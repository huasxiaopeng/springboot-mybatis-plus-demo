package mybatis.plus.sample.condition;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import mybatis.plus.sample.condition.domain.Country;
import mybatis.plus.sample.condition.mapper.CountryMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusSampleConditionApplicationTests {
    @Autowired
    private CountryMapper mapper;

    /**
     * 条件查询构造语句
     */
    @Test
    public void dSelect() {
        //查询指定条件
        Country country = mapper.selectOne(new QueryWrapper<Country>().lambda().eq(Country::getId, 100));
        System.out.println(country);

        //使用lambda构造查询
        QueryWrapper<Country> queryWrapper=new QueryWrapper();
        queryWrapper.lambda().isNotNull(Country::getId)
                .ge(Country::getCode,10);
        mapper.selectList(queryWrapper).forEach(System.out::println);

    }

    /**
     * 动态条件查询
     *
     */
    @Test
    public void dConditionalSelect() {
       Country country=new Country();
//       country.setId(10);
//       country.setCode("36");
       country.setCountry("法国");
        QueryWrapper<Country> queryWrapper=new QueryWrapper();
        queryWrapper.lambda().ge((null!=country.getId()),Country::getId,country.getId())
                .ge((StringUtils.isNotEmpty(country.getCode())),Country::getCode,country.getCode())
               // .ge((StringUtils.isNotEmpty(country.getCountry())),Country::getCountry,country.getCountry())
                        .eq((StringUtils.isNotEmpty(country.getCountry())),Country::getCountry,country.getCountry());
                mapper.selectList(queryWrapper).forEach(System.out::println);

    }

}
