package javaee;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcTest01 {
    //继承自封装器 Wrapper
    private Statement statement;
    //继承自 Statement
    private PreparedStatement preparedStatement;
    //继承自 PreparedStatement
    private CallableStatement callableStatement;

    public static void main(String[] args) {

    }
}
