/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.esolutions.fw.util.commons.job.Job;

public interface IKeyBoardManager {
    default public Job fireKeyEvent(int n, long l, int n2, int n3) {
    }

    default public Job fireKeyEvent(int n, long l, int n2, long l2, int n3) {
    }

    default public void fireKeyEventDirectlyInEventDispatchThread(int n, long l, int n2, int n3) {
    }

    default public Job fireJoyStickEvent(int n, long l, int n2, int n3, int n4) {
    }

    default public Job fireWheelButtonEvent(int n, long l, int n2, int n3, int n4, int n5, int n6) {
    }

    default public Job fireWheelButtonEvent(int n, long l, int n2, int n3, int n4, int n5) {
    }

    default public Job fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, int n6) {
    }

    default public Job fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
    }

    default public Job fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, boolean bl, int n6, int n7, int n8, int n9) {
    }

    default public Job fireTouchEvent(int n, long l, int n2, int n3, int n4, String string, int[] nArray, int n5) {
    }

    default public Job fireGestureEvent(int n, long l, int n2, int n3, int n4) {
    }

    default public Job fireGestureEvent(int n, int n2, int n3, int n4, int n5, int n6, long l, int n7) {
    }

    default public Job fireGestureEvent(int n, long l, int n2, int n3, String[] stringArray, int[] nArray, int n4) {
    }

    default public Job fireProximityEvent(int n, int n2) {
    }
}

