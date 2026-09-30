/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.AbstractTelSAPUpgradeHandler;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.evo.screen.TelEvoPopupHandler;
import java.util.Map;

public class TelEvoSAPUpgradeHandler
extends AbstractTelSAPUpgradeHandler
implements IActionProxyListener {
    private volatile boolean telAppEntered;
    private TelEvoPopupHandler popupHandler;

    public TelEvoSAPUpgradeHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.popupHandler = new TelEvoPopupHandler(iTelApplication, 300014);
        this.addSubPhoneComponent(this.popupHandler);
    }

    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(8, this);
    }

    protected void processSAPUpgradeActive(boolean bl) {
        if (bl) {
            if (this.telAppEntered) {
                this.log.log(1000000, "[TelEvoSAPUpgradeHandler#processSAPUpgradeActive] sapUpgradeActive=%1 - showing popup.", bl);
                this.popupHandler.requestShowPopup();
            } else {
                this.log.log(1000000, "[TelEvoSAPUpgradeHandler#processSAPUpgradeActive] sapUpgradeActive=%1 however not in telephone context - not showing popup!", bl);
            }
        } else {
            this.log.log(1000000, "[TelEvoSAPUpgradeHandler#processSAPUpgradeActive] sapUpgradeActive=%1 - removing popup.", bl);
            this.popupHandler.requestRemovePopup();
        }
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 7) {
            this.telAppEntered = true;
        } else if (n == 8) {
            this.telAppEntered = false;
        }
    }
}

