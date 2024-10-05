
package clase7;

public class Principal {
    public static void main(String[] args) {
        // Upcasting: Perro -> Animal
        Animal miAnimal = new Perro(); 
        // Verificamos si miAnimal es instancia de Perro
        if (miAnimal instanceof Perro) {
            // Downcasting a Perro
            Perro miPerro = (Perro) miAnimal;  
            miPerro.hacerSonido();  
            miPerro.moverCola();
        } else {
            System.out.println(
                    "El objeto no es una instancia de Perro.");
        }
    }
}


