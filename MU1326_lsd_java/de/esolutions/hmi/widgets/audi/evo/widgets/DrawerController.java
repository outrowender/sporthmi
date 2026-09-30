/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.AsyncBitmapEvent;
import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.UnitChangedEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.evo.PropertyObject;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerTitle;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionDrawerPreviewIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DrawerController
extends ContainerController
implements IDrawerControllerEvo {
    private static final int MAX_ITERATIONS = 10;
    protected static final boolean HIDE_CLOSED_ICON = false;
    public static final int CONTENT_TYPE_DEFAULT = 0;
    public static final int CONTENT_TYPE_SPELLER_OPTIONS = 1;
    public static final int HEADER_OFFSET_ENTERTAINMENTDRAWER = 48;
    protected DrawerIcon icon;
    protected DrawerMain main;
    protected DrawerTitle title;
    protected SelectionDrawerPreviewIconController selectionDrawerPreviewIconController;
    private boolean connected = false;
    private int id = -500;
    protected HMIView[][] views;
    protected int[] replacementIDs = null;
    protected HMIView[][] replacementWidgets = null;
    protected AbstractWidget[][] conditionWidgets = null;
    protected PropertyObject[] propertyObjects = null;
    private int[] viewModelIDs;
    private int[] modelIDs;
    private int[] eventIDs;
    private boolean alwaysHideClosedIcon = false;
    private int drawerType = 0;
    protected int currentDrawerState = 1;
    private int screenChangeTarget;
    private int hkReturnEvent = -1;
    private int contentType = 0;
    private boolean remoteHMIDrawerEntries = false;
    private boolean headerVisible;
    private AbstractWidget[] widgetsOfClosedOptionDrawers;
    private boolean blockedWhileLockingIsActive = false;

    public DrawerController() {
    }

    public DrawerController(int n) {
        this.id = n;
    }

    public void setDrawerMain(DrawerMain drawerMain) {
        this.main = drawerMain;
        this.add((AbstractWidget)((Object)drawerMain));
        this.adjustMainAnimationType(this.drawerType);
        this.connectOpenedDrawerWithPreviewIconController();
    }

    public void setDrawerTitle(DrawerTitle drawerTitle) {
        this.title = drawerTitle;
        this.add((AbstractWidget)((Object)drawerTitle));
        this.adjustTitleAnimationType(this.drawerType);
    }

    public void setDrawerIcon(DrawerIcon drawerIcon) {
        this.icon = drawerIcon;
        this.add((AbstractWidget)((Object)drawerIcon));
        if (drawerIcon instanceof ContainerController) {
            this.setSelectionDrawerPreviewIconController(((ContainerController)drawerIcon).getSelectionDrawerPreviewIconController());
        }
        this.adjustClosedDrawerAnimationType(this.drawerType);
    }

    public void setSelectionDrawerPreviewIconController(SelectionDrawerPreviewIconController selectionDrawerPreviewIconController) {
        this.selectionDrawerPreviewIconController = selectionDrawerPreviewIconController;
        this.adjustPreviewIconsAnimationType(this.drawerType);
        this.connectOpenedDrawerWithPreviewIconController();
    }

    private void connectOpenedDrawerWithPreviewIconController() {
        if (this.main == null || this.selectionDrawerPreviewIconController == null) {
            return;
        }
        if (!(this.main instanceof SelectionMenuController)) {
            return;
        }
        SelectionMenuController selectionMenuController = (SelectionMenuController)this.main;
        selectionMenuController.setPreviewIcons(this.selectionDrawerPreviewIconController);
    }

    public DrawerMain getDrawerMain() {
        return this.main;
    }

    public DrawerIcon getDrawerIcon() {
        return this.icon;
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (this.main != null) {
            this.main.keyPressed(keyEvent);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (this.main != null) {
            this.main.keyReleased(keyEvent);
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.main != null) {
            this.main.keyTurned(wheelButtonEvent);
        }
    }

    public void triggerRepaint() {
        if (this.terminal != null) {
            if (this.terminal.getRootWindow().getCurrentScreen() != null) {
                ((AbstractScreenWidget)this.terminal.getRootWindow().getCurrentScreen()).doCheckedRepaint();
            } else {
                this.terminal.getRootWindow().repaint();
            }
        } else {
            logChannel.log(10000, "SimpleDrawerController#triggerRepaint terminal is null repaint is ignored at screen with ID %1", (long)this.id);
        }
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        if (this.main != null) {
            this.main.keyMoved(joystickEvent);
        }
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        if (this.main != null) {
            this.main.touchPadPressed(touchEvent);
        }
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        if (this.main != null) {
            this.main.touchPadReleased(touchEvent);
        }
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (this.main != null) {
            this.main.touchPadPositionMoved(touchEvent);
        }
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        if (this.main != null) {
            this.main.touchPadCharactersRecognized(touchEvent);
        }
    }

    public void touchPadPalmRecognized(TouchEvent touchEvent) {
        if (this.main != null) {
            this.main.touchPadPalmRecognized(touchEvent);
        }
    }

    public void touchPadApproached(TouchEvent touchEvent) {
        if (this.main != null) {
            this.main.touchPadApproached(touchEvent);
        }
    }

    public void touchPadAbandoned(TouchEvent touchEvent) {
        if (this.main != null) {
            this.main.touchPadAbandoned(touchEvent);
        }
    }

    public void screenChangeFinished() {
        logScreenChange.log(1000000, "DrawerController#screenChangeFinished this=%1", (Object)this);
        if (this.drawerType == 2 && this.main != null) {
            this.main.screenChangeFinished();
        }
    }

    public HMIView[] getViews() {
        LinkedList linkedList = new LinkedList();
        if (this.views != null) {
            for (int i2 = 0; i2 < this.views.length; ++i2) {
                if (this.views[i2] == null) continue;
                for (int i3 = 0; i3 < this.views[i2].length; ++i3) {
                    if (this.views[i2][i3] == null) continue;
                    linkedList.add(this.views[i2][i3]);
                }
            }
        }
        return (HMIView[])linkedList.toArray(new HMIView[linkedList.size()]);
    }

    public void setViews(int[] nArray, HMIView[][] hMIViewArray) {
        this.views = hMIViewArray;
        this.viewModelIDs = nArray;
    }

    public void setConditionWidgets(int[] nArray, AbstractWidget[][] abstractWidgetArray) {
        this.conditionIDs = nArray;
        this.conditionWidgets = abstractWidgetArray;
    }

    public int[] getConditionIDs() {
        return this.conditionIDs;
    }

    public int[] getReplacementIDs() {
        return this.replacementIDs;
    }

    public void setReplacementWidgets(int[] nArray, HMIView[][] hMIViewArray) {
        this.replacementIDs = nArray;
        this.replacementWidgets = hMIViewArray;
    }

    public int getPriority() {
        return 0;
    }

    public void disconnecting() {
        logWidgetPerformance.log(1000000, "DrawerController#disconnecting id %1 start", (long)this.id);
        long l = framework.getMonotonicTime();
        super.disconnecting();
        this.connected = false;
        long l2 = framework.getMonotonicTime();
        logWidgetPerformance.log(1000000, "DrawerController#disconnecting id %1 finished, took %2 ms", (long)this.id, l2 - l);
    }

    public void connected(IScreenData iScreenData) {
        logWidgetPerformance.log(1000000, "DrawerController#connected id %1 start", (long)this.id);
        long l = framework.getMonotonicTime();
        this.initContext = null;
        if (this.initContext == null) {
            this.initContext = new InitializationContext(this.terminal);
            this.initContext.setScreenFactory(this.screenFactory);
            this.initContext.setContextIDs(iScreenData.getContextIDs());
            this.initContext.setScreenID(this.getID());
            this.initContext.setScreen(this);
        }
        this.initContext.setReinit(iScreenData.isReinit());
        super.connected(this.initContext);
        long l2 = framework.getMonotonicTime();
        logWidgetPerformance.log(1000000, "DrawerController#connected id %1 finished, took %2 ms", (long)this.id, l2 - l);
    }

    public void setScreenFactory(AbstractScreenFactory abstractScreenFactory) {
        this.screenFactory = abstractScreenFactory;
    }

    protected void initializeWidget() {
        this.executeAllConditions();
    }

    protected void executeAllConditions() {
        if (this.conditionIDs != null) {
            for (int i2 = 0; i2 < this.conditionIDs.length; ++i2) {
                HMIView[] hMIViewArray = this.conditionWidgets[i2];
                if (this.isOptionDrawer()) {
                    hMIViewArray = this.findWidgetsOfClosedOptionDrawer((AbstractWidget[])hMIViewArray);
                }
                try {
                    this.screenFactory.executeCondition(this.conditionIDs[i2], this.id, hMIViewArray, this.terminal.getTerminalID());
                    continue;
                }
                catch (NullPointerException nullPointerException) {
                    screenLogChannel.log(1000, "DrawerController#executeAllConditions problems executing condition for model id: %1 screenID: %2", (long)this.conditionIDs[i2], (long)this.id);
                }
            }
        }
    }

    public int getID() {
        return this.id;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent.getModelType() == 100) {
            ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
            for (int i2 = 0; i2 < modelUpdateEventArray.length; ++i2) {
                if (!this.propagateModelUpdateEvent(modelUpdateEventArray[i2], IWidgetLogChannel.logDrawer)) continue;
                modelUpdateEvent.setConsumed(true);
            }
        } else if (this.propagateModelUpdateEvent(modelUpdateEvent, IWidgetLogChannel.logDrawer)) {
            modelUpdateEvent.setConsumed(true);
        }
    }

    protected boolean propagateModelUpdateEvent(ModelUpdateEvent modelUpdateEvent, LogChannel logChannel) {
        HMIView[] hMIViewArray;
        HMIView[] hMIViewArray2;
        if (modelUpdateEvent == null) {
            logChannel.log(10000, "SimpleDrawer#propagateModelUpdateEvent modelUpdateEvent is: %1", (Object)modelUpdateEvent);
            return false;
        }
        boolean bl = false;
        int n = modelUpdateEvent.getModelId();
        HMIView[] hMIViewArray3 = this.findViews(n);
        if (hMIViewArray3 != null) {
            for (int i2 = 0; i2 < hMIViewArray3.length; ++i2) {
                if (this == hMIViewArray3[i2]) continue;
                hMIViewArray3[i2].processModelUpdateEvent(modelUpdateEvent);
                bl = true;
            }
        }
        if ((hMIViewArray2 = this.findConditionWidgets(n)) != null) {
            this.screenFactory.executeCondition(n, this.id, hMIViewArray2, this.terminal.getTerminalID());
            bl = true;
        }
        if ((hMIViewArray = this.findReplacementWidgets(n)) != null) {
            for (int i3 = 0; i3 < hMIViewArray.length; ++i3) {
                ((AbstractWidget)hMIViewArray[i3]).processTextReplacementUpdateEvent();
                bl = true;
            }
        }
        return bl;
    }

    public HMIView[] findViews(int n) {
        return this.findWidgets(this.views, this.viewModelIDs, n);
    }

    protected AbstractWidget[] findConditionWidgets(int n) {
        AbstractWidget[] abstractWidgetArray = (AbstractWidget[])this.findWidgets(this.conditionWidgets, this.conditionIDs, n);
        if (abstractWidgetArray != null && this.isOptionDrawer()) {
            return this.findWidgetsOfClosedOptionDrawer(abstractWidgetArray);
        }
        return abstractWidgetArray;
    }

    protected AbstractWidget[] findWidgetsOfClosedOptionDrawer(AbstractWidget[] abstractWidgetArray) {
        if (this.widgetsOfClosedOptionDrawers == null || this.widgetsOfClosedOptionDrawers.length < abstractWidgetArray.length) {
            this.widgetsOfClosedOptionDrawers = new AbstractWidget[abstractWidgetArray.length];
        }
        for (int i2 = 0; i2 < abstractWidgetArray.length; ++i2) {
            AbstractWidget abstractWidget = abstractWidgetArray[i2];
            if (abstractWidget != null && abstractWidget.getPartOfOptionDrawer() == 0) {
                int n = this.calculatePartOfOptionDrawer(abstractWidget);
                abstractWidget.setPartOfOptionDrawer(n);
            }
            this.widgetsOfClosedOptionDrawers[i2] = abstractWidget != null && abstractWidget.getPartOfOptionDrawer() == 1 ? abstractWidget : null;
        }
        return this.widgetsOfClosedOptionDrawers;
    }

    private boolean isOptionDrawer() {
        return this.propertyObjects != null && this.propertyObjects.length > 0;
    }

    private int calculatePartOfOptionDrawer(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof MenuController || this.hasMenuControllerChild(abstractWidget) || this.hasMenuControllerParent(abstractWidget)) {
            return 2;
        }
        return 1;
    }

    private boolean hasMenuControllerChild(AbstractWidget abstractWidget) {
        List list = abstractWidget.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (!(list.get(i2) instanceof MenuController)) continue;
            return true;
        }
        return false;
    }

    private boolean hasMenuControllerParent(AbstractWidget abstractWidget) {
        AbstractWidget abstractWidget2 = abstractWidget.getParent();
        for (int n = 0; abstractWidget2 != null && !(abstractWidget2 instanceof DrawerController) && n < 10; abstractWidget2 = abstractWidget2.getParent(), ++n) {
            if (!(abstractWidget2 instanceof MenuController)) continue;
            return true;
        }
        return false;
    }

    protected HMIView[] findReplacementWidgets(int n) {
        return this.findWidgets(this.replacementWidgets, this.replacementIDs, n);
    }

    public void setPropertyObjects(PropertyObject[] propertyObjectArray) {
        this.propertyObjects = propertyObjectArray;
    }

    public PropertyObject[] getPropertyObjects() {
        return this.propertyObjects;
    }

    private HMIView[] findWidgets(HMIView[][] hMIViewArray, int[] nArray, int n) {
        int n2;
        if (hMIViewArray != null && nArray != null && (n2 = Arrays.binarySearch(nArray, n)) >= 0) {
            return hMIViewArray[n2];
        }
        return null;
    }

    public void processSDSEvent(SDSEvent sDSEvent) {
    }

    public void setTerminal(HMITerminal hMITerminal) {
        this.terminal = (HMITerminalImpl)hMITerminal;
    }

    public void setState(int[] nArray) {
    }

    public HMITerminal getTerminal() {
        return this.terminal;
    }

    public int getTerminalID() {
        if (this.terminal != null) {
            return this.terminal.getTerminalID();
        }
        return 0;
    }

    public void setLocked(boolean bl) {
    }

    public AbstractScreenFactory getScreenFactory() {
        return this.screenFactory;
    }

    public void paint() {
        RedrawContext redrawContext = this.terminal.getRedrawContext();
        this.managePaint(redrawContext);
    }

    public int getEventProcessing() {
        return 0;
    }

    public int getCacheBehaviour() {
        return 0;
    }

    public int getEventID(int n) {
        int n2;
        if (this.modelIDs != null && this.eventIDs != null && this.modelIDs.length > 0 && this.modelIDs.length == this.eventIDs.length && (n2 = Arrays.binarySearch(this.modelIDs, n)) >= 0) {
            return this.eventIDs[n2];
        }
        return -1;
    }

    public void setModelIDs(int[] nArray) {
        this.modelIDs = nArray;
    }

    public void setEventIDs(int[] nArray) {
        this.eventIDs = nArray;
    }

    public boolean hasErrorOccured() {
        return false;
    }

    public int getScreenType() {
        return 0;
    }

    public void setScreenType(int n) {
    }

    public int[] getViewIDs() {
        return this.viewModelIDs;
    }

    public void showPartialPopups(int[] nArray) {
    }

    public void hidePartialPopups(int[] nArray) {
    }

    public void hideNotScreenChangeSurvivingPopups() {
    }

    public void unitsChanged(UnitChangedEvent unitChangedEvent) {
    }

    public void bitmapLoaded(AsyncBitmapEvent asyncBitmapEvent) {
    }

    public boolean isPartialPopupBlocked(IPartialPopupController iPartialPopupController) {
        return false;
    }

    public boolean areAllPartialPopupsAllowed() {
        return false;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void setConnected(boolean bl) {
        this.connected = bl;
    }

    public void setClosedIconVisible(boolean bl) {
        this.alwaysHideClosedIcon = !bl;
    }

    public boolean isClosedIconVisible() {
        return !this.alwaysHideClosedIcon;
    }

    public void setScreenChangeProgress(float f2) {
        if (logScreenChange.isDebug2()) {
            logScreenChange.log(100000000, "DrawerController#setScreenChangeProgress this=%1, progress=%2", (Object)this, (Object)new Float(f2));
        }
        if (!(this.main instanceof SelectionMenuController) && this.drawerType != 2) {
            super.setScreenChangeProgress(f2);
        }
    }

    public void setScreenChangeTarget(int n) {
        this.screenChangeTarget = n;
        if (this.drawerType == 2 || this.drawerType == 1) {
            if (this.main != null) {
                this.main.setScreenChangeTarget(n);
            }
            if (this.icon != null) {
                this.icon.setScreenChangeTarget(n);
            }
        }
    }

    public HMIView[][] getReplacementWidgets() {
        return this.replacementWidgets;
    }

    public void setDrawerType(int n) {
        this.drawerType = n;
        this.adjustMainAnimationType(n);
        this.adjustClosedDrawerAnimationType(n);
        this.adjustTitleAnimationType(n);
        this.adjustPreviewIconsAnimationType(n);
    }

    private void adjustMainAnimationType(int n) {
        if (this.main != null) {
            switch (n) {
                case 2: {
                    this.main.setAnimationType(53);
                    this.main.setDrawerAnimationMask(4100);
                    break;
                }
                case 1: {
                    this.main.setAnimationType(52);
                    this.main.setDrawerAnimationMask(4097);
                    break;
                }
                case 3: {
                    this.main.setAnimationType(58);
                    this.main.setDrawerAnimationMask(16);
                    break;
                }
            }
        }
    }

    private void adjustClosedDrawerAnimationType(int n) {
        if (this.icon != null) {
            switch (n) {
                case 2: {
                    this.icon.setAnimationType(55);
                    this.icon.setDrawerAnimationMask(4136);
                    break;
                }
                case 1: {
                    this.icon.setAnimationType(54);
                    this.icon.setDrawerAnimationMask(4151);
                    break;
                }
                case 3: {
                    this.icon.setAnimationType(59);
                    break;
                }
            }
        }
    }

    private void adjustTitleAnimationType(int n) {
        if (this.title != null) {
            switch (n) {
                case 2: {
                    this.title.setAnimationType(53);
                    break;
                }
                case 1: {
                    this.title.setAnimationType(52);
                    break;
                }
                case 3: {
                    this.title.setAnimationType(58);
                    break;
                }
            }
        }
    }

    private void adjustPreviewIconsAnimationType(int n) {
        if (this.selectionDrawerPreviewIconController != null) {
            switch (n) {
                case 2: {
                    this.selectionDrawerPreviewIconController.setAnimationType(55);
                    this.selectionDrawerPreviewIconController.setDrawerAnimationMask(4104);
                    break;
                }
                case 1: {
                    this.selectionDrawerPreviewIconController.setAnimationType(54);
                    this.selectionDrawerPreviewIconController.setDrawerAnimationMask(4098);
                    break;
                }
                case 3: {
                    this.selectionDrawerPreviewIconController.setAnimationType(59);
                    break;
                }
            }
        }
    }

    public void setDisplayDrawerState(int n, boolean bl, boolean bl2) {
        bl = bl && this.isConnected();
        switch (n) {
            case 0: 
            case 3: {
                if (this.icon != null) {
                    this.icon.hideDrawerItem(bl, bl2);
                }
                if (this.selectionDrawerPreviewIconController != null) {
                    this.selectionDrawerPreviewIconController.hideDrawerItem(false, bl2);
                }
                if (this.main == null) break;
                this.main.showDrawerItem(bl, bl2);
                break;
            }
            case 1: 
            case 4: 
            case 6: {
                if (this.main != null) {
                    this.main.hideDrawerItem(bl, bl2);
                }
                if (this.icon != null) {
                    if (this.alwaysHideClosedIcon) {
                        this.icon.hideDrawerItem(bl, bl2);
                    } else {
                        this.icon.showDrawerItem(bl, bl2);
                    }
                }
                if (this.selectionDrawerPreviewIconController == null) break;
                if (this.alwaysHideClosedIcon) {
                    this.selectionDrawerPreviewIconController.hideDrawerItem(false, bl2);
                    break;
                }
                this.selectionDrawerPreviewIconController.showDrawerItem(false, bl2);
                break;
            }
            case 2: {
                if (this.icon != null) {
                    this.icon.hideDrawerItem(bl, true);
                }
                if (this.selectionDrawerPreviewIconController != null) {
                    this.selectionDrawerPreviewIconController.hideDrawerItem(false, bl2);
                }
                if (this.main == null) break;
                this.main.hideDrawerItem(bl, bl2);
                break;
            }
            default: {
                logDrawer.log(10000, "DrawerController#setDisplayDrawerState: unknown drawer state: %1", (long)n);
            }
        }
        this.currentDrawerState = n;
    }

    public int getDisplayDrawerState() {
        return this.currentDrawerState;
    }

    public void updateContexts(long[] lArray) {
    }

    public void setMMICombiSyncMode(int n) {
        if (this.main != null) {
            this.main.setMMICombiSyncMode(n);
        }
        if (this.title != null) {
            this.title.setMMICombiSyncMode(n);
        }
        if (this.icon != null) {
            this.icon.setMMICombiSyncMode(n);
        }
    }

    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }

    public void processKeyEvent(KeyEvent keyEvent) {
    }

    public void processTouchPadEvent(TouchEvent touchEvent) {
    }

    public void processGestureEvent(GestureEvent gestureEvent) {
    }

    public boolean canOpen() {
        if (this.main != null) {
            return this.remoteHMIDrawerEntries || this.main.canOpen();
        }
        return true;
    }

    public boolean canClose() {
        if (this.main != null) {
            return this.main.canClose();
        }
        return true;
    }

    public boolean isVerticalLineVisible() {
        return false;
    }

    public void setVerticalLineVisible(boolean bl) {
    }

    public void updatedColorScheme(int n) {
    }

    public boolean hasDrawerScreenChangeAnimation() {
        if (this.main instanceof ContainerController) {
            return false;
        }
        ContainerController containerController = (ContainerController)this.main;
        return containerController.hasDrawerScreenChangeAnimation();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("DrawerController [main=");
        buffer.append(this.main);
        buffer.append(", id=");
        buffer.append(this.id);
        buffer.append("]");
        return buffer.toString();
    }

    public int[] getCurrentColorPalette() {
        return new int[0];
    }

    public int getScreenChangeTarget() {
        return this.screenChangeTarget;
    }

    public int getCurrentAudioSource() {
        return -1;
    }

    public int[] getHmiAppsToNotifyForVisibility() {
        return new int[0];
    }

    public void setTransitionForward(boolean bl) {
    }

    public void setHKReturnEvent(int n) {
        this.hkReturnEvent = n;
    }

    public int getHkReturnEvent() {
        return this.hkReturnEvent;
    }

    public boolean hasIdleTimer() {
        if (this.main instanceof SelectionMenuController) {
            return this.main.hasIdleTimer();
        }
        return super.hasIdleTimer();
    }

    public void restartIdleTimer() {
        if (this.main instanceof SelectionMenuController) {
            this.main.restartIdleTimer();
            return;
        }
        super.restartIdleTimer();
    }

    public void cancelIdleTimer() {
        if (this.main instanceof SelectionMenuController) {
            this.main.cancelIdleTimer();
            return;
        }
        super.cancelIdleTimer();
    }

    public int getContentType() {
        return this.contentType;
    }

    public void setContentType(int n) {
        this.contentType = n;
    }

    public boolean isHeaderVisible() {
        return this.headerVisible;
    }

    public void setHeaderVisible(boolean bl) {
        if (this instanceof EntertainmentDrawerContentController) {
            this.headerVisible = bl;
            ((EntertainmentDrawerContentController)this).updateTargetState();
            if (this.title instanceof ContainerController) {
                ((ContainerController)this.title).setVisible(bl);
            }
        }
    }

    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
    }

    public boolean isSDSAudioSource(int n) {
        if (this.isEntertainmentDrawerContent() || this instanceof EntertainmentDrawerController) {
            return EntertainmentDrawerContentManager.isSDSAudioSource(n);
        }
        return false;
    }

    public boolean isPhoneAudioSource(int n) {
        if (this.isEntertainmentDrawerContent() || this instanceof EntertainmentDrawerController) {
            return EntertainmentDrawerContentManager.isPhoneAudioSource(n);
        }
        return false;
    }

    public void updateDrawers(IScreenData iScreenData) {
    }

    public void setRemoteHMIDrawerEntries(boolean bl) {
        this.remoteHMIDrawerEntries = bl;
    }

    public boolean hasRemoteHMIDrawerEntries() {
        return this.remoteHMIDrawerEntries;
    }

    public boolean isEntertainmentDrawerContent() {
        return false;
    }

    public void setIsBlockedWhileLockingIsActive(boolean bl) {
        this.blockedWhileLockingIsActive = bl;
    }

    public boolean isBlockedWhileLockingIsActive() {
        return this.blockedWhileLockingIsActive;
    }
}

