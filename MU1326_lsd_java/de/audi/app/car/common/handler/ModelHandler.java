/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.business.ModelEventBusiness;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;

public interface ModelHandler {
    public void setBusiness(ModelEventBusiness var1);

    public ModelEventBusiness getBusiness();

    public void deinitModel();

    public void fireEvent();

    public int getHandledModelID();

    public HMIModelApp getHandledModel();

    public LogChannel getLogChannel();
}

