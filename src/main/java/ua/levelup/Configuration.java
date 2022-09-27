package ua.levelup;
public class Configuration {
    private static long id;
    private static String title;
    private static final int par1=3;
    private static final int par2=4;
    public static void main(String[] args){
        int a=5;
        int b=7;
        int c=a+b;
        System.out.println(c);
        System.out.println(multiply(par1, par2));
        System.out.println("HELLO WORLD!");
    }
    public static int multiply(int par1, int par2){
        return par1*par2;
    }

}