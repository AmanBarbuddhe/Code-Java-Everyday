public class Autoboxing_Unboxing {
    
    public static void main(String args[]){

        int i = 10 ;
        Integer ob = i ; //Autoboxing

        ob++;

        int j = ob; //unboxing

        System.out.println(j);

    }

}
