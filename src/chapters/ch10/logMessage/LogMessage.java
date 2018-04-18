package chapters.ch10.logMessage;

public class LogMessage
{
    private String machineId;
    private String description;
    private String log;


    public LogMessage(String message)
    {
        int splitter = message.indexOf(":");
        this.machineId = message.substring(0, splitter);
        this.description = message.substring(splitter + 1);

        this.log = machineId + ":" + description;
    }

    public boolean containsWord(String word)
    {
        return this.description.matches(".*\\b" + word + "\\b.*");
    }


    public String getMachineId()
    {
        return machineId;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLog()
    {
        return log;
    }
}
