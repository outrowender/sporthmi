/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.DragAndDropListener;

public interface IDragAndDropHandler {
    public int startDrag(int var1, long var2, int var4);

    public void stopDrag(int var1, long var2, int var4, long var5);

    public void drop(int var1, long var2, int var4, long var5, int var7, int var8);

    public void addListener(DragAndDropListener var1);
}

