package mybatis.plus.sample.association.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("company")
public class Company {
	private Long id;
    private String name;
}
