package sort;

public class Sort {
    public String sort(double a, double b, double c) {
        double[] list = {a, b, c};

        var sorted = bubbleSort(list);

        var sb = new StringBuilder();

        for (int i = 0; i < sorted.length; i++) {
            sb.append(i + 1).append(": ").append(sorted[i]).append("\n");
        }

        return sb.toString();
    }

    public double[] bubbleSort(double[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i] > list[j]) {
                    var temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }

        return list;
    }
}
