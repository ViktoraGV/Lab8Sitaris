package radomskaya.account;

import radomskaya.entity.Student;

public class AccountScore {

    private double score;

    public double count(Student student) {
        score = (Double.parseDouble(student.getMarkMath())+Double.parseDouble(student.getMarkRussian()))/2;
        return score;
    }
}
