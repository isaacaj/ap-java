package experiments;

import labs.dice.Di;

import java.util.ArrayList;
import java.util.Arrays;

public class DiArray extends ArrayList<Di>
{
    private DiArray() {

    }

    public DiArray(Di[] diArray) {
        this.addAll(Arrays.asList(diArray));
    }

    public int getSumOfDiValues(){
        return this.stream().mapToInt(di -> di.getRoll()).sum();
    }
}
