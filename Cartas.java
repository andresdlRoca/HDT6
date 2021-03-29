import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Cartas {

    MapFactory mapfacto = new MapFactory();

    Map<String, String> mapUsuario;
    //Map<String, String> mapGeneral;
    boolean hashmap = false;
    boolean treemap = false;
    boolean linkedhmap = false;

    MapFactory factory = new MapFactory();
    Map<String, String> cards;


    public void setImplementacion(int respuesta){
        try {
            File myObj = new File("cards_desc.txt");
            Scanner linea = new Scanner(myObj);

            cards = factory.getMap(respuesta);


            //complejidad del Hashmap
            int i=0;

            while (linea.hasNextLine()&&i<10000) {
                String data = linea.nextLine();
                String nombre = data.split("\\|")[0];
                String tipo = data.split("\\|")[1];

                cards.put(nombre, tipo);
                i++;
            }

            System.out.println(cards);

            linea.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        mapUsuario = mapfacto.getMap(respuesta);
        //mapGeneral = mapfacto.getMap(respuesta);
        


        if(respuesta == 1 || respuesta > 3) {
            hashmap = true;
        } else if (respuesta == 2) {
            treemap = true;
        } else if (respuesta == 3) {
            linkedhmap = true;
        }
    }

    //Se chequea si la carta existe y luego se agrega al Map del usuario.
    public void agregarCarta(String carta) {
        if(cards.containsKey(carta)) {
            mapUsuario.put(carta, cards.get(carta));
            System.out.println("La carta se ha agregado a tu coleccion.");
        } else {
            System.out.println("Esta carta no existe.");
        }
    }

  //Se chequea si la carta existe y luego se muestra el tipo que tiene asignado.
  public void mostrarTipo(String carta) {
    if(cards.containsKey(carta)) {
      System.out.println("Esta carta es de tipo " + cards.get(carta));
    } else {
      System.out.println("Esta carta no existe.");
    }
    
  }

  //Muestra el nombre, tipo y cantidad de cada carta que el usuario tiene en su coleccion.
  public void mostrarCartasUsuario() {
    for(Map.Entry<String,String> entry : mapUsuario.entrySet()) {
      System.out.println(entry.getKey() + " / " + entry.getValue());
    }

    int countTrampa = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Trampa");
    int countMonstruo = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Monstruo");
    int countHechizo = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Hechizo");

    System.out.println("---Cantidad de cartas---");
    System.out.println("Trampa: " + countTrampa);
    System.out.println("Monstruo: " + countMonstruo);
    System.out.println("Hechizo " + countHechizo);
    
  }

  //Muestra el nombre, tipo y cantidad de cada carta que el usuario tiene en su coleccion, ordenadas por tipo.
  public void mostrarCartasUsuarioOrd() {
    if(hashmap) {
      Map<String, String> sortedMap = sortByValues(mapUsuario);
      Set set2 = sortedMap.entrySet();
      Iterator iterator2 = set2.iterator();
      while(iterator2.hasNext()) {
        Map.Entry me2 = (Map.Entry)iterator2.next();
        System.out.print(me2.getKey() + " / ");
        System.out.println(me2.getValue());
      }

    } else if (treemap) {
      Map SortedMap = sortByValues(mapUsuario);
      Set set = SortedMap.entrySet();
      Iterator i = set.iterator();
      while(i.hasNext()) {
        Map.Entry me = (Map.Entry)i.next();
        System.out.println(me.getKey() + " / " + me.getValue());
      }
    } else if (linkedhmap) {
        Map<String, String> sortedMap = sortByValues(mapUsuario);
        Set set2 = sortedMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
          Map.Entry me2 = (Map.Entry)iterator2.next();
          System.out.print(me2.getKey() + " / ");
          System.out.println(me2.getValue());
      
        }
    }

    int countTrampa = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Trampa");
    int countMonstruo = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Monstruo");
    int countHechizo = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Hechizo");

    System.out.println("---Cantidad de cartas---");
    System.out.println("Trampa: " + countTrampa);
    System.out.println("Monstruo: " + countMonstruo);
    System.out.println("Hechizo " + countHechizo);
  }
  

  //Mostrar el nombre y tipo de todas las cartas existentes.
  public void mostrarCartasGeneral() {
        for(Map.Entry<String,String> entry : cards.entrySet()) {
      System.out.println(entry.getKey() + " / " + entry.getValue());
    }
  }

  //Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.
  public void mostrarCartasGeneralOrd() {
      if(hashmap) {
        Map<String, String> sortedMap = sortByValues(cards);
        Set set2 = sortedMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
          Map.Entry me2 = (Map.Entry)iterator2.next();
          System.out.print(me2.getKey() + " / ");
          System.out.println(me2.getValue());
        }

    } else if (treemap) {
      Map SortedMap = sortByValues(cards);
      Set set = SortedMap.entrySet();
      Iterator i = set.iterator();
      while(i.hasNext()) {
        Map.Entry me = (Map.Entry)i.next();
        System.out.println(me.getKey() + " / " + me.getValue());
      }
    } else if (linkedhmap) {
        Map<String, String> sortedMap = sortByValues(cards);
        Set set2 = sortedMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
          Map.Entry me2 = (Map.Entry)iterator2.next();
          System.out.print(me2.getKey() + " / ");
          System.out.println(me2.getValue());
      
        }
    }
  }

  private Map sortByValues (Map map) {
      List list = new LinkedList(map.entrySet());

       Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o1)).getValue())
                  .compareTo(((Map.Entry) (o2)).getValue());
            }
       });

       Map sortedHashMap = new LinkedHashMap();
       for (Iterator it = list.iterator(); it.hasNext();) {
              Map.Entry entry = (Map.Entry) it.next();
              sortedHashMap.put(entry.getKey(), entry.getValue());
       } 
       return sortedHashMap;
  }

  private <K, V extends Comparable<V>> Map<K,V> sortByValuesTree(final Map<K, V> map) {
      Comparator<K> valueComparator = new Comparator<K>() {
      public int compare(K k1, K k2) {
        int compare = map.get(k1).compareTo(map.get(k2));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
 
    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
  }

}