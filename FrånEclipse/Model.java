package FrånEclipse;

import java.util.HashMap;

public class Model {
    HashMap<Integer, Long> computeList = new HashMap<Integer, Long>();

    private void addValueToMemory(Integer value, Long result) {
        computeList.put(value, result);
    }
    public void clearMemory() {
        computeList.clear();
    }
    private Long getValueFromMemory(Integer value) {
        if(computeList.containsKey(value)) {
            return computeList.get(value);
        }else {
            return null;
        }
    }
    private long computePower(int power) {
        if (power == 0) {
            return 1;
        }else {
            return 2 * computePower(power - 1);
        }
    }
    public long compute2Power(int power) {
        if(power < 0) {
            throw new IllegalArgumentException();
        }else if(computeList.containsKey(power)) {
            return getValueFromMemory(power);
        } else {
            long result = computePower(power);
            addValueToMemory(power, result);
            return result;
        }
    }
}
