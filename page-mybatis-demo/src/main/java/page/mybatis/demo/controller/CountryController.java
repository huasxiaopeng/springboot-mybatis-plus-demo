package page.mybatis.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import page.mybatis.demo.entity.Country;
import page.mybatis.demo.mapper.CountryMapper;

import java.util.List;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc  测试分页插件
 *
 * http://localhost:8082/countriers?pageNum=2&size=8  输入如下路径，测试分页展示
 */
@RestController
public class CountryController {
    @Autowired
    private CountryMapper countryMapper;
    @GetMapping(value = "/countriers")
    public List<Country> getSomePerson(@RequestParam(value = "pageNum",defaultValue="1") int pageNum,@RequestParam(value ="size")int size ){
        //pageNum:表示第几页  pageSize:表示一页展示的数据
        PageHelper.startPage(pageNum,size);
        List<Country> countries = countryMapper.selectAll();
        //将查询到的数据封装到PageInfo对象
        PageInfo<Country> pageInfo=new PageInfo(countries,size);
        //分割数据成功
        return countries;
    }

}
