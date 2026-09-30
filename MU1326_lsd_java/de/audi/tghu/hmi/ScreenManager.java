/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.EventDispatcherAdmin;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.IScreenChangeManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.irc.InfotainmentRecorder;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.fwhmi.ModelConnectServiceImpl;
import java.io.PrintStream;

public final class ScreenManager
implements IScreenManager {
    final LogChannel lcHMIService;
    final LogChannel lcHMIServiceMain;
    private final LogChannel lcHMIServicePopup;
    LogChannel logRepaintCause;
    private final FwHMI fwHMI;
    private final ITerminalContext terminalContext;
    private final int terminalID;
    private ScreenData fallbackScreenData = new ScreenData();
    private IScreenChangeManager screenChangeUnit;
    private ModelConnectServiceImpl modelConnectService;
    IScreenData currentConnectedScreenData = new ScreenData();
    private IScreenData previousConnectedScreenData;
    private IScreenData currentScreenData = new ScreenData();
    private IScreenData nextScreenData = new ScreenData();
    private final int ID_REMOVE_ALL_POPUPS_FROM_SCREENDATA;

    public ScreenManager(ITerminalContext iTerminalContext) {
        this.ID_REMOVE_ALL_POPUPS_FROM_SCREENDATA = -2;
        this.terminalContext = iTerminalContext;
        this.fwHMI = (FwHMI)iTerminalContext.getHMIService();
        this.lcHMIService = this.getFramework().getLogChannel("Fw.HMIService.Screen");
        this.lcHMIServiceMain = this.getFramework().getLogChannel("Fw.HMIService.Main");
        this.lcHMIServicePopup = this.getFramework().getLogChannel("Fw.HMIService.Popup");
        this.terminalID = iTerminalContext.getTerminalID();
        this.modelConnectService = new ModelConnectServiceImpl(iTerminalContext);
    }

    public String toString() {
        return "ScreenManager[" + this.getTerminalID() + "]";
    }

    int getTerminalID() {
        return this.terminalID;
    }

    public boolean isCluster() {
        return this.getTerminalContext().isCluster();
    }

    public Screen getScreen(IScreenData iScreenData) {
        if (iScreenData != null && iScreenData.isScreenIDValid()) {
            Screen screen = iScreenData.getScreen();
            if (screen == null && (screen = this.getTerminalContext().getScreenFromCache(iScreenData.getId())) != null) {
                screen.setState(iScreenData.getStates());
                iScreenData.setScreen(screen);
            }
            return screen;
        }
        return null;
    }

    public IScreenData getTargetScreenData() {
        IScreenData iScreenData = this.isScreenChangePending() ? this.getPendingScreenData() : this.getCurrentScreenData();
        this.lcHMIService.log(10000000, "ScreenManager.getTargetScreenData(): targetScreenID = %1", (long)iScreenData.getId());
        return iScreenData;
    }

    public IScreenData getCurrentScreenData() {
        return this.currentScreenData;
    }

    public void setCurrentScreenData(IScreenData iScreenData) {
        this.currentScreenData = iScreenData;
    }

    Screen getCurrentScreen() {
        return this.getScreen(this.getCurrentScreenData());
    }

    public int getCurrentScreenId() {
        IScreenData iScreenData = this.getCurrentScreenData();
        return iScreenData != null ? iScreenData.getId() : -1;
    }

    public IScreenData getCurrentConnectedScreenData() {
        return this.currentConnectedScreenData;
    }

    public void setCurrentConnectedScreenData(IScreenData iScreenData) {
        this.lcHMIServiceMain.log(100000000, "ScreenManager().setCurrentConnectedScreenData(%1)", (Object)iScreenData);
        this.currentConnectedScreenData = iScreenData;
        Screen screen = this.getScreen(iScreenData);
        if (iScreenData == null) {
            return;
        }
        if (screen != null && iScreenData.isLocked()) {
            screen.setLocked(true);
        }
    }

    public void clearCurrentConnectedScreenData() {
        this.previousConnectedScreenData = this.currentConnectedScreenData;
        this.setCurrentConnectedScreenData(null);
    }

    public Screen getCurrentConnectedScreen() {
        return this.getScreen(this.getCurrentConnectedScreenData());
    }

    public int getCurrentConnectedScreenId() {
        IScreenData iScreenData = this.getCurrentConnectedScreenData();
        return iScreenData != null ? iScreenData.getId() : -1;
    }

    public void lockCurrentConnectedScreen(boolean bl) {
        Screen screen = this.getCurrentConnectedScreen();
        if (screen != null) {
            screen.setLocked(bl);
        }
    }

    public IScreenData getPendingScreenData() {
        return this.nextScreenData;
    }

    public Screen getPendingScreen() {
        return this.getScreen(this.getPendingScreenData());
    }

    public int getPendingScreenId() {
        IScreenData iScreenData = this.getPendingScreenData();
        return iScreenData != null ? iScreenData.getId() : -1;
    }

    public void setPendingScreenChange(IScreenData iScreenData) {
        this.nextScreenData = iScreenData;
    }

    public void clearPendingScreenChange() {
        this.setPendingScreenChange(null);
    }

    public boolean isScreenChangePending() {
        return this.getPendingScreenData() != null && this.getPendingScreenData().getId() != -1;
    }

    public boolean isCurrentConnectedScreen(int n) {
        return this.getCurrentConnectedScreenId() == n;
    }

    public boolean isCurrentScreen(int n) {
        return this.getCurrentScreenId() == n;
    }

    boolean isPendingScreen(int n) {
        return this.getPendingScreenId() == n;
    }

    public ITerminalContext getTerminalContext() {
        return this.terminalContext;
    }

    public FwHMI getHMIService() {
        return this.fwHMI;
    }

    public IFrameworkAccess getFramework() {
        return this.getTerminalContext().getFramework();
    }

    public EventDispatcherAdmin getEventDispatcherAdmin() {
        return this.getHMIService().getEventDispatcherAdmin();
    }

    HMITerminal getHmiTerminalImpl() {
        return this.getTerminalContext().getHmiTerminal();
    }

    public void logToInfotainmentRecorder(int n) {
        InfotainmentRecorder infotainmentRecorder = this.getFramework().getInfotainmentrecorder();
        if (infotainmentRecorder != null) {
            infotainmentRecorder.logScreenChange(n);
        }
    }

    public void showScreen(IScreenData iScreenData) {
        this.screenChangeUnit.showScreen(iScreenData);
    }

    public boolean isClusterAnScreenHidden(Screen screen) {
        return this.isCluster() && screen.getEventProcessing() == 1;
    }

    public void removePartialPopups(int n, int[] nArray) {
        boolean bl = false;
        if (nArray.length > 0 && nArray[0] == -2) {
            this.lcHMIServicePopup.log(10000000, "ScreenChangeManager#removePartialPopups remove all popups from screendata");
            this.removePartialPopupFromScreenData(n, -2);
        } else {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                bl = this.removePartialPopupFromScreenData(n, nArray[i2]);
                if (bl) {
                    this.lcHMIServicePopup.log(10000000, "ScreenChangeManager#removePartialPopups popup with id %1 has been removed from screendata");
                }
                if (bl) continue;
                this.lcHMIServicePopup.log(100000, "ScreenChangeManager#removePartialPopups popup with id %1 was not part of screendata", (long)nArray[i2]);
            }
        }
        if (this.isCurrentConnectedScreen(n)) {
            this.getCurrentConnectedScreen().hidePartialPopups(nArray);
        }
    }

    public void showPartialPopups(int n, int[] nArray) {
        if (this.isCurrentConnectedScreen(n)) {
            this.getCurrentConnectedScreenData().setPartialPopups(nArray);
            this.getCurrentConnectedScreen().showPartialPopups(nArray);
        } else if (this.isCurrentScreen(n)) {
            this.getCurrentScreenData().setPartialPopups(nArray);
        } else if (this.isPendingScreen(n)) {
            this.getPendingScreenData().setPartialPopups(nArray);
        } else {
            this.lcHMIService.log(100000, "ScreenManager.showPartialPopups(): screenId %1 not found!", (long)n);
        }
    }

    public void refresh() {
        Screen screen = this.getCurrentConnectedScreen();
        if (screen != null) {
            this.screenChangeUnit.reinitScreen(this.getCurrentConnectedScreenData(), false);
            if (this.logRepaintCause == null) {
                this.logRepaintCause = this.getFramework().getLogChannel("Fw.Widgets.RepaintCause");
            }
            this.logRepaintCause.log(10000000, "ScreenManager#refresh: paint screen: %1", (Object)screen);
            screen.paint();
        }
    }

    public void dump(PrintStream printStream, String string) {
        printStream.print(string);
        printStream.print("Current Screen: ");
        printStream.println(this.getCurrentScreenData());
        printStream.print(string);
        printStream.print("Current Connected Screen: ");
        printStream.println(this.getCurrentConnectedScreenData());
        printStream.print(string);
        printStream.print("Next Screen: ");
        printStream.println(this.getPendingScreenData());
        printStream.print(string);
        printStream.print("ScreenChangeState: ");
        printStream.println(this.screenChangeUnit.getScreenChangeState());
    }

    public IModelConnectService getModelConnectService() {
        return this.modelConnectService;
    }

    public void setFallbackScreen(Screen screen) {
        this.fallbackScreenData = new ScreenData(screen.getID(), false, false, null, false, screen, null, 0, -1, -1, false, -1, null, -1L, -1L, 0, 0, 0, null);
    }

    public IScreenData getFallbackScreenData() {
        return this.fallbackScreenData;
    }

    public boolean isScreenAvailable() {
        return this.getCurrentScreenData() != null && this.getCurrentScreenData().isScreenIDValid() || this.getPendingScreenData() != null && this.getPendingScreenData().isScreenIDValid();
    }

    public void setScreenChangeUnit(IScreenChangeManager iScreenChangeManager) {
        this.screenChangeUnit = iScreenChangeManager;
    }

    public IScreenChangeManager getScreenChangeUnit() {
        return this.screenChangeUnit;
    }

    public boolean isScreenChangeAnimationRunning(int n) {
        return this.getScreenChangeUnit().getScreenChangeState() != 0;
    }

    public IScreenData getPreviousConnectedScreenData() {
        return this.previousConnectedScreenData;
    }

    public boolean removePartialPopupFromScreenData(int n, int n2) {
        int n3;
        int[] nArray;
        boolean bl = false;
        if (n2 == -2) {
            if (this.isPendingScreen(n)) {
                this.getPendingScreenData().setPartialPopups(null);
            }
            if (this.isCurrentConnectedScreen(n)) {
                this.getCurrentConnectedScreenData().setPartialPopups(null);
            }
            if (this.isCurrentScreen(n)) {
                this.getCurrentScreenData().setPartialPopups(null);
            }
            return true;
        }
        if (this.isPendingScreen(n) && this.getPendingScreenData().isPartialPopupAvailable()) {
            nArray = this.getPendingScreenData().getPartialPopups();
            for (n3 = 0; n3 < nArray.length; ++n3) {
                if (nArray[n3] != n2) continue;
                nArray[n3] = -1;
                bl = true;
            }
            this.getPendingScreenData().setPartialPopups(nArray);
        }
        if (this.isCurrentConnectedScreen(n) && this.getCurrentConnectedScreenData().isPartialPopupAvailable()) {
            nArray = this.getCurrentConnectedScreenData().getPartialPopups();
            for (n3 = 0; n3 < nArray.length; ++n3) {
                if (nArray[n3] != n2) continue;
                nArray[n3] = -1;
                bl = true;
            }
            this.getCurrentConnectedScreenData().setPartialPopups(nArray);
        }
        if (this.isCurrentScreen(n) && this.getCurrentScreenData().isPartialPopupAvailable()) {
            nArray = this.getCurrentScreenData().getPartialPopups();
            for (n3 = 0; n3 < nArray.length; ++n3) {
                if (nArray[n3] != n2) continue;
                nArray[n3] = -1;
                bl = true;
            }
            this.getCurrentScreenData().setPartialPopups(nArray);
        }
        return bl;
    }
}

