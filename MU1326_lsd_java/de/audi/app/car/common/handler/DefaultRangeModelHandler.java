/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.RangeModelHandlerAdapter;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;

public class DefaultRangeModelHandler
extends RangeModelHandlerAdapter {
    public DefaultRangeModelHandler(RangeModelApp rangeModelApp, LogChannel logChannel) {
        super(rangeModelApp, logChannel);
    }

    public void updateOnAdjustment(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processAdjustment(n, (RangeModelHandler)this);
        }
    }

    public void updateOnKeyPressed(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processKeyPressed(n, (ButtonModelHandler)this);
        }
    }

    public void updateOnKeyReleased(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processKeyReleased(n, (ButtonModelHandler)this);
        }
    }

    public void updateOnKeyTyped(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processKeyTyped(n, (ButtonModelHandler)this);
        }
    }
}

