package practicePackage;

import java.util.Scanner;

public class Vinay {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter size of array A");
        int sizeOfA = sc.nextInt();
        System.out.println("enter size of array B");
        int sizeOfB = sc.nextInt();



        int[] a = new int[sizeOfA];
        int[] b = new int[sizeOfB];

        System.out.println("Enter elements in array A");
        for (int i = 0; i < sizeOfA; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter elements in array B");
        for (int i = 0; i < sizeOfB; i++) {
            b[i] = sc.nextInt();
        }


        int maxLength = 0;
        int minLength = 0;
        if(sizeOfA >= sizeOfB){
            maxLength = sizeOfA;
            minLength = sizeOfB;
        }else{
            maxLength = sizeOfB;
            minLength = sizeOfA;
        }
        int[] ans = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            if(i >= minLength){
                if(sizeOfA >= sizeOfB){
                    ans[i] = a[i];
                }else{
                    System.out.println("i value: "+i);
                    ans[i] = b[i];
                }
            }else{
                if(sizeOfA >= sizeOfB){
                    ans[i] = a[i] - b[i];
                }else{
                    ans[i] = b[i] - a[i];
                }
            }
        }

        for (int i = 0; i < maxLength; i++) {
            if(i == 0){
                System.out.print("[ "+ans[i]+", ");
            }else if(i == maxLength-1){
                System.out.print(ans[i]+" ]");
            }else{
                System.out.print(ans[i] + ", ");
            }
        }
    }
}
