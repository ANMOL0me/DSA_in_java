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

    void insertionsort(int arr[]) {

        int key, j;

        for (int i = 1; i < arr.length; i++) {

            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            System.out.println(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]);
        }

        System.out.println("Sorting done");
    }
}

class Ch {

    Ch(Search obj, int arr[]) {

        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("1 for Bubble Sort");
        System.out.println("2 for Insertion Sort");

        choice = sc.nextInt();

        switch (choice) {

            case 1:
                obj.bubblesort(arr);
                break;

            case 2:
                obj.insertionsort(arr);
                break;

            default:
                System.out.println("Invalid choice");
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

        Ch obj1 = new Ch(obj, arr);
    }
}