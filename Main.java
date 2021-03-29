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

    int respuesta = scan.nextInt();
    cartas.setImplementacion(respuesta);

    boolean run = true;

    while(run) {

      System.out.println("\nMenu de opciones\n");
      System.out.println("1. Agregar a coleccion");
      System.out.println("2. Mostrar tipo de una carta de la coleccion general");
      System.out.println("3. Mostrar nombre y tipo de cartas en tu coleccion");
      System.out.println("4. Mostrar nombre y tipo de cartas en tu coleccion, ordenadas por tipo");
      System.out.println("5. Mostrar nombre y tipo de todas las cartas existentes");
      System.out.println("6. Mostrar nombre y tipo de todas las cartas existentes, ordenadas por tipo");
      System.out.println("7. Salir del programa");

      int opcion = scan.nextInt();

      //Menu principal de opciones
      switch(opcion) {

        case 1 : 
          System.out.println("Cual es el nombre de la carta que quiere agregar?");
          scan.nextLine();
          String carta = scan.nextLine();
          cartas.agregarCarta(carta);
          break;
        
        case 2 : 
          System.out.println("Cual es el nombre de la tarjeta que quiere revisar?");
          scan.nextLine();
          String cartaTipo = scan.nextLine();
          cartas.mostrarTipo(cartaTipo);
          break;

        case 3 : 
          System.out.println("---Tu Coleccion---");
          cartas.mostrarCartasUsuario();
          break;

        case 4 :
          System.out.println("---Tu Coleccion Ordenada---");
          cartas.mostrarCartasUsuarioOrd();
          break;

        case 5 : 
          System.out.println("---Coleccion General---");
          cartas.mostrarCartasGeneral();
          break;
        
        case 6 : 
          System.out.println("---Coleccion General Ordenada---");
          cartas.mostrarCartasGeneralOrd();
          break;

        case 7 : 
          System.out.println("Saliendo del programa...");
          run = false;
          break;
        
        default : 
          System.out.println("Ingreso una opcion invalida, intentelo de nuevo");
          scan.nextLine();
      }

    }


  }
}