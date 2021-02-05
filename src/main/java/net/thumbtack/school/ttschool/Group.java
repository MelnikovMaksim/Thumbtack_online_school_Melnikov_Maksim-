package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String name, room;
    private List<Trainee> trainees = new ArrayList<>();

    public Group(String name, String room) throws TrainingException {
        this.setName(name);
        this.setRoom(room);
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException{
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int i) throws TrainingException{
        if (i >= 0 && i < trainees.size()) {
            trainees.remove(i);
        }
        else {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException{
        for (Trainee trainee: trainees) {
            if (firstName.equals(trainee.getFirstName())){
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException{
        for (Trainee trainee: trainees) {
            if (fullName.equals(trainee.getFullName())){
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(Comparator.comparing(Trainee::getRating).reversed());
    }

    public void reverseTraineeList(){
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions){
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (trainees.size() == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        List<Trainee> traineesWithMaxRating = new ArrayList<>();
        int maxRating = 1;
        for (Trainee trainee : trainees) {
            if (trainee.getRating() == maxRating) {
                traineesWithMaxRating.add(trainee);
            }
            if (trainee.getRating() > maxRating) {
                traineesWithMaxRating.clear();
                traineesWithMaxRating.add(trainee);
                maxRating = trainee.getRating();
            }
        }
        return traineesWithMaxRating;
    }

    public boolean hasDuplicates(){
        return !(new HashSet<>(trainees).size() == trainees.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(getName(), group.getName()) &&
                Objects.equals(getRoom(), group.getRoom()) &&
                Objects.equals(getTrainees(), group.getTrainees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRoom(), getTrainees());
    }
}
