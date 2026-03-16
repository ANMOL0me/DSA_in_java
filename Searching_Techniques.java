import java.util.*;

class Search {

    void bubblesort(int arr[]) {

        int temp;

        for (int pass = 0; pass < arr.length - 1; pass++) {

            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i] > arr[i + 1]) {

                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                }

                System.out.println(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]);

            }

            System.out.println("loop");
        }

        System.out.println("Sorting done");
        System.out.println(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]);
    }
    void insertionsort(int arr[]){
        int temp;
       for (int i = 0; i < arr.length; i++) {
           for (int j = 1; j < arr.length; j++) {
               if(arr[i]>arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp ; 
                System.out.println(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]);
               }
               else{}
           }
       }
         

    }

}
public class Searching_Techniques {

    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]);

        Search obj = new Search();
       int choice;
       
       System.out.println("1 for bubble\n2 for insertion");
       choice = sc.nextInt();

       switch (choice){
       case 1:
       obj.bubblesort(arr);
       break;
       case 2:
        obj.insertionsort(arr);
        break;
       
    }


        }
}