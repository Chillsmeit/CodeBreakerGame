package io.codeforall.gameJam.position;
public class ChallengesDaresRewards {
    private String[] challenges = {
      "Diz algo que ninguém sabe sobre ti",
      "Dá um beijo na cabeça do careca mais próximo",
      "Faz uma moeda ressaltar de uma mes para dentro de um copo",
      "Faz a coisa mais atletica que consegues, todos os participantes votam yes or no se tiveres mais no's bebe um copo",
      "Tens 30 segundos para falar algo com a boca cheia de água ou cerveja, se não perceberem engole e bebe mais um copo",
      "Escolhe alguém para criar um aperto de mão secreto contigo, se não conseguirem bebam os dois",
      "recita um poema senão bebe um copo",
      "Todo mundo diz algo de que se arrepende de ter feito, quem tem a pior história bebe um copo",
      "Dança por cima de uma mesa senão bebe um copo",
      "Diz uma frase famosa de um filme se não adivinharem o filme bebe um copo",
      "Mimica se não descobrirem a tua mímica todos bebem um copo"
    };
    private String[] penalties = {
       "Não podes fugir, bebe um copo",
       "Anda com as mãos nos pés, 20 passos",
       "Bebe um copo sem usar as mãos",
       "Bebe o número de copos que calhou nos dados, good luck",
       "Walk the dog ou carrinho de mão humano, 20 passos",
       "Não digas nada por duas Jogadas senão bebes dois copos",
       "Equilibra um copo (de plástico plz) cheio por cima de tua cabeça por 1 minuto",
       "Equilibra-te em uma perna por 5 jogadas",
       "Todos bebem, agradeçam ao jogador que caiu nesta casa",
       "Bebe um copo e escolhe dois jogadores para beberem também"
    };
    private String[] rewards = {
       "Escolhe alguém para beber",
       "Tens Um passe podes passar um desafio",
       "Podes dizer não a um penalty",
       "Podes lançar o dado novamente",
       "Escolhe duas pessoas para beberem",
       "Cria um desafio para alguém (não podes recuar casas)"
    };

    private String zuka = "Dança a Lapada Dela com o Zuka, se ele não tiver presente dança sozinho";
    private String mic = "Canta uma música da escolha do Mic, se ele não estiver presente canta uma da tua escolha";
    private String mariana = "Durante as próximas cinco jogadas sempre que falares tens de dar um conselho senão bebe um copo";

    public String getRewards() {
        return rewards[(int)(Math.random()*(rewards.length-1))];
    }

    public String getChallenges() {
        return challenges[(int)(Math.random()*(challenges.length-1))];
    }

    public String getPenalties() {
        return penalties[(int)(Math.random()* (penalties.length-1))];
    }

    public String getZuka() {
        return zuka;
    }

    public String getMic() {
        return mic;
    }

    public String getMariana() {
        return mariana;
    }
}
