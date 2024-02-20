public class MeuVetor {
   private int[] v;
   private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new int[capacidade];
        ultimaPos = -1;
    }

    // métodos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }
    public int[] getV() {
        return v;
        // o int[] significa vetor - definição de tipos diferentes
    }

    // métodos modificadores
    public void setUltimaPos(int pos){
        if(pos>=0 && pos<v.length) {
            ultimaPos = pos;
        }
        else{
            ultimaPos = v.length -1;
        }

    }

    public boolean estaCheio() {
        // para verificar isso, consultamos nossa variavel de controle
        if(ultimaPos == v.length-1)
            return true;
        else
            return false;
            // apesar disso, o else não seria necessário, já que, se o if for verdadeiro, ele vai sair do laço e não chegará até o falso. além disso, podemos simplesmente retornar o próprio teste, como : return ultimaPos == v.length -1;
    }

    public boolean add(int elemento){
        if(estaCheio())
            return false;
        ultimaPos++;
        v[ultimaPos] = elemento;
        return true;
    }

    public boolean estaVazio(){
        return ultimaPos == -1;
    }

    @Override // aviso para o desenvolvedor de que não podemos mexer na assinatura do método, já que queremos que haja sobrescrita
    public String toString(){
        String s = "";
        if(estaVazio()){
            s = s + "esta vazio";
        }else{
            for(int i=0; i<=ultimaPos; i++){
                s = s + v[i] + " ";
            }
        }

        s = s + "\n";

        return s;
    }

}


// polimorfismo paramétrico - sobrecarga de métodos