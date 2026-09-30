/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface HMIView {
    public void setModel(HMIModelGUI var1);

    public int getModelID();

    public void setStatus(int var1);

    public void processModelUpdateEvent(ModelUpdateEvent var1);
}

