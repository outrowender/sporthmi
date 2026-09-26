/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.DragAndDropListener;
import de.audi.atip.hmi.model.FallbackDragAndDropListener;
import de.audi.atip.hmi.model.IDragAndDropHandler;

public final class DragAndDropHandler
implements IDragAndDropHandler {
    private final int[] possibleSourceModelIds;
    private final boolean[] shouldAskApp;
    private DragAndDropListener listener = FallbackDragAndDropListener.INSTANCE;

    public DragAndDropHandler(int[] nArray) {
        this(nArray, new boolean[nArray.length]);
    }

    public DragAndDropHandler(int[] nArray, boolean[] blArray) {
        if (nArray != null && blArray != null) {
            this.possibleSourceModelIds = nArray;
            if (nArray.length == blArray.length) {
                this.shouldAskApp = blArray;
            } else {
                this.shouldAskApp = new boolean[nArray.length];
                for (int i2 = 0; i2 < this.shouldAskApp.length && i2 < blArray.length; ++i2) {
                    this.shouldAskApp[i2] = blArray[i2];
                }
            }
        } else {
            this.possibleSourceModelIds = new int[0];
            this.shouldAskApp = new boolean[0];
        }
    }

    @Override
    public int startDrag(int n, long l, int n2) {
        for (int i2 = 0; i2 < this.possibleSourceModelIds.length; ++i2) {
            if (this.possibleSourceModelIds[i2] != n) continue;
            if (this.shouldAskApp[i2]) {
                return this.listener.itemDragStarted(n, l, n2);
            }
            return 0;
        }
        return 1;
    }

    @Override
    public void stopDrag(int n, long l, int n2, long l2) {
        this.listener.itemDragStopped(n, l, n2, l2);
    }

    @Override
    public void drop(int n, long l, int n2, long l2, int n3, int n4) {
        this.listener.itemDropped(n, l, n2, l2, n3, n4);
    }

    @Override
    public void addListener(DragAndDropListener dragAndDropListener) {
        this.listener = dragAndDropListener != null ? dragAndDropListener : FallbackDragAndDropListener.INSTANCE;
    }
}

