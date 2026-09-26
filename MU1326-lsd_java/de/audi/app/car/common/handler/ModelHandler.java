/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.business.ModelEventBusiness;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;

public interface ModelHandler {
    default public void setBusiness(ModelEventBusiness modelEventBusiness) {
    }

    default public ModelEventBusiness getBusiness() {
    }

    default public void deinitModel() {
    }

    default public void fireEvent() {
    }

    default public int getHandledModelID() {
    }

    default public HMIModelApp getHandledModel() {
    }

    default public LogChannel getLogChannel() {
    }
}

