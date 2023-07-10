public class EstructurasPrincipales {
    public static void main(String[] args){
        //Tipo string, char
        System.out.println("Hello, World!");
        //Tipo int, short (-32.768 a 32.767), long (Sufijo L), byte (-128 a 127)
        System.out.println(5);
        //Tipo float (Sufijo F), double
        System.out.println(3.25F);
        //Tipo booleano
        //Variables en java
        boolean activo;
        activo = true;
        System.out.println(activo);
        activo = false;
        System.out.println(activo);
        //Declarar una constante en java (con final antes del tipo de dato)
        final float pi = 3.14F;

        //OPERADORES 
        //Lógicos (>, <, !=, ==, &&, ||)
        //Incremento/Decremento (++, --, += n, -= n)
        //Concatenación (+)
        int a = 5;
        int b = 7;
        int c = a+b;
        System.out.println(c);
        c++;
        System.out.println(c);
        c-=a+1;
        System.out.println(c);
        System.out.println("El valor de pi es: "+pi);
    }
}
