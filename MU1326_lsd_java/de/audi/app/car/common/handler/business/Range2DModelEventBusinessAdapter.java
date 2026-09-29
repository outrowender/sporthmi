/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.Range2DModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusinessAdapter;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.common.handler.business.Range2DModelEventBusiness;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class Range2DModelEventBusinessAdapter
extends ButtonModelEventBusinessAdapter
implements Range2DModelEventBusiness {
    protected Range2DModelEventBusinessAdapter(DSIBase dSIBase, LogChannel logChannel) {
        super(dSIBase, logChannel);
    }

    @Override
    public boolean processAdjustment(int n, int n2, Range2DModelHandler range2DModelHandler) {
        return false;
    }

    @Override
    public boolean processAdjustment(HandlerTransactionData handlerTransactionData, Range2DModelHandler range2DModelHandler) {
        return false;
    }
}

