/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.fwhmi.evo.HMIRegistryEvo;
import de.audi.tghu.hmi.AbstractTerminalContext;
import de.audi.tghu.hmi.ScreenManager;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.ITerminalContextEvo;
import de.audi.tghu.hmi.evo.PopupManagerEvo;
import de.audi.tghu.hmi.evo.ResourceManagerEvo;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationManagerEvo;
import de.audi.tghu.hmi.evo.ScreenChangeManagerEvo;
import de.audi.tghu.hmi.evo.TerminalContextEvo$1;
import de.audi.tghu.hmi.evo.TerminalContextEvo$2;
import java.io.PrintStream;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class TerminalContextEvo
extends AbstractTerminalContext
implements ITerminalContextEvo {
    private ResourceManagerEvo resourceManager;
    private IAnimationController animationController;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IMMICombiPopupManager;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IMMICombiScreenChangeManager;

    TerminalContextEvo(int n) {
        super(n);
    }

    ResourceManagerEvo getResourceManager() {
        if (this.resourceManager == null) {
            this.resourceManager = new ResourceManagerEvo(this.getFramework(), this.getTerminalID());
        }
        return this.resourceManager;
    }

    @Override
    public IScreenManager getScreenManager() {
        if (this.screenManager == null || this.popupManager == null) {
            this.initializeScreenManagers();
        }
        return this.screenManager;
    }

    @Override
    public IPopupManager getPopupManager() {
        if (this.popupManager == null || this.screenManager == null) {
            this.initializeScreenManagers();
        }
        return this.popupManager;
    }

    private void initializeScreenManagers() {
        this.screenManager = new ScreenManager(this);
        PopupManagerEvo popupManagerEvo = new PopupManagerEvo(this.screenManager, this.getFramework(), this.getFramework().getLogChannel("Fw.HMIService.Popup"));
        ScreenChangeManagerEvo screenChangeManagerEvo = new ScreenChangeManagerEvo(this, this.screenManager, popupManagerEvo, false, this.getFramework().getLogChannel("Fw.HMIService.ScreenChange"), this.getFramework().getLogChannel("Fw.Widgets.RepaintCause"));
        screenChangeManagerEvo.setAnimationManager(new ScreenChangeAnimationManagerEvo(this.screenManager, screenChangeManagerEvo, popupManagerEvo));
        this.screenManager.setScreenChangeUnit(screenChangeManagerEvo);
        popupManagerEvo.setScreenChangeUnit(screenChangeManagerEvo);
        this.popupManager = popupManagerEvo;
    }

    private void initializeCombiSyncTrackers() {
        this.initializeCombiScreenChangeTracker();
        this.initializeCombiPopupTracker();
    }

    private void initializeCombiPopupTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.getFramework().getBundleCxt(), (class$de$audi$atip$mmicombi$IMMICombiPopupManager == null ? (class$de$audi$atip$mmicombi$IMMICombiPopupManager = TerminalContextEvo.class$("de.audi.atip.mmicombi.IMMICombiPopupManager")) : class$de$audi$atip$mmicombi$IMMICombiPopupManager).getName(), (ServiceTrackerCustomizer)new TerminalContextEvo$1(this));
        serviceTracker.open();
    }

    private void initializeCombiScreenChangeTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.getFramework().getBundleCxt(), (class$de$audi$atip$mmicombi$IMMICombiScreenChangeManager == null ? (class$de$audi$atip$mmicombi$IMMICombiScreenChangeManager = TerminalContextEvo.class$("de.audi.atip.mmicombi.IMMICombiScreenChangeManager")) : class$de$audi$atip$mmicombi$IMMICombiScreenChangeManager).getName(), (ServiceTrackerCustomizer)new TerminalContextEvo$2(this));
        serviceTracker.open();
    }

    @Override
    public IPartialPopupManager getPartialPopupManager() {
        return this.getHmiTerminal().getPartialPopupManager();
    }

    IAnimationController getAnimationController() {
        if (this.animationController == null) {
            this.animationController = this.getHmiTerminal().getIAnimationController();
        }
        return this.animationController;
    }

    @Override
    public IDrawerControllerEvo[] getSelectionDrawers(int n) {
        return this.getHMIRegistryEvo().getSelectionDrawers(this.getTerminalID(), n);
    }

    @Override
    public IDrawerControllerEvo[] getOptionDrawers(int n) {
        return this.getHMIRegistryEvo().getOptionDrawers(this.getTerminalID(), n);
    }

    @Override
    public Object getKanziResource(String string, Object object, int n, int n2) {
        return this.getResourceManager().getKanziResource(string, object, n, n2, true, true);
    }

    @Override
    public Object getImageImpl(int n, boolean bl, int n2, int n3) {
        return this.getResourceManager().getImageImpl(n, bl, n2, n3);
    }

    public String toString() {
        return new StringBuffer().append("TerminalManager: ").append(this.getTerminalID()).toString();
    }

    @Override
    public void dump(PrintStream printStream) {
        printStream.print("Terminal: ");
        printStream.println(this.getTerminalID());
        this.getScreenManager().dump(printStream, "  ");
        for (int i2 = 0; i2 < this.subTerminals.length; ++i2) {
            if (this.subTerminals[i2] == null) continue;
            printStream.print("  SubTerminal: ");
            printStream.println(i2);
            this.subTerminals[i2].getScreenManager().dump(printStream, "    ");
        }
        if (this.getPopupManager() != null) {
            this.getPopupManager().dump(printStream, "  ");
        }
    }

    @Override
    public void initialize(HMIService hMIService) {
        this.fwHMI = (FwHMI)hMIService;
        this.log = this.getFramework().getLogChannel("Fw.HMIService.Main");
        this.initializeScreenManagers();
        if (this.terminalID == 0 && this.getFramework().getScreenRes() == 4 && !Boolean.getBoolean("DisableCombiSync")) {
            this.initializeCombiSyncTrackers();
        }
    }

    @Override
    protected ITerminalContext createSubTerminalContext(int n) {
        return new TerminalContextEvo(n);
    }

    protected HMIRegistryEvo getHMIRegistryEvo() {
        return (HMIRegistryEvo)this.fwHMI.getHMIRegistry();
    }

    @Override
    public void notifyScreenFadedOut(int n, int n2) {
        HMIApplication hMIApplication = this.getHMIApplication(n2 * -1601830656);
        if (hMIApplication != null) {
            hMIApplication.screenFadedOut(n, this.terminalID);
        }
    }

    @Override
    public void notifyScreenConnected(int n, int n2) {
        HMIApplication hMIApplication = this.getHMIApplication(n2 * -1601830656);
        if (hMIApplication != null) {
            hMIApplication.screenConnected(n, this.terminalID);
        }
    }

    @Override
    public Screen getPartialPopup(int n, int n2) {
        Screen screen = this.getHMIRegistry().getPartialPopup(this.getTerminalID(), n2);
        if (screen != null) {
            this.getScreenManager().getModelConnectService().modifiyModelReference(screen, true, true);
        }
        return screen;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IPopupManager access$000(TerminalContextEvo terminalContextEvo) {
        return terminalContextEvo.popupManager;
    }

    static /* synthetic */ IPopupManager access$102(TerminalContextEvo terminalContextEvo, IPopupManager iPopupManager) {
        terminalContextEvo.popupManager = iPopupManager;
        return terminalContextEvo.popupManager;
    }

    static /* synthetic */ IScreenManager access$200(TerminalContextEvo terminalContextEvo) {
        return terminalContextEvo.screenManager;
    }

    static /* synthetic */ IScreenManager access$300(TerminalContextEvo terminalContextEvo) {
        return terminalContextEvo.screenManager;
    }

    static /* synthetic */ IPopupManager access$400(TerminalContextEvo terminalContextEvo) {
        return terminalContextEvo.popupManager;
    }

    static /* synthetic */ IPopupManager access$500(TerminalContextEvo terminalContextEvo) {
        return terminalContextEvo.popupManager;
    }

    static /* synthetic */ IPopupManager access$600(TerminalContextEvo terminalContextEvo) {
        return terminalContextEvo.popupManager;
    }

    static /* synthetic */ IPopupManager access$700(TerminalContextEvo terminalContextEvo) {
        return terminalContextEvo.popupManager;
    }
}

