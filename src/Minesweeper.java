import java.util.Scanner;

public class Minesweeper {

	public static void main(String[] args) {
		int minesCount = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the cells layout:");
		String[] m = sc.nextLine().split(",");
		MSGrid minesw = new MSGrid();
		Cell[][] cells = new Cell[m.length][m.length];
		minesCount = processInput(m, cells);
		minesw.setCells(cells);
		minesw.setMinesCount(minesCount);
		minesw.printCells();
		minesw.checkCells();
		try {
			while (!minesw.isGameOver()) {
				System.out.println("Enter the option: ");
				String opt[] = sc.nextLine().split(",");
				String option = opt[0];
				int x = Integer.parseInt(opt[1]);
				int y = Integer.parseInt(opt[2]);
				minesw.process(option, x, y);
			}
			System.out.println("Wow! You cleared the minefield! Game over!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static int processInput(String[] m, Cell[][] cells) {
		int minesCount = 0;
		for (int i = 0; i < m.length; i++) {
			String str = m[i];
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				Cell cell = new Cell();
				switch (c) {
				case 'm':
					cell.type = CellType.m;
					cell.setValue(-1);
					minesCount++;
					break;
				default:
					break;
				}
				cells[i][j] = cell;
			}
		}
		return minesCount;
	}
}

class MSGrid {
	private static final String OPEN = "o";
	private Cell[][] cells;
	private int minesCount;

	public int getMinesCount() {
		return minesCount;
	}

	public boolean isGameOver() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				Cell c = cells[i][j];
				if (!(c.isOpen() || c.isFlagged())) {
					return false;
				}
			}
		}
		return true;
	}

	public void setMinesCount(int minesCount) {
		this.minesCount = minesCount;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public void process(String option, int x, int y) throws Exception {
		Cell cell = cells[x][y];
		if (OPEN.equalsIgnoreCase(option)) {
			if (cell.isMine()) {
				throw new Exception("Oops! You stepped on a mine! Game over!");
			}
			cell.open();
		} else if (CellType.f.toString().equals(option)) {
			cell.type = CellType.f;
		}
		printCells();
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void printCells() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				Cell c = cells[i][j];
				if (c.isOpen()) {
					if (c.isMine()) {
						System.out.print(CellType.m.toString());
					} else {
						System.out.print(c.getValue());
					}
				} else if (c.isFlagged()) {
					System.out.print(CellType.f.toString());
				} else {
					System.out.print(CellType.x.toString());
				}
			}
			System.out.println();
		}
	}

	public void checkCells() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				Cell cell = cells[i][j];
				if (cell.isMine()) {
					updatecells(i, j);
				}
			}
		}
	}

	private void updatecells(int i, int j) {
		if (canGetLeftSquare(i, j))
			cells[i][j - 1].setValue(cells[i][j - 1].getValue() == 0 ? 1
					: cells[i][j - 1].getValue() + 1);

		if (canGetRightSquare(i, j))
			cells[i][j + 1].setValue(cells[i][j + 1].getValue() == 0 ? 1
					: cells[i][j + 1].getValue() + 1);

		if (canGetTopSquare(i, j))
			cells[i - 1][j].setValue(cells[i - 1][j].getValue() == 0 ? 1
					: cells[i - 1][j].getValue() + 1);

		if (canGetBottomSquare(i, j))
			cells[i + 1][j].setValue(cells[i + 1][j].getValue() == 0 ? 1
					: cells[i + 1][j].getValue() + 1);
	}

	private boolean canGetLeftSquare(int rowNumber, int columnNumber) {
		return (columnNumber != 0);
	}

	private boolean canGetRightSquare(int rowNumber, int columnNumber) {
		return (columnNumber != cells[0].length - 1);
	}

	private boolean canGetTopSquare(int rowNumber, int columnNumber) {
		return (rowNumber != 0);
	}

	private boolean canGetBottomSquare(int rowNumber, int columnNumber) {
		return (rowNumber != cells[0].length - 1);
	}

}

class Cell {
	private int x;
	private int y;
	private int value = 0;
	private boolean isOpen;

	public int getValue() {
		return value;
	}

	public boolean isFlagged() {
		return CellType.f.equals(type);
	}

	public void setValue(int value) {
		this.value = value;
	}

	CellType type;

	public boolean isOpen() {
		return isOpen;
	}

	public void open() {
		isOpen = true;
	}

	public boolean isMine() {
		if (type == CellType.m)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return value + " : " + this.type;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
}

enum CellType {
	m, f, x
}