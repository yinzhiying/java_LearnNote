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
* 俄罗斯方块游戏面板 
*
*/

public class Tetris extends JFrame {
	/**
	 * 正在下落的方块
	 */
	private Tetromino tetromino;
	// the next block
	private Tetromino nextOne;
	// row行
	public static final int ROWS = 20;
	// COL列
	public static final int COLS = 10;

	// WALL
	private Cell[][] wall = new Cell[ROWS][COLS];
	// destory lines
	private int lines;
	// score
	private int score;

	/** 等级 */
	private int level = 1;
	private int temp = 0;

	public static final int CELL_SIZE = 26;

	MenuBar m_MenuBar;// 定义菜单条

	Menu menuGame, menuHelp;// 菜单项
	MenuItem mi_Game_NewGame, mi_Game_Option,
			mi_Game_ChangeAppearance, mi_Game_Exit;// File中的菜单子项
	MenuItem mi_Help_ViewHelp, mi_Help_About;

	private static Image background;// 背景图片
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
	 * 构造函数
	 */
	Tetris() {
		super("俄罗斯方块");

		m_MenuBar = new MenuBar();// 创建菜单条

		menuGame = new Menu("游戏");
		// System.out.println(menuGame);
		mi_Game_NewGame = new MenuItem("新游戏");
		//mi_Game_Option = new MenuItem("Option");
		mi_Game_ChangeAppearance = new MenuItem("换肤");
		mi_Game_Exit = new MenuItem("退出");

		// 相应动作事件
		mi_Game_ChangeAppearance.addActionListener(new HandleAct());
		//mi_Game_Option.addActionListener(new HandleAct());
		mi_Game_NewGame.addActionListener(new HandleAct());
		mi_Game_Exit.addActionListener(new HandleAct());

		// 将菜单子项加入菜单项
		menuGame.add(mi_Game_NewGame);
		//menuGame.add(mi_Game_Option);
		menuGame.add(mi_Game_ChangeAppearance);
		menuGame.addSeparator();// 加一条横向分割线
		menuGame.add(mi_Game_Exit);
		m_MenuBar.add(menuGame);// 将游戏菜单项加入菜单

		// 帮助菜单选项
		menuHelp = new Menu("帮助");
		mi_Help_ViewHelp = new MenuItem("查看帮助");
		mi_Help_About = new MenuItem("关于");
		// 注册监听者
		mi_Help_ViewHelp.addActionListener(new HandleAct());
		mi_Help_About.addActionListener(new HandleAct());
		// 加入菜单
		menuHelp.add(mi_Help_ViewHelp);
		menuHelp.add(mi_Help_About);

		// add menu bar
		m_MenuBar.add(menuHelp);

		this.setMenuBar(m_MenuBar);
		// addWindowListener(new HandleClose);

	}

	/**
	 * 处理菜单命令 内部类
	 */
	class HandleAct implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "退出") {
				// ConfirmDlg confirm=new ConfirmDlg(this);
				pauseAction();
				int reponse = JOptionPane.showConfirmDialog(null, "是否退出", "退出",
						JOptionPane.YES_NO_OPTION);
				// System.out.println(reponse);
			
					if (reponse == 0) {
						dispose();
						System.exit(0);
					
				}
				

			}
			if (e.getActionCommand() == "新游戏") {
				startAction();
			}
			
			if (e.getActionCommand() == "关于") {
				JOptionPane.showMessageDialog(null, "是一款风靡全球的游戏",
						"俄罗斯方块", JOptionPane.INFORMATION_MESSAGE);
			}
			if (e.getActionCommand() == "查看帮助") {
				JOptionPane
						.showMessageDialog(
								null,
								"说明:\n1.按左键向左移动\n2.按右键向右移动\n3.按向上键向右变换形状，z为向左变换形状\n4.按向下键向下移动\n5.p为暂停，c为继续，s为重新开始\n6.空格为直接下降",
								"游戏玩法", JOptionPane.INFORMATION_MESSAGE);
			}
			if (e.getActionCommand() == "换肤") {
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
	 * 处理鼠标事件
	 */
	class HandleMouse extends MouseAdapter {
		public void mousesReleased(MouseEvent e) {

		}
	}


	/**
	 * 方块运动代码
	 */
	// 按键q弹出对话框是否退出游戏
	public void action() {
		startAction();
		repaint();
		KeyAdapter l = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_Q) {
					int reponse = JOptionPane.showConfirmDialog(null, "是否退出",
							"退出", JOptionPane.YES_NO_OPTION);
					if (reponse == 0) {
						dispose();
						System.exit(0);
					}
				}
				// 开始游戏
				if (gameOver) {
					if (key == KeyEvent.VK_S) {
						startAction();
					}
					return;
				}
				// 如果暂停并且按键是[c]就继续动作
				if (pause) {
					if (key == KeyEvent.VK_C) {
						continueAction();
					}
					return;
				}
				// 否则处理其他按键
				switch (key) {
				//向左移动
				case KeyEvent.VK_RIGHT:
					moveRightAction();
					break;
					//向右移动
				case KeyEvent.VK_LEFT:
					moveLeftAction();
					break;
					//方块下降
				case KeyEvent.VK_DOWN:
					softDropAction();
					break;
				// 向右变换形状
				case KeyEvent.VK_UP:
					rotateRightAction();
					break;
				// 向左变换形状
				case KeyEvent.VK_Z:
					rotateLeftAction();
					break;
				// 瞬间下落
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
		String str = "分数:" + this.score;
		
		g.drawString(str, x, y);
		y += 56;
		str = "行数:" + this.lines;
		g.drawString(str, x, y);
		y += 56;
		// 等级
		str = "等级:" + this.level;
		g.drawString(str, x, y);
		y += 56;
		str = "[P]暂停";
		if (pause) {
			str = "[C]继续";
		}
		if (gameOver) {
			str = "[S]开始";
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
	// 在Tetris类中添加方法paintwall
	private void paintWall(Graphics g) {
		for (int row = 0; row < wall.length; row++) {
			// 迭代每一行
			Cell[] line = wall[row];
			for (int col = 0; col < line.length; col++) {
				Cell cell = line[col];
				int x = col * CELL_SIZE;
				int y = row * CELL_SIZE;
				if (cell == null) {
					g.setColor(new Color(0));
					// 显示网格
					g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
				} else {
					g.drawImage(cell.getImage(), x - 1, y - 1, null);
				}
			}
		}
	}

	// 在 Tetris(俄罗斯方块) 类中增加方法 这个方法的功能是：软下落的动作 控制流程
	// 完成功能：如果能够下落就下落，否则就着陆到墙上，而新的方块出现并开始落下。

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
			destoryLines();// 破坏满的行
			checkGameOver();
			tetromino = nextOne;
			nextOne = Tetromino.randomTetromino();
		}
	}

	/**
	 * 销毁已经满的行，并且计分 1）迭代每一行 2）如果（检查）某行满是格子了 就销毁这行
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

	private static final int[] SCORE_TABLE = { 0, 1, 10, 30, 200 };// 消行所得分

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
	 * 删除此行
	 * 
	 * @param row
	 */
	public void deleteRow(int row) {
		for (int i = row; i >= 1; i--) {
			// copy [i-1]->[i]
			System.arraycopy(wall[i - 1], 0, wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);// 清空此行
	}

	/**
	 * 检查当前的4格方块能否继续下落
	 */
	public boolean tetrominoCanDrop() {
		Cell[] cells = tetromino.getCells();
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if (row == ROWS - 1) {
				return false;
			}// 到底就不能下降
		}

		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if (wall[row + 1][col] != null) {
				return false;// 下方墙有方块就不能下降
			}
		}
		return true;
	}

	/**
	 * 四块方块着路到墙上
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
	 * 判断是否出界
	 */
	private boolean outOfBound() {
		Cell[] cells = tetromino.getCells();
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int col = cell.getCol();
			if (col < 0 || col >= COLS) {
				return true;// 出界了
			}
		}
		return false;
	}

	/**
	 * 判断方块之间是不是重合
	 */
	private boolean coincide() {
		Cell[] cells = tetromino.getCells();
		// for each 循环、迭代
		for (Cell cell : cells) {
			int row = cell.getRow();
			int col = cell.getCol();
			if (row < 0 || row >= ROWS || col < 0 || col >= COLS
					|| wall[row][col] != null) {
				return true;// 墙上有格子对像，发生重合
			}
		}
		return false;
	}

	/**
	 * 向右旋转
	 */
	public void rotateRightAction() {
		// 旋转之前
		// System.out.println(tetromino);
		tetromino.rotateRight();
		if (outOfBound() || coincide()) {
			tetromino.rotateLeft();
		}
	}

	/**
	 * 向左旋转
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
	 * 启动游戏
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
		}, 700, 700);// 调整速度
		
	}

	/**
	 * 清理墙壁
	 */
	private void clearWall() {
		// 每个格子清理为null
		for (int row = 0; row < ROWS; row++) {
			Arrays.fill(wall[row], null);
		}
	}

	/**
	 * 停止定时器
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
		JOptionPane.showConfirmDialog(null, "GAMEOVER", "游戏结束",
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
		 tetris.setUndecorated(false);// 去掉窗口框
		 tetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// // Location位置RelativeTO相对于
		 tetris.setLocationRelativeTo(null);
		 tetris.setVisible(true);
		tetris.action();

	}

}
