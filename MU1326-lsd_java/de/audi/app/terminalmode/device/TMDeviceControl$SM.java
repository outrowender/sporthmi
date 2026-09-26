/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.statemachine.Message;
import de.audi.atip.utils.statemachine.StateMachine;
import de.audi.atip.utils.statemachine.StateMachineInflator;

class TMDeviceControl$SM
extends StateMachine {
    private final ISmartphoneIntegrationDSIController dsiController;
    private final /* synthetic */ TMDeviceControl this$0;

    protected TMDeviceControl$SM(TMDeviceControl tMDeviceControl) {
        this.this$0 = tMDeviceControl;
        super(TMDeviceControl.access$000(tMDeviceControl), TMDeviceControl.access$100(tMDeviceControl), (IDispatcher)TMDeviceControl.access$200(tMDeviceControl).get(TMDeviceControl.class$de$audi$atip$utils$dispatching$IDispatcher == null ? (TMDeviceControl.class$de$audi$atip$utils$dispatching$IDispatcher = TMDeviceControl.class$("de.audi.atip.utils.dispatching.IDispatcher")) : TMDeviceControl.class$de$audi$atip$utils$dispatching$IDispatcher), TMDeviceControl$TMDeviceControlState.getMessageCodeConverter());
        this.dsiController = TMDeviceControl.access$200(tMDeviceControl).getSMIDSIController();
        try {
            new StateMachineInflator(this).inflate();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.setInitialState(this.getStateForClass(TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotDiscoveredState")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState));
    }

    static /* synthetic */ TMDeviceControl access$500(TMDeviceControl$SM tMDeviceControl$SM) {
        return tMDeviceControl$SM.this$0;
    }

    static /* synthetic */ void access$900(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$1100(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$1200(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$1300(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$1700(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$1800(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$1900(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2100(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2400(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2500(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2600(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2700(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2800(TMDeviceControl$SM tMDeviceControl$SM, Message message) {
        tMDeviceControl$SM.deferMessage(message);
    }

    static /* synthetic */ void access$2900(TMDeviceControl$SM tMDeviceControl$SM, Message message) {
        tMDeviceControl$SM.deferMessage(message);
    }

    static /* synthetic */ ISmartphoneIntegrationDSIController access$3100(TMDeviceControl$SM tMDeviceControl$SM) {
        return tMDeviceControl$SM.dsiController;
    }

    static /* synthetic */ void access$3200(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$3400(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$3500(TMDeviceControl$SM tMDeviceControl$SM, Message message) {
        tMDeviceControl$SM.deferMessage(message);
    }

    static /* synthetic */ void access$3700(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4000(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4100(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4200(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4300(TMDeviceControl$SM tMDeviceControl$SM, Message message) {
        tMDeviceControl$SM.deferMessage(message);
    }

    static /* synthetic */ void access$4700(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4900(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$5000(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$5200(TMDeviceControl$SM tMDeviceControl$SM, Class clazz) {
        tMDeviceControl$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$5300(TMDeviceControl$SM tMDeviceControl$SM, Message message) {
        tMDeviceControl$SM.deferMessage(message);
    }
}

