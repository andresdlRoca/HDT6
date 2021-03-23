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
            case 1 : return new HashMap<String, String>();
            //regresa una treeMap
            case 2 : return new TreeMap<String,String>();
            //regresa un LinkedHashMap
            case 3 : return new LinkedHashMap<String,String>();
            //regresa Vector
            default : new StackVector<E>();
        };
    }
}