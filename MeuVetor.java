import java.util.Random;

public class MeuVetor {
   private double[] v;
   private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }

    // métodos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }
    public double[] getV() {
        return v;
        // o int[] significa vetor - definição de tipos diferentes
    }

    // métodos modificadores - esse não indicado porque voce dá o controle interno na mão do usuário
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

    public void add(double elemento){
        if(estaCheio()){
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = elemento;
    }
    
    
    // na classe array list, os argumentos sao da classe generics, que so recebe classes, porque assim podemos conferir se aquela posicao realmente tera algo ou ela esta nula
    // quando queremos dar um clear, não temos que apagar tudo, só temos que colocar o ponteiro no começo, porque dai ele vai comecar a sobrescrever em cima das informações (elas estão "apagadas" pois não tem mais referencia na memoria)
    
    public boolean estaVazio(){
        return ultimaPos == -1;
    }

    public void reset(){
        ultimaPos = -1;
    }
    
    public double remove(){
        if(estaVazio()) return 0;
        double aux = v[ultimaPos];
        ultimaPos--;
        if(v.length >= 10 && ultimaPos <= v.length/4) { //para que, se por acaso der menos, ele nao quebre
            redimensiona(v.length/2);
        }
        return aux;
    }
    
    
    private void redimensiona(int novaCapacidade){
        double[] temp = new double [novaCapacidade]; //esse vetor está dissociado na memória (sem referência), é um vetor temporário. como vamos cortar a referência do vetor original e attach it aqui, vamos deixar o outro vetor sem referencia e o garbagge (JVM) vai cuidar de liberar ele da memoria
        // se estivermos em uma linguagem que não tem essa propriedade, teríamos que carregar a "capacidade" como atributo e passar ela

        for(int i=0; i<=ultimaPos; i++){
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
                s = s + String.format("%.0f ", v[i]);
            }
        }

        s = s + "\n";

        return s;
    }


    	// public void preencheVetor(){
        //     for(int i =0; i<=v.length; i++){ //não podemos usar o v.length para controlar esse método pois estamos baseando todo o nosso código no controle ultPos. se nós usamos o v.length e não modificamos de alguma forma o ultPos, ele será sempre -1. logo, dá que o vetor está sempre vazio. por isso, ao inves de nos mesmos mexermos no vetor, jogamos para o metodo add e ele que toma conta disso
        //         add(Math.random());
        //     }
        // }

        public void preencheVetor(){
            Random r = new Random(); //o random nao é parte dos atributos da nossa classe - nasce e morre
            for(int i =0; i<v.length; i++){ 
                add(r.nextInt(v.length*10 + 1));
            }
        }

        public void preencheVetor(int limite){
            Random r = new Random();
            for(int i =0; i<v.length; i++){ 
                add(r.nextInt(limite));
            }
        }


        public int bubbleSort(){ //o bubblesort é um alogoritmo de ordenacao estavel pois valores iguais permanecem na mesma posicao sem troca, 
            // se voce nao quer declarar variaveis para atribuição, podemos usar a=a+b, b=a-b, b=a-b;

            // bubblesort é eficaz? sim, mas nao é eficiente (porque com um volume muito grande de dados o desempenho dele nao e tao bom)
            int cont = 0;
            for(int i =1; i<v.length; i++){
                for (int j=0; j<v.length-1; j++){
                    cont++;
                    if(v[j]>v[j+1]) {
                        double aux = v[j];
                        v[j] = v[j+1];
                        v[j+1] = aux;

                    }
                }
            }
            return cont;
        }

}


// polimorfismo paramétrico - sobrecarga de métodos