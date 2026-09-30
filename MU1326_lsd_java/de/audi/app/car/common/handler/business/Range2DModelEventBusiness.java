/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.Range2DModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.app.car.common.handler.business.HandlerTransactionData;

public interface Range2DModelEventBusiness
extends ButtonModelEventBusiness {
    public boolean processAdjustment(int var1, int var2, Range2DModelHandler var3);

    public boolean processAdjustment(HandlerTransactionData var1, Range2DModelHandler var2);
}

