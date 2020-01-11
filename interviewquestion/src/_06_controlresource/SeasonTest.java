package _06_controlresource;

public class SeasonTest {
    public static void main(String[] args) {
        SeasonEnum[] enums = SeasonEnum.values();
        for (SeasonEnum season : enums) {
            System.out.print(season);
            System.out.println("\t开始月份\t" + season.getBeginMonth() + "\t结束月份\t" + season.getEndMonth());
        }
    }
}
