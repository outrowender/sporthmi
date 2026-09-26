/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.DragAndDropListener;

public class FallbackDragAndDropListener
implements DragAndDropListener {
    public static final FallbackDragAndDropListener INSTANCE = new FallbackDragAndDropListener();

    private FallbackDragAndDropListener() {
    }

    @Override
    public int itemDragStarted(int n, long l, int n2) {
        return 1;
    }

    @Override
    public void itemDropped(int n, long l, int n2, long l2, int n3, int n4) {
    }

    @Override
    public void itemDragStopped(int n, long l, int n2, long l2) {
    }
}

