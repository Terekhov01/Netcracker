package task1.quadraticEquations;
/*
Разработайте класс для решения квадратных уравнений. Вычисление
дискриминанта должен осуществлять вложенный класс. После компиляции
объясните структуру class файлов. Проанализируйте использование вложенного
класса.
 */
public class QuadraticEquations {
    private double x1;
    private double x2;
    static class Discriminant{
        double findDiscriminant(double a, double b, double c){
            return Math.pow(b, 2) -4*a*c;
        }
    }
    void solve(double a, double b, double c){
        Discriminant discriminant = new QuadraticEquations.Discriminant();
        double d = discriminant.findDiscriminant(a, b, c);
        x1 = (-b + Math.sqrt(d))/(2*a);
        x2 = (-b - Math.sqrt(d))/(2*a);
    }

    public static void main(String[] args) {
        QuadraticEquations quadraticEquations = new QuadraticEquations();
        quadraticEquations.solve(1, 4, 4);
        System.out.println("a = 1   b = 4   c = 4");
        System.out.println("x1 = " + quadraticEquations.x1 + "\nx2 = " + quadraticEquations.x2);
    }
}