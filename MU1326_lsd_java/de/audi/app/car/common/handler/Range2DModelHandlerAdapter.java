/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandlerAdapter;
import de.audi.app.car.common.handler.Range2DModelHandler;
import de.audi.app.car.common.handler.business.Range2DModelEventBusiness;
import de.audi.atip.hmi.model.RangeListener2D;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.log.LogChannel;

public class Range2DModelHandlerAdapter
extends ButtonModelHandlerAdapter
implements RangeListener2D,
Range2DModelHandler {
    protected Range2DModelHandlerAdapter(RangeModel2DApp rangeModel2DApp, LogChannel logChannel) {
        super(rangeModel2DApp, logChannel);
        rangeModel2DApp.setRangeListener(this);
    }

    @Override
    public void updateOnAdjustment(int n, int n2) {
    }

    @Override
    public void setValueHit(int n, int n2, int n3, int n4) {
        if (this.getHandledModelID() == n) {
            this.updateOnAdjustment(n2, n3);
        }
    }

    @Override
    public RangeModel2DApp getRange2DModel() {
        return (RangeModel2DApp)this.getHandledModel();
    }

    @Override
    public Range2DModelEventBusiness getRange2DEventBusiness() {
        return (Range2DModelEventBusiness)this.getBusiness();
    }

    @Override
    public void updateRangeModel2DLimits(int n, int n2, int n3, int n4, int n5, int n6) {
        this.getRange2DModel().setLimitsXY(n, n2, n4, n5, n3, n6);
    }

    @Override
    public void updateRangeModel2DLimitsX(int n, int n2, int n3) {
        this.getRange2DModel().setLimitsX(n, n2, n3);
    }

    @Override
    public void updateRangeModel2DLimitsY(int n, int n2, int n3) {
        this.getRange2DModel().setLimitsY(n, n2, n3);
    }

    @Override
    public void updateRange2DModelValue(int n, int n2) {
        this.getRange2DModel().setValue(n, n2);
    }

    @Override
    public void updateRangeModelValueX(int n) {
        this.getRange2DModel().setValue(n, this.getRange2DModel().getValueY());
    }

    @Override
    public void updateRangeModelValueY(int n) {
        this.getRange2DModel().setValue(this.getRange2DModel().getValueX(), n);
    }
}

