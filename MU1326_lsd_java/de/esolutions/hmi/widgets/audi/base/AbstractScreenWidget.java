/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.ATIPEvent;
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
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.ITouchInputManager;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.timer.Timer;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.audi.tghu.hmi.evo.IScreenEvo;
import de.audi.tghu.hmi.evo.ScreenAreaFocus;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractImageLoader;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IDisplayControllerWidget;
import de.esolutions.hmi.widgets.audi.base.IIdleTimerWidget;
import de.esolutions.hmi.widgets.audi.base.ITouchScreenEventListener;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.ModelEventPropagator;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.SDSEventListener;
import de.esolutions.hmi.widgets.audi.base.ScreenArea;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.WidgetPersistenceManager;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ScreenWidgetRenderer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AbstractScreenWidget
extends AbstractWidgetController
implements IScreenEvo,
ScreenAreaFocus {
    public static final int PROCESS_NOTHING;
    public static final int PROCESS_INC_MENU_ENTER;
    public static final int PROCESS_KEY_BACK;
    public static final int DEFAULT_COLOR_SCHEME;
    public static final int LOCK_ALL;
    public static final int LOCK_DDS_ONLY;
    public static final int LOCK_DDS_HK_RETURN;
    public static final int ANIMATION_TRIGGER_ON_IDLE;
    public static final int PARTIAL_POPUP_BLOCKMODE_ALLOW_ALL;
    public static final int PARTIAL_POPUP_BLOCKMODE_BLOCK_ALL;
    public static final int CLEAR_TRANSPARENT;
    public static final int CLEAR_OPAQUE_BLACK;
    public static final int CLEAR_OPAQUE_IMAGE;
    public static final int ROLE_MAIN_AREA;
    public static final int ROLE_TITLE_AREA;
    public static final int ROLE_SUBTITLE_AREA;
    public static final int ROLE_DEPRECATED_DRAWER_INDEPENDENT_AREA;
    public static final int ROLE_DEPRECATED_SPECIAL_AREA;
    public static final int ROLE_DRAWER_INDEPENDENT_AREA;
    public static final int ROLE_SPECIAL_AREA;
    public static final int ROLE_SPECIAL_AREA_LIST;
    public static final int ROLE_SMALL_STAGE_ICON;
    public static final int DRAWER_VISIBILITY_ALL_VISIBLE;
    public static final int DRAWER_VISIBILITY_CLOSED_SIDE_DRAWERS_NOT_VISIBLE;
    public static final int DRAWER_VISIBILITY_ENTERTAINMENT_DRAWER_NOT_VISIBLE;
    public static final int DRAWER_VISIBILITY_CLOSED_SIDE_DRAWERS_AND_ENTERTAINMENT_NOT_VISIBLE;
    public static final int SMALL_STAGE_ABBREVIATE;
    public static final int SMALL_STAGE_OMISSION;
    public static final int SMALL_STAGE_REPLACE;
    public static final int SMALL_STAGE_SCREENSHOT;
    public static final int SMALL_STAGE_CANCEL;
    public static final int SMALL_STAGE_UNDEFINED;
    public static final int SMALL_STAGE_NO_CHANGE;
    public static final int SMALL_STAGE_WRAP;
    public static final int SMALL_STAGE_SCREENSHOT_FULLSCREEN;
    public static final int SMALL_STAGE_KEEP_VIEWSIZE;
    public static final int SMALL_STAGE_OPT_SCREEN_SMALL_STAGE_PREFERRED;
    protected HMIView[][] views;
    private int defaultSKKeyCode = 0;
    private int skModelId = -1;
    protected int id;
    protected int position;
    protected int priority;
    protected int[] replacementIDs = null;
    protected HMIView[][] replacementWidgets = null;
    protected AbstractWidget[][] conditionWidgets = null;
    private int listenKeyCode = -1;
    protected boolean locked = false;
    private int lockMode = 0;
    private int[] states = null;
    private int screenType = 0;
    private ArrayList idleTimers = null;
    private boolean sdsDialogInProgress = false;
    private IDisplayControllerWidget displayController;
    private long lastModelUpdateTime = 0L;
    protected boolean errorOccured = false;
    protected int cacheBehaviour = 1;
    private int smallStageType = 0;
    private int[] modelIDs;
    private int[] eventIDs;
    private static final int UPDATE_DELTA_TIME;
    private int[] viewModelIDs;
    private int partialPopupBlockMode = 0;
    private int[] partialPopupBlockExceptions = null;
    private boolean connected = false;
    private int clearMethod = 2;
    private static boolean touchPadAvailabilityInitialized;
    private ScreenWidgetRenderer renderer;
    private ScreenMainArea mainArea;
    protected ScreenMainArea titleArea;
    private ScreenArea subtitleArea;
    private ScreenMainArea drawerIndependentArea;
    private ScreenMainArea specialArea;
    private List specialAreas = new ArrayList(1);
    private AbstractWidget selectionMask;
    private AbstractWidget optionMask;
    private AbstractWidget partialPopupMask;
    private int drawerVisibility = 0;
    public static final boolean DEFAULT_TOPLEVEL;
    public static final int DEFAULT_SCREEN_MODE;
    private boolean toplevelScreen = false;
    private int screenMode = 1;
    private int[][] colorPlates;
    private int[] activeColorPlate;
    private boolean paintedWithChangedColorTheme = false;
    private boolean screenPainted = false;
    private boolean largeViewSizePreferred = false;
    private boolean optionIconVisible;
    private boolean disableLeftBack = false;
    private AbstractWidget smallStageIcon;
    private ITouchScreenEventListener touchScreenEventHandler;
    private int[] hmiAppsToNotifyForVisibility;
    private RedrawContext rc;
    private int optionIconOffsetX = 0;
    private int optionIconOffsetY = 0;
    private static boolean firstPaint;
    private static final int[] ERROR_COLOR_PLATE;

    public AbstractScreenWidget() {
        this.role |= 0x100;
        this.setBounds(0, 0, 800, 480);
    }

    public AbstractScreenWidget(int n) {
        this.id = n;
        this.role |= 0x100;
        this.setBounds(0, 0, 800, 480);
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ScreenWidgetRenderer screenWidgetRenderer) {
        this.renderer = screenWidgetRenderer;
    }

    public final String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Screen[id=").append(this.id);
        if (this.terminal != null) {
            buffer.append(",screen=").append(this.terminal.getScreenName(this.id));
        }
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public int[] getConditionIDs() {
        return this.conditionIDs;
    }

    @Override
    public int[] getViewIDs() {
        return this.viewModelIDs;
    }

    public void setConditionModelIds(int[] nArray) {
        this.conditionIDs = nArray;
    }

    public void setConditionWidgets(int[] nArray, AbstractWidget[][] abstractWidgetArray) {
        this.conditionIDs = nArray;
        this.conditionWidgets = abstractWidgetArray;
    }

    public int getDefaultSKKeyCode() {
        if (this.skModelId != -1) {
            HMIModel hMIModel = hmiService.getModel(this.terminal.getTerminalID(), this.skModelId);
            if (hMIModel != null && 2 == hMIModel.getModelType()) {
                int n = ((ChoiceModelGUI)((Object)hMIModel)).getValue();
                switch (n) {
                    case 1: {
                        this.defaultSKKeyCode = 9;
                        break;
                    }
                    case 2: {
                        this.defaultSKKeyCode = 11;
                        break;
                    }
                    case 3: {
                        this.defaultSKKeyCode = 12;
                        break;
                    }
                    case 4: {
                        this.defaultSKKeyCode = 10;
                        break;
                    }
                    case 0: {
                        this.defaultSKKeyCode = 0;
                        break;
                    }
                    default: {
                        screenLogChannel.log(10000, "ScreenWidget#getDefaultSKKeyCode unknown softkeyPosition: %1 in highlightSKModel(id): %2 - taking screen configured softkey: %3", (long)n, (long)this.skModelId, (long)this.defaultSKKeyCode);
                        break;
                    }
                }
            } else {
                screenLogChannel.log(10000, "ScreenWidget#getDefaultSKKeyCode highlightSKModelId: %2 configured but no highlightSoftkeyModel present or not a choice model model: %1 - taking screen configured softkey: %3", this.model, (long)this.skModelId, (long)this.defaultSKKeyCode);
            }
        }
        screenLogChannel.log(-2137614336, "ScreenWidget#getDefaultSKKeyCode skModelId: %1 defaultSKKeyCode: %2", (long)this.skModelId, (long)this.defaultSKKeyCode);
        return this.defaultSKKeyCode;
    }

    public void setDefaultSK(int n) {
        this.defaultSKKeyCode = n;
    }

    public void setScreenKeyCode(int n) {
    }

    public void setID(int n) {
        this.id = n;
    }

    @Override
    public void setTerminal(HMITerminal hMITerminal) {
        this.terminal = (HMITerminalImpl)hMITerminal;
    }

    @Override
    public HMITerminal getTerminal() {
        return this.terminal;
    }

    @Override
    public void setState(int[] nArray) {
        this.states = nArray;
    }

    @Override
    public int getID() {
        return this.id;
    }

    public void setKeyCode(int n) {
        this.listenKeyCode = n;
    }

    public void setPriority(int n) {
        this.priority = n;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public int[] getReplacementIDs() {
        return this.replacementIDs;
    }

    @Override
    public HMIView[][] getReplacementWidgets() {
        return this.replacementWidgets;
    }

    @Override
    public void setReplacementWidgets(int[] nArray, HMIView[][] hMIViewArray) {
        this.replacementIDs = nArray;
        this.replacementWidgets = hMIViewArray;
    }

    @Override
    public void setScreenFactory(AbstractScreenFactory abstractScreenFactory) {
        this.screenFactory = abstractScreenFactory;
    }

    @Override
    public AbstractScreenFactory getScreenFactory() {
        return this.screenFactory;
    }

    @Override
    public void setViews(int[] nArray, HMIView[][] hMIViewArray) {
        this.views = hMIViewArray;
        this.viewModelIDs = nArray;
    }

    @Override
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

    @Override
    public void connected(IScreenData iScreenData) {
        try {
            logBenchmark.log(-2137614336, "AbstractScreenWidget#connected id %1 start", (long)this.id);
            long l = framework.getMonotonicTime();
            hmiService.getEventDispatcher().doCheckedSleepingInternal();
            this.defineScreenMode(iScreenData);
            this.defineColorPlate(iScreenData.getColorScheme());
            this.connected(this.createScreenContext(iScreenData));
            this.initializeSmallStageMode();
            this.showPartialPopupsInternal(iScreenData.getPartialPopups());
            hmiService.getEventDispatcher().doCheckedSleepingInternal();
            this.errorOccured = false;
            long l2 = framework.getMonotonicTime();
            logBenchmark.log(-2137614336, "AbstractScreenWidget#connected id %1 finished", (long)this.id);
            logWidgetPerformance.log(-2137614336, "AbstractScreenWidget#connected id %1 took %2 ms", (long)this.id, l2 - l);
        }
        catch (Exception exception) {
            logChannel.log(10000, "ScreenWidget#connected error ocurred in: %1", (Object)this);
            logChannel.log(10000, "ScreenWidget#connected exception: %1", (Throwable)exception);
            this.doErrorhandling(exception);
            this.errorOccured = true;
        }
    }

    private void initializeSmallStageMode() {
        if (this.smallStageType == 3 || this.smallStageType == 8) {
            if (this.mainArea != null) {
                this.mainArea.setFocusableInSmallStage(false);
            }
            if (this.titleArea != null) {
                this.titleArea.setFocusableInSmallStage(false);
            }
        } else if (this.mainArea != null && this.mainArea.getNotFocusableIcon() != null) {
            this.mainArea.getNotFocusableIcon().setVisible(false);
            logChannel.log(-2137614336, "AbstractScreenWidget#initializeSmallStageMode small stage type is not screenshot but application icon for small stage is modelled: %1", (Object)this);
        }
    }

    private void defineScreenMode(IScreenData iScreenData) {
        this.screenMode = iScreenData.getScreenMode();
        if (this.screenMode == -1) {
            logChannel.log(-2137614336, "ScreenWidget#connected no screen mode set for %1", (Object)this);
            this.screenMode = 1;
        }
        if (this.titleArea != null) {
            if (this.screenMode == 2) {
                ((AbstractWidget)((Object)this.titleArea)).setY(this.terminal.getLayout().getIntegerConstant(28));
            } else {
                ((AbstractWidget)((Object)this.titleArea)).setY(0);
            }
        }
    }

    private void defineColorPlate(int n) {
        this.paintedWithChangedColorTheme = false;
        this.activeColorPlate = this.getColorPlate(n);
        if (this.rc != null) {
            this.rc.setActiveColorPlate(this.activeColorPlate);
        }
    }

    public String getScreenName() {
        if (this.terminal == null) {
            return String.valueOf(this.id);
        }
        return this.terminal.getScreenName(this.id);
    }

    protected InitializationContext createScreenContext(IScreenData iScreenData) {
        InitializationContext initializationContext = new InitializationContext(this.terminal, iScreenData);
        initializationContext.setScreenFactory(this.screenFactory);
        initializationContext.setScreen(this);
        initializationContext.setCompositeID(-1);
        return initializationContext;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        ITouchInputManager iTouchInputManager;
        if (screenLogChannel.isDebug()) {
            screenLogChannel.log(-2137614336, "ScreenWidget#connected, %2, initContext.isReinit(): %1", initializationContext.isReinit(), (Object)this);
        }
        if ((iTouchInputManager = this.terminal.getTouchInputManager()) != null) {
            iTouchInputManager.updateRecognizerMode(false);
            iTouchInputManager.clear();
            int n = this.getDefaultRecognizerMode();
            iTouchInputManager.setDesiredRecognizerMode(this, n);
        }
        super.connected(initializationContext);
        this.terminal.getDrawerManager().activateOptionDrawer(initializationContext.getOptionDrawerID(), initializationContext.getContextIDs());
        this.terminal.getDrawerManager().activateSelectionDrawer(initializationContext.getSelectionDrawerID());
        if (framework.getScreenRes() != 4) {
            this.terminal.getDrawerManager().activateEntertainmentDrawer();
        }
        this.afterConnect();
    }

    private int getDefaultRecognizerMode() {
        if (this.terminal.getKbdService().getCurrentKeyboardType() == 6) {
            return 24;
        }
        return 26;
    }

    @Override
    public void updateContexts(long[] lArray) {
        if (this.terminal != null && this.terminal.getDrawerManager() != null && this.initContext != null) {
            this.initContext.setContextIDs(lArray);
            this.terminal.getDrawerManager().activateOptionDrawer(this.initContext.getOptionDrawerID(), lArray);
            this.terminal.getDrawerManager().activateSelectionDrawer(this.initContext.getSelectionDrawerID());
        }
    }

    @Override
    protected void initializeWidget() {
        IPartialPopupManagerEvo iPartialPopupManagerEvo;
        super.initializeWidget();
        this.getAnimationController().newMainScreenConnected(this);
        this.terminal.setHighlightSK(this.getDefaultSKKeyCode());
        if (!framework.isFrontMU() && this.terminal.getKbdService() != null && this.getDefaultSKKeyCode() == 0 && this.terminal.getTerminalID() != 5) {
            this.terminal.getKbdService().setSKIlluminationOff();
        }
        if ((iPartialPopupManagerEvo = this.terminal.getPartialPopupManagerEvo()) != null) {
            iPartialPopupManagerEvo.newScreenConnected(this);
        }
        this.executeAllConditions();
        this.initializeRedrawContext();
        WidgetPersistenceManager widgetPersistenceManager = this.terminal.getWidgetPersistenceManager();
        widgetPersistenceManager.readBegin(this.states);
    }

    protected void afterConnect() {
        this.setSmallStageIconOnScreen(true);
        this.requestLargeViewSizeIfNeeded();
        if (this.idleTimers != null && !this.sdsDialogInProgress) {
            this.restartIdleTimer();
        }
        if (this.terminal.getTouchInputManager() != null) {
            this.terminal.getTouchInputManager().updateRecognizerMode(true);
        }
        this.connected = true;
    }

    public void initializeRedrawContext() {
        this.rc = this.renderer.createRedrawContextRoot();
        this.terminal.setRedrawContext(this.rc);
        this.rc.setActiveColorPlate(this.activeColorPlate);
        this.rc.setColorIndices(this.colorIndices);
        this.rc.setScreenID(this.id);
    }

    @Override
    public void disconnecting() {
        try {
            screenLogChannel.log(-2137614336, "ScreenWidget#disconnecting is called: %1", (Object)this);
            logWidgetPerformance.log(1078071040, "AbstractScreenWidget#disconnecting id %1 start", (long)this.id);
            long l = framework.getMonotonicTime();
            this.unrequestLargeViewSizeIfNeeded();
            this.connected = false;
            hmiService.getEventDispatcher().doCheckedSleepingInternal();
            this.cancelIdleTimer();
            this.terminal.getGUIManager().setDrawMissing(false);
            if (this.getAnimationController().isPaintTargetRegistered(this)) {
                this.getAnimationController().deregisterPaintTarget(this);
                screenLogChannel.log(-2137614336, "ScreenWidget#disconnecting still registered for repainting, deregistering now: %1", (Object)this);
            }
            this.terminal.getWidgetPersistenceManager().storeBegin(this.states);
            this.setLocked(false);
            super.disconnecting();
            this.terminal.getWidgetPersistenceManager().storeEnd(this.states);
            this.errorOccured = false;
            ((AbstractImageLoader)this.terminal.getImageLoader()).screenDisconnected(this.id, this.terminal.getTerminalID());
            this.screenPainted = false;
            hmiService.getEventDispatcher().doCheckedSleepingInternal();
            long l2 = framework.getMonotonicTime();
            logWidgetPerformance.log(1078071040, "AbstractScreenWidget#disconnecting id %1 finished, took %2 ms", (long)this.id, l2 - l);
        }
        catch (Exception exception) {
            this.terminal.getWidgetRegistry().deregisterWidgets(this);
            logChannel.log(10000, "ScreenWidget#disconnecting error ocurred in screen: %1", (Object)this);
            this.doErrorhandling(exception);
            this.errorOccured = true;
            ((AbstractImageLoader)this.terminal.getImageLoader()).screenDisconnected(this.id, this.terminal.getTerminalID());
        }
    }

    private void managePaintPartialPopups() {
        IPartialPopupManagerEvo iPartialPopupManagerEvo = this.terminal.getPartialPopupManagerEvo();
        if (iPartialPopupManagerEvo == null) {
            return;
        }
        iPartialPopupManagerEvo.paintUnboundPopups();
    }

    private void managePaintDrawers() {
        if (firstPaint) {
            logBenchmark.log(1078071040, "AbstractScreenWidget#managePaintDrawers first paint, ignore Drawers");
            firstPaint = false;
        } else {
            IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager();
            if (iDrawerFocusManagerEvo == null) {
                return;
            }
            iDrawerFocusManagerEvo.paintDrawers();
        }
    }

    @Override
    public void paint() {
        try {
            if (!this.screenPainted) {
                logBenchmark.log(-2137614336, "AbstractScreenWidget#paint id %1 start", (long)this.id);
            }
            logWidgetPerformance.log(1078071040, "AbstractScreenWidget#paint id %1 start", (long)this.id);
            long l = framework.getMonotonicTime();
            if (!this.paintedWithChangedColorTheme && this.terminal.getDrawerFocusManager() != null) {
                this.terminal.getDrawerFocusManager().setDrawersAndPopupsInvalid();
                this.paintedWithChangedColorTheme = true;
            }
            if (this.errorOccured) {
                logChannel.log(10000, "ScreenWidget#paint not painting, error ocurred in screen with ID %1", (long)this.id);
            } else {
                this.managePaint(this.rc);
            }
            long l2 = framework.getMonotonicTime();
            this.managePaintPartialPopups();
            this.managePaintDrawers();
            if (!this.screenPainted) {
                logBenchmark.log(-2137614336, "AbstractScreenWidget#paint id %1 finished", (long)this.id);
            }
            long l3 = framework.getMonotonicTime();
            logWidgetPerformance.log(1078071040, "AbstractScreenWidget#paint id %1 finished, took %2 ms (screen itself: %3 ms)", (long)this.id, l3 - l, l2 - l);
            this.screenPainted = true;
        }
        catch (Exception exception) {
            this.errorOccured = true;
            screenLogChannel.log(1000, "ScreenWidget#paint - illegal state exception - maybe target was bound - try to release target", (Throwable)exception);
            this.renderer.handlePaintError(exception);
            this.doErrorhandling(exception);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            this.errorOccured = true;
            screenLogChannel.log(1000, "ScreenWidget#paint received out of memory");
            AbstractWidget.framework.getErrorMgr().handleError(outOfMemoryError, "ScreenWidget#paint received out of memory ", 0, 3, 2);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.errorOccured) {
            try {
                if (screenLogChannel.isDebug()) {
                    screenLogChannel.log(-2137614336, "ScreenWidget#keyPressed on terminal: %2 is called - locked is %1", this.locked, (long)this.terminal.getTerminalID());
                }
                this.processKeyPressed(keyEvent);
            }
            catch (Exception exception) {
                logChannel.log(10000, "ScreenWidget#keyPressed error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public boolean hasIdleTimer() {
        return this.idleTimers != null;
    }

    @Override
    public void restartIdleTimer() {
        if (this.idleTimers != null) {
            int n = this.idleTimers.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((IIdleTimerWidget)this.idleTimers.get(i2)).restartTimer();
            }
        }
    }

    @Override
    public void cancelIdleTimer() {
        if (this.idleTimers != null) {
            int n = this.idleTimers.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((IIdleTimerWidget)this.idleTimers.get(i2)).cancelTimer();
            }
        }
    }

    private void processKeyPressed(KeyEvent keyEvent) {
        screenLogChannel.log(-2137614336, "ScreenWidget#processKeyPressed is called - locked is %1, id: %2", this.locked, (long)this.id);
        int n = keyEvent.getKeyCode();
        super.keyPressed(keyEvent);
        if (screenLogChannel.isDebug()) {
            screenLogChannel.log(-2137614336, "ScreenWidget#processKeyPressed is called - evt consumed %1", keyEvent.isConsumed());
        }
        if (keyEvent.isConsumed()) {
            return;
        }
        if (!keyEvent.isConsumed() && this.listenKeyCode != 0 && (n == 17 && (this.listenKeyCode & 1) != 0 || n == 15 && (this.listenKeyCode & 2) != 0) && this.hasState(36)) {
            if (this.model instanceof HMIModelGUI) {
                int n2 = ((HMIModelGUI)this.model).getModelType();
                if (n2 == 1 || n2 == 2) {
                    keyEvent.consume(false);
                    ButtonModelGUI buttonModelGUI = (ButtonModelGUI)this.model;
                    buttonModelGUI.keyPressed(keyEvent.getKeyCode(), this.initContext.getTerminalID());
                    buttonModelGUI.keyTyped(keyEvent.getKeyCode(), this.initContext.getTerminalID());
                } else {
                    screenLogChannel.log(14808325, "ScreenWidget#keyPressed wrong model type: %1 ", (long)n2);
                }
            } else if (this.event != 0) {
                keyEvent.consume(false);
                this.fireSMEvent(this.initContext.getTerminalID(), this.event);
            } else {
                screenLogChannel.log(14808325, "ScreenWidget#keyPressed(1) event keyCode: %1 is not consumed by widgets ", (long)n);
            }
        } else {
            screenLogChannel.log(14808325, "ScreenWidget#keyPressed(2) event keyCode: %1 is not consumed by widgets ", (long)n);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (!this.errorOccured) {
            try {
                if (screenLogChannel.isDebug()) {
                    screenLogChannel.log(-2137614336, "ScreenWidget#keyReleased on terminal: %2 is called - locked is %1", this.locked, (long)this.terminal.getTerminalID());
                }
                super.keyReleased(keyEvent);
            }
            catch (Exception exception) {
                logChannel.log(10000, "ScreenWidget#keyReleased error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (!this.errorOccured) {
            try {
                if (screenLogChannel.isDebug()) {
                    screenLogChannel.log(-2137614336, "ScreenWidget#keyTurned on terminal: %2 is called - locked is %1", this.locked, (long)this.terminal.getTerminalID());
                }
                super.keyTurned(wheelButtonEvent);
            }
            catch (Exception exception) {
                logChannel.log(10000, "ScreenWidget#keyTurned error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#keyMoved is called - locked is %1", this.locked);
                super.keyMoved(joystickEvent);
            }
            catch (Exception exception) {
                logChannel.log(10000, "ScreenWidget#keyMoved error ocurred in screen with ID %1", (long)this.id, (Throwable)exception);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    public void doCheckedRepaint() {
        if (this.initContext == null) {
            return;
        }
        AbstractAnimationController abstractAnimationController = this.getAnimationController();
        if (abstractAnimationController != null && abstractAnimationController.isAnimationRunningThatBlocksRepaint()) {
            abstractAnimationController.registerPaintTarget(this);
        } else {
            try {
                if (this.terminal != null) {
                    this.terminal.getRootWindow().repaint();
                } else {
                    logChannel.log(10000, "ScreenWidget#doCheckedRepaint terminal is null repaint is ignored at screen with ID %1", (long)this.id);
                }
            }
            catch (Exception exception) {
                this.errorOccured = true;
                logChannel.log(10000, "ScreenWidget#doCheckedRepaint error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
            }
        }
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        if (screenLogChannel.isDebug()) {
            screenLogChannel.log(-2137614336, "ScreenWidget#touchPadPressed called - evt: %1 evt.getCode: %2", (Object)touchEvent, (long)touchEvent.getCode());
        }
        if (!touchPadAvailabilityInitialized) {
            ((ChoiceModelApp)((Object)hmiService.getModel(413))).setValue(1);
            touchPadAvailabilityInitialized = true;
        }
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#touchPadPressed is called - locked is %1", this.locked);
                logChannel.log(-2137614336, "ScreenWidget#touchPadPressed");
                super.touchPadPressed(touchEvent);
            }
            catch (Exception exception) {
                screenLogChannel.log(10000, "ScreenWidget#touchPadPressed error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#touchPadReleased is called - locked is %1", this.locked);
                logChannel.log(-2137614336, "ScreenWidget#touchPadReleased");
                super.touchPadReleased(touchEvent);
            }
            catch (Exception exception) {
                screenLogChannel.log(10000, "ScreenWidget#touchPadReleased error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#touchPadPositionMoved is called - locked is %1", this.locked);
                super.touchPadPositionMoved(touchEvent);
            }
            catch (Exception exception) {
                screenLogChannel.log(10000, "ScreenWidget#touchPadPositionMoved error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#touchPadCharactersRecognized is called - locked is %1", this.locked);
                super.touchPadCharactersRecognized(touchEvent);
            }
            catch (Exception exception) {
                screenLogChannel.log(10000, "ScreenWidget#touchPadCharactersRecognized error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#touchPadAbandoned is called - locked is %1", this.locked);
                super.touchPadAbandoned(touchEvent);
            }
            catch (Exception exception) {
                screenLogChannel.log(10000, "ScreenWidget#touchPadAbandoned error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void touchPadPalmRecognized(TouchEvent touchEvent) {
        if (screenLogChannel.isDebug()) {
            screenLogChannel.log(-2137614336, "ScreenWidget#touchPadPalmRecognized called - evt: %1 evt.getCode: %2", (Object)touchEvent, (long)touchEvent.getCode());
        }
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#touchPadPalmRecognized is called - locked is %1", this.locked);
                logChannel.log(-2137614336, "ScreenWidget#touchPadApproached");
                super.touchPadPalmRecognized(touchEvent);
            }
            catch (Exception exception) {
                screenLogChannel.log(10000, "ScreenWidget#touchPadPalmRecognized error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
        if (screenLogChannel.isDebug()) {
            screenLogChannel.log(-2137614336, "ScreenWidget#touchPadApproached called - evt: %1 evt.getCode: %2", (Object)touchEvent, (long)touchEvent.getCode());
        }
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#touchPadApproached is called - locked is %1", this.locked);
                logChannel.log(-2137614336, "ScreenWidget#touchPadApproached");
                super.touchPadApproached(touchEvent);
            }
            catch (Exception exception) {
                screenLogChannel.log(10000, "ScreenWidget#touchPadApproached error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (!this.errorOccured) {
            try {
                long l;
                IUserHintHandler iUserHintHandler;
                logWidgetPerformance.log(1078071040, "AbstractScreenWidget#processModelUpdateEvent start, event: %1", (Object)modelUpdateEvent);
                long l2 = AbstractWidget.framework.getMonotonicTime();
                if (screenLogChannel.isDebug()) {
                    screenLogChannel.log(-2137614336, "ScreenWidget#processModelUpdateEvent on terminal: %2 is called - locked is %1", this.locked, (long)this.terminal.getTerminalID());
                }
                if (modelUpdateEvent.getTerminalID() != -1 && modelUpdateEvent.getTerminalID() != this.initContext.getTerminalID()) {
                    if (screenLogChannel.isDebug()) {
                        screenLogChannel.log(-2137614336, "ScreenWidget#processModelUpdateEvent is called for other terminal. modelUpdateTerminalID: %1 initContext.terminalID: %2", (long)modelUpdateEvent.getTerminalID(), (long)this.initContext.getTerminalID());
                    }
                    long l3 = AbstractWidget.framework.getMonotonicTime();
                    logWidgetPerformance.log(1078071040, "AbstractScreenWidget#processModelUpdateEvent finished (other terminal), took %1 ms", l3 - l2);
                    return;
                }
                int n = modelUpdateEvent.getModelId();
                if (screenLogChannel.isDebug()) {
                    screenLogChannel.log(-2137614336, "ScreenWidget#processModelUpdateEvent id: %2 modelId: %3, event: %1 ", (Object)modelUpdateEvent, (long)modelUpdateEvent.getID(), (long)n);
                }
                boolean bl = false;
                IPartialPopupManagerEvo iPartialPopupManagerEvo = this.terminal.getPartialPopupManagerEvo();
                if (iPartialPopupManagerEvo != null) {
                    bl |= iPartialPopupManagerEvo.processModelUpdateEvent(modelUpdateEvent);
                }
                if ((iUserHintHandler = this.terminal.getUserHintHandler()) != null) {
                    iUserHintHandler.processModelUpdateEvent(modelUpdateEvent);
                }
                if ((bl |= new ModelEventPropagator(modelUpdateEvent, this).propagate()) || modelUpdateEvent.isConsumed()) {
                    if (this.getAnimationController().isAnimationRunningThatBlocksRepaint()) {
                        screenLogChannel.log(-2137614336, "ScreenWidget#processModelUpdateEvent register screen as repaint target");
                        this.getAnimationController().registerPaintTarget(this);
                    } else {
                        l = framework.getMonotonicTime() - this.lastModelUpdateTime;
                        if (l > 0 || !this.nextEventWillTriggerRepaint()) {
                            logRepaintCause.log(-2137614336, "AbstractScreenWidget#processModelUpdateEvent: trigger repaint. deltatime: %2, event: %1", (Object)modelUpdateEvent, l);
                            this.triggerRepaint();
                            if (AbstractModel.statistics != null) {
                                AbstractModel.statistics.countRedraw(n);
                            }
                            this.lastModelUpdateTime = framework.getMonotonicTime();
                        } else {
                            logRepaintCause.log(-2137614336, "AbstractScreenWidget#processModelUpdateEvent: paint screen %3. deltatime: %2, event: %1", (Object)modelUpdateEvent, l, (long)this.getID());
                            this.paint();
                        }
                    }
                } else {
                    screenLogChannel.log(-2137614336, "ScreenWidget#processModelUpdateEvent updateEvent with ID: %1 has not been processed", (long)n);
                }
                l = AbstractWidget.framework.getMonotonicTime();
                logWidgetPerformance.log(1078071040, "AbstractScreenWidget#processModelUpdateEvent finished, took %1 ms", l - l2);
            }
            catch (Exception exception) {
                logChannel.log(10000, "ScreenWidget#processModelUpdateEvent error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    public HMIView[] findViews(int n) {
        return this.findWidgets(this.views, this.viewModelIDs, n);
    }

    protected AbstractWidget[] findConditionWidgets(int n) {
        return (AbstractWidget[])this.findWidgets(this.conditionWidgets, this.conditionIDs, n);
    }

    protected HMIView[] findReplacementWidgets(int n) {
        return this.findWidgets(this.replacementWidgets, this.replacementIDs, n);
    }

    private HMIView[] findWidgets(HMIView[][] hMIViewArray, int[] nArray, int n) {
        int n2;
        if (hMIViewArray != null && nArray != null && (n2 = Arrays.binarySearch(nArray, n)) >= 0) {
            return hMIViewArray[n2];
        }
        return null;
    }

    private boolean nextEventWillTriggerRepaint() {
        ATIPEvent aTIPEvent = hmiService.getEventDispatcher().peekEvent();
        boolean bl = false;
        if (aTIPEvent instanceof ModelUpdateEvent) {
            ModelUpdateEvent modelUpdateEvent = (ModelUpdateEvent)aTIPEvent;
            if (modelUpdateEvent.getModelType() == 100) {
                ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
                for (int i2 = 0; i2 < modelUpdateEventArray.length; ++i2) {
                    if (!this.nextEventWillBeProcessed(modelUpdateEventArray[i2].getTerminalID(), modelUpdateEventArray[i2].getModelId())) continue;
                    bl = true;
                    break;
                }
            } else if (this.nextEventWillBeProcessed(modelUpdateEvent.getTerminalID(), modelUpdateEvent.getModelId())) {
                bl = true;
            }
        }
        return bl;
    }

    private boolean nextEventWillBeProcessed(int n, int n2) {
        boolean bl = false;
        if (n == -1 || n == this.initContext.getTerminalID()) {
            int n3;
            if (this.viewModelIDs != null && (n3 = Arrays.binarySearch(this.viewModelIDs, n2)) >= 0) {
                bl = true;
            }
            if (!bl && this.conditionIDs != null && (n3 = Arrays.binarySearch(this.conditionIDs, n2)) >= 0) {
                bl = true;
            }
            if (!bl && this.replacementIDs != null && (n3 = Arrays.binarySearch(this.replacementIDs, n2)) >= 0) {
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public void afterPaint(RedrawContext redrawContext) {
    }

    protected void executeAllConditions() {
        if (this.conditionIDs != null) {
            for (int i2 = 0; i2 < this.conditionIDs.length; ++i2) {
                try {
                    this.screenFactory.executeCondition(this.conditionIDs[i2], this.id, this.conditionWidgets[i2], this.terminal.getTerminalID());
                    continue;
                }
                catch (NullPointerException nullPointerException) {
                    screenLogChannel.log(1000, "ScreenWidget#executeAllConditions problems executing condition for model id: %1 screenID: %2", (long)this.conditionIDs[i2], (long)this.id);
                }
            }
        }
    }

    @Override
    public void processSDSEvent(SDSEvent sDSEvent) {
        if (!this.errorOccured) {
            try {
                AbstractWidget abstractWidget;
                AbstractWidget abstractWidget2;
                screenLogChannel.log(-2137614336, "ScreenWidget#processSDSEvent is called - locked is %1", this.locked);
                IPartialPopupManagerEvo iPartialPopupManagerEvo = (IPartialPopupManagerEvo)this.terminal.getPartialPopupManager();
                if (iPartialPopupManagerEvo != null) {
                    iPartialPopupManagerEvo.processSDSEvent(sDSEvent);
                }
                if ((abstractWidget2 = this.getCurrentMenu()) instanceof SDSEventListener) {
                    ((SDSEventListener)((Object)abstractWidget2)).processSDSEvent(sDSEvent);
                }
                for (int i2 = 0; i2 < 10 && (abstractWidget = this.terminal.getWidgetRegistry().getWidget(16, i2, this)) != null; ++i2) {
                    if (!abstractWidget.isVisible()) continue;
                    ((SDSEventListener)((Object)abstractWidget)).processSDSEvent(sDSEvent);
                }
                if (!sDSEvent.isConsumed()) {
                    sDSEvent.consume();
                    if (sdsService != null) {
                        if (sDSEvent.getSDSCommand() != 8 && sDSEvent.getSDSCommand() != 9) {
                            screenLogChannel.log(10000, "ScreenWidget#processSDSEvent sdsEvent has not been processed by widgets");
                            this.handleUnconsumedSDSEvent(sDSEvent);
                        } else {
                            screenLogChannel.log(1078071040, "ScreenWidget#processSDSEvent sdsEvent has not been processed by widgets for command READ_LINE or READ_NEXT");
                        }
                    } else {
                        screenLogChannel.log(10000, "ScreenWidget#processSDSEvent try to acknowledge sdsEvent but sdsService not present. Cannot sendResult");
                    }
                } else {
                    screenLogChannel.log(-2137614336, "ScreenWidget#processSDSEvent RESPONSE_ERROR -> repaint");
                    this.triggerRepaint();
                }
            }
            catch (Exception exception) {
                logChannel.log(10000, "ScreenWidget#processSDSEvent error ocurred in screen with ID %1", (long)this.id);
                this.doErrorhandling(exception);
                this.errorOccured = true;
            }
        }
    }

    protected void handleUnconsumedSDSEvent(SDSEvent sDSEvent) {
    }

    protected AbstractWidget getCurrentMenu() {
        return this.terminal.getWidgetRegistry().getWidget(0, -1, this);
    }

    @Override
    public void triggerRepaint() {
        screenLogChannel.log(-2137614336, "ScreenWidget#triggerRepaint is called, id: %1", (long)this.id);
        this.doCheckedRepaint();
    }

    @Override
    public void setLocked(boolean bl) {
        screenLogChannel.log(-2137614336, "ScreenWidget#setLocked locked is called - locked: %1", bl);
        this.locked = bl;
        ArrayList arrayList = this.initContext.getWidgetRegistry().getActiveWaitAnimControllers();
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)arrayList.get(i2);
            if (abstractWidgetController == null) continue;
            abstractWidgetController.setVisible(bl);
            abstractWidgetController.setCompositesDirty(true);
        }
        if (!arrayList.isEmpty()) {
            this.triggerRepaint();
        }
    }

    public void setLockMode(int n) {
        this.lockMode = n;
    }

    @Override
    public int getTerminalID() {
        return 0;
    }

    public IDisplayControllerWidget getDisplayController() {
        return this.displayController;
    }

    public void setDisplayController(IDisplayControllerWidget iDisplayControllerWidget) {
        this.displayController = iDisplayControllerWidget;
        this.clearMethod = 0;
        this.add((AbstractWidget)((Object)iDisplayControllerWidget));
    }

    @Override
    public int getScreenType() {
        return this.screenType;
    }

    @Override
    public void setScreenType(int n) {
        this.screenType = n;
    }

    @Override
    public int getEventProcessing() {
        return 0;
    }

    public void setSdsDialogInProgress(boolean bl) {
        if (this.sdsDialogInProgress != bl) {
            if (this.sdsDialogInProgress) {
                this.restartIdleTimer();
            } else {
                this.cancelIdleTimer();
            }
        }
        this.sdsDialogInProgress = bl;
    }

    public void cancelTimer(Timer timer) {
    }

    @Override
    public int getCacheBehaviour() {
        return this.cacheBehaviour;
    }

    public void setCacheBehaviour(int n) {
        this.cacheBehaviour = n;
    }

    @Override
    public int getEventID(int n) {
        int n2;
        if (this.modelIDs != null && this.eventIDs != null && this.modelIDs.length > 0 && this.modelIDs.length == this.eventIDs.length && (n2 = Arrays.binarySearch(this.modelIDs, n)) >= 0) {
            return this.eventIDs[n2];
        }
        return -1;
    }

    @Override
    public void setModelIDs(int[] nArray) {
        this.modelIDs = nArray;
    }

    @Override
    public void setEventIDs(int[] nArray) {
        this.eventIDs = nArray;
    }

    public void setHighlightSKModelId(int n) {
        this.skModelId = n;
    }

    @Override
    public boolean hasErrorOccured() {
        return this.errorOccured;
    }

    @Override
    public void hidePartialPopups(int[] nArray) {
        IPartialPopupManagerEvo iPartialPopupManagerEvo = (IPartialPopupManagerEvo)this.terminal.getPartialPopupManager();
        if (nArray != null && iPartialPopupManagerEvo != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                iPartialPopupManagerEvo.hidePopup(nArray[i2], false);
            }
            if (nArray.length > 0) {
                if (screenLogChannel.isDebug()) {
                    logRepaintCause.log(-2137614336, "AbstractScreenWidget#hidePartialPopups: hide %1 partial popups (first ID: %2), trigger repaint", (long)nArray.length, (long)nArray[0]);
                }
                this.triggerRepaint();
            }
        }
    }

    @Override
    public void hideNotScreenChangeSurvivingPopups() {
        IPartialPopupManagerEvo iPartialPopupManagerEvo = (IPartialPopupManagerEvo)this.terminal.getPartialPopupManager();
        if (iPartialPopupManagerEvo != null) {
            iPartialPopupManagerEvo.hideNotScreenChangeSurvivingPopups();
        }
    }

    @Override
    public void showPartialPopups(int[] nArray) {
        this.showPartialPopupsInternal(nArray);
        if (nArray != null && nArray.length > 0) {
            if (screenLogChannel.isDebug()) {
                logRepaintCause.log(-2137614336, "AbstractScreenWidget#showPartialPopups: show %1 partial popups (first ID: %2), trigger repaint", (long)nArray.length, (long)nArray[0]);
            }
            this.triggerRepaint();
        }
    }

    private void showPartialPopupsInternal(int[] nArray) {
        IPartialPopupManager iPartialPopupManager = this.terminal.getPartialPopupManager();
        if (nArray != null && iPartialPopupManager != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                iPartialPopupManager.showPopup(nArray[i2]);
            }
        }
    }

    @Override
    public void unitsChanged(UnitChangedEvent unitChangedEvent) {
        if (!this.errorOccured) {
            try {
                screenLogChannel.log(-2137614336, "ScreenWidget#unitsChanged is called");
                super.unitsChanged(unitChangedEvent);
                if (unitChangedEvent.isConsumed()) {
                    logRepaintCause.log(-2137614336, "PartialPopupManager#unitsChanged: do checked repaint on screen %2, unit change event: %1", (Object)unitChangedEvent, (long)this.getID());
                    this.doCheckedRepaint();
                }
            }
            catch (Exception exception) {
                logChannel.log(10000, "ScreenWidget#unitsChanged error ocurred in screen with ID %1", (long)this.id);
                this.errorOccured = true;
                this.doErrorhandling(exception);
            }
        }
    }

    private void doErrorhandling(Exception exception) {
        if (this.initContext != null) {
            logChannel.log(10000, "ScreenWidget#doErrorhandling: error occurred in scren %1: %2", (long)this.id, (Throwable)exception);
            this.initContext.getTerminal().getGUIManager().doErrorHandling(exception, this.id);
            if (this.terminal.getTTSHandler() != null) {
                this.terminal.getTTSHandler().reset();
            }
        } else {
            logChannel.log(10000, "ScreenWidget#doErrorhandling no initContext for screen with ID %1, no error handling possible", (long)this.id);
        }
    }

    public void setPartialPopupsAllowed(boolean bl) {
    }

    public void setBoundingBoxes(int[][] nArray) {
    }

    public int[][] getBoundingBoxes() {
        return null;
    }

    @Override
    public boolean isConnected() {
        return this.connected;
    }

    public boolean has3DBackground() {
        return false;
    }

    @Override
    public void bitmapLoaded(AsyncBitmapEvent asyncBitmapEvent) {
        if (screenLogChannel.isDebug()) {
            iconLogChannel.log(-2137614336, "ScreenWidget#bitmapLoaded async loaded: %1, erroCode: %2", (Object)asyncBitmapEvent.getResourceLocator(), (long)asyncBitmapEvent.getErrorCode());
        }
        super.bitmapLoaded(asyncBitmapEvent);
        if (asyncBitmapEvent.isConsumed()) {
            if (screenLogChannel.isDebug()) {
                logRepaintCause.log(-2137614336, "AbstractScreenWidget#bitmapLoaded: do checked repaint on screen %2. event: %1", (Object)asyncBitmapEvent.getResourceLocator(), (long)this.getID());
            }
            this.doCheckedRepaint();
        }
    }

    public void setPartialPopupBlockMode(int n) {
        this.partialPopupBlockMode = n;
    }

    public void setPartialPopupBlockExceptions(int[] nArray) {
        this.partialPopupBlockExceptions = nArray;
    }

    @Override
    public boolean isPartialPopupBlocked(IPartialPopupController iPartialPopupController) {
        if (this.partialPopupBlockMode == 0) {
            if (this.partialPopupBlockExceptions == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.partialPopupBlockExceptions.length; ++i2) {
                if (this.partialPopupBlockExceptions[i2] != iPartialPopupController.getID()) continue;
                return true;
            }
            return false;
        }
        if (this.partialPopupBlockMode == 1) {
            if (this.partialPopupBlockExceptions == null) {
                return true;
            }
            for (int i3 = 0; i3 < this.partialPopupBlockExceptions.length; ++i3) {
                if (this.partialPopupBlockExceptions[i3] != iPartialPopupController.getID()) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean areAllPartialPopupsAllowed() {
        return this.partialPopupBlockMode == 0 && this.partialPopupBlockExceptions == null;
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof IIdleTimerWidget) {
            if (this.idleTimers == null) {
                this.idleTimers = new ArrayList(3);
            }
            this.idleTimers.add(abstractWidget);
        }
        if (abstractWidget instanceof ITouchScreenEventListener) {
            this.touchScreenEventHandler = (ITouchScreenEventListener)((Object)abstractWidget);
        }
    }

    public int getClearMethod() {
        return this.clearMethod;
    }

    public ScreenMainArea getMainArea() {
        return this.mainArea;
    }

    public ScreenMainArea getDrawerIndependentArea() {
        return this.drawerIndependentArea;
    }

    public ScreenMainArea getTitleArea() {
        return this.titleArea;
    }

    public ScreenMainArea getSpecialArea() {
        return this.specialArea;
    }

    public List getSpecialAreas() {
        return Collections.unmodifiableList(this.specialAreas);
    }

    protected AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.terminal.getIAnimationController();
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof ScreenArea) {
            switch (n) {
                case 1: {
                    this.mainArea = (ScreenMainArea)((Object)abstractWidget);
                    break;
                }
                case 2: {
                    this.titleArea = (ScreenMainArea)((Object)abstractWidget);
                    break;
                }
                case 4: 
                case 6: {
                    screenLogChannel.log(-1601830656, "AbstractScreenWidget#add new widget: deprecated role %2 for %1", (Object)abstractWidget, (long)n);
                    this.drawerIndependentArea = (ScreenMainArea)((Object)abstractWidget);
                    this.specialAreas.add(this.drawerIndependentArea);
                    break;
                }
                case 5: {
                    screenLogChannel.log(-1601830656, "AbstractScreenWidget#add new widget: deprecated role %2 for %1", (Object)abstractWidget, (long)n);
                }
                case 7: {
                    this.specialArea = (ScreenMainArea)((Object)abstractWidget);
                    this.specialAreas.add(this.specialArea);
                    break;
                }
                case 8: {
                    this.specialAreas.add(abstractWidget);
                    break;
                }
                case 3: {
                    this.subtitleArea = (ScreenArea)((Object)abstractWidget);
                    break;
                }
                case 15: {
                    this.specialAreas.add(abstractWidget);
                    logViewSize.log(-2137614336, "AbstractScreenWidget#add Small stage icon found.");
                    this.smallStageIcon = abstractWidget;
                    break;
                }
                default: {
                    screenLogChannel.log(10000, "AbstractScreenWidget#add new widget: unknown role %2 for %1", (Object)abstractWidget, (long)n);
                }
            }
            this.add(((ScreenArea)((Object)abstractWidget)).getScreenAreaWidget());
        } else {
            screenLogChannel.log(10000, "AbstractScreenWidget#add new widget: %1 is not instance of ScreenArea", (Object)abstractWidget);
        }
    }

    public void setSelectionMask(AbstractWidget abstractWidget) {
        abstractWidget.setVisible(false);
        abstractWidget.setOpacity(0.0f);
        this.selectionMask = abstractWidget;
        this.add(abstractWidget);
    }

    public void setOptionMask(AbstractWidget abstractWidget) {
        abstractWidget.setVisible(false);
        abstractWidget.setOpacity(0.0f);
        this.optionMask = abstractWidget;
        this.add(abstractWidget);
    }

    public void setPartialPopupMask(AbstractWidget abstractWidget) {
        abstractWidget.setVisible(false);
        abstractWidget.setOpacity(0.0f);
        this.partialPopupMask = abstractWidget;
        this.add(abstractWidget);
    }

    public AbstractWidget getSelectionMask() {
        return this.selectionMask;
    }

    public AbstractWidget getOptionMask() {
        return this.optionMask;
    }

    public AbstractWidget getPartialPopupMask() {
        return this.partialPopupMask;
    }

    public ScreenArea getScreenArea(int n) {
        switch (n) {
            case 1: {
                return this.mainArea;
            }
            case 2: {
                return this.titleArea;
            }
            case 6: {
                return this.drawerIndependentArea;
            }
            case 7: {
                return null;
            }
            case 8: {
                return null;
            }
            case 3: {
                return this.subtitleArea;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Invalid role ").append(n).toString());
    }

    public List getScreenAreas(int n) {
        switch (n) {
            case 7: {
                return this.specialAreas;
            }
            case 8: {
                return this.specialAreas;
            }
        }
        return null;
    }

    public int getDrawerVisibility() {
        return this.drawerVisibility;
    }

    public void setDrawerVisibility(int n) {
        this.drawerVisibility = n;
    }

    public void setColorPalettes(int[][] nArray) {
        this.colorPlates = nArray;
    }

    public int[] getColorPlate(int n) {
        int[] nArray;
        if (this.colorPlates == null) {
            nArray = ERROR_COLOR_PLATE;
            logChannel.log(10000, "ScreenWidget#getColorPlate no colorplates modelled for %1", (Object)this);
        } else if (n < 0 || n >= this.colorPlates.length) {
            logChannel.log(10000, "ScreenWidget#getColorPlate no colorplate for colorscheme %1 in screen %2)", (long)n, (long)this.id);
            nArray = ERROR_COLOR_PLATE;
        } else {
            nArray = this.colorPlates[n];
        }
        return nArray;
    }

    @Override
    public int[] getCurrentColorPalette() {
        return this.activeColorPlate;
    }

    @Override
    public void triggerGestureEvent(GestureEvent gestureEvent) {
        if (this.touchScreenEventHandler == null) {
            logChannel.log(-2137614336, "AbstractScreenWidget#triggerGestureEvent event received, but no touchscreen event handler is modeled!");
            return;
        }
        switch (gestureEvent.getID()) {
            case 10903: 
            case 10906: {
                logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent GESTURE_EVENT_RELEASE (%1,%2,%3)", (Object)gestureEvent, (long)gestureEvent.getX(), (long)gestureEvent.getY());
                this.touchScreenEventHandler.touchScreenReleased(gestureEvent, gestureEvent.getX(), gestureEvent.getY());
                break;
            }
            case 10905: {
                logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent GESTURE_EVENT_FLICK (%1,%2,%3)", (Object)gestureEvent, (long)gestureEvent.getX(), (long)gestureEvent.getY());
                this.touchScreenEventHandler.touchScreenFlicked(gestureEvent, gestureEvent.getX(), gestureEvent.getY());
                break;
            }
            case 10902: {
                logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent GESTURE_EVENT_PRESS (%1,%2,%3)", (Object)gestureEvent, (long)gestureEvent.getX(), (long)gestureEvent.getY());
                this.touchScreenEventHandler.touchScreenPressed(gestureEvent, gestureEvent.getX(), gestureEvent.getY());
                break;
            }
            case 10909: {
                logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent GESTURE_EVENT_PRESS2(%1,%2,%3)", (Object)gestureEvent, (long)gestureEvent.getX(), (long)gestureEvent.getY());
                this.touchScreenEventHandler.touchScreenPress2(gestureEvent, gestureEvent.getX(), gestureEvent.getY());
                break;
            }
            case 10904: {
                logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent GESTURE_EVENT_MOVE (%1,%2,%3)", (Object)gestureEvent, (long)gestureEvent.getX(), (long)gestureEvent.getY());
                this.touchScreenEventHandler.touchScreenMoved(gestureEvent, gestureEvent.getX(), gestureEvent.getY());
                break;
            }
            case 10912: {
                logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent GESTURE_EVENT_MOVE (%1,%2,%3)", (Object)gestureEvent, (long)gestureEvent.getX(), (long)gestureEvent.getY());
                this.touchScreenEventHandler.touchScreenZoom(gestureEvent, gestureEvent.getX(), gestureEvent.getY());
                break;
            }
            case 10907: {
                logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent GESTURE_EVENT_ZOOM(%1,%2,%3)", (Object)gestureEvent, (long)gestureEvent.getX(), (long)gestureEvent.getY());
                this.touchScreenEventHandler.touchScreenZoom(gestureEvent, gestureEvent.getX(), gestureEvent.getY());
                break;
            }
            case 10908: {
                logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent GESTURE_EVENT_ROTATE(%1,%2,%3)", (Object)gestureEvent, (long)gestureEvent.getX(), (long)gestureEvent.getY());
                this.touchScreenEventHandler.touchScreenRotate(gestureEvent, gestureEvent.getX(), gestureEvent.getY());
                break;
            }
        }
        logChannel.log(1078071040, "AbstractScreenWidget#triggerGestureEvent -> finished\n");
    }

    @Override
    public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }

    @Override
    public void processKeyEvent(KeyEvent keyEvent) {
        switch (keyEvent.getID()) {
            case 10401: {
                this.keyPressed(keyEvent);
                break;
            }
            case 10402: {
                this.keyReleased(keyEvent);
                break;
            }
            case 10403: {
                if (!(keyEvent instanceof WheelButtonEvent)) break;
                this.keyTurned((WheelButtonEvent)keyEvent);
                break;
            }
            case 10404: {
                if (!(keyEvent instanceof JoystickEvent)) break;
                this.keyMoved((JoystickEvent)keyEvent);
                break;
            }
            default: {
                logChannel.log(-1601830656, "AbstractScreenWidget.processKeyEvent(%1) - invalid key event", (Object)keyEvent);
            }
        }
    }

    @Override
    public void processTouchPadEvent(TouchEvent touchEvent) {
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
                logChannel.log(-1601830656, "AbstractScreenWidget.processTouchPadEvent(%1) - invalid touch event", (Object)touchEvent);
            }
        }
    }

    @Override
    public void processGestureEvent(GestureEvent gestureEvent) {
        this.triggerGestureEvent(gestureEvent);
    }

    public boolean isTopLevelScreen() {
        return this.toplevelScreen;
    }

    public boolean isEventBlocked(ATIPEvent aTIPEvent) {
        boolean bl = false;
        if (this.locked) {
            if (aTIPEvent instanceof KeyEvent) {
                bl = this.isKeyEventBlockedDuringLock((KeyEvent)aTIPEvent);
            } else if (aTIPEvent instanceof TouchEvent) {
                bl = true;
            } else if (aTIPEvent instanceof JoystickEvent) {
                bl = true;
            } else if (aTIPEvent instanceof GestureEvent) {
                bl = true;
            }
        }
        return bl;
    }

    private boolean isKeyEventBlockedDuringLock(KeyEvent keyEvent) {
        boolean bl;
        block8: {
            block7: {
                bl = false;
                if (keyEvent.getID() != 10401 && keyEvent.getID() != 10402) break block7;
                int n = keyEvent.getKeyCode();
                switch (this.lockMode) {
                    case 0: {
                        bl = true;
                        break;
                    }
                    case 2: {
                        if (n == 17 || n == 15) {
                            bl = true;
                            break;
                        }
                        break block8;
                    }
                    case 1: {
                        if (n == 17) {
                            bl = true;
                            break;
                        }
                        break block8;
                    }
                    default: {
                        screenLogChannel.log(-1601830656, "ScreenWidget#isKeyEventBlocked unknown lockMode event keyCode: %1 received, lockMode: %2", (long)n, (long)this.lockMode);
                        break;
                    }
                }
                break block8;
            }
            bl = true;
        }
        return bl;
    }

    public void setToplevelScreen(boolean bl) {
        this.toplevelScreen = bl;
    }

    public void setClearMethod(int n) {
        this.clearMethod = n;
    }

    public int getScreenMode() {
        return this.screenMode;
    }

    @Override
    public void updatedColorScheme(int n) {
        this.defineColorPlate(n);
    }

    public int getSmallStageType() {
        return this.smallStageType;
    }

    public void setSmallStageType(int n) {
        this.smallStageType = n;
    }

    @Override
    public int[] getHmiAppsToNotifyForVisibility() {
        return this.hmiAppsToNotifyForVisibility;
    }

    public void setHmiAppsToNotifyForVisibility(int[] nArray) {
        this.hmiAppsToNotifyForVisibility = nArray;
    }

    protected boolean isHMIFullscreenPopup() {
        return false;
    }

    public void requestLargeViewSizeIfNeeded() {
        logViewSize.log(-2137614336, "AbstractScreenWidget#requestLargeViewSizeIfNeeded for screen with id = %1", (long)this.getScreenId());
        if (this.getScreenId() != -1) {
            IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
            boolean bl = false;
            boolean bl2 = false;
            bl2 |= iViewSizeManager.isHMIPopupHandlingActive() && (iViewSizeManager.isRequestActive(12) || this.isHMIFullscreenPopup());
            if (bl2 |= iViewSizeManager.isKombiPopupHandlingActive() && iViewSizeManager.isRequestActive(13)) {
                iViewSizeManager.setLocked(true, false);
                bl = true;
            }
            long l = 0L;
            switch (this.smallStageType) {
                case 2: {
                    l |= 0;
                    break;
                }
                case 3: {
                    l |= 0;
                    break;
                }
                case 8: {
                    l |= 0;
                    break;
                }
                case 4: {
                    l |= 0;
                    break;
                }
                case 9: {
                    l |= 0;
                    break;
                }
            }
            if (this.getScreenMode() == 2 && this.smallStageType != 10) {
                l |= 0;
            }
            if (this.isLargeViewSizePreferred()) {
                l |= 0;
            }
            if (l > 0L) {
                iViewSizeManager.requestLargeViewSizeViaBitfield(l);
            }
            if (!(bl2 || this.smallStageType != 2 && this.smallStageType != 3 || iViewSizeManager.getCurrentViewSize() != 1 || l == 0L || iViewSizeManager.isLocked())) {
                this.setSmallStageIconOnScreen(false);
            }
            if (bl) {
                iViewSizeManager.setLocked(false, false);
            }
        }
    }

    public boolean isLargeViewSizeNeeded() {
        IViewSizeManager iViewSizeManager;
        int n = -1;
        switch (this.smallStageType) {
            case 2: {
                n = 2;
                break;
            }
            case 3: {
                n = 3;
                break;
            }
            case 8: {
                n = 4;
                break;
            }
            case 4: {
                n = 5;
                break;
            }
        }
        int n2 = -1;
        if (this.terminal != null && (iViewSizeManager = this.terminal.getViewSizeManager()) != null) {
            n2 = iViewSizeManager.getCurrentViewSize();
        }
        boolean bl = this.isLargeViewSizePreferred();
        bl |= n != -1;
        return bl |= n2 == 2 && this.smallStageType == 9;
    }

    protected void unrequestLargeViewSizeIfNeeded() {
        if (this.getScreenId() != -1) {
            logViewSize.log(-2137614336, "AbstractScreenWidget#unrequestLargeViewSizeIfNeeded for screen with id = %1", (long)this.getScreenId());
            int n = -1;
            switch (this.smallStageType) {
                case 2: {
                    n = 2;
                    break;
                }
                case 3: {
                    n = 3;
                    break;
                }
                case 8: {
                    n = 4;
                    break;
                }
                case 4: {
                    n = 5;
                    break;
                }
                case 9: {
                    n = 14;
                    break;
                }
            }
            IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
            if (n != -1) {
                iViewSizeManager.unrequestLargeViewSize(n);
            }
            if (this.getScreenMode() == 2 && this.getSmallStageType() != 10) {
                iViewSizeManager.unrequestLargeViewSize(6);
            }
            if (this.isLargeViewSizePreferred()) {
                iViewSizeManager.unrequestLargeViewSize(9);
            }
            if (this.getMainArea() != null && !this.getMainArea().isFocusableInSmallStage()) {
                iViewSizeManager.unrequestLargeViewSize(8);
                iViewSizeManager.unrequestLargeViewSize(7);
            }
            iViewSizeManager.releaseInvalidation();
        }
    }

    public boolean isLargeViewSizePreferred() {
        return this.largeViewSizePreferred;
    }

    public void setLargeViewSizePreferred(boolean bl) {
        this.largeViewSizePreferred = bl;
    }

    public boolean isOptionIconVisible() {
        return this.optionIconVisible;
    }

    public void setOptionIconVisible(boolean bl) {
        this.optionIconVisible = bl;
    }

    public int getOptionIconOffsetX() {
        return this.optionIconOffsetX;
    }

    public void setOptionIconOffsetX(int n) {
        this.optionIconOffsetX = n;
    }

    public int getOptionIconOffsetY() {
        return this.optionIconOffsetY;
    }

    public void setOptionIconOffsetY(int n) {
        this.optionIconOffsetY = n;
    }

    public boolean isDisableLeftBack() {
        return this.disableLeftBack;
    }

    public void setDisableLeftBack(boolean bl) {
        this.disableLeftBack = bl;
    }

    public void setSmallStageIconOnScreen(boolean bl) {
        if (this.smallStageIcon != null && this.smallStageIcon.isOnScreen() != bl) {
            logViewSize.log(-2137614336, "AbstractScreenWidget#setSmallStageIconOnScreen onScreen = %1.", bl);
            this.smallStageIcon.setOnScreen(bl);
        }
    }

    @Override
    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
    }

    @Override
    public void updateDrawers(IScreenData iScreenData) {
        if (this.initContext.getSelectionDrawerID() != iScreenData.getSelectionDrawerID()) {
            this.terminal.getDrawerManager().activateSelectionDrawer(iScreenData.getSelectionDrawerID());
        }
        if (this.initContext.getOptionDrawerID() != iScreenData.getOptionsDrawerID()) {
            this.terminal.getDrawerManager().activateOptionDrawer(iScreenData.getOptionsDrawerID(), iScreenData.getContextIDs());
        }
    }

    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public void managePaint(RedrawContext redrawContext) {
        super.managePaint(redrawContext);
        if (this.renderer != null) {
            this.renderer.invalidateViewPort();
        }
    }

    static {
        touchPadAvailabilityInitialized = false;
        firstPaint = true;
        ERROR_COLOR_PLATE = new int[]{-65281, -65281, -65281, -65281, -65281, -65281, -65281, -65281};
    }
}

