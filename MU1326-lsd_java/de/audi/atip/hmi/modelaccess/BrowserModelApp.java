/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.BrowserListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface BrowserModelApp
extends HMIModelApp {
    default public void setBrowserListener(BrowserListener browserListener) {
    }
}

