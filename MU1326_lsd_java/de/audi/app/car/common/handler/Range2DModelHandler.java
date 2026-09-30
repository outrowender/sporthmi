/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.Range2DModelEventBusiness;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;

public interface Range2DModelHandler
extends ButtonModelHandler {
    public void updateOnAdjustment(int var1, int var2);

    public RangeModel2DApp getRange2DModel();

    public Range2DModelEventBusiness getRange2DEventBusiness();

    public void updateRangeModel2DLimits(int var1, int var2, int var3, int var4, int var5, int var6);

    public void updateRangeModel2DLimitsX(int var1, int var2, int var3);

    public void updateRangeModel2DLimitsY(int var1, int var2, int var3);

    public void updateRange2DModelValue(int var1, int var2);

    public void updateRangeModelValueX(int var1);

    public void updateRangeModelValueY(int var1);
}

