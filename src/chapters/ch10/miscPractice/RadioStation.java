package chapters.ch10.miscPractice;

public class RadioStation
{
    private String name, band;
    private double station;
    private RadioStation link;

    public RadioStation(String name, String band, double station)
    {
        this.name = name;
        this.band = band;
        this.station = station;
    }

    public String getName()
    {
        return name;
    }

    public String getBand()
    {
        return band;
    }

    public double getStation()
    {
        return station;
    }

    public void simulcast(RadioStation link)
    {
        this.link = link;
    }

    @Override
    public String toString()
    {
        if (this.link != null)
        {
            return this.link.toString();
        }

        return this.name + " " + this.band + " " + this.station;
    }

    public int compareTo(RadioStation r)
    {
        if (!(this.band.equalsIgnoreCase(r.getBand())))
        {
            return 0 > this.band.compareToIgnoreCase(r.getBand()) ? -1 : 1;
        }

        if (this.station != r.getStation())
        {
            return r.getStation() > this.station ? 1 : -1;
        }

        return 0;
    }


    public static void main(String[] args)
    {
        RadioStation station1 = new RadioStation("STATION", "XM", 100.1);
        RadioStation station2 = new RadioStation("STATION", "AM", 100.1);

        System.out.println(station1.compareTo(station1));
        System.out.println(station1.compareTo(station2));
        System.out.println(station2.compareTo(station1));
    }
}
