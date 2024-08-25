package gradesWithIHKScheme;

public class GradeCalculator {
    public int calculateGrade(double points, int reachablePoints){
        var grades = new int[]{-1, 92, 81, 67, 50, 30}; // index of array represents grade, index 0 is not a grade

        if (points > reachablePoints)
            return -1;

        var percentage = (int) Math.round(points / reachablePoints * 100);

        for (int i = 1; i < grades.length; i++) {
            if (percentage >= grades[i])
                return i; // return grade that meets threshold
        }
        return grades.length; // return lowest grade when other grades dont meet

    }
}