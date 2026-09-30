/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi;

import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IScreenChangeAnimationManager;
import de.audi.atip.hmi.view.IScreenChangeManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.PopupManager;

public class ScreenChangeManager
implements IScreenChangeManager {
    private boolean alwaysDisconnectOnScreenChange;
    private IScreenChangeAnimationManager animationManager;
    private PopupManager popupManager;
    protected IScreenManager screenManager;
    protected IRootWindow rootWindow;
    protected LogChannel logScreenChange;
    private LogChannel logRepaintCause;
    protected IModelConnectService modelConnectService;
    protected ITerminalContext terminalContext;
    protected IViewSizeManager viewSizeManager;
    private boolean viewSizeLockAcquired;

    public ScreenChangeManager(ITerminalContext iTerminalContext, IScreenManager iScreenManager, PopupManager popupManager, boolean bl, LogChannel logChannel, LogChannel logChannel2) {
        this.terminalContext = iTerminalContext;
        this.screenManager = iScreenManager;
        this.popupManager = popupManager;
        this.rootWindow = iTerminalContext.getRootWindow();
        this.modelConnectService = iScreenManager.getModelConnectService();
        this.alwaysDisconnectOnScreenChange = bl;
        this.logScreenChange = logChannel;
        this.logRepaintCause = logChannel2;
    }

    protected void changeToCurrentConnectedScreen(IScreenData iScreenData, boolean bl) {
        this.screenManager.setCurrentScreenData(iScreenData);
        Screen screen = this.screenManager.getCurrentConnectedScreen();
        iScreenData.setScreen(screen);
        this.screenManager.setCurrentConnectedScreenData(iScreenData);
        if (iScreenData.isReinit()) {
            this.reinitScreen(iScreenData, bl);
        } else {
            this.logScreenChange.log(10000000, "ScreenChangeManager.changeToCurrentConnectedScreen(): no reinit for current screen");
            screen.updateContexts(iScreenData.getContextIDs());
            screen.hideNotScreenChangeSurvivingPopups();
            screen.updatedColorScheme(iScreenData.getColorScheme());
            screen.setLocked(iScreenData.isLocked());
            this.updateDrawers(screen, iScreenData);
            if (iScreenData.isPartialPopupAvailable()) {
                screen.showPartialPopups(iScreenData.getPartialPopups());
            } else if (bl) {
                this.logRepaintCause.log(10000000, "ScreenChangeManager#changeToCurrentConnectedScreen: repaint. current screen: %1", (Object)screen);
                this.rootWindow.repaint();
            }
        }
        this.logScreenChange.log(10000000, "ScreenChangeManager.changeToCurrentConnectedScreen(id = %1), finished", (long)iScreenData.getId());
    }

    private void changeToNewScreen(IScreenData iScreenData, boolean bl) {
        Screen screen = this.screenManager.getScreen(iScreenData);
        if (screen != null) {
            this.logScreenChange.log(10000000, "ScreenChangeManager.changeToNewScreen: screen == %1", (Object)screen);
            if (!this.popupManager.isPopupVisible()) {
                this.disConnectScreen(this.screenManager.getCurrentConnectedScreen(), true, bl);
                this.connectScreen(iScreenData, iScreenData.isReinit(), bl);
                if (!bl) {
                    this.logRepaintCause.log(10000000, "ScreenChangeManager#changeToNewScreen: repaint. new screen: %1", (Object)screen);
                    this.rootWindow.repaint();
                }
            }
            this.screenManager.setCurrentScreenData(new ScreenData((ScreenData)iScreenData));
        }
    }

    private void changeToPopup(boolean bl) {
        this.logScreenChange.log(10000000, "ScreenChangeManager.changeToPopup()");
        Screen screen = this.screenManager.getCurrentConnectedScreen();
        int n = this.screenManager.getCurrentConnectedScreenId();
        if (screen != null) {
            this.disConnectScreen(screen, true, bl);
            this.screenManager.getTerminalContext().callbackScreenHidden(n);
        }
        IScreenData iScreenData = this.popupManager.getCurrentPopupScreenData();
        this.connectScreen(iScreenData, iScreenData.isReinit(), bl);
        this.popupManager.setPopupVisible(true);
        if (this.screenManager.isCluster() || !bl) {
            this.logRepaintCause.log(10000000, "ScreenChangeManager#changeToPopup: repaint. current screen: %1 ", (Object)screen);
            this.rootWindow.repaint();
        }
        this.logScreenChange.log(10000000, "ScreenChangeManager.changeToPopup() finished");
    }

    private void changeToScreen(IScreenData iScreenData, boolean bl) {
        this.logScreenChange.log(10000000, "ScreenChangeManager.changeToScreen(id = %2, reinit = %1) called", iScreenData.isReinit(), (long)iScreenData.getId());
        if (this.isChangeToCurrentConnectedScreen(iScreenData)) {
            this.changeToCurrentConnectedScreen(iScreenData, !bl);
        } else {
            this.changeToNewScreen(iScreenData, bl);
        }
        this.screenManager.logToInfotainmentRecorder(this.screenManager.getCurrentScreenId());
        this.logScreenChange.log(10000000, "ScreenChangeManager.changeToScreen(id = %1), finished ", (long)iScreenData.getId());
    }

    private boolean isChangeToCurrentConnectedScreen(IScreenData iScreenData) {
        Screen screen = this.screenManager.getScreen(this.screenManager.getCurrentConnectedScreenData());
        Screen screen2 = this.screenManager.getScreen(iScreenData);
        return this.screenManager.isCurrentScreen(iScreenData.getId()) && screen != null && screen.equals(screen2);
    }

    protected void connectScreen(IScreenData iScreenData, boolean bl, boolean bl2) {
        Screen screen = this.screenManager.getScreen(iScreenData);
        this.logScreenChange.log(10000000, "ScreenChangeManager.connectScreen(): screen=%2, reinit=%1", bl, (Object)screen);
        if (screen != null) {
            if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                StatisticsManager.instance().getScreenStatistics().connectStart(screen.getID());
            }
            try {
                if (this.screenManager.isClusterAnScreenHidden(screen)) {
                    if (bl) {
                        this.reinitScreen(iScreenData, false);
                    }
                } else {
                    this.modelConnectService.clearUnconnectedItems(false);
                    this.logScreenChange.log(10000000, "ScreenChangeManager.addScreenReference( %1 )", (Object)screen);
                    this.modelConnectService.modifiyModelReference(screen, true, false);
                    screen.connected(iScreenData);
                    this.notifyScreenConnected(screen);
                }
            }
            catch (Exception exception) {
                this.logScreenChange.log(10000, "ScreenChangeManager.connectScreen(): failed!", (Throwable)exception);
            }
            this.screenManager.setCurrentConnectedScreenData(iScreenData);
            this.rootWindow.add(iScreenData, screen);
            this.afterConnect(screen, bl2);
            if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                StatisticsManager.instance().getScreenStatistics().connectEnd();
            }
        }
        this.unlockViewSizeChange(true);
    }

    protected void disConnectScreen(Screen screen, boolean bl, boolean bl2) {
        if (screen == null) {
            return;
        }
        this.logScreenChange.log(10000000, "logScreenChange.disConnectScreen(): screen=%1", (Object)screen);
        if (bl) {
            this.rootWindow.remove(screen);
        }
        if (this.screenManager.isClusterAnScreenHidden(screen)) {
            return;
        }
        try {
            this.preDisconnectScreen(screen);
            if (this.isAlwaysDisconnectOnScreenChange() || !bl2) {
                this.lockViewSizeChange();
                screen.disconnecting();
            }
            this.logScreenChange.log(10000000, "ScreenChangeManager.removeScreenReference( %1 )", (Object)screen);
            this.modelConnectService.modifiyModelReference(screen, false, false);
            this.screenManager.clearCurrentConnectedScreenData();
        }
        catch (Exception exception) {
            this.logScreenChange.log(10000, "ScreenChangeManager.disConnectScreen(): failed!", (Throwable)exception);
        }
        this.logScreenChange.log(10000000, "ScreenChangeManager.disConnectScreen(): screen == %1, finished", (Object)screen);
    }

    public void fadeInAnimationFinished() {
        this.notifyHMIApplicationScreenVisible();
        if (this.popupManager.popupAvailable()) {
            if (!this.screenManager.isCurrentConnectedScreen(this.popupManager.getCurrentPopupScreen().getID())) {
                if (!this.popupManager.isLogicalPopup(this.popupManager.getCurrentPopup()) || this.screenManager.getCurrentConnectedScreenData().isPopup()) {
                    if (!this.animationManager.startScreenChangeAnimation(this.screenManager.getCurrentConnectedScreenData(), this.popupManager.getCurrentPopupScreenData())) {
                        this.notifyScreenFadedOut(this.screenManager.getCurrentConnectedScreen());
                        if (this.screenManager.getCurrentConnectedScreenData().isPopup()) {
                            this.hideCurrentPopup(false);
                        } else {
                            this.changeToPopup(false);
                            this.notifyHMIApplicationScreenVisible();
                        }
                    }
                } else if (this.popupManager.isLogicalPopup(this.popupManager.getCurrentPopup())) {
                    this.checkForNewScreenAfterFadeIn();
                }
            }
        } else if (!this.screenManager.getCurrentConnectedScreenData().isPopup()) {
            this.checkForNewScreenAfterFadeIn();
        } else {
            IScreenData iScreenData = this.screenManager.getTargetScreenData();
            if (!this.animationManager.startScreenChangeAnimation(this.screenManager.getCurrentConnectedScreenData(), iScreenData)) {
                this.hideCurrentPopup(false);
            }
        }
    }

    private void checkForNewScreenAfterFadeIn() {
        if (this.screenManager.isScreenChangePending()) {
            if (this.screenManager.isCurrentConnectedScreen(this.screenManager.getPendingScreenData().getId())) {
                this.changeToCurrentConnectedScreen(this.screenManager.getPendingScreenData(), true);
                this.screenManager.clearPendingScreenChange();
            } else {
                IScreenData iScreenData = this.screenManager.getPendingScreenData();
                if (!this.animationManager.startScreenChangeAnimation(this.screenManager.getCurrentConnectedScreenData(), iScreenData)) {
                    this.changeToScreen(iScreenData, false);
                    this.screenManager.clearPendingScreenChange();
                }
            }
        }
    }

    public IRootWindow getRootWindow() {
        return this.rootWindow;
    }

    public int getScreenChangeState() {
        return this.animationManager.getScreenChangeState();
    }

    private void hideCurrentPopup(boolean bl) {
        IScreenData iScreenData = this.screenManager.getCurrentConnectedScreenData();
        Screen screen = this.screenManager.getScreen(iScreenData);
        this.logScreenChange.log(10000000, "ScreenChangeManager.hideCurrentPopup(): popupScreen=%1, terminal=%2", (Object)screen);
        if (screen != null) {
            int n = iScreenData.getId();
            int n2 = iScreenData.getPopupId();
            this.logScreenChange.log(10000000, "ScreenChangeManager.hideCurrentPopup(): screenId=%1, popupId=%2", (long)n, (long)n2);
            IScreenData iScreenData2 = this.popupManager.getCurrentPopupScreenData();
            int n3 = -1;
            if (iScreenData2 != null) {
                n3 = iScreenData2.getId();
            }
            if (iScreenData != iScreenData2) {
                this.logScreenChange.log(1000000, "ScreenChangeManager#hideCurrentPopup disconnecting popup %1 and connecting popup %2; should the disconnecting process be animated, it may get interrupted and popup %1 may remain connected", (long)n2, (long)n3);
                this.disConnectScreen(screen, true, bl);
                if (iScreenData.isNotify()) {
                    this.popupManager.callbackPopupRemoved(n, n2);
                } else {
                    this.logScreenChange.log(10000000, "ScreenChangeManager.hideCurrentPopup(): popupRemoved suppressed for id %1 (! notify)", (long)n2);
                }
                if (this.popupManager.popupAvailable() && !this.popupManager.isLogicalPopup(this.popupManager.getCurrentPopup())) {
                    this.connectScreen(iScreenData2, iScreenData2.isReinit(), bl);
                    if (!bl) {
                        this.terminalContext.callbackPopupVisible(iScreenData2.getId(), iScreenData2.getPopupId());
                    }
                } else {
                    this.popupManager.setPopupVisible(false);
                    IScreenData iScreenData3 = this.screenManager.getCurrentScreenData();
                    if (this.screenManager.isScreenChangePending()) {
                        IScreenData iScreenData4 = this.screenManager.getPendingScreenData();
                        Screen screen2 = this.screenManager.getPendingScreen();
                        if (screen2 != null) {
                            this.connectScreen(iScreenData4, iScreenData4.isReinit(), bl);
                            this.screenManager.setCurrentScreenData(new ScreenData((ScreenData)iScreenData4));
                        }
                        this.screenManager.clearPendingScreenChange();
                    } else if (this.screenManager.getScreen(iScreenData3) != null) {
                        this.connectScreen(iScreenData3, false, bl);
                        if (!bl) {
                            this.screenManager.getTerminalContext().callbackScreenVisible(iScreenData3.getId());
                        }
                    }
                    if (this.popupManager.popupAvailable() && this.popupManager.isLogicalPopup(this.popupManager.getCurrentPopup())) {
                        this.notifyScreenConnected(this.popupManager.getCurrentPopupScreen());
                    }
                }
            } else {
                this.logScreenChange.log(1000000, "ScreenChangeManager#hideCurrentPopup nothing to disconnect or connect as the next popup is identical to the current one; keeping things as they are");
            }
            if (this.popupManager.popupAvailable() && n2 != iScreenData2.getPopupId() && this.popupManager.isInPopupList(n2)) {
                this.logScreenChange.log(10000000, "ScreenChangeManager.hideCurrentPopup(): old popupId = %1, new popupId = %2", (long)n2, (long)iScreenData2.getPopupId());
                this.screenManager.getTerminalContext().callbackPopupHidden(n, n2);
            }
        }
        if (!bl) {
            this.logRepaintCause.log(10000000, "ScreenChangeManager#hideCurrentPopup: repaint. popup screen: %1 ", (Object)screen);
            this.rootWindow.repaint();
        }
        this.logScreenChange.log(10000000, "ScreenChangeManager.hideCurrentPopup() finished ");
    }

    public boolean isAlwaysDisconnectOnScreenChange() {
        return this.alwaysDisconnectOnScreenChange;
    }

    public void processFadeOutPopup() {
        this.logScreenChange.log(10000000, "ScreenChangeManager.processFadeOutPopup: faded out popup");
        this.hideCurrentPopup(true);
    }

    public void processFadeOutScreen() {
        this.logScreenChange.log(10000000, "ScreenChangeManager.processFadeOutScreen(): faded out screen");
        if (this.popupManager.popupAvailable() && !this.popupManager.isLogicalPopup(this.popupManager.getCurrentPopup())) {
            this.logScreenChange.log(10000000, "ScreenChangeManager.processFadeOutScreen(): changing to popup");
            this.changeToPopup(true);
        } else {
            this.logScreenChange.log(10000000, "ScreenChangeManager.processFadeOutScreen(): changing to screen");
            if (this.screenManager.isScreenChangePending()) {
                this.changeToScreen(this.screenManager.getPendingScreenData(), true);
                this.screenManager.clearPendingScreenChange();
            } else {
                this.changeToScreen(this.screenManager.getCurrentScreenData(), true);
            }
        }
    }

    public void reinitScreen(IScreenData iScreenData, boolean bl) {
        Screen screen = this.getScreen(iScreenData);
        this.logScreenChange.log(10000000, "ScreenChangeManager.reinitScreen(%2,%1)", iScreenData.isReinit(), (Object)iScreenData.getScreen());
        this.lockViewSizeChange();
        try {
            this.preDisconnectScreen(screen);
            screen.disconnecting();
            screen.connected(iScreenData);
        }
        catch (Exception exception) {
            this.logScreenChange.log(10000, "ScreenChangeManager#reinitScreen Exception occurred: %1", (Throwable)exception);
        }
        this.unlockViewSizeChange(false);
        this.notifyScreenConnected(screen);
        if (iScreenData.isLocked()) {
            screen.setLocked(true);
        }
        if (bl) {
            this.logRepaintCause.log(10000000, "ScreenChangeManager#reinitScreen: repaint. screen: %1 ", (Object)screen);
            this.rootWindow.repaint();
        }
    }

    protected void preDisconnectScreen(Screen screen) {
    }

    protected void afterConnect(Screen screen, boolean bl) {
    }

    public void notifyScreenFadedOut(Screen screen) {
    }

    public void notifyScreenConnected(Screen screen) {
    }

    public void removeCurrentConnectedPopup(IScreenData iScreenData) {
        this.logScreenChange.log(10000000, "ScreenChangeManager.removeCurrentConnectedPopup: popupScreen == currentConnectedScreen ");
        switch (this.animationManager.getScreenChangeState()) {
            case 0: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.removeCurrentConnectedPopup: SCREENCHANGE_STATE_INIT");
                if (!this.screenManager.isScreenAvailable()) {
                    this.logScreenChange.log(100000, "ScreenChangeManager.removeCurrentConnectedPopup: no target screen available, set fallback screen as pending screen");
                    this.screenManager.showScreen(this.screenManager.getFallbackScreenData());
                }
                this.popupManager.removePopupFromList(iScreenData);
                if (this.animationManager.startScreenChangeAnimation(iScreenData, this.popupManager.getTargetScreenData())) break;
                this.notifyScreenFadedOut(this.screenManager.getCurrentConnectedScreen());
                this.hideCurrentPopup(false);
                break;
            }
            case 1: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.removeCurrentConnectedPopup: SCREENCHANGE_STATE_FADEOUT ");
                this.popupManager.removePopupFromList(iScreenData);
                break;
            }
            case 2: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.removeCurrentConnectedPopup: SCREENCHANGE_STATE_FADEIN ");
                this.popupManager.removePopupFromList(iScreenData);
                break;
            }
        }
    }

    public void showHighestPrioPopup(IScreenData iScreenData) {
        switch (this.animationManager.getScreenChangeState()) {
            case 0: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.showHighestPrioPopup: state == SCREENCHANGE_STATE_INIT");
                if (this.animationManager.startScreenChangeAnimation(this.screenManager.getCurrentConnectedScreenData(), iScreenData) || this.popupManager.isLogicalPopup(iScreenData)) break;
                if (this.screenManager.getCurrentConnectedScreenData() != null) {
                    this.notifyScreenFadedOut(this.screenManager.getCurrentConnectedScreen());
                    if (this.screenManager.getCurrentConnectedScreenData().isPopup()) {
                        this.hideCurrentPopup(false);
                    } else {
                        this.changeToPopup(false);
                    }
                } else {
                    this.changeToPopup(false);
                }
                this.notifyHMIApplicationScreenVisible();
                break;
            }
            case 1: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.showHighestPrioPopup: state == SCREENCHANGE_STATE_FADEOUT");
                break;
            }
            case 2: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.showHighestPrioPopup: state == SCREENCHANGE_STATE_FADEIN");
                break;
            }
        }
    }

    public void showScreen(IScreenData iScreenData) {
        this.logScreenChange.log(10000000, "[ScreenChangeManager#showScreen] screenID=%1", (long)iScreenData.getId());
        if (this.popupManager.isPopupVisible()) {
            this.logScreenChange.log(10000000, "ScreenChangeManager.showScreen(): popupVisible --> request stored");
            this.screenManager.setPendingScreenChange(iScreenData);
            return;
        }
        switch (this.animationManager.getScreenChangeState()) {
            case 0: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.showScreen(): SCREENCHANGE_STATE_INIT --> change screen ");
                this.screenManager.setPendingScreenChange(iScreenData);
                if (this.animationManager.startScreenChangeAnimation(this.screenManager.getCurrentConnectedScreenData(), iScreenData)) {
                    this.hideNotSurvivingPartialPopups();
                    break;
                }
                this.notifyScreenFadedOut(this.screenManager.getCurrentConnectedScreen());
                this.changeToScreen(iScreenData, false);
                if (!iScreenData.isReinit()) break;
                this.afterConnect(this.screenManager.getCurrentConnectedScreen(), false);
                break;
            }
            case 1: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.showScreen(): SCREENCHANGE_STATE_FADEOUT --> stored ");
                this.screenManager.setPendingScreenChange(iScreenData);
                break;
            }
            case 2: {
                this.logScreenChange.log(10000000, "ScreenChangeManager.showScreen(): SCREENCHANGE_STATE_FADEIN --> stored ");
                this.screenManager.setPendingScreenChange(iScreenData);
                if (this.screenManager.isCurrentConnectedScreen(iScreenData.getId())) {
                    this.animationManager.rollBackEnterAnimation(false);
                    break;
                }
                this.animationManager.rollBackEnterAnimation(true);
                break;
            }
        }
    }

    private void hideNotSurvivingPartialPopups() {
        IPartialPopupManager iPartialPopupManager = this.terminalContext.getPartialPopupManager();
        if (iPartialPopupManager != null) {
            iPartialPopupManager.oldScreenDisconnecting(this.screenManager.getCurrentConnectedScreen());
        }
    }

    private void notifyHMIApplicationScreenVisible() {
        int n = this.screenManager.getCurrentConnectedScreenId();
        IScreenData iScreenData = this.screenManager.getCurrentConnectedScreenData();
        if (!iScreenData.isPopup()) {
            if (this.animationManager.wasPopupFadedOut()) {
                this.logScreenChange.log(10000000, "ScreenChangeManager.notifyHMIApplicationScreenVisible: screenVisible(), screen = %1 ", (long)n);
                this.terminalContext.callbackScreenVisible(n);
            }
        } else {
            int n2 = iScreenData.getPopupId();
            if (iScreenData.isNotify()) {
                if (this.screenManager.getPreviousConnectedScreenData() != null && this.screenManager.getPreviousConnectedScreenData().getPopupId() == n2) {
                    this.logScreenChange.log(10000000, "ScreenChangeManager.notifyHMIApplicationScreenVisible: not sending notification to app because it must be screen switch within popup");
                } else {
                    this.terminalContext.callbackPopupVisible(n, n2);
                }
            } else {
                this.logScreenChange.log(10000000, "ScreenChangeManager.notifyHMIApplicationScreenVisible: popupVisible() suppressed for id %1", (long)n2);
            }
        }
    }

    public void setFocus(int n) {
        if (this.animationManager != null) {
            this.animationManager.setFocus(n);
        }
    }

    public Screen getScreen(IScreenData iScreenData) {
        return this.screenManager.getScreen(iScreenData);
    }

    public void setAnimationManager(IScreenChangeAnimationManager iScreenChangeAnimationManager) {
        this.animationManager = iScreenChangeAnimationManager;
    }

    protected void lockViewSizeChange() {
        if (this.viewSizeManager != null && !this.viewSizeLockAcquired) {
            this.viewSizeManager.setLocked(true, false);
            this.viewSizeLockAcquired = true;
        }
    }

    protected void unlockViewSizeChange(boolean bl) {
        if (this.viewSizeManager != null && this.viewSizeLockAcquired) {
            this.viewSizeManager.setLocked(false, bl);
            this.viewSizeLockAcquired = false;
        }
    }

    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
        this.viewSizeManager = iViewSizeManager;
    }

    public IViewSizeManager getViewSizeManager() {
        return this.viewSizeManager;
    }

    protected void updateDrawers(Screen screen, IScreenData iScreenData) {
    }
}

