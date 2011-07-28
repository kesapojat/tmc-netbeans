package fi.helsinki.cs.tmc.data;

public class Course {

    private String name;
    
    private ExerciseCollection exercises;
    
    
    public Course() {
        this(null);
    }

    public Course(String name) {
        this.name = name;
        this.exercises = new ExerciseCollection();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name == null) throw new NullPointerException("name was null at Course.setName");
        if(name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty at Course.setName");
        
        this.name = name;
    }

    public ExerciseCollection getExercises() {
        return exercises;
    }

    public void setExercises(ExerciseCollection exercises) {
        this.exercises = exercises;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
