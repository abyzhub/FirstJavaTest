package com.algorithm.test;


public class GameOfLife {

	private GameOfLifeMatrix doProcess(GameOfLifeMatrix input){
		input.printMatrix();
		GameOfLifePlay play=new GameOfLifePlay();
		return play.tick(input);
	}

	public GameOfLifeMatrix doProcess(char[][] input){
		GameOfLifeMatrix inputSeed= new GameOfLifeMatrix(input);
		return doProcess(inputSeed);
	}

	public static void main(String[] args) {
		char[][] seed = new char[][]{{'-','x','-'},
					 			 	 {'-','x','-'},
					 			 	 {'-','x','-'}};
//		char[][] seed = new char[][]{{'-','-','-','-','-','-'},
//									 {'-','x','x','-','-','-'},
//									 {'-','x','x','-','-','-'},
//									 {'-','-','-','x','x','-'},
//									 {'-','-','-','x','x','-'},
//			 	 					 {'-','-','-','-','-','-'}};
//		char[][] seed = new char[][]{{'-','x','x','x'},
//									 {'x','x','x','-'}};
//		char[][] seed = new char[][]{{'-','-','x'},
//									 {'x','-','x'},
//									 {'-','x','x'}};
		
		GameOfLife game= new GameOfLife();
		GameOfLifeMatrix input= new GameOfLifeMatrix(seed);
		GameOfLifeMatrix output= game.doProcess(input);
		output.printMatrix();
	}
}
