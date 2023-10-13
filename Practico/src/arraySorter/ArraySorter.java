package arraySorter;
import java.util.Arrays;
import java.util.Random;

/**
* Provee métodos para ordenar arreglos de objetos comparables.
* Los algoritmos de ordenamiento provistos por esta clase son:
* <ul>
* <li>Bubble sort.</li>
* <li>Selection sort.</li>
* <li>Shell sort.</li>
* <li>Quick sort.</li>
* <li>Merge sort.</li>
* </ul>
* El invariante que deben cumplir todos los arreglos {@code array} para ser utilizados como argumentos de los distintos algoritmos de ordenamiento es:
* <pre>
* array != null &amp;&amp; for (T elem : array) {elem != null}
* </pre>
*/
public class ArraySorter {

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Bubble Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
      boolean sorted = false;
      int n = array.length; 
      for (int pass = 1; (pass < n) && !sorted; ++pass) {
         sorted = true;
         for (int index = 0; index < n - pass; ++index) {
            int nextIndex = index + 1;
            if (array[index].compareTo(array[nextIndex]) > 0) {
               swap(array, index, nextIndex);
               sorted = false;
            }
         }
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Selection Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("Arreglo nulo.");
      //last = indice del ultimo elemento de la parte no ordenada
      for (int last = array.length - 1; last >= 1; last--) {
         //largest = posicion del elemento mas grande
         int largest = indexOfLargest(array, last + 1);
         swap(array, last, largest);
      }
   }


   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Shell Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void shellSort(T[] array) {
	    if (array == null || array.length <= 1) {
	        throw new UnsupportedOperationException("Arreglo vacio o inválido."); 
	    }
	    
	    int n = array.length;
	    int intervalo = 1;

	    // Determinar el intervalo inicial (se sugiere secuencia de Marcin Ciura)
	    while (intervalo < n / 3) {
	        intervalo = intervalo * 3 + 1;
	    }

	    while (intervalo >= 1) {
	        for (int i = intervalo; i < n; i++) {
	            // Insertion sort para los elementos en el intervalo actual
	            T elemento = array[i];
	            int j;
	            for (j = i; j >= intervalo && array[j - intervalo].compareTo(elemento) > 0; j -= intervalo) {
	                array[j] = array[j - intervalo];
	            }
	            array[j] = elemento;
	        }
	        intervalo /= 3; // Reducir el intervalo
	    }
	}


   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Quick Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void quickSort(T[] array) {
	    if (array == null || array.length == 0) {
	    	throw new UnsupportedOperationException("Arreglo vacio o inválido."); 
	    }
	    quickSort(array, 0, array.length - 1);
	}

   private static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right) {
       if (left < right) {
           // Elegir un pivote aleatorio
           int pivotIndex = getRandomPivotIndex(left, right);
           
           // Mover el pivote al final del arreglo
           swap(array, pivotIndex, right);
           
           int partitionIndex = partition(array, left, right);
           
           quickSort(array, left, partitionIndex - 1);
           quickSort(array, partitionIndex + 1, right);
       }
   }

   
   private static <T extends Comparable<? super T>> int partition(T[] array, int left, int right) {
	    T pivot = array[right];
	    int i = left - 1;
	    for (int j = left; j < right; j++) {
	        if (array[j].compareTo(pivot) <= 0) {
	            i++;
	            swap(array, i, j);
	        }
	    }
	    swap(array, i + 1, right);
	    return i + 1;
	}
   
   private static <T extends Comparable<? super T>> int getRandomPivotIndex(int left, int right) {
       Random rand = new Random();
       return rand.nextInt(right - left + 1) + left;
   }
   
   /**
   * Ordena un arreglo, usando el orden natural de sus elementos utilizando Merge Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
	    if (array == null || array.length <= 1) {
	        return; // No se hace nada si el arreglo está vacío o tiene un solo elemento
	    }
	    
	    T[] aux = Arrays.copyOf(array, array.length); // Creamos un arreglo auxiliar para almacenar los valores ordenados
	    mergeSort(array, aux, 0, array.length - 1);
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] array, T[] aux, int low, int high) {
	    if (low < high) {
	        int mid = low + (high - low) / 2;
	        mergeSort(array, aux, low, mid); // Ordenar la mitad izquierda
	        mergeSort(array, aux, mid + 1, high); // Ordenar la mitad derecha
	        merge(array, aux, low, mid, high); // Combinar las dos mitades ordenadas
	    }
	}

	private static <T extends Comparable<? super T>> void merge(T[] array, T[] aux, int low, int mid, int high) {
	    // Copiar los elementos a ordenar al arreglo auxiliar
	    for (int i = low; i <= high; i++) {
	        aux[i] = array[i];
	    }

	    int i = low;
	    int j = mid + 1;
	    int k = low;

	    // Combinar las dos mitades ordenadas
	    while (i <= mid && j <= high) {
	        if (aux[i].compareTo(aux[j]) <= 0) {
	            array[k] = aux[i];
	            i++;
	        } else {
	            array[k] = aux[j];
	            j++;
	        }
	        k++;
	    }

	    // Copiar cualquier elemento restante en la mitad izquierda (si lo hay)
	    while (i <= mid) {
	        array[k] = aux[i];
	        k++;
	        i++;
	    }
	    // No es necesario copiar la mitad derecha, ya que los elementos restantes ya están en su lugar original
	}

   /* (non-Javadoc)
   * Este método intercambia dos posiciones de un arreglo.
   */ 
   private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   /* (non-Javadoc)
   * Este método retorna el indice del elemento mas grande. 
   */
   private static <T extends Comparable<? super T>> int indexOfLargest(T[] array, int n){
      int largest = 0;
      for (int i = 1; i < n; i++){
         if (array[i].compareTo(array[largest]) > 0){
            largest = i;
         }
      }  
      return largest;
   }
   
   /**
    * Ordenada el arreglo haciendo uso del radixSort, el mismo se usa para ordenar números en el cual
    * va ordenando por cada digito del mismo.
    */
   
   public static Integer[] radixSort(Integer[] entrada) {
	    if (entrada == null || entrada.length <= 1) {
	        return entrada; // No se hace nada si el arreglo está vacío o tiene un solo elemento
	    }

	    // Encuentra el valor máximo para determinar el número de dígitos
	    int max = findMax(entrada);

	    // Realiza el ordenamiento por cada dígito, desde el dígito menos significativo al más significativo
	    for (int exp = 1; max / exp > 0; exp *= 10) {
	        countingSortByDigit(entrada, exp);
	    }

	    return entrada;
	}

	private static int findMax(Integer[] array) {
	    int max = array[0];
	    for (int i = 1; i < array.length; i++) {
	        if (array[i] > max) {
	            max = array[i];
	        }
	    }
	    return max;
	}

	private static void countingSortByDigit(Integer[] array, int exp) {
	    int n = array.length;
	    int[] output = new int[n];
	    int[] count = new int[10];

	    // Inicializa el arreglo de conteo
	    for (int i = 0; i < 10; i++) {
	        count[i] = 0;
	    }

	    // Almacena el conteo de ocurrencias de cada dígito en el arreglo de conteo
	    for (int i = 0; i < n; i++) {
	        count[(array[i] / exp) % 10]++;
	    }

	    // Calcula la posición de cada dígito en el arreglo de salida
	    for (int i = 1; i < 10; i++) {
	        count[i] += count[i - 1];
	    }

	    // Construye el arreglo de salida
	    for (int i = n - 1; i >= 0; i--) {
	        output[count[(array[i] / exp) % 10] - 1] = array[i];
	        count[(array[i] / exp) % 10]--;
	    }

	    // Copia el arreglo de salida al arreglo original
	    for (int i = 0; i < n; i++) {
	        array[i] = output[i];
	    }
	}


}
