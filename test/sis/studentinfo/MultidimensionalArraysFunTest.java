package sis.studentinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MultidimensionalArraysFunTest {

//		0 1 2  3
//		4 5 6  7
//		8 9 10 11
	@Test
	public void testTwoDimensionalArrays() {
		final int rows = 3;
		final int cols = 4;
		int count = 0;
	
		int[][] matrix = new int[rows][cols];
		for (int x = 0; x < rows; x++)
			for (int y = 0; y < cols; y++)
				matrix[x][y] = count++;
		
		assertEquals(11, matrix[2][3]);
	}
	
	// 0
	// 1 2
	// 3 4 5
	@Test
	public void testPartialDimensions() {
		final int rows = 3;
		int[][] matrix = new int[rows][];
		matrix[0] = new int[] { 0 };
		matrix[1] = new int[] { 1, 2 };
		matrix[2] = new int[] { 3, 4, 5 };
		assertEquals(1, matrix[1][0]);
		assertEquals(5, matrix[2][2]);
	}
	
	//same partial dimension matrix
	@Test
	public void testPartialDimensionsWithInitializationSyntax() {
		int[][] matrix = { { 0 }, { 1, 2 }, { 3, 4, 5 } };
		assertEquals(5, matrix[2][2]);
	}

}
