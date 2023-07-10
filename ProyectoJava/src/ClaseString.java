public class ClaseString {
    public static void main (String[] args){
        //nombre es un objeto (instancia) de la clase String, no es una variable.
        String nombre = "Juan";
        String apellido = "Perez";
        System.out.println(nombre+" "+apellido);

        //Método de la class String más útiles
        //String.length
        //String.charAt(n) (Char en la posición dada)
        //String.substring(x, y) (Toma desde la pos x a la y)
        //String.equals(cadena) (Devuelve True si 2 cadenas son iguales)
        //String.equalsIgnoreCase(cadena) (Es lo mismo pero ignora mayusculas)

        //Al ser instanciaciones de la class String, tenemos que usar los métodos sobre el nombre que tenga la "variable", por ejemplo, en lugar de String.length(nombre) seria nombre.length()
        System.out.println("Longitud del nombre: "+nombre.length());
        System.out.println("La primera letra del nombre "+nombre+" es: "+nombre.charAt(0));
        System.out.println("La última letra del nombre "+nombre+" es: "+nombre.charAt(nombre.length()-1));
        System.out.println(apellido.substring(1, 5));
        System.out.println(nombre.equals(apellido));

        String frase = "Hoy es un dia muy bonito para ponernos a programar";
        String fraseResumen = frase.substring(30);
        System.out.println(fraseResumen+" es algo bonito que nos alegra la vida");
    }
}
