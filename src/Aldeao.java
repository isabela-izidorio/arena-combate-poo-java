public class Aldeao extends Personagem {  // Personagem passivo

    private String profissao;

    // Métodos acessores
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        if (profissao.equalsIgnoreCase("Ferreiro") || 
            profissao.equalsIgnoreCase("Carpinteiro")) {
            
            this.profissao = profissao;
        } else {
            System.out.println("- Profissao '" + profissao + "' inválida! Definindo 'Ferreiro' por padrão.");
            this.profissao = "Ferreiro"; // Valor padrão para evitar atributos nulos
        }
    }

    // Construtor
    public Aldeao(String nome, String profissao) {
        super(nome);
        this.profissao = profissao;
    }

    // Outros métodos
    public void interagir() {
        System.out.println(getNome() + " (" + profissao + "): 'Olá, Estou só de passagem! Não procuro briga por aqui...");
    }
}