/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

public interface ICursorComponent {
    public static final int NO_SELECTION;

    default public int getIndex() {
    }

    default public int getSubindex() {
    }

    default public String getId() {
    }

    default public String getSubid() {
    }

    default public int getRightDrawerIndex() {
    }

    default public ICursorComponent withRightDrawerIndex(int n) {
    }

    default public ICursorComponent withValues(int n, int n2, String string, String string2) {
    }

    default public ICursorComponent withValues(int n, int n2, String string, String string2, int n3) {
    }

    default public ICursorComponent withDefaultValues() {
    }

    default public boolean equalsIgnoringRightDrawer(ICursorComponent iCursorComponent) {
    }
}

