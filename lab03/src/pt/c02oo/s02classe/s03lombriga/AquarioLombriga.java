package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamAquario, tamLombriga, posicao, orientacao;
    
    public AquarioLombriga(int tamAquario, int tamLombriga, int posicaoIni) {
        this.tamAquario = tamAquario;
        if(tamLombriga > tamAquario)
        	this.tamLombriga = tamAquario;
        else
        	this.tamLombriga = tamLombriga;
        if(posicaoIni < 1 || posicaoIni + tamLombriga - 1 > tamAquario)
        	this.posicao = 1;
        else
        	this.posicao = posicaoIni;
        this.orientacao = 1;
    }
    
    public void crescer() {
    	if(orientacao == 1 && posicao + tamLombriga - 1 < tamAquario)
    		tamLombriga++;
    	else if(orientacao == 2 && posicao - tamLombriga + 1 > 1)
    		tamLombriga++;
    }
    
    public void mover() {
    	if(orientacao == 1) {
    		if(posicao > 1)
    			posicao--;
    		else
    			virar();
    	}
    	else {
    		if(posicao < tamAquario)
    			posicao++;
    		else
    			virar();
    	}
    }
    
    public void virar() {
    	if(orientacao == 1) {
    		orientacao = 2;
    		posicao = posicao + tamLombriga - 1;
    	}
    	else {
    		orientacao = 1;
    		posicao = posicao - tamLombriga + 1;
    	}
    }
    
    public String apresenta() {
    	String mostra = "";
    	if(orientacao == 1) {
    		if(tamLombriga == tamAquario) {
    			mostra += "O";
    			for(int i = 1; i < tamLombriga; i++)
    				mostra += "@";
    		}
    		else {
    			for(int i = 1; i < posicao; i++)
    				mostra += "#";
    			mostra += "O";
    			for(int i = 1; i < tamLombriga; i++)
    				mostra += "@";
    			while(mostra.length() < tamAquario)
    				mostra += "#";
    		}
    	}
    	else {
    		if(tamLombriga == tamAquario) {
    			for(int i = 1; i < tamLombriga; i++)
    				mostra += "@";
    			mostra += "O";
    		}
    		else {
    			int distancia = posicao - tamLombriga;
    			for(int i = 0; i < distancia; i++)
    				mostra += "#";
    			for(int i = 1; i < tamLombriga; i++)
    				mostra += "@";
    			mostra += "O";
    			while(mostra.length() < tamAquario)
    				mostra += "#";
    		}
    	}
    	return mostra;
    }
}
