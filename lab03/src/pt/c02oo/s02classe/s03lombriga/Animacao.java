package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String anima;
	AquarioLombriga lombriga;
	int passoAtual;

	public Animacao(String anima) {
		this.anima = anima.substring(6);
		int tamAquario = Integer.parseInt(anima.substring(0, 2));
		int tamLombriga = Integer.parseInt(anima.substring(2, 4));
		int posicaoIni = Integer.parseInt(anima.substring(4, 6));
		this.lombriga = new AquarioLombriga(tamAquario, tamLombriga, posicaoIni);
		this.passoAtual = 0;
	}

	public String apresenta() {
		return lombriga.apresenta();
	}
	
	public void passo() {
		char instrucao = anima.charAt(passoAtual);
		passoAtual++;
		if(instrucao == 'C')
			lombriga.crescer();
		else if (instrucao == 'M')
			lombriga.mover();
		else if (instrucao == 'V')
			lombriga.virar();
	}
}
