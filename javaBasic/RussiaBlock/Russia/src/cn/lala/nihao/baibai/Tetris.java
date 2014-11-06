package cn.lala.nihao.baibai;

import java.awt.*;

import javax.imageio.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.applet.*;
import sun.audio.*;
import java.awt.*;
import javax.swing.*;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sun.audio.*;

/**
* ����˹������Ϸ��� 
*
*/

public class Tetris extends JFrame {
	/**
	 * ��������ķ���
	 */
	private Tetromino tetromino;
	// the next block
	private Tetromino nextOne;
	// row��
	public static final int ROWS = 20;
	// COL��
	public static final int COLS = 10;

	// WALL
	private Cell[][] wall = new Cell[ROWS][COLS];
	// destory lines
	private int lines;
	// score
	private int score;

	/** �ȼ� */
	private int level = 1;
	private int temp = 0;

	public static final int CELL_SIZE = 26;

	MenuBar m_MenuBar;// ����˵���

	Menu menuGame, menuHelp;// �˵���
	MenuItem mi_Game_NewGame, mi_Game_Option,
			mi_Game_ChangeAppearance, mi_Game_Exit;// File�еĲ˵�����
	MenuItem mi_Help_ViewHelp, mi_Help_About;

	private static Image background;// ����ͼƬ
	public static Image I;
	public static Image J;
	public static Image L;
	public static Image S;
	public static Image Z;
	public static Image O;
	public static Image T;
	public final static int alinescore = 100;
	public final static int everylevescore = alinescore * 20;
	public final static int maxlevel = 10;
	public final static int initlevel = 5;

	static {
		try {
			background = ImageIO.read(Tetris.class.getResource("tetris.png"));
			T = ImageIO.read(Tetris.class.getResource("T.png"));
			I = ImageIO.read(Tetris.class.getResource("I.png"));
			S = ImageIO.read(Tetris.class.getResource("S.png"));
			Z = ImageIO.read(Tetris.class.getResource("Z.png"));
			L = ImageIO.read(Tetris.class.getResource("L.png"));
			J = ImageIO.read(Tetris.class.getResource("J.png"));
			O = ImageIO.read(Tetris.class.getResource("O.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���캯��
	 */
	Tetris() {
		super("����˹����");

		m_MenuBar = new MenuBar();// �����˵���

		menuGame = new Menu("��Ϸ");
		// System.out.println(menuGame);
		mi_Game_NewGame = new MenuItem("����Ϸ");
		//mi_Game_Option = new MenuItem("Option");
		mi_Game_ChangeAppearance = new MenuItem("����");
		mi_Game_Exit = new MenuItem("�˳�");

		// ��Ӧ�����¼�
		mi_Game_ChangeAppearance.addActionListener(new HandleAct());
		//mi_Game_Option.addActionListener(new HandleAct());
		mi_Game_NewGame.addActionListener(new HandleAct());
		mi_Game_Exit.addActionListener(new HandleAct());

		// ���˵��������˵���
		menuGame.add(mi_Game_NewGame);
		//menuGame.add(mi_Game_Option);
		menuGame.add(mi_Game_ChangeAppearance);
		menuGame.addSeparator();// ��һ������ָ���
		menuGame.add(mi_Game_Exit);
		m_MenuBar.add(menuGame);// ����Ϸ�˵������˵�

		// �����˵�ѡ��
		menuHelp = new Menu("����");
		mi_Help_ViewHelp = new MenuItem("�鿴����");
		mi_Help_About = new MenuItem("����");
		// ע�������
		mi_Help_ViewHelp.addActionListener(new HandleAct());
		mi_Help_About.addActionListener(new HandleAct());
		// ����˵�
		menuHelp.add(mi_Help_ViewHelp);
		menuHelp.add(mi_Help_About);

		// add menu bar
		m_MenuBar.add(menuHelp);

		this.setMenuBar(m_MenuBar);
		// addWindowListener(new HandleClose);

	}

	/**
	 * ����˵����� �ڲ���
	 */
	class HandleAct implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "�˳�") {
				// ConfirmDlg confirm=new ConfirmDlg(this);
				pauseAction();
				int reponse = JOptionPane.showConfirmDialog(null, "�Ƿ��˳�", "�˳�",
						JOptionPane.YES_NO_OPTION);
				// System.out.println(reponse);
			
					if (reponse == 0) {
						dispose();
						System.exit(0);
					
				}
				

			}
			if (e.getActionCommand() == "����Ϸ") {
				startAction();
			}
			
			if (e.getActionCommand() == "����") {
				JOptionPane.showMessageDialog(null, "��һ�����ȫ�����Ϸ",
						"����˹����", JOptionPane.INFORMATION_MESSAGE);
			}
			if (e.getActionCommand() == "�鿴����") {
				JOptionPane
						.showMessageDialog(
								null,
								"˵��:\n1.����������ƶ�\n2.���Ҽ������ƶ�\n3.�����ϼ����ұ任��״��zΪ����任��״\n4.�����¼������ƶ�\n5.pΪ��ͣ��cΪ������sΪ���¿�ʼ\n6.�ո�Ϊֱ���½�",
								"��Ϸ�淨", JOptionPane.INFORMATION_MESSAGE);
			}
			if (e.getActionCommand() == "����") {
				try {
					background = ImageIO.read(Tetris.class
							.getResource("tetris1.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * ��������¼�
	 */
	class HandleMouse extends MouseAdapter {
		public void mousesReleased(MouseEvent e) {

		}
	}


	/**
	 * �����˶�����
	 */
	// ����q�����Ի����Ƿ��˳���Ϸ
	public void action() {
		startAction();
		repaint();
		KeyAdapter l = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_Q) {
					int reponse = JOptionPane.showConfirmDialog(null, "�Ƿ��˳�",
							"�˳�", JOptionPane.YES_NO_OPTION);
					if (reponse == 0) {
						dispose();
						System.exit(0);
					}
				}
				// ��ʼ��Ϸ
				if (gameOver) {
					if (key == KeyEvent.VK_S) {
						startAction();
					}
					return;
				}
				// �����ͣ���Ұ�����[c]�ͼ�������
				if (pause) {
					if (key == KeyEvent.VK_C) {
						continueAction();
					}
					return;
				}
				// ��������������
				switch (key) {
				//�����ƶ�
				case KeyEvent.VK_RIGHT:
					moveRightAction();
					break;
					//�����ƶ�
				case KeyEvent.VK_LEFT:
					moveLeftAction();
					break;
					//�����½�
				case KeyEvent.VK_DOWN:
					softDropAction();
					break;
				// ���ұ任��״
				case KeyEvent.VK_UP:
					rotateRightAction();
					break;
				// ����任��״
				case KeyEvent.VK_Z:
					rotateLeftAction();
					break;
				// ˲������
				case KeyEvent.VK_SPACE:
					hardDropAction();
					break;
				case KeyEvent.VK_P:
					pauseAction();
					break;
				}
				repaint();
			}
		};
		this.requestFocus();
		this.addKeyListener(l);
	}

	public void paint(Graphics g) {
		g.drawImage(background, 0,35, null);
		g.translate(15,45);
		paintTetromino(g);
	    paintWall(g);
		paintNextOne(g);
		paintScore(g);

	}

	public static final int FONT_COLOR = 0x667799;
	public static final int FONT_SIZE = 0x20;

	// Panel writing
	private void paintScore(Graphics g) {
		Font f = getFont();// get old font family
		Font font = new Font(f.getName(), Font.BOLD, FONT_SIZE);
		int x = 290;
		int y = 162;
		g.setColor(new Color(FONT_COLOR));
		g.setFont(font);
		String str = "����:" + this.score;
		
		g.drawString(str, x, y);
		y += 56;
		str = "����:" + this.lines;
		g.drawString(str, x, y);
		y += 56;
		// �ȼ�
		str = "�ȼ�:" + this.level;
		g.drawString(str, x, y);
		y += 56;
		str = "[P]��ͣ";
		if (pause) {
			str = "[C]����";
		}
		if (gameOver) {
			str = "[S]��ʼ";
		}
		g.drawString(str, x, y);
	}

//	public void setLevel() {
//		
//		
//		this.level = this.level + 1;
//	}

	private void paintNextOne(Graphics g) {
		Cell[] cells = nextOne.getCells();
		for (int i = 0; i < cells.length; i++) {
			Cell c = cells[i];
			int x = (c.getCol() + 10) * CELL_SIZE - 1;// the next one
			int y = (c.getRow() + 1) * CELL_SIZE - 1;// the next one
			g.drawImage(c.getImage(), x, y, null);
		}
	}

	private void paintTetromino(Graphics g) {
	Cell[] cells = tetromino.getCells();
	for (int i = 0; i < cells.length; i++) {
		Cell c = cells[i];
		int x = c.getCol() * CELL_SIZE - 1;
		int y = c.getRow() * CELL_SIZE - 1;
		// g.setColor(new Color(c.getColor()));
		// g.fillRect(x,y,CELL_SIZE,CELL_SIZE);
		g.drawImage(c.getImage(), x, y, null);
	}
	}
	// ��Tetris������ӷ���paintwall
	private void paintWall(Graphics g) {
		for (int row = 0; row < wall.length; row++) {
			// ����ÿһ��
			Cell[] line = wall[row];
			for (int col = 0; col < line.length; col++) {
				Cell cell = line[col];
				int x = col * CELL_SIZE;
				int y = row * CELL_SIZE;
				if (cell == null) {
					g.setColor(new Color(0));
					// ��ʾ����
					g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
				} else {
					g.drawImage(cell.getImage(), x - 1, y - 1, null);
				}
			}
		}
	}

	// �� Tetris(����˹����) �������ӷ��� ��������Ĺ����ǣ�������Ķ��� ��������
	// ��ɹ��ܣ�����ܹ���������䣬�������½��ǽ�ϣ����µķ�����ֲ���ʼ���¡�

	public void softDropAction() {
		if (tetrominoCanDrop()) {
			try{
				
				FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\down.wav");
				AudioStream as=new AudioStream(file);
				AudioPlayer.player.start(as);
				
				}catch(IOException e){}
			tetromino.softDrop();
		} else {
			tetrominoLandToWall();
			destoryLines();// �ƻ�������
			checkGameOver();
			tetromino = nextOne;
			nextOne = Tetromino.randomTetromino();
		}
	}

	/**
	 * �����Ѿ������У����ҼƷ� 1������ÿһ�� 2���������飩ĳ�����Ǹ����� ����������
	 **/
	public void destoryLines() {
		int lines = 0;
		for (int row = 0; row < wall.length; row++) {
			if (fullCells(row)) {
				try{
					
					FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\winning.wav");
					AudioStream as=new AudioStream(file);
					AudioPlayer.player.start(as);
					
					}catch(IOException e){}
				deleteRow(row);
				lines++;
			}
		}
		// lines=?

		this.lines += lines;// 0 1 2 3 4
		this.temp += lines;
		this.score += SCORE_TABLE[lines];
		
		if (this.temp >= 6) {
			this.temp = 0;
			level++;
			try{
				FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\level.wav");
				AudioStream as=new AudioStream(file);
				AudioPlayer.player.start(as);
			}catch(IOException e){}
		}
	}

	private static final int[] SCORE_TABLE = { 0, 1, 10, 30, 200 };// �������÷�

	                                         //0 1   2   3    4

	public boolean fullCells(int row) {
		try{
			
			FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\scoring.wav");
			AudioStream as=new AudioStream(file);
			AudioPlayer.player.start(as);
			
		}catch(IOException e){}
		Cell[] line = wall[row];
		for (int i = 0; i < line.length; i++) {
			if (line[i] == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ɾ������
	 * 
	 * @param row
	 */
	public void deleteRow(int row) {
		for (int i = row; i >= 1; i--) {
			// copy [i-1]->[i]
			System.arraycopy(wall[i - 1], 0, wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);// ��մ���
	}

	/**
	 * ��鵱ǰ��4�񷽿��ܷ��������
	 */
	public boolean tetrominoCanDrop() {
		Cell[] cells = tetromino.getCells();
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if (row == ROWS - 1) {
				return false;
			}// ���׾Ͳ����½�
		}

		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if (wall[row + 1][col] != null) {
				return false;// �·�ǽ�з���Ͳ����½�
			}
		}
		return true;
	}

	/**
	 * �Ŀ鷽����·��ǽ��
	 */
	public void tetrominoLandToWall() {
		Cell[] cells = tetromino.getCells();
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col] = cell;
		}
	}

	public void moveRightAction() {
		tetromino.moveRight();
		try{
			
			FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\swift.wav");
			AudioStream as=new AudioStream(file);
			AudioPlayer.player.start(as);
		
			}catch(IOException e){}
		if (outOfBound() || coincide()) {
			tetromino.moveLeft();
		}
	}

	public void moveLeftAction() {
		tetromino.moveLeft();
		try{
			
			FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\swift.wav");
			AudioStream as=new AudioStream(file);
			AudioPlayer.player.start(as);
			
			}catch(IOException e){}
		if (outOfBound() || coincide()) {
			tetromino.moveRight();
		}
	}

	/**
	 * �ж��Ƿ����
	 */
	private boolean outOfBound() {
		Cell[] cells = tetromino.getCells();
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int col = cell.getCol();
			if (col < 0 || col >= COLS) {
				return true;// ������
			}
		}
		return false;
	}

	/**
	 * �жϷ���֮���ǲ����غ�
	 */
	private boolean coincide() {
		Cell[] cells = tetromino.getCells();
		// for each ѭ��������
		for (Cell cell : cells) {
			int row = cell.getRow();
			int col = cell.getCol();
			if (row < 0 || row >= ROWS || col < 0 || col >= COLS
					|| wall[row][col] != null) {
				return true;// ǽ���и��Ӷ��񣬷����غ�
			}
		}
		return false;
	}

	/**
	 * ������ת
	 */
	public void rotateRightAction() {
		// ��ת֮ǰ
		// System.out.println(tetromino);
		tetromino.rotateRight();
		if (outOfBound() || coincide()) {
			tetromino.rotateLeft();
		}
	}

	/**
	 * ������ת
	 */
	public void rotateLeftAction() {
		tetromino.rotateLeft();
		if (outOfBound() || coincide()) {
			tetromino.rotateRight();
		}
	}

	public void hardDropAction() {
		while (tetrominoCanDrop()) {
			tetromino.softDrop();
		}
		tetrominoLandToWall();
		destoryLines();
		checkGameOver();
		tetromino = nextOne;
		nextOne = Tetromino.randomTetromino();

	}

	private boolean pause;
	private boolean gameOver;
	private Timer timer;

	/**
	 * ������Ϸ
	 */
	public void startAction() {
		clearWall();
		
		tetromino = Tetromino.randomTetromino();
		nextOne = Tetromino.randomTetromino();
		lines = 0;
		score = 0;
		level=1;
		pause = false;
		gameOver = false;
		timer = new Timer();
		try{
			
			FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\start.wav");
			AudioStream as=new AudioStream(file);
			AudioPlayer.player.start(as);
			
			}catch(IOException e){}
		timer.schedule(new TimerTask() {
			public void run() {
				softDropAction();
				repaint();
			}
		}, 700, 700);// �����ٶ�
		
	}

	/**
	 * ����ǽ��
	 */
	private void clearWall() {
		// ÿ����������Ϊnull
		for (int row = 0; row < ROWS; row++) {
			Arrays.fill(wall[row], null);
		}
	}

	/**
	 * ֹͣ��ʱ��
	 */
	public void pauseAction() {
		timer.cancel();
		try{
			
			FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\pause.wav");
			AudioStream as=new AudioStream(file);
			AudioPlayer.player.start(as);
			
			}catch(IOException e){}
		pause = true;
		repaint();
	}

	// continue
	public void continueAction() {
		timer = new Timer();
		pause = false;
		//gameOver = false;
		try{
			
			FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\start.wav");
			AudioStream as=new AudioStream(file);
			AudioPlayer.player.start(as);
		}catch(IOException e){}
		timer.schedule(new TimerTask() {
			public void run() {
				softDropAction();
				
				repaint();
			}
		}, 700, 700);
	}

	public void checkGameOver() {
		if (wall[0][4] == null) {
			
			return;
		}
		gameOver = true;
		try{
			
			FileInputStream file=new FileInputStream("G:\\workspace\\Russia\\src\\cn\\lala\\nihao\\baibai\\over.wav");
			AudioStream as=new AudioStream(file);
			AudioPlayer.player.start(as);
			
		}catch(IOException e){}
		timer.cancel();
		JOptionPane.showConfirmDialog(null, "GAMEOVER", "��Ϸ����",
				JOptionPane.INFORMATION_MESSAGE);
		
		repaint();
	}


	class HandelWin extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			Frame f = (Frame) (e.getWindow());
//			ConfirmDlg confirm = new ConfirmDlg(f);
//			if (confirm.ans) {
				f.dispose();
				System.exit(0);
			}
		}
//	}

	
	 
	public static void main(String[] args) {
		 //JFrame frame = new JFrame();
		Tetris tetris = new Tetris();
		 //frame.add(tetris);
		// play(System.getProperty("user.dir") + "\\sounds\\begin.wav");
		// play(System.getProperty("user.dir") + "\\sounds\\roger.wav");
//		final Music m = new Music();
//		m.startMusic();
		 tetris.setSize(536, 590);
		 tetris.setUndecorated(false);// ȥ�����ڿ�
		 tetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// // Locationλ��RelativeTO�����
		 tetris.setLocationRelativeTo(null);
		 tetris.setVisible(true);
		tetris.action();

	}

}
