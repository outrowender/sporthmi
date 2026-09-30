/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ModelHandler;
import de.audi.app.car.common.handler.business.ModelEventBusiness;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;

public class ModelHandlerAdapter
implements ModelHandler {
    private LogChannel logChannel;
    private HMIModelApp model;
    private ModelEventBusiness business;

    protected ModelHandlerAdapter(HMIModelApp hMIModelApp, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.model = hMIModelApp;
    }

    public void deinitModel() {
        this.getHandledModel().resetListener();
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public int getHandledModelID() {
        return this.model.getID();
    }

    public HMIModelApp getHandledModel() {
        return this.model;
    }

    public void fireEvent() {
        if (!this.model.fireEvent(0)) {
            this.getLogChannel().log(1000, "Model with ID=%1 has no event attatched", (long)this.model.getID());
        }
    }

    public void setBusiness(ModelEventBusiness modelEventBusiness) {
        this.business = modelEventBusiness;
    }

    public ModelEventBusiness getBusiness() {
        return this.business;
    }
}

