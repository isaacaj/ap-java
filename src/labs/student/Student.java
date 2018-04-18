package labs.student;

public class Student
{
    private String name;
    private int ID, gradeLevel;

    private static int globalID = 10000000;

    public Student()
    {
        this("", 0);
    }

    public Student(String name)
    {
        this(name, 0);
    }

    public Student(String name, int gradeLevel)
    {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.ID = globalID++;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getGradeLevel()
    {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel)
    {
        this.gradeLevel = gradeLevel;
    }

    public int getID()
    {
        return ID;
    }

    public String toString()
    {
        return this.name + ", grade " + gradeLevel + ", ID: " + ID;
    }
}
