import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Matriz {
   private String matriz[] = new String[12];
   private int numVertices;

   public Matriz(String[] matriz, int numVertices) {
      this.matriz = matriz;
      this.numVertices = numVertices;
   }

   public Matriz() {
      this.numVertices = 0;
   }

   public String[] getMatriz() {
      return matriz;
   }

   public void setMatriz(String[] matriz) {
      this.matriz = matriz;
   }

   public int getNumVertices() {
      return numVertices;
   }

   public void setNo(int numVertices) {
      this.numVertices = numVertices;
   }

   public void setMat(int i, String str) {
      this.matriz[i] = str;
   }

   public void readFile(String fileName) {
      try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
         String linha;

         linha = br.readLine();
         this.numVertices = linha.length();

         int i = 0;
         while ((linha = br.readLine()) != null) {
            this.matriz[i++] = linha;
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void exibir() {
      for(int i=-1; i< numVertices; i++) {
         if(i==-1) {
            System.out.print("  ");
            for(int j=0; j<numVertices; j++) {
               System.out.print((char)(j+65));
            }
         } else {
            System.out.print((char)(i+65)+" ");
            System.out.print(matriz[i]);
         }
         System.out.println();
      }
   }
}
