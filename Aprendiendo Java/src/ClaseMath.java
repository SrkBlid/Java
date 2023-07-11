public class ClaseMath {
    public static void main(String[] args){

        //Clases propias: Creadas por nosotros.
        //Clases predefinidas (API JAVA, que es una biblioteca que contiene todas las clases predefinidas): Vienen ya hechas en java. (Math, String, Array, etc)
        
        //Clase math: raices cuadradas, aproximaciones, exponenciales, etc.
        //Math.sqrt(n);
        //Math.pow(base, exponente);
        //Math.sin(ángulo), Math.cos(ángulo), Math.tan(ángulo), Math.atan(ángulo);
        //Math.round(decimal);
        //Math.PI; Constante que contiene el número PI

        double a = Math.sqrt(9); 
        System.out.println(a);

        int exp = 5;
        int base = 20;
        double res = Math.pow(base, exp);
        System.out.println(res);
    
        //Refundición: Consiste en convertir un tipo de dato en otro.
        //Lo que se hace es poner el tipo de dato al que queremos transformarlo entre parentesis adelante de la expresión.
        float d = 8.46F;
        int redAbajo= (int)Math.round(d);
        System.out.println("El redondeo de 8.46 es: "+redAbajo);
    }
}
