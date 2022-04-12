/* A classe apresenta os m�todos sacar e depositar.
 * O m�todo sacar apresenta algumas condi�oes.
 * O destaque fica para a condi�ao do saque ser menor ou igual a saldo+limite,
 * caso a retirada tenha um valor menor ou igual a zero o saldo � atualizado
 * para zero, nessa mesma l�gica ao atualizar o limite, usa-se o resultado negativo
 * da retirada para tirar do limite, como toda vez vai ser um valor negativo
 * � preciso somar o valor negativo para subtrair do limite e atualiza-lo.
 * 
 * O modificador de acesso public torna publico o determinado objeto, as classes os
 * construtores sempre s�o public.
 * Os atributos podem ser public, private, protected.
 * Dizer que uma classe, construtor ou atributo � p�blic quer dizer que podem ser
 * acessados em todo o projeto.
 * Normalmente todos os atributos de uma classe s�o privados.
 * 
 * O private torna aquele atributo exclusivo da classe, ou seja, somente
 * a classe pode acessar e modificar ela, n�o se pode importar para outra classe
 * mesmo estando no mesmo projeto.*/

package br.geekuniversity.secao11;

import br.geekuniversity.secao11.Cliente;
import br.geekuniversity.secao11.Conta;

@SuppressWarnings("unused")
public class Conta {
	private int conta;
	private float saldo, limite;
	private Cliente cliente;

	public Conta(int conta, float saldo, float limite, Cliente cliente) {
		this.conta = conta;
		this.saldo = saldo;
		this.limite = limite;
		this.cliente = cliente;
	}

	// ----------------------------------//
	public Conta() {
	}

	// ----------------------------------//
	/**
	 * M�todo para sacar
	 * 
	 * @param valor de saque
	 */
	public void sacar(float saque) {
		if (saque <= (this.saldo)) {
			this.saldo = this.saldo - saque;
			System.out.println("Saque realizado");

		} else if (saque <= (this.saldo + this.limite)) {
			float retirada = this.saldo - saque;
			if (retirada <= 0) {
				this.saldo = 0;
			}
			retirada = this.limite + retirada;
			this.limite = retirada;

		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	// ----------------------------------//
	/**
	 * Metodo para deposito
	 * 
	 * @param valor de deposito
	 */
	public void depositar(float deposito) {
		/*Forma 01 de sincroniza��o*/
		synchronized(this) {
			this.saldo = this.saldo + deposito;
		}
	}
	/*Forma 02 de sincroniza��o
	 * public synchronized void depositar(float valor){
	 * 		this.saldo = this.saldo+valor;
	 * }*/

	// ----------------------------------//
	/**
	 * Metodo para mostrar o saldo
	 * 
	 * @return valor atual
	 */
	public float getSaldo() {
		return this.saldo + this.limite;
	}

	/**
	 * Metodo para mostrar o limite
	 * 
	 * @return limite atual
	 */
	public float getLimite() {
		return this.limite;
	}

	@Override
	public String toString() {
		return "O saldo da conta �: " + this.getSaldo();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Conta)) {
			return false;
		} else {
			Conta verificar = (Conta) obj;// Cast, trabalho com o obj como se fosse uma conta
			return verificar.getSaldo() == this.getSaldo();
		}
	}
}
