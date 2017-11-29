package leetcode.String_657;

/**
 * Created by felix on 2017/11/29. https://leetcode.com/problems/judge-route-circle/description/
 */
public class Solution {

  class Point{

    private int x;
    private int y;

    public Point(){
      this.x=0;
      this.y=0;
    }

    public void moveX(int dx){
      this.x+=dx;
    }

    public void moveY(int dy){
      this.x+=dy;
    }

    public boolean isOrigin(){
      return this.x==0&&this.y==0;
    }
  }


  /**
   * 定义Point(x,y)结构,遍历每一个move动作，最后看结束的点是否在原点。
   * @param moves
   * @return
   */
  public boolean judgeCircle(String moves) {
    Point p = new Point();
    for (char c : moves.toCharArray()) {
      switch (c){
        case 'U':
          p.moveY(1);
          break;
        case 'D':
          p.moveY(-1);
          break;
        case 'L':
          p.moveX(-1);
          break;
        case 'R':
          p.moveX(1);
          break;
      }
    }

    return p.isOrigin();
  }

  public static void main(String args[]) {
    Solution solution = new Solution();
    solution.judgeCircle("UD");
  }
}
