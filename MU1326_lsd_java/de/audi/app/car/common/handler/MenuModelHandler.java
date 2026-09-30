/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ModelHandler;
import de.audi.app.car.common.handler.business.MenuModelEventBusiness;
import de.audi.atip.hmi.model.menu.MenuModelApp;

public interface MenuModelHandler
extends ModelHandler {
    public void updateOnItemFocused(int var1);

    public MenuModelApp returnMenuModel();

    public MenuModelEventBusiness getMenuModelBusiness();
}

