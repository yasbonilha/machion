public class Teste1 {
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(10);
        System.out.println("ultima posicao depois de instanciar: " + v1.getUltimaPos());
        // v1.ultimaPos = 27;
        // v1.v[v1.ultimaPos] =10;
        // v1.setUltimaPos(27);
        // System.out.println("ultima posicao depois do 27: " + v1.getUltimaPos());
        // System.out.println(v1);

        // if(v1.add(12)){
        //     System.out.println("elemento inserido com sucesso!");
        // }else{
        //     System.out.println("o vetor está cheio!");
        // };
        
        for(int n=0; n<100; n++){
            v1.add(n);

            System.out.println("capacidade atual para  " + n + ":   "+ v1.getV().length);
        }

        System.out.println("*****************");

        while(!v1.estaVazio()){
            v1.remove();
            System.out.println("capacidade atual para  " + v1.getUltimaPos() + ":   " + v1.getV().length);
        }
        
    }
}

// quando printamos os vetores, o que aparece é o nomeClasse@hashCode, que dá uma chave de como você consegue acessar esse objeto;
// temos o polimorfismo dinâmico (sobrecarga), estático (sobrescrita) e paramétrico (generics).
// polimorfismo dinamico pq ele é resolvido em tempo de execucao. estatico pq e resolvido em tempo de compilacao. e o parametrico é o que define a partir do que a gente definiu

// quando chamamos o metodo getV, temos como retorno para nos a referencia na memoria do vetor V