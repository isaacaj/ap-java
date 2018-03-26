package labs.people;

public class Person
{
    private static int globalSSN = 100000000;

    private String first, last;
    private int age, ssn;

    public Person(String first, String last, int age)
    {
        this.first = first;
        this.last = last;
        this.age = age;
        this.ssn = globalSSN += 1;
    }

    public Person()
    {
        this("---", "---", 0);
    }

    public String getFirst()
    {
        return first;
    }

    public void setFirst(String first)
    {
        this.first = first;
    }

    public String getLast()
    {
        return last;
    }

    public void setLast(String last)
    {
        this.last = last;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getSsn()
    {
        return ssn;
    }

    public String toString()
    {
        return first.substring(0, 1).toUpperCase() + first.substring(1) + " " + last.substring(0, 1).toUpperCase() + last.substring(1) + "\t\t| Age: " + age + " \t| SSN: " + ssn;
    }

    public boolean isUnique(Person p)
    {
        return !(p.first.equalsIgnoreCase(this.first)
                && p.last.equalsIgnoreCase(this.last)
                && p.age == this.age);
    }

    public void birthday()
    {
        this.age++;
    }
}
