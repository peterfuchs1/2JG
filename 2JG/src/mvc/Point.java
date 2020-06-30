/**
 * 
 */
package mvc;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author wrafeiner
 *
 */
public class Point {
	private int x;
	private int y;
	public static final int MAX_X = 79;
	public static final int MAX_Y = 10;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this(0, 0);
	}

	public Point(int x) {
		this(x, 0);
	}

	/**
	 * on step left
	 * 
	 * @return is there enough space
	 */
	public boolean left() {
		if (x != 0) {
			--x;
			return true;
		}
		return false;

	}

	/**
	 * on line down
	 * 
	 * @return is there enough space
	 */
	public boolean down() {
		if (y < MAX_Y) {
			++y;
			return true;
		}
		return false;
	}

	/**
	 * on line right
	 * 
	 * @return is there enough space
	 */
	public boolean right() {
		if (x < MAX_X) {
			++x;
			return true;
		}
		return false;
	}

	///// GETTER
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	public static void main(String[] args) {
		Point p = new Point();
		int y_start = p.getY();
		//Scanner s = new Scanner(System.in);
		char c = 255;
		boolean b=true;
		do {
//			c = (char) s.nextInt();
			try {
				c= (char) System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (c) {
			case 37: // left
				p.left();
				write(p, y_start);
				break;
			case 39: // right
				p.right();
				write(p, y_start);
				break;
			case 40: // down
				p.down();
				write(p, y_start);
				break;
			default:
				b=false;
			}
		} while (b);
	}
	public static void write(Point p, int y_start) {
		for (int x = p.getX();x>=0; --x) {
			System.out.print("\b");
			
		}
		for (int y = 0; y < y_start - p.getY(); ++y) {
			System.out.println();
		}
		for (int x = 0; x < p.getX(); ++x) {
			System.out.print("");
		}
		System.out.print("*");
		
	}
}
