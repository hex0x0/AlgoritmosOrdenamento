public class TrySort {
    public static void main(String[] args) {
        

        int[] values = new int[]{3, 15, 13, 7, 8, 1, 2, 9};


        

        trySort(values, 0, values.length-1);
        printValues(values);


    }

    public static void printValues(int[] values){
        for(int i = 0; i < values.length; i++){
            System.out.println("Valor " + values[i] + " na posicao:" + i);
        }
    }

    public static void trySort(int[] values, int lowIndex, int highIndex){
        
        int q;
        if(lowIndex < highIndex){
            q = particao(values, lowIndex, highIndex);

            trySort(values, lowIndex, q - 1);
            trySort(values, q+1, highIndex);
        }

    }

    public static void swap(int[] values, int esq, int dir){
        int aux = values[esq];
        values[esq] = values[dir];
        values[dir] = aux;
    }

    public static int particao(int[] values, int inicio, int fim){
        int pivot = values[inicio];


        int i = inicio + 1;
        int f = fim;

        while(i <= f){
            while(i <= f && values[i] <= pivot){
                i++;
            }

            while(i <= f && values[f] > pivot){
                f--;
            }

            if(i < f){
                swap(values, i, f);
            }
        }

        swap(values, inicio, f);

        return f;
    }
}
