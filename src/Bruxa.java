public class Bruxa extends Personagem implements Lutador {

    private String elemento;

    // Métodos acessores
    public String getElemento() {
        return elemento;
    }
    public final void setElemento(String elemento) {
        if (elemento.equalsIgnoreCase("Fogo") || 
            elemento.equalsIgnoreCase("Água") || 
            elemento.equalsIgnoreCase("Terra") || 
            elemento.equalsIgnoreCase("Ar") || 
            elemento.equalsIgnoreCase("Éter")) {
            
            this.elemento = elemento;
        } else {
            System.out.println("- Elemento '" + elemento + "' inválido! Definindo 'Éter' por padrão.");
            this.elemento = "Éter"; // Valor padrão para evitar atributos nulos
        }
    }

    // Construtor
    public Bruxa(String nome, String elemento) {
        super(nome);
        this.setElemento(elemento);
    }

    // Outros métodos

    public void defenderTerceiro(Personagem alvo) {
        if (this.getEnergia() >= 20) {
            System.out.println(this.getNome() + " lança um escudo de " + elemento + " sobre " + alvo.getNome() + "!");
            
            // Ativa a defesa do alvo, mesmo que o alvo não seja um Lutador
            alvo.setEstaDefendendo(true); 
            
            this.gastarEnergia(20);
        } else {
            System.out.println(this.getNome() + " está exausta demais para proteger alguém!");
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " conjura " + elemento + " contra " + alvo.getNome());
        gastarEnergia(10);
        alvo.receberDano(15);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (getEnergia() >= 40) {

            System.out.println(getNome() + " usa Habilidade de Dreno de Alma!");
            gastarEnergia(40);
            alvo.receberDano(30);

            // Bruxa se cura um pouco
            receberDano(-10); // "Dano negativo" funciona como cura
        }
    }

    @Override
    public void defender(){
        this.estaDefendendo = true;
    }
}