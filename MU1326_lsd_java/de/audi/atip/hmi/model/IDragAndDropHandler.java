/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.DragAndDropListener;

public interface IDragAndDropHandler {
    default public int startDrag(int n, long l, int n2) {
    }

    default public void stopDrag(int n, long l, int n2, long l2) {
    }

    default public void drop(int n, long l, int n2, long l2, int n3, int n4) {
    }

    default public void addListener(DragAndDropListener dragAndDropListener) {
    }
}

