import java.util.ArrayList;

public class No {
   private No pai;
   private char info;
   private ArrayList<No> ligacoes;
   private ArrayList<Integer> valores = new ArrayList();

   public No(char info, ArrayList ligacoes, ArrayList valores) {
      this.info = info;
      this.ligacoes = ligacoes;
      this.valores = valores;
   }

   public No(char info) {
      this.info = info;
      this.ligacoes = new ArrayList<>();
   }

   public No getPai() {
      return this.pai;
   }

   public void setPai(No pai) {
      this.pai = pai;
   }

   public char getInfo() {
      return info;
   }

   public void setInfo(char info) {
      this.info = info;
   }

   public void setLigacao(No no) {
      this.ligacoes.add(no);
   }

   public No getLigacao(int pos) {
      return this.ligacoes.get(pos);
   }

   public ArrayList<No> getLigacoes() {
      return this.ligacoes;
   }

   public void insereValor(int num) {
      this.valores.add(num);
   }

   public ArrayList<Integer> getValores() {
      return valores;
   }

   public int getValorPos(int pos) {
      return valores.get(pos);
   }
}
