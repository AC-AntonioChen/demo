package normal;

import org.junit.Test;

public class No_0134 {
    @Test
    public void test() {

    }

    /**
     * 可以完成电路
     *
     * @param gas  气体
     * @param cost 费用
     * @return int
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int stationLength = gas.length;
        int curIndex = 0;
        while (curIndex < stationLength) {
            int arriveStationCount = 0;
            int costCount = 0;
            int gasCount = 0;
            while (arriveStationCount < stationLength) {
                int arriveStationIndex = (curIndex + arriveStationCount) % stationLength;
                costCount = costCount + cost[arriveStationIndex];
                gasCount = gasCount + gas[arriveStationIndex];
                if (gasCount < costCount) {
                    break;
                }
                arriveStationCount++;
            }
            if (arriveStationCount >= stationLength) {
                return curIndex;
            } else {
                curIndex = curIndex + arriveStationCount + 1;
            }
        }
        return -1;
    }


//    暴力解法
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//
//        for (int i = 0; i < gas.length; i++) {
//            if (gas[i] < cost[i]) {
//                continue;
//            }
//            int curGas = 0;
//            boolean isFinishCircle = true;
//            for (int j = i; j <= gas.length + i; j++) {
//                int curIndex = j % gas.length;
//                curGas = curGas + gas[curIndex];
//                curGas = curGas - cost[curIndex];
//                if (curGas < 0) {
//                    isFinishCircle = false;
//                    break;
//                }
//            }
//            if (isFinishCircle) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
