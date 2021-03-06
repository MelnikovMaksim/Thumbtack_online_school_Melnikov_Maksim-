package net.thumbtack.school.ttschool;

import java.util.*;

public class School {
    private String name;
    private int year;
    private Set<Group> groups = new TreeSet<>(Comparator.comparing(Group::getName));

    public School(String name, int year) throws TrainingException {
        this.setName(name);
        this.setYear(year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals("")) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        if (!groups.add(group)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
        }
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!groups.remove(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public void removeGroup(String name) throws TrainingException {
        Group group = new Group(name, "/n");
        if (!groups.remove(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        School school = (School) o;
        return getYear() == school.getYear() &&
                Objects.equals(getName(), school.getName()) &&
                Objects.equals(getGroups(), school.getGroups());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getYear(), getGroups());
    }
}
