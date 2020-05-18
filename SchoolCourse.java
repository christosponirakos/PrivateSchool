
package sms;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Chris
 */
public class SchoolCourse {
    private Course course;
    private List<Student> listOfStudents;
    private List<Trainer> listOfTrainers;
    private List<Assignment> listOfAssignmets;

    public SchoolCourse(Course course, List<Student> listOfStudents, List<Trainer> listOfTrainers, List<Assignment> listOfAssignmets) {
        this.course = course;
        this.listOfStudents = listOfStudents;
        this.listOfTrainers = listOfTrainers;
        this.listOfAssignmets = listOfAssignmets;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public List<Trainer> getListOfTrainers() {
        return listOfTrainers;
    }

    public void setListOfTrainers(List<Trainer> listOfTrainers) {
        this.listOfTrainers = listOfTrainers;
    }

    public List<Assignment> getListOfAssignmets() {
        return listOfAssignmets;
    }

    public void setListOfAssignmets(List<Assignment> listOfAssignmets) {
        this.listOfAssignmets = listOfAssignmets;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.course);
        hash = 47 * hash + Objects.hashCode(this.listOfStudents);
        hash = 47 * hash + Objects.hashCode(this.listOfTrainers);
        hash = 47 * hash + Objects.hashCode(this.listOfAssignmets);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SchoolCourse other = (SchoolCourse) obj;
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.listOfStudents, other.listOfStudents)) {
            return false;
        }
        if (!Objects.equals(this.listOfTrainers, other.listOfTrainers)) {
            return false;
        }
        if (!Objects.equals(this.listOfAssignmets, other.listOfAssignmets)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SchoolCourse{" + "course=" + course + ", listOfStudents=" + listOfStudents + ", listOfTrainers=" + listOfTrainers + ", listOfAssignmets=" + listOfAssignmets + '}';
    }
    
    
    
}
