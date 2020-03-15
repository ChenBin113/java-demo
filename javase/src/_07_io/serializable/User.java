package _07_io.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * 实现 Serializable 接口
 */
@Data
public class User implements Serializable {
    private String name;
    private int age;
}
