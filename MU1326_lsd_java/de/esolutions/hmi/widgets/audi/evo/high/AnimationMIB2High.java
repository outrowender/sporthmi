/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.fwhmi.IDisplayManagerKombiControl;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IDisplayControllerWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationCurve;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationCurveDynamic;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationCurveFixedValues;
import de.esolutions.hmi.widgets.audi.base.animation.IAnimationCurve;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.evo.IAnimationTypesEvo;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationParametersEvoHigh;
import de.esolutions.hmi.widgets.audi.evo.high.IAnimationParametersMIB2;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import java.util.Iterator;
import java.util.List;

public class AnimationMIB2High
extends AbstractAnimation
implements AnimationListener,
IAnimationTypesEvo {
    private static final int MMI_COMBI_SYNC_TYPE_NONE = -1;
    private static final int MMI_COMBI_SYNC_TYPE_VIEW_SIZE_CHANGE = 1;
    private static final int MMI_COMBI_SYNC_TYPE_SELECTION_DRAWER_STATE_CHANGE = 2;
    private static final int MMI_COMBI_SYNC_TYPE_OPTION_DRAWER_STATE_CHANGE = 3;
    private static final int MMI_COMBI_SYNC_TYPE_SCREEN_CHANGE_STANDARD_FORWARD = 4;
    private static final int MMI_COMBI_SYNC_TYPE_REMOVE_POPUP = 8;
    private static final int MMI_COMBI_SYNC_TYPE_SHOW_POPUP = 9;
    private static final int MMI_COMBI_SYNC_TYPE_EXIT_VIEW_FADING = 10;
    private static final int MMI_COMBI_SYNC_TYPE_SCREEN_CHANGE_FADING_IN_PLACE = 11;
    private static final int MMI_COMBI_SYNC_TYPE_EXIT_VIEW_FADING_WITHOUT_VIEW_SIZE_CHANGE = 12;
    private static final int MMI_COMBI_SYNC_TYPE_FLAP_FADING_WITHOUT_VIEW_SIZE_CHANGE = 13;
    Screen oldScreen;
    Screen newScreen;
    DrawerController oldOptionDrawer;
    DrawerController newOptionDrawer;
    int[] computedAnimationInfo;

    public AnimationMIB2High(AbstractAnimationController abstractAnimationController) {
        super(abstractAnimationController);
    }

    public void startScreenChangeAnimation(int[] nArray, boolean bl, IScreenData iScreenData, IScreenData iScreenData2) {
        try {
            this.initializeScreenChange(nArray, bl, iScreenData, iScreenData2);
            if (this.needsBackgroundFading()) {
                this.prepareBackgroundFading();
            }
            switch (this.type) {
                case 23: {
                    this.startFakeAnimation();
                    break;
                }
                case 25: {
                    this.startScreenChange(4);
                    break;
                }
                case 24: {
                    this.startScreenChange(4);
                    break;
                }
                case 28: {
                    this.startScreenChange(16);
                    break;
                }
                case 27: {
                    this.startScreenChange(8);
                    break;
                }
                case 26: {
                    this.startScreenChange(28);
                    break;
                }
                case 22: {
                    this.startScreenChange(4);
                    break;
                }
                default: {
                    this.type = 22;
                    this.startScreenChange(4);
                    break;
                }
            }
        }
        catch (RuntimeException runtimeException) {
            this.logAnimation.log(1000, "AnimationMIB2High#startScreenChangeAnimation exception occured: %1 trying to start fakeanimation", (Throwable)runtimeException);
            this.type = 23;
            this.fadeIn = bl;
            this.animationStart = AbstractWidget.framework.getMonotonicTime();
            this.startFakeAnimation();
        }
    }

    private void initializeScreenChange(int[] nArray, boolean bl, IScreenData iScreenData, IScreenData iScreenData2) {
        Screen screen = null;
        if (iScreenData != null) {
            this.oldScreen = iScreenData.getScreen();
            this.oldOptionDrawer = this.getOptionDrawer(iScreenData.getOptionsDrawerID());
        }
        if (iScreenData2 != null) {
            this.newScreen = iScreenData2.getScreen();
            this.newOptionDrawer = this.getOptionDrawer(iScreenData2.getOptionsDrawerID());
        }
        this.computedAnimationInfo = nArray;
        screen = bl ? this.newScreen : this.oldScreen;
        if (screen == null || ((AbstractScreenWidget)screen).getInitContext() == null) {
            this.logAnimation.log(10000, "AnimationMIB2High#startScreenChange animation screen not initialized, trying to work with current connected screen from controller");
            screen = this.controller.getConnectedMainScreen();
        }
        if (screen != this.controller.getConnectedMainScreen()) {
            this.logAnimation.log(10000, "AnimationMIB2High#startScreenChange screen != connectedMainScreen should not happen, work with connected main screen");
            screen = this.controller.getConnectedMainScreen();
        }
        this.animatedScreen = screen;
        this.fadeIn = bl;
        this.type = bl ? nArray[2] : nArray[0];
        if (!this.controller.isScreenChangeType(this.type)) {
            this.logAnimation.log(100000, "AnimationMIB2High#startScreenChangeAnimation type: %1 is not a valid screenChangeType, using fake animation instead", (long)this.type);
            this.type = 23;
        }
        this.animationStart = AbstractWidget.framework.getMonotonicTime();
    }

    public void animationStarted(int n, int n2) {
    }

    protected void prepareBackgroundFading() {
        AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)this.animatedScreen;
        IDisplayControllerWidget iDisplayControllerWidget = abstractScreenWidget.getDisplayController();
        if (iDisplayControllerWidget != null) {
            if (this.fadeIn) {
                iDisplayControllerWidget.setOpacityOnBackgroundLayers(0.0f, true);
            }
        } else {
            this.logAnimation.log(100000, "AnimationMIB2High#prepareBackgroundFading no controller at screen!");
        }
    }

    protected boolean needsBackgroundFading() {
        int n = 1;
        if (this.fadeIn) {
            n = 3;
        }
        return (this.computedAnimationInfo[n] & 1) > 0;
    }

    protected void startFakeAnimation() {
        this.startDynamicAnimation(40.0f, 40.0f, 23, this.fadeIn, (AbstractWidget)((Object)this.animatedScreen));
    }

    protected void startScreenChange(int n) {
        if (IWidgetLogChannel.logScreenChange.isInfo()) {
            IWidgetLogChannel.logScreenChange.log(1000000, "AnimationMIB2High#startScreenChange target=%1: %2", (Object)ScreenChangeAnimationItem.Helper.getText(n));
        }
        boolean bl = (this.computedAnimationInfo[1] & 8) > 0;
        boolean bl2 = (this.computedAnimationInfo[1] & 4) > 0;
        boolean bl3 = (this.computedAnimationInfo[1] & 2) == 0;
        n |= this.fadeIn ? 1 : 2;
        AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)(this.fadeIn ? this.newScreen : this.oldScreen);
        this.setScreenChangeTargets(abstractScreenWidget, n |= bl3 ? 32 : 64, bl, bl2);
        this.controller.getTerminal().getDrawerFocusManager().setScreenChangeTarget(n);
        this.startDynamicAnimation(0.0f, 1.0f, this.type, this.fadeIn, (AbstractWidget)((Object)this.animatedScreen));
    }

    private DrawerController getOptionDrawer(long l) {
        return (DrawerController)this.controller.getTerminal().getDrawerManager().getOptionDrawer(l);
    }

    private void setScreenChangeTargets(AbstractScreenWidget abstractScreenWidget, int n, boolean bl, boolean bl2) {
        ScreenChangeAnimationItem screenChangeAnimationItem;
        ScreenMainArea screenMainArea;
        ScreenMainArea screenMainArea2;
        ScreenMainArea screenMainArea3 = abstractScreenWidget.getMainArea();
        if (screenMainArea3 != null) {
            screenMainArea3.setScreenChangeTarget(n);
        }
        if ((screenMainArea2 = abstractScreenWidget.getTitleArea()) != null) {
            screenMainArea2.setScreenChangeTarget(n);
        }
        List list = abstractScreenWidget.getSpecialAreas();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            screenMainArea = (ScreenMainArea)iterator.next();
            screenMainArea.setScreenChangeTarget(n);
        }
        ScreenMainArea screenMainArea4 = screenMainArea = this.fadeIn ? this.newOptionDrawer : this.oldOptionDrawer;
        if (screenMainArea != null) {
            boolean bl3 = ((ScreenWidgetEVO)abstractScreenWidget).isOptionDrawerOpenedDuringScreenChange();
            if (bl2 && !bl3) {
                ((DrawerController)screenMainArea).setScreenChangeTarget(n);
            } else {
                ((DrawerController)screenMainArea).setScreenChangeTarget(24);
                if (bl3) {
                    this.controller.getTerminal().getDrawerFocusManager().setOptionDrawerOpenedDuringScreenChange(true);
                    ((ScreenWidgetEVO)abstractScreenWidget).setOptionDrawerOpenedDuringScreenChange(false);
                }
            }
        }
        if ((screenChangeAnimationItem = (ScreenChangeAnimationItem)this.controller.getTerminal().getDrawerFocusManager().getSelectionDrawer()) != null) {
            if (bl) {
                screenChangeAnimationItem.setScreenChangeTarget(n);
            } else {
                screenChangeAnimationItem.setScreenChangeTarget(24);
            }
        }
    }

    protected void startBackgroundFading() {
        this.prepareBackgroundFading();
        if (this.fadeIn) {
            this.startDynamicAnimation(0.0f, 100.0f, this.type, this.fadeIn, (AbstractWidget)((Object)this.animatedScreen));
        } else {
            this.startDynamicAnimation(100.0f, 0.0f, this.type, this.fadeIn, (AbstractWidget)((Object)this.animatedScreen));
        }
    }

    protected void doBackgroundFading() {
        float f2;
        float f3 = f2 = this.getProgress();
        if (!this.fadeIn) {
            float f4 = 1.0f - f2;
            f3 = f4 * f4 * f4;
        } else {
            f3 = f2 * f2;
        }
        IDisplayControllerWidget iDisplayControllerWidget = ((AbstractScreenWidget)this.animatedScreen).getDisplayController();
        if (iDisplayControllerWidget != null) {
            boolean bl = true;
            if (!this.fadeIn) {
                bl = false;
            }
            iDisplayControllerWidget.setOpacityOnBackgroundLayers(f3, bl);
        }
    }

    protected void doSpecializedAnimation() {
        switch (this.type) {
            case 22: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: {
                this.doStandardScreenChange();
                break;
            }
            case 1: 
            case 31: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 57: 
            case 58: 
            case 59: 
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: 
            case 76: 
            case 77: 
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 83: 
            case 84: 
            case 85: 
            case 86: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: 
            case 96: 
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: 
            case 102: 
            case 103: 
            case 104: 
            case 105: 
            case 106: 
            case 108: {
                this.animateListener();
                break;
            }
            default: {
                this.logAnimation.log(10000000, "AnimationMIB2High#doSpecializedAnimation nothing special done for tpye: %1", (long)this.type);
            }
        }
    }

    private void doStandardScreenChange() {
        float f2 = this.getValue();
        if (this.needsBackgroundFading()) {
            this.doBackgroundFading();
        }
        this.controller.getTerminal().getDrawerFocusManager().setScreenChangeProgress(f2);
    }

    private void doStandardScreenChangeFinished() {
        if (this.fadeIn) {
            Object object;
            AbstractWidget.hmiService.getEventDispatcherAdmin().unBlockHardkeys();
            AbstractWidget.hmiService.getEventDispatcherAdmin().unBlockScreenChangeDisturbingEvents();
            this.manageRepaint(true);
            AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)this.oldScreen;
            ScreenMainArea screenMainArea = abstractScreenWidget.getMainArea();
            ScreenMainArea screenMainArea2 = abstractScreenWidget.getTitleArea();
            List list = abstractScreenWidget.getSpecialAreas();
            if (screenMainArea != null) {
                screenMainArea.screenChangeFinished();
            }
            if (screenMainArea2 != null) {
                screenMainArea2.screenChangeFinished();
            }
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                object = (ScreenChangeAnimationItem)iterator.next();
                object.screenChangeFinished();
            }
            object = (AbstractScreenWidget)this.newScreen;
            ScreenMainArea screenMainArea3 = ((AbstractScreenWidget)object).getMainArea();
            ScreenMainArea screenMainArea4 = ((AbstractScreenWidget)object).getTitleArea();
            List list2 = ((AbstractScreenWidget)object).getSpecialAreas();
            if (screenMainArea3 != null) {
                screenMainArea3.screenChangeFinished();
            }
            if (screenMainArea4 != null) {
                screenMainArea4.screenChangeFinished();
            }
            Iterator iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                ScreenChangeAnimationItem screenChangeAnimationItem = (ScreenChangeAnimationItem)iterator2.next();
                screenChangeAnimationItem.screenChangeFinished();
            }
            this.controller.getTerminal().getDrawerFocusManager().screenChangeFinished();
        }
    }

    protected void stopSpecializedAnimation() {
        if (this.controller.isScreenChangeType(this.type) && this.fadeIn) {
            AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)this.animatedScreen;
            IDisplayControllerWidget iDisplayControllerWidget = abstractScreenWidget.getDisplayController();
            if (iDisplayControllerWidget != null) {
                iDisplayControllerWidget.setOpacityOnBackgroundLayers(1.0f, true);
            }
            if (abstractScreenWidget.getScreenType() == 1) {
                this.logAnimation.log(10000000, "AnimationMIB2High#animationFinished: Map animation finished, notifying Startup.");
                AbstractWidget.framework.getStartupMgr().triggerMapAvailable();
            }
        }
        switch (this.type) {
            case 61: {
                boolean bl;
                IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2High#stopSpecializedAnimation stop exit view fading without view size, fadeIn: %1", this.fadeIn);
                if (!((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).isKDKVisible(this.controller.getTerminal().getTerminalID())) break;
                boolean bl2 = bl = this.controller.getTerminal().getViewSizeManager().getCurrentViewSize() == 2;
                if (!this.fadeIn) {
                    this.setKDKVisible(false, bl, false);
                    ((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).setKDKVisible(-1, this.controller.getTerminal().getTerminalID());
                    break;
                }
                this.setKDKVisible(true, bl, false);
                break;
            }
            case 62: {
                boolean bl;
                IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2High#stopSpecializedAnimation stop flap fading without view size, fadeIn: %1", this.fadeIn);
                boolean bl3 = bl = this.controller.getTerminal().getViewSizeManager().getCurrentViewSize() == 2;
                if (this.fadeIn) break;
                this.setKDKVisible(false, bl, false);
                ((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).setKDKVisible(-1, this.controller.getTerminal().getTerminalID());
                break;
            }
            case 56: {
                IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2High#stopSpecializedAnimation stop exit view fading with view size change, fadeIn: %1", this.fadeIn);
                if (!this.fadeIn || !((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).isKDKVisible(this.controller.getTerminal().getTerminalID())) break;
                boolean bl = this.controller.getTerminal().getViewSizeManager().getCurrentViewSize() == 2;
                this.setKDKVisible(true, bl, true);
                break;
            }
            case 57: {
                int n = ((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).getVisibleKDK(0);
                if (n == -1) break;
                this.setKDKVisible(false, this.fadeIn, true);
                break;
            }
            case 22: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: {
                this.doStandardScreenChangeFinished();
                break;
            }
            case 23: {
                break;
            }
            case 52: 
            case 53: {
                if (this.controller.getTerminal().getDrawerFocusManager().getDrawerState() != 16) break;
                this.controller.setDrawerWasClosed(false);
                break;
            }
            default: {
                this.logAnimation.log(10000000, "AnimationMIB2High#stopSpecializedAnimation nothing special to do for type: %1", (long)this.type);
            }
        }
    }

    protected void doErrorHandlingForScreenChange() {
        this.animationCurve.setFinished(true);
        this.doSpecializedAnimation();
        this.stopSpecializedAnimation();
    }

    protected boolean startSpezializedAnimation() {
        switch (this.type) {
            case 61: {
                IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2High#startSpecializedAnimation start exit view fading without view size, fadeIn: %1", this.fadeIn);
                if (this.fadeIn && ((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).isKDKVisible(this.controller.getTerminal().getTerminalID())) {
                    boolean bl = this.controller.getTerminal().getViewSizeManager().getCurrentViewSize() == 2;
                    this.setKDKVisible(true, bl, true);
                }
                return true;
            }
            case 56: {
                this.setKDKVisible(true, this.fadeIn, false);
                return true;
            }
            case 57: {
                int n = ((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).getVisibleKDK(0);
                if (n != -1) {
                    this.setKDKVisible(false, this.fadeIn, true);
                }
                return true;
            }
        }
        return true;
    }

    private void setKDKVisible(boolean bl, boolean bl2, boolean bl3) {
        int n;
        IDisplayManagerKombiControl iDisplayManagerKombiControl = this.getDisplayManager();
        if (iDisplayManagerKombiControl == null) {
            IWidgetLogChannel.logKDK.log(100000, "AnimationMIB2High#setKDKvisible failed to retrieve the display manager; ignoring the invocation");
            return;
        }
        int n2 = iDisplayManagerKombiControl.getVisibleKDK(0);
        Layout layout = this.getLayout();
        if (bl3 && n2 != -1 && layout != null) {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            if (bl2) {
                n7 = layout.getIntegerConstant(118);
                n = layout.getIntegerConstant(119);
                n6 = layout.getIntegerConstant(120);
                n5 = layout.getIntegerConstant(121);
                n4 = layout.getIntegerConstant(60);
                n3 = layout.getIntegerConstant(61);
            } else {
                n7 = layout.getIntegerConstant(122);
                n = layout.getIntegerConstant(123);
                n6 = layout.getIntegerConstant(124);
                n5 = layout.getIntegerConstant(125);
                n4 = layout.getIntegerConstant(58);
                n3 = layout.getIntegerConstant(59);
            }
            IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2High#setKDKvisible setCropping 1 sourceX: %1, sourceY: %2, cropWidth: %3, cropHeight: %4", (Object)String.valueOf(n7), (Object)String.valueOf(n), (Object)String.valueOf(n6), (Object)String.valueOf(n5));
            IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2High#setKDKvisible setCropping 2 targetX: %1, targetY: %2", (long)n4, (long)n3);
            iDisplayManagerKombiControl.setCropping(n2, 0, n7, n, n6, n5, n4, n3, n6, n5);
        }
        if (bl) {
            IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2High#setKDKvisible setting opacity of kdk to opaque");
            if (n2 != -1) {
                ((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).setKDKOpacity(this.controller.getTerminal().getTerminalID(), 100);
                int[] nArray = AbstractWidget.hmiService.getDisplayManager().getPosition(n2, 0);
                n = 0;
                if (nArray[0] == this.controller.getTerminal().getLayout().getIntegerConstant(60)) {
                    n = 1;
                }
                ((EALManager)this.controller.getTerminal().getGUIManager()).showKDKBackground(this.getKDKBackgroundImage(n != 0), nArray[0], nArray[1], this);
            }
        } else {
            IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2High#setKDKvisible setting opacity of kdk to transparent");
            if (n2 != -1) {
                ((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).setKDKOpacity(this.controller.getTerminal().getTerminalID(), 0);
            }
            ((EALManager)this.controller.getTerminal().getGUIManager()).hideKDKBackground();
        }
    }

    private IDisplayManagerKombiControl getDisplayManager() {
        IDisplayManager iDisplayManager;
        IDisplayManagerKombiControl iDisplayManagerKombiControl = null;
        if (AbstractWidget.hmiService != null && (iDisplayManager = AbstractWidget.hmiService.getDisplayManager()) instanceof IDisplayManagerKombiControl) {
            iDisplayManagerKombiControl = (IDisplayManagerKombiControl)iDisplayManager;
        }
        return iDisplayManagerKombiControl;
    }

    private Layout getLayout() {
        HMITerminalImpl hMITerminalImpl;
        Layout layout = null;
        if (this.controller != null && (hMITerminalImpl = this.controller.getTerminal()) != null) {
            layout = hMITerminalImpl.getLayout();
        }
        return layout;
    }

    protected int getKDKBackgroundImage(boolean bl) {
        return HMIImageConstantsSystem.kdk_background_default;
    }

    protected int getMinimumDelay() {
        return 20;
    }

    protected int getMinimumTimerIntervall() {
        if (AbstractWidget.isVariantHigh()) {
            return 1;
        }
        return 20;
    }

    public Screen getOldScreen() {
        return this.oldScreen;
    }

    public void setOldScreen(Screen screen) {
        this.oldScreen = screen;
    }

    public Screen getNewScreen() {
        return this.newScreen;
    }

    public void setNewScreen(Screen screen) {
        this.newScreen = screen;
    }

    protected int getMenuClippingHeight() {
        return 540;
    }

    protected boolean repaintAtFinish() {
        return this.type != 23;
    }

    public int getCombiSyncType(int n) {
        if (n == 0) {
            return this.getCombiSyncTypeV0();
        }
        switch (this.type) {
            case 57: {
                return 1;
            }
            case 22: {
                return 4;
            }
            case 25: {
                return 9;
            }
            case 24: {
                return 8;
            }
            case 52: {
                return 2;
            }
            case 53: {
                return 3;
            }
            case 56: {
                return 10;
            }
            case 28: {
                return 11;
            }
            case 61: {
                return 12;
            }
            case 62: {
                return 13;
            }
        }
        return -1;
    }

    private int getCombiSyncTypeV0() {
        if (this.type == 22) {
            return 17;
        }
        if (this.type == 57) {
            return 63;
        }
        return -1;
    }

    protected IAnimationCurve createAnimationCurve() {
        AbstractAnimationCurve abstractAnimationCurve;
        IAnimationParametersMIB2 iAnimationParametersMIB2 = this.getAnimationParameters();
        float[] fArray = iAnimationParametersMIB2.getAnimationParameters(this.type, -1, false);
        float[] fArray2 = iAnimationParametersMIB2.getFixedAnimationValues(this.type, -1, false, this.fadeIn);
        if (this.plannedDuration > 0 && fArray != null) {
            fArray[3] = this.plannedDuration;
            fArray[4] = this.plannedDuration + 100;
        }
        if (this.type == 28 && this.fadeIn) {
            fArray[3] = 400.0f;
            fArray[4] = 450.0f;
        }
        if (fArray2 != null || this.isEndlessAnimation()) {
            abstractAnimationCurve = new AnimationCurveFixedValues(this.type, 1, this.start, this.target, this.renderEachStep(), this.logAnimation, fArray, fArray2, this.isEndlessAnimation(), this.getMinimumTimerIntervall());
            if (this.isEndlessAnimation()) {
                abstractAnimationCurve.setTimerIntervall(this.endlessTimerIntervall);
            }
            if (this.controller.isScreenChangeType(this.type)) {
                ((AnimationCurveFixedValues)abstractAnimationCurve).setFastRollBack(true);
            }
        } else {
            abstractAnimationCurve = new AnimationCurveDynamic(this.type, 1, this.start, this.target, this.renderEachStep(), this.logAnimation, fArray, this.getMinimumTimerIntervall());
        }
        return abstractAnimationCurve;
    }

    protected IAnimationParametersMIB2 getAnimationParameters() {
        return AnimationParametersEvoHigh.getAnimationParametersEvoHigh();
    }

    public boolean isAnimationNeeded(int n) {
        if (n == 56) {
            return ((IDisplayManagerKombiControl)AbstractWidget.hmiService.getDisplayManager()).isKDKVisible(this.controller.getTerminal().getTerminalID());
        }
        return super.isAnimationNeeded(n);
    }

    public void animationFinished(int n, int n2) {
    }
}

