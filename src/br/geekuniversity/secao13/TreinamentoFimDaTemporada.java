/*Os m�todos da classe abstrata s�o obrigatorios para as classes filhas.*/

package br.geekuniversity.secao13;

import br.geekuniversity.secao13.Treinamento;

@SuppressWarnings("unused")
public class TreinamentoFimDaTemporada extends Treinamento{
	
	//M�todos da classe abstrata, sobrescrita/override.
	@Override
	public void preparoFisico() {
		System.out.println("Preparo f�sico de fim da temporada");
	}
	@Override
	public void jogoTreino() {
		System.out.println("Jogo treino de fim da temporada");
	}

}
