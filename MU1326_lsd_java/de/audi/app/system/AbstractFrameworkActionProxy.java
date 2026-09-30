/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.IFocusManager;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.start.IStartupManager;

public abstract class AbstractFrameworkActionProxy {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final IStartupManager stm;

    public AbstractFrameworkActionProxy(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.stm = iFrameworkAccess.getStartupMgr();
        this.log = iFrameworkAccess.getLogChannel("Fw.Framework");
    }

    protected final LogChannel getLog() {
        return this.log;
    }

    protected IFrameworkAccess getFramework() {
        return this.framework;
    }

    protected HMIService getHMIService() {
        return this.getFramework().getHMIService();
    }

    protected ChoiceModelApp getChoiceModel(int n, int n2) {
        return this.getHMIService().getChoiceModel(n, n2);
    }

    public void hkSetupDuringPowerPopup(int n) {
    }

    private ChoiceModelApp getActiveAppChoice(int n) {
        return this.getChoiceModel(n, 8);
    }

    private ChoiceModelApp getWizardAppChoice(int n) {
        return this.getChoiceModel(n, 138);
    }

    public void activeApplication(int n, int n2) {
        this.getLog().log(1000000, "FrameworkActionProxy.activeApplication(%1,%2)", (long)n, (long)n2);
        if (n2 != 0) {
            IFocusManager iFocusManager;
            this.getActiveAppChoice(0).setValue(n2);
            if (this.getFramework().getLastmodeHandler().isValidLastmode(n2)) {
                this.requestAppStart(n, n2);
            }
            if ((iFocusManager = this.getHMIService().getFocusManager()) != null) {
                iFocusManager.setActiveApplication(n, n2);
            }
        } else if (this.getFramework().isEvoHighMMIKombi()) {
            this.getActiveAppChoice(0).setValue(36);
        } else {
            this.getActiveAppChoice(0).setValue(41);
        }
    }

    public void requestAppStart(int n, int n2) {
        this.getLog().log(1000000, "FrameworkActionProxy.requestAppStart(%1,%2)", (long)n, (long)n2);
        this.stm.requestAppStart(n2);
    }

    public void mainApplicationWizardLastApplication(int n, int n2) {
        this.getLog().log(1000000, "FrameworkActionProxy.mainApplicationWizardLastApplication(%1,%2)", (long)n, (long)n2);
        this.getWizardAppChoice(n).setValue(n2);
    }

    public void mediaDomainStartupFailed(int n) {
        this.getLog().log(1000000, "[FrameworkActionProxyImpl.mediaDomainStartupFailed] Called on terminal '%1'", (long)n);
        this.getLog().log(10000, "XXX! TODO! FIXME! mediaDomainStartupFailed(..) -> create and start mediaStartupController again!!!");
    }
}

