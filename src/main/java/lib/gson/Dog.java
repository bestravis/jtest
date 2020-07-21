package lib.gson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author yml
 * @Date 2020/4/17
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {

    private String name;

    private String type;

    private String memo;

    private Date birthday;

    private byte age;
}
