package PointExtends;

public class Triangle extends Point {
    private Point A;
    private Point B;
    private Point C;
    public Triangle() {}
    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    public boolean isTriangle(Point a, Point b, Point c) {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ca = c.distance(a);

        return (ab + bc > ca) && (bc + ca > ab) && (ca + ab > bc);
    }
    public double Area(Point a, Point b, Point c) {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ca = c.distance(a);
        double p = (ab + bc + ca) / 2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
    }
    public boolean checkPointInTriangle(Point a, Point b, Point c, Point p) {
        double sABC = this.Area(a, b, c);
        double sABP = this.Area(a, b, p);
        double sBCP = this.Area(b, c, p);
        double sCAP = this.Area(c, a, p);
        double epsilon = 0.000001;
        return Math.abs((sABP + sBCP + sCAP) - sABC) < epsilon; // lấy giá tri tuyệt đối
    }
    public double Perimater(Point a, Point b, Point c) {
        return a.distance(b) + b.distance(c) + c.distance(a);
    }
}
