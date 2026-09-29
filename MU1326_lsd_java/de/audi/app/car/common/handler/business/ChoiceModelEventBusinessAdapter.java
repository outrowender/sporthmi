/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusinessAdapter;
import de.audi.app.car.common.handler.business.ChoiceModelEventBusiness;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class ChoiceModelEventBusinessAdapter
extends ButtonModelEventBusinessAdapter
implements ChoiceModelEventBusiness {
    protected ChoiceModelEventBusinessAdapter(DSIBase dSIBase, LogChannel logChannel) {
        super(dSIBase, logChannel);
    }

    @Override
    public boolean processItemSelected(int n, ChoiceModelHandler choiceModelHandler) {
        return false;
    }

    @Override
    public boolean processItemFocused(int n, ChoiceModelHandler choiceModelHandler) {
        return false;
    }

    @Override
    public boolean processItemSelected(HandlerTransactionData handlerTransactionData, ChoiceModelHandler choiceModelHandler) {
        return false;
    }

    @Override
    public boolean processItemFocused(HandlerTransactionData handlerTransactionData, ChoiceModelHandler choiceModelHandler) {
        return false;
    }
}

