import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] valores= new int[]{4, 12, 51, 9, 10, 20, 4, 11, 99, 12};
         
        //4, 12, 11, 9, 10, 20, 4, 51, 99, 12
        //4, 12, 11, 9, 10, 4, 20, 51, 99, 12
       
    
        
    
        /*
        for(int i = 0; i < valores.length; i++){
            valores[i] = rand.nextInt(100);
        }
        */
    
    
        printArray(valores);
    
        mergeSort(valores);//or lenght -1
    
        printArray(valores);
    
    }

    public static void mergeSort(int[] array){
        int arraySize = array.length;
        if(array.length < 2){
            return;
        }

        int midIndex = arraySize/2;

        int[] arrayLeftPart = new int[midIndex]; //5
        int[] arrayRightPart = new int[arraySize - midIndex];

        for(int i = 0; i < arrayLeftPart.length; i++){
            arrayLeftPart[i] = array[i];
        }

       for(int i = midIndex; i < array.length; i++){
           arrayRightPart[i - midIndex] = array[i];
       }

       
       mergeSort(arrayLeftPart);
       mergeSort(arrayRightPart);
      


       //merge

       merge(array, arrayLeftPart, arrayRightPart);


    }

    public static void merge(int[] array, int[] leftPart, int[] rightPart){
        int sizeLeft = leftPart.length;
        int sizeRight = rightPart.length;

        int i = 0, j = 0 , k = 0;

        while(i < sizeLeft && j < sizeRight){
            if(leftPart[i] <= rightPart[j]){
                array[k] = leftPart[i];
                i++;

            }else{
                array[k] = rightPart[j];
                j++;
            }

           k++;
        }

        if(i < sizeLeft){
            array[k] = leftPart[i];
            i++;
            k++;
        }


        if(j < sizeRight){
            array[k] = rightPart[j];
            j++;
            k++;
        }
        
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
