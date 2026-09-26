/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.tv.app.tm.ITouchpadHandler;
import de.audi.tv.app.tm.TouchpadListener;

class TouchpadListener$1
implements ITouchpadHandler {
    private final /* synthetic */ TouchpadListener this$0;

    TouchpadListener$1(TouchpadListener touchpadListener) {
        this.this$0 = touchpadListener;
    }

    @Override
    public short touchScreenReleased() {
        return -1;
    }

    @Override
    public short touchScreenPressed() {
        return -1;
    }

    @Override
    public short keyReleased() {
        return -1;
    }

    @Override
    public short keyPressed() {
        return -1;
    }

    @Override
    public short jsWest() {
        return -1;
    }

    @Override
    public short jsSouth() {
        return -1;
    }

    @Override
    public short jsNorth() {
        return -1;
    }

    @Override
    public short jsEast() {
        return -1;
    }

    @Override
    public short increment() {
        return -1;
    }

    @Override
    public short decrement() {
        return -1;
    }
}

