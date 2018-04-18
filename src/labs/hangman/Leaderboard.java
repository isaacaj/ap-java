package labs.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Leaderboard
{
    private Scanner scanner;
    private ArrayList<String> topScores = new ArrayList<>();

    public Leaderboard(File file) throws FileNotFoundException
    {
        scanner = new Scanner(file);


    }

    private static ArrayList<String> makeArrayList(String fileName) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<>();

        while (list.size() < 10)
        { list.add(input.nextLine()); }

        return list;
    }

    public void putToLeaderboard()
    {

    }
}
