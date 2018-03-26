package labs.people;

public class PersonRunner
{
    public static void main(String[] args)
    {
        Person me = new Person("Isaac", "Ash", 16);
        System.out.println(me);

        me.birthday();

        me.setFirst("Ritik");
        me.setLast("Mishra");
        me.setAge(14);

        System.out.println(me);

        Person notMe = new Person("Isaac", "Ash", 16);

        System.out.println(notMe);

        System.out.println("Unique? " + me.isUnique(notMe));

    }
}
