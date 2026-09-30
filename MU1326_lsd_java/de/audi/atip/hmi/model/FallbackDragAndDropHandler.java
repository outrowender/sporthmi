/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.DragAndDropListener;
import de.audi.atip.hmi.model.IDragAndDropHandler;

public final class FallbackDragAndDropHandler
implements IDragAndDropHandler {
    public static final FallbackDragAndDropHandler INSTANCE = new FallbackDragAndDropHandler();

    private FallbackDragAndDropHandler() {
    }

    public void stopDrag(int n, long l, int n2, long l2) {
    }

    public int startDrag(int n, long l, int n2) {
        return 1;
    }

    public void drop(int n, long l, int n2, long l2, int n3, int n4) {
    }

    public void addListener(DragAndDropListener dragAndDropListener) {
    }
}

