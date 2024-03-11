public class TesteDeslocamento {
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(10);
        
        for(int i = 10; i<=50; i+=10){
            v1.add(i);
            System.out.println(v1);
        }

        v1.add(100, 37);
        System.out.println(v1);

        v1.add(200,2);
         System.out.println(v1);

        // System.out.println(v1.remove(0));
        // System.out.println(v1);

        // System.out.println(v1.remove(7));
        // System.out.println(v1);

        System.out.println(v1.remove(3) + "saiu da posicao 03");

        for(int i = 1; i<=4; i++){
            v1.add(5, 2*i);
        }
        System.out.println(v1);

        v1.remove(5.0); // tamos que especificar que queremos o método com o parâmetro double! (para ele não confundir com o método que chama o int posição)
        System.out.println(v1);

    }
}
