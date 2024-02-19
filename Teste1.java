public class Teste1 {
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(10);
        System.out.println("última posição depois de instanciar" + v1.getUltimaPos());
        // v1.ultimaPos = 27;
        // v1.v[v1.ultimaPos] =10;
        v1.setUltimaPos(27);
        System.out.println("ultima posicao depois do 27" + v1.getUltimaPos());

    }
}
