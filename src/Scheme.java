public class Scheme {
    private Vector profile; //вектор документа

    public Scheme(String text, int k, int d) {
        int n = text.length();
        //массив для частот хеш-кодов
        double[] freq = new double[d];
        for (int i = 0; i < n-k+1; i++) {
            String kgram = text.substring(i, i+k);
            //узнаем хеш-код подстроки
            int hash = kgram.hashCode();
            //увеличиваем частоту с этим хеш-кодом
            freq[Math.abs(hash % d)] += 1;
        }
        //создание вектора из массива частот хеш-кодов
        Vector vector = new Vector(freq);
        //преобразование в единичный вектор
        profile = vector.direction();
    }

    //сравнение конспектов
    // (по косинусному расстоянию=скалярному произведению)
    public double similarTo(Scheme other) {
        return profile.dot(other.profile);
    }

    //чтобы выводился не объект, а текстовое представление вектора
    public String toString() {
        return "" + profile;
    }

    public static void main(String[] args) {
        //2 - длина подстроки
        int k = Integer.parseInt(args[0]);
        //16 - размер вектора
        int d = Integer.parseInt(args[1]);
        String text = "ATAGATGCATAGCGCATAGC";
        Scheme sketch = new Scheme(text, k, d);
        //StdOut.println(sketch);
    }
}
