/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.Range2DModelHandlerAdapter;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.log.LogChannel;

public class DefaultRange2DModelHandler
extends Range2DModelHandlerAdapter {
    public DefaultRange2DModelHandler(RangeModel2DApp rangeModel2DApp, LogChannel logChannel) {
        super(rangeModel2DApp, logChannel);
    }

    @Override
    public void updateOnAdjustment(int n, int n2) {
        if (this.getBusiness() != null) {
            this.getRange2DEventBusiness().processAdjustment(n, n2, this);
        }
    }

    @Override
    public void updateOnKeyPressed(int n) {
        if (this.getBusiness() != null) {
            this.getRange2DEventBusiness().processKeyPressed(n, (ButtonModelHandler)this);
        }
    }

    @Override
    public void updateOnKeyReleased(int n) {
        if (this.getBusiness() != null) {
            this.getRange2DEventBusiness().processKeyReleased(n, (ButtonModelHandler)this);
        }
    }

    @Override
    public void updateOnKeyTyped(int n) {
        if (this.getBusiness() != null) {
            this.getRange2DEventBusiness().processKeyTyped(n, (ButtonModelHandler)this);
        }
    }
}

