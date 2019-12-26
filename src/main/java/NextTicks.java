public class NextTicks {
    private long nextTick;

    public long getNextTick() {
        return nextTick;
    }

    public TickHandler getTh() {
        return th;
    }

    private TickHandler th;

    public NextTicks(long nextTick, TickHandler th) {

        this.nextTick = nextTick;
        this.th = th;
    }

    public void setNextTick(long next) {
        this.nextTick = next;
    }
}
