/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractIdleTimerController;

public class IdleTimerController
extends AbstractIdleTimerController {
    public static final int TYPE_NOTIFY_APP = 0;
    public static final int TYPE_FIRE_EVENT = 1;
    private int defaultIdleTime = 10000;
    private int triggerType = 0;
    private int sdsStatusModelId = 335;

    public IdleTimerController() {
        super(screenLogChannel);
        this.startTimerAutomatically = false;
    }

    protected void initializeWidget() {
        if (this.model != null) {
            this.updateValue();
        } else {
            this.idleTime = this.defaultIdleTime;
        }
        super.initializeWidget();
    }

    protected void timerFired() {
        ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)((Object)hmiService.getModel(this.sdsStatusModelId));
        if (choiceModelGUI == null || choiceModelGUI.getValue() == 0) {
            if (this.model != null && this.triggerType == 0) {
                screenLogChannel.log(10000000, "IdleTimerController#fireTimer calling keyPressed/keyTyped at model modelID: %2, model: %1", this.model, (long)this.modelID);
                ButtonModelGUI buttonModelGUI = (ButtonModelGUI)this.model;
                buttonModelGUI.keyPressed(0, this.initContext.getTerminalID());
                buttonModelGUI.keyTyped(0, this.initContext.getTerminalID());
            } else if (this.event != 0) {
                screenLogChannel.log(10000000, "IdleTimerController#fireTimer calling fireSMEvent on terminalID: %1, event: %2", (long)this.initContext.getTerminalID(), (long)this.event);
                this.fireSMEvent(this.initContext.getTerminalID(), this.event);
            } else {
                screenLogChannel.log(1000000, "IdleTimerController#fireTimer timer expired, but no model or event configured");
            }
        }
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent.getModelId() == this.sdsStatusModelId) {
            if (modelUpdateEvent.getUpdateType() == 1) {
                this.handleSDSmodelUpdate();
            }
        } else {
            this.updateValue();
            this.handleModelUpdate();
        }
    }

    private void handleModelUpdate() {
        if (this.model instanceof AbstractModel) {
            int n = ((AbstractModel)this.model).getStatus();
            if (n == 0) {
                this.cancelTimer();
            } else {
                this.setActive(true);
                this.restartTimer();
            }
        }
    }

    private void handleSDSmodelUpdate() {
        ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)((Object)hmiService.getModel(this.sdsStatusModelId));
        if (choiceModelGUI != null && choiceModelGUI.getValue() == 0) {
            screenLogChannel.log(10000000, "IdleTimerController#handleSDSmodelUpdate SDS dialog finished - restarting idleTimer");
            this.setActive(true);
            this.restartTimer();
        } else {
            this.cancelTimer();
        }
    }

    public void setIdleTimeout(int n) {
        this.defaultIdleTime = n;
    }

    public void updateValue() {
        if (this.model instanceof ChoiceModelGUI) {
            int n = 0;
            n = ((ChoiceModelGUI)this.model).getValue();
            this.idleTime = n == 0 ? this.defaultIdleTime : n;
            if (this.idleTime < 0) {
                this.cancelTimer();
            }
            screenLogChannel.log(10000000, "IdleTimerController#updateValue read idleTime from model - modelIdleTimeout: %1, current real idle timeout: %2", (long)n, (long)this.idleTime);
        }
    }

    public void setTriggerType(int n) {
        this.triggerType = n;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public void setSdsStatusModelId(int n) {
        this.sdsStatusModelId = n;
    }
}

