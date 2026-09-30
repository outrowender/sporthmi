/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenChangeManager;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IMMICombiPopupManager;
import de.audi.atip.mmicombi.IMMICombiScreenChangeManager;
import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.fwhmi.evo.HMIRegistryEvo;
import de.audi.tghu.hmi.AbstractTerminalContext;
import de.audi.tghu.hmi.PopupManager;
import de.audi.tghu.hmi.ScreenManager;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.ITerminalContextEvo;
import de.audi.tghu.hmi.evo.PopupManagerEvo;
import de.audi.tghu.hmi.evo.ResourceManagerEvo;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationManagerEvo;
import de.audi.tghu.hmi.evo.ScreenChangeManagerEvo;
import java.io.PrintStream;
import org.osgi.framework.ServiceReference;
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

    public IScreenManager getScreenManager() {
        if (this.screenManager == null || this.popupManager == null) {
            this.initializeScreenManagers();
        }
        return this.screenManager;
    }

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
        ServiceTracker serviceTracker = new ServiceTracker(this.getFramework().getBundleCxt(), (class$de$audi$atip$mmicombi$IMMICombiPopupManager == null ? (class$de$audi$atip$mmicombi$IMMICombiPopupManager = TerminalContextEvo.class$("de.audi.atip.mmicombi.IMMICombiPopupManager")) : class$de$audi$atip$mmicombi$IMMICombiPopupManager).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                IMMICombiPopupManager iMMICombiPopupManager = (IMMICombiPopupManager)TerminalContextEvo.this.getFramework().getBundleCxt().getService(serviceReference);
                iMMICombiPopupManager.setMainUnitPopupManager(TerminalContextEvo.this.popupManager);
                TerminalContextEvo.this.popupManager = iMMICombiPopupManager;
                return iMMICombiPopupManager;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
            }
        });
        serviceTracker.open();
    }

    private void initializeCombiScreenChangeTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.getFramework().getBundleCxt(), (class$de$audi$atip$mmicombi$IMMICombiScreenChangeManager == null ? (class$de$audi$atip$mmicombi$IMMICombiScreenChangeManager = TerminalContextEvo.class$("de.audi.atip.mmicombi.IMMICombiScreenChangeManager")) : class$de$audi$atip$mmicombi$IMMICombiScreenChangeManager).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                IMMICombiScreenChangeManager iMMICombiScreenChangeManager = (IMMICombiScreenChangeManager)TerminalContextEvo.this.getFramework().getBundleCxt().getService(serviceReference);
                iMMICombiScreenChangeManager.setScreenChangeManager(TerminalContextEvo.this.screenManager.getScreenChangeUnit());
                TerminalContextEvo.this.screenManager.setScreenChangeUnit((IScreenChangeManager)((Object)iMMICombiScreenChangeManager));
                PopupManager popupManager = null;
                if (TerminalContextEvo.this.popupManager instanceof PopupManager) {
                    popupManager = (PopupManager)TerminalContextEvo.this.popupManager;
                } else if (TerminalContextEvo.this.popupManager instanceof IMMICombiPopupManager) {
                    popupManager = (PopupManager)((IMMICombiPopupManager)TerminalContextEvo.this.popupManager).getMainUnitPopupManager();
                }
                popupManager.setScreenChangeUnit((IScreenChangeManager)((Object)iMMICombiScreenChangeManager));
                return iMMICombiScreenChangeManager;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
            }
        });
        serviceTracker.open();
    }

    public IPartialPopupManager getPartialPopupManager() {
        return this.getHmiTerminal().getPartialPopupManager();
    }

    IAnimationController getAnimationController() {
        if (this.animationController == null) {
            this.animationController = this.getHmiTerminal().getIAnimationController();
        }
        return this.animationController;
    }

    public IDrawerControllerEvo[] getSelectionDrawers(int n) {
        return this.getHMIRegistryEvo().getSelectionDrawers(this.getTerminalID(), n);
    }

    public IDrawerControllerEvo[] getOptionDrawers(int n) {
        return this.getHMIRegistryEvo().getOptionDrawers(this.getTerminalID(), n);
    }

    public Object getKanziResource(String string, Object object, int n, int n2) {
        return this.getResourceManager().getKanziResource(string, object, n, n2, true, true);
    }

    public Object getImageImpl(int n, boolean bl, int n2, int n3) {
        return this.getResourceManager().getImageImpl(n, bl, n2, n3);
    }

    public String toString() {
        return new StringBuffer().append("TerminalManager: ").append(this.getTerminalID()).toString();
    }

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

    public void initialize(HMIService hMIService) {
        this.fwHMI = (FwHMI)hMIService;
        this.log = this.getFramework().getLogChannel("Fw.HMIService.Main");
        this.initializeScreenManagers();
        if (this.terminalID == 0 && this.getFramework().getScreenRes() == 4 && !Boolean.getBoolean("DisableCombiSync")) {
            this.initializeCombiSyncTrackers();
        }
    }

    protected ITerminalContext createSubTerminalContext(int n) {
        return new TerminalContextEvo(n);
    }

    protected HMIRegistryEvo getHMIRegistryEvo() {
        return (HMIRegistryEvo)this.fwHMI.getHMIRegistry();
    }

    public void notifyScreenFadedOut(int n, int n2) {
        HMIApplication hMIApplication = this.getHMIApplication(n2 * 100000);
        if (hMIApplication != null) {
            hMIApplication.screenFadedOut(n, this.terminalID);
        }
    }

    public void notifyScreenConnected(int n, int n2) {
        HMIApplication hMIApplication = this.getHMIApplication(n2 * 100000);
        if (hMIApplication != null) {
            hMIApplication.screenConnected(n, this.terminalID);
        }
    }

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
}

