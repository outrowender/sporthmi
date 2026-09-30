/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.mmicombi.IMMICombiScreen;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.IOptionIconPositionController;
import de.esolutions.hmi.widgets.audi.evo.LockingManager;
import de.esolutions.hmi.widgets.audi.evo.ViewSizeManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.StatusBarG24Controller;
import de.esolutions.hmi.widgets.audi.evo.widgets.ViewSizeAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.Iterator;

public class ScreenWidgetEVO
extends AbstractScreenWidget
implements IMMICombiScreen {
    public static final float[] BIG_STAGE = new float[]{0.0f};
    public static final float[] SMALL_STAGE = new float[]{1.0f};
    private static final int SDS_MODULE_ID = 14;
    private int mmiCombiContextID = 0;
    private boolean hMIScreen = true;
    private boolean selectionDrawerVisible = true;
    private boolean openSelectionDrawerByHkReturn = false;
    private int hardKeyToConsumeOnOpenDrawer = -1;
    private IPopupKeyConsuptionStrategy keyConsumptionStrategy;
    private boolean optionIconPositionControllerAvailable = false;
    private boolean optionDrawerOpenedDuringScreenChange;

    public ScreenWidgetEVO() {
    }

    public ScreenWidgetEVO(int n) {
        super(n);
    }

    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof IOptionIconPositionController) {
            this.optionIconPositionControllerAvailable = true;
        }
    }

    private ViewSizeAnimationManager getViewSizeAnimationManager() {
        if (this.terminal.getViewSizeManager() instanceof ViewSizeManager) {
            return ((ViewSizeManager)this.terminal.getViewSizeManager()).getViewSizeAnimationManager();
        }
        return null;
    }

    public void setCurrentViewSizeOnWidget(AbstractWidgetController abstractWidgetController) {
        if (this.getViewSizeAnimationManager() != null) {
            this.getViewSizeAnimationManager().setCurrentViewSizeOnWidget(abstractWidgetController);
        }
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.getViewSizeAnimationManager() != null) {
            this.getViewSizeAnimationManager().addScreen(this);
        }
        if (initializationContext != null && initializationContext.isReinit() && this.getTerminalImpl() != null && this.getTerminalImpl().getDrawerFocusManager() != null) {
            this.getTerminalImpl().getDrawerFocusManager().reinitScreen(this);
        }
        this.initCombiSync();
        this.refreshSCDDisplay();
        this.notifySdsOnConnect();
        LockingManager.userInput();
    }

    private void notifySdsOnConnect() {
        if (!this.isNotifySdsForVisibility()) {
            return;
        }
        if (AbstractWidget.sdsService == null) {
            screenLogChannel.log(100000, "ScreenWidgetEVO#notifySdsOnConnect: SDS Service is null (%1)", (Object)this);
            return;
        }
        int n = this.terminal.getTerminalID();
        int n2 = this.getScreenId();
        SDSService.ScreenConnectedSDSData screenConnectedSDSData = new SDSService.ScreenConnectedSDSData();
        screenConnectedSDSData.setSmallStageType(this.getSmallStageType());
        screenLogChannel.log(10000000, "ScreenWidgetEVO#notifySdsOnConnect: screen ID: %1, terminal ID: %2, sdsData: %3", (Object)screenConnectedSDSData, (long)n2, (long)n);
        AbstractWidget.sdsService.screenConnectedWithSDSData(n2, n, screenConnectedSDSData);
    }

    public boolean isNotifySdsForVisibility() {
        int[] nArray = this.getHmiAppsToNotifyForVisibility();
        if (nArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != 14) continue;
            return true;
        }
        return false;
    }

    private void refreshSCDDisplay() {
        IPartialPopupManagerEvo iPartialPopupManagerEvo;
        if (this.terminal.getFramework().getKombiType() == 4 && (iPartialPopupManagerEvo = this.terminal.getPartialPopupManagerEvo()) != null) {
            PartialPopupController partialPopupController = (PartialPopupController)iPartialPopupManagerEvo.getPartialPopup(101);
            this.callScreenConnected(partialPopupController);
        }
    }

    private void callScreenConnected(PartialPopupController partialPopupController) {
        if (partialPopupController != null && partialPopupController.getChild(0) instanceof StatusBarG24Controller) {
            StatusBarG24Controller statusBarG24Controller = (StatusBarG24Controller)partialPopupController.getChild(0);
            statusBarG24Controller.newScreenConnected();
        }
    }

    private void initCombiSync() {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager();
        if (iDrawerFocusManagerEvo != null) {
            DrawerController drawerController = (DrawerController)iDrawerFocusManagerEvo.getSelectionDrawer();
            this.setCombiSyncMode(drawerController);
        }
        this.terminal.getGUIManager().setMMICombiContextID(this.mmiCombiContextID);
    }

    private void setCombiSyncMode(DrawerController drawerController) {
        if (this.isCarSelectionDrawer(drawerController) && !this.selectionDrawerVisible) {
            drawerController.setMMICombiSyncMode(2);
        }
    }

    private boolean isCarSelectionDrawer(DrawerController drawerController) {
        if (drawerController == null) {
            return false;
        }
        int n = drawerController.getID();
        int n2 = n / 100000;
        return n2 == 6;
    }

    public int getEventID(int n) {
        int n2 = -1;
        if (this.terminal != null) {
            IPartialPopupManagerEvo iPartialPopupManagerEvo = this.terminal.getPartialPopupManagerEvo();
            if (iPartialPopupManagerEvo != null) {
                n2 = iPartialPopupManagerEvo.getEventID(n);
            }
            if (n2 == -1) {
                IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager();
                if (iDrawerFocusManagerEvo.getSelectionDrawer() != null) {
                    n2 = ((DrawerController)iDrawerFocusManagerEvo.getSelectionDrawer()).getEventID(n);
                }
                if (n2 == -1 && iDrawerFocusManagerEvo.getOptionDrawer() != null) {
                    n2 = ((DrawerController)iDrawerFocusManagerEvo.getOptionDrawer()).getEventID(n);
                }
            }
            if (n2 == -1) {
                n2 = super.getEventID(n);
            }
        } else {
            n2 = super.getEventID(n);
        }
        return n2;
    }

    public int getMmiCombiContextID() {
        return this.mmiCombiContextID;
    }

    public void setMmiCombiContextID(int n, boolean bl) {
        this.mmiCombiContextID = n;
        this.hMIScreen = bl;
    }

    protected AbstractWidget getCurrentMenu() {
        return this.getCurrentMenu(this);
    }

    private AbstractWidget getCurrentMenu(AbstractWidget abstractWidget) {
        if (!abstractWidget.isVisible()) {
            return null;
        }
        if (abstractWidget instanceof MenuController && abstractWidget.isActive()) {
            return abstractWidget;
        }
        Iterator iterator = abstractWidget.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget2 = (AbstractWidget)iterator.next();
            AbstractWidget abstractWidget3 = this.getCurrentMenu(abstractWidget2);
            if (abstractWidget3 == null) continue;
            return abstractWidget3;
        }
        return null;
    }

    public void setSelectionDrawerVisible(boolean bl) {
        this.selectionDrawerVisible = bl;
    }

    public void disconnecting() {
        if (this.getViewSizeAnimationManager() != null) {
            this.getViewSizeAnimationManager().removeScreen(this);
        }
        super.disconnecting();
    }

    public boolean isHMIScreen() {
        return this.hMIScreen;
    }

    public boolean isOpenSelectionDrawerByHkReturn() {
        return this.openSelectionDrawerByHkReturn;
    }

    public void setOpenSelectionDrawerByHkReturn(boolean bl) {
        this.openSelectionDrawerByHkReturn = bl;
    }

    public int getHardKeyToConsumeOnOpenDrawer() {
        return this.hardKeyToConsumeOnOpenDrawer;
    }

    public void setHardKeyToConsumeOnOpenDrawer(int n) {
        this.hardKeyToConsumeOnOpenDrawer = n;
    }

    public void requestLargeViewSizeIfNeeded() {
        if (this.isHMIScreen()) {
            IViewSizeManager iViewSizeManager;
            super.requestLargeViewSizeIfNeeded();
            if (this.isHMIFullscreenPopup() && (iViewSizeManager = this.terminal.getViewSizeManager()) != null) {
                iViewSizeManager.requestLargeViewSize(12);
            }
        } else {
            IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
            if (iViewSizeManager != null) {
                iViewSizeManager.unrequestLargeViewSize(0);
                iViewSizeManager.unrequestLargeViewSize(1);
                if (this.isKombiFullscreenPopup()) {
                    iViewSizeManager.requestLargeViewSize(13);
                }
            }
        }
    }

    protected void unrequestLargeViewSizeIfNeeded() {
        if (this.isHMIScreen()) {
            IViewSizeManager iViewSizeManager;
            super.unrequestLargeViewSizeIfNeeded();
            if (this.isHMIFullscreenPopup() && (iViewSizeManager = this.terminal.getViewSizeManager()) != null) {
                iViewSizeManager.unrequestLargeViewSize(12);
            }
        } else {
            IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
            if (iViewSizeManager != null) {
                if (this.isKombiFullscreenPopup()) {
                    iViewSizeManager.setLocked(true, false);
                    iViewSizeManager.unrequestLargeViewSize(13);
                    iViewSizeManager.setLocked(false, false);
                }
                iViewSizeManager.releaseInvalidation();
            }
        }
    }

    protected void afterConnect() {
        IViewSizeManager iViewSizeManager;
        super.afterConnect();
        if (this.isHMIScreen() && (iViewSizeManager = this.terminal.getViewSizeManager()) instanceof ViewSizeManager) {
            ((ViewSizeManager)iViewSizeManager).checkForHistoryStateChange();
        }
    }

    public boolean isLargeViewSizeNeeded() {
        return super.isLargeViewSizeNeeded() && !this.isHMIFullscreenPopup();
    }

    protected boolean isHMIFullscreenPopup() {
        boolean bl = this.mmiCombiContextID == 1000;
        return bl &= !this.isLargeViewSizePreferred();
    }

    private boolean isKombiFullscreenPopup() {
        return this.mmiCombiContextID == 1001;
    }

    public void setOptionIconVisible(boolean bl) {
        if (bl != this.isOptionIconVisible()) {
            DrawerAnimationManager drawerAnimationManager;
            DrawerFocusManager drawerFocusManager;
            super.setOptionIconVisible(bl);
            if (this.terminal != null && (drawerFocusManager = (DrawerFocusManager)this.terminal.getDrawerFocusManager()) != null && (drawerAnimationManager = drawerFocusManager.getDrawerAnimationManager()) != null) {
                drawerAnimationManager.showSideOptionIcon(bl);
            }
        }
    }

    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
        this.keyConsumptionStrategy = iPopupKeyConsuptionStrategy;
        this.notifyDrawerAnimationManager();
    }

    private void notifyDrawerAnimationManager() {
        DrawerAnimationManager drawerAnimationManager;
        DrawerFocusManager drawerFocusManager;
        if (this.terminal != null && (drawerFocusManager = (DrawerFocusManager)this.terminal.getDrawerFocusManager()) != null && (drawerAnimationManager = drawerFocusManager.getDrawerAnimationManager()) != null) {
            drawerAnimationManager.updateClosedDrawerIconVisibility();
        }
    }

    public boolean doesHKFilterContainsKey(int n) {
        if (this.keyConsumptionStrategy != null) {
            return this.keyConsumptionStrategy.doesHKFilterContainsKey(n);
        }
        return false;
    }

    public boolean hasOptionIconPositionController() {
        return this.optionIconPositionControllerAvailable;
    }

    public void updateDrawers(IScreenData iScreenData) {
        super.updateDrawers(iScreenData);
        this.initCombiSync();
    }

    public void setOptionDrawerOpenedDuringScreenChange(boolean bl) {
        this.optionDrawerOpenedDuringScreenChange = bl;
    }

    public boolean isOptionDrawerOpenedDuringScreenChange() {
        return this.optionDrawerOpenedDuringScreenChange;
    }
}

