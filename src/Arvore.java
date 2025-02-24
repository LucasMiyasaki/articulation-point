import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Arvore {
   private No raiz;
   private ArrayList<No> lista = new ArrayList<>();
   private int tempo;

   public Arvore(No raiz) {
      this.raiz = raiz;
   }

   public Arvore() {
      this.raiz = null;
      this.tempo = 2;
   }

   public No getRaiz() {
      return raiz;
   }

   public void setRaiz(No raiz) {
      this.raiz = raiz;
   }

   public ArrayList<No> getLista() {
      return lista;
   }

   public void setLista(No no) {
      this.lista.add(no);
   }

   //Primeira Etapa
   private void buscaProfundidade(No no, Matriz matriz, int pos) {
      for (int i = 0; i < matriz.getNumVertices(); i++) {
         //Verifica matriz
         if (matriz.getMatriz()[pos].charAt(i) == '1') {
            char c = (char) (65 + i);

            // Se não está na lista, insere e faz as ligações dos nós
            if (!lista.stream().anyMatch(noAux -> noAux.getInfo() == c)) {
               No novoNo = new No(c);
               novoNo.insereValor(tempo++);

               //2 ligações
               no.setLigacao(novoNo);
               novoNo.setLigacao(no);
               novoNo.setPai(no);

               lista.add(novoNo);
               buscaProfundidade(novoNo, matriz, i);
            }
         }
      }
   }

   //Segunda Etapa
   private void conexoes(Matriz mat) {
      for (No no : this.lista) {
         int pos = no.getInfo() - 65;
         ArrayList<Integer> lista = new ArrayList<>();

         for (int i = 0; i < mat.getNumVertices(); i++) {
            char c = (char) (i + 65);

            //Verifica quais nós da matriz não foram ligadas
            if (mat.getMatriz()[pos].charAt(i) == '1') {
               if (!no.getLigacoes().stream().anyMatch(aux -> aux.getInfo() == c)) {
                  lista.add(buscaNo(c).getValorPos(0));
               }
            }
         }
         if (lista.size() == 0)
            lista.add(0);

         //Menor valor da lista auxiliar
         no.getValores().add(Collections.min(lista));
      }
   }

   //Terceira Etapa
   //Terceira posicao do vetor e menor de todos
   private void ajustarValor() {
      for (No no : lista) {
         if (no.getLigacoes().size() <= 1 && no != raiz) {
            no.insereValor(0);

            ArrayList<Integer> listaValores = new ArrayList<>();

            for (int i : no.getValores()) {
               if (i != 0) {
                  listaValores.add(i);
               }
            }

            no.insereValor(Collections.min(listaValores));
         }
      }

      Collections.reverse(lista);

      for(No no : lista) {
         if(no.getLigacoes().size() > 1 || no == raiz) {
            ArrayList<Integer> listaValores = new ArrayList<>();

            for(No aux : no.getLigacoes()) {
               if(aux.getPai() == no) {
                  listaValores.add(aux.getValorPos(3));
               }
            }

            no.insereValor(Collections.min(listaValores));

            listaValores.clear();

            for (int i : no.getValores()) {
               if (i != 0) {
                  listaValores.add(i);
               }
            }

            no.insereValor(Collections.min(listaValores));
         }
      }

      Collections.reverse(lista);
   }

   private void teste() {
      ArrayList<No> articulacoes = new ArrayList<>();
      ArrayList<Integer> listaAux = new ArrayList<>();

      for(No no : lista) {
         if(no.getLigacoes().size() > 1 && no != raiz) {
            for(No aux : no.getLigacoes()) {
               if(aux != no.getPai() && aux.getValorPos(3) >= no.getValorPos(0)) {
                  if(!articulacoes.contains(no))
                     articulacoes.add(no);
               }
            }
         }
      }

      if(articulacoes.isEmpty()) {
         System.out.println("Não há necessidade de no-break");
      }
      else {
         System.out.print("Roteadores que precisam de no-break: ");
         for(No no : articulacoes) {
            System.out.print(no.getInfo() + " ");
         }
      }
   }

   public No buscaNo(char c) {
      return buscaNoRecursivo(raiz, c, new ArrayList<>());
   }

   private No buscaNoRecursivo(No no, char c, ArrayList<No> visitados) {
      if (no == null) {
         return null;
      }

      if (no.getInfo() == c) {
         return no;
      }

      visitados.add(no);

      for (No ligacao : no.getLigacoes()) {
         if (!visitados.contains(ligacao)) {
            No aux = buscaNoRecursivo(ligacao, c, visitados);
            if (aux != null) {
               return aux;
            }
         }
      }

      return null;
   }


   public void mostrarLigacoes() {
      mostrarLigacoes(raiz, new ArrayList<>());
   }

   private void mostrarLigacoes(No no, ArrayList<No> visitados) {
      if (no != null && !visitados.contains(no)) {
         visitados.add(no);

         System.out.print("" + no.getValores() + " " + no.getInfo() + " -> ");
         for (int i = 0; i < no.getLigacoes().size(); i++) {
            System.out.print(no.getLigacao(i).getInfo());
            if (i < no.getLigacoes().size() - 1) {
               System.out.print(" -> ");
            }
         }
         System.out.println();

         for (int i = 0; i < no.getLigacoes().size(); i++) {
            mostrarLigacoes(no.getLigacao(i), visitados);
         }
      }
   }

   public void pontoArticulacao(Matriz matriz) {
      No primeiroNo = new No('A');
      raiz = primeiroNo;
      setLista(primeiroNo);
      raiz.insereValor(1);

      buscaProfundidade(raiz, matriz, 0);
      conexoes(matriz);
      ajustarValor();
      teste();
   }
}
