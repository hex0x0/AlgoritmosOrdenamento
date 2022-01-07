import java.util.Random;

public class QuickSort{
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

    quicksort(valores, 0, valores.length -1);//or lenght -1

    printArray(valores);

    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void quicksort(int[] array, int lowIndex, int highIndex){


        if(lowIndex >= highIndex){
            return;
        }

        int pivot = array[highIndex];

        //O pivo sera o ultimo numero no intervalo do array

        int ponteiroEsquerda= lowIndex;
        int ponteiroDireita = highIndex;

        // 0 -----------------9
        //3 7 8 5 2 1 9 5 4 10
        //pivot  

        while(ponteiroEsquerda < ponteiroDireita){
           
            while(array[ponteiroEsquerda] <= pivot && ponteiroEsquerda < ponteiroDireita){
                ponteiroEsquerda++;
            }

            while(array[ponteiroDireita] >= pivot && ponteiroEsquerda < ponteiroDireita){
                ponteiroDireita--;
            }

            System.out.println("Esquerda: " + ponteiroEsquerda + " Direita: " + ponteiroDireita);

            swap(array, ponteiroEsquerda, ponteiroDireita);
        }

        swap(array, ponteiroEsquerda, highIndex);
        quicksort(array, lowIndex, ponteiroEsquerda - 1);
        quicksort(array, ponteiroEsquerda + 1, highIndex);

    }

    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}