/******************************************************************************
 *  x        =  (1.0, 2.0, 3.0, 4.0)
 *  y        =  (5.0, 2.0, 4.0, 1.0)
 *  x + y    =  (6.0, 4.0, 7.0, 5.0)
 *  10x      =  (10.0, 20.0, 30.0, 40.0)
 *  |x|      =  5.477225575051661
 *  <x, y>   =  25.0
 *  |x - y|  =  5.0990195135927845

 ******************************************************************************/

public class Vector { 

    private int n;   // длина вектора
    private double[] data; // массив для элементов вектора

    //вар. 1 создание нулевого вектора длины n
    public Vector(int n) {
        this.n = n;
        this.data = new double[n];
    }

    //вар. 2 создание вектора из массива элементов
    public Vector(double[] data) {
        n = data.length;
        //копирование поступивших данных в массив вектора
        this.data = new double[n];
        for (int i = 0; i < n; i++)
            this.data[i] = data[i];
    }

    //метод-геттер для получения размера вектора
    public int length() {
        return n;
    }

    //геттер для получения элемента вектора
    public double cartesian(int i) {
        return data[i];
    }

    //скалярное произведение: нашего вектора и из параметра
    public double dot(Vector that) {
        //если длины не равны, то вычислить нельзя
        if (this.length() != that.length())
            System.out.println("разные размеры векторов");
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    }

    // евклидова норма
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    //евклидово расстояние между двумя векторами
    public double distanceTo(Vector that) {
        if (this.length() != that.length())
            System.out.println("разные размеры векторов");
        return this.minus(that).magnitude();
    }

    // разница векторов this - that
    public Vector minus(Vector that) {
        if (this.length() != that.length())
            System.out.println("разные размеры векторов");
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    }
    // сумма векторов this + that
    public Vector plus(Vector that) {
        if (this.length() != that.length())
            System.out.println("разные размеры векторов");
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    }

    //умножение вектора на число (this * factor)
    public Vector scale(double factor) {
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = factor * data[i];
        return c;
    }

    //преобразование в единичный вектор
    public Vector direction() {
        if (this.magnitude() == 0.0)
            System.out.println("нет направления для нулевого вектора");
        return this.scale(1.0 / this.magnitude());
    }

    //вывод вектора текстом
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('(');
        for (int i = 0; i < n; i++) {
            s.append(data[i]);
            if (i < n-1) s.append(", ");
        }
        s.append(')');
        return s.toString();
    }

    //протестировать

}
