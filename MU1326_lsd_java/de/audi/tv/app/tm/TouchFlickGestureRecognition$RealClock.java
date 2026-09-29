/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.tv.app.tm.TouchFlickGestureRecognition$1;
import de.audi.tv.app.tm.TouchFlickGestureRecognition$Clock;

class TouchFlickGestureRecognition$RealClock
implements TouchFlickGestureRecognition$Clock {
    private TouchFlickGestureRecognition$RealClock() {
    }

    @Override
    public long getTime() {
        return System.currentTimeMillis();
    }

    /* synthetic */ TouchFlickGestureRecognition$RealClock(TouchFlickGestureRecognition$1 touchFlickGestureRecognition$1) {
        this();
    }
}

