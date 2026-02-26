public class App {
    public static void main(String[] args) {
        
        // Instanciação dos Personagens
        Bruxa cassandra = new Bruxa("Cassandra", "Gelo");
        Demonio oni = new Demonio("Oni", 7);
        Aldeao bob = new Aldeao("Bob", "Ferreiro");

        System.out.println("\n=== INÍCIO DA BATALHA NA ARENA ===\n");

        System.out.println(cassandra.getNome() + ", " + oni.getNome() + " e " + bob.getNome() + " entram no campo.");
        bob.interagir(); 

        // --- TURNO 1: Demônio ataca a Bruxa 
        System.out.println("\n--- TURNO 1 ---\n");
        oni.atacar(cassandra);

        // --- TURNO 2: Bruxa protege o Aldeão e ataca 
        System.out.println("\n--- TURNO 2 ---\n");
        cassandra.defenderTerceiro(bob); 
        cassandra.atacar(oni);

        // --- TURNO 3: O Oni tenta atacar o Aldeão 
        System.out.println("\n--- TURNO 3 ---\n");
        System.out.println(oni.getNome() + " ignora a Bruxa e avança contra o civil!");
        oni.atacar(bob); 

        // --- TURNO 4: Habilidades Especiais
        System.out.println("\n--- TURNO 4 ---\n");
        oni.usarHabilidadeEspecial(cassandra);
        cassandra.usarHabilidadeEspecial(oni);


        System.out.println("\n=== Status Final dos Personagens ===\n");

        exibirStatus(cassandra);
        exibirStatus(oni);
        exibirStatus(bob);
        
        System.out.println("\n=== FIM DA SIMULAÇÃO ===\n");
    }

    public static void exibirStatus(Personagem p) {
        System.out.println(String.format("[%s] Vida: %d | Energia: %d", 
            p.getNome(), p.getVida(), p.getEnergia()));
    }
}