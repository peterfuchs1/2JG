package test4;
public class Y extends X {
  private int yVar;
  public Y(int xVar, int yVar) {
	  super(xVar);
    this.yVar = yVar;
    //super.setX(xVar);
  }
  public void setY(int y) {yVar = y; }
  public int getY() { return yVar; }
}
