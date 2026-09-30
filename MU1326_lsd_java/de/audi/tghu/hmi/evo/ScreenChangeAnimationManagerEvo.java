/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.EventDispatcherAdmin;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IScreenChangeAnimationManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.PopupManager;
import de.audi.tghu.hmi.ScreenChangeManager;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.TerminalContextEvo;
import de.esolutions.fw.util.commons.Buffer;

public final class ScreenChangeAnimationManagerEvo
implements AnimationListener,
IScreenChangeAnimationManager {
    private static final int[] CURRENT_ANIMATION_INFO_INIT = new int[]{0, 0, 0, 0};
    private static final boolean SCREEN_EXIT = true;
    private static final boolean SCREEN_ENTER = false;
    private final IScreenManager screenManager;
    private final PopupManager popupManager;
    private final ScreenChangeManager screenChangeUnit;
    private final LogChannel log;
    private IAnimationController animationController;
    IAnimation screenChangeAnimation;
    private int screenChangeState;
    private IScreenData startScreenData;
    private IScreenData targetScreenData;
    private int[] screenChangeAnimationInfo;
    private int[] modelledAnimationInfo;
    private int currentFocus = 2;
    private boolean animationRolledBack = false;

    ScreenChangeAnimationManagerEvo(IScreenManager iScreenManager, ScreenChangeManager screenChangeManager, PopupManager popupManager) {
        this.screenManager = iScreenManager;
        this.screenChangeUnit = screenChangeManager;
        this.popupManager = popupManager;
        this.log = this.getFramework().getLogChannel("Fw.Animation");
    }

    public String toString() {
        return "ScreenChangeAnimationManager:" + this.getTerminalId();
    }

    private IScreenManager getScreenManager() {
        return this.screenManager;
    }

    private ITerminalContext getTerminalContext() {
        return this.getScreenManager().getTerminalContext();
    }

    private IFrameworkAccess getFramework() {
        return this.getScreenManager().getFramework();
    }

    private int getTerminalId() {
        return this.getTerminalContext().getTerminalID();
    }

    private EventDispatcherAdmin getEventDispatcherAdmin() {
        return this.getScreenManager().getEventDispatcherAdmin();
    }

    private IAnimationController getAnimationController() {
        if (this.animationController == null) {
            this.animationController = ((TerminalContextEvo)this.getTerminalContext()).getAnimationController();
        }
        return this.animationController;
    }

    public int getScreenChangeState() {
        return this.screenChangeState;
    }

    private void setScreenChangeState(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                this.screenChangeState = n;
                break;
            }
            default: {
                Buffer buffer = new Buffer();
                buffer.append("ScreenManager#setScreenChangeState: screenChangeState ");
                buffer.append(n);
                buffer.append(" is not supported.");
                throw new IllegalArgumentException(buffer.toString());
            }
        }
    }

    private int getExitScreenAnimationType() {
        return this.screenChangeAnimationInfo[0];
    }

    private int getEnterScreenAnimationType() {
        return this.screenChangeAnimationInfo[2];
    }

    private void computeScreenChangeTypes(int[] nArray, IScreenData iScreenData, IScreenData iScreenData2, int[] nArray2) {
        this.getScreenManager().getScreen(iScreenData);
        this.getScreenManager().getScreen(iScreenData2);
        this.screenChangeAnimationInfo = this.getAnimationController().getScreenChangeTypes(nArray, iScreenData, iScreenData2, nArray2);
    }

    public boolean wasPopupFadedOut() {
        return this.startScreenData.isPopup();
    }

    private void setupExitAnimation() {
        this.animationRolledBack = false;
        this.log.log(10000000, "AnimationState.setupExitAnimation()");
        this.screenChangeAnimation = this.getAnimationController().getIAnimation(this.screenChangeAnimationInfo[0]);
        this.screenChangeAnimation.addListener(this);
        if (((HMITerminalEvo)this.getTerminalContext().getHmiTerminal()).getDrawerFocusManager().getDrawerState() != 4) {
            this.getEventDispatcherAdmin().blockScreenChangeDisturbingEvents();
        }
    }

    private void setupEnterAnimation() {
        this.log.log(10000000, "AnimationState.setupEnterAnimation()");
        this.screenChangeAnimation = this.getAnimationController().getIAnimation(this.screenChangeAnimationInfo[2]);
        this.screenChangeAnimation.addListener(this);
    }

    public boolean startScreenChangeAnimation(IScreenData iScreenData, IScreenData iScreenData2) {
        try {
            this.log.log(10000000, "ScreenChangeAnimationManager.startScreenChangeAnimation called");
            if (!this.initialize(iScreenData, iScreenData2)) {
                return false;
            }
            if (!this.isAnimationNeeded()) {
                return false;
            }
            this.setupExitAnimation();
            this.setScreenChangeState(1);
            this.screenChangeAnimation.startScreenChangeAnimation(this.screenChangeAnimationInfo, false, iScreenData, iScreenData2);
            if (!this.screenChangeAnimation.isAnimating()) {
                this.log.log(10000, "ScreenChangeAnimationManager.startScreenChangeAnimation animation not animating for type: %1, change without animation", (long)this.getExitScreenAnimationType());
                this.cleanupAnimation();
                return false;
            }
            return true;
        }
        catch (Exception exception) {
            this.log.log(10000, "ScreenChangeAnimationManager.startScreenChangeAnimation exception starting screen change animation, try to change without animation %1", (Object)exception, (long)this.getExitScreenAnimationType());
            this.cleanupAnimation();
            return false;
        }
    }

    private void startFadeInAnimation() {
        this.log.log(10000000, "ScreenChangeAnimationManager.startFadeInAnimation");
        this.setupEnterAnimation();
        this.setScreenChangeState(2);
        this.screenChangeAnimation.startScreenChangeAnimation(this.screenChangeAnimationInfo, true, this.startScreenData, this.targetScreenData);
    }

    private void cleanupAnimation() {
        this.log.log(10000000, "ScreenChangeAnimationManager.cleanupAnimation()");
        this.setScreenChangeState(0);
        if (this.screenChangeAnimation != null && this.screenChangeAnimation.isAnimating()) {
            this.screenChangeAnimation.stopAnimation();
        }
        this.screenChangeAnimation = null;
        this.getEventDispatcherAdmin().unBlockHardkeys();
        this.getEventDispatcherAdmin().unBlockScreenChangeDisturbingEvents();
    }

    private void fadeOutAnimationFinished() {
        this.getEventDispatcherAdmin().blockHardkeys();
        try {
            this.screenChangeUnit.notifyScreenFadedOut(this.startScreenData.getScreen());
            if (this.wasPopupFadedOut()) {
                this.screenChangeUnit.processFadeOutPopup();
            } else {
                this.screenChangeUnit.processFadeOutScreen();
            }
            if (this.targetScreenData != this.getScreenManager().getCurrentConnectedScreenData()) {
                this.updateTargetScreen(this.getScreenManager().getCurrentConnectedScreenData());
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "ScreenChangeAnimationManager#fadeOutAnimationFinished exception after fadeout animation finished trying to fadein new screen %1", (Throwable)exception);
        }
        try {
            this.startFadeInAnimation();
        }
        catch (Exception exception) {
            this.log.log(10000, "ScreenChangeAnimationManager#fadeOutAnimationFinished exception starting fadein animation cleaning up %1", (Throwable)exception);
            this.cleanupAnimation();
            this.screenChangeUnit.fadeInAnimationFinished();
        }
        if (!this.screenChangeAnimation.isAnimating()) {
            this.log.log(10000, "ScreenChangeAnimationManager#fadeOutAnimationFinished fade in animation not animating for type: %1, skip fade in animation", (long)this.getEnterScreenAnimationType());
            this.cleanupAnimation();
            this.screenChangeUnit.fadeInAnimationFinished();
        }
    }

    private boolean initialize(IScreenData iScreenData, IScreenData iScreenData2) {
        Screen screen;
        if (this.screenChangeState != 0) {
            this.log.log(100000, "initialize not allowed when state != SCREENCHANGE_STATE_FADEIN");
            return false;
        }
        if (iScreenData == null || iScreenData2 == null) {
            this.log.log(10000000, "intialize: no animation possible: current screen data: %1, target screen data:%2 ", (Object)iScreenData, (Object)iScreenData2);
            return false;
        }
        if (!iScreenData.isScreenIDValid() || !iScreenData2.isScreenIDValid()) {
            this.log.log(10000000, "intialize: no animation possible: current screen id: %1, target screen id:%2 ", (long)iScreenData.getId(), (long)iScreenData2.getId());
            return false;
        }
        if (iScreenData2.getScreen() == null && (screen = this.getScreenManager().getScreen(iScreenData2)) == null) {
            this.log.log(100000, "intialize: no animation possible: target screen is null ");
            return false;
        }
        if (!iScreenData.isPopup() && iScreenData2.isPopup() && this.popupManager.isLogicalPopup(iScreenData2)) {
            this.log.log(10000000, "intialize: no animation possible: target screen is logical popup, current screen is no popup ");
            return false;
        }
        this.startScreenData = iScreenData;
        this.targetScreenData = iScreenData2;
        this.modelledAnimationInfo = this.computeModelledAnimationInfo(iScreenData2);
        this.computeScreenChangeTypes(this.modelledAnimationInfo, this.startScreenData, iScreenData2, CURRENT_ANIMATION_INFO_INIT);
        return true;
    }

    private void updateTargetScreen(IScreenData iScreenData) {
        if (this.screenChangeState != 1) {
            this.log.log(100000, "updateTargetScreen not allowed when state != SCREENCHANGE_STATE_FADEOUT");
            return;
        }
        this.targetScreenData = iScreenData;
        this.computeScreenChangeTypes(this.modelledAnimationInfo, this.startScreenData, iScreenData, this.screenChangeAnimationInfo);
    }

    private boolean isAnimationNeeded() {
        return this.screenChangeAnimationInfo[0] != 0 || this.screenChangeAnimationInfo[2] != 0;
    }

    private int[] computeModelledAnimationInfo(IScreenData iScreenData) {
        int n = iScreenData.getAnimationInfo();
        this.log.log(10000000, "ScreenChangeAnimationManager#computeModelledAnimationInfo modelledInfo: %1", (long)n);
        int[] nArray = new int[2];
        nArray[1] = n;
        if (this.animationRolledBack) {
            nArray[0] = nArray[0] | 0x800;
        }
        if (iScreenData.isReinit()) {
            nArray[1] = nArray[1] | 0x100;
        }
        if (this.startScreenData.isPopup()) {
            if (iScreenData.isPopup()) {
                if (this.popupManager.isLogicalPopup(iScreenData)) {
                    nArray[0] = nArray[0] | 0x400;
                    nArray[1] = nArray[1] | 0x400;
                } else if (iScreenData.isAnimated()) {
                    nArray[0] = nArray[0] | 0x200;
                    nArray[1] = nArray[1] | 0x200;
                }
            } else {
                nArray[0] = nArray[0] | 0x400;
                nArray[1] = nArray[1] | 0x400;
            }
        } else if (iScreenData.isPopup()) {
            nArray[0] = nArray[0] | 0x200;
            nArray[1] = nArray[1] | 0x200;
        } else if (iScreenData.isAnimated()) {
            if ((n & 1) == 0) {
                this.log.log(100000, "ScreenChangeAnimationManager#computeModelledAnimationInfo old application change set, but not modelled in animationInfo");
            }
            nArray[0] = nArray[0] | 1;
            nArray[1] = nArray[1] | 1;
        }
        return nArray;
    }

    public void animate(int n, float f2) {
    }

    public void animate(int n, float f2, int n2) {
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        this.log.log(10000000, "ScreenChangeAnimationManager.animationFinished() type=%1, terminal=%2", (long)n, (long)this.getTerminalId());
        switch (this.getScreenChangeState()) {
            case 0: {
                this.log.log(10000, "ERR: state == SCREENCHANGE_STATE_INIT --> ignored");
                break;
            }
            case 1: {
                this.log.log(10000000, "state == SCREENCHANGE_STATE_FADEOUT");
                this.fadeOutAnimationFinished();
                this.getDrawerFocusManager().screenFadedOut();
                if (this.getScreenChangeState() != 0 || this.screenChangeUnit == null || this.screenChangeUnit.getViewSizeManager() == null) break;
                this.screenChangeUnit.getViewSizeManager().screenChangeStateFinished(1);
                break;
            }
            case 2: {
                this.log.log(10000000, "state == SCREENCHANGE_STATE_FADEIN");
                this.cleanupAnimation();
                this.getDrawerFocusManager().screenChangeFinished();
                this.checkForDelayedDisconnecting();
                this.screenChangeUnit.fadeInAnimationFinished();
                if (this.getScreenChangeState() != 0 || this.screenChangeUnit == null || this.screenChangeUnit.getViewSizeManager() == null) break;
                this.screenChangeUnit.getViewSizeManager().screenChangeStateFinished(2);
                break;
            }
            default: {
                this.log.log(10000, "ERR: state == unknown --> ignored");
            }
        }
    }

    private void checkForDelayedDisconnecting() {
        if (!this.screenChangeUnit.isAlwaysDisconnectOnScreenChange() && this.startScreenData.getScreen() != this.targetScreenData.getScreen()) {
            this.startScreenData.getScreen().disconnecting();
            if (this.targetScreenData.getScreen().getTerminal() != null && this.targetScreenData.getScreen().getTerminal().getGUIManager() != null) {
                this.targetScreenData.getScreen().getTerminal().getGUIManager().draw();
            }
        }
    }

    public void setFocus(int n) {
        this.currentFocus = n;
    }

    public void rollBackEnterAnimation(boolean bl) {
        if (this.animationRolledBack) {
            if (!bl) {
                this.screenChangeAnimation.rollBackAnimation(true);
                this.animationRolledBack = false;
            }
        } else if (bl) {
            this.screenChangeAnimation.rollBackAnimation(true);
            this.animationRolledBack = true;
        }
    }

    protected IDrawerFocusManagerEvo getDrawerFocusManager() {
        return ((HMITerminalEvo)this.getTerminalContext().getHmiTerminal()).getDrawerFocusManager();
    }
}

