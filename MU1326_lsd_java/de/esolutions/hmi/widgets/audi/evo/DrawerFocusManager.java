/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IMMICombiAnimationSyncer;
import de.audi.atip.mmicombi.IMMICombiDrawerStateSync;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.timer.WatchDog;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IDrawerListener;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IFocusedPropertyProvider;
import de.audi.tghu.hmi.evo.IGEMKeyHandler;
import de.audi.tghu.hmi.evo.ILongpressKeyHandler;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.audi.tghu.hmi.evo.IPhoneKeyHandler;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.audi.tghu.hmi.evo.ScreenAreaFocus;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.WidgetPersistenceManager;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.DisplayControllerEvo;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManagerEvo;
import de.esolutions.hmi.widgets.audi.evo.LockingManager;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DrawerFocusManager
implements IDrawerFocusManagerEvo,
IWidgetLogChannel {
    private static final LogChannel lc = logDrawerFocusMain;
    private static final LogChannel lcD = logDrawerFocus;
    private static final int PERSISTENCE_DRAWER_STATE_OPEN = 1;
    private static final int PERSISTENCE_DRAWER_STATE_CLOSE = 2;
    private static final int PERSISTENCE_DRAWER_STATE_UNDEFINED = 3;
    private int drawerCloseRequest = 0;
    private WatchDog drawerClosingWatchdog;
    private static final int DRAWER_CLOSING_TIMEOUT = 8000;
    private static final int NOT_ALLOWED_WHILE_DRIVING_POPUP = 191;
    private boolean partialPopupDrawerOpen = false;
    private int state;
    private int targetState = this.state = 16;
    private IPartialPopupManagerEvo partialPopupManager;
    private IPresetInputHandler presetPopupHandler;
    private IPhoneKeyHandler phoneKeyHandler;
    private ILongpressKeyHandler longpressKeyHandler;
    private IGEMKeyHandler gemKeyHandler;
    private AbstractScreenWidget screen;
    private IScreenData screenData;
    private IDrawerControllerEvo selectionDrawer;
    private IDrawerControllerEvo optionDrawer;
    private IDrawerControllerEvo entertainmentDrawer;
    private IDrawerControllerEvo previousSelectionDrawer;
    private IDrawerControllerEvo previousOptionDrawer;
    private IDrawerControllerEvo lastValidOptionDrawer;
    private IMMICombiDrawerStateSync mmiCombiDrawerStateSync;
    private boolean disclaimerActive = false;
    private IFocusedPropertyProvider focusPropertyProvider;
    private boolean ignoreTouchEvents = false;
    private HMITerminalImpl terminal = null;
    private int viewSize = 2;
    private boolean usePersistence = false;
    private int drawerStateWrittenToChoiceModel = -1;
    private final DrawerAnimationManagerEvo drawerAnimationManager;
    private Map drawerListeners = new HashMap();
    private Runnable popupDrawerCloseAction;
    private boolean isScreenChange;
    private boolean optionDrawerOpenedDuringScreenChange;
    private boolean earlyEntertainmentVisible = true;
    private boolean lockingActive;
    private boolean menuMoveModeActive;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IMMICombiDrawerStateSync;
    static /* synthetic */ Class class$de$audi$tghu$hmi$evo$IDrawerFocusManagerEvo;

    public DrawerFocusManager(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
        this.drawerAnimationManager = new DrawerAnimationManagerEvo(hMITerminalImpl);
        LockingManager.registerListener(this);
    }

    private boolean requestButtonDrawerState(int n) {
        int n2;
        this.setUsePersistence(false);
        if (n != 4 && n != 8 && n != 32 && n != 16) {
            lc.log(10000, "DrawerFocusManager#requestButtonDrawerState Wrong state number %1", (long)n);
            return false;
        }
        if (this.state == 16 && n != 16 && this.getDrawer(n) == null) {
            lc.log(10000000, "DrawerFocusManager#requestButtonDrawerState No drawer for state available, do not consume event, buttonTargetState=%1", (long)n);
            return false;
        }
        int n3 = 16;
        if (this.state == 16) {
            if (this.screen != null && this.screen.getDefaultSKKeyCode() == 0 && (n2 = this.requestDrawerState(n)) != 0) {
                n3 = n;
            }
        } else {
            if (n == 4 && this.state == 4 && this.isSubringOfSelectionDrawerOpened()) {
                lc.log(1000000, "DrawerFocusManager#requestButtonDrawerState Closing subring in selection drawer");
                return this.closeSubringOfSelectionDrawer();
            }
            this.requestDrawerState(16);
        }
        if (this.screenData != null) {
            if (n3 == 8) {
                lcD.log(10000000, "DrawerFocusManager#requestButtonDrawerState set persistent option drawer state to opened state, screen=%1", (Object)this.screenData);
                n2 = 1;
            } else {
                lcD.log(10000000, "DrawerFocusManager#requestButtonDrawerState set persistent option drawer state to closed state, screen=%1", (Object)this.screenData);
                n2 = 0;
            }
            Comparable comparable = this.getFocusedIndexOfDrawer((DrawerController)this.getDrawer(8));
            this.setPersistenceOptionDrawerState(this.screenData, n2, comparable);
        }
        return true;
    }

    private void updateOptionMenuInitialFocus() {
        DrawerController drawerController = (DrawerController)this.optionDrawer;
        if (drawerController.getDrawerMain() instanceof ContainerController) {
            ((ContainerController)drawerController.getDrawerMain()).updateMenuInitialFocus();
        }
    }

    private boolean closeSubringOfSelectionDrawer() {
        SelectionMenuController selectionMenuController = this.getSelectionMenuController();
        if (selectionMenuController == null) {
            lc.log(10000000, "DrawerFocusManager#closeSubringOfSelectionDrawer SelectionMenuController not found");
            return false;
        }
        return selectionMenuController.closeSubList(true);
    }

    private boolean isSubringOfSelectionDrawerOpened() {
        SelectionMenuController selectionMenuController = this.getSelectionMenuController();
        if (selectionMenuController == null) {
            lcD.log(10000000, "DrawerFocusManager#isSubringOfSelectionDrawerOpened SelectionMenuController not found");
            return false;
        }
        return selectionMenuController.isSubListOpened();
    }

    private SelectionMenuController getSelectionMenuController() {
        if (this.selectionDrawer == null) {
            lcD.log(10000000, "DrawerFocusManager#getSelectionMenuController No selectionDrawer available");
            return null;
        }
        if (!(this.selectionDrawer instanceof DrawerController)) {
            lcD.log(10000000, "DrawerFocusManager#getSelectionMenuController selectionDrawer not a DrawerController");
            return null;
        }
        DrawerController drawerController = (DrawerController)this.selectionDrawer;
        DrawerMain drawerMain = drawerController.getDrawerMain();
        if (drawerMain == null) {
            lcD.log(10000000, "DrawerFocusManager#getSelectionMenuController DrawerController has no main part");
            return null;
        }
        if (!(drawerMain instanceof SelectionMenuController)) {
            lcD.log(10000000, "DrawerFocusManager#getSelectionMenuController main part of DrawerController is not a SelectionMenuController");
            return null;
        }
        return (SelectionMenuController)drawerMain;
    }

    public Comparable getFocusedIndexOfDrawer(DrawerController drawerController) {
        if (drawerController == null) {
            return null;
        }
        if (drawerController.getDrawerMain() == null) {
            return null;
        }
        ContainerController containerController = (ContainerController)drawerController.getDrawerMain();
        MenuItemIndex menuItemIndex = null;
        List list = containerController.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (!(list.get(i2) instanceof MenuController)) continue;
            menuItemIndex = ((MenuController)list.get(i2)).getFocusedIndex();
            break;
        }
        return menuItemIndex;
    }

    private void setFocusedIndexOfDrawer(DrawerController drawerController, MenuItemIndex menuItemIndex) {
        ContainerController containerController;
        lcD.log(10000000, "DrawerFocusManager#setFocusedIndexOfDrawer %1", (Object)menuItemIndex);
        if (drawerController != null && (containerController = (ContainerController)drawerController.getDrawerMain()) != null) {
            List list = containerController.getChildren();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                if (!(list.get(i2) instanceof MenuController)) continue;
                ((MenuController)list.get(i2)).focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
                break;
            }
        }
    }

    public boolean requestDrawerState(int n) {
        lc.log(1000000, "DrawerFocusManager#requestDrawerState Requesting state %1", (Object)DrawerFocusManager.getStateName(n));
        this.updateDrawerContent(n);
        if (!this.canShowState(n)) {
            return false;
        }
        if (this.mmiCombiDrawerStateSync == null) {
            this.setDrawerState(n, true);
            return true;
        }
        if (this.mmiCombiDrawerStateSync.requestDrawerState(n)) {
            this.setDrawerState(n, true);
        }
        return true;
    }

    private boolean canShowState(int n) {
        if (this.state == n) {
            return true;
        }
        if (n == 16) {
            IDrawerControllerEvo iDrawerControllerEvo = this.getDrawer(this.state);
            if (iDrawerControllerEvo == null) {
                return true;
            }
            boolean bl = iDrawerControllerEvo.canClose();
            if (!bl) {
                lc.log(1000000, "DrawerFocusManager#canShowState opened drawer in state %1 prevents closing itself", (long)this.state);
            }
            return bl;
        }
        if (n == 8 && this.isDisclaimerActive()) {
            lc.log(1000000, "DrawerFocusManager#canShowState disclaimer is active in state %1", (long)this.state);
            return false;
        }
        if (n == 8 && this.menuMoveModeActive) {
            lc.log(1000000, "DrawerFocusManager#canShowState moveModeActive do not open option drawer");
            return false;
        }
        IDrawerControllerEvo iDrawerControllerEvo = this.getDrawer(n);
        if (iDrawerControllerEvo == null) {
            lc.log(1000000, "DrawerFocusManager#canShowState drawer for targetState %1 not available ", (long)n);
            return false;
        }
        boolean bl = iDrawerControllerEvo.canOpen();
        if (!bl) {
            lc.log(1000000, "DrawerFocusManager#canShowState closed drawer for targetState %1 prevents opening itself", (long)n);
        }
        return bl;
    }

    public void setMenuMoveModeActive(boolean bl) {
        this.menuMoveModeActive = bl;
    }

    private void closeDrawer(int n) {
        IDrawerControllerEvo iDrawerControllerEvo = this.getDrawer(n);
        if (iDrawerControllerEvo == null) {
            return;
        }
        if (n == 32) {
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "DrawerFocusManager#closeDrawer try to close EntertainmentDrawer");
            iDrawerControllerEvo.setDisplayDrawerState(1, iDrawerControllerEvo.isConnected(), true);
        }
        this.cancelIdleTimer(iDrawerControllerEvo);
    }

    public void closePopupDrawer() {
        if (!this.partialPopupDrawerOpen) {
            return;
        }
        IPartialPopupManager iPartialPopupManager = this.getPartialPopupManager();
        if (iPartialPopupManager instanceof AbstractPartialPopupManager) {
            ((AbstractPartialPopupManager)iPartialPopupManager).closePopupDrawer();
        }
        this.partialPopupDrawerOpen = false;
    }

    private IDrawerControllerEvo getDrawer(int n) {
        if (n == 4) {
            return this.selectionDrawer;
        }
        if (n == 32) {
            return this.entertainmentDrawer;
        }
        if (n == 8) {
            return this.optionDrawer;
        }
        return null;
    }

    public void setPartialPopupManager(IPartialPopupManager iPartialPopupManager) {
        this.partialPopupManager = (IPartialPopupManagerEvo)iPartialPopupManager;
    }

    public IPartialPopupManager getPartialPopupManager() {
        return this.partialPopupManager;
    }

    public void setPresetPopupHandler(IPresetInputHandler iPresetInputHandler) {
        this.presetPopupHandler = iPresetInputHandler;
    }

    public IPresetInputHandler getPresetPopupHandler() {
        return this.presetPopupHandler;
    }

    public void setPhoneKeyHandler(IPhoneKeyHandler iPhoneKeyHandler) {
        this.phoneKeyHandler = iPhoneKeyHandler;
    }

    public void setLongpressKeyHandler(ILongpressKeyHandler iLongpressKeyHandler) {
        this.longpressKeyHandler = iLongpressKeyHandler;
    }

    public IPhoneKeyHandler getPhoneKeyHandler() {
        return this.phoneKeyHandler;
    }

    public ILongpressKeyHandler getLongpressKeyHandler() {
        return this.longpressKeyHandler;
    }

    public void setGEMKeyHandler(IGEMKeyHandler iGEMKeyHandler) {
        this.gemKeyHandler = iGEMKeyHandler;
    }

    public void keyPressed(KeyEvent keyEvent) {
        ScreenAreaFocus screenAreaFocus;
        int n = keyEvent.getKeyCode();
        if (this.screen instanceof ScreenWidgetEVO && ((ScreenWidgetEVO)this.screen).doesHKFilterContainsKey(n)) {
            keyEvent.setConsumed(true);
            keyEvent.setIgnorePopupRemoval(true);
            return;
        }
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.keyPressed(keyEvent);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1 consumed by presetPopupHandler", (Object)keyEvent);
                return;
            }
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.keyPressed(keyEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)keyEvent);
                this.doCheckedRepaint(keyEvent);
                return;
            }
            this.partialPopupManager.setFocusedLayer(2);
            this.partialPopupManager.keyPressed(keyEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1 consumed by popup drawer", (Object)keyEvent);
                this.doCheckedRepaint(keyEvent);
                return;
            }
        }
        if (DrawerFocusManager.isPTTKey(n)) {
            if (this.state == 4 || this.state == 8) {
                if (this.mmiCombiDrawerStateSync != null && this.mmiCombiDrawerStateSync.getCurrentFocus() != 2) {
                    lc.log(1000000, "DrawerFocusManager#keyPressed ptt -> not closing side drawers because focus is not hmi");
                } else {
                    lc.log(1000000, "DrawerFocusManager#keyPressed ptt -> closing selection or option drawer");
                    this.requestDrawerState(16);
                }
            }
            return;
        }
        if (this.isMFLPhoneKey(n)) {
            if (this.isG24MMIKombi()) {
                this.phoneKeyHandler.handleMFLPhoneKeyPressed();
            } else {
                lc.log(1000000, "DrawerFocusManager#keyPressed MFL Phonekey pressed - but no G24 system - ignore press event");
                return;
            }
        }
        if (this.isAllInTouchVirtualKey(n)) {
            this.ignoreTouchEvents = true;
        }
        if (this.state != 32 && this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.keyPressed(keyEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)keyEvent);
                this.doCheckedRepaint(keyEvent);
                return;
            }
        }
        if (KeyEvent.isAppChangeHardkey(n)) {
            this.handleAppChangeHardKey(keyEvent);
            return;
        }
        if (this.state != 16 && this.isKeyCodeForSelectionDrawer(n)) {
            if (this.gemKeyHandler != null) {
                this.gemKeyHandler.keyPressed(keyEvent);
                return;
            }
            if (this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1. don't open selection menu, because main area is locked", (Object)keyEvent);
            } else if (this.requestButtonDrawerState(4)) {
                keyEvent.consume();
                return;
            }
            if (!this.screen.isDisableLeftBack()) {
                this.runSDSAction(0);
                return;
            }
        }
        if (this.state != 16 && this.isKeyCodeForOptionDrawer(n)) {
            if (this.gemKeyHandler != null) {
                this.gemKeyHandler.keyPressed(keyEvent);
                return;
            }
            if (this.isSmallStageWithNotFocusableScreen()) {
                this.requestLargeViewSize(8);
                keyEvent.consume();
                return;
            }
            if (this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1. don't open option menu, because main area is locked", (Object)keyEvent);
            } else {
                this.requestButtonDrawerState(8);
                keyEvent.consume();
                return;
            }
        }
        if (this.isSmallStageWithNotFocusableScreen()) {
            if (n != 58 && n != 14 && n != 13 && n != 19) {
                if (this.screen instanceof ScreenWidgetEVO && ((ScreenWidgetEVO)this.screen).isHMIScreen()) {
                    this.requestLargeViewSize(8);
                }
                keyEvent.consume();
            }
            return;
        }
        ScreenAreaFocus screenAreaFocus2 = this.getFocusedDrawer();
        if (screenAreaFocus2 != null) {
            if (this.state == 8 && this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1 not sent to current focused drawer, because drawer is locked", (Object)keyEvent);
            } else {
                screenAreaFocus2.keyPressed(keyEvent);
            }
            this.cancelAllIdleTimers();
            if (n == 15 && !keyEvent.isConsumed()) {
                this.handleBackKey(keyEvent);
            }
        }
        if (this.partialPopupManager != null && !keyEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.keyPressed(keyEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)keyEvent);
                this.doCheckedRepaint(keyEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1 not sent to current focused main area, because main area is locked", (Object)keyEvent);
                keyEvent.consume(false);
            } else {
                screenAreaFocus.keyPressed(keyEvent);
            }
            if (n == 19) {
                this.restartAllIdleTimers();
            } else {
                this.cancelAllIdleTimers();
            }
        }
        if (this.state == 16 && !keyEvent.isConsumed() && this.isKeyCodeForSelectionDrawer(n)) {
            if (this.gemKeyHandler != null) {
                this.gemKeyHandler.keyPressed(keyEvent);
                return;
            }
            if (this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1. don't open selection menu, because main area is locked", (Object)keyEvent);
            } else if (this.requestButtonDrawerState(4)) {
                keyEvent.consume();
                return;
            }
            if (!this.screen.isDisableLeftBack()) {
                this.runSDSAction(0);
                return;
            }
        }
        if (this.state == 16 && !keyEvent.isConsumed() && this.isKeyCodeForOptionDrawer(n)) {
            if (this.gemKeyHandler != null) {
                this.gemKeyHandler.keyPressed(keyEvent);
                return;
            }
            if (this.isSmallStageWithNotFocusableScreen()) {
                this.requestLargeViewSize(8);
                keyEvent.consume();
                return;
            }
            if (this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyPressed event: %1. don't open option menu, because main area is locked", (Object)keyEvent);
            } else {
                this.requestButtonDrawerState(8);
                keyEvent.consume();
                return;
            }
        }
        if (keyEvent.getKeyCode() == 17) {
            this.runSDSAction(keyEvent.getSdsAction());
        }
        if (n == 15 && !keyEvent.isConsumed()) {
            this.handleBackKey(keyEvent);
        }
        this.doCheckedRepaint(keyEvent);
    }

    protected boolean isG24MMIKombi() {
        return AbstractWidget.isScreenResolution1440();
    }

    private boolean isLtr() {
        return this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation();
    }

    private boolean isKeyCodeForSelectionDrawer(int n) {
        if (this.isLtr()) {
            return n == 9;
        }
        return n == 11;
    }

    private boolean isKeyCodeForOptionDrawer(int n) {
        if (this.isLtr()) {
            return n == 11;
        }
        return n == 9;
    }

    private boolean isOptionDrawerDirection(int n) {
        if (this.isLtr()) {
            return n == 4;
        }
        return n == 8;
    }

    private boolean isSelectionDrawerDirection(int n) {
        if (this.isLtr()) {
            return n == 8;
        }
        return n == 4;
    }

    private void handleAppChangeHardKey(KeyEvent keyEvent) {
        if (this.state == 4 || this.state == 8 || this.state == 32 && AbstractWidget.isVariantHigh()) {
            boolean bl = this.shouldConsumeAppChangeHardKeyInDrawer(keyEvent.getKeyCode());
            lc.log(1000000, "DrawerFocusManager#keyPressed handleAppChangeHardKey closing drawers, shouldConsume=%1", bl);
            if (bl) {
                this.requestDrawerState(16);
                keyEvent.consume();
            }
        }
    }

    private boolean shouldConsumeAppChangeHardKeyInDrawer(int n) {
        if (this.screen instanceof ScreenWidgetEVO) {
            int n2 = ((ScreenWidgetEVO)this.screen).getHardKeyToConsumeOnOpenDrawer();
            return n2 == n;
        }
        return false;
    }

    private void handleBackKey(KeyEvent keyEvent) {
        int n;
        int n2 = this.getDrawerState();
        if (n2 == 4 && this.selectionDrawer instanceof DrawerController && (n = ((DrawerController)this.selectionDrawer).getHkReturnEvent()) != -1 && AbstractWidget.hmiService != null) {
            lc.log(1000000, "DrawerFocusManager#handleBackKey: fire SM event %1 from open selection drawer", (long)n);
            keyEvent.consume();
            this.requestDrawerClose(4);
            AbstractWidget.hmiService.fireSMEvent(this.terminal.getTerminalID(), n);
            return;
        }
        if (n2 != 16) {
            lc.log(1000000, "DrawerFocusManager#handleBackKey: go back to main area for screen: %1", (Object)this.screen);
            this.requestButtonDrawerState(16);
            keyEvent.consume();
            return;
        }
        if (n2 == 16 && this.screen instanceof ScreenWidgetEVO && (n = (int)(((ScreenWidgetEVO)this.screen).isOpenSelectionDrawerByHkReturn() ? 1 : 0)) != 0) {
            if (this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#handleBackKey event: %1. don't go back to selection menu, because main area is locked", (Object)keyEvent);
            } else {
                lc.log(1000000, "DrawerFocusManager#handleBackKey: go back to selection drawer from screen: %1", (Object)this.screen);
                if (this.requestButtonDrawerState(4)) {
                    keyEvent.consume();
                } else {
                    lc.log(100000, "DrawerFocusManager#handleBackKey: could not open selection drawer with HK_BACK");
                }
            }
            return;
        }
    }

    private void runSDSAction(int n) {
        if (AbstractWidget.sdsService == null) {
            lc.log(1000000, "DrawerFocusManager#runSDSAction: no SDSService available. SDS action: %1", (long)n);
            return;
        }
        if (!AbstractWidget.sdsService.isSDSActive()) {
            return;
        }
        if (n == 0) {
            lc.log(10000000, "DrawerFocusManager#runSDSAction: abort SDS service");
            AbstractWidget.sdsService.abortSDSSession(false, (byte)3);
        } else if (n == 1) {
            lc.log(10000000, "DrawerFocusManager#runSDSAction: silent abort SDS service");
            AbstractWidget.sdsService.abortSDSSession(true, (byte)3);
        }
    }

    private boolean isAllInTouchVirtualKey(int n) {
        return n == 30 || n == 15 || n == 77 || n == 78 || n == 9 || n == 11 || n == 43 || n == 44 || n == 45 || n == 46 || n == 47 || n == 48 || n == 79 || n == 80;
    }

    private boolean isMFLPhoneKey(int n) {
        return this.phoneKeyHandler != null && n == 58;
    }

    private static boolean isPTTKey(int n) {
        return n == 18 || n == 28 || n == 23;
    }

    private void restartIdleTimer(ScreenAreaFocus screenAreaFocus) {
        if (screenAreaFocus != null && screenAreaFocus.hasIdleTimer()) {
            screenAreaFocus.restartIdleTimer();
        }
    }

    private void cancelIdleTimer(ScreenAreaFocus screenAreaFocus) {
        if (screenAreaFocus != null && screenAreaFocus.hasIdleTimer()) {
            screenAreaFocus.cancelIdleTimer();
        }
    }

    private void cancelAllIdleTimers() {
        this.cancelIdleTimer(this.screen);
        this.cancelIdleTimer(this.selectionDrawer);
        this.cancelIdleTimer(this.optionDrawer);
        this.cancelIdleTimer(this.entertainmentDrawer);
    }

    private void restartAllIdleTimers() {
        this.restartIdleTimer(this.screen);
        this.restartIdleTimer(this.selectionDrawer);
        this.restartIdleTimer(this.optionDrawer);
        this.restartIdleTimer(this.entertainmentDrawer);
    }

    private ScreenAreaFocus getFocusMainArea() {
        if (this.screen == null) {
            return null;
        }
        if (this.state != 16) {
            return null;
        }
        ScreenMainArea screenMainArea = this.screen.getMainArea();
        if (this.isMainAreaFocusable(screenMainArea)) {
            return this.screen;
        }
        return null;
    }

    private ScreenAreaFocus getFocusedDrawer() {
        if (this.screen == null) {
            return null;
        }
        if (this.state == 16) {
            return null;
        }
        if (this.state == 4) {
            return this.selectionDrawer;
        }
        if (this.state == 8) {
            return this.optionDrawer;
        }
        if (this.state == 32) {
            return this.entertainmentDrawer;
        }
        lc.log(10000, "DrawerFocusManager#getFocusedDrawer unknown state: %1", (long)this.state);
        return null;
    }

    private boolean isMainAreaFocusable(ScreenMainArea screenMainArea) {
        if (screenMainArea == null) {
            return false;
        }
        AbstractWidgetController abstractWidgetController = screenMainArea.getScreenAreaWidget();
        if (abstractWidgetController == null) {
            return true;
        }
        HMITerminal hMITerminal = abstractWidgetController.getTerminal();
        if (!(hMITerminal instanceof HMITerminalImpl)) {
            return true;
        }
        HMITerminalImpl hMITerminalImpl = (HMITerminalImpl)hMITerminal;
        IViewSizeManager iViewSizeManager = hMITerminalImpl.getViewSizeManager();
        if (iViewSizeManager == null) {
            return true;
        }
        if (this.viewSize != 1) {
            return true;
        }
        return screenMainArea.isFocusableInSmallStage();
    }

    public void keyReleased(KeyEvent keyEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.isMFLPhoneKey(keyEvent.getKeyCode())) {
            if (this.isG24MMIKombi()) {
                this.phoneKeyHandler.handleMFLPhoneKeyReleased();
            } else {
                lc.log(1000000, "DrawerFocusManager#keyReleased MFL Phonekey released - but no G24 system - ignore release event");
                return;
            }
        }
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.keyReleased(keyEvent);
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.keyReleased(keyEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyReleased event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)keyEvent);
                this.doCheckedRepaint(keyEvent);
                return;
            }
            this.partialPopupManager.setFocusedLayer(2);
            this.partialPopupManager.keyReleased(keyEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyReleased event: %1 consumed by popup drawer", (Object)keyEvent);
                this.doCheckedRepaint(keyEvent);
                return;
            }
        }
        if (this.state != 32 && this.partialPopupManager != null && !keyEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.keyReleased(keyEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyReleased event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)keyEvent);
                this.doCheckedRepaint(keyEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyReleased event: %1 not sent to current focused drawer, because main area is locked", (Object)keyEvent);
            } else {
                screenAreaFocus2.keyReleased(keyEvent);
            }
            this.restartAllIdleTimers();
        }
        if (this.partialPopupManager != null && !keyEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.keyReleased(keyEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (keyEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyReleased event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)keyEvent);
                this.doCheckedRepaint(keyEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(keyEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyReleased event: %1 not sent to current focused main area, because main area is locked", (Object)keyEvent);
                keyEvent.consume(false);
            } else {
                screenAreaFocus.keyReleased(keyEvent);
            }
            this.restartAllIdleTimers();
        }
        if (keyEvent.getKeyCode() == 17) {
            this.runSDSAction(keyEvent.getSdsAction());
        }
        this.doCheckedRepaint(keyEvent);
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.keyTurned(wheelButtonEvent);
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.keyTurned(wheelButtonEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (wheelButtonEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyTurned event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)wheelButtonEvent);
                this.doCheckedRepaint(wheelButtonEvent);
                return;
            }
            this.partialPopupManager.setFocusedLayer(2);
            this.partialPopupManager.keyTurned(wheelButtonEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (wheelButtonEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyTurned event: %1 consumed by popup drawer", (Object)wheelButtonEvent);
                this.doCheckedRepaint(wheelButtonEvent);
                return;
            }
        }
        if (this.isSmallStageWithNotFocusableScreen() && wheelButtonEvent.getClickCount() > 0) {
            this.requestLargeViewSize(7);
            return;
        }
        if (this.state != 32 && this.partialPopupManager != null && !wheelButtonEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.keyTurned(wheelButtonEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (wheelButtonEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyTurned event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)wheelButtonEvent);
                this.doCheckedRepaint(wheelButtonEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(wheelButtonEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyTurned event: %1 not sent to current focused main area, because main area is locked", (Object)wheelButtonEvent);
            } else {
                screenAreaFocus2.keyTurned(wheelButtonEvent);
            }
            this.restartAllIdleTimers();
        }
        if (this.partialPopupManager != null && !wheelButtonEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.keyTurned(wheelButtonEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (wheelButtonEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyTurned event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)wheelButtonEvent);
                this.doCheckedRepaint(wheelButtonEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(wheelButtonEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyTurned event: %1 not sent to current focused main area, because main area is locked", (Object)wheelButtonEvent);
                wheelButtonEvent.consume(false);
            } else {
                screenAreaFocus.keyTurned(wheelButtonEvent);
            }
            this.restartAllIdleTimers();
        }
        this.doCheckedRepaint(wheelButtonEvent);
    }

    private void requestLargeViewSize(int n) {
        IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
        if (!iViewSizeManager.isRequestActive(n)) {
            iViewSizeManager.requestLargeViewSize(n);
        }
    }

    private boolean isSmallStageWithNotFocusableScreen() {
        if (this.terminal.getViewSizeManager() != null && this.terminal.getViewSizeManager().getCurrentViewSize() == 1) {
            return this.state == 16 && this.screen.getMainArea() != null && !this.screen.getMainArea().isFocusableInSmallStage();
        }
        return false;
    }

    private boolean isCurrentScreenFocused() {
        if (this.screen == null) {
            return false;
        }
        if (this.state != 16) {
            return false;
        }
        ScreenMainArea screenMainArea = this.screen.getMainArea();
        if (screenMainArea == null) {
            return false;
        }
        IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
        if (iViewSizeManager == null) {
            return true;
        }
        if (iViewSizeManager.getCurrentViewSize() == 2) {
            return true;
        }
        return screenMainArea.isFocusableInSmallStage();
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        ScreenAreaFocus screenAreaFocus;
        int n;
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.keyMoved(joystickEvent);
            if (joystickEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1 consumed by presetPopupHandler", (Object)joystickEvent);
                return;
            }
        }
        if (this.screen instanceof ScreenWidgetEVO && ((ScreenWidgetEVO)this.screen).doesHKFilterContainsKey(n = joystickEvent.getKeyCode())) {
            joystickEvent.setConsumed(true);
            joystickEvent.setIgnorePopupRemoval(true);
            return;
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.keyMoved(joystickEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (joystickEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)joystickEvent);
                this.runSDSAction(joystickEvent.getSdsAction());
                this.doCheckedRepaint(joystickEvent);
                return;
            }
            this.partialPopupManager.setFocusedLayer(2);
            this.partialPopupManager.keyMoved(joystickEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (joystickEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1 consumed by popup drawer", (Object)joystickEvent);
                this.doCheckedRepaint(joystickEvent);
                return;
            }
        }
        n = joystickEvent.getDirection();
        if (this.state != 32 && this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.keyMoved(joystickEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (joystickEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)joystickEvent);
                this.runSDSAction(joystickEvent.getSdsAction());
                this.doCheckedRepaint(joystickEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(joystickEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1 not sent to current focused drawer, because main area is locked", (Object)joystickEvent);
            } else {
                screenAreaFocus.keyMoved(joystickEvent);
                if (joystickEvent.isConsumed()) {
                    return;
                }
                if (this.isOptionDrawerDirection(n)) {
                    this.requestButtonDrawerState(8);
                    joystickEvent.consume();
                    return;
                }
                if (this.isSelectionDrawerDirection(n)) {
                    this.requestButtonDrawerState(4);
                    joystickEvent.consume();
                    return;
                }
                if (n == 2 && this.state == 32) {
                    this.requestButtonDrawerState(32);
                    joystickEvent.consume();
                    return;
                }
                if (n == 6) {
                    this.requestButtonDrawerState(32);
                    joystickEvent.consume();
                    return;
                }
            }
            this.restartAllIdleTimers();
        }
        if (this.partialPopupManager != null && !joystickEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.keyMoved(joystickEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (joystickEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)joystickEvent);
                this.runSDSAction(joystickEvent.getSdsAction());
                this.doCheckedRepaint(joystickEvent);
                return;
            }
        }
        if (this.isSmallStageWithNotFocusableScreen()) {
            this.requestLargeViewSize(8);
            joystickEvent.consume();
            return;
        }
        ScreenAreaFocus screenAreaFocus2 = this.getFocusMainArea();
        if (screenAreaFocus2 != null) {
            if (this.screen.isEventBlocked(joystickEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1 not sent to current focused main area, because main area is locked", (Object)joystickEvent);
                joystickEvent.consume(false);
            } else {
                screenAreaFocus2.keyMoved(joystickEvent);
            }
            this.restartAllIdleTimers();
        }
        if (joystickEvent.isConsumed()) {
            lc.log(10000000, "DrawerFocusManager#keyMoved event: %1 consumed by current focus area", (Object)joystickEvent);
            this.runSDSAction(joystickEvent.getSdsAction());
            this.doCheckedRepaint(joystickEvent);
            return;
        }
        if (this.state == 16 && this.isSelectionDrawerDirection(n)) {
            if (this.screen.isEventBlocked(joystickEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1. don't open selection menu, because main area is locked", (Object)joystickEvent);
            } else if (this.requestButtonDrawerState(4)) {
                joystickEvent.consume();
                return;
            }
            if (!this.screen.isDisableLeftBack()) {
                this.runSDSAction(0);
                return;
            }
        }
        if (this.state == 16 && this.isOptionDrawerDirection(n)) {
            if (this.screen.isEventBlocked(joystickEvent)) {
                lc.log(10000000, "DrawerFocusManager#keyMoved event: %1. don't open option menu, because main area is locked", (Object)joystickEvent);
            } else {
                this.requestButtonDrawerState(8);
            }
            joystickEvent.consume();
            return;
        }
        if (this.state == 16 && n == 6) {
            if (this.entertainmentDrawer != null && this.entertainmentDrawer.getDisplayDrawerState() != 2 && this.entertainmentDrawer.canOpen()) {
                if (this.screen.isEventBlocked(joystickEvent)) {
                    lc.log(10000000, "DrawerFocusManager#keyMoved event: %1. don't open entertainment drawer, because main area is locked", (Object)joystickEvent);
                } else {
                    this.requestButtonDrawerState(32);
                }
            }
            joystickEvent.consume();
            return;
        }
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.touchPadPositionMoved(touchEvent);
            if (touchEvent.isConsumed()) {
                lcD.log(10000000, "DrawerFocusManager#touchPadPositionMoved event: %1 consumed by presetPopupHandler", (Object)touchEvent);
                return;
            }
        }
        if (this.ignoreTouchEvents) {
            lcD.log(10000000, "DrawerFocusManager#touchPadPositionMoved event: %1 ignored because virtual key has been pressed before", (Object)touchEvent);
            return;
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.touchPadPositionMoved(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
        }
        if (touchEvent.isConsumed()) {
            lcD.log(10000000, "DrawerFocusManager#touchPadPositionMoved event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)touchEvent);
            this.doCheckedRepaint(touchEvent);
            return;
        }
        if (this.state != 32 && this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.touchPadPositionMoved(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lcD.log(10000000, "DrawerFocusManager#touchPadPositionMoved event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(touchEvent)) {
                lcD.log(10000000, "DrawerFocusManager#touchPadPositionMoved event: %1 not sent to current focused drawer, because drawer is locked", (Object)touchEvent);
            } else {
                screenAreaFocus2.touchPadPositionMoved(touchEvent);
            }
            this.restartAllIdleTimers();
        }
        if (this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.touchPadPositionMoved(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lcD.log(10000000, "DrawerFocusManager#touchPadPositionMoved event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadPositionMoved event: %1 not sent to current focused main area, because main area is locked", (Object)touchEvent);
            } else {
                screenAreaFocus.touchPadPositionMoved(touchEvent);
            }
            this.restartAllIdleTimers();
        }
        this.doCheckedRepaint(touchEvent);
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.touchPadPressed(touchEvent);
            if (touchEvent.isConsumed()) {
                lcD.log(10000000, "DrawerFocusManager#touchPadPressed event: %1 consumed by presetPopupHandler", (Object)touchEvent);
                return;
            }
        }
        if (this.ignoreTouchEvents) {
            this.ignoreTouchEvents = false;
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.touchPadPressed(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
        }
        if (touchEvent.isConsumed()) {
            lc.log(10000000, "DrawerFocusManager#touchPadPressed event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)touchEvent);
            this.doCheckedRepaint(touchEvent);
            return;
        }
        if (this.state != 32 && this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.touchPadPressed(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadPressed event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadPressed event: %1 not sent to current focused drawer, because drawer is locked", (Object)touchEvent);
            } else {
                screenAreaFocus2.touchPadPressed(touchEvent);
            }
            this.cancelAllIdleTimers();
        }
        if (this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.touchPadPressed(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadPressed event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadPressed event: %1 not sent to current focused main area, because main area is locked", (Object)touchEvent);
            } else {
                screenAreaFocus.touchPadPressed(touchEvent);
            }
            this.cancelAllIdleTimers();
        }
        this.doCheckedRepaint(touchEvent);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.touchPadReleased(touchEvent);
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.touchPadReleased(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
        }
        if (touchEvent.isConsumed()) {
            lc.log(10000000, "DrawerFocusManager#touchPadReleased event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)touchEvent);
            this.doCheckedRepaint(touchEvent);
            return;
        }
        if (this.state != 32 && this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.touchPadReleased(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadReleased event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadReleased event: %1 not sent to current focused drawer, because drawer is locked", (Object)touchEvent);
            } else {
                screenAreaFocus2.touchPadReleased(touchEvent);
            }
            this.restartAllIdleTimers();
        }
        if (this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.touchPadReleased(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadReleased event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadReleased event: %1 not sent to current focused main area, because main area is locked", (Object)touchEvent);
                touchEvent.consume(false);
            } else {
                screenAreaFocus.touchPadReleased(touchEvent);
            }
            this.restartAllIdleTimers();
        }
        this.doCheckedRepaint(touchEvent);
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.touchPadCharactersRecognized(touchEvent);
        }
        if (this.ignoreTouchEvents) {
            lc.log(10000000, "DrawerFocusManager#touchPadCharactersRecognized event: %1 ignored because virtual key has been pressed before", (Object)touchEvent);
            return;
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.touchPadCharactersRecognized(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
        }
        if (touchEvent.isConsumed()) {
            lc.log(10000000, "DrawerFocusManager#touchPadCharactersRecognized event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)touchEvent);
            this.runSDSAction(touchEvent.getSdsAction());
            this.doCheckedRepaint(touchEvent);
            return;
        }
        if (this.state != 32 && this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.touchPadCharactersRecognized(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadCharactersRecognized event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)touchEvent);
                this.runSDSAction(touchEvent.getSdsAction());
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadCharactersRecognized event: %1 not sent to current focused drawer, because drawer is locked", (Object)touchEvent);
            } else {
                screenAreaFocus2.touchPadCharactersRecognized(touchEvent);
                if (touchEvent.isConsumed()) {
                    this.runSDSAction(touchEvent.getSdsAction());
                }
            }
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.touchPadCharactersRecognized(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadCharactersRecognized event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)touchEvent);
                this.runSDSAction(touchEvent.getSdsAction());
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadCharactersRecognized event: %1 not sent to current focused main area, because main area is locked", (Object)touchEvent);
            } else {
                screenAreaFocus.touchPadCharactersRecognized(touchEvent);
                if (touchEvent.isConsumed()) {
                    this.runSDSAction(touchEvent.getSdsAction());
                }
            }
        }
        this.doCheckedRepaint(touchEvent);
    }

    public void touchPadAbandoned(TouchEvent touchEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.touchPadAbandoned(touchEvent);
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.touchPadAbandoned(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
        }
        if (touchEvent.isConsumed()) {
            lc.log(10000000, "DrawerFocusManager#touchPadAbandoned event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)touchEvent);
            this.doCheckedRepaint(touchEvent);
            return;
        }
        if (this.state != 32 && this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.touchPadAbandoned(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadAbandoned event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadAbandoned event: %1 not sent to current focused drawer, because drawer is locked", (Object)touchEvent);
            } else {
                screenAreaFocus2.touchPadAbandoned(touchEvent);
            }
        }
        if (this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.touchPadAbandoned(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadAbandoned event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadAbandoned event: %1 not sent to current focused main area, because main area is locked", (Object)touchEvent);
            } else {
                screenAreaFocus.touchPadAbandoned(touchEvent);
            }
        }
        this.doCheckedRepaint(touchEvent);
    }

    public void touchPadPalmRecognized(TouchEvent touchEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.touchPadPalmRecognized(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
        }
        if (touchEvent.isConsumed()) {
            lc.log(10000000, "DrawerFocusManager#touchPadPalmRecognized event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)touchEvent);
            this.doCheckedRepaint(touchEvent);
            return;
        }
        if (this.state != 32 && this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.touchPadPalmRecognized(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadPalmRecognized event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadPalmRecognized event: %1 not sent to current focused drawer, because drawer is locked", (Object)touchEvent);
            } else {
                screenAreaFocus2.touchPadPalmRecognized(touchEvent);
            }
            this.cancelAllIdleTimers();
        }
        if (this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.touchPadPalmRecognized(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadPalmRecognized event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadPalmRecognized event: %1 not sent to current focused main area, because main area is locked", (Object)touchEvent);
            } else {
                screenAreaFocus.touchPadPalmRecognized(touchEvent);
            }
            this.cancelAllIdleTimers();
        }
        this.doCheckedRepaint(touchEvent);
    }

    public void touchPadApproached(TouchEvent touchEvent) {
        ScreenAreaFocus screenAreaFocus;
        ScreenAreaFocus screenAreaFocus2;
        if (this.screen instanceof ScreenWidgetEVO && ((ScreenWidgetEVO)this.screen).doesHKFilterContainsKey(touchEvent.getCode())) {
            touchEvent.setConsumed(true);
            return;
        }
        if (this.presetPopupHandler != null) {
            this.presetPopupHandler.touchPadApproached(touchEvent);
            if (touchEvent.isConsumed()) {
                return;
            }
        }
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.touchPadApproached(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
        }
        if (touchEvent.isConsumed()) {
            lc.log(10000000, "DrawerFocusManager#touchPadApproached event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)touchEvent);
            this.doCheckedRepaint(touchEvent);
            return;
        }
        if (this.state != 32 && this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(3);
            this.partialPopupManager.touchPadApproached(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadApproached event: %1 consumed by partialPopupManager (LAYER_BETWEEN_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus2 = this.getFocusedDrawer()) != null) {
            if (this.state == 8 && this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadApproached event: %1 not sent to current focused drawer, because drawer is locked", (Object)touchEvent);
            } else {
                screenAreaFocus2.touchPadApproached(touchEvent);
            }
        }
        if (this.partialPopupManager != null && !touchEvent.isConsumed()) {
            this.partialPopupManager.setFocusedLayer(0);
            this.partialPopupManager.touchPadApproached(touchEvent);
            this.partialPopupManager.setFocusedLayer(-1);
            if (touchEvent.isConsumed()) {
                lc.log(10000000, "DrawerFocusManager#touchPadApproached event: %1 consumed by partialPopupManager (LAYER_BEHIND_DRAWERS)", (Object)touchEvent);
                this.doCheckedRepaint(touchEvent);
                return;
            }
        }
        if ((screenAreaFocus = this.getFocusMainArea()) != null) {
            if (this.screen.isEventBlocked(touchEvent)) {
                lc.log(10000000, "DrawerFocusManager#touchPadApproached event: %1 not sent to current focused main area, because main area is locked", (Object)touchEvent);
            } else {
                screenAreaFocus.touchPadApproached(touchEvent);
            }
        }
        this.doCheckedRepaint(touchEvent);
    }

    public void setScreen(IScreenData iScreenData, Screen screen) {
        logScreenChange.log(1000000, "DrawerFocusManager#setScreen screenData=%1, screen=%2", (Object)iScreenData, (Object)screen);
        lc.log(1000000, "DrawerFocusManager#setScreen Old screen %1, new screen %2, current state %3, drawerCloseRequest=%4", (Object)this.screen, (Object)screen, (Object)DrawerFocusManager.getStateName(this.state), (long)this.drawerCloseRequest);
        this.isScreenChange = true;
        if (screen instanceof AbstractScreenWidget) {
            WidgetPersistenceManager.DrawerPersistence drawerPersistence;
            Object object;
            int n;
            AbstractScreenWidget abstractScreenWidget;
            this.screen = abstractScreenWidget = (AbstractScreenWidget)screen;
            this.screenData = iScreenData;
            int n2 = iScreenData.getAnimationInfo();
            boolean bl = (n2 & 1) != 0;
            lc.log(10000000, "DrawerFocusManager#setScreen appChange=%1", bl);
            if (bl && (this.state == 4 || this.state == 8)) {
                lc.log(10000000, "DrawerFocusManager#setScreen closing side drawers because appChange is true");
                n = 16;
            } else {
                n = this.getPredictedDrawerState(iScreenData);
            }
            if (n == 8 && this.optionDrawer == null || n == 4 && this.selectionDrawer == null) {
                lc.log(10000, "DrawerFocusManager#setScreen predicted drawer state is %1, but drawer not available", (Object)DrawerFocusManager.getStateName(this.state));
                n = 16;
            }
            if (lc.isDebug()) {
                lc.log(10000000, "DrawerFocusManager#setScreen state: %1, oldState: %2", (long)n, (long)this.state);
                lc.log(10000000, "DrawerFocusManager#setScreen switching state of screen to %1, oldState %2", (Object)DrawerFocusManager.getStateName(n), (Object)DrawerFocusManager.getStateName(this.state));
            }
            if (n == this.state) {
                object = this.getFocusedIndexOfDrawer((DrawerController)this.getDrawer(8));
                this.setPersistenceOptionDrawerState(iScreenData, this.state, (Comparable)object);
            }
            this.requestDrawerState(n);
            if (this.usePersistence && (drawerPersistence = ((WidgetPersistenceManager)(object = this.getWidgetPersistenceManager())).getDrawerState(iScreenData.getStates())) != null) {
                MenuItemIndex menuItemIndex = (MenuItemIndex)drawerPersistence.getFocusedIndex();
                this.setFocusedIndexOfDrawer((DrawerController)this.getDrawer(8), menuItemIndex);
            }
            this.drawerAnimationManager.setScreen(abstractScreenWidget, n);
            object = abstractScreenWidget.getMainArea();
            if (object != null && this.state == 16) {
                this.restartIdleTimer(abstractScreenWidget);
            }
        } else {
            lc.log(100000, "DrawerFocusManager#setScreen screen not a ScreenWidget", (Object)screen);
            this.screen = null;
        }
        if (this.isCurrentScreenFocused()) {
            int n = 1024;
            if (iScreenData != null && iScreenData.isReinit()) {
                n |= 0x1000;
            }
            this.fireFocusChangedScreen(this.screen, 2, this.state, n);
        }
        this.updateDrawerStates(this.screen, true);
        this.isScreenChange = false;
        IDrawerListener.CallbackFunction.informListeners(this.drawerListeners, IDrawerListener.CALLBACK_SCREEN_SET, new Object[]{iScreenData, screen});
        LockingManager.requestCurrentLockingState(this);
    }

    public void setDrawersAndPopupsInvalid() {
        if (this.screen != null) {
            this.screen.makeSubtreeDirty();
        }
        if (this.optionDrawer != null) {
            ((AbstractWidgetController)((Object)this.optionDrawer)).makeSubtreeDirty();
        }
        if (this.selectionDrawer != null) {
            ((AbstractWidgetController)((Object)this.selectionDrawer)).makeSubtreeDirty();
        }
        if (this.entertainmentDrawer != null) {
            ((AbstractWidgetController)((Object)this.entertainmentDrawer)).makeSubtreeDirty();
        }
        if (this.partialPopupManager instanceof AbstractPartialPopupManager) {
            ((AbstractPartialPopupManager)this.partialPopupManager).setUnboundPartialPopupsInvalid();
        }
    }

    private void setPersistenceOptionDrawerState(IScreenData iScreenData, int n, Comparable comparable) {
        lcD.log(10000000, "DrawerFocusManager#setPersistenceDrawerState screenData=%1, persistenceDrawerState=%2", (Object)iScreenData, (long)n);
        if (iScreenData == null) {
            return;
        }
        WidgetPersistenceManager widgetPersistenceManager = this.getWidgetPersistenceManager();
        widgetPersistenceManager.setDrawerState(iScreenData.getStates(), new WidgetPersistenceManager.DrawerPersistence(n, comparable));
    }

    private int getPredictedDrawerState(IScreenData iScreenData) {
        if (this.optionDrawerOpenedDuringScreenChange) {
            this.optionDrawerOpenedDuringScreenChange = false;
            return 8;
        }
        int n = this.getPersistenceOptionDrawerState(iScreenData);
        if (n == 3) {
            if (this.state == 8) {
                lcD.log(10000000, "DrawerFocusManager#getPredictedDrawerState changing state from option drawer to main area, because no persistence was used");
                return 16;
            }
            lcD.log(10000000, "DrawerFocusManager#getPredictedDrawerState returning old state %1", (Object)DrawerFocusManager.getStateName(this.state));
            return this.state;
        }
        if (n == 1 && this.state != 8) {
            lcD.log(10000000, "DrawerFocusManager#getPredictedDrawerState opened option drawer");
            return 8;
        }
        if (n == 2 && this.state == 8) {
            lcD.log(10000000, "DrawerFocusManager#getPredictedDrawerState closed option drawer -> main state");
            return 16;
        }
        lcD.log(10000000, "DrawerFocusManager#getPredictedDrawerState already in wanted state %1", (Object)DrawerFocusManager.getStateName(this.state));
        return this.state;
    }

    private int getPersistenceOptionDrawerState(IScreenData iScreenData) {
        int n;
        lcD.log(10000000, "DrawerFocusManager#getPersistenceOptionDrawerState screenData=%1", (Object)iScreenData);
        if (iScreenData == null) {
            return 3;
        }
        boolean bl = iScreenData.isReinit();
        lcD.log(10000000, "DrawerFocusManager#getPersistenceOptionDrawerState reinit=%1, usePersistence=%2", bl, this.usePersistence);
        if (!this.usePersistence) {
            return 3;
        }
        int[] nArray = iScreenData.getStates();
        lcD.log(10000000, "DrawerFocusManager#getPersistenceOptionDrawerState states=%1", (Object)nArray);
        if (bl && nArray != null && nArray.length == 1 && nArray[0] == 300006) {
            return 2;
        }
        WidgetPersistenceManager widgetPersistenceManager = this.getWidgetPersistenceManager();
        WidgetPersistenceManager.DrawerPersistence drawerPersistence = widgetPersistenceManager.getDrawerState(nArray);
        int n2 = n = drawerPersistence != null ? drawerPersistence.getState() : 0;
        int n3 = n == 0 ? 2 : (n == 1 ? 1 : 3);
        lcD.log(10000000, "DrawerFocusManager#getPersistenceOptionDrawerState persistenceOptionDrawerState=%1, returning=%2", (long)n, (long)n3);
        return n3;
    }

    private WidgetPersistenceManager getWidgetPersistenceManager() {
        return this.terminal.getWidgetPersistenceManager();
    }

    public AbstractScreenWidget getScreen() {
        return this.screen;
    }

    protected boolean shouldShowSideDrawerIcons(AbstractScreenWidget abstractScreenWidget) {
        boolean bl;
        boolean bl2 = bl = this.viewSize != 1 && this.state != 4 && this.state != 8;
        if (!bl) {
            lcD.log(10000000, "DrawerFocusManager#shouldShowSideDrawerIcons small view size or opened side drawers -> hiding icons");
            return false;
        }
        if (abstractScreenWidget == null) {
            lcD.log(10000000, "DrawerFocusManager#shouldShowSideDrawerIcons no screen -> showing icons");
            return true;
        }
        int n = abstractScreenWidget.getDrawerVisibility();
        lcD.log(10000000, "DrawerFocusManager#shouldShowSideDrawerIcons screen drawerVisibility flag: %1", (long)n);
        return n == 0 || n == 2;
    }

    protected boolean shouldShowEntertainmentDrawer(AbstractScreenWidget abstractScreenWidget) {
        if (abstractScreenWidget == null) {
            lcD.log(10000000, "DrawerFocusManager#shouldShowEntertainmentDrawer no screen -> showing entertainment drawer");
            return true;
        }
        int n = abstractScreenWidget.getDrawerVisibility();
        lcD.log(10000000, "DrawerFocusManager#shouldShowEntertainmentDrawer screen drawerVisibility flag: %1", (long)n);
        return n == 0 || n == 1;
    }

    private void doCheckedRepaint(KeyEvent keyEvent) {
        if (this.screen != null && keyEvent.isConsumed() && keyEvent.isRepaintNeeded()) {
            logRepaintCause.log(10000000, "DrawerFocusManager#doCheckedRepaint: do checked repaint on screen %2. key event: %1", (Object)keyEvent, (long)this.screen.getID());
            this.screen.doCheckedRepaint();
        }
    }

    private void doCheckedRepaint(TouchEvent touchEvent) {
        if (this.screen != null && touchEvent.isConsumed() && touchEvent.isRepaintNeeded()) {
            logRepaintCause.log(10000000, "DrawerFocusManager#doCheckedRepaint: do checked repaint on screen %2. touch event: %1", (Object)touchEvent, (long)this.screen.getID());
            this.screen.doCheckedRepaint();
        }
    }

    public void setSelectionDrawer(Object object) {
        lc.log(1000000, "DrawerFocusManager#setSelectionDrawer current selection drawer: %1, new selection drawer: %2", (Object)this.selectionDrawer, object);
        this.previousSelectionDrawer = this.selectionDrawer;
        this.selectionDrawer = (IDrawerControllerEvo)object;
        if (this.selectionDrawer == null || !this.selectionDrawer.canOpen()) {
            if (this.state == 4) {
                lc.log(10000000, "DrawerFocusManager#setSelectionDrawer Switching to main area because selection drawer is null");
                this.requestDrawerState(16);
            } else {
                this.updateClosedDrawerIconVisibility();
            }
        } else if (!this.selectionDrawer.equals(this.previousSelectionDrawer)) {
            lcD.log(10000000, "DrawerFocusManager#setSelectionDrawer initializing new selection drawer");
            this.updateClosedDrawerIconVisibility();
            this.setTransitionOnSide(4, true);
            if (this.state == 4) {
                this.requestDrawerState(16);
            }
        }
        this.drawerAnimationManager.setSelectionDrawer((DrawerController)this.selectionDrawer, 0);
        this.updateDrawerStates(this.screen, true);
        if (this.previousSelectionDrawer != null && !this.previousSelectionDrawer.equals(this.selectionDrawer)) {
            this.disconnectDrawer(this.previousSelectionDrawer);
        }
    }

    private void disconnectDrawer(IDrawerControllerEvo iDrawerControllerEvo) {
        IModelConnectService iModelConnectService = AbstractWidget.framework.getHMIService().getModelConnectService(this.terminal.getTerminalID());
        iDrawerControllerEvo.predisconnecting();
        iModelConnectService.modifiyModelReference(iDrawerControllerEvo, false, true);
        iDrawerControllerEvo.disconnecting();
    }

    public void setOptionDrawer(Object object, Comparable comparable) {
        lc.log(1000000, "DrawerFocusManager#setOptionDrawer current option drawer: %1, new option drawer: %2", (Object)this.optionDrawer, object);
        if (this.screenData != null) {
            int n;
            if (this.state == 8) {
                lcD.log(10000000, "DrawerFocusManager#setOptionDrawer set persistent option drawer state to opened state, screen=%1", (Object)this.screenData);
                n = 1;
            } else {
                lcD.log(10000000, "DrawerFocusManager#setOptionDrawer set persistent option drawer state to closed state, screen=%1", (Object)this.screenData);
                n = 0;
            }
            this.setPersistenceOptionDrawerState(this.screenData, n, comparable);
        }
        this.previousOptionDrawer = this.optionDrawer;
        this.optionDrawer = (IDrawerControllerEvo)object;
        if (this.optionDrawer != null) {
            this.lastValidOptionDrawer = this.optionDrawer;
            this.optionDrawer.setTransitionForward(true);
            this.updateDrawerContent(8);
        }
        if (this.optionDrawer == null || !this.optionDrawer.canOpen()) {
            if (this.state == 8) {
                lc.log(10000000, "DrawerFocusManager#setOptionDrawer Switching to main area because option drawer is null");
                this.requestDrawerState(16);
            } else {
                this.updateClosedDrawerIconVisibility();
            }
            this.drawerAnimationManager.setOptionDrawer((DrawerController)this.optionDrawer, 1);
        } else if (!this.optionDrawer.equals(this.previousOptionDrawer)) {
            lcD.log(10000000, "DrawerFocusManager#setOptionDrawer initializing new option drawer");
            this.updateClosedDrawerIconVisibility();
            DrawerController drawerController = (DrawerController)this.optionDrawer;
            boolean bl = ScreenChangeAnimationItem.Helper.isType(drawerController.getScreenChangeTarget(), 8) && ScreenChangeAnimationItem.Helper.isTransition(drawerController.getScreenChangeTarget(), 64);
            lc.log(10000000, "DrawerFocusManager#setOptionDrawer drawerShallBeOpenDirectly=%1", bl);
            if (bl) {
                this.setTransitionOnSide(8, true);
                this.drawerAnimationManager.setOptionDrawer((DrawerController)this.optionDrawer, 2);
            } else {
                boolean bl2 = this.getPersistenceOptionDrawerState(this.screenData) == 1;
                drawerController.setTransitionForward(bl2);
                if (this.state == 8) {
                    lc.log(10000000, "DrawerFocusManager#setOptionDrawer opening option drawer because state is option drawer");
                    drawerController.setTransitionForward(true);
                }
                this.drawerAnimationManager.setOptionDrawer((DrawerController)this.optionDrawer, 1);
            }
        }
        if (this.previousOptionDrawer != null && !this.previousOptionDrawer.equals(this.optionDrawer)) {
            this.disconnectDrawer(this.previousOptionDrawer);
        }
        IDrawerListener.CallbackFunction.informListeners(this.drawerListeners, IDrawerListener.CALLBACK_OPTION_DRAWER_ACTIVATED, new Object[]{this.screenData, this.screen, this.optionDrawer});
    }

    public Object getPreviosSelectionDrawer() {
        return this.previousSelectionDrawer;
    }

    public Object getPreviousOptionDrawer() {
        return this.previousOptionDrawer;
    }

    public Object getSelectionDrawer() {
        return this.selectionDrawer;
    }

    public Object getOptionDrawer() {
        return this.optionDrawer;
    }

    public Object getEntertainmentDrawer() {
        return this.entertainmentDrawer;
    }

    public Object getPreviousSelectionDrawer() {
        return this.previousSelectionDrawer;
    }

    public void screenChangeFinished() {
        this.drawerAnimationManager.screenChangeFinished();
    }

    public void screenFadedOut() {
        if (this.optionDrawer != null && this.isDrawerClosingRequested(8) && this.state == 8) {
            this.requestDrawerState(16);
        }
        if (this.selectionDrawer != null && this.isDrawerClosingRequested(4) && this.state == 4) {
            this.requestDrawerState(16);
        }
    }

    public void setEntertainmentDrawer(Object object) {
        this.entertainmentDrawer = (IDrawerControllerEvo)object;
        this.drawerAnimationManager.setEntertainmentDrawer((DrawerController)this.entertainmentDrawer, 0);
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = ((EntertainmentDrawerController)object).getOpenCloseController();
        entertainmentDrawerOpenCloseController.onDrawerVisibiltyChange(this.earlyEntertainmentVisible);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        logWidgetPerformance.log(1000000, "DrawerFocusManager#processModelUpdateEvent start, event: %1", (Object)modelUpdateEvent);
        long l = AbstractWidget.framework.getMonotonicTime();
        if (this.selectionDrawer != null) {
            this.selectionDrawer.processModelUpdateEvent(modelUpdateEvent);
        }
        if (this.optionDrawer != null) {
            this.optionDrawer.processModelUpdateEvent(modelUpdateEvent);
        }
        if (this.entertainmentDrawer != null) {
            this.entertainmentDrawer.processModelUpdateEvent(modelUpdateEvent);
        }
        long l2 = AbstractWidget.framework.getMonotonicTime();
        logWidgetPerformance.log(1000000, "DrawerFocusManager#processModelUpdateEvent finished, took %1 ms", l2 - l);
    }

    public void paintDrawers() {
        HMITerminal hMITerminal;
        Object object;
        RedrawContext redrawContext = null;
        if (this.selectionDrawer instanceof DrawerController && (object = this.selectionDrawer.getTerminal()) instanceof HMITerminalImpl && (redrawContext = ((HMITerminalImpl)object).getRedrawContext()) != null) {
            ((DrawerController)this.selectionDrawer).managePaint(redrawContext);
        }
        if (this.optionDrawer instanceof DrawerController && (hMITerminal = ((DrawerController)(object = (DrawerController)this.optionDrawer)).getTerminal()) instanceof HMITerminalImpl && (redrawContext = ((HMITerminalImpl)hMITerminal).getRedrawContext()) != null) {
            DrawerIcon drawerIcon;
            DrawerMain drawerMain = ((DrawerController)object).getDrawerMain();
            if (drawerMain instanceof AbstractWidget && this.getDrawerState() != 8) {
                ((AbstractWidget)((Object)drawerMain)).setInvalid(false);
            }
            if ((drawerIcon = ((DrawerController)object).getDrawerIcon()) instanceof AbstractWidget && this.getDrawerState() == 8) {
                ((AbstractWidget)((Object)drawerIcon)).setInvalid(false);
            }
            ((AbstractWidgetController)object).managePaint(redrawContext);
        }
        if (this.entertainmentDrawer instanceof DrawerController && (object = this.entertainmentDrawer.getTerminal()) instanceof HMITerminalImpl && (redrawContext = ((HMITerminalImpl)object).getRedrawContext()) != null) {
            ((DrawerController)this.entertainmentDrawer).managePaint(redrawContext);
        }
    }

    public int getDrawerState() {
        return this.state;
    }

    public void setDrawerState(int n, boolean bl) {
        lc.log(1000000, "DrawerFocusManager#setDrawerState Setting state %1, animated=%2, old state is %3", (Object)DrawerFocusManager.getStateName(n), (Object)bl, (Object)DrawerFocusManager.getStateName(this.state));
        if (n != 4 && n != 8 && n != 32 && n != 16) {
            lc.log(10000, "Wrong state number", (long)n);
            return;
        }
        if (this.lockingActive && n == 8 && this.optionDrawer != null && this.optionDrawer.isBlockedWhileLockingIsActive()) {
            lc.log(1000000, "DrawerFocusManager#setDrawerState lockingActive do not open OptionDrawer, try to show popup");
            this.showNotAllowedWhileDrivingPopup();
            return;
        }
        this.targetState = n;
        if (this.state == 16) {
            if (this.screen != null && this.screen.getDefaultSKKeyCode() == 0) {
                IDrawerControllerEvo iDrawerControllerEvo = this.getDrawer(n);
                if (iDrawerControllerEvo != null) {
                    ScreenMainArea screenMainArea;
                    if (n != this.state) {
                        this.closePopupDrawer();
                        this.fireFocusChanged(16, n, 512);
                    }
                    if ((screenMainArea = this.screen.getMainArea()) != null) {
                        this.cancelIdleTimer(this.screen);
                    }
                    if (n == 32) {
                        iDrawerControllerEvo.setDisplayDrawerState(0, bl && iDrawerControllerEvo.isConnected(), true);
                    }
                    this.restartAllIdleTimers();
                    this.setState(n);
                }
            } else {
                this.targetState = this.state;
            }
        } else if (n != this.state && n != 16) {
            this.fireFocusChanged(this.state, n, 512);
            this.closeDrawer(this.state);
            IDrawerControllerEvo iDrawerControllerEvo = this.getDrawer(this.state);
            IDrawerControllerEvo iDrawerControllerEvo2 = this.getDrawer(n);
            if (iDrawerControllerEvo != null) {
                if (this.state == 32) {
                    iDrawerControllerEvo.setDisplayDrawerState(1, bl && iDrawerControllerEvo.isConnected(), true);
                }
                this.cancelIdleTimer(iDrawerControllerEvo);
            }
            if (iDrawerControllerEvo2 != null) {
                if (n == 32) {
                    iDrawerControllerEvo2.setDisplayDrawerState(0, bl && iDrawerControllerEvo2.isConnected(), true);
                }
                this.restartIdleTimer(iDrawerControllerEvo2);
            }
            this.setState(n);
        } else if (n == 16) {
            if (!this.isScreenChange) {
                this.fireFocusChanged(this.state, 16, 512);
            }
            this.closeDrawer(this.state);
            this.restartIdleTimer(this.screen);
            this.setState(16);
        } else {
            lcD.log(10000000, "DrawerFocusManager#setDrawerState drawer already open. state: %1, newState: %2", (Object)DrawerFocusManager.getStateName(this.state), (Object)DrawerFocusManager.getStateName(n));
        }
        this.drawerAnimationManager.setDrawerState(n, bl);
        this.updateDrawerStates(this.screen, bl);
    }

    private void showNotAllowedWhileDrivingPopup() {
        if (this.terminal.isStarted()) {
            this.terminal.getFramework().getHMIService().showPartialPopup(this.terminal.getTerminalID(), 191);
        }
    }

    private void hideNotAllowedWhileDrivingPopup() {
        if (this.terminal.isStarted()) {
            this.terminal.getFramework().getHMIService().removePartialPopup(this.terminal.getTerminalID(), 191);
        }
    }

    private void setTransitionOnSide(int n, boolean bl) {
        IDrawerControllerEvo iDrawerControllerEvo = this.getDrawer(n);
        if (iDrawerControllerEvo == null) {
            return;
        }
        iDrawerControllerEvo.setTransitionForward(bl);
    }

    private void updateDrawerContent(int n) {
        if (n == 8) {
            this.updateOptionDrawerContent();
            this.updateOptionMenuInitialFocus();
        }
    }

    public void updateOptionDrawerContent() {
        IFocusedPropertyObject iFocusedPropertyObject = this.getCurrentFocusedProperty();
        if (this.screen != null) {
            ((HMITerminalEvo)this.screen.getTerminal()).getDrawerConditionEngine().setFocusedProperty(iFocusedPropertyObject);
        }
    }

    private void setState(int n) {
        lc.log(10000000, "DrawerFocusManager#setState Switching state from %1 to %2", (Object)DrawerFocusManager.getStateName(this.state), (Object)DrawerFocusManager.getStateName(n));
        this.state = n;
        if (this.terminal != null && this.terminal.getKbdService() != null) {
            this.setIllumination(this.state);
        }
        this.clearDrawerCloseFlags();
        if (n != 16 && null != this.terminal) {
            this.terminal.getUserHintHandler().removeCurrentUserHint();
        }
    }

    private void setIllumination(int n) {
        if (n == 8 || n == 4) {
            this.terminal.getKbdService().setSKIlluminationExclusive(this.getIlluminationKey(n));
        } else if (n == 16 && this.partialPopupDrawerOpen) {
            this.terminal.getKbdService().setSKIlluminationExclusive(this.getIlluminationKey(8));
        } else {
            this.terminal.getKbdService().setSKIlluminationOff();
        }
    }

    public void setPartialPopupDrawerOpen(boolean bl) {
        this.partialPopupDrawerOpen = bl;
        if (bl) {
            this.setIllumination(8);
        } else {
            this.setIllumination(this.state);
        }
    }

    private int getIlluminationKey(int n) {
        if (n == 4) {
            return this.isLtr() ? 77 : 78;
        }
        if (n == 8) {
            return this.isLtr() ? 78 : 77;
        }
        return -1;
    }

    private IFocusedPropertyObject getCurrentFocusedProperty() {
        if (this.focusPropertyProvider != null) {
            return this.focusPropertyProvider.getCurrentFocusedPropertyObject();
        }
        return null;
    }

    public void startTrackingServices(BundleContext bundleContext, HMITerminal hMITerminal) {
        this.initializeMMICombiDrawerStateSyncTracker(bundleContext);
    }

    private void initializeMMICombiDrawerStateSyncTracker(final BundleContext bundleContext) {
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$mmicombi$IMMICombiDrawerStateSync == null ? (class$de$audi$atip$mmicombi$IMMICombiDrawerStateSync = DrawerFocusManager.class$("de.audi.atip.mmicombi.IMMICombiDrawerStateSync")) : class$de$audi$atip$mmicombi$IMMICombiDrawerStateSync).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                DrawerFocusManager.this.mmiCombiDrawerStateSync = (IMMICombiDrawerStateSync)bundleContext.getService(serviceReference);
                return DrawerFocusManager.this.mmiCombiDrawerStateSync;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                DrawerFocusManager.this.mmiCombiDrawerStateSync = null;
            }
        });
        serviceTracker.open();
    }

    public void registerDrawerFocusManagerService(IFrameworkAccess iFrameworkAccess) {
        Hashtable hashtable = new Hashtable();
        iFrameworkAccess.getBundleCxt().registerService(new String[]{(class$de$audi$tghu$hmi$evo$IDrawerFocusManagerEvo == null ? (class$de$audi$tghu$hmi$evo$IDrawerFocusManagerEvo = DrawerFocusManager.class$("de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo")) : class$de$audi$tghu$hmi$evo$IDrawerFocusManagerEvo).getName()}, (Object)this, (Dictionary)hashtable);
    }

    public void registerFocusPropertyProvider(IFocusedPropertyProvider iFocusedPropertyProvider) {
        this.focusPropertyProvider = iFocusedPropertyProvider;
    }

    public void deRegisterFocusPropertyProvider(IFocusedPropertyProvider iFocusedPropertyProvider) {
        if (this.focusPropertyProvider == iFocusedPropertyProvider) {
            this.focusPropertyProvider = null;
        }
    }

    public int getPredictedDrawerState(Screen screen, IScreenData iScreenData) {
        return this.getPredictedDrawerState(iScreenData);
    }

    public IPresetPopupData getPresetPopupData() {
        IPresetPopupData iPresetPopupData = null;
        switch (this.state) {
            case 8: {
                if (this.optionDrawer == null) break;
                iPresetPopupData = this.optionDrawer.getPresetPopupData();
                break;
            }
            case 4: {
                if (this.selectionDrawer == null) break;
                iPresetPopupData = this.selectionDrawer.getPresetPopupData();
                break;
            }
            case 32: {
                break;
            }
            default: {
                Object object;
                ScreenMainArea screenMainArea;
                if (this.screen == null || (screenMainArea = this.screen.getMainArea()) == null) break;
                iPresetPopupData = screenMainArea.getScreenAreaWidget().getPresetPopupData();
                List list = this.screen.getChildren();
                if (iPresetPopupData != null || list == null) break;
                int n = list.size();
                for (int i2 = 0; !(i2 >= n || (object = list.get(i2)) instanceof DisplayControllerEvo && (iPresetPopupData = ((DisplayControllerEvo)object).getPresetPopupData()) != null); ++i2) {
                }
            }
        }
        return iPresetPopupData;
    }

    public void setViewSize(int n, boolean bl) {
        boolean bl2;
        lc.log(1000000, "DrawerFocusManager#setViewSize size=%1, animate=%2", (Object)Util.createInteger(n), (Object)bl);
        boolean bl3 = this.screen != null && this.isMainAreaFocusable(this.screen.getMainArea());
        this.viewSize = n;
        if (this.viewSize == 1 && this.state == 8) {
            lc.log(10000000, "DrawerFocusManager#setViewSize option drawer opened, switching to small stage -> closing drawer", (Object)Util.createInteger(n), (Object)bl);
            this.requestDrawerState(16);
        }
        if (this.screen != null && this.state == 16 && bl3 != (bl2 = this.isMainAreaFocusable(this.screen.getMainArea()))) {
            if (bl2) {
                this.fireFocusChanged(this.screen, 2, 16, 2048);
            } else {
                this.fireFocusChanged(this.screen, 1, 16, 2048);
            }
        }
        this.updateDrawerStates(this.screen, bl);
        this.drawerAnimationManager.setViewSize(this.viewSize, bl);
    }

    private void updateDrawerStates(AbstractScreenWidget abstractScreenWidget, boolean bl) {
        lcD.log(10000000, "DrawerFocusManager#updateDrawerStates screen=%1, animate=%2", (Object)abstractScreenWidget, (Object)bl);
        this.updateClosedDrawerIconVisibility();
        boolean bl2 = this.shouldShowEntertainmentDrawer(abstractScreenWidget);
        int n = bl2 ? 1 : 2;
        int n2 = this.state == 32 ? 0 : n;
        IDrawerControllerEvo iDrawerControllerEvo = this.getDrawer(32);
        if (iDrawerControllerEvo != null) {
            iDrawerControllerEvo.setDisplayDrawerState(n2, bl && iDrawerControllerEvo.isConnected(), true);
        }
        this.updateDrawerStateChoiceModel();
        this.drawerAnimationManager.setDrawerState(this.state, true);
    }

    private void updateDrawerStateChoiceModel() {
        ChoiceModelGUI choiceModelGUI;
        if (this.drawerStateWrittenToChoiceModel != this.state && (choiceModelGUI = (ChoiceModelGUI)((Object)AbstractWidget.hmiService.getModel(535))) != null) {
            choiceModelGUI.itemSelected(this.state, this.terminal.getTerminalID());
            this.drawerStateWrittenToChoiceModel = this.state;
        }
    }

    private void updateClosedDrawerIconVisibility() {
        boolean bl;
        lcD.log(10000000, "DrawerFocusManager#updateClosedDrawerIconVisibility");
        boolean bl2 = this.shouldShowSideDrawerIcons(this.screen);
        if (this.selectionDrawer != null) {
            bl = this.selectionDrawer.canOpen();
            lcD.log(10000000, "DrawerFocusManager#updateClosedDrawerIconVisibility selection drawer can open: %1", bl);
            this.selectionDrawer.setClosedIconVisible(bl2 && bl);
        }
        if (this.optionDrawer != null) {
            this.optionDrawer.setClosedIconVisible(bl2);
        }
        bl = this.shouldShowEntertainmentDrawer(this.screen);
        if (this.entertainmentDrawer != null) {
            this.entertainmentDrawer.setClosedIconVisible(bl);
        }
        lcD.log(10000000, "DrawerFocusManager#updateClosedDrawerIconVisibility drawer closed icon visibility: side drawers: %1, entertainment drawer %2", bl2, bl);
    }

    private void fireFocusChangedScreen(AbstractScreenWidget abstractScreenWidget, int n, int n2, int n3) {
        if (n == 1) {
            this.fireFocusChanged(abstractScreenWidget, 1, n2, n3);
            return;
        }
        if (abstractScreenWidget != null && this.isMainAreaFocusable(abstractScreenWidget.getMainArea())) {
            this.fireFocusChanged(abstractScreenWidget, 2, n2, n3);
        }
    }

    private void fireFocusChanged(int n, int n2, int n3) {
        IDrawerControllerEvo iDrawerControllerEvo;
        if (n == n2 && !DrawerFocusUtil.isPartialPopupShown(n3) && !DrawerFocusUtil.isPartialPopupHidden(n3)) {
            return;
        }
        if (DrawerFocusUtil.isPartialPopupShown(n3) || DrawerFocusUtil.isPartialPopupHidden(n3)) {
            int n4 = n2 == 16 ? 2 : 1;
            this.fireFocusChangedScreen(this.screen, n4, n2, n3);
            return;
        }
        if (n == 16) {
            this.fireFocusChangedScreen(this.screen, 1, n2, n3);
        } else {
            iDrawerControllerEvo = this.getDrawer(n);
            this.fireFocusChanged(iDrawerControllerEvo, 1, n2, n3);
        }
        if (n2 == 16) {
            this.fireFocusChangedScreen(this.screen, 2, n2, n3);
        } else {
            iDrawerControllerEvo = this.getDrawer(n2);
            this.fireFocusChanged(iDrawerControllerEvo, 2, n2, n3);
        }
    }

    private void fireFocusChanged(ScreenAreaFocus screenAreaFocus, int n, int n2, int n3) {
        if (screenAreaFocus == null) {
            lc.log(10000000, "DrawerFocusManager#fireFocusChanged focusEvent: %1 drawerState:%2 reasonMask: %3", (long)n, (long)n2, (long)n3);
            return;
        }
        if (lc.isDebug()) {
            lc.log(10000000, "DrawerFocusManager#fireFocusChanged focusEvent: %1 drawerState:%2 screenAreaFocus: %3 reasonMask: %4", (Object)Util.createInteger(n), (Object)Util.createInteger(n2), (Object)screenAreaFocus, (long)n3);
        }
        screenAreaFocus.focusChanged(n, n2, n3);
    }

    public static String getStateName(int n) {
        switch (n) {
            case 16: {
                return "MAIN";
            }
            case 4: {
                return "SELECTION_MENU";
            }
            case 8: {
                return "OPTION_MENU";
            }
            case 32: {
                return "ENTERTAINMENT_MENU";
            }
        }
        return new StringBuffer().append("UNKNOWN_STATE").append(n).toString();
    }

    public void processKeyEvent(KeyEvent keyEvent) {
        lc.log(10000000, "[DrawerFocusManager].processKeyEvent(%1)", (Object)keyEvent);
        logWidgetPerformance.log(1000000, "DrawerFocusManager#processKeyEvent start, event: %1", (Object)keyEvent);
        long l = AbstractWidget.framework.getMonotonicTime();
        switch (keyEvent.getID()) {
            case 10401: {
                LockingManager.userInput();
                this.blockOptionDrawerAnimation();
                this.keyPressed(keyEvent);
                this.checkForUnblockingOptionDrawerAnimation();
                break;
            }
            case 10402: {
                this.keyReleased(keyEvent);
                break;
            }
            case 10403: {
                if (keyEvent instanceof WheelButtonEvent) {
                    LockingManager.userInput();
                    this.keyTurned((WheelButtonEvent)keyEvent);
                    break;
                }
                lc.log(100000, "[DrawerFocusManager].processKeyEvent(%1) - unsupported event type", (Object)keyEvent);
                break;
            }
            case 10404: {
                if (keyEvent instanceof JoystickEvent) {
                    if (keyEvent.getID() != 76) {
                        LockingManager.userInput();
                    }
                    this.blockOptionDrawerAnimation();
                    this.keyMoved((JoystickEvent)keyEvent);
                    this.checkForUnblockingOptionDrawerAnimation();
                    break;
                }
                lc.log(100000, "[DrawerFocusManager].processKeyEvent(%1) - unsupported event type", (Object)keyEvent);
                break;
            }
            default: {
                lc.log(100000, "[DrawerFocusManager].processKeyEvent(%1) - unknown key event type", (Object)keyEvent);
            }
        }
        long l2 = AbstractWidget.framework.getMonotonicTime();
        logWidgetPerformance.log(1000000, "DrawerFocusManager#processKeyEvent finished, took %1 ms", l2 - l);
    }

    private void checkForUnblockingOptionDrawerAnimation() {
        if (((HMITerminalEvo)((Object)this.terminal)).getSkin() == 1 && this.terminal.getViewSizeManager().getRequestedViewSize() == -1 && !this.terminal.getIAnimationController().isAnimationRunning(57) && !this.terminal.getIAnimationController().isAnimationRunning(56)) {
            this.terminal.getIAnimationController().setAnimationBlocked(53, false);
        }
    }

    private void blockOptionDrawerAnimation() {
        if (((HMITerminalEvo)((Object)this.terminal)).getSkin() == 1) {
            IMMICombiAnimationSyncer iMMICombiAnimationSyncer = ((AbstractAnimationController)this.terminal.getIAnimationController()).getAnimationSyncer();
            if (iMMICombiAnimationSyncer != null && !iMMICombiAnimationSyncer.isAnimationPlanActive()) {
                iMMICombiAnimationSyncer.activateNewAnimationPlan();
            }
            this.terminal.getIAnimationController().setAnimationBlocked(53, true);
        }
    }

    public void processTouchPadEvent(TouchEvent touchEvent) {
        logWidgetPerformance.log(1000000, "DrawerFocusManager#processTouchPadEvent start, event: %1", (Object)touchEvent);
        long l = AbstractWidget.framework.getMonotonicTime();
        LockingManager.userInput();
        lcD.log(10000000, "[DrawerFocusManager].processTouchPadEvent(%1)", (Object)touchEvent);
        switch (touchEvent.getID()) {
            case 10908: {
                this.touchPadCharactersRecognized(touchEvent);
                break;
            }
            case 10910: {
                this.touchPadAbandoned(touchEvent);
                break;
            }
            case 10909: {
                this.touchPadApproached(touchEvent);
                break;
            }
            case 10904: 
            case 10906: 
            case 10907: {
                this.touchPadPressed(touchEvent);
                break;
            }
            case 10905: {
                this.touchPadReleased(touchEvent);
                break;
            }
            case 10911: 
            case 10912: 
            case 10913: {
                this.touchPadPositionMoved(touchEvent);
                break;
            }
            case 10914: {
                this.touchPadPalmRecognized(touchEvent);
                break;
            }
            default: {
                lc.log(100000, "[DrawerFocusManager].processTouchPadEvent(%1) - unknown touch pad event type", (Object)touchEvent);
            }
        }
        long l2 = AbstractWidget.framework.getMonotonicTime();
        logWidgetPerformance.log(1000000, "DrawerFocusManager#processTouchPadEvent finished, took %1 ms", l2 - l);
    }

    public void processGestureEvent(GestureEvent gestureEvent) {
        lcD.log(1000000, "DrawerFocusManager#processGestureEvent start, event: %1", (Object)gestureEvent);
        LockingManager.userInput();
        if (this.partialPopupManager != null) {
            this.partialPopupManager.setFocusedLayer(1);
            this.partialPopupManager.triggerGestureEvent(gestureEvent);
            this.partialPopupManager.setFocusedLayer(-1);
        }
        if (gestureEvent.isConsumed()) {
            lc.log(10000000, "DrawerFocusManager#processGestureEvent event: %1 consumed by partialPopupManager (LAYER_IN_FRONT_OF_DRAWERS)", (Object)gestureEvent);
            return;
        }
        ScreenAreaFocus screenAreaFocus = this.getFocusMainArea();
        if (screenAreaFocus != null) {
            if (this.screen.isEventBlocked(gestureEvent)) {
                lc.log(10000000, "DrawerFocusManager#processGestureEvent event: %1 not sent to current focused main area, because main area is locked", (Object)gestureEvent);
            } else {
                screenAreaFocus.triggerGestureEvent(gestureEvent);
            }
        }
    }

    public void requestDrawerClose(int n) {
        lcD.log(10000000, "DrawerFocusManager#requestDrawerClose requesting to close drawer(s) %1, current state %2, current drawerCloseRequest=%3", (long)n, (long)this.state, (long)this.drawerCloseRequest);
        if ((n & this.state) == 0) {
            lcD.log(10000000, "DrawerFocusManager#requestDrawerClose request ignored because drawer(s) already closed");
            return;
        }
        this.drawerCloseRequest |= n;
        lcD.log(10000000, "DrawerFocusManager#requestDrawerClose setting drawerCloseRequest to %1", (long)this.drawerCloseRequest);
        if ((n & 8) != 0 && this.screenData != null) {
            lcD.log(10000000, "DrawerFocusManager#requestDrawerClose set persistent option drawer state to closed state, screen=%1", (Object)this.screenData);
            Comparable comparable = this.getFocusedIndexOfDrawer((DrawerController)this.getDrawer(8));
            this.setPersistenceOptionDrawerState(this.screenData, 2, comparable);
        }
        this.restartDrawerClosingWatchdog();
    }

    private void restartDrawerClosingWatchdog() {
        if (this.drawerClosingWatchdog == null) {
            lc.log(10000000, "DrawerFocusManager#restartDrawerClosingWatchdog creating watchdog");
            this.drawerClosingWatchdog = AbstractWidget.framework.getErrorMgr().createWatchDog(8000L, new DrawerClosingTimeoutAlarm(), "DrawerClosingWatchdog", 0, 1, 0, false);
        } else {
            lc.log(10000000, "DrawerFocusManager#restartDrawerClosingWatchdog restarting watchdog");
            this.drawerClosingWatchdog.restart();
        }
    }

    private void stopDrawerClosingWatchdog() {
        lcD.log(10000000, "DrawerFocusManager#stopDrawerClosingWatchdog");
        if (this.drawerClosingWatchdog != null) {
            lc.log(10000000, "DrawerFocusManager#stopDrawerClosingWatchdog cancel");
            this.drawerClosingWatchdog.cancel();
        }
    }

    public boolean isDrawerClosingRequested(int n) {
        boolean bl = (this.drawerCloseRequest & n) != 0;
        lcD.log(10000000, "DrawerFocusManager#isDrawerCloseRequested checking drawer %1: %2", (Object)DrawerFocusManager.getStateName(n), (Object)bl);
        return bl;
    }

    private void clearDrawerCloseFlags() {
        switch (this.state) {
            case 16: {
                this.clearDrawerCloseFlags(44);
                break;
            }
            case 4: {
                this.clearDrawerCloseFlags(40);
                break;
            }
            case 8: {
                this.clearDrawerCloseFlags(36);
                break;
            }
            case 32: {
                this.clearDrawerCloseFlags(12);
                break;
            }
            default: {
                lcD.log(10000, "DrawerFocusManager#clearDrawerCloseFlags No case defined for state = %1", (long)this.state);
            }
        }
    }

    private void clearDrawerCloseFlags(int n) {
        int n2 = this.drawerCloseRequest;
        this.drawerCloseRequest &= ~n;
        lcD.log(10000000, "DrawerFocusManager#clearDrawerCloseFlags removing flags %1, drawerCloseRequest: %2 -> %3", (long)n, (long)n2, (long)this.drawerCloseRequest);
        if (n2 != 0 && this.drawerCloseRequest == 0) {
            this.stopDrawerClosingWatchdog();
        }
    }

    public void setUsePersistence(boolean bl) {
        this.usePersistence = bl;
    }

    public boolean isUsePersistence() {
        return this.usePersistence;
    }

    public IDrawerControllerEvo getLastValidOptionDrawer() {
        return this.lastValidOptionDrawer;
    }

    public void processDrawerEvent(DrawerEvent drawerEvent) {
        int n = drawerEvent.getAction();
        lc.log(1000000, "DrawerFocusManager#processDrawerEvent action=%1", (long)n);
        if ((n & 2) != 0 && (this.state == 8 || this.partialPopupDrawerOpen) || (n & 1) != 0 && this.state == 4 || (n & 4) != 0 && this.state == 32) {
            lc.log(1000000, "DrawerFocusManager#processDrawerEvent request STATE_MAIN_AREA");
            this.requestDrawerState(16);
            if (this.partialPopupDrawerOpen && this.popupDrawerCloseAction != null) {
                lc.log(1000000, "DrawerFocusManager#processDrawerEvent close popup drawer");
                this.popupDrawerCloseAction.run();
            }
        }
        if ((n & 0x10) != 0 && this.state != 8) {
            lc.log(1000000, "DrawerFocusManager#processDrawerEvent request STATE_OPTION_MENU");
            this.requestDrawerState(8);
        }
        if ((n & 8) != 0 && this.state != 4) {
            lc.log(1000000, "DrawerFocusManager#processDrawerEvent request STATE_SELECTION_MENU");
            this.requestDrawerState(4);
            if (this.partialPopupDrawerOpen && this.popupDrawerCloseAction != null) {
                lc.log(1000000, "DrawerFocusManager#processDrawerEvent close popup drawer");
                this.popupDrawerCloseAction.run();
            }
        }
        if ((n & 0x20) != 0 && this.state != 32) {
            lc.log(100000, "DrawerFocusManager#processDrawerEvent request STATE_ENTERTAINMENT_MENU not implemented!");
        }
    }

    public void registerPopupDrawerAction(Runnable runnable) {
        this.popupDrawerCloseAction = runnable;
    }

    public void reconnectDrawers() {
        screenLogChannel.log(1000000, "DrawerFocusManager#reconnectDrawers. Current screen: %1", (Object)this.screen);
        if (this.screen != null && this.screen.isConnected()) {
            AbstractWidget abstractWidget = this.screen;
            while (abstractWidget.getParent() != null) {
                abstractWidget = abstractWidget.getParent();
            }
            this.reconnectSubtree(abstractWidget);
        }
        this.reconnectDrawer(this.entertainmentDrawer);
        this.reconnectDrawer(this.selectionDrawer);
        this.reconnectDrawer(this.optionDrawer);
    }

    private void reconnectDrawer(IDrawerControllerEvo iDrawerControllerEvo) {
        if (iDrawerControllerEvo != null && iDrawerControllerEvo instanceof AbstractWidget && iDrawerControllerEvo.isConnected()) {
            this.reconnectSubtree((AbstractWidget)((Object)iDrawerControllerEvo));
            ((DrawerController)iDrawerControllerEvo).setConnected(true);
        }
    }

    private void reconnectSubtree(AbstractWidget abstractWidget) {
        InitializationContext initializationContext = abstractWidget.getInitContext();
        InitializationContext initializationContext2 = new InitializationContext(initializationContext);
        initializationContext2.setReinit(false);
        initializationContext2.setStayOnFocusedElement(true);
        initializationContext2.setInitialCursorPosition(-1);
        abstractWidget.predisconnecting();
        abstractWidget.disconnecting();
        abstractWidget.connected(initializationContext2);
    }

    public boolean isDisclaimerActive() {
        return this.disclaimerActive;
    }

    public void setDisclaimerActive(boolean bl) {
        this.disclaimerActive = bl;
        if (bl) {
            this.requestDrawerState(16);
        }
    }

    public void registerDrawerAnimationListener(DrawerAnimationListener drawerAnimationListener) {
        this.drawerAnimationManager.registerListener(drawerAnimationListener);
    }

    public void unregisterDrawerAnimationListener(DrawerAnimationListener drawerAnimationListener) {
        this.drawerAnimationManager.unregisterListener(drawerAnimationListener);
    }

    public DrawerAnimationManager getDrawerAnimationManager() {
        return this.drawerAnimationManager;
    }

    public void closeCurrentOptionDrawer() {
        lc.log(10000000, "DrawerFocusManager#closeCurrentOptionDrawer");
        if (this.state == 8) {
            this.requestDrawerState(16);
        }
        if (this.partialPopupDrawerOpen && this.popupDrawerCloseAction != null) {
            this.popupDrawerCloseAction.run();
        }
    }

    public void initializeDrawerAnimation(DrawerAnimationListener drawerAnimationListener) {
        this.drawerAnimationManager.initializeDrawerAnimation(drawerAnimationListener);
    }

    public void setScreenChangeProgress(float f2) {
        this.drawerAnimationManager.setScreenChangeProgress(f2);
    }

    public void setScreenChangeTarget(int n) {
        this.drawerAnimationManager.setScreenChangeTarget(n);
    }

    public void addDrawerListener(IDrawerListener iDrawerListener) {
        if (!this.drawerListeners.containsKey(iDrawerListener)) {
            this.drawerListeners.put(iDrawerListener, iDrawerListener);
        } else {
            lc.log(10000, "DrawerFocusManager#addDrawerListener IDrawerListener %1 already added.", (Object)iDrawerListener);
        }
    }

    public void removeDrawerListener(IDrawerListener iDrawerListener) {
        if (this.drawerListeners.containsKey(iDrawerListener)) {
            this.drawerListeners.remove(iDrawerListener);
        } else {
            lc.log(10000, "DrawerFocusManager#removeDrawerListener IDrawerListener %1 is not contained.", (Object)iDrawerListener);
        }
    }

    public void reinitScreen(Screen screen) {
        lcD.log(10000000, "DrawerFocusManager#reinitScreen screen=%1", (Object)screen);
        if (!screen.equals(this.screen)) {
            lc.log(10000000, "DrawerFocusManager#reinitScreen current screen %1 not %2", (Object)this.screen, (Object)screen);
            return;
        }
        if (this.isCurrentScreenFocused()) {
            this.fireFocusChangedScreen(this.screen, 2, this.state, 5120);
        }
        this.screenChangeFinished();
    }

    public void changeToCurrentConnectedScreen(boolean bl) {
        lcD.log(10000000, "DrawerFocusManager#changeToCurrentConnectedScreen reinit=%1", bl);
        if (bl && this.isCurrentScreenFocused()) {
            this.fireFocusChanged(this.screen, 1, this.state, 5120);
        }
    }

    public void setOptionIconOffset(int n, int n2) {
        this.drawerAnimationManager.setOptionIconOffset(n, n2);
    }

    public int getDrawerTargetState() {
        return this.targetState;
    }

    public void atLeastOnePartialPopupVisible(boolean bl) {
        int n = 0;
        n = bl ? 64 : 128;
        this.fireFocusChanged(this.state, this.state, n);
    }

    public void setOptionDrawerOpenedDuringScreenChange(boolean bl) {
        this.optionDrawerOpenedDuringScreenChange = bl;
    }

    public void setEarlyEntertainmentDrawerVisibility(boolean bl) {
        this.earlyEntertainmentVisible = bl;
    }

    public void isLockingActive(boolean bl, boolean bl2) {
        if (this.optionDrawer != null) {
            boolean bl3 = this.lockingActive = bl && this.optionDrawer.isBlockedWhileLockingIsActive();
            if (this.lockingActive) {
                this.closeCurrentOptionDrawer();
            } else if (this.optionDrawer.isBlockedWhileLockingIsActive()) {
                logLocking.log(1000000, "DrawerFocusManager#lockingActive locking inactive try to hide notpopup");
                this.hideNotAllowedWhileDrivingPopup();
            }
            logLocking.log(1000000, "DrawerFocusManager#lockingActive inform IDrawerListener lockingActive=%1", this.lockingActive);
            IDrawerListener.CallbackFunction.informListeners(this.drawerListeners, IDrawerListener.CALLBACK_OPTION_DRAWER_LOCKED, new Object[]{this.lockingActive});
        }
    }

    public boolean isInterestedOnTimerEvents() {
        return false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class DrawerClosingTimeoutAlarm
    implements Runnable {
        private DrawerClosingTimeoutAlarm() {
        }

        public void run() {
            if (DrawerFocusManager.this.screen != null && DrawerFocusManager.this.screen.isLocked()) {
                lc.log(1000000, "DrawerFocusManager#DrawerClosingTimeoutAlarm restarting watchdog because screen is locked, screen=%1", (Object)DrawerFocusManager.this.screen);
                DrawerFocusManager.this.restartDrawerClosingWatchdog();
            } else {
                lc.log(10000, "DrawerFocusManager#DrawerClosingTimeoutAlarm closing drawers");
                DrawerFocusManager.this.requestDrawerState(16);
            }
        }
    }
}

