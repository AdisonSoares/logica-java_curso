/*A fun��o toString retorna, por padr�o o endere�o de mem�ria
 *referenciado da classe.*/

package br.geekuniversity.secao12;

//Classe abstrata
public abstract class Pessoa {
	private String nome;
	private int ano_nascimento;
	private String email;
	
	//M�todo construtor
	public Pessoa(String nome, int ano_nascimento, String email) {
		this.nome = nome;
		this.ano_nascimento = ano_nascimento;
		this.email = email;
	}
	public Pessoa() {}
	
	//M�todos Get e Set
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}
	public int getAnoNascimento() {
		return this.ano_nascimento;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAnoNascimento(int ano_nascimento) {
		this.ano_nascimento = ano_nascimento;
	}
	
	//M�todo toString
	public String toString() {
		return "Nome: "+this.nome+"\nAno Nascimento: "+this.ano_nascimento;
	}
	
	//Declara��o de um m�todo abstrato
	public abstract void outra_mensagem(String texto);
	
}
