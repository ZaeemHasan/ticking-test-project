import java.util.ArrayList;
import java.util.List;

public class TestAppV2 {

    public static void main(String[] args) {

        List<NextTicks> nextTicks = new ArrayList<>();

        ServerState rs = new ServerState();


        long nextTick = rs.tick() + currentTimeMillis();
        System.out.println("InMain:::" + rs.tick() + ":::" + nextTick + ":::" + currentTimeMillis());
        nextTicks.add(new NextTicks(nextTick, rs));

        while (true){
            tick(nextTicks);
        }

    }

    public static void tick(List<NextTicks> nextTicks) {
        if (!nextTicks.isEmpty()) {
            if (nextTicks.get(0).getNextTick() <= currentTimeMillis()) {
                System.out.println("Here:::" + nextTicks.get(0).getNextTick() + ":::" + currentTimeMillis());
                updateNextTick(nextTicks);
                System.out.println(currentTimeMillis());
            }
        }
    }


    public static long currentTimeMillis() {
        final long currentTime = System.currentTimeMillis();
        return currentTime;
    }

    // sort ticks in ascending order
    public static void orderTicks(List<NextTicks> nextTicks) {
        nextTicks.sort((a, b) -> ((Long) a.getNextTick()).compareTo(b.getNextTick()));
    }

    public static void updateNextTick(List<NextTicks> nextTicks) {
        NextTicks first = nextTicks.get(0);
        long next = first.getTh().tick() + currentTimeMillis();
        first.setNextTick(next);
        orderTicks(nextTicks);
    }
}
