import java.util.*;
class Point {
 int x, y;
 Point(int x, int y) {
 this.x = x;
 this.y = y;
 }
}
class ConvexHull{
 public static int OrientationMatch(Point check1, Point check2, Point check3) {
 int val = (check2.y - check1.y) * (check3.x - check2.x) - (check2.x -
check1.x) * (check3.y - check2.y);
 if (val == 0)
 return 0;
 return (val > 0) ? 1 : 2;
 }
 public static void convex_hull(Point points[], int lengths) {
 if (lengths<3) return;
 Vector<Point> result = new Vector<Point> ();
 int leftmost = 0;
 for (int i = 1; i<lengths; i++)
 if (points[i].x<points[leftmost].x)
 leftmost = i;
 int p = leftmost, pointq;
 do {
 result.add(points[p]);
 pointq = (p + 1) % lengths;
 for (int i = 0; i<lengths; i++) {
 if (OrientationMatch(points[p], points[i], points[pointq]) == 2) {
 pointq = i;
 }
 }
 p = pointq;
 }
 while (p != leftmost);
 System.out.print("The points in the convex hull are: ");
 for (Point temp: result)
 System.out.println("(" + temp.x + ", " + temp.y + ")");
 }
 public static void main(String[] args) {
 Point points[] = new Point[7];
 points[0] = new Point(0, 3);
 points[1] = new Point(2, 3);
 points[2] = new Point(1, 1);
 points[3] = new Point(2, 1);
 points[4] = new Point(3, 0);
 points[5] = new Point(0, 0);
 points[6] = new Point(3, 3);
 int lengths = points.length;
 convex_hull(points, lengths);
int lengths = points.length;
 convex_hull(points, lengths);
 }
}