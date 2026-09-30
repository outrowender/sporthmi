/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

public interface ITimerListener {
    public void fireTimer();

    public void cancelTimer();

    public static class Stub
    implements ITimerListener {
        public void fireTimer() {
        }

        public void cancelTimer() {
        }
    }
}

