/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.HMIModel;

public interface SDSIntegerModelApp
extends HMIModel {
    default public void setValue(int n) {
    }

    default public void incrementValue(int n) {
    }

    default public int getValue() {
    }
}

