/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.RangeModelEventBusiness;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

public interface RangeModelHandler
extends ButtonModelHandler {
    public void updateOnAdjustment(int var1);

    public RangeModelApp getRangeModel();

    public RangeModelEventBusiness getRangeEventBusiness();

    public void updateRangeModelLimits(int var1, int var2, int var3);

    public void updateRangeModelValue(int var1);
}

