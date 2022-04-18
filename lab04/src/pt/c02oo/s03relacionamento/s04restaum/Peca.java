package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	
	private Tabuleiro tabuleiro;
	public String posicao;
	public boolean capturada;
	
	public Peca(String posicao) {
		this.posicao = posicao;
		this.capturada = false;
	}
	
	public void conecta(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	private boolean moveValido(String origem, String destino, int tipoMov) {
		char colunaOrigem = origem.charAt(0);
		char linhaOrigem = origem.charAt(1);
		char colunaDestino = destino.charAt(0);
		char linhaDestino = destino.charAt(1);
		
		int difColuna = (int)colunaOrigem - (int)colunaDestino;
		int difLinha = (int)linhaOrigem - (int)linhaDestino; 
		
		if((int)colunaDestino < 65 || (int)colunaDestino > 71 || Character.getNumericValue(linhaDestino) < 1 || Character.getNumericValue(linhaDestino) > 7) {
			return false;
		}
		else if((Character.getNumericValue(linhaDestino) <= 2 || Character.getNumericValue(linhaDestino) >= 6) && ((int)colunaDestino <= 66 || (int)colunaDestino >= 70)) {
			return false;
		}
		else if(difColuna < -2 || difColuna > 2 || difLinha < -2 || difLinha > 2) {
			return false;
		}
		else if(tabuleiro.destinoVazio(destino) == false) {
			return false;
		}
		else if(tabuleiro.existePecaPulada(origem, destino, tipoMov) == false) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void move(String origem, String destino) {
		int tipoMov; //0 - Vertical; 1 - Horizontal;
		if(origem.charAt(0) == destino.charAt(0))
			tipoMov = 0;
		else
			tipoMov = 1;
		
		if(moveValido(origem, destino, tipoMov) == true) {
			this.posicao = destino;
		}
	}
	
}
