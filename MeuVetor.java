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

    // public boolean add(int elemento){ neste caso, o vetor está fixo - nós escolhemos esse tamanho e ele fica desse tamanho para sempre
    //     if(estaCheio())
    //         return false;
    //     ultimaPos++;
    //     v[ultimaPos] = elemento;
    //     return true;

    //     // por que não colocamos um print aqui para vermos se deu certo? pelo padrão MVC, onde não misturamos modelos (regras de negócio ) com visão (interface), já que não sabemos se o cliente que vai usar nosso programa vai ser um usuário final ou um outro software, que talvez não tenha uma saída visual e, portanto, não consegue fazer o tratamento desse print. já o vetor é totalmente tratável - o print não. 
    // }

    // análise amortizada do custo computacional (pesquisar!!!!) - se encher, a gente dobra. se estiver só um quarto, a genre reduz pela metade.

    // não precisamos mais do retorno boolean, só se for em c por exemplo ou em tempo de execução, como em dispositivos com menos memória
    public void add(int elemento) {
        if(estaCheio()){
           redimensiona(v.length*2);
        }
        v[++ultimaPos] = elemento; //primeiro soma depois atribui
    }
    
    
    // na classe array list, os argumentos sao da classe generics, que so recebe classes, porque assim podemos conferir se aquela posicao realmente tera algo ou ela esta nula
    // quando queremos dar um clear, não temos que apagar tudo, só temos que colocar o ponteiro no começo, porque dai ele vai comecar a sobrescrever em cima das informações (elas estão "apagadas" pois não tem mais referencia na memoria)
    
    public boolean estaVazio(){
        return ultimaPos == -1;
    }
    
    public int remove(){
        if(estaVazio()) return 0;
        int aux = v[ultimaPos];
        ultimaPos--;
        if(v.length >= 10 && ultimaPos <= v.length/4) { //para que, se por acaso der menos, ele nao quebre
            redimensiona(v.length/2);
        }
        return aux;
    }
    
    
    private void redimensiona(int novaCapacidade){
        int[] temp = new int [novaCapacidade]; //esse vetor está dissociado na memória (sem referência), é um vetor temporário. como vamos cortar a referência do vetor original e attach it aqui, vamos deixar o outro vetor sem referencia e o garbagge (JVM) vai cuidar de liberar ele da memoria
        // se estivermos em uma linguagem que não tem essa propriedade, teríamos que carregar a "capacidade" como atributo e passar ela

        for(int i=0; i<ultimaPos; i++){
            temp[i] = v[i];
        }
        v = temp; //atribui a ref do novo vetor ao atributo v;
        //cortamos os laços e passamos os valores de temp para v (como temp é uma variável local de metodo, ela morre quando o metodo termina)
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