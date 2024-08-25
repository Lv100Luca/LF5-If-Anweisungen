package getMaximum;

public class Maximum{
    public int getMaximum(int number1, int number2, int number3){
        var array = new int[]{number1, number2, number3};

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

        // sort and return last element
        // to list and .max
    }
}

