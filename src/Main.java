public class Main {
   public static void main(String[] args) {
      Matriz matriz = new Matriz();
      Arvore arvore = new Arvore();

      matriz.readFile("grafo3.txt");
      matriz.exibir();

      System.out.println();
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      arvore.pontoArticulacao(matriz);
      System.out.println();
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println();

      arvore.mostrarLigacoes();
   }
}