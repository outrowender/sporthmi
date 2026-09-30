/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.tv.app.tm.ITouchFlickGestureRecognitionListener;

public class TouchFlickGestureRecognition {
    public static final int THRESHOLD_DISTANCE = 80;
    public static final int THRESHOLD_TIME = 250;
    public Clock clock;
    private ITouchFlickGestureRecognitionListener listener;
    private boolean moving = false;
    private long startTime = 0L;
    private int startX;
    private int startY;
    private int currX;
    private int currY;

    public TouchFlickGestureRecognition(ITouchFlickGestureRecognitionListener iTouchFlickGestureRecognitionListener) {
        this(iTouchFlickGestureRecognitionListener, new RealClock());
    }

    TouchFlickGestureRecognition(ITouchFlickGestureRecognitionListener iTouchFlickGestureRecognitionListener, Clock clock) {
        this.listener = iTouchFlickGestureRecognitionListener;
        this.clock = clock;
    }

    public void startMove() {
        this.startTime = this.clock.getTime();
        this.startX = 0;
        this.currX = 0;
        this.startY = 0;
        this.currY = 0;
    }

    public void move(int n, int n2, int n3, int n4) {
        if (!this.moving || this.clock.getTime() - this.startTime > 250L) {
            this.startTime = this.clock.getTime();
            this.moving = true;
            this.startX = n;
            this.startY = n2;
        }
        this.currX = n3;
        this.currY = n4;
    }

    public void stopMove() {
        this.moving = false;
        long l = this.clock.getTime() - this.startTime;
        int n = this.euclideanDistance(this.startX, this.startY, this.currX, this.currY);
        int n2 = this.currX - this.startX;
        int n3 = this.currY - this.startY;
        if (l < 250L && n > 80) {
            if (Math.abs(n2) > Math.abs(n3)) {
                if (n2 > 0) {
                    this.listener.flickRight();
                } else {
                    this.listener.flickLeft();
                }
            } else if (n3 > 0) {
                this.listener.flickDown();
            } else {
                this.listener.flickUp();
            }
        } else {
            this.listener.tap();
        }
    }

    private int euclideanDistance(int n, int n2, int n3, int n4) {
        return (int)Math.sqrt(Math.pow(n - n3, 2.0) + Math.pow(n2 - n4, 2.0));
    }

    public static interface Clock {
        public long getTime();
    }

    private static class RealClock
    implements Clock {
        private RealClock() {
        }

        public long getTime() {
            return System.currentTimeMillis();
        }
    }
}

