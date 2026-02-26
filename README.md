## Apresentação

Simulador de combate por turnos construído em Java, focado na aplicação prática de POO: Herança, Polimorfismo, Interfaces e Encapsulamento.
Projeto de estudo.

## Regras de Negócio e Dinâmicas

### Núcleo de Personagem (Base)

* Gestão de Recursos: Todos iniciam com 100 de Vida e 100 de Energia.

* Integridade de Dados: Vida e Energia não recebem valores negativos.

* Mecânica de Dano: Personagens em estado de defesa reduzem o dano recebido em 50%. Após sofrer o ataque, a defesa é resetada automaticamente.

### Especializações (Lutadores)

* ####  Bruxa (Elemental/Suporte):

Restrição: Só pode operar um dos 5 elementos (Fogo, Água, Terra, Ar, Éter).

Habilidade Única: Pode gastar energia para defender qualquer outro personagem (mesmo não-lutadores).

Auto-cura: Sua habilidade especial causa dano e recupera sua própria vida (Dreno de Alma).

* ####  Demônio (Ofensivo/Risco):

Escalabilidade: O dano aumenta conforme seu Nível de Maldade (limitado de 1 a 10).

Estado de Fúria: Quando a vida cai abaixo de 30, ganha um bônus de +10 de dano.

Sacrifício: Seu especial causa dano massivo, mas consome a própria vida do Demônio.

* ####  Personagens Passivos

Aldeão: Não possui habilidades de combate (não implementa a interface Lutador). Sua interação é limitada a diálogos e profissões específicas (Ferreiro/Carpinteiro).


## Diagrama de Classes

```text
                    +-----------------------+
                    |     <<Abstract>>      |
                    |      Personagem       | 
                    +-----------------------+
                    | - nome: String        |
                    | - vida: int           |
                    | - energia: int        |
                    | - estaDefendendo: bln |
                    +-----------------------+
                    | + receberDano()       |
                    | + gastarEnergia()     |
                    +-----------+-----------+
                                |
        ________________________|________________________
       |                        |                        |
 (Herança)                (Herança)                (Herança)
       |                        |                        |
+--------------------+   +--------------------+   +-----------------+
|        Aldeao      |   |        Bruxa       |   |     Demonio     |
+--------------------+   +--------------------+   +-----------------+
| - profissao: String|   | - elemento: String |   | - maldade: int  |
+--------------------+   +--------------------+   +-----------------+
| + interagir()      |   | +defenderTerceiro()|   |                 |
+--------------------+   +-----+--------------+   +-----+-----------+
                               |                        |
                               |      (Implementam)     |
                               \___________  ___________/
                                           |
                                           v
                                +-----------------------+
                                |     <<Interface>>     |
                                |        Lutador        |
                                +-----------------------+
                                | + atacar(alvo)        |
                                | + usarEspecial(alvo)  |
                                | + defender()          |
                                +-----------------------+

