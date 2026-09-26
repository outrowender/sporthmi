/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.hmi.evo.IPartialPopupControllerEvo;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.audi.tghu.hmi.evo.IScreenEvo;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PopupDrawerController;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractPartialPopupController
extends AbstractWidgetController
implements IPartialPopupControllerEvo,
TimerListener,
IScreenEvo {
    private static final boolean DEFAULT_UPDATE_FROM_MODEL_ON_CONNECT;
    public static final int PARTIAL_POPUP_SCREEN_ID;
    protected int popupID;
    private int popupPrio;
    protected IPartialPopupManagerEvo popupManager;
    private boolean surviveScreenChange;
    protected int[] invisibleChoiceValues;
    protected int autoHideTime;
    private Timer autoHideTimer;
    private int timerMode = 0;
    private int style = 2;
    protected int type = 8;
    protected int slot = 0;
    protected HMIView[][] views;
    protected int hkReturnEvent = 0;
    private boolean popupActive = true;
    protected boolean greyOutBackground;
    protected boolean tempGrayOut = this.greyOutBackground = false;
    protected AbstractWidget[][] conditionWidgets = null;
    private boolean updateFromModelOnConnect = true;
    private int[] viewModelIDs;
    protected int[] replacementIDs = null;
    protected HMIView[][] replacementWidgets = null;
    protected int consumeHKAppChange = 0;
    protected int consumeHKReturn = 0;
    protected int consumeDDSPress = 0;
    protected int consumeKeyTurned = 0;
    protected int consumeSKPress = 0;
    protected int consumeJoystickNorth = 0;
    protected int consumeJoystickEast = 0;
    protected int consumeJoystickSouth = 0;
    protected int consumeJoystickWest = 0;
    protected int consumeTouchpad = 0;
    private int layer = 0;
    private int[] modelIDs = null;
    private int[] eventIDs = null;
    private boolean relatedToMainAreaFocus = false;
    private int zpmSlot;
    private int zpmPriority;
    private int consumeGeneric;
    private int[] consumeGenericKeyIDs;
    protected boolean allowsFallbackScreen = true;
    private PopupDrawerController popupDrawerController;
    private int focusedLayer = -1;

    public AbstractPartialPopupController() {
        this.role |= 0x1000;
    }

    public AbstractPartialPopupController(int n) {
        this();
        this.setID(n);
    }

    public final String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(": Id=").append(this.getID()).toString();
    }

    @Override
    public void triggerRepaint() {
        if (this.parent == null) {
            if (this.terminal != null) {
                if (this.terminal.getRootWindow().getCurrentScreen() != null) {
                    ((AbstractScreenWidget)this.terminal.getRootWindow().getCurrentScreen()).doCheckedRepaint();
                } else {
                    this.terminal.getRootWindow().repaint();
                }
            } else {
                AbstractPartialPopupManager.LOGPOPUPS.log(10000, "AbstractPartialPopupController#triggerRepaint terminal is null repaint is ignored at popup with ID %1", (Object)this.getPopupName());
            }
        } else {
            super.triggerRepaint();
        }
    }

    protected String getPopupName() {
        if (this.popupManager instanceof AbstractPartialPopupManager) {
            return ((AbstractPartialPopupManager)this.popupManager).getPopupName(this.popupID);
        }
        return String.valueOf(this.popupID);
    }

    private Timer getAutoHideTimer() {
        if (this.autoHideTimer == null) {
            this.autoHideTimer = new Timer("AudioHideTimer", Math.max(1, this.autoHideTime), true, new TimerSyncer(this));
        }
        return this.autoHideTimer;
    }

    @Override
    public void connected(boolean bl, boolean bl2) {
        boolean bl3 = this.updateFromModelOnConnect;
        this.updateFromModelOnConnect = bl2;
        this.connected(new ScreenData(bl));
        this.updateFromModelOnConnect = bl3;
    }

    @Override
    protected void initializeWidget() {
        this.popupManager = this.terminal.getPartialPopupManagerEvo();
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(-2137614336, "AbstractPartialPopupController#connecting partial popup with ID %1", (Object)this.getPopupName());
        }
        super.initializeWidget();
        this.registerPopup();
        this.setVisible(false);
        this.executeAllConditions();
    }

    @Override
    protected void afterConnected() {
        super.afterConnected();
        if (this.updateFromModelOnConnect) {
            this.checkModelStatusAndInformPopupManager();
        }
    }

    protected void registerPopup() {
        this.popupManager.registerPopup(this);
        if (this.type == 7) {
            this.terminal.getWidgetRegistry().newScreenConnected(this);
        }
    }

    @Override
    public void predisconnecting() {
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(-2137614336, "AbstractPartialPopupController#predisconnecting partial popup with ID %1", (Object)this.getPopupName());
        }
        this.cancelAutoHideTimer();
        this.deregisterPopup();
        super.predisconnecting();
    }

    private void deregisterPopup() {
        if (this.popupManager != null) {
            this.popupManager.deregisterPopup(this);
        }
        if (this.type == 7 && this.isConnected()) {
            this.terminal.getWidgetRegistry().screenDisconnected(this);
        }
    }

    @Override
    public boolean checkModelStatusAndInformPopupManager() {
        if (this.popupManager == null) {
            this.setVisible(false);
            return false;
        }
        if (this.model == null) {
            return false;
        }
        boolean bl = false;
        boolean bl2 = this.isVisible();
        int n = ((ChoiceModelGUI)this.model).getValue();
        if (this.invisibleChoiceValues == null) {
            if (n != 0) {
                int n2;
                if (AbstractPartialPopupManager.LOGPOPUPS.isInfo()) {
                    AbstractPartialPopupManager.LOGPOPUPS.log(1078071040, "AbstractPartialPopupController#checkModelStatusAndInformPopupManager popupID: %1, modelValue is %2 -> showPopup()", (Object)this.getPopupName(), (long)n);
                }
                bl = (n2 = this.popupManager.showPopup(this.popupID)) == 1;
            } else {
                if (AbstractPartialPopupManager.LOGPOPUPS.isInfo()) {
                    AbstractPartialPopupManager.LOGPOPUPS.log(1078071040, "AbstractPartialPopupController#checkModelStatusAndInformPopupManager popupID: %1 modelValue is 0 -> hidePopup()", (Object)this.getPopupName());
                }
                bl = false;
                this.popupManager.hidePopup(this.popupID);
            }
        } else {
            int n3;
            boolean bl3 = false;
            for (n3 = 0; n3 < this.invisibleChoiceValues.length; ++n3) {
                if (this.invisibleChoiceValues[n3] != n) continue;
                bl3 = true;
                break;
            }
            if (!bl3) {
                bl = true;
                if (AbstractPartialPopupManager.LOGPOPUPS.isInfo()) {
                    AbstractPartialPopupManager.LOGPOPUPS.log(1078071040, "AbstractPartialPopupController#checkModelStatusAndInformPopupManager popupID: %1 modelValue is %2 -> showPopup()", (Object)this.getPopupName(), (long)n);
                }
                bl = (n3 = this.popupManager.showPopup(this.popupID)) == 1;
            } else {
                bl = false;
                if (AbstractPartialPopupManager.LOGPOPUPS.isInfo()) {
                    AbstractPartialPopupManager.LOGPOPUPS.log(1078071040, "AbstractPartialPopupController#checkModelStatusAndInformPopupManager popupID: %1 modelValue is %2 -> hidePopup()", (Object)this.getPopupName(), (long)n);
                }
                this.popupManager.hidePopup(this.popupID);
            }
        }
        return bl2 != bl;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.processModelUpdateEventWithBoolean(modelUpdateEvent);
    }

    @Override
    public boolean processModelUpdateEventWithBoolean(ModelUpdateEvent modelUpdateEvent) {
        boolean bl = false;
        if (this.isEventFromOwnModel(modelUpdateEvent)) {
            switch (modelUpdateEvent.getUpdateType()) {
                case 1: {
                    bl |= this.checkModelStatusAndInformPopupManager();
                    break;
                }
                case 2: {
                    break;
                }
                default: {
                    AbstractPartialPopupManager.LOGPOPUPS.log(10000, "AbstractPartialPopupController#processModelUpdateEvent unknown updateType: %1 ", (long)modelUpdateEvent.getUpdateType());
                }
            }
        }
        return bl |= this.handOverUpdateEventToChildren(modelUpdateEvent);
    }

    private boolean isEventFromOwnModel(ModelUpdateEvent modelUpdateEvent) {
        if (this.model == null) {
            return false;
        }
        if (modelUpdateEvent.getModelType() != 2) {
            return false;
        }
        if (this.model instanceof HMIModel) {
            HMIModel hMIModel = (HMIModel)this.model;
            return modelUpdateEvent.getModelId() == hMIModel.getID();
        }
        return false;
    }

    protected boolean handOverUpdateEventToChildren(ModelUpdateEvent modelUpdateEvent) {
        boolean bl = false;
        if (modelUpdateEvent.getModelType() == 100) {
            ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
            for (int i2 = 0; i2 < modelUpdateEventArray.length; ++i2) {
                bl |= this.propagateModelUpdateEvent(modelUpdateEventArray[i2], AbstractPartialPopupManager.LOGPOPUPS);
            }
        } else {
            bl |= this.propagateModelUpdateEvent(modelUpdateEvent, AbstractPartialPopupManager.LOGPOPUPS);
        }
        return bl;
    }

    protected boolean propagateModelUpdateEvent(ModelUpdateEvent modelUpdateEvent, LogChannel logChannel) {
        HMIView[] hMIViewArray;
        HMIView[] hMIViewArray2;
        if (modelUpdateEvent == null) {
            logChannel.log(10000, "AbstractPartialPopupController#propagateModelUpdateEvent modelUpdateEvent is: %1", (Object)modelUpdateEvent);
            return false;
        }
        boolean bl = false;
        int n = modelUpdateEvent.getModelId();
        HMIView[] hMIViewArray3 = this.findViews(n);
        if (hMIViewArray3 != null) {
            for (int i2 = 0; i2 < hMIViewArray3.length; ++i2) {
                if (hMIViewArray3[i2] == this) continue;
                hMIViewArray3[i2].processModelUpdateEvent(modelUpdateEvent);
                bl = true;
            }
        }
        if ((hMIViewArray2 = this.findConditionWidgets(n)) != null) {
            if (logChannel.isDebug()) {
                logChannel.log(-2137614336, "AbstractPartialPopupController#propagateModelUpdateEvent: %1 conditionWidgets found for modelID %2", (long)hMIViewArray2.length, (long)modelUpdateEvent.getModelId());
            }
            this.screenFactory.executeCondition(n, this.popupID, hMIViewArray2, this.terminal.getTerminalID());
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

    public void setInvisibleChoiceValues(int[] nArray) {
        this.invisibleChoiceValues = nArray;
    }

    @Override
    public int getID() {
        return this.popupID;
    }

    public final void setID(int n) {
        this.popupID = n;
    }

    @Override
    public int getPriority() {
        if (this.zpmSlot != -1 && this.zpmPriority != -1) {
            if (this.popupManager == null) {
                this.popupManager = this.terminal.getPartialPopupManagerEvo();
            }
            return this.popupManager.getHMIPrio(this.zpmSlot, this.zpmPriority);
        }
        return this.popupPrio;
    }

    public void setPriority(int n) {
        this.popupPrio = n;
    }

    public void setPopupActive(boolean bl) {
        this.popupActive = bl;
    }

    @Override
    public boolean isPopupActive() {
        return this.popupActive;
    }

    @Override
    public int show(int n) {
        if (!this.isEnabled()) {
            if (AbstractPartialPopupManager.LOGPOPUPS.isDebug()) {
                AbstractPartialPopupManager.LOGPOPUPS.log(-2137614336, "AbstractPartialPopupController#show not showing partial popup with ID %1 because it is disabled", (Object)this.getPopupName());
            }
            return 2;
        }
        if (!this.isPopupActive()) {
            if (AbstractPartialPopupManager.LOGPOPUPS.isDebug()) {
                AbstractPartialPopupManager.LOGPOPUPS.log(-2137614336, "AbstractPartialPopupController#show not showing partial popup with ID %1 because it is inactive", (Object)this.getPopupName());
            }
            return 2;
        }
        this.restartAutoHideTimer();
        return 1;
    }

    @Override
    public int hide(int n) {
        this.cancelAutoHideTimer();
        return 1;
    }

    @Override
    public void setAutoHideTime(int n) {
        this.autoHideTime = n;
        if (this.autoHideTime > 0) {
            this.getAutoHideTimer().setDelay(this.autoHideTime);
        } else {
            this.cancelAutoHideTimer();
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer == this.getAutoHideTimer()) {
            if (AbstractPartialPopupManager.LOGPOPUPS.isDebug()) {
                AbstractPartialPopupManager.LOGPOPUPS.log(-2137614336, "AbstractPartialPopupController#fireTimer called for popup with ID %1", (Object)this.getPopupName());
            }
            this.popupManager.hidePopup(this.popupID);
            if (this.timerMode == 1) {
                this.keyPressedOnModel(0);
            }
            if (IWidgetLogChannel.logRepaintCause.isDebug()) {
                IWidgetLogChannel.logRepaintCause.log(-2137614336, "AbstractPartialPopupController#fireTimer: popup: %1, trigger repaint", (Object)this.getPopupName());
            }
            this.triggerRepaint();
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(-2137614336, "AbstractPartialPopupController#cancelTimer called for popup with ID %1", (Object)this.getPopupName());
        }
    }

    @Override
    public void restartAutoHideTimer() {
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(-2137614336, "AbstractPartialPopupController#restartAutoHideTimer called for popup with ID %1, autoHideTime is %2", (Object)this.getPopupName(), (long)this.autoHideTime);
        }
        if (this.autoHideTime > 0) {
            this.getAutoHideTimer().restart();
        }
    }

    private void cancelAutoHideTimer() {
        if (this.autoHideTimer != null && !this.autoHideTimer.isCanceled()) {
            this.autoHideTimer.cancel();
        }
    }

    @Override
    public int getStyle() {
        return this.style;
    }

    public void setStyle(int n) {
        this.style = n;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public void setType(int n) {
        this.type = n;
    }

    @Override
    public void setScreenFactory(AbstractScreenFactory abstractScreenFactory) {
        this.screenFactory = abstractScreenFactory;
    }

    @Override
    public int getCacheBehaviour() {
        return 0;
    }

    @Override
    public int[] getConditionIDs() {
        return this.conditionIDs;
    }

    public void setConditionWidgets(int[] nArray, AbstractWidget[][] abstractWidgetArray) {
        this.conditionIDs = nArray;
        this.conditionWidgets = abstractWidgetArray;
    }

    protected AbstractWidget[] findConditionWidgets(int n) {
        return (AbstractWidget[])this.findWidgets(this.conditionWidgets, this.conditionIDs, n);
    }

    @Override
    public int[] getViewIDs() {
        return this.viewModelIDs;
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
    public int getEventProcessing() {
        return 0;
    }

    @Override
    public int[] getReplacementIDs() {
        return this.replacementIDs;
    }

    @Override
    public void setReplacementWidgets(int[] nArray, HMIView[][] hMIViewArray) {
        this.replacementIDs = nArray;
        this.replacementWidgets = hMIViewArray;
    }

    @Override
    public AbstractScreenFactory getScreenFactory() {
        return this.screenFactory;
    }

    @Override
    public HMITerminal getTerminal() {
        return this.terminal;
    }

    @Override
    public int getTerminalID() {
        if (this.terminal != null) {
            return this.terminal.getTerminalID();
        }
        return 0;
    }

    @Override
    public HMIView[] getViews() {
        HMIView[] hMIViewArray = null;
        if (this.views != null) {
            int n;
            int n2;
            ArrayList arrayList = new ArrayList(15);
            for (n2 = 0; n2 < this.views.length; ++n2) {
                if (this.views[n2] == null) continue;
                for (n = 0; n < this.views[n2].length; ++n) {
                    if (this.views[n2][n] == null) continue;
                    arrayList.add(this.views[n2][n]);
                }
            }
            n2 = arrayList.size();
            hMIViewArray = new HMIView[n2];
            for (n = 0; n < n2; ++n) {
                hMIViewArray[n] = (HMIView)arrayList.get(n);
            }
        }
        return hMIViewArray;
    }

    @Override
    public void setViews(int[] nArray, HMIView[][] hMIViewArray) {
        this.views = hMIViewArray;
        this.viewModelIDs = nArray;
    }

    @Override
    public boolean hasErrorOccured() {
        return false;
    }

    @Override
    public void paint() {
    }

    @Override
    public void processSDSEvent(SDSEvent sDSEvent) {
    }

    @Override
    public void setEventIDs(int[] nArray) {
        this.eventIDs = nArray;
    }

    @Override
    public void setLocked(boolean bl) {
    }

    @Override
    public void setModelIDs(int[] nArray) {
        this.modelIDs = nArray;
    }

    @Override
    public void setState(int[] nArray) {
    }

    @Override
    public void setTerminal(HMITerminal hMITerminal) {
        this.terminal = (HMITerminalImpl)hMITerminal;
    }

    public HMIView[] findViews(int n) {
        return this.findWidgets(this.views, this.viewModelIDs, n);
    }

    private HMIView[] findWidgets(HMIView[][] hMIViewArray, int[] nArray, int n) {
        int n2;
        if (hMIViewArray != null && nArray != null && (n2 = Arrays.binarySearch(nArray, n)) >= 0) {
            return hMIViewArray[n2];
        }
        return null;
    }

    protected HMIView[] findReplacementWidgets(int n) {
        return this.findWidgets(this.replacementWidgets, this.replacementIDs, n);
    }

    @Override
    public void setScreenType(int n) {
        this.type = n;
    }

    @Override
    public int getScreenType() {
        return this.type;
    }

    public void setSurviveScreenChange(boolean bl) {
        this.surviveScreenChange = bl;
    }

    @Override
    public boolean survivesScreenChange() {
        return this.surviveScreenChange;
    }

    public void setConsumeHKAppChange(int n) {
        this.consumeHKAppChange = n;
    }

    public int getConsumeHKAppChange() {
        return this.consumeHKAppChange;
    }

    @Override
    public void setConsumeHKReturn(int n) {
        this.consumeHKReturn = n;
    }

    @Override
    public void setConsumeDDSPress(int n) {
        this.consumeDDSPress = n;
    }

    @Override
    public void setConsumeKeyTurned(int n) {
        this.consumeKeyTurned = n;
    }

    @Override
    public void setConsumeSKPress(int n) {
        this.consumeSKPress = n;
    }

    @Override
    public void setConsumeTouchPad(int n) {
        this.consumeTouchpad = n;
    }

    @Override
    public void setConsumeGenericKeys(int n, int[] nArray) {
        this.consumeGeneric = n;
        this.consumeGenericKeyIDs = nArray;
    }

    private void keyPressedOnModel(int n) {
        if (this.model != null) {
            try {
                ((ButtonModelGUI)this.model).keyPressed(n, this.terminal.getTerminalID());
                ((ButtonModelGUI)this.model).keyTyped(n, this.terminal.getTerminalID());
            }
            catch (ClassCastException classCastException) {
                AbstractPartialPopupManager.LOGPOPUPS.log(1000, "AbstractPartialPopupController#keyPressedOnModel --> %1", this.model, (Throwable)classCastException);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.isVisible()) {
            return;
        }
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug2()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(14808325, "AbstractPartialPopupController#keyPressed popupID=%1", (Object)this.getPopupName());
        }
        if (!this.shouldProcessEvent(keyEvent)) {
            return;
        }
        if (this.popupDrawerController != null) {
            this.popupDrawerController.keyPressed(keyEvent);
            if (keyEvent.isConsumed()) {
                return;
            }
        }
        if (this.focusedLayer == 2) {
            return;
        }
        int n = keyEvent.getKeyCode();
        if (n == 17 && this.consumeDDSPress != 0) {
            this.handleMenuEnterPressed(keyEvent, n);
        } else if (this.consumeHKAppChange == 1 && KeyEvent.isAppChangeHardkey(n)) {
            this.hideAndDelegateEventToModel(n);
        } else if (n == 15 && this.consumeHKReturn != 0) {
            this.handleBackPressed(keyEvent, n);
        } else if (n >= 9 && n <= 12 && this.consumeSKPress != 0) {
            this.handleSoftKeyPressed(keyEvent);
        } else if (n >= 43 && n <= 48 || n <= 79 || n <= 80) {
            super.keyPressed(keyEvent);
        } else if (this.consumeGenericKeyIDs != null) {
            for (int i2 = 0; i2 < this.consumeGenericKeyIDs.length; ++i2) {
                if (n != this.consumeGenericKeyIDs[i2] || this.consumeGeneric == 0) continue;
                if (this.consumeGeneric == 1) {
                    keyEvent.consume(true);
                    this.hideAndDelegateEventToModel(n);
                    continue;
                }
                if (this.consumeGeneric == 6) {
                    this.hideAndDelegateEventToModel(n);
                    continue;
                }
                if (this.consumeGeneric == 2) {
                    keyEvent.consume(false);
                    continue;
                }
                if (this.consumeGeneric == 3) {
                    keyEvent.consume(true);
                    this.fireSMEvent(this.terminal.getTerminalID(), this.event);
                    continue;
                }
                if (this.consumeGeneric == 4) {
                    super.keyPressed(keyEvent);
                    continue;
                }
                if (this.consumeGeneric == 5) {
                    super.keyPressed(keyEvent);
                    keyEvent.consume(false);
                    continue;
                }
                if (this.consumeGeneric != 7) continue;
                super.keyPressed(keyEvent);
                keyEvent.consume(false);
                if (this.popupManager == null) continue;
                this.popupManager.hidePopup(this.popupID);
            }
        }
    }

    private void handleSoftKeyPressed(KeyEvent keyEvent) {
        if (this.consumeSKPress == 2) {
            keyEvent.consume(true);
            if (this.popupManager != null) {
                this.popupManager.hidePopup(this.popupID);
            }
        } else if (this.consumeSKPress == 1) {
            super.keyPressed(keyEvent);
        } else if (this.consumeSKPress == 4) {
            keyEvent.consume(false);
        } else if (this.consumeSKPress == 3 && this.popupManager != null) {
            this.popupManager.hidePopup(this.popupID);
        }
    }

    private void handleBackPressed(KeyEvent keyEvent, int n) {
        if (this.consumeHKReturn == 1 || this.consumeHKReturn == 8) {
            keyEvent.consume(true);
            this.hideAndDelegateEventToModel(n);
        } else if (this.consumeHKReturn == 6) {
            this.hideAndDelegateEventToModel(n);
        } else if (this.consumeHKReturn == 2) {
            keyEvent.consume(false);
        } else if (this.consumeHKReturn == 3) {
            keyEvent.consume(true);
            this.fireSMEvent(this.terminal.getTerminalID(), this.hkReturnEvent);
        } else if (this.consumeHKReturn == 4) {
            super.keyPressed(keyEvent);
        } else if (this.consumeHKReturn == 5) {
            super.keyPressed(keyEvent);
            keyEvent.consume(false);
        } else if (this.consumeHKReturn == 7) {
            super.keyPressed(keyEvent);
            keyEvent.consume(false);
            if (this.popupManager != null) {
                this.popupManager.hidePopup(this.popupID);
            }
        }
    }

    private void handleMenuEnterPressed(KeyEvent keyEvent, int n) {
        switch (this.consumeDDSPress) {
            case 1: 
            case 9: {
                keyEvent.consume(true);
                this.hideAndDelegateEventToModel(n);
                break;
            }
            case 8: {
                this.hideAndDelegateEventToModel(n);
                break;
            }
            case 2: {
                keyEvent.consume(false);
                break;
            }
            case 3: {
                keyEvent.consume(true);
                this.fireSMEvent(this.terminal.getTerminalID(), this.event);
                break;
            }
            case 7: {
                keyEvent.consume(true);
                this.fireSMEvent(this.terminal.getTerminalID(), this.event);
                this.popupManager.hidePopup(this.popupID);
                break;
            }
            case 4: {
                super.keyPressed(keyEvent);
                break;
            }
            case 5: {
                super.keyPressed(keyEvent);
                keyEvent.consume(false);
                break;
            }
            case 6: {
                super.keyPressed(keyEvent);
                keyEvent.consume(true);
                this.popupManager.hidePopup(this.popupID);
                break;
            }
            default: {
                AbstractPartialPopupManager.LOGPOPUPS.log(-1601830656, "AbstractPartialPopupController#keyPressed popupID=%1 consumeDDSPress=%2 - ignoring event", (Object)this.getPopupName(), (long)this.consumeDDSPress);
            }
        }
    }

    private void hideAndDelegateEventToModel(int n) {
        if (this.popupManager != null) {
            this.popupManager.hidePopup(this.popupID);
            this.keyPressedOnModel(n);
        }
    }

    private boolean shouldProcessEvent(KeyEvent keyEvent) {
        boolean bl;
        if (!keyEvent.isConsumed()) {
            return true;
        }
        int n = keyEvent.getKeyCode();
        switch (n) {
            case 15: {
                bl = this.consumeHKReturn == 8;
                break;
            }
            case 17: {
                bl = this.consumeDDSPress == 9;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (!this.isVisible()) {
            return;
        }
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug2()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(14808325, "AbstractPartialPopupController#keyReleased popupID=%2 evt.isConsumed: %1", keyEvent.isConsumed(), (Object)this.getPopupName());
        }
        if (keyEvent.isConsumed()) {
            return;
        }
        if (this.popupDrawerController != null) {
            this.popupDrawerController.keyReleased(keyEvent);
            if (keyEvent.isConsumed()) {
                return;
            }
        }
        if (this.focusedLayer == 2) {
            return;
        }
        int n = keyEvent.getKeyCode();
        if (n == 17 && this.consumeDDSPress == 4) {
            super.keyReleased(keyEvent);
        } else if (n >= 9 && n <= 12 && this.consumeSKPress == 1) {
            super.keyReleased(keyEvent);
        } else if (n == 13 || n == 14) {
            super.keyReleased(keyEvent);
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (!this.isVisible()) {
            return;
        }
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug2()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(14808325, "AbstractPartialPopupController#keyTurned popupID=%1", (Object)this.getPopupName());
        }
        if (wheelButtonEvent.isConsumed()) {
            return;
        }
        if (this.popupDrawerController != null) {
            this.popupDrawerController.keyTurned(wheelButtonEvent);
            if (wheelButtonEvent.isConsumed()) {
                return;
            }
        }
        if (this.focusedLayer == 2) {
            return;
        }
        switch (this.consumeKeyTurned) {
            case 3: {
                if (this.popupManager == null) break;
                this.popupManager.hidePopup(this.popupID);
                this.keyPressedOnModel(wheelButtonEvent.getKeyCode());
                break;
            }
            case 2: {
                wheelButtonEvent.consume(false);
                break;
            }
            case 1: {
                wheelButtonEvent.consume(true);
                if (this.popupManager == null) break;
                this.popupManager.hidePopup(this.popupID);
                this.keyPressedOnModel(wheelButtonEvent.getKeyCode());
                break;
            }
            case 4: {
                super.keyTurned(wheelButtonEvent);
                break;
            }
            case 5: {
                super.keyTurned(wheelButtonEvent);
                wheelButtonEvent.consume(false);
                break;
            }
            case 0: {
                break;
            }
            default: {
                AbstractPartialPopupManager.LOGPOPUPS.log(-1601830656, "AbstractPartialPopupController#keyTurned popupID=%1 consumeKeyTurned=%2 - ignoring event", (Object)this.getPopupName(), (long)this.consumeKeyTurned);
            }
        }
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        if (!this.isVisible()) {
            return;
        }
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug2()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(14808325, "AbstractPartialPopupController#keyMoved popupID=%1", (Object)this.getPopupName());
        }
        if (joystickEvent.isConsumed()) {
            return;
        }
        if (this.popupDrawerController != null) {
            this.popupDrawerController.keyMoved(joystickEvent);
            if (joystickEvent.isConsumed()) {
                return;
            }
        }
        if (this.focusedLayer == 2) {
            return;
        }
        int n = this.getJoystickBehaviour(joystickEvent);
        switch (n) {
            case 3: {
                if (this.popupManager == null) break;
                this.popupManager.hidePopup(this.popupID);
                this.keyPressedOnModel(joystickEvent.getKeyCode());
                break;
            }
            case 2: {
                joystickEvent.consume(false);
                break;
            }
            case 1: {
                joystickEvent.consume(true);
                if (this.popupManager == null) break;
                this.popupManager.hidePopup(this.popupID);
                this.keyPressedOnModel(joystickEvent.getKeyCode());
                break;
            }
            case 4: {
                super.keyMoved(joystickEvent);
                break;
            }
            case 5: {
                super.keyMoved(joystickEvent);
                joystickEvent.consume(false);
                break;
            }
            case 0: {
                break;
            }
            default: {
                AbstractPartialPopupManager.LOGPOPUPS.log(-1601830656, "AbstractPartialPopupController#keyMoved popupID=%1 behaviour=%2 - ignoring event", (Object)this.getPopupName(), (long)n);
            }
        }
    }

    private boolean handleTouchEvent(TouchEvent touchEvent) {
        if (!this.isVisible()) {
            return false;
        }
        if (AbstractPartialPopupManager.LOGPOPUPS.isDebug2()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(14808325, "AbstractPartialPopupController#handleTouchEvent popupID=%1", (Object)this.getPopupName());
        }
        if (touchEvent.isConsumed()) {
            return false;
        }
        switch (this.consumeTouchpad) {
            case 2: {
                touchEvent.consume(true);
                if (this.popupManager != null) {
                    this.popupManager.hidePopup(this.popupID);
                }
                return false;
            }
            case 3: {
                if (this.popupManager != null) {
                    this.popupManager.hidePopup(this.popupID);
                }
                return false;
            }
            case 1: {
                return true;
            }
            case 0: {
                return false;
            }
            case 4: {
                touchEvent.consume(false);
                return false;
            }
        }
        AbstractPartialPopupManager.LOGPOPUPS.log(-1601830656, "AbstractPartialPopupController#handleTouchEvent popupID=%1 consumeTouchpad=%2 - ignoring event", (Object)this.getPopupName(), (long)this.consumeTouchpad);
        return false;
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        boolean bl = this.handleTouchEvent(touchEvent);
        if (bl) {
            super.touchPadPressed(touchEvent);
        }
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        boolean bl = this.handleTouchEvent(touchEvent);
        if (bl) {
            super.touchPadReleased(touchEvent);
        }
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        boolean bl = this.handleTouchEvent(touchEvent);
        if (bl) {
            super.touchPadPositionMoved(touchEvent);
        }
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        boolean bl = this.handleTouchEvent(touchEvent);
        if (bl) {
            super.touchPadCharactersRecognized(touchEvent);
        }
    }

    private int getJoystickBehaviour(JoystickEvent joystickEvent) {
        int n = joystickEvent.getDirection();
        switch (n) {
            case 2: {
                return this.consumeJoystickNorth;
            }
            case 4: {
                return this.consumeJoystickEast;
            }
            case 6: {
                return this.consumeJoystickSouth;
            }
            case 8: {
                return this.consumeJoystickWest;
            }
            case 0: {
                return 0;
            }
        }
        AbstractPartialPopupManager.LOGPOPUPS.log(10000, "AbstractPartialPopupController#getJoystickBehaviour: unknown joystick direction: %2 for event: %1", (Object)joystickEvent, (long)n);
        return 0;
    }

    @Override
    public void connected(IScreenData iScreenData) {
        if (logWidgetPerformance.isInfo()) {
            logWidgetPerformance.log(1078071040, "AbstractPartialPopupController#connected id %1 start", (Object)this.getPopupName());
        }
        long l = framework.getMonotonicTime();
        if (this.initContext == null) {
            this.initContext = new InitializationContext(this.terminal);
            this.initContext.setScreenFactory(this.screenFactory);
            this.initContext.setContextIDs(iScreenData.getContextIDs());
            this.initContext.setScreenID(-1);
            this.initContext.setScreen(this);
        }
        this.initContext.setReinit(iScreenData.isReinit());
        this.connected(this.initContext);
        if (logWidgetPerformance.isInfo()) {
            long l2 = framework.getMonotonicTime();
            logWidgetPerformance.log(1078071040, "AbstractPartialPopupController#connected id %1 finished, took %2 ms", (Object)this.getPopupName(), l2 - l);
        }
    }

    @Override
    public void disconnecting() {
        if (logWidgetPerformance.isInfo()) {
            logWidgetPerformance.log(1078071040, "AbstractPartialPopupController#disconnecting id %1 start", (Object)this.getPopupName());
        }
        long l = framework.getMonotonicTime();
        super.disconnecting();
        if (logWidgetPerformance.isInfo()) {
            long l2 = framework.getMonotonicTime();
            logWidgetPerformance.log(1078071040, "AbstractPartialPopupController#disconnecting id %1 finished, took %2 ms", (Object)this.getPopupName(), l2 - l);
        }
    }

    @Override
    public void hidePartialPopups(int[] nArray) {
    }

    @Override
    public void showPartialPopups(int[] nArray) {
    }

    @Override
    public void setHKReturnEvent(int n) {
        this.hkReturnEvent = n;
    }

    public abstract void shiftHorizontal(int n) {
    }

    protected void executeAllConditions() {
        if (this.conditionIDs != null && this.conditionWidgets != null) {
            for (int i2 = 0; i2 < this.conditionIDs.length; ++i2) {
                try {
                    this.screenFactory.executeCondition(this.conditionIDs[i2], this.popupID, this.conditionWidgets[i2], this.terminal.getTerminalID());
                    continue;
                }
                catch (NullPointerException nullPointerException) {
                    AbstractPartialPopupManager.LOGPOPUPS.log(1000, "AbstractPartialPopupController#executeAllConditions problems executing condition for model id: %1 popupID: %2", (long)this.conditionIDs[i2], (long)this.popupID);
                    AbstractPartialPopupManager.LOGPOPUPS.log(10000, "AbstractPartialPopupController#executeAllConditions ERROR=%1", (Throwable)nullPointerException);
                }
            }
        }
    }

    @Override
    public int[] getCurrentColorPalette() {
        return new int[0];
    }

    @Override
    public void notifyPartialPopup(int n, int n2) {
    }

    public void setAutoHideTimerMode(int n) {
        if (n == 0 || n == 1) {
            this.timerMode = n;
        } else {
            AbstractPartialPopupManager.LOGPOPUPS.log(10000, "AbstractPartialPopupController#setTimerMode invalid timer mode %2 (popupID = %1)", (Object)this.getPopupName(), (long)n);
        }
    }

    @Override
    public int getSlot() {
        return this.slot;
    }

    @Override
    public void setSlot(int n) {
        this.slot = n;
    }

    @Override
    public boolean areAllPartialPopupsAllowed() {
        return true;
    }

    @Override
    public boolean isPartialPopupBlocked(IPartialPopupController iPartialPopupController) {
        return false;
    }

    @Override
    public void setShowPopupAfterConnecting(boolean bl) {
    }

    @Override
    public void updateContexts(long[] lArray) {
    }

    @Override
    public void setLayer(int n) {
        this.layer = n;
    }

    @Override
    public int getlayer() {
        return this.layer;
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
                AbstractPartialPopupManager.LOGPOPUPS.log(-1601830656, "AbstractPartialPopupController.processKeyEvent(%1) - invalid key event", (Object)keyEvent);
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
                AbstractPartialPopupManager.LOGPOPUPS.log(-1601830656, "AbstractPartialPopupController.processTouchPadEvent(%1) - invalid touch event", (Object)touchEvent);
            }
        }
    }

    @Override
    public void processGestureEvent(GestureEvent gestureEvent) {
        this.triggerGestureEvent(gestureEvent);
    }

    public int getConsumeJoystickNorth() {
        return this.consumeJoystickNorth;
    }

    public void setConsumeJoystickNorth(int n) {
        this.consumeJoystickNorth = n;
    }

    public int getConsumeJoystickEast() {
        return this.consumeJoystickEast;
    }

    public void setConsumeJoystickEast(int n) {
        this.consumeJoystickEast = n;
    }

    public int getConsumeJoystickSouth() {
        return this.consumeJoystickSouth;
    }

    public void setConsumeJoystickSouth(int n) {
        this.consumeJoystickSouth = n;
    }

    public int getConsumeJoystickWest() {
        return this.consumeJoystickWest;
    }

    public void setConsumeJoystickWest(int n) {
        this.consumeJoystickWest = n;
    }

    public boolean isRelatedToMainAreaFocus() {
        return this.relatedToMainAreaFocus;
    }

    public void setRelatedToMainAreaFocus(boolean bl) {
        this.relatedToMainAreaFocus = bl;
    }

    @Override
    public void updatedColorScheme(int n) {
    }

    public void setSmallStageType(int n) {
    }

    public void setUpdateFromModelOnConnect(boolean bl) {
        this.updateFromModelOnConnect = bl;
    }

    @Override
    public int[] getHmiAppsToNotifyForVisibility() {
        return new int[0];
    }

    public int getZpmSlot() {
        return this.zpmSlot;
    }

    public void setZpmSlot(int n) {
        this.zpmSlot = n;
    }

    public int getZpmPriority() {
        return this.zpmPriority;
    }

    public void setZpmPriority(int n) {
        this.zpmPriority = n;
    }

    public boolean isGreyOutBackground() {
        return this.greyOutBackground;
    }

    public void setGreyOutBackground(boolean bl) {
        this.tempGrayOut = this.greyOutBackground = bl;
    }

    @Override
    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof PopupDrawerController) {
            if (this.popupDrawerController != null) {
                AbstractPartialPopupManager.LOGPOPUPS.log(10000, "AbstractPartialPopupController#add only one drawer popup supported, this=%1", (Object)this);
            }
            this.popupDrawerController = (PopupDrawerController)abstractWidget;
        }
        super.add(abstractWidget);
    }

    @Override
    public boolean hasPopupDrawer() {
        return this.popupDrawerController != null;
    }

    @Override
    public void updateDrawers(IScreenData iScreenData) {
    }

    @Override
    public void setFocusedLayer(int n) {
        this.focusedLayer = n;
    }

    @Override
    public void closePopupDrawer() {
        if (this.popupDrawerController != null) {
            this.popupDrawerController.closePopupDrawer();
        }
    }

    @Override
    public boolean isFallbackScreenAllowed() {
        return this.allowsFallbackScreen;
    }

    @Override
    public void setFallbackScreenAllowed(boolean bl) {
        this.allowsFallbackScreen = bl;
    }
}

