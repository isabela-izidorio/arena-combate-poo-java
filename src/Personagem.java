public abstract class Personagem {
    private String nome;
    private int vida;
    private int energia;
    protected boolean estaDefendendo; 

    // Métodos acessores

    public String getNome(){
        return nome;
    }
    public int getVida(){
        return vida;
    }
    public int getEnergia(){
        return energia;
    }
    public boolean getEstaDefendendo(){
        return estaDefendendo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setVida(int vida) {
        if(vida<0){
            this.vida = 0;
        }else{
            this.vida = vida;
        }
    }
    public void setEnergia(int energia) {
        if(energia<0){
            this.energia = 0;
        }else{
            this.energia = energia;
        }
    }
    public void setEstaDefendendo(boolean estaDefendendo) {
        this.estaDefendendo = estaDefendendo;
    }


    // construtor
    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.energia = 100;
        this.estaDefendendo = false;
    }


    public void receberDano(int danoOriginal) {

        int danoFinal = estaDefendendo ? danoOriginal / 2 : danoOriginal; // Se estiver defendendo o dano original é dividido por 2

        this.vida = Math.max(0, this.vida - danoFinal);
        
        System.out.println(nome + " sofreu " + danoFinal + " de dano!");

        if (estaDefendendo) {
            System.out.println("A defesa mitigou parte do impacto!");
            estaDefendendo = false; // Reseta a defesa depois do ataque
        }

        if (this.vida <= 0)
            System.out.println(nome + " foi derrotado!");
    }

    public void gastarEnergia(int custo) {
        this.energia = Math.max(0, this.energia - custo);
    }

    
}