/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface LabelModelApp
extends HMIModelApp {
    default public void setText(String string) {
    }

    default public String getText() {
    }

    default public int getLength() {
    }
}

