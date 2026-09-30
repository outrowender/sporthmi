/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.app.car.common.handler.business.HandlerTransactionData;

public interface RangeModelEventBusiness
extends ButtonModelEventBusiness {
    public boolean processAdjustment(int var1, RangeModelHandler var2);

    public boolean processAdjustment(HandlerTransactionData var1, RangeModelHandler var2);
}

