/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelBase;

public interface HMIModelGUI
extends HMIModelBase {
    public int getModelType();

    public void addReference();

    public void removeReference();

    public int getChangeState();

    public int startDrag(int var1, long var2, int var4);

    public void stopDrag(int var1, long var2, long var4);

    public void drop(int var1, long var2, long var4, int var6, int var7);
}

