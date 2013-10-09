package com.algorithm.test;

import java.util.HashSet;
import java.util.Set;

public class GameOfLifePlay {
	public GameOfLifeMatrix tick(GameOfLifeMatrix seed){
		int rows=seed.getRows();
		int cols=seed.getCols();
		int colOffset=0, rowOffset=0;
		int colGrowth=0, rowGrowth=0;
		HashSet<GameOfLifeMatrix.Grow> growthSet=(HashSet<GameOfLifeMatrix.Grow>) growthArea(seed);
		
		if(growthSet.contains(GameOfLifeMatrix.Grow.TOP)){
			rowGrowth++;
			rowOffset=-1;
		}
		if(growthSet.contains(GameOfLifeMatrix.Grow.LEFT)){
			colGrowth++;
			colOffset=-1;
		}
		if(growthSet.contains(GameOfLifeMatrix.Grow.RIGHT)) colGrowth++;
		if(growthSet.contains(GameOfLifeMatrix.Grow.BOTTOM)) rowGrowth++;
		
		
		
		char[][] nextGeneration=new char[rows+rowGrowth][cols+colGrowth];
		for(int row=0;row<rows+rowGrowth;row++){
			for(int col=0;col<cols+colGrowth;col++){
				char currValInNxtGen=getValInNxtGenAt(seed, row+rowOffset,col+colOffset);
				nextGeneration[row][col]=currValInNxtGen;
			}
		}
		return new GameOfLifeMatrix(nextGeneration);
	}

	private char getValInNxtGenAt(GameOfLifeMatrix seed, int row, int col){
		char retVal='-';
		int countLive=0;
		for(int neighbourRow=-1;neighbourRow<=1;neighbourRow++){
			for(int neighbourCol=-1;neighbourCol<=1;neighbourCol++){
				try{
					if(neighbourRow==0 && neighbourCol==0) continue;
					char val=seed.getValAt(row+neighbourRow,col+neighbourCol);
					if(val=='x') countLive++;
				}catch(ArrayIndexOutOfBoundsException ex){}
			}	
		}
		try{
			if(seed.getValAt(row,col)=='-' && countLive==3) retVal='x';
			else if(seed.getValAt(row,col)=='x'){
				if(countLive==2 || countLive==3)	retVal='x';
			}
		}catch(ArrayIndexOutOfBoundsException ex){
			if(countLive==3) retVal='x';
		}
		return retVal;
	}
	
	private Set<GameOfLifeMatrix.Grow> growthArea(GameOfLifeMatrix seed){
		Set<GameOfLifeMatrix.Grow> retVal=new HashSet<GameOfLifeMatrix.Grow>();
		
		if(isRowGrowable(seed, -1)) retVal.add(GameOfLifeMatrix.Grow.TOP);
		if(isRowGrowable(seed, seed.getRows())) retVal.add(GameOfLifeMatrix.Grow.BOTTOM);
		if(isColGrowable(seed, -1)) retVal.add(GameOfLifeMatrix.Grow.LEFT);
		if(isColGrowable(seed, seed.getCols())) retVal.add(GameOfLifeMatrix.Grow.RIGHT);
		
		return retVal;
	}
	
	private boolean isRowGrowable(GameOfLifeMatrix seed, int row){
		boolean retVal=false;
		for(int col=0;col<seed.getCols();col++){
			char nxtVal=getValInNxtGenAt(seed, row, col);
			if(nxtVal=='x'){
				retVal=true;
				break;
			}
		}
		return retVal;
	}
	
	private boolean isColGrowable(GameOfLifeMatrix seed, int col){
		boolean retVal=false;
		for(int row=0;row<seed.getRows();row++){
			char nxtVal=getValInNxtGenAt(seed,row, col);
			if(nxtVal=='x'){
				retVal=true;
				break;
			}
		}
		return retVal;
	}

}
