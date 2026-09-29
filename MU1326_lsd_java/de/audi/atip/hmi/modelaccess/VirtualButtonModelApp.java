/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.VirtualButtonListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

public interface VirtualButtonModelApp
extends RangeModelApp {
    default public void setVirtualButtonListener(VirtualButtonListener virtualButtonListener) {
    }
}

