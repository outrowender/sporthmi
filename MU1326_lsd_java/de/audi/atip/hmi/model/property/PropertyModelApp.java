/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.property;

import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface PropertyModelApp
extends HMIModelApp {
    default public void setProperties(int n, int[] nArray) {
    }

    default public int getCategory() {
    }

    default public int[] getProperties() {
    }
}

