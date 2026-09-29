/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface HMIView {
    default public void setModel(HMIModelGUI hMIModelGUI) {
    }

    default public int getModelID() {
    }

    default public void setStatus(int n) {
    }

    default public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }
}

