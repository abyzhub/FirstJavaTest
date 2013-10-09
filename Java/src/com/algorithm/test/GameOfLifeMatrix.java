package com.algorithm.test;

public class GameOfLifeMatrix {
	private char[][] matrix;
	private int rows;
	private int cols;
	
	public enum Grow{
		LEFT, RIGHT, TOP, BOTTOM
	}
	
	
	
	public GameOfLifeMatrix(char[][] matrix) {
		this.matrix=matrix;
		rows=matrix.length;
		cols=matrix[0].length;		
	}

	public char getValAt(int row, int col){
		return matrix[row][col];
	}
	
	public GameOfLifeMatrix deepCopy(){
		char[][] target=new char[rows][cols];
		for(int row=0;row<rows;row++){
			for(int col=0;col<cols;col++){
				target[row][col]=matrix[row][col];
			}
		}
		return new GameOfLifeMatrix(target);
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public void printMatrix(){
		StringBuilder rowVal=new StringBuilder();
		for(int row=0;row<rows;row++){
			for(int col=0;col<cols;col++){
				try{
					rowVal.append(matrix[row][col]);
				}catch(ArrayIndexOutOfBoundsException ex){
					rowVal.append('-');
				}
			}
			rowVal.append('\n');
		}
		System.out.println(rowVal.toString());
	}
}
