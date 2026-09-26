/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.SCXMLSemantics;
import org.apache.commons.scxml.Status;
import org.apache.commons.scxml.Step;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.model.Datamodel;
import org.apache.commons.scxml.model.History;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.SCXML;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;
import org.apache.commons.scxml.semantics.SCXMLSemanticsImpl;

public class SCXMLExecutor
implements Serializable {
    private static final long serialVersionUID;
    private Log log = LogFactory.getLog(class$org$apache$commons$scxml$SCXMLExecutor == null ? (class$org$apache$commons$scxml$SCXMLExecutor = SCXMLExecutor.class$("org.apache.commons.scxml.SCXMLExecutor")) : class$org$apache$commons$scxml$SCXMLExecutor);
    private volatile SCXML stateMachine;
    private Status currentStatus;
    private EventDispatcher eventdispatcher;
    private ErrorReporter errorReporter = null;
    private boolean superStep = true;
    private SCXMLSemantics semantics;
    private SCInstance scInstance;
    private boolean terminated = false;
    private static final String EVENT_DATA;
    private static final String EVENT_DATA_MAP;
    private static final String ERR_NO_STATE_MACHINE;
    static /* synthetic */ Class class$org$apache$commons$scxml$SCXMLExecutor;

    public synchronized void triggerEvents(TriggerEvent[] triggerEventArray) {
        Object[] objectArray = this.setEventData(triggerEventArray);
        if (this.terminated) {
            this.log.warn("SCXMLExecutor#triggerEvents: executor is terminated");
            return;
        }
        this.semantics.processInvokes(triggerEventArray, this.errorReporter, this.scInstance);
        ArrayList arrayList = new ArrayList(Arrays.asList(triggerEventArray));
        Step step = null;
        do {
            step = new Step(arrayList, this.currentStatus);
            this.semantics.enumerateReachableTransitions(this.stateMachine, step, this.errorReporter);
            this.semantics.filterTransitionsSet(step, this.eventdispatcher, this.errorReporter, this.scInstance);
            this.semantics.followTransitions(step, this.errorReporter, this.scInstance);
            this.semantics.updateHistoryStates(step, this.errorReporter, this.scInstance);
            this.semantics.executeActions(step, this.stateMachine, this.eventdispatcher, this.errorReporter, this.scInstance);
            this.updateStatus(step);
            if (!this.superStep) continue;
            arrayList.clear();
        } while (this.superStep && this.currentStatus.getEvents().size() > 0);
        this.semantics.initiateInvokes(step, this.errorReporter, this.scInstance);
        this.restoreEventData(objectArray);
        this.logState();
    }

    public void triggerEvent(TriggerEvent triggerEvent) {
        this.triggerEvents(new TriggerEvent[]{triggerEvent});
    }

    public SCXMLExecutor(Evaluator evaluator, EventDispatcher eventDispatcher, ErrorReporter errorReporter) {
        this(evaluator, eventDispatcher, errorReporter, null);
    }

    public SCXMLExecutor() {
        this(null, null, null, null);
    }

    public SCXMLExecutor(Evaluator evaluator, EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCXMLSemantics sCXMLSemantics) {
        this.eventdispatcher = eventDispatcher;
        this.errorReporter = errorReporter;
        this.currentStatus = new Status();
        this.stateMachine = null;
        this.semantics = sCXMLSemantics == null ? new SCXMLSemanticsImpl() : sCXMLSemantics;
        this.scInstance = new SCInstance(this);
        this.scInstance.setEvaluator(evaluator);
    }

    public synchronized void reset() {
        Context context = this.scInstance.getRootContext();
        if (this.stateMachine == null) {
            this.log.error("SCXMLExecutor: State machine not set");
            throw new ModelException("SCXMLExecutor: State machine not set");
        }
        Object object = this.stateMachine.getDatamodel();
        SCXMLHelper.cloneDatamodel((Datamodel)object, context, this.scInstance.getEvaluator(), this.log);
        object = this.stateMachine.getTargets().values().iterator();
        while (object.hasNext()) {
            TransitionTarget transitionTarget = (TransitionTarget)object.next();
            if (transitionTarget instanceof State) {
                Context context2 = this.scInstance.lookupContext(transitionTarget);
                if (context2 == null) continue;
                context2.reset();
                Datamodel datamodel = transitionTarget.getDatamodel();
                if (datamodel == null) continue;
                SCXMLHelper.cloneDatamodel(datamodel, context2, this.scInstance.getEvaluator(), this.log);
                continue;
            }
            if (!(transitionTarget instanceof History)) continue;
            this.scInstance.reset((History)transitionTarget);
        }
        this.currentStatus = new Status();
        object = new Step(null, this.currentStatus);
        this.semantics.determineInitialStates(this.stateMachine, ((Step)object).getAfterStatus().getStates(), ((Step)object).getEntryList(), this.errorReporter, this.scInstance);
        this.semantics.executeActions((Step)object, this.stateMachine, this.eventdispatcher, this.errorReporter, this.scInstance);
        this.updateStatus((Step)object);
        if (this.superStep && this.currentStatus.getEvents().size() > 0) {
            this.triggerEvents(new TriggerEvent[0]);
        } else {
            this.semantics.initiateInvokes((Step)object, this.errorReporter, this.scInstance);
            this.logState();
        }
    }

    public synchronized Status getCurrentStatus() {
        return this.currentStatus;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.scInstance.setEvaluator(evaluator);
    }

    public Evaluator getEvaluator() {
        return this.scInstance.getEvaluator();
    }

    public void setRootContext(Context context) {
        this.scInstance.setRootContext(context);
    }

    public Context getRootContext() {
        return this.scInstance.getRootContext();
    }

    public synchronized SCXML getStateMachine() {
        return this.stateMachine;
    }

    public synchronized void setStateMachine(SCXML sCXML) {
        SCXML sCXML2;
        this.stateMachine = sCXML2 = this.semantics.normalizeStateMachine(sCXML, this.errorReporter);
    }

    public void go() {
        this.reset();
    }

    public synchronized ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public synchronized void setErrorReporter(ErrorReporter errorReporter) {
        this.errorReporter = errorReporter;
    }

    public EventDispatcher getEventdispatcher() {
        return this.eventdispatcher;
    }

    public void setEventdispatcher(EventDispatcher eventDispatcher) {
        this.eventdispatcher = eventDispatcher;
    }

    public boolean isSuperStep() {
        return this.superStep;
    }

    public void setSuperStep(boolean bl) {
        this.superStep = bl;
    }

    public void addListener(SCXML sCXML, SCXMLListener sCXMLListener) {
        SCXML sCXML2 = sCXML;
        this.scInstance.getNotificationRegistry().addListener(sCXML2, sCXMLListener);
    }

    public void removeListener(SCXML sCXML, SCXMLListener sCXMLListener) {
        SCXML sCXML2 = sCXML;
        this.scInstance.getNotificationRegistry().removeListener(sCXML2, sCXMLListener);
    }

    public void addListener(TransitionTarget transitionTarget, SCXMLListener sCXMLListener) {
        TransitionTarget transitionTarget2 = transitionTarget;
        this.scInstance.getNotificationRegistry().addListener(transitionTarget2, sCXMLListener);
    }

    public void removeListener(TransitionTarget transitionTarget, SCXMLListener sCXMLListener) {
        TransitionTarget transitionTarget2 = transitionTarget;
        this.scInstance.getNotificationRegistry().removeListener(transitionTarget2, sCXMLListener);
    }

    public void addListener(Transition transition, SCXMLListener sCXMLListener) {
        Transition transition2 = transition;
        this.scInstance.getNotificationRegistry().addListener(transition2, sCXMLListener);
    }

    public void removeListener(Transition transition, SCXMLListener sCXMLListener) {
        Transition transition2 = transition;
        this.scInstance.getNotificationRegistry().removeListener(transition2, sCXMLListener);
    }

    public void registerInvokerClass(String string, Class clazz) {
        this.scInstance.registerInvokerClass(string, clazz);
    }

    public void unregisterInvokerClass(String string) {
        this.scInstance.unregisterInvokerClass(string);
    }

    SCInstance getSCInstance() {
        return this.scInstance;
    }

    private void logState() {
        if (this.log.isDebugEnabled()) {
            Iterator iterator = this.currentStatus.getStates().iterator();
            StringBuffer stringBuffer = new StringBuffer("Current States: [");
            while (iterator.hasNext()) {
                State state = (State)iterator.next();
                stringBuffer.append(state.getId());
                if (!iterator.hasNext()) continue;
                stringBuffer.append(", ");
            }
            stringBuffer.append(']');
            this.log.debug(stringBuffer.toString());
        }
    }

    private void updateStatus(Step step) {
        this.currentStatus = step.getAfterStatus();
        this.scInstance.getRootContext().setLocal("_ALL_STATES", SCXMLHelper.getAncestorClosure(this.currentStatus.getStates(), null));
        this.setEventData((TriggerEvent[])this.currentStatus.getEvents().toArray(new TriggerEvent[0]));
    }

    private Object[] setEventData(TriggerEvent[] triggerEventArray) {
        Context context = this.scInstance.getRootContext();
        Object[] objectArray = new Object[]{context.get("_eventdata"), context.get("_eventdatamap")};
        int n = triggerEventArray.length;
        if (n > 0) {
            Object object = null;
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < n; ++i2) {
                TriggerEvent triggerEvent = triggerEventArray[i2];
                hashMap.put(triggerEvent.getName(), triggerEvent.getPayload());
            }
            if (n == 1) {
                object = triggerEventArray[0].getPayload();
            }
            context.setLocal("_eventdata", object);
            context.setLocal("_eventdatamap", hashMap);
        }
        return objectArray;
    }

    public void terminate() {
        this.terminated = true;
    }

    private void restoreEventData(Object[] objectArray) {
        this.scInstance.getRootContext().setLocal("_eventdata", objectArray[0]);
        this.scInstance.getRootContext().setLocal("_eventdatamap", objectArray[1]);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

