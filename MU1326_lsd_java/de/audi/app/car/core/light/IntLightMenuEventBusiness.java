/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.business.MenuModelEventBusinessAdapter;
import de.audi.app.car.core.light.IntLightCurrentFocus;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class IntLightMenuEventBusiness
extends MenuModelEventBusinessAdapter {
    private IntLightCurrentFocus focus;

    public IntLightMenuEventBusiness(IntLightCurrentFocus intLightCurrentFocus, DSIBase dSIBase, LogChannel logChannel) {
        super(dSIBase, logChannel);
        this.focus = intLightCurrentFocus;
    }

    @Override
    public boolean processItemFocused(int n, MenuModelHandler menuModelHandler) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[IntLightMenuEventBusiness#processItemFocused] Focus has changed to menuItemID = %1", (long)n);
        }
        this.focus.setFocus(n);
        return true;
    }
}

