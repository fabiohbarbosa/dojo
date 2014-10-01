package com.wordpress.fabiohbarbosa.dojo.jogodavida;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JogoDaVidaTest {
	private final int totalLinhas = 10;
	private final int totalColunas = 5;
	
	private JogoDaVida jogoDaVida;
	
	public JogoDaVidaTest() {
		jogoDaVida = new JogoDaVida(totalLinhas, totalColunas);
	}
	
	@Test
	public void celulaVivaDeveMorrerPorBaixaPopulacao() {
		int linha = 0;
		int coluna = 1;
		
		jogoDaVida.adicionarVizinho(0, 0);
		
		boolean viva = jogoDaVida.movimentarCelula(true, linha, coluna);
		assertFalse(viva);
	}
	
	@Test
	public void celulaVivaDeveMorrerPorAltaPopulacao() {
		int linha = 1;
		int coluna = 1;
		
		jogoDaVida.adicionarVizinho(1, 0);
		jogoDaVida.adicionarVizinho(1, 2);
		jogoDaVida.adicionarVizinho(0, 1);
		jogoDaVida.adicionarVizinho(2, 1);
		
		boolean viva = jogoDaVida.movimentarCelula(true, linha, coluna);
		assertFalse(viva);
	}
	
	@Test
	public void celulaVivaDevePermanecerVivaParaProximaGeracao() {
		int linha = 1;
		int coluna = 1;
		
		jogoDaVida.adicionarVizinho(1, 0);
		jogoDaVida.adicionarVizinho(1, 2);
		
		boolean viva = jogoDaVida.movimentarCelula(true, linha, coluna);
		assertTrue(viva);
	}
	
	@Test
	public void celulaMortaDeveSeTransformarEmCelulaVivaComTresCelulasVizinhas() {
		int linha = 1;
		int coluna = 1;
		
		jogoDaVida.adicionarVizinho(1, 0);
		jogoDaVida.adicionarVizinho(1, 2);
		jogoDaVida.adicionarVizinho(0, 1);
		
		boolean viva = jogoDaVida.movimentarCelula(false, linha, coluna);
		assertTrue(viva);
	}
	
	@Test
	public void celulaVivaSemNenhumVizinhoDeveMorrer() {
		int linha = 1;
		int coluna = 1;
		
		boolean viva = jogoDaVida.movimentarCelula(true, linha, coluna);
		assertFalse(viva);
	}
	
	@Test
	public void celulaMortaDevePermanecerMortaComDuasCelulasVizinhas() {
		int linha = 1;
		int coluna = 1;
		
		jogoDaVida.adicionarVizinho(1, 0);
		jogoDaVida.adicionarVizinho(1, 2);
		
		boolean viva = jogoDaVida.movimentarCelula(false, linha, coluna);
		assertFalse(viva);
	}
	
	@Test
	public void celulaDeveEstarMortaUmVizinhoADireita() {
		int linha = 0;
		int coluna = 0;

		jogoDaVida.adicionarVizinho(0, 1);
		
		boolean viva = jogoDaVida.verificarCelulaViva(linha, coluna);
		assertFalse(viva);
	}
	
	@Test
	public void celulaDeveEstarMortaComQuatroVizinhos() {
		int linha = 2;
		int coluna = 2;
		
		jogoDaVida.adicionarVizinho(1, 2);
		jogoDaVida.adicionarVizinho(2, 1);
		jogoDaVida.adicionarVizinho(2, 3);
		jogoDaVida.adicionarVizinho(3, 2);
		
		boolean viva = jogoDaVida.verificarCelulaViva(linha, coluna);
		assertFalse(viva);
	}
	
	@Test
	public void celulaDeveEstarVivaComDoisVizinhosNasLaterais() {
		int linha = 3;
		int coluna = 3;
		
		jogoDaVida.adicionarVizinho(3, 2);
		jogoDaVida.adicionarVizinho(3, 4);
		
		boolean viva = jogoDaVida.verificarCelulaViva(linha, coluna);
		assertTrue(viva);
	}
	
	@Test
	public void celulaDeveEstarMortaParaPosicao21ComQuatroVizinhos() {
		int linha = 2;
		int coluna = 1;
		
		jogoDaVida.adicionarVizinho(1, 1);
		jogoDaVida.adicionarVizinho(2, 0);
		jogoDaVida.adicionarVizinho(2, 2);
		jogoDaVida.adicionarVizinho(3, 1);
		
		boolean viva = jogoDaVida.verificarCelulaViva(linha, coluna);
		assertFalse(viva);
	}
	
	@Test
	public void deveRetornarDoisVizinhos() {
		int linha = 3;
		int coluna = 3;
		
		jogoDaVida.adicionarVizinho(3, 2);
		jogoDaVida.adicionarVizinho(3, 4);
		
		int vizinhos = jogoDaVida.retonarQuantidadeDeVizinhos(linha, coluna);
		assertEquals(2, vizinhos);
	}	
	
	@Test
	public void deveRetornarQuatroVizinhos() {
		int linha = 2;
		int coluna = 2;
		
		jogoDaVida.adicionarVizinho(1, 2);
		jogoDaVida.adicionarVizinho(2, 1);
		jogoDaVida.adicionarVizinho(2, 3);
		jogoDaVida.adicionarVizinho(3, 2);
				
		int vizinhos = jogoDaVida.retonarQuantidadeDeVizinhos(linha, coluna);
		assertEquals(4, vizinhos);
	}
	
	@Test
	public void deveRetornarDoisVizinhosParaPrimeiraColunaPrimeiraLinha() {
		int linha = 0;
		int coluna = 0;
		
		jogoDaVida.adicionarVizinho(0, 1);
		jogoDaVida.adicionarVizinho(1, 0);
		
		int vizinhos = jogoDaVida.retonarQuantidadeDeVizinhos(linha, coluna);
		assertEquals(2, vizinhos);
	}
	
	@Test
	public void deveRetornarDoisVizinhosParaPrimeiraColunaUltimaLinha() {
		int linha = 0;
		int coluna = 4;
		
		jogoDaVida.adicionarVizinho(0, 3);
		jogoDaVida.adicionarVizinho(1, 4);
		
		int vizinhos = jogoDaVida.retonarQuantidadeDeVizinhos(linha, coluna);
		assertEquals(2, vizinhos);
	}
	
	@Test
	public void deveRetornarDoisVizinhosParaUltimaLinhaUltimaColuna() {
		int linha = 9;
		int coluna = 4;
		
		jogoDaVida.adicionarVizinho(9, 3);
		jogoDaVida.adicionarVizinho(8, 4);
		
		int vizinhos = jogoDaVida.retonarQuantidadeDeVizinhos(linha, coluna);
		assertEquals(2, vizinhos);
	}
	
	@Test
	public void deveRetornarDoisVizinhosParaUltimaLinhaPrimeiraColuna() {
		int linha = 9;
		int coluna = 0;
		
		jogoDaVida.adicionarVizinho(8, 0);
		jogoDaVida.adicionarVizinho(9, 1);
		
		int vizinhos = jogoDaVida.retonarQuantidadeDeVizinhos(linha, coluna);
		assertEquals(2, vizinhos);
	}
}
