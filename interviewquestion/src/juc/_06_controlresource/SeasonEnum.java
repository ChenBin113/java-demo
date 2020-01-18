package juc._06_controlresource;

public enum SeasonEnum {
    SPRING(3, 5), SUMMER(6, 8), AUTUMN(9, 11), WINTER(12, 2);

    private Integer beginMonth;
    private Integer endMonth;

    SeasonEnum(Integer beginMonth, Integer endMonth) {
        this.beginMonth = beginMonth;
        this.endMonth = endMonth;
    }

    public Integer getBeginMonth() {
        return beginMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

}
