/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.property;

import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface PropertyModelApp
extends HMIModelApp {
    public void setProperties(int var1, int[] var2);

    public int getCategory();

    public int[] getProperties();
}

