/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.MenuModelHandlerAdapter;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.log.LogChannel;

public class DefaultMenuModelHandler
extends MenuModelHandlerAdapter {
    public DefaultMenuModelHandler(MenuModelApp menuModelApp, LogChannel logChannel) {
        super(menuModelApp, logChannel);
        menuModelApp.setListener(this);
    }

    @Override
    public void updateOnItemFocused(int n) {
        if (this.getBusiness() != null) {
            this.getMenuModelBusiness().processItemFocused(n, (MenuModelHandler)this);
        }
    }
}

