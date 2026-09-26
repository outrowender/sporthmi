/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface DragAndDropListener {
    public static final int START_DRAG_OK;
    public static final int START_DRAG_NOT_OK;
    public static final int START_DRAG_PENDING;
    public static final int OPERATION_MODE_DEFAULT_OPERATION_MODE;
    public static final int OPERATION_MODE_INSERT_BEFORE;
    public static final int OPERATION_MODE_INSERT_AFTER;
    public static final int OPERATION_MODE_REPLACE;

    default public int itemDragStarted(int n, long l, int n2) {
    }

    default public void itemDragStopped(int n, long l, int n2, long l2) {
    }

    default public void itemDropped(int n, long l, int n2, long l2, int n3, int n4) {
    }
}

