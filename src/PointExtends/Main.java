package PointExtends;

public class Main extends Triangle{
    public static void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(5, 2);
        Point c = new Point(3, 6);
        Point d = new Point(1, 5);
        Triangle triangle = new Triangle();
        if(triangle.isTriangle(a,b,c)){
            System.out.println("ABC Là Tam Giác!");
            boolean check = triangle.checkPointInTriangle(a, b, c, d);
            if (check) {
                System.out.println("Điểm D thuộc tam giác ABC!");
            } else {
                System.out.println("Điểm D không thuộc tam giác ABC!");
            }
        }else{
            System.out.println("ABC không là tam giác!");
        }

    }

}
