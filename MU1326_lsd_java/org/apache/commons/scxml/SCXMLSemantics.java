/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.util.List;
import java.util.Set;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.Step;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.model.SCXML;

public interface SCXMLSemantics {
    default public SCXML normalizeStateMachine(SCXML sCXML, ErrorReporter errorReporter) {
    }

    default public void determineInitialStates(SCXML sCXML, Set set, List list, ErrorReporter errorReporter, SCInstance sCInstance) {
    }

    default public void executeActions(Step step, SCXML sCXML, EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance) {
    }

    default public void enumerateReachableTransitions(SCXML sCXML, Step step, ErrorReporter errorReporter) {
    }

    default public void filterTransitionsSet(Step step, EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance) {
    }

    default public void followTransitions(Step step, ErrorReporter errorReporter, SCInstance sCInstance) {
    }

    default public void updateHistoryStates(Step step, ErrorReporter errorReporter, SCInstance sCInstance) {
    }

    default public void processInvokes(TriggerEvent[] triggerEventArray, ErrorReporter errorReporter, SCInstance sCInstance) {
    }

    default public void initiateInvokes(Step step, ErrorReporter errorReporter, SCInstance sCInstance) {
    }
}

