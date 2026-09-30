/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.property;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface PropertyModelGui
extends HMIModelGUI {
    public int getCategory();

    public int[] getProperties();
}

