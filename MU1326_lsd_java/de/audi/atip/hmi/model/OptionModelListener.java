/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface OptionModelListener {
    public static final int ACTION_SAVE_FAVORITE_DISABLED;

    default public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    default public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    default public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    default public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

