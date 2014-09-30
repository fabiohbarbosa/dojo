package com.wordpress.fabiohbarbosa.dojo.jogodavida;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class JogoDaVidaTest {
	private boolean[][] tabuleiro;
	private JogoDaVida jogoDaVida;
	
	@Before
	public void setUp() {
		tabuleiro = new boolean[10][10];
		jogoDaVida = new JogoDaVida(tabuleiro);
	}
	
	@Test
	public void celulaDeveEstarMortaPorBaixaPopulacaoComMenosDeDoisVizinhos() {
		int x = 0;
		int y = 0;
		
		boolean viva = jogoDaVida.verificarSituacaoCelula(x, y);
		assertFalse(viva);
	}
	
	@Test
	public void celulaDeveEstarMortaPorAltaPopulacaoComMaisDeTresVizinhos() {
		int x = 0;
		int y = 0;
		
		boolean viva = jogoDaVida.verificarSituacaoCelula(x, y);
		assertFalse(viva);
	}
}
