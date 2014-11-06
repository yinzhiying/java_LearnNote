package cn.lala.nihao.baibai;

import java.awt.Image;

public class Cell {

	// Иёзг
	private int row;
	private int col;
	// private int color;
	private Image image;

	public Cell() {

	}

	// constrator

	public Cell(int row, int col, Image image) {
		super();
		this.row = row;
		this.col = col;
		this.image = image;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void moveRight() {
		col++;

	}

	public void moveLeft() {
		col--;

	}

	public void moveDown() {
		row++;
	}

	public String toString() {
		return "[" + row + "," + col + "]";
	}
}
