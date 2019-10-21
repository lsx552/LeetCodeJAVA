package test;

public class ctest {
    String nums;
    public static void main(String[] args) {
        ctest a = new ctest();
        addNum(a);
        System.out.println(a.nums);
        String b = new String();
        addNum2(b);
        System.out.println(b);
    }
    public static void addNum(ctest a){
        a.nums = "1234";
    }
    public static void addNum2(String b){
        b = "222";
    }
}
