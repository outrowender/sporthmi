/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cas;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.cas.CasDisclaimer$CasDisclaimerDismissButtonHandler;
import de.audi.tv.app.cas.CasDisclaimer$SelectionListener;
import de.audi.tv.app.cas.CasDisclaimer$TVEventListener;
import de.audi.tv.app.cas.CasDisclaimer$TVListenerImpl;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.tm.KeyPanelHandler;

public class CasDisclaimer {
    private static final int HIDE_CAS_DISCLAIMER;
    private static final int SHOW_CAS_DISCLAIMER;
    public final DefaultTVListener tvListener = new CasDisclaimer$TVListenerImpl(this, null);
    public final CasDisclaimer$TVEventListener eventListener = new CasDisclaimer$TVEventListener(this, null);
    public final DSICallListener callListener = new CasDisclaimer$SelectionListener(this, null);
    private final TVEnv env;
    private final KeyPanelHandler keyPanelHandler;
    private volatile boolean isCasDisclaimerActive = false;
    private volatile boolean isAVActive = false;
    private volatile boolean isEnergySavingModeActive = false;
    private final ChoiceModelApp showCasDisclaimerChoice;

    public CasDisclaimer(TVEnv tVEnv, KeyPanelHandler keyPanelHandler) {
        this.env = tVEnv;
        this.keyPanelHandler = keyPanelHandler;
        tVEnv.getButtonModel(363669248).setButtonListener(new CasDisclaimer$CasDisclaimerDismissButtonHandler(this, null));
        this.showCasDisclaimerChoice = tVEnv.getChoiceModel(-1850988800);
        this.showCasDisclaimerChoice.setValue(0);
        this.showCasDisclaimerChoice.forceUpdate(true);
    }

    private void show(boolean bl) {
        if (!this.isCasDisclaimerActive || bl) {
            this.env.lcDSI.log(1078071040, "[CasDisclaimer.show] reshowOverride: %1", bl);
            this.env.properties.terminalMode.desiredTerminalMode.accept(new Integer(12));
            this.showCasDisclaimerChoice.setValue(1);
            this.isCasDisclaimerActive = true;
        }
    }

    private void hide() {
        if (this.isCasDisclaimerActive) {
            this.env.lcDSI.log(1078071040, "[CasDisclaimer.hide]");
            this.showCasDisclaimerChoice.setValue(0);
            this.isCasDisclaimerActive = false;
        }
    }

    static /* synthetic */ TVEnv access$400(CasDisclaimer casDisclaimer) {
        return casDisclaimer.env;
    }

    static /* synthetic */ void access$500(CasDisclaimer casDisclaimer, boolean bl) {
        casDisclaimer.show(bl);
    }

    static /* synthetic */ void access$600(CasDisclaimer casDisclaimer) {
        casDisclaimer.hide();
    }

    static /* synthetic */ boolean access$700(CasDisclaimer casDisclaimer) {
        return casDisclaimer.isCasDisclaimerActive;
    }

    static /* synthetic */ boolean access$800(CasDisclaimer casDisclaimer) {
        return casDisclaimer.isAVActive;
    }

    static /* synthetic */ boolean access$900(CasDisclaimer casDisclaimer) {
        return casDisclaimer.isEnergySavingModeActive;
    }

    static /* synthetic */ boolean access$802(CasDisclaimer casDisclaimer, boolean bl) {
        casDisclaimer.isAVActive = bl;
        return casDisclaimer.isAVActive;
    }

    static /* synthetic */ boolean access$902(CasDisclaimer casDisclaimer, boolean bl) {
        casDisclaimer.isEnergySavingModeActive = bl;
        return casDisclaimer.isEnergySavingModeActive;
    }

    static /* synthetic */ KeyPanelHandler access$1000(CasDisclaimer casDisclaimer) {
        return casDisclaimer.keyPanelHandler;
    }
}

