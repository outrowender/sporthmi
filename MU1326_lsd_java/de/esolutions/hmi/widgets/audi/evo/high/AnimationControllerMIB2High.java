/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IStatistics;
import de.audi.atip.mmicombi.IMMICombiAnimationSyncer;
import de.audi.atip.mmicombi.IMMICombiScreen;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IAbstractCursorBarWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.base.animation.CombinedAnimation;
import de.esolutions.hmi.widgets.audi.evo.IAnimationTypesEvo;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationMIB2HighSport;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationParametersEvoHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AnimationControllerMIB2High
extends AnimationController
implements IAnimationTypesEvo {
    private static final int[] ANIMATION_TYPES_FOR_COMBI_SYNC = new int[]{51, 57, 22, 28, 25, 24, 53, 52, 56, 61, 62};
    private boolean drawerWasClosed;
    private final AnimationInfoProvider dumpInfoProvider = new AnimationInfoProvider();
    private int skin = 0;
    private CombinedAnimation kdkAnimation;

    public AnimationControllerMIB2High(int n) {
        super(n);
        AbstractWidget.framework.getErrorMgr().registerDumpInfoProvider(this.dumpInfoProvider);
    }

    public void deactivateAnimation(int n, AbstractAnimation abstractAnimation, Exception exception) {
        super.deactivateAnimation(n, abstractAnimation, exception);
        this.dumpInfoProvider.animationEnded(abstractAnimation, exception);
    }

    protected AbstractAnimation createAnimation(int n) {
        if (this.skin == 1) {
            return new AnimationMIB2HighSport(this);
        }
        return new AnimationMIB2High(this);
    }

    public CombinedAnimation getCombinedAnimation(int n) {
        return new CombinedAnimation(this);
    }

    public int[] getScreenChangeTypes(int[] nArray, IScreenData iScreenData, IScreenData iScreenData2, int[] nArray2) {
        this.initialize(nArray, iScreenData, iScreenData2, nArray2);
        if (!this.checkParameters(nArray, this.currentScreen, this.targetScreen, nArray2)) {
            this.logAnimation.log(10000, "AnimationControllerMIBHigh#getScreenChangeTypes invalid parameters");
            System.arraycopy((Object)COMPUTED_ANIMATION_INFO_NO_ANIMATION, 0, (Object)this.computedAnimationInfo, 0, COMPUTED_ANIMATION_INFO_NO_ANIMATION.length);
            return this.computedAnimationInfo;
        }
        if (this.currentScreen == null) {
            this.logAnimation.log(10000000, "AnimationControllerMIBHigh#getScreenChangeTypes current screen is null, only o.k. for first screen");
            System.arraycopy((Object)COMPUTED_ANIMATION_INFO_NO_ANIMATION, 0, (Object)this.computedAnimationInfo, 0, COMPUTED_ANIMATION_INFO_NO_ANIMATION.length);
            return this.computedAnimationInfo;
        }
        int[] nArray3 = this.computeAnimationTypes();
        if (LOG_SCREEN_CHANGE) {
            this.logScreenChangeEngine(nArray, this.currentScreen, this.targetScreen, nArray2, nArray3);
        }
        if (SHOW_SCREEN_CHANGE_ANIMATION_INFO) {
            if (this.terminal == null) {
                this.logAnimation.log(100000, "AnimationControllerMIBHigh#getScreenChangeTypes Cannot show statistics because terminal not set");
            } else {
                IStatistics iStatistics = this.terminal.getStatistics();
                if (iStatistics == null) {
                    this.logAnimation.log(100000, "AnimationControllerMIBHigh#getScreenChangeTypes Statistics not found");
                } else {
                    String[] stringArray = this.getScreenChangeEngineInfo(nArray, this.currentScreen, this.targetScreen, nArray2, nArray3);
                    iStatistics.showStatistics(17, stringArray, false);
                }
            }
        }
        return nArray3;
    }

    private void checkForCurrentScreenLeaveInfo() {
        if (this.currentAnimationInfo[0] != 0 || this.currentAnimationInfo[1] > 0) {
            if (this.currentScreen == this.targetScreen) {
                this.computedAnimationInfo[0] = this.currentAnimationInfo[0];
                this.computedAnimationInfo[1] = this.currentAnimationInfo[1];
                this.computedAnimationInfo[2] = this.currentAnimationInfo[2];
                this.computedAnimationInfo[3] = this.currentAnimationInfo[3];
            }
            if (this.currentAnimationInfo[0] == 22) {
                this.computedAnimationInfo[0] = 22;
                this.computedAnimationInfo[2] = 22;
            }
            if (this.currentContextID != this.targetContextID && this.currentContextID != 0) {
                this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 1;
            }
            if (this.currentContextID != this.targetContextID && this.targetContextID != 0) {
                this.logAnimation.log(10000000, "AnimationControllerMIBHigh#checkForCurrentScreenLeaveType targetContextID: %1", (long)this.targetContextID);
                this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 1;
            }
            if (this.currentContextID == this.targetContextID && (this.currentAnimationInfo[1] & 1) > 0) {
                this.logAnimation.log(10000000, "AnimationControllerMIBHigh#checkForCurrentScreenLeaveType currentcontextID = targetContextID: %1", (long)this.targetContextID);
                this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 1;
            }
        }
    }

    private void checkBackgroundFadeInTargetScreen() {
        if (this.currentContextID != this.targetContextID) {
            if (this.targetContextID != 0 && this.targetContextID != 35 && !this.isTVTeletextSwitch() && !this.isFullscreenOverlaySwitch()) {
                this.logAnimation.log(10000000, "AnimationControllerMIBHigh#checkBackgroundFadeInTargetScreen targetContextID: %1", (long)this.targetContextID);
                this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 1;
            }
        } else if (this.targetContextID == 4 || this.targetContextID == 39 || this.targetScreenType == 4 || this.targetScreenType == 14) {
            this.logAnimation.log(10000000, "AnimationControllerMIBHigh#checkBackgroundFadeInTargetScreen targetScreenType is Browser:");
            this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 1;
        }
    }

    private boolean isTVTeletextSwitch() {
        if (!(this.currentContextID != 1 && this.currentContextID != 36 || this.targetContextID != 23 && this.targetContextID != 57)) {
            return true;
        }
        return !(this.currentContextID != 23 && this.currentContextID != 57 || this.targetContextID != 1 && this.targetContextID != 36);
    }

    private boolean isFullscreenOverlaySwitch() {
        if ((this.currentContextID == 1 || this.currentContextID == 36) && this.targetContextID == 67) {
            return true;
        }
        if (this.currentContextID == 67 && (this.targetContextID == 1 || this.targetContextID == 36)) {
            return true;
        }
        if ((this.currentContextID == 6 || this.currentContextID == 41) && this.targetContextID == 71) {
            return true;
        }
        if (this.currentContextID == 71 && (this.targetContextID == 6 || this.targetContextID == 41)) {
            return true;
        }
        if ((this.currentContextID == 2 || this.currentContextID == 37) && this.targetContextID == 68) {
            return true;
        }
        if (this.currentContextID == 68 && (this.targetContextID == 2 || this.targetContextID == 37)) {
            return true;
        }
        if ((this.currentContextID == 7 || this.currentContextID == 42) && this.targetContextID == 69) {
            return true;
        }
        if (this.currentContextID == 69 && (this.targetContextID == 7 || this.targetContextID == 42)) {
            return true;
        }
        if ((this.currentContextID == 8 || this.currentContextID == 43) && this.targetContextID == 70) {
            return true;
        }
        return this.currentContextID == 70 && (this.targetContextID == 8 || this.targetContextID == 43);
    }

    private void checkBackgroundFadeOutCurrentScreen() {
        if (this.currentContextID != this.targetContextID) {
            if (this.currentContextID != 0 && this.currentContextID != 35 && !this.isTVTeletextSwitch() && !this.isFullscreenOverlaySwitch()) {
                this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 1;
            }
        } else if (this.currentContextID == 4 || this.currentContextID == 39) {
            this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 1;
        }
    }

    private boolean isAnimationModelled() {
        return (this.modelledAnimationInfo[0] & 0xFFFFFEFF) > 0 || (this.modelledAnimationInfo[1] & 0xFFFFFEFF) > 0;
    }

    protected int[] computeAnimationTypes() {
        boolean bl = false;
        this.terminal.getDrawerFocusManager().setUsePersistence(false);
        if (this.terminal.getDrawerFocusManager().getDrawerState() != 16) {
            this.drawerWasClosed = true;
        }
        if (this.isEnterAnimationRolledBack()) {
            this.computedAnimationInfo[0] = 23;
            this.computedAnimationInfo[2] = 22;
            return this.computedAnimationInfo;
        }
        if (this.isChangeInRemoteHMI()) {
            return this.computeAnimationeTypeRemoteHMI();
        }
        if (this.isNotAnimatedChangeOnSameScreen()) {
            this.logAnimation.log(10000000, "AnimationControllerMIBHigh#getScreenChangeTypes change to same screen, currently no animation running");
            System.arraycopy((Object)COMPUTED_ANIMATION_INFO_NO_ANIMATION, 0, (Object)this.computedAnimationInfo, 0, COMPUTED_ANIMATION_INFO_NO_ANIMATION.length);
        } else {
            if (!(this.checkForExplicitNoAnimation() || this.checkForPopupChange() || this.checkApplicationChange() || this.checkForOptionDrawerPopup() || (bl = this.checkForClosingToOptionDrawer()) || this.checkForHKSelection() || this.checkForFadingInPlace())) {
                this.checkForStandardChange();
            }
            this.checkBackgroundFadeOutCurrentScreen();
            this.checkBackgroundFadeInTargetScreen();
            this.checkForCurrentScreenLeaveInfo();
            this.checkForDrawerAnimation();
        }
        this.drawerWasClosed = false;
        this.checkForStageChange(bl);
        return this.computedAnimationInfo;
    }

    private void checkForStageChange(boolean bl) {
        if (this.currentScreen != this.targetScreen) {
            boolean bl2;
            boolean bl3 = bl2 = this.targetScreenData.getScreenMode() == 2 && ((ScreenWidgetEVO)this.targetScreen).getSmallStageType() != 10;
            if (((ScreenWidgetEVO)this.targetScreen).isLargeViewSizeNeeded() || bl2 || bl) {
                if (((IMMICombiScreen)((Object)this.targetScreen)).isHMIScreen()) {
                    this.terminal.getViewSizeManager().requestEarlyViewSizeChange(2, this.targetScreen.getID());
                }
            } else if (this.terminal.getViewSizeManager().getPreferredViewSize() == 1 && !this.terminal.getViewSizeManager().isNonScreenBasedRequestActive() && ((IMMICombiScreen)((Object)this.targetScreen)).isHMIScreen()) {
                this.terminal.getViewSizeManager().requestEarlyViewSizeChange(1, this.targetScreen.getID());
            }
        }
    }

    public void dump() {
        PrintStream printStream = new PrintStream(System.out);
        this.dumpInfoProvider.dump(printStream, null);
    }

    private void checkForDrawerAnimation() {
        if (this.targetScreenData != null && this.currentScreenData != null) {
            if (this.currentScreenData.getSelectionDrawerID() != this.targetScreenData.getSelectionDrawerID()) {
                this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 8;
                this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 8;
            }
            if (this.currentScreenData.getOptionsDrawerID() != this.targetScreenData.getOptionsDrawerID()) {
                this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 4;
                this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 4;
            }
        }
    }

    private boolean isNotAnimatedChangeOnSameScreen() {
        if (this.currentScreen == this.targetScreen && this.currentScreenType == 1) {
            return true;
        }
        return this.currentScreen == this.targetScreen && !this.isAnimationModelled() && !this.drawerWasClosed && !this.isAnimationComputedInCurrentInfo();
    }

    private boolean isChangeInRemoteHMI() {
        return (this.currentScreenType == 13 || this.currentScreenType == 1 || this.currentScreenType == 14) && this.targetScreenType == 13 && IAnimationController.ModelContainer.screenExitRemoteHMI != null && IAnimationController.ModelContainer.screenEnterRemoteHMI != null;
    }

    private boolean isEnterAnimationRolledBack() {
        return (this.modelledAnimationInfo[0] & 0x800) > 0;
    }

    private int[] computeAnimationeTypeRemoteHMI() {
        if (IAnimationController.ModelContainer.screenExitRemoteHMI.getValue() == -1 || IAnimationController.ModelContainer.screenEnterRemoteHMI.getValue() == -1) {
            System.arraycopy((Object)COMPUTED_ANIMATION_INFO_NO_ANIMATION, 0, (Object)this.computedAnimationInfo, 0, COMPUTED_ANIMATION_INFO_NO_ANIMATION.length);
            return this.computedAnimationInfo;
        }
        int[] nArray = new int[]{IAnimationController.ModelContainer.screenExitRemoteHMI.getValue(), IAnimationController.ModelContainer.screenExitAdditionalInformationRemoteHMI.getValue(), IAnimationController.ModelContainer.screenEnterRemoteHMI.getValue(), IAnimationController.ModelContainer.screenEnterAdditionalInformationRemoteHMI.getValue()};
        if (nArray[0] == 27 && (nArray[1] & 2) > 0) {
            this.terminal.getDrawerFocusManager().setUsePersistence(true);
        }
        if (this.targetScreenData != null && this.currentScreenData != null && this.currentScreenData.getOptionsDrawerID() != this.targetScreenData.getOptionsDrawerID()) {
            nArray[1] = nArray[1] | 8;
            nArray[3] = nArray[3] | 8;
            nArray[1] = nArray[1] | 4;
            nArray[3] = nArray[3] | 4;
        }
        return nArray;
    }

    private boolean checkForExplicitNoAnimation() {
        return (this.modelledAnimationInfo[1] & 0x20) > 0;
    }

    protected boolean checkForPopupChange() {
        if (this.isSpecialPopupChange()) {
            if (this.isChangeFromRVC()) {
                return true;
            }
            this.computedAnimationInfo[0] = 22;
            this.computedAnimationInfo[2] = 22;
            return true;
        }
        if ((this.modelledAnimationInfo[1] & 0x200) > 0) {
            this.computedAnimationInfo[0] = 25;
            this.computedAnimationInfo[2] = 25;
            return true;
        }
        if ((this.modelledAnimationInfo[0] & 0x400) > 0) {
            this.computedAnimationInfo[0] = 24;
            this.computedAnimationInfo[2] = 24;
            this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 2;
            this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 2;
            return true;
        }
        if (this.isModelledPopupScreen(this.currentScreenType) || this.isModelledPopupScreen(this.targetScreenType)) {
            this.checkForModelledPopup();
            return true;
        }
        return false;
    }

    private void checkForModelledPopup() {
        if (this.isModelledPopupScreen(this.currentScreenType) && !this.isModelledPopupScreen(this.targetScreenType)) {
            if (this.currentScreenType == 8) {
                this.computedAnimationInfo[0] = 24;
                this.computedAnimationInfo[2] = 24;
            }
        } else if (!this.isModelledPopupScreen(this.currentScreenType) && this.isModelledPopupScreen(this.targetScreenType)) {
            if (this.targetScreenType == 8) {
                this.computedAnimationInfo[0] = 25;
                this.computedAnimationInfo[2] = 25;
            }
        } else {
            this.logAnimation.log(10000000, "AnimationControllerMIBHigh#checkForModelledPopup current screen and target screen are modelled as popups, don't animate");
        }
    }

    private boolean isSpecialPopupChange() {
        return this.currentScreenType == 5 || this.currentScreenType == 6 || this.targetScreenType == 5 || this.targetScreenType == 6;
    }

    private boolean isChangeFromRVC() {
        return this.currentScreenType == 5;
    }

    private boolean isModelledPopupScreen(int n) {
        switch (n) {
            case 7: {
                return false;
            }
            case 8: {
                return true;
            }
            case 9: {
                return true;
            }
        }
        return false;
    }

    private IDrawerFocusManagerEvo getDrawerFocusManager() {
        return this.terminal != null ? ((HMITerminalEvo)((Object)this.terminal)).getDrawerFocusManager() : null;
    }

    protected boolean checkApplicationChange() {
        this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkApplicationChange");
        if ((this.modelledAnimationInfo[1] & 1) > 0) {
            EntertainmentDrawerContentController entertainmentDrawerContentController;
            EntertainmentDrawerController entertainmentDrawerController;
            EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController;
            this.logAnimation.log(10000000, "AnimationControllerMIBHigh#checkApplicationChange app change modelled current exit info: %1 enter info: %2", (long)this.currentAnimationInfo[0], (long)this.currentAnimationInfo[2]);
            this.computedAnimationInfo[0] = 22;
            this.computedAnimationInfo[2] = 22;
            IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.getDrawerFocusManager();
            if (iDrawerFocusManagerEvo != null && iDrawerFocusManagerEvo.getDrawerState() == 32 && iDrawerFocusManagerEvo.getEntertainmentDrawer() != null && (entertainmentDrawerOpenCloseController = (entertainmentDrawerController = (EntertainmentDrawerController)iDrawerFocusManagerEvo.getEntertainmentDrawer()).getOpenCloseController()) != null && (entertainmentDrawerContentController = entertainmentDrawerOpenCloseController.getContent()) != null && !EntertainmentDrawerContentManager.isSDSAudioSource(entertainmentDrawerContentController.getAudioSource())) {
                iDrawerFocusManagerEvo.requestDrawerState(16);
            }
            return true;
        }
        return false;
    }

    protected boolean checkForOptionDrawerPopup() {
        this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkForOptionDrawerPopup");
        if (this.isChangeFromOpenOptionDrawer()) {
            this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkForOptionDrawerPopup change from option drawer popup modelled");
            this.computedAnimationInfo[0] = 27;
            this.computedAnimationInfo[2] = 27;
            this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 4;
            this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 4;
            return true;
        }
        return false;
    }

    private boolean isChangeFromOpenOptionDrawer() {
        return (this.modelledAnimationInfo[1] & 8) > 0;
    }

    protected boolean checkForFadingInPlace() {
        this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkForFadingInPlace");
        if ((this.modelledAnimationInfo[1] & 0x10) > 0 || this.terminal.getDrawerFocusManager().getDrawerState() == 4 || this.currentContextID != this.targetContextID && this.currentScreenType != 1 && this.targetScreenType != 1) {
            this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkForFadingInPlace show fade in place animation");
            this.computedAnimationInfo[0] = 28;
            this.computedAnimationInfo[2] = 28;
            return true;
        }
        return false;
    }

    protected boolean checkForClosingToOptionDrawer() {
        this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkForClosingToOptionDrawer");
        if ((this.modelledAnimationInfo[1] & 0x80) > 0) {
            this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkForClosingToOptionDrawer closing to option drawer");
            this.computedAnimationInfo[0] = 27;
            this.computedAnimationInfo[2] = 27;
            this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 2;
            this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 2;
            this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 4;
            this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 4;
            this.terminal.getDrawerFocusManager().setUsePersistence(true);
            return true;
        }
        return false;
    }

    protected boolean checkForHKSelection() {
        this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkForHKSelection");
        if ((this.modelledAnimationInfo[1] & 0x40) > 0) {
            this.logAnimation.log(10000000, "AnimationControllerMIB2High#checkForHKSelection showing HK-Selection animation");
            this.computedAnimationInfo[0] = 26;
            this.computedAnimationInfo[2] = 26;
            this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 2;
            this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 2;
            return true;
        }
        return false;
    }

    private boolean checkForStandardChange() {
        if (this.currentScreen == this.targetScreen && !this.isAnimationComputedInCurrentInfo() && !this.isSubMenuAnimationModelled()) {
            this.computedAnimationInfo[0] = 0;
            this.computedAnimationInfo[2] = 0;
        } else {
            this.computedAnimationInfo[0] = 26;
            this.computedAnimationInfo[2] = 26;
            if ((this.modelledAnimationInfo[1] & 4) > 0) {
                this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 2;
                this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 2;
            } else if ((this.modelledAnimationInfo[1] & 2) == 0 && (this.modelledAnimationInfo[1] & 0x100) == 0) {
                this.computedAnimationInfo[1] = this.computedAnimationInfo[1] | 2;
                this.computedAnimationInfo[3] = this.computedAnimationInfo[3] | 2;
            }
        }
        return true;
    }

    private boolean isSubMenuAnimationModelled() {
        return (this.modelledAnimationInfo[1] & 4) > 0 || (this.modelledAnimationInfo[1] & 2) > 0;
    }

    private boolean isAnimationComputedInCurrentInfo() {
        return this.currentAnimationInfo[0] != 0 || this.currentAnimationInfo[2] != 0;
    }

    public boolean isScreenChangeAnimationRunning() {
        return AbstractWidget.hmiService.isScreenChangeAnimationRunning(this.terminal.getTerminalID());
    }

    public boolean isScreenChangeType(int n) {
        return n >= 21 && n < 40;
    }

    public void startWaitAnimation(int n) {
        IAbstractCursorBarWidget iAbstractCursorBarWidget = (IAbstractCursorBarWidget)((Object)this.widgetRegistry.getWidget(1, n, this.connectedMainScreen));
        if (iAbstractCursorBarWidget != null) {
            iAbstractCursorBarWidget.startWaitAnimation(0);
        } else {
            this.logAnimation.log(10000000, "Animation#startWaitAnimation no cursor to fade");
        }
    }

    public void stopWaitAnimation(int n) {
        AbstractWidget abstractWidget = this.widgetRegistry.getWidget(1, n, this.connectedMainScreen);
        this.stopAnimation(2);
        if (abstractWidget != null) {
            abstractWidget.setCompositesDirty(true);
        }
    }

    public String getAnimationName(int n) {
        switch (n) {
            case 0: {
                return "No animation";
            }
            case 1: {
                return "Endless animation";
            }
            case 2: {
                return "Wait fading";
            }
            case 22: {
                return "Black Fading";
            }
            case 23: {
                return "TYPE_SCREEN_CHANGE_FAKE_ANIMATION";
            }
            case 24: {
                return "Remove Popup";
            }
            case 25: {
                return "Show Popup";
            }
            case 26: {
                return "screen change standard";
            }
            case 27: {
                return "show option drawer popup";
            }
            case 28: {
                return "Fading in place";
            }
            case 31: {
                return "TYPE_MIXEDLIST_KDK_PREVIEWMAP_FADING";
            }
            case 51: {
                return "TYPE_VIEW_SIZE_CHANGE_COMBINED";
            }
            case 52: {
                return "TYPE_SELECTION_DRAWER";
            }
            case 53: {
                return "TYPE_OPTION_DRAWER";
            }
            case 54: {
                return "TYPE_CLOSED_SELECTION_DRAWER";
            }
            case 55: {
                return "TYPE_CLOSED_OPTION_DRAWER";
            }
            case 56: {
                return "TYPE_VIEW_SIZE_EXIT_VIEW_FADING";
            }
            case 57: {
                return "TYPE_VIEW_SIZE_TUBES_MAIN_AREA";
            }
            case 58: {
                return "TYPE_ENTERTAINMENT_DRAWER";
            }
            case 59: {
                return "TYPE_CLOSED_ENTERTAINMENT_DRAWER";
            }
            case 71: {
                return "TYPE_SCROLLBAR";
            }
            case 72: {
                return "TYPE_PARTIAL_POPUP_FADING";
            }
            case 73: {
                return "TYPE_SPELLER_CURSOR_MOVEMENT";
            }
            case 74: {
                return "TYPE_RADIOBUTTON";
            }
            case 75: {
                return "TYPE_CHECKBOX";
            }
            case 76: {
                return "TYPE_CONTAINER";
            }
            case 77: {
                return "TYPE_SPELLER_OPEN";
            }
            case 78: {
                return "TYPE_MENU";
            }
            case 79: {
                return "TYPE_MENU_MOVE_CURSOR_GAP";
            }
            case 80: {
                return "TYPE_ENTERTAINMENT_DRAWER_LONG_ANIM";
            }
            case 81: {
                return "TYPE_STATUSBAR_GAP";
            }
            case 82: {
                return "TYPE_ENTERTAINMENT_DRAWER_RESIZE_ANIM";
            }
            case 83: {
                return "TYPE_ENTERTAINMENT_DRAWER_FADE_ANIM";
            }
            case 84: {
                return "TYPE_SELECTION_DRAWER_VIEWPORT";
            }
            case 85: {
                return "TYPE_SELECTION_DRAWER_CURSOR";
            }
            case 86: {
                return "TYPE_MAINWIZARD_VIEWPORT";
            }
            case 87: {
                return "TYPE_MAINWIZARD_CURSOR";
            }
            case 88: {
                return "TYPE_SELECTION_DRAWER_GAP";
            }
            case 89: {
                return "TYPE_SPELLER_EXPAND";
            }
            case 90: {
                return "TYPE_MIXEDLIST";
            }
            case 91: {
                return "TYPE_MIXEDLIST_DEBUG";
            }
            case 92: {
                return "TYPE_PICTUREWALL_SCROLL";
            }
            case 93: {
                return "TYPE_PICTUREWALL_SCROLL_FAST";
            }
            case 94: {
                return "TYPE_PICTUREWALL_SCALE";
            }
            case 95: {
                return "TYPE_ROUTE_CRITERIA_BOX";
            }
            case 96: {
                return "TYPE_TOUCHFIELD_INFOLINE_OPEN";
            }
            case 97: {
                return "TYPE_3D_CAR_ANIMATION";
            }
            case 100: {
                return "TYPE_3D_DRIVESELECT_SHIFT_ANIMATION";
            }
            case 101: {
                return "TYPE_3D_DRIVESELECT_GYRO_ANIMATION";
            }
            case 98: {
                return "TYPE_COMBO_BOX";
            }
            case 99: {
                return "TYPE_USER_HINT";
            }
            case 102: {
                return "TYPE_USER_HINT_MAP";
            }
            case 104: {
                return "TYPE_COVERSTACK_CROSSFADING";
            }
            case 105: {
                return "TYPE_SDS_LINE_NUMBERS";
            }
            case 106: {
                return "TYPE_MENU_CURSOR_BOUNCE";
            }
            case 108: {
                return "TYPE_3D_DRIVESELECT_GYRO_GRID_ANIMATION";
            }
        }
        AbstractWidget.logChannel.log(10000000, "AnimationController#getAnimationName unknown animationtype %1", (long)n);
        return "Unknown animation type";
    }

    public int[] getAnimationsTypesForCombiSync() {
        return ANIMATION_TYPES_FOR_COMBI_SYNC;
    }

    public void readAnimationParametersFromFile(String string) {
        AnimationParametersEvoHigh.getAnimationParametersEvoHigh().readAnimationParametersFromFile(string);
    }

    public void setDrawerWasClosed(boolean bl) {
        this.drawerWasClosed = bl;
    }

    public void startKDKAnimation(boolean bl) {
        this.logAnimation.log(10000000, "AnimationControllerMIB2High#startKdKAnimation kdkVisible: %1", bl);
        IWidgetLogChannel.logKDK.log(10000000, "AnimationControllerMIB2High#startKdKAnimation kdkVisible: %1", bl);
        if (this.animationSyncer != null) {
            this.animationSyncer.setKdKVisible(bl);
            if (!this.animationSyncer.isAnimationPlanActive()) {
                this.animationSyncer.activateNewAnimationPlan();
            }
        }
        if (this.kdkAnimation == null) {
            this.kdkAnimation = this.getCombinedAnimation(61);
        }
        if (this.kdkAnimation.isAnimating()) {
            IWidgetLogChannel.logKDK.log(10000000, "AnimationControllerMIB2High#startKdKAnimation rollback animation");
            this.kdkAnimation.rollBackAnimation(true);
        } else {
            float[] fArray = new float[]{0.0f, 0.0f};
            float[] fArray2 = new float[]{1000.0f, 1000.0f};
            int[] nArray = new int[]{62, 61};
            boolean[] blArray = new boolean[]{true, true};
            if (!bl) {
                nArray = new int[]{61, 62};
                blArray = new boolean[]{false, false};
            }
            IWidgetLogChannel.logKDK.log(10000000, "AnimationControllerMIB2High#startKdKAnimation starting combined kdk animation");
            this.kdkAnimation.startCombinedAnimation(60, fArray, fArray2, nArray, blArray, (AbstractWidget)((Object)this.terminal.getPartialPopupManagerEvo().getPartialPopup(62)));
        }
    }

    public int getSkin() {
        return this.skin;
    }

    public void setSkin(int n) {
        this.skin = n;
        if (this.animationSyncer != null) {
            this.animationSyncer.setSkin(n);
        }
    }

    public void setMMICombiAnimationSyncer(IMMICombiAnimationSyncer iMMICombiAnimationSyncer) {
        this.animationSyncer = iMMICombiAnimationSyncer;
        iMMICombiAnimationSyncer.setSkin(this.skin);
    }

    private static class AnimationInfo {
        private int animationType = 0;
        private long startTime = 0L;
        private int steps = 0;
        private long endTime = 0L;
        private long plannedTime = 0L;
        private int timerInterval = 0;
        private Exception exception = null;

        private AnimationInfo() {
        }

        private int getAnimationType() {
            return this.animationType;
        }

        private void setAnimationType(int n) {
            this.animationType = n;
        }

        private long getStartTime() {
            return this.startTime;
        }

        private void setStartTime(long l) {
            this.startTime = l;
        }

        private int getSteps() {
            return this.steps;
        }

        private void setSteps(int n) {
            this.steps = n;
        }

        private long getEndTime() {
            return this.endTime;
        }

        private void setEndTime(long l) {
            this.endTime = l;
        }

        private long getPlannedTime() {
            return this.plannedTime;
        }

        private void setPlannedTime(long l) {
            this.plannedTime = l;
        }

        private float getUpdatesPerSecond() {
            return (float)this.steps / ((float)(this.getTotalTime() + (long)this.timerInterval) / 1000.0f);
        }

        private void setTimerInterval(int n) {
            this.timerInterval = n;
        }

        private Exception getException() {
            return this.exception;
        }

        private void setException(Exception exception) {
            this.exception = exception;
        }

        private long getTotalTime() {
            return this.endTime - this.startTime;
        }

        private boolean isFinishedInError() {
            return null != this.exception;
        }
    }

    private static class AnimationStatistics {
        private volatile int count = 0;
        private volatile long totalSteps = 0L;
        private volatile long totalTime = 0L;
        private volatile int errCount = 0;

        private AnimationStatistics() {
        }
    }

    private class AnimationInfoProvider
    implements DumpInfoProvider {
        private static final int HISTORY_RECORDS = 20;
        private final List animErrorHistory = new LinkedList();
        private final AnimationStatistics[] statistics;

        public AnimationInfoProvider() {
            this.statistics = new AnimationStatistics[AnimationControllerMIB2High.this.actualAnimations.length];
        }

        private synchronized void animationEnded(AbstractAnimation abstractAnimation, Exception exception) {
            this.addToHistory(abstractAnimation, exception);
            this.updateStatistics(abstractAnimation, null != exception);
        }

        private void addToHistory(AbstractAnimation abstractAnimation, Exception exception) {
            if (IStatisticsManager.INSTRUMENTATION_ENABLED && abstractAnimation.isInitialized()) {
                StatisticsManager.instance().getAnimationStatistics().registerAnimation(abstractAnimation.getType(), abstractAnimation.getCurrentAnimationStep(), abstractAnimation.getStartTime(), abstractAnimation.isAnimating() ? AbstractWidget.framework.getMonotonicTime() : abstractAnimation.getEndTime(), abstractAnimation.getPlannedDuration(), abstractAnimation.getTimerIntervall(), exception);
            }
            if (null != exception) {
                AnimationInfo animationInfo = new AnimationInfo();
                animationInfo.setAnimationType(abstractAnimation.getType());
                animationInfo.setSteps(abstractAnimation.getCurrentAnimationStep());
                animationInfo.setEndTime(abstractAnimation.isAnimating() ? AbstractWidget.framework.getMonotonicTime() : abstractAnimation.getEndTime());
                animationInfo.setStartTime(abstractAnimation.getStartTime());
                animationInfo.setPlannedTime(abstractAnimation.getPlannedDuration());
                animationInfo.setException(exception);
                animationInfo.setTimerInterval(abstractAnimation.getTimerIntervall());
                this.animErrorHistory.add(0, animationInfo);
                if (20 < this.animErrorHistory.size()) {
                    this.animErrorHistory.remove(20);
                }
            }
        }

        private void updateStatistics(AbstractAnimation abstractAnimation, boolean bl) {
            AnimationStatistics animationStatistics = this.statistics[abstractAnimation.getType()];
            if (null == animationStatistics) {
                this.statistics[abstractAnimation.getType()] = animationStatistics = new AnimationStatistics();
            }
            ++animationStatistics.count;
            if (bl) {
                ++animationStatistics.errCount;
            }
            animationStatistics.totalSteps += abstractAnimation.getCurrentAnimationStep();
            animationStatistics.totalTime += (abstractAnimation.isAnimating() ? AbstractWidget.framework.getMonotonicTime() : abstractAnimation.getEndTime()) - abstractAnimation.getStartTime();
        }

        public String getName() {
            return "AnimationStatistics";
        }

        public synchronized void dump(PrintStream printStream, String string) {
            Object object;
            Object object2;
            printStream.println("### Animation Statistics ###");
            printStream.println("\nCurrently Running Animations:");
            boolean bl = false;
            try {
                if (null != AnimationControllerMIB2High.this.actualAnimations) {
                    for (int i2 = 0; i2 < AnimationControllerMIB2High.this.actualAnimations.length; ++i2) {
                        object2 = AnimationControllerMIB2High.this.actualAnimations[i2];
                        if (null == object2 || object2.isEmpty()) continue;
                        object = (AbstractAnimation[])object2.toArray(new AbstractAnimation[object2.size()]);
                        bl = true;
                        printStream.println(new StringBuffer().append("Animations of type ").append(AnimationControllerMIB2High.this.getAnimationName(i2)).append("(").append(i2).append("):").toString());
                        for (int i3 = 0; i3 < ((Object)object).length; ++i3) {
                            this.dumpAnimationInfo(printStream, (AbstractAnimation)object[i3]);
                        }
                    }
                }
                if (!bl) {
                    printStream.println("### NONE ###");
                }
            }
            catch (Exception exception) {
                printStream.println("Failed to print current animations!");
                printStream.println(exception);
            }
            printStream.println("\nAnimation error history (last 20 records):");
            bl = false;
            Iterator iterator = this.animErrorHistory.iterator();
            while (iterator.hasNext()) {
                bl = true;
                this.dumpAnimationInfo(printStream, (AnimationInfo)iterator.next());
            }
            if (!bl) {
                printStream.println("### NONE ###");
            }
            printStream.println("\nGeneral Animation Statistics:");
            bl = false;
            for (int i4 = 0; i4 < this.statistics.length; ++i4) {
                object2 = this.statistics[i4];
                if (null == object2) continue;
                bl = true;
                object = new Buffer(100);
                ((Buffer)object).append("\tType: ").append(AnimationControllerMIB2High.this.getAnimationName(i4)).append('(').append(i4).append(')').append(", Count: ").append(((AnimationStatistics)object2).count).append(", Error Count: ").append(((AnimationStatistics)object2).errCount).append(", Error%: ").append(100.0f * ((float)((AnimationStatistics)object2).errCount / (float)((AnimationStatistics)object2).count)).append('%').append(", Average Steps: ").append((float)((AnimationStatistics)object2).totalSteps / (float)((AnimationStatistics)object2).count).append(", Average Time: ").append((float)((AnimationStatistics)object2).totalTime / (float)((AnimationStatistics)object2).count);
                printStream.println(object);
            }
            if (!bl) {
                printStream.println("### NONE ###");
            }
        }

        private void dumpAnimationInfo(PrintStream printStream, AnimationInfo animationInfo) {
            Buffer buffer = new Buffer(256);
            long l = animationInfo.getEndTime();
            long l2 = animationInfo.getStartTime();
            long l3 = animationInfo.getTotalTime();
            int n = animationInfo.getSteps();
            int n2 = animationInfo.getAnimationType();
            buffer.append("\tType: ").append(AnimationControllerMIB2High.this.getAnimationName(n2)).append('(').append(n2).append(')').append(", Start: ").append(l2).append(", Steps: ").append(n).append(", End: ").append(l).append(", Elapsed time: ").append(l3).append(", Planned duration: ").append(animationInfo.getPlannedTime()).append(", Updates/sec: ").append(animationInfo.getUpdatesPerSecond());
            if (animationInfo.isFinishedInError()) {
                buffer.append(", Exeption: ").append(animationInfo.getException());
            }
            printStream.println(buffer);
        }

        private void dumpAnimationInfo(PrintStream printStream, AbstractAnimation abstractAnimation) {
            Buffer buffer = new Buffer(256);
            long l = abstractAnimation.isAnimating() ? AbstractWidget.framework.getMonotonicTime() : abstractAnimation.getEndTime();
            long l2 = abstractAnimation.getStartTime();
            long l3 = l - l2;
            int n = abstractAnimation.getCurrentAnimationStep();
            buffer.append("\tType: ").append(AnimationControllerMIB2High.this.getAnimationName(abstractAnimation.getType())).append('(').append(abstractAnimation.getType()).append(')').append(", Start: ").append(l2).append(", Steps: ").append(n).append(", End: ").append(l).append(", Elapsed time: ").append(l3).append(", Planned duration: ").append(abstractAnimation.getPlannedDuration()).append(", Updates/sec: ").append((float)n / ((float)(l3 + (long)abstractAnimation.getTimerIntervall()) / 1000.0f));
            if (abstractAnimation.isAnimating()) {
                buffer.append(", Target: ").append(abstractAnimation.getTarget()).append(", Value: ").append(abstractAnimation.getValue()).append(", Progress: ").append(abstractAnimation.getProgress()).append(", Blocked: ").append(abstractAnimation.isBlocked());
            }
            printStream.println(buffer);
        }
    }
}

