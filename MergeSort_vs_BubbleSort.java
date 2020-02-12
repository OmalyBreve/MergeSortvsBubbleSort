import java.util.Timer;

public class MergeSort_vs_BubbleSort {




    public static void main(String[] args) {
        // write your code here

        int[] arreglo1 = new int[5000];
        int[] arreglo2 = new int[5000];



        for (int i = 0; i<arreglo1.length;i++){
            int temp = (int)(Math.random()*99)+1;
            arreglo1[i] = temp;
            arreglo2[i] = temp;
        }

        arreglo1 = mergeSort(arreglo1);
        arreglo2 = bubbleSort(arreglo1);

        Timer timer = new Timer();

        System.out.println("MERGE SORT");
        for (int i = 0; i < arreglo1.length; i++) {
            long Time = System.currentTimeMillis();
            System.out.print(arreglo1[i]+", ");
            System.out.println(Time+" Milisegundos");

        }


        System.out.println("BUBBLE SORT");
        for (int i = 0; i< arreglo2.length;i++){
            long TIME = System.currentTimeMillis();
            System.out.print(arreglo2[i]+", ");
            System.out.println(TIME+" Milisegundos");
        }
    }


    public static int[] bubbleSort(int[] arreglo){

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if(arreglo[i]< arreglo[j]){
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }
        return arreglo;
    }

    public  static int[] mergeSort(int[] arreglo){
        if(arreglo.length <= 1){
            return arreglo;
        }
        int medio = arreglo.length /2;

        int[] abajo = new int[medio];
        int[] arriba = new int[arreglo.length - medio];
        for (int i = 0; i < medio; i++) {
            abajo[i] = arreglo[i];
        }

        for (int i = 0; i < arriba.length ; i++) {
            arriba[i] = arreglo[i + abajo.length];
        }
        return  merge(mergeSort(abajo), mergeSort(arriba));
    }


    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }

        while (j < a.length){
            retval[i++] = a[j++];
        }

        while (k < b.length){
            retval[i++] = b[k++];
        }
        return retval;
    }
}


