package net.thumbtack.school.ttschool;

import java.io.Serializable;
import java.util.Objects;

public class Trainee implements Serializable{

    private static final long serialVersionUID = -2010372504089559489L;
    private String firstName, lastName;
    private int rating;

    public Trainee(String firstName, String lastName, int rating) throws TrainingException {
        setFirstName(firstName);
        setLastName(lastName);
        setRating(rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainee)) return false;
        Trainee trainee = (Trainee) o;
        return getRating() == trainee.getRating() &&
                getFirstName().equals(trainee.getFirstName()) &&
                getLastName().equals(trainee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getRating());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName().concat(" ").concat(getLastName());
    }

    public int getRating() {
        return rating;
    }

    public void setFirstName(String firstName) throws TrainingException {
        if (firstName == null || firstName.equals(""))
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_FIRSTNAME);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws TrainingException {
        if (lastName == null || lastName.equals(""))
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_LASTNAME);
        this.lastName = lastName;
    }

    public void setRating(int rating) throws TrainingException {
        if (rating < 1 || rating > 5)
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_RATING);
        this.rating = rating;
    }
}
