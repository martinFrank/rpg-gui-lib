package de.frank.martin.games.rpgguilib.input.event;

public class InputDirectionEvent extends InputEvent {

    public static final InputDirectionEvent NW = new InputDirectionEvent(-1, -1);
    public static final InputDirectionEvent N = new InputDirectionEvent(0, -1);
    public static final InputDirectionEvent NE = new InputDirectionEvent(+1, -1);
    public static final InputDirectionEvent E = new InputDirectionEvent(+1, 0);
    public static final InputDirectionEvent C = new InputDirectionEvent(0, 0);
    public static final InputDirectionEvent W = new InputDirectionEvent(-1, 0);
    public static final InputDirectionEvent SW = new InputDirectionEvent(-1, +1);
    public static final InputDirectionEvent S = new InputDirectionEvent(0, +1);
    public static final InputDirectionEvent SE = new InputDirectionEvent(+1, +1);

    private final int dx;
    private final int dy;

    public InputDirectionEvent(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

}
