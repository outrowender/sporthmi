/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.charisma;

import de.audi.app.car.common.charisma.CharismaPopupHandler;
import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusinessAdapter;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class CharismaPopupButtonListenerBusiness
extends ButtonModelEventBusinessAdapter {
    private CharismaPopupHandler popupHandler;

    public CharismaPopupButtonListenerBusiness(CharismaPopupHandler charismaPopupHandler, DSIBase dSIBase, LogChannel logChannel) {
        super(dSIBase, logChannel);
        this.popupHandler = charismaPopupHandler;
    }

    public boolean processKeyTyped(int n, ButtonModelHandler buttonModelHandler) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CharismaButtonListenerBusiness#processKeyTyped] DDS push on Charisma Screen");
        }
        return this.popupHandler.buttonPopupRequest();
    }
}

