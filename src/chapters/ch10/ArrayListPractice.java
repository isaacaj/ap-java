package chapters.ch10;

import java.util.ArrayList;

public class ArrayListPractice
{
    public static void main(String[] args)
    {
        testOne();
        testTwo();
        testThree();
        testFour();
        testFive();
        testSix();
        testSeven();
        testEight();
        testNine();
    }

    private static void testOne()
    {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Apple");
        stringArrayList.add("Banana");
        stringArrayList.add("Corn");

        System.out.println(maxLength(stringArrayList));

        stringArrayList.removeAll(stringArrayList);

        System.out.println(maxLength(stringArrayList));

        System.out.println("End of test 1");
    }

    private static void testTwo()
    {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(100);
        integerArrayList.add(-11);

        System.out.println(range(integerArrayList));

        integerArrayList.add(50);

        System.out.println(range(integerArrayList));

        integerArrayList.removeAll(integerArrayList);

        System.out.println(range(integerArrayList));

        System.out.println("End of test 2");
    }

    private static void testThree()
    {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(-2);
        integerArrayList.add(7);

        System.out.println(integerArrayList.toString());
        System.out.println(minToFront(integerArrayList).toString());
        System.out.println(integerArrayList.toString());
        System.out.println("End of test 3");
    }

    private static void testFour()
    {
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("odd");
        stringArrayList.add("even");
        stringArrayList.add("ooddddddd");
        stringArrayList.add("oddod");
        stringArrayList.add("eeeevven");
        stringArrayList.add("neveneven");

        System.out.println(stringArrayList.toString());
        System.out.println(removeEvenLength(stringArrayList).toString());
        System.out.println(stringArrayList.toString());

        System.out.println("End of test 4");
    }

    private static void testFive()
    {
        ArrayList<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(stutter(list));

        System.out.println("End of test 5");
    }

    private static void testSix()
    {
        ArrayList<String> list = new ArrayList<>();

        list.add("ONE");
        list.add("TWOO");
        list.add("APPLE");
        list.add("Worddddds");
        list.add("x");
        list.add("ss");

        System.out.println(removeShorterStrings(list));

        System.out.println("End of test 6");
    }

    private static void testSeven()
    {
        ArrayList<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");

        System.out.println(switchPairs(list));
        System.out.println("End of test 7");
    }

    private static void testEight()
    {
        ArrayList<String> list = new ArrayList<>();

        list.add("be");
        list.add("be");
        list.add("is");
        list.add("not");
        list.add("or");
        list.add("question");
        list.add("that");
        list.add("the");
        list.add("to");
        list.add("to");

        System.out.println(removeDuplicates(list));
        System.out.println("End of test 8");
    }

    private static void testNine()
    {
        ArrayList<String> list = new ArrayList<>();

        list.add("beee");
        list.add("beee");
        list.add("is");
        list.add("not");
        list.add("or");
        list.add("question");
        list.add("that");
        list.add("the");
        list.add("tooo");
        list.add("to");

        System.out.println(markLength4(list));
        System.out.println("End of test 9");
    }

    private static int maxLength(ArrayList<String> list)
    {
        if (list.size() == 0)
        {
            return 0;
        }

        String longest = list.get(0);
        for (String s : list)
        {
            if (s.length() > longest.length())
            {
                longest = s;
            }
        }

        return longest.length();
    }

    private static int range(ArrayList<Integer> list)
    {
        if (list.size() == 0)
        {
            return 0;
        }

        int range = 0;

        for (int i : list)
        {
            for (int j : list)
            {
                if (Math.abs(i - j) > range)
                {
                    range = Math.abs(i - j);
                }
            }
        }

        return range + 1;
    }

    private static ArrayList<Integer> minToFront(ArrayList<Integer> list)
    {
        if (list.size() == 0)
            return list;

        int min = list.get(0);

        for (int i : list)
            if (i < min)
                min = i;

        list.remove(list.indexOf(min));
        list.add(0, min);

        return list;
    }

    private static ArrayList<String> removeEvenLength(ArrayList<String> list)
    {
        ArrayList<Integer> indexesOfEvens = new ArrayList<>();
        for (String s : list)
            if (s.length() % 2 == 0)
                indexesOfEvens.add(list.indexOf(s));

        int count = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).equalsIgnoreCase(list.get(indexesOfEvens.get(count))))
            {
                indexesOfEvens.remove(count);
                list.remove(i);
            }
        }

        return list;
    }

    private static ArrayList<String> stutter(ArrayList<String> list)
    {
        ArrayList<String> stutter = new ArrayList<>();

        for (String s : list)
        {
            stutter.add(s);
            stutter.add(s);
        }

        return stutter;
    }

    private static ArrayList<String> removeShorterStrings(ArrayList<String> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i).length() > list.get(i + 1).length())
            {
                list.remove(i + 1);
            } else
            {
                list.remove(i);
            }
        }

        return list;
    }

    private static ArrayList<String> switchPairs(ArrayList<String> list)
    {
        String swap;

        if (list.size() % 2 != 0)
        {
            for (int i = 0; i < list.size() - 1; i += 2)
            {
                swap = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, swap);
            }
        } else
        {
            for (int i = 0; i < list.size(); i += 2)
            {
                swap = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, swap);
            }
        }

        return list;
    }

    private static ArrayList<String> removeDuplicates(ArrayList<String> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i).equalsIgnoreCase(list.get(i + 1)))
                list.remove(i + 1);
        }

        return list;
    }

    private static ArrayList<String> markLength4(ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).length() == 4)
            {
                list.add(i, "****");
                i++;
            }
        }

        return list;
    }
}
