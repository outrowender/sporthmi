/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenChangeManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.IShowPopupRunnable;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.log.LogChannel;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PopupManager
implements IPopupManager {
    protected final LogChannel logPopup;
    private final IScreenManager screenManager;
    IScreenChangeManager screenChangeUnit;
    IPartialPopupManager ppManager;
    private final List popups = new ArrayList(10);
    boolean popupVisible;
    private boolean ignorePopups;
    private int moduleExemptedFromIgnorePopups = -1;
    protected IFrameworkAccess framework;

    public PopupManager(IScreenManager iScreenManager, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.screenManager = iScreenManager;
        this.framework = iFrameworkAccess;
        this.logPopup = logChannel;
    }

    public void dump(PrintStream printStream, String string) {
        if (this.ignorePopups) {
            printStream.println("ignore popus");
            printStream.println();
        }
        printStream.print(string);
        printStream.println("Popups:");
        for (int i2 = 0; i2 < this.popups.size(); ++i2) {
            printStream.print(string);
            printStream.print("  ");
            printStream.println(this.popups.get(i2));
        }
        printStream.print(string);
        printStream.println("Popins:");
    }

    List getPopups() {
        return this.popups;
    }

    public boolean isPopupVisible() {
        return this.popupVisible;
    }

    private IScreenManager getScreenManager() {
        return this.screenManager;
    }

    public ITerminalContext getTerminalContext() {
        return this.getScreenManager().getTerminalContext();
    }

    Screen getScreen(IScreenData iScreenData) {
        return this.getScreenManager().getScreen(iScreenData);
    }

    public void callbackPopupRemoved(int n, int n2) {
        if (!this.isInPopupList(n2)) {
            this.getTerminalContext().callbackPopupRemoved(n, n2);
        } else {
            this.logPopup.log(10000000, "PopupManager.callbackPopupRemoved(): avoiding popupRemoved (popup still active)!");
        }
    }

    public boolean popupAvailable() {
        return !this.popups.isEmpty();
    }

    public ScreenData getPopupData(int n) {
        return (ScreenData)this.popups.get(n);
    }

    public IScreenData getCurrentPopup() {
        return this.popupAvailable() ? this.getPopupData(0) : null;
    }

    public IScreenData getCurrentPopupScreenData() {
        return this.popupAvailable() ? this.getCurrentPopup() : null;
    }

    public int getCurrentPopupID() {
        return this.popupAvailable() ? this.getCurrentPopup().getPopupId() : -1;
    }

    public int getCurrentPopupPriority() {
        return this.popupAvailable() ? this.getCurrentPopup().getPopupPriority() : -1;
    }

    Screen getCurrentPopupScreen() {
        return this.popupAvailable() ? this.getScreen(this.getCurrentPopup()) : null;
    }

    private boolean hasHighestPriority(Screen screen) {
        return this.getCurrentPopupScreen() == screen;
    }

    public boolean isInPopupList(int n) {
        for (int i2 = 0; i2 < this.popups.size(); ++i2) {
            if (((IScreenData)this.popups.get(i2)).getPopupId() != n) continue;
            return true;
        }
        return false;
    }

    public IScreenData getFromPopupList(int n) {
        for (int i2 = 0; i2 < this.popups.size(); ++i2) {
            if (this.getScreen(this.getPopupData(i2)).getID() != n) continue;
            return (IScreenData)this.popups.get(i2);
        }
        return null;
    }

    public IScreenData getPopup(int n) {
        for (int i2 = 0; i2 < this.popups.size(); ++i2) {
            if (((IScreenData)this.popups.get(i2)).getPopupId() != n) continue;
            return (IScreenData)this.popups.get(i2);
        }
        return null;
    }

    void insertIntoPopupList(IScreenData iScreenData) {
        int n;
        if (this.getScreen(iScreenData) == null) {
            return;
        }
        if (this.getFromPopupList(iScreenData.getId()) != null) {
            return;
        }
        for (n = 0; n < this.popups.size() && this.getPopupPriority(this.getPopupData(n)) > this.getPopupPriority(iScreenData); ++n) {
        }
        this.popups.add(n, iScreenData);
        this.inspectCachedPopupConsumtionStrategies(iScreenData);
    }

    protected void inspectCachedPopupConsumtionStrategies(IScreenData iScreenData) {
    }

    protected int getPopupPriority(IScreenData iScreenData) {
        return iScreenData.getPopupPriority();
    }

    void removePopupFromList(IScreenData iScreenData) {
        this.popups.remove(iScreenData);
    }

    public void replacePopupScreen(int n, IScreenData iScreenData) {
        this.logPopup.log(10000000, "PopupManager.replacePopupScreen(screenId1=%2, newPopupData=%1) called", (Object)iScreenData, (long)n);
        if (n == iScreenData.getId()) {
            if (iScreenData.isReinit() && this.screenManager.isCurrentConnectedScreen(iScreenData.getId())) {
                this.screenChangeUnit.reinitScreen(iScreenData, true);
            } else {
                this.logPopup.log(10000000, "PopupManager.replacePopupScreen: no reinit for screen %1", (long)iScreenData.getId());
            }
            return;
        }
        Screen screen = this.getScreenManager().getScreen(iScreenData);
        if (screen != null) {
            this.logPopup.log(10000000, "PopupManager.replacePopupScreen(): newScreen == %1", (Object)screen);
            this.insertIntoPopupList(new ScreenData((ScreenData)iScreenData));
            this.removePopupScreen(n, iScreenData.isAnimated(), false);
        } else {
            this.logPopup.log(10000000, "PopupManager.replacePopupScreen(): new Screen %1 not found", (long)iScreenData.getId());
        }
        this.logPopup.log(10000000, "PopupManager.replacePopupScreen() finished");
    }

    IScreenData getTargetScreenData() {
        IScreenData iScreenData = this.popupAvailable() && !this.isLogicalPopup(this.getCurrentPopup()) ? this.getCurrentPopupScreenData() : this.getScreenManager().getTargetScreenData();
        this.logPopup.log(10000000, "PopupManager.getTargetScreenData(): targetScreenData = %1", (Object)iScreenData);
        return iScreenData;
    }

    public void showPopupScreen(IScreenData iScreenData) {
        this.logPopup.log(10000000, "PopupManager.showPopupScreen(popupId = %1, priority == %2) called ...", (long)iScreenData.getPopupId(), (long)iScreenData.getPopupPriority());
        Screen screen = this.screenManager.getScreen(iScreenData);
        if (screen != null) {
            this.showPopupScreenImpl(iScreenData);
        } else {
            this.logPopup.log(100000, "PopupManager.showPopupScreen(screenId = %1), no popup available", (long)iScreenData.getId());
        }
        this.logPopup.log(10000000, "PopupManager.showPopupScreen(id = %1), finished ", (long)iScreenData.getId());
    }

    private void showPopupScreenImpl(IScreenData iScreenData) {
        IScreenData iScreenData2 = null;
        IScreenData iScreenData3 = null;
        if (this.popupAvailable() && this.isLogicalPopup(iScreenData2 = this.getCurrentPopup())) {
            iScreenData3 = this.getCurrentPopup();
        }
        this.insertIntoPopupList(iScreenData);
        if (this.hasHighestPriority(this.getScreen(iScreenData))) {
            this.screenChangeUnit.showHighestPrioPopup(iScreenData);
            this.logPopup.log(10000000, "PopupManager.showPopupScreenImpl has highest prio: %1", (long)iScreenData.getPopupId());
            this.logPopup.log(10000000, "PopupManager.showPopupScreenImpl is logical popup: %1", this.isLogicalPopup(iScreenData));
            if (this.isLogicalPopup(iScreenData)) {
                this.getPPManager().checkPriosAgainstFullScreenPopup();
                if (iScreenData2 == null) {
                    this.logPopup.log(10000000, "PopupManager.showPopupScreenImpl before notify connected");
                    this.screenChangeUnit.notifyScreenConnected(iScreenData.getScreen());
                }
            }
            if (iScreenData3 != null) {
                this.callBackPopupHidden(iScreenData3);
                this.screenChangeUnit.notifyScreenFadedOut(iScreenData3.getScreen());
            }
        } else {
            if (this.isLogicalPopup(iScreenData)) {
                this.screenChangeUnit.notifyScreenFadedOut(iScreenData.getScreen());
            }
            this.logPopup.log(10000000, "PopupManager.showPopupScreenImpl(): not highest priority --> stored ");
            this.callBackPopupHidden(iScreenData);
        }
    }

    public void callBackPopupHidden(IScreenData iScreenData) {
        this.getTerminalContext().callbackPopupHidden(iScreenData.getId(), iScreenData.getPopupId());
    }

    public void removePopupScreen(int n, boolean bl, boolean bl2) {
        this.logPopup.log(10000000, "PopupManager.removePopupScreenImpl(id == %2) called; animated = %1 ", bl, (long)n);
        IScreenData iScreenData = this.getFromPopupList(n);
        if (iScreenData != null) {
            this.logPopup.log(10000000, "PopupManager.removePopupScreenImpl(): popupScreen.Id == %1, popupScreen.getPopupId == %2", (long)iScreenData.getId(), (long)iScreenData.getPopupId());
            if (this.getScreenManager().getCurrentConnectedScreen() == this.getScreen(iScreenData)) {
                this.screenManager.getCurrentConnectedScreenData().setNotify(bl2);
                this.screenChangeUnit.removeCurrentConnectedPopup(iScreenData);
            } else {
                this.logPopup.log(10000000, "PopupManager.removePopupScreenImpl(): popupScreen != currentConnectedScreen ");
                boolean bl3 = false;
                if (iScreenData == this.getCurrentPopup()) {
                    bl3 = true;
                }
                this.removePopupFromList(iScreenData);
                this.callbackPopupRemoved(n, iScreenData.getPopupId());
                if (this.isLogicalPopup(iScreenData) && bl3) {
                    if (this.popupAvailable()) {
                        this.screenChangeUnit.showHighestPrioPopup(this.getCurrentPopup());
                    } else {
                        this.getPPManager().checkPriosAgainstFullScreenPopup();
                        this.screenChangeUnit.notifyScreenFadedOut(iScreenData.getScreen());
                    }
                }
            }
        } else {
            this.logPopup.log(10000000, "PopupManager.removePopupScreenImpl(): Screen (%1) not found ", (long)n);
        }
        this.logPopup.log(10000000, "PopupManager.removePopupScreenImpl(id = %1), finished ", (long)n);
    }

    public void removePartialPopupsFromPopup(int n, int n2, int[] nArray) {
        this.showOrRemovePartialPopupsForPopup(n, n2, nArray, false);
    }

    private void showOrRemovePartialPopupsForPopup(int n, int n2, int[] nArray, boolean bl) {
        IScreenData iScreenData = this.getFromPopupList(n);
        if (iScreenData != null && iScreenData.getPopupId() == n2) {
            if (this.getScreenManager().isCurrentConnectedScreen(n)) {
                if (bl) {
                    this.getScreen(iScreenData).showPartialPopups(nArray);
                    iScreenData.setPartialPopups(nArray);
                } else {
                    if (!this.screenManager.isCurrentConnectedScreen(n)) {
                        this.getScreen(iScreenData).hidePartialPopups(nArray);
                    }
                    this.screenManager.removePartialPopups(n, nArray);
                }
            }
        } else {
            this.logPopup.log(100000, "PopupManager.showOrRemovePartialPopupsForPopup %1 not found in popups!", (long)n);
        }
    }

    public void showPartialPopupsForPopup(int n, int n2, int[] nArray) {
        this.showOrRemovePartialPopupsForPopup(n, n2, nArray, true);
    }

    public void setScreenChangeUnit(IScreenChangeManager iScreenChangeManager) {
        this.screenChangeUnit = iScreenChangeManager;
    }

    public void setPopupVisible(boolean bl) {
        this.popupVisible = bl;
    }

    private boolean isPopupExempted(int n) {
        return this.getModuleId(n) == this.moduleExemptedFromIgnorePopups;
    }

    private int getModuleId(int n) {
        return n / 100000;
    }

    private boolean isPopupsEnabled(int n) {
        return !this.ignorePopups || this.isPopupExempted(n);
    }

    private void showPopupImpl(int n) {
        if (this.isPopupsEnabled(n)) {
            this.postRunnable(new ShowPopupRunnable(n, this.getTerminalContext().getTerminalID()));
        } else {
            this.logPopup.log(10000000, "PopupManager.showPopup: popup ignored");
        }
    }

    protected void postRunnable(Runnable runnable) {
        this.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(runnable));
    }

    public void showPopup(int n) {
        this.logPopup.log(10000000, "PopupManager.showPopup(popupId = %1, terminalId = %2) called", (long)n, (long)this.getTerminalContext().getTerminalID());
        this.showPopupImpl(n);
        this.logPopup.log(10000000, "PopupManager.showPopup(popupId = %1, terminalId = %2) finished", (long)n, (long)this.getTerminalContext().getTerminalID());
    }

    private void removePopupImpl(final int n) {
        this.postRunnable(new Runnable(){

            public void run() {
                PopupManager.this.logPopup.log(10000000, "RemovePopupRunnable: calling SMI.stopPopup(%1) ", (long)n);
                PopupManager.this.framework.getSMInterpreter().stopPopup(PopupManager.this.getTerminalContext().getTerminalID(), n);
            }

            public String toString() {
                return new StringBuffer().append("RemovePopupRunnable(terminal: ").append(PopupManager.this.getTerminalContext().getTerminalID()).append(" popupId: ").append(n).append(")").toString();
            }
        });
    }

    public void removePopup(int n) {
        this.logPopup.log(10000000, "PopupManager.removePopup(popupId=%1, terminalId=%2)", (long)n, (long)this.getTerminalContext().getTerminalID());
        this.removePopupImpl(n);
    }

    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
    }

    public boolean removeCurrentPopup() {
        int n = this.getCurrentPopupID();
        if (n >= 0) {
            this.removePopupImpl(n);
            return true;
        }
        return false;
    }

    public void disablePopups(int n) {
        this.logPopup.log(10000000, "PopupManager.disablePopups(%1)", (long)n);
        this.ignorePopups = true;
        this.moduleExemptedFromIgnorePopups = n;
    }

    public void enablePopups() {
        this.logPopup.log(10000000, "PopupManager.enablePopups()");
        this.ignorePopups = false;
        this.moduleExemptedFromIgnorePopups = -1;
    }

    public boolean isLogicalPopup(IScreenData iScreenData) {
        return false;
    }

    public IPartialPopupManager getPPManager() {
        if (this.ppManager == null) {
            this.ppManager = this.framework.getHMITerminalRegistry().getTerminal(this.getTerminalContext().getTerminalID()).getPartialPopupManager();
        }
        return this.ppManager;
    }

    public void processPopupQuit(int n) {
        this.removeCurrentPopup();
    }

    public class ShowPopupRunnable
    implements Runnable,
    IShowPopupRunnable {
        final int popupId;
        final int terminalId;

        ShowPopupRunnable(int n, int n2) {
            this.popupId = n;
            this.terminalId = n2;
        }

        public void run() {
            PopupManager.this.logPopup.log(10000000, "ShowPopupRunnable: calling SMI.startPopup(%1) ", (long)this.popupId);
            PopupManager.this.framework.getSMInterpreter().startPopup(this.terminalId, this.popupId);
        }

        public String toString() {
            return new StringBuffer().append("ShowPopupRunnable(terminal: ").append(this.terminalId).append(" popupId: ").append(this.popupId).append(")").toString();
        }
    }
}

