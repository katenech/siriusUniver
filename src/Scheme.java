public class Scheme {
    private Vector profile; //������ ���������

    public Scheme(String text, int k, int d) {
        int n = text.length();
        //������ ��� ������ ���-�����
        double[] freq = new double[d];
        for (int i = 0; i < n-k+1; i++) {
            String kgram = text.substring(i, i+k);
            //������ ���-��� ���������
            int hash = kgram.hashCode();
            //����������� ������� � ���� ���-�����
            freq[Math.abs(hash % d)] += 1;
        }
        //�������� ������� �� ������� ������ ���-�����
        Vector vector = new Vector(freq);
        //�������������� � ��������� ������
        profile = vector.direction();
    }

    //��������� ����������
    // (�� ����������� ����������=���������� ������������)
    public double similarTo(Scheme other) {
        return profile.dot(other.profile);
    }

    //����� ��������� �� ������, � ��������� ������������� �������
    public String toString() {
        return "" + profile;
    }

    public static void main(String[] args) {
        //2 - ����� ���������
        int k = Integer.parseInt(args[0]);
        //16 - ������ �������
        int d = Integer.parseInt(args[1]);
        String text = "ATAGATGCATAGCGCATAGC";
        Scheme sketch = new Scheme(text, k, d);
        //StdOut.println(sketch);
    }
}
