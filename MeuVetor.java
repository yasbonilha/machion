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
}