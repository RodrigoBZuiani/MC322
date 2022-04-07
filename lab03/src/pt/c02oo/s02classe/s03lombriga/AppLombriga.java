package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

	public static void main(String[] args) {
		Toolkit tk = Toolkit.start();
      
		String lombrigas[] = tk.recuperaLombrigas();
      
		for (int i = 0; i < lombrigas.length; i++) {
			tk.gravaPasso("=====");
			Animacao ani = new Animacao(lombrigas[i]);
			tk.gravaPasso(ani.apresenta());
			for (int j = 0; j < lombrigas[i].substring(6).length(); j++) {
				ani.passo();
				tk.gravaPasso(ani.apresenta());
			}
		}
      
		tk.stop();
	}

}
