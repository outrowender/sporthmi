/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices;

import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingStatusIconHandler;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;

public class TelEvoCallForwardingStatusIconHandler
extends AbstractTelCallForwardingStatusIconHandler {
    private IHMIServiceApp hmiService;
    public static final int HIDE_CF_ICON = 0;
    public static final int SHOW_CF_ICON = 1;

    public TelEvoCallForwardingStatusIconHandler(LogChannel logChannel, IHMIServiceApp iHMIServiceApp) {
        super(logChannel);
        this.hmiService = iHMIServiceApp;
    }

    protected void showCallForwardingIcon() {
        this.log.log(1000000, "TelCallForwardingStatusIconHandler#showCallForwardingIcon()");
        this.hmiService.getChoiceModel(4550).setValue(1);
        this.hmiService.getChoiceModel(4550).setStatus(1);
    }

    protected void hideCallForwardingIcon() {
        this.log.log(1000000, "TelCallForwardingStatusIconHandler#hideCallForwardingIcon()");
        this.hmiService.getChoiceModel(4550).setValue(0);
        this.hmiService.getChoiceModel(4550).setStatus(0);
    }
}

