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

    private int n;   // ����� �������
    private double[] data; // ������ ��� ��������� �������

    //���. 1 �������� �������� ������� ����� n
    public Vector(int n) {
        this.n = n;
        this.data = new double[n];
    }

    //���. 2 �������� ������� �� ������� ���������
    public Vector(double[] data) {
        n = data.length;
        //����������� ����������� ������ � ������ �������
        this.data = new double[n];
        for (int i = 0; i < n; i++)
            this.data[i] = data[i];
    }

    //�����-������ ��� ��������� ������� �������
    public int length() {
        return n;
    }

    //������ ��� ��������� �������� �������
    public double cartesian(int i) {
        return data[i];
    }

    //��������� ������������: ������ ������� � �� ���������
    public double dot(Vector that) {
        //���� ����� �� �����, �� ��������� ������
        if (this.length() != that.length())
            System.out.println("������ ������� ��������");
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    }

    // ��������� �����
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    //��������� ���������� ����� ����� ���������
    public double distanceTo(Vector that) {
        if (this.length() != that.length())
            System.out.println("������ ������� ��������");
        return this.minus(that).magnitude();
    }

    // ������� �������� this - that
    public Vector minus(Vector that) {
        if (this.length() != that.length())
            System.out.println("������ ������� ��������");
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    }
    // ����� �������� this + that
    public Vector plus(Vector that) {
        if (this.length() != that.length())
            System.out.println("������ ������� ��������");
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    }

    //��������� ������� �� ����� (this * factor)
    public Vector scale(double factor) {
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = factor * data[i];
        return c;
    }

    //�������������� � ��������� ������
    public Vector direction() {
        if (this.magnitude() == 0.0)
            System.out.println("��� ����������� ��� �������� �������");
        return this.scale(1.0 / this.magnitude());
    }

    //����� ������� �������
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

    //��������������

}
