import java.util.*;

public class MapFactory {

    /**
     * @post: regresa el stack seleccionado
     * @param entry es el tipo de stack que se inicializa
     * @return el stack seleccionado nuevo
     */
    public Map getMap(int entry) {

            switch (entry) {
            //regresa un Hashmap
            case 1 : 
              System.out.println("HashMap");
              return new HashMap<String, String>();
              
            //regresa una treeMap
            case 2 : System.out.println("TreeMap");
              return new TreeMap<String,String>();
              
            case 3 : 
              System.out.println("LinkedHashMap");
              return new LinkedHashMap<String,String>();
              
            default :  
              System.out.println("Default, Hashmap");
              return new HashMap<String, String>();
              
        }
    }
}