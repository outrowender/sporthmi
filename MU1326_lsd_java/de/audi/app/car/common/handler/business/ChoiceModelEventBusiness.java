/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.app.car.common.handler.business.HandlerTransactionData;

public interface ChoiceModelEventBusiness
extends ButtonModelEventBusiness {
    public boolean processItemSelected(int var1, ChoiceModelHandler var2);

    public boolean processItemFocused(int var1, ChoiceModelHandler var2);

    public boolean processItemSelected(HandlerTransactionData var1, ChoiceModelHandler var2);

    public boolean processItemFocused(HandlerTransactionData var1, ChoiceModelHandler var2);
}

