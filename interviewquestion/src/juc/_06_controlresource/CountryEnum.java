package juc._06_controlresource;

/**
 * 枚举类的 demo
 * 枚举类相当于一个数据库，数据库连接池有满了、中断的问题，枚举类可以避免
 * 一些敏感的数据，小的可以放枚举类
 *
 * MySQL dbName = CountryEnum
 *
 * table
 * ONE
 * ID userName age
 * 1  齐
 *
 * TWO
 * ID userName age
 * 2  楚
 */
public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");

    private Integer retCode;
    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static String forEach(int index) {
        CountryEnum[] enums = CountryEnum.values();
        for (CountryEnum country : enums) {
            if (index == country.retCode) {
                return country.retMessage;
            }
        }
        return null;
    }

}
