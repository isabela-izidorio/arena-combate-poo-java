public class Demonio extends Personagem implements Lutador {

    private int nivelMaldade;

    // Métodos acessores
    public int getNivelMaldade() {
        return nivelMaldade;
    }
    public void setNivelMaldade(int nivelMaldade) {
        
        this.nivelMaldade = Math.max(1, Math.min(10, nivelMaldade));
        
        if (nivelMaldade < 1 || nivelMaldade > 10) {
            System.out.println("- Nível de maldade ajustado para os limites permitidos (1-10).");
        }
    }

    // Construtor
    public Demonio(String nome, int nivelMaldade) {
        super(nome);
        this.nivelMaldade = nivelMaldade;
    }

    // Outros métodos

    @Override
    public void atacar(Personagem alvo) {

        // Dano aumenta se a vida do demônio estiver baixa -> >30 (Fúria)
        int bonusFuria = (getVida() < 30) ? 10 : 0;

        if(bonusFuria > 0){
            System.out.println(getNome() + " ataca " + alvo.getNome() + " com fúria sombria!");
        } else{
            System.out.println(getNome() + " ataca " + alvo.getNome() + "!");}

        alvo.receberDano(15 + nivelMaldade + bonusFuria);
        gastarEnergia(15);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println(getNome() + " invoca Habilidade do Sacrifício Sombrio!");
        alvo.receberDano(45);
        this.receberDano(10); // Demônio se machuca para causar mais dano
    }

    @Override public void defender() {
        this.estaDefendendo = true;
    }

}