/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.ModelHandlerAdapter;
import de.audi.app.car.common.handler.business.MenuModelEventBusiness;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.log.LogChannel;

public class MenuModelHandlerAdapter
extends ModelHandlerAdapter
implements MenuModelHandler,
MenuModelListener {
    protected MenuModelHandlerAdapter(MenuModelApp menuModelApp, LogChannel logChannel) {
        super(menuModelApp, logChannel);
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        if (this.getHandledModelID() == n2) {
            this.updateOnItemFocused(n);
        }
    }

    @Override
    public void updateOnItemFocused(int n) {
    }

    @Override
    public MenuModelApp returnMenuModel() {
        return (MenuModelApp)this.getHandledModel();
    }

    @Override
    public MenuModelEventBusiness getMenuModelBusiness() {
        return (MenuModelEventBusiness)this.getBusiness();
    }
}

