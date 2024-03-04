import java.util.Scanner;
import java.util.Date;

public class Ordenacao {
    public static void main(String[] args) {
        int tamanho;
        MeuVetor v1;
        Scanner sc = new Scanner(System.in); //temos que inicializar o objeto e fecha-lo depois
        System.out.println("querido usuario, digite o tamanho do vetor:)\n 0 encerra: ");
        tamanho = sc.nextInt();
        while(tamanho > 0){
            v1 = new MeuVetor(tamanho);
            v1.preencheVetor();
            // System.out.println("vetor gerado: " + v1);
            long inicio = new Date().getTime(); // nao guardamos o objeto porque nao vamos precisar dele, so do numero que o metodo dele nos dá
            int comparacoes = v1.bubbleSort();
            long fim = new Date().getTime();
            // System.out.println("vetor ordenado pelo Bubble: " +v1);
            // System.out.println("tamanho: " + tamanho + ", comparacoes: " + comparacoes);
            System.out.println("tamanho = " + tamanho + ", demorou: "  + (fim - inicio) + "ms");
            System.out.println("querido usuario, digite o tamanho do vetor:)\n 0 encerra: ");
            tamanho = sc.nextInt();
        }
        sc.close();

    }
}
