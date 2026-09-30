/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.ChoiceModelEventBusiness;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public interface ChoiceModelHandler
extends ButtonModelHandler {
    public void updateOnItemSelected(int var1);

    public void updateOnItemFocused(int var1);

    public void updateChoiceModelValue(int var1);

    public ChoiceModelApp getChoiceModel();

    public ChoiceModelEventBusiness getChoiceModelBusiness();
}

