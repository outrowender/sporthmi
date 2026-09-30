/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.common.handler.business.ModelEventBusiness;

public interface MenuModelEventBusiness
extends ModelEventBusiness {
    public boolean processItemFocused(int var1, MenuModelHandler var2);

    public boolean processItemFocused(HandlerTransactionData var1, MenuModelHandler var2);
}

