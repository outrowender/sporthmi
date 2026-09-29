/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface RedrawContext {
    public static final int BLACK;
    public static final int WHITE;
    public static final int CYAN;
    public static final int DISABLED_OPACITY;
    public static final int TRANSPARENT;

    default public int[] setColorIndices(int[] nArray) {
    }

    default public void setActiveColorPlate(int[] nArray) {
    }

    default public int[] getActiveColorPlate() {
    }

    default public void setScreenID(int n) {
    }

    default public int getScreenID() {
    }

    default public void setNodeIndex(int n) {
    }

    default public int getNodeIndex() {
    }

    default public int getCalculatedNodeIndex(int n) {
    }

    default public int getColor(int n) {
    }
}

