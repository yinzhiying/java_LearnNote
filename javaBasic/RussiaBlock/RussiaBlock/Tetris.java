package day06.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * ����˹������Ϸ��� 
 *
 */
public class Tetris extends JPanel {
	/** �������䷽�� */
	private Tetromino tetromino;
	/** ��һ�����䷽�� */
	private Tetromino nextOne;
	/** ���� */
	public static final int ROWS = 20;
	/** ���� */
	public static final int COLS = 10;
	/** ǽ */
	private Cell[][] wall = new Cell[ROWS][COLS]; 
	/** ���������� */
	private int lines;
	/** ���� */
	private int score;
	
	public static final int CELL_SIZE = 26;
	
	private static Image background;//����ͼƬ
	public static Image I;
	public static Image J;
	public static Image L;
	public static Image S;
	public static Image Z;
	public static Image O;
	public static Image T;
	static{//���ؾ�̬��Դ�ģ�����ͼƬ
		//���齫ͼƬ�ŵ� Tetris.java ͬ����!
		//�Ӱ��м���ͼƬ����ʹ��Swing APIʵ��
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		background = toolkit.getImage(
//				Tetris.class.getResource("tetris.png"));
//		T = toolkit.getImage(Tetris.class.getResource("T.png"));
//		S = toolkit.getImage(Tetris.class.getResource("S.png"));
//		Z = toolkit.getImage(Tetris.class.getResource("Z.png"));
//		L = toolkit.getImage(Tetris.class.getResource("L.png"));
//		J = toolkit.getImage(Tetris.class.getResource("J.png"));
//		I = toolkit.getImage(Tetris.class.getResource("I.png"));
//		O = toolkit.getImage(Tetris.class.getResource("O.png"));
		//import javax.imageio.ImageIO;
		try{
			background = ImageIO.read(
				Tetris.class.getResource("tetris.png"));
			T=ImageIO.read(Tetris.class.getResource("T.png"));
			I=ImageIO.read(Tetris.class.getResource("I.png"));
			S=ImageIO.read(Tetris.class.getResource("S.png"));
			Z=ImageIO.read(Tetris.class.getResource("Z.png"));
			L=ImageIO.read(Tetris.class.getResource("L.png"));
			J=ImageIO.read(Tetris.class.getResource("J.png"));
			O=ImageIO.read(Tetris.class.getResource("O.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void action(){
		tetromino = Tetromino.randomTetromino();
		nextOne = Tetromino.randomTetromino();
		wall[19][2] = new Cell(19,2,Tetris.T);
		repaint();
		KeyAdapter l = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				//System.out.println(key); 
				switch(key){
				case KeyEvent.VK_RIGHT: moveRightAction(); break;
				case KeyEvent.VK_LEFT: moveLeftAction(); break;
				case KeyEvent.VK_DOWN: softDropAction() ; break;
				}
				repaint();
			}
		};
		this.requestFocus();
		this.addKeyListener(l);
	}
	
	public void paint(Graphics g){
		//g.setColor(new Color(0xdddddd));
		//g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
		g.drawImage(background, 0, 0, null);//ʹ��this ��Ϊ�۲���
		g.translate(15, 15);//ƽ�ƻ�ͼ����ϵ
		Cell[] cells = tetromino.getCells();
		for(int i=0; i<cells.length; i++){
			Cell c = cells[i];
			int x = c.getCol() * CELL_SIZE-1;
			int y = c.getRow() * CELL_SIZE-1;
			//g.setColor(new Color(c.getColor()));
			//g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
			g.drawImage(c.getImage(), x, y, null);
		}
		paintWall(g);//��ǽ
	}
	//�� Tetris �� ����� ���� paintWall
	private void paintWall(Graphics g){
		for(int row=0; row<wall.length; row++){
			//����ÿһ��, i = 0 1 2 ... 19
			Cell[] line = wall[row];
			//line.length = 10
			for(int col=0; col<line.length; col++){
				Cell cell = line[col]; 
				int x = col*CELL_SIZE; 
				int y = row*CELL_SIZE;
				if(cell==null){
					g.setColor(new Color(0));
					//������ 
					g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
				}else{
					g.drawImage(cell.getImage(), x-1, y-1, null);
				}
			}
		}
	}
	/**
	 * �� Tetris(����˹����) �������ӷ���
	 * ��������Ĺ����ǣ�������Ķ��� ��������
	 * ��ɹ��ܣ�����ܹ���������䣬�������½��ǽ�ϣ�
	 *   ���µķ�����ֲ���ʼ���¡�
	 */
	public void softDropAction(){
		if(tetrominoCanDrop()){
			tetromino.softDrop();
		}else{
			tetrominoLandToWall();
			destroyLines();//�ƻ�������
			tetromino = nextOne;
			nextOne = Tetromino.randomTetromino();
		}
	}
	/** �����Ѿ������У����ҼƷ�
	 * 1������ÿһ�� 
	 * 2���������飩ĳ�����Ǹ����� ���������� 
	 **/
	public void destroyLines(){
		int lines = 0;
		for(int row = 0; row<wall.length; row++){
			if(fullCells(row)){
				deleteRow(row);
				lines++;
			}
		}
		// lines = ?
		this.lines += lines;//0 1 2 3 4
		this.score += SCORE_TABLE[lines];
	}
	private static final int[] SCORE_TABLE={0,1,10,30,200};
	//                                      0 1  2  3  4
	
	public boolean fullCells(int row){
		Cell[] line = wall[row];
		for(int i=0; i<line.length; i++){
			if(line[i]==null){//����пո�ʽ�Ͳ�������
				return false;
			}
		}
		return true;
	}
	public void deleteRow(int row){
		for(int i=row; i>=1; i--){
			//���� [i-1] -> [i] 
			System.arraycopy(wall[i-1], 0, wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);
	}
	
	/** ��鵱ǰ��4�񷽿��ܷ�������� */
	public boolean tetrominoCanDrop(){
		Cell[] cells = tetromino.getCells();
		for(int i = 0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow(); int col = cell.getCol();
			if(row == ROWS-1){return false;}//���׾Ͳ����½���
		}
		for(int i = 0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow(); int col = cell.getCol();
			if(wall[row+1][col] != null){
				return false;//�·�ǽ���з���Ͳ����½���
			}
		}
		return true;
	}
	/** 4�񷽿���½��ǽ�� */
	public void tetrominoLandToWall(){
		Cell[] cells = tetromino.getCells();
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col] = cell;
		}
	}
	
	public void moveRightAction(){
		tetromino.moveRight();
		if(outOfBound() || coincide()){
			tetromino.moveLeft();
		}
	}
	public void moveLeftAction(){
		tetromino.moveLeft();
		if(outOfBound() || coincide()){
			tetromino.moveRight();
		}
	}
	/** ... */
	private boolean outOfBound(){
		Cell[] cells = tetromino.getCells();
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int col = cell.getCol();
			if(col<0 || col>=COLS){
				return true;//������
			}
		}
		return false;
	}
	private boolean coincide(){
		Cell[] cells = tetromino.getCells();
		//for each ѭ��������������"���������д"
		for(Cell cell: cells){//Java 5 �Ժ��ṩ��ǿ��forѭ��
			int row = cell.getRow();
			int col = cell.getCol();
			if(row<0 || row>=ROWS || col<0 || col>=COLS || 
					wall[row][col]!=null){
				return true; //ǽ���и��Ӷ��󣬷����غ�
			}
		}
		return false;
	} 
	/** ������ת���� */
	public void rotateRightAction(){
		tetromino.rotateRight();
		if(outOfBound() || coincide()){
			tetromino.rotateLeft();
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Tetris tetris = new Tetris();
		frame.add(tetris);
		frame.setSize(525, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Location λ�� RelativeTo����� 
		frame.setLocationRelativeTo(null);//ʹ��ǰ���ھ���
		frame.setVisible(true);
		tetris.action();
		//tetris.requestFocus();
	}
}







