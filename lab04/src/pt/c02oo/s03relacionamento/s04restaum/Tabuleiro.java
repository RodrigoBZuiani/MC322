package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	
	private Peca[] pecas = new Peca[32];
	private int numPecas;
	
	public Tabuleiro() {
		this.numPecas = 32;
	}
	
	public void conecta(Peca peca, int index) {
		this.pecas[index] = peca;
	}
	
	private boolean existePeca(String posicao) {
		for(int i = 0; i < numPecas; i++)
			if(pecas[i].posicao.equals(posicao) && pecas[i].capturada == false)
				return true;
		return false;
	}
	
	public boolean destinoVazio(String destino) {
		if(existePeca(destino))
			return false;
		return true;
	}
	
	public boolean existePecaPulada(String origem, String destino, int tipoMov) {
		boolean existe = false;
		String meio = "";
		if(tipoMov == 0) { //Vertical
			meio += origem.charAt(0);
			char linhaMeio = (char)(((int)origem.charAt(1) + (int)destino.charAt(1)) / 2);
			meio += linhaMeio;
			if(existePeca(meio)) {
				capturaPeca(meio);
				existe = true;
			}
		}
		else if(tipoMov == 1) { //Horizontal
			char colunaMeio = (char)(((int)origem.charAt(0) + (int)destino.charAt(0)) / 2);
			meio += colunaMeio;
			meio += origem.charAt(1);
			if(existePeca(meio)) {
				capturaPeca(meio);
				existe = true;
			}
		}
		return existe;
	}
	
	public void movimentaPeca(String origem, String destino) {
		for(int i = 0; i < numPecas; i++) {
			if(pecas[i].posicao.equals(origem.toUpperCase()) && pecas[i].capturada == false)
				pecas[i].move(origem.toUpperCase(), destino.toUpperCase());
		}
	}
	
	private void capturaPeca(String pecaPulada) {
		for(int i = 0; i < numPecas; i++) {
			if(pecas[i].posicao.equals(pecaPulada) && pecas[i].capturada == false)
				pecas[i].capturada = true;
		}
	}
	
	public char[][] retornaTabuleiro() {
		char[][] tabuleiro = new char[7][7];
		for (int linha = 0; linha < 7; linha++) {
			for (int coluna = 0; coluna < 7; coluna++) {
				if((linha <= 1 || linha >= 5) && (coluna <= 1 || coluna >= 5))
					  tabuleiro[linha][coluna] = ' ';
				else {
					String posicao = "";
					posicao += (char)(coluna + 65);
					posicao += (char)((linha + 1) + '0');
					if(existePeca(posicao))
						tabuleiro[linha][coluna] = 'P';
					else
						tabuleiro[linha][coluna] = '-';
				}
			}
		}
		return tabuleiro;
	}

}
