package org.entdes.todolist;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodolistApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testTasca() {
		Tasca tasca = new Tasca("Test Tasca");
		assertEquals("Test Tasca", tasca.getDescripcio());
		assertFalse(tasca.isCompletada());

		tasca.setCompletada(true);
		assertTrue(tasca.isCompletada());
		assertEquals("Test Tasca: Completada", tasca.toString());
		tasca.setCompletada(false);
		assertFalse(tasca.isCompletada());
		assertEquals("Test Tasca: Pendent", tasca.toString());
	}

	@Test
	void testGestorTasques() {
		GestorTasques gestor = new GestorTasques();
		gestor.afegirTasca("Tasca 1");
		gestor.afegirTasca("Tasca 2");

		assertEquals(2, gestor.llistarTasques().size());

		gestor.marcarCompletada("Tasca X");
		assertTrue(!gestor.llistarTasques().get(0).isCompletada());
		assertTrue(!gestor.llistarTasques().get(1).isCompletada());


		gestor.marcarCompletada("Tasca 1");
		assertTrue(gestor.llistarTasques().get(0).isCompletada());

		gestor.marcarCompletada("Tasca 2");
		assertTrue(gestor.llistarTasques().get(1).isCompletada());

		gestor.eliminarTasca("Tasca 2");
		assertEquals(1, gestor.llistarTasques().size());
	}
}
