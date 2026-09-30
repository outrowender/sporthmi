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
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.SCXML;

public interface SCXMLSemantics {
    public SCXML normalizeStateMachine(SCXML var1, ErrorReporter var2);

    public void determineInitialStates(SCXML var1, Set var2, List var3, ErrorReporter var4, SCInstance var5) throws ModelException;

    public void executeActions(Step var1, SCXML var2, EventDispatcher var3, ErrorReporter var4, SCInstance var5) throws ModelException;

    public void enumerateReachableTransitions(SCXML var1, Step var2, ErrorReporter var3);

    public void filterTransitionsSet(Step var1, EventDispatcher var2, ErrorReporter var3, SCInstance var4) throws ModelException;

    public void followTransitions(Step var1, ErrorReporter var2, SCInstance var3) throws ModelException;

    public void updateHistoryStates(Step var1, ErrorReporter var2, SCInstance var3);

    public void processInvokes(TriggerEvent[] var1, ErrorReporter var2, SCInstance var3) throws ModelException;

    public void initiateInvokes(Step var1, ErrorReporter var2, SCInstance var3);
}

