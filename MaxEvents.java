import java.util.ArrayList;
import java.util.List;


public class MaxEvents {

    /*
     * Complete the 'maxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        int count = 0;
        for(int i1 = 0; i1 < arrival.size() - 1; i1++) {
            int indexNextSmallest = i1;
            for (int i2 = i1 + 1; i2 < arrival.size(); i2++) {
                if (arrival.get(indexNextSmallest) > arrival.get(i2)) {
                    indexNextSmallest = i2;
                }
            }
            int temp = arrival.get(i1);
            int temp2 = duration.get(i1);
            arrival.set(i1, arrival.get(indexNextSmallest));
            duration.set(i1, duration.get(indexNextSmallest));
            arrival.set(indexNextSmallest, temp);
            duration.set(indexNextSmallest, temp2);
        }

        ArrayList<Integer> occupied = new ArrayList<Integer>();


        for (int i = 0; i < duration.size(); i++) {
            int time = arrival.get(i) + duration.get(i);
            if ((i < duration.size() - 1) && (time <= arrival.get(i + 1))) {
                count ++;
            }
            else if (i == duration.size() - 1) {
                count++;
            }
            else if (i < duration.size() - 1) {
                boolean test = true;
                int index = i;
                while ((index < duration.size()) && (test)) {
                    if (!arrival.get(i).equals(arrival.get(index))) {
                        if (time <= arrival.get(index) &&
                                (!occupied.contains(arrival.get(i)))) {
                            count ++;
                            occupied.add(arrival.get(i));
                            test = false;
                        }
                    }
                    index++;
                }
            }
        }
        return count;

    }

    public static void printList(List<Integer> arrivalTest)
    {
        for (int i = 0; i < arrivalTest.size(); i++)
        {
            System.out.println(arrivalTest.get(i));
        }
    }

}

