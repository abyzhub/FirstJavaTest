package com.algorithm.junit;

import org.junit.Test;

import com.algorithm.test.GameOfLife;
import com.algorithm.test.GameOfLifeMatrix;

import junit.framework.TestCase;

public class GameOfLifeTestSuite extends TestCase {
	@Test public void testBlockPattern(){
		char[][] seed = new char[][]{{'x','x'},
									 {'x','x'}};
		GameOfLifeMatrix result=(new GameOfLife()).doProcess(seed);
		assertNotNull(result);
		result.printMatrix();

	}
	@Test public void testBoatPattern(){
		char[][] seed = new char[][]{{'x','x','-'},
									 {'x','-','x'},
									 {'-','x','-'}};
		GameOfLifeMatrix result=(new GameOfLife()).doProcess(seed);
		assertNotNull(result);
		result.printMatrix();
	}
	@Test public void testBlinkerPattern(){
		char[][] seed = new char[][]{{'-','x','-'},
									 {'-','x','-'},
									 {'-','x','-'}};
		GameOfLifeMatrix result=(new GameOfLife()).doProcess(seed);
		assertNotNull(result);
		result.printMatrix();
	}
	@Test public void testToadPattern(){
		char[][] seed = new char[][]{{'-','x','x','x'},
									 {'x','x','x','-'}};
		GameOfLifeMatrix result=(new GameOfLife()).doProcess(seed);
		assertNotNull(result);
		result.printMatrix();
	}
}
