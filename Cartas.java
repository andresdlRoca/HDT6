import java.util.*;

public class Cartas {

  MapFactory mapfacto = new MapFactory();

  Map<String, String> mapUsuario;
  Map<String, String> mapGeneral;
  boolean hashmap = false;
  boolean treemap = false;
  boolean linkedhmap = false;

  public void setImplementacion(int respuesta){
    mapUsuario = mapfacto.getMap(respuesta);
    mapGeneral = mapfacto.getMap(respuesta);
    mapGeneral.put("CartaPrueba", "Mago");
    mapGeneral.put("CartaPrueba 2", "Mago");
    mapGeneral.put("CartaPrueba 3", "Mago");
    mapGeneral.put("El Bicho", "Futbolista");
    mapGeneral.put("Messi", "Futbolista");
    mapGeneral.put("Haaland", "Futbolista");
    mapGeneral.put("Dragon", "Monstruo");
    mapGeneral.put("Ogro", "Monstruo");
    mapGeneral.put("Esqueleto", "Monstruo");
    mapGeneral.put("No se", "Arquero");
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
    if(mapGeneral.containsKey(carta)) {
      mapUsuario.put(carta, mapGeneral.get(carta));
      System.out.println("La carta se ha agregado a tu coleccion.");
    } else {
      System.out.println("Esta carta no existe.");
    }
  }

  //Se chequea si la carta existe y luego se muestra el tipo que tiene asignado.
  public void mostrarTipo(String carta) {
    if(mapGeneral.containsKey(carta)) {
      System.out.println("Esta carta es de tipo " + mapGeneral.get(carta));
    } else {
      System.out.println("Esta carta no existe.");
    }
    
  }

  //Muestra el nombre, tipo y cantidad de cada carta que el usuario tiene en su coleccion.
  public void mostrarCartasUsuario() {
    for(Map.Entry<String,String> entry : mapUsuario.entrySet()) {
      System.out.println(entry.getKey() + " / " + entry.getValue());
    }

    int countMago = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Mago");
    int countMonstruo = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Monstruo");
    int countFutbolista = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Futbolista");
    int countArquero = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Arquero");

    System.out.println("---Cantidad de cartas---");
    System.out.println("Mago: " + countMago);
    System.out.println("Monstruo: " + countMonstruo);
    System.out.println("Fubolista: " + countFutbolista);
    System.out.println("Arquero: " + countArquero);
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

    int countMago = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Mago");
    int countMonstruo = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Monstruo");
    int countFutbolista = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Futbolista");
    int countArquero = Collections.frequency(new ArrayList<String>(mapUsuario.values()), "Arquero");

    System.out.println("---Cantidad de cartas---");
    System.out.println("Mago: " + countMago);
    System.out.println("Monstruo: " + countMonstruo);
    System.out.println("Fubolista: " + countFutbolista);
    System.out.println("Arquero: " + countArquero);
  }
  

  //Mostrar el nombre y tipo de todas las cartas existentes.
  public void mostrarCartasGeneral() {
        for(Map.Entry<String,String> entry : mapGeneral.entrySet()) {
      System.out.println(entry.getKey() + " / " + entry.getValue());
    }
  }

  //Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.
  public void mostrarCartasGeneralOrd() {
      if(hashmap) {
        Map<String, String> sortedMap = sortByValues(mapGeneral);
        Set set2 = sortedMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
          Map.Entry me2 = (Map.Entry)iterator2.next();
          System.out.print(me2.getKey() + " / ");
          System.out.println(me2.getValue());
        }

    } else if (treemap) {
      Map SortedMap = sortByValues(mapGeneral);
      Set set = SortedMap.entrySet();
      Iterator i = set.iterator();
      while(i.hasNext()) {
        Map.Entry me = (Map.Entry)i.next();
        System.out.println(me.getKey() + " / " + me.getValue());
      }
    } else if (linkedhmap) {
        Map<String, String> sortedMap = sortByValues(mapGeneral);
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