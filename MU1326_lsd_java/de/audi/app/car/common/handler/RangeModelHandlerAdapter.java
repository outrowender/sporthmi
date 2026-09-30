/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandlerAdapter;
import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.business.RangeModelEventBusiness;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;

public class RangeModelHandlerAdapter
extends ButtonModelHandlerAdapter
implements RangeListener,
RangeModelHandler {
    protected RangeModelHandlerAdapter(RangeModelApp rangeModelApp, LogChannel logChannel) {
        super(rangeModelApp, logChannel);
        rangeModelApp.setRangeListener(this);
    }

    public void updateOnAdjustment(int n) {
    }

    public void decrement(int n, int n2, int n3) {
        if (this.getHandledModelID() == n) {
            this.updateOnAdjustment(n2 * -1);
        }
    }

    public void increment(int n, int n2, int n3) {
        if (this.getHandledModelID() == n) {
            this.updateOnAdjustment(n2);
        }
    }

    public RangeModelApp getRangeModel() {
        return (RangeModelApp)this.getHandledModel();
    }

    public RangeModelEventBusiness getRangeEventBusiness() {
        return (RangeModelEventBusiness)this.getBusiness();
    }

    public void updateRangeModelLimits(int n, int n2, int n3) {
        this.getRangeModel().setLimits(n, n2, n3);
    }

    public void updateRangeModelValue(int n) {
        this.getRangeModel().setValue(n);
    }
}

