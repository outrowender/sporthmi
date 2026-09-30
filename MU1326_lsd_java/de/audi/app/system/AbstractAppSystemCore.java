/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.AbstractAppManagerCore;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;

public abstract class AbstractAppSystemCore
implements HMIApplication {
    private final IFrameworkAccess framework;
    private final LogChannel log;

    AbstractAppSystemCore(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("App.System.Evo");
    }

    protected IFrameworkAccess getFramework() {
        return this.framework;
    }

    protected IHMIServiceApp getHMIService() {
        return this.getFramework().getHmiServiceApp();
    }

    protected void fireSMEvent(int n, int n2) {
        this.getHMIService().fireSMEvent(n, n2);
    }

    protected LogChannel getLog() {
        return this.log;
    }

    protected abstract AbstractAppManagerCore getAppManager();

    public int getId() {
        return 0;
    }

    public ButtonModelApp getVirtualButton(int n) {
        switch (n) {
            case 2: {
                return this.getHMIService().getButtonModel(0, 427);
            }
            case 3: {
                return this.getHMIService().getButtonModel(0, 148);
            }
        }
        return (ButtonModelApp)((Object)this.getAppManager().getVirtualButton(n));
    }

    public void popupVisible(int n, int n2) {
    }

    public void popupHidden(int n, int n2) {
    }

    public void popupRemoved(int n, int n2) {
    }

    public void screenVisible(int n, int n2) {
    }

    public void screenHidden(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
    }

    public void screenConnected(int n, int n2) {
    }
}

