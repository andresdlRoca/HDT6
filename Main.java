import java.util.Scanner;

class Main {
  public static void main(String[] args) {


    Scanner scan = new Scanner(System.in);
    Cartas cartas = new Cartas();

    System.out.println("---Coleccion de cartas---\n");

    System.out.println("Eliga que implementacion de MAP quiere utilizar");
    System.out.println("1. HashMap");
    System.out.println("2. TreeMap");
    System.out.println("3. LinkedHashMap");

    int respuesta = scan.nextLine();
    

    boolean run = true;

    while(run) {

      System.out.println("\nMenu de opciones\n");
      System.out.println("1. Agregar a coleccion");
      System.out.println("2. Mostrar tipo de una carta");
      System.out.println("3. Mostrar nombre y tipo de cartas en tu coleccion");
      System.out.println("4. Mostrar nombre y tipo de cartas en tu coleccion, ordenadas por tipo");
      System.out.println("5. Mostrar nombre y tipo de todas las cartas existentes");
      System.out.println("6. Mostrar nombre y tipo de todas las cartas existentes, ordenadas por tipo")

      int opcion = scan.nextLine();


    }


  }
}