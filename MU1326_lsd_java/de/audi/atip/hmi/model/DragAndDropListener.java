/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface DragAndDropListener {
    public static final int START_DRAG_OK = 0;
    public static final int START_DRAG_NOT_OK = 1;
    public static final int START_DRAG_PENDING = 2;
    public static final int OPERATION_MODE_DEFAULT_OPERATION_MODE = 0;
    public static final int OPERATION_MODE_INSERT_BEFORE = 1;
    public static final int OPERATION_MODE_INSERT_AFTER = 2;
    public static final int OPERATION_MODE_REPLACE = 3;

    public int itemDragStarted(int var1, long var2, int var4);

    public void itemDragStopped(int var1, long var2, int var4, long var5);

    public void itemDropped(int var1, long var2, int var4, long var5, int var7, int var8);
}

