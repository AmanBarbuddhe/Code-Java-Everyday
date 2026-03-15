import java.util.Arrays;

public class ArrayReferenceCopy {
    public static void main(String[] args){

        int a[] = {11,22,33};
        int b[] = new int[5];

        System.out.println(a);
        System.out.println(b);

        b = a;

        System.out.println(a);
        System.out.println(b);

        System.out.println(Arrays.toString(b));

    }

}
