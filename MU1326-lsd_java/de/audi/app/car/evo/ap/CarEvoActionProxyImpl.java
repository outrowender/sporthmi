/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.ap;

import de.audi.app.car.common.ap.AbstractCarActionProxyImpl;
import de.audi.app.car.common.ap.IActionProxyDispatcher;
import de.audi.app.car.evo.ap.CarEvoActionProxyIDs;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.statemachine.ap.CarActionProxy;
import java.util.HashMap;
import org.osgi.framework.BundleContext;

public class CarEvoActionProxyImpl
extends AbstractCarActionProxyImpl
implements CarActionProxy,
CarEvoActionProxyIDs {
    IFrameworkAccess frameworkAccess;

    public CarEvoActionProxyImpl(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IActionProxyDispatcher iActionProxyDispatcher) {
        super(iFrameworkAccess, bundleContext, iActionProxyDispatcher);
        this.frameworkAccess = iFrameworkAccess;
    }

    @Override
    public int getActionProxyInterfaceID() {
        return 2;
    }

    public void ugdoSetIdle(int n) {
    }

    @Override
    public void ugdoAbort(int n) {
        this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#ugdoAbort] called");
        this.getActionProxyDispatcher().notifyActionProxyCall(50, new HashMap());
    }

    @Override
    public void ugdoRestart(int n) {
        this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#ugdoRestart] called");
        this.getActionProxyDispatcher().notifyActionProxyCall(51, new HashMap());
    }

    @Override
    public void ugdoSync(int n) {
        this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#ugdoSync] called");
        this.getActionProxyDispatcher().notifyActionProxyCall(52, new HashMap());
    }

    @Override
    public void setIndividualEntered(int n) {
    }

    public void resetDeleteUGDOPartialPopup(int n) {
    }

    public void auxHeatNowExited(int n) {
    }

    public void auxHeatPastErrorEntered(int n) {
    }

    public void resetAuxHeatPastError(int n) {
        this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#resetAuxHeatPastError] called");
        this.getActionProxyDispatcher().notifyActionProxyCall(10, new HashMap());
    }

    @Override
    public void charismaExited(int n) {
        this.getLogChannel().log(1078071040, "CarEvoActionProxyImplementation#charismaExited()");
        this.getActionProxyDispatcher().notifyActionProxyCall(64, new HashMap());
    }

    @Override
    public void carMenusEntered(int n, boolean bl) {
    }

    @Override
    public void setCarContext(int n, int n2) {
        this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#setCarContext] context='%1'", (long)n2);
        HashMap hashMap = new HashMap(1);
        hashMap.put("CONTEXT", new Integer(n2));
        this.getActionProxyDispatcher().notifyActionProxyCall(20, hashMap);
    }

    @Override
    public void browserScreenEntered(int n) {
        this.getLogChannel().log(1078071040, "CarEvoActionProxyImplementation#carManualBrowserEnetered()");
        this.getActionProxyDispatcher().notifyActionProxyCall(1, new HashMap());
    }

    @Override
    public void browserScreenEnteredByHistory(int n) {
    }

    @Override
    public void browserScreenExited(int n) {
        this.getLogChannel().log(1078071040, "CarEvoActionProxyImplementation#carManualBrowserEnetered()");
        this.getActionProxyDispatcher().notifyActionProxyCall(2, new HashMap());
    }

    @Override
    public void browserScreenEndMediaPlayback(int n) {
        this.getLogChannel().log(1078071040, "CarEvoActionProxyImplementation#browserScreenEndMediaPlayback()");
        this.getActionProxyDispatcher().notifyActionProxyCall(4, new HashMap());
    }

    @Override
    public void browserScreenStartMediaPlayback(int n) {
        this.getLogChannel().log(1078071040, "CarEvoActionProxyImplementation#browserScreenStartMediaPlayback()");
        this.getActionProxyDispatcher().notifyActionProxyCall(3, new HashMap());
    }

    @Override
    public void charismaEntered(int n) {
        this.getLogChannel().log(1078071040, "CarEvoActionProxyImplementation#charismaEntered()");
        this.getActionProxyDispatcher().notifyActionProxyCall(60, new HashMap());
    }

    @Override
    public void resetTruffleSelection(int n) {
        this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#resetTruffleSelection]");
        this.getActionProxyDispatcher().notifyActionProxyCall(61, new HashMap());
    }

    @Override
    public void codriverMovementByDriverScreenExited(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#codriverMovementByDriverScreenExited]");
        }
        this.getActionProxyDispatcher().notifyActionProxyCall(62, new HashMap());
    }

    @Override
    public void codriverMovementByDriverScreenEntered(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#codriverMovementByDriverScreenEntered]");
        }
        this.getActionProxyDispatcher().notifyActionProxyCall(63, new HashMap());
    }

    @Override
    public void charismaMenuStateChange(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#charismaMenuStateChange] state='%1'", (long)n2);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("STATE", new Integer(n2));
        this.getActionProxyDispatcher().notifyActionProxyCall(65, hashMap);
    }

    @Override
    public void jokerKeyPopupActive(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CarEvoActionProxyImpl#jokerKeyPopupActive] state='%1'", (long)n2);
        }
        ChoiceModelApp choiceModelApp = this.frameworkAccess.getHmiServiceApp().getChoiceModel(1429342464);
        choiceModelApp.setValue(n2);
    }
}

