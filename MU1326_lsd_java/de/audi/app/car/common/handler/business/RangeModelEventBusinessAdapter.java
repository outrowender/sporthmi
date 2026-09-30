/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusinessAdapter;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.common.handler.business.RangeModelEventBusiness;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class RangeModelEventBusinessAdapter
extends ButtonModelEventBusinessAdapter
implements RangeModelEventBusiness {
    public RangeModelEventBusinessAdapter(DSIBase dSIBase, LogChannel logChannel) {
        super(dSIBase, logChannel);
    }

    public boolean processAdjustment(int n, RangeModelHandler rangeModelHandler) {
        return false;
    }

    public boolean processAdjustment(HandlerTransactionData handlerTransactionData, RangeModelHandler rangeModelHandler) {
        return false;
    }
}

