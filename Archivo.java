
import java.io.*;

public class Archivo
{
    public void leer()
    {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("cards_desc.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero, mostradolo con print
         /*
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);*/
            
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }

    public void escribir()
    {
       FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("cards_desc.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

    public void separar()
    {
      leer();
      String linea = br.readLine();
         
      String[] parts = linea.split("|");
      for(int i = 0; i < parts.length;i++)
        {
          System.out.println(parts[i]);
        }
        
      
    }
}