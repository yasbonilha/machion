import java.util.Scanner;

public class OrdenaBusca {
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(120000);
        v1.preencheVetor();
        System.out.println("vetor gerado:\n" + v1);
        Scanner sc = new Scanner(System.in);
        System.out.println("querido usuário, digite um valor para busca: ");
        double x = sc.nextDouble();

        Retorno r = v1.buscaSimples(x);

        if(r.getAchou()){
            System.out.println(x + " encontrado no vetor pela busca simples");;
        }else{
            System.out.println(x + " não encontrado pela busca simples");
        }
        System.out.println("fram realizados " + r.getContador() + " testes na busca simples.");



        v1.bubbleSort();
        r = v1.buscaBinaria(x);
        if(r.getAchou()){
            System.out.println(x + " encontrado no vetor pela busca binária");;
        }else{
            System.out.println(x + " não encontrado pela busca binária");
        }
        System.out.println("fram realizados " + r.getContador() + " testes na busca binária.");

        sc.close();
    }
    // por que ordenar? para recuperar informações de maneira eficiente. se os dados forem ordenados, podemos pegar a mediana dos dados e 
}