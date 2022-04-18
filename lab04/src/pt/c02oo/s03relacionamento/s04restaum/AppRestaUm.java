package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo("commands.csv", "results.csv");
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      Tabuleiro tabuleiro = new Tabuleiro();
      Peca[] pecas = new Peca[32];
      int i = 0;
      for (int linha = 1; linha < 8; linha++) {
    	  for (int coluna = 65; coluna < 72; coluna++) {
    		  if(linha <= 2 && coluna >= 67 && coluna <= 69) {
    			  String posicao = "";
    			  posicao += (char)coluna;
    			  posicao += (char)(linha+'0');
    			  pecas[i] = new Peca(posicao);
    			  i++;
    		  }
    		  else if(linha == 3 || linha == 5) {
    			  String posicao = "";
    			  posicao += (char)coluna;
    			  posicao += (char)(linha+'0');
    			  pecas[i] = new Peca(posicao);
    			  i++;
    		  }
    		  else if(linha == 4 && coluna != 68) {
    			  String posicao = "";
    			  posicao += (char)coluna;
    			  posicao += (char)(linha+'0');
    			  pecas[i] = new Peca(posicao);
    			  i++;
    		  }
    		  if(linha >= 6 && coluna >= 67 && coluna <= 69) {
    			  String posicao = "";
    			  posicao += (char)coluna;
    			  posicao += (char)(linha+'0');
    			  pecas[i] = new Peca(posicao);
    			  i++;
    		  }
    	  }
      }
      
      for (int j = 0; j < 32; j++) {
    	  tabuleiro.conecta(pecas[j], j);
    	  pecas[j].conecta(tabuleiro);
      }
      
      tk.writeBoard("Tabuleiro inicial", tabuleiro.retornaTabuleiro());
      for (int l = 0; l < commands.length; l++) {
    	  String[] origemDestino = commands[l].split(":");
    	  tabuleiro.movimentaPeca(origemDestino[0], origemDestino[1]);
    	  tk.writeBoard("source: " + origemDestino[0] + ";target: " + origemDestino[1], tabuleiro.retornaTabuleiro());
      }
      
      tk.stop();
   }

}
