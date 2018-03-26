package chapters.ch10.logMessage;

public class LogRunner
{
    public static void main(String[] args)
    {
        LogMessage logMessage = new LogMessage("I:D PIZza D wordsssss");

        System.out.println(logMessage.containsWord("pizza"));
    }
}
