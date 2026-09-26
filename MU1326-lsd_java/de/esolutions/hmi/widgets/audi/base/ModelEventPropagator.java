/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.util.ArrayList;
import java.util.List;

public class ModelEventPropagator
implements IWidgetLogChannel {
    private boolean processed;
    private List calledWidgetsForModelGroupEvent;
    private final ModelUpdateEvent eventFromQueue;
    private final AbstractScreenWidget rootWidget;

    public ModelEventPropagator(ModelUpdateEvent modelUpdateEvent, AbstractScreenWidget abstractScreenWidget) {
        this.eventFromQueue = modelUpdateEvent;
        this.rootWidget = abstractScreenWidget;
        this.calledWidgetsForModelGroupEvent = null;
        this.processed = false;
    }

    public boolean propagate() {
        if (this.eventFromQueue == null) {
            screenLogChannel.log(10000, "ModelEventPropagator#propagate: event is null. screen: %1", (Object)this.rootWidget);
            return false;
        }
        if (this.eventFromQueue.getModelType() == 100) {
            this.processModelGroupEvent(this.eventFromQueue);
        } else {
            this.processSingleEvent(this.eventFromQueue);
        }
        return this.processed;
    }

    private void processModelGroupEvent(ModelUpdateEvent modelUpdateEvent) {
        ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
        for (int i2 = 0; i2 < modelUpdateEventArray.length; ++i2) {
            ModelUpdateEvent modelUpdateEvent2 = modelUpdateEventArray[i2];
            if (this.isForOwnTerminal(modelUpdateEvent2)) {
                this.processSingleEvent(modelUpdateEvent2);
                AbstractWidget.hmiService.getEventDispatcher().doCheckedSleepingInternal();
                continue;
            }
            if (!screenLogChannel.isDebug()) continue;
            screenLogChannel.log(-2137614336, "ModelEventPropagator#processModelUpdateEvent is called. modelUpdateTerminalID: %1, screen.terminalID: %2", (long)modelUpdateEvent2.getTerminalID(), (long)this.getScreenTerminalID());
        }
    }

    private boolean isForOwnTerminal(ModelUpdateEvent modelUpdateEvent) {
        return modelUpdateEvent.getTerminalID() == -1 || modelUpdateEvent.getTerminalID() == this.getScreenTerminalID();
    }

    private void processSingleEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        this.updateWidgets(modelUpdateEvent);
        this.executeConditions(n);
        this.updateTextReplacement(n);
    }

    private void updateWidgets(ModelUpdateEvent modelUpdateEvent) {
        HMIView[] hMIViewArray = this.rootWidget.findViews(modelUpdateEvent.getModelId());
        if (hMIViewArray != null) {
            for (int i2 = 0; i2 < hMIViewArray.length; ++i2) {
                HMIView hMIView = hMIViewArray[i2];
                if (Util.equals(this.rootWidget, hMIView)) continue;
                this.propagateToWidget(modelUpdateEvent, hMIView);
                this.processed = true;
            }
        }
    }

    private void propagateToWidget(ModelUpdateEvent modelUpdateEvent, HMIView hMIView) {
        if (this.isNestedEvent(modelUpdateEvent) && this.canProcessModelGroupEvent(hMIView)) {
            if (!this.isModelGroupEventAlreadyPropagatedToWidget(hMIView)) {
                hMIView.processModelUpdateEvent(this.eventFromQueue);
                this.modelGroupEventPropagatedToWidget(hMIView);
            }
        } else {
            hMIView.processModelUpdateEvent(modelUpdateEvent);
        }
    }

    private boolean isModelGroupEventAlreadyPropagatedToWidget(HMIView hMIView) {
        return this.calledWidgetsForModelGroupEvent != null && this.calledWidgetsForModelGroupEvent.contains(hMIView);
    }

    private void modelGroupEventPropagatedToWidget(HMIView hMIView) {
        if (this.calledWidgetsForModelGroupEvent == null) {
            this.calledWidgetsForModelGroupEvent = new ArrayList(2);
        }
        this.calledWidgetsForModelGroupEvent.add(hMIView);
    }

    private boolean isNestedEvent(ModelUpdateEvent modelUpdateEvent) {
        return !Util.equals(modelUpdateEvent, this.eventFromQueue);
    }

    private boolean canProcessModelGroupEvent(HMIView hMIView) {
        return hMIView instanceof AbstractWidget && ((AbstractWidget)hMIView).canProcessModelGroupEvent();
    }

    private void executeConditions(int n) {
        HMIView[] hMIViewArray = this.rootWidget.findConditionWidgets(n);
        if (hMIViewArray != null) {
            this.rootWidget.getScreenFactory().executeCondition(n, this.rootWidget.getID(), hMIViewArray, this.getScreenTerminalID());
            this.processed = true;
        }
    }

    private void updateTextReplacement(int n) {
        HMIView[] hMIViewArray = this.rootWidget.findReplacementWidgets(n);
        if (hMIViewArray != null) {
            for (int i2 = 0; i2 < hMIViewArray.length; ++i2) {
                AbstractWidget abstractWidget = (AbstractWidget)hMIViewArray[i2];
                abstractWidget.processTextReplacementUpdateEvent();
                this.processed = true;
            }
        }
    }

    private int getScreenTerminalID() {
        return this.rootWidget.getTerminal().getTerminalID();
    }

    public boolean isProcessed() {
        return this.processed;
    }
}

