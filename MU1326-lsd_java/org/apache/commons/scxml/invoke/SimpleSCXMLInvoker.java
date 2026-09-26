/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.invoke;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import java.util.Map$Entry;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExecutor;
import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.env.SimpleDispatcher;
import org.apache.commons.scxml.env.SimpleErrorHandler;
import org.apache.commons.scxml.env.SimpleErrorReporter;
import org.apache.commons.scxml.env.SimpleSCXMLListener;
import org.apache.commons.scxml.invoke.AsyncTrigger;
import org.apache.commons.scxml.invoke.Invoker;
import org.apache.commons.scxml.invoke.InvokerException;
import org.apache.commons.scxml.io.SCXMLParser;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.SCXML;
import org.xml.sax.SAXException;

public class SimpleSCXMLInvoker
implements Invoker,
Serializable {
    private static final long serialVersionUID;
    private String parentStateId;
    private String eventPrefix;
    private SCInstance parentSCInstance;
    private SCXMLExecutor executor;
    private boolean cancelled;
    private static String invokePrefix;
    private static String invokeDone;
    private static String invokeCancelResponse;

    @Override
    public void setParentStateId(String string) {
        this.parentStateId = string;
        this.eventPrefix = new StringBuffer().append(this.parentStateId).append(invokePrefix).toString();
        this.cancelled = false;
    }

    @Override
    public void setSCInstance(SCInstance sCInstance) {
        this.parentSCInstance = sCInstance;
    }

    @Override
    public void invoke(String string, Map map) {
        SCXML sCXML = null;
        try {
            sCXML = SCXMLParser.parse(new URL(string), new SimpleErrorHandler());
        }
        catch (ModelException modelException) {
            throw new InvokerException(modelException.getMessage(), modelException.getCause());
        }
        catch (IOException iOException) {
            throw new InvokerException(iOException.getMessage(), iOException.getCause());
        }
        catch (SAXException sAXException) {
            throw new InvokerException(sAXException.getMessage(), sAXException.getCause());
        }
        Evaluator evaluator = this.parentSCInstance.getEvaluator();
        this.executor = new SCXMLExecutor(evaluator, new SimpleDispatcher(), new SimpleErrorReporter());
        Context context = evaluator.newContext(null);
        Object object = map.entrySet().iterator();
        while (object.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)object.next();
            context.setLocal((String)map$Entry.getKey(), map$Entry.getValue());
        }
        this.executor.setRootContext(context);
        this.executor.setStateMachine(sCXML);
        this.executor.addListener(sCXML, (SCXMLListener)new SimpleSCXMLListener());
        this.executor.registerInvokerClass("scxml", super.getClass());
        try {
            this.executor.go();
        }
        catch (ModelException modelException) {
            throw new InvokerException(modelException.getMessage(), modelException.getCause());
        }
        if (this.executor.getCurrentStatus().isFinal()) {
            object = new TriggerEvent(new StringBuffer().append(this.eventPrefix).append(invokeDone).toString(), 3);
            new AsyncTrigger(this.parentSCInstance.getExecutor(), (TriggerEvent)object).start();
        }
    }

    @Override
    public void parentEvents(TriggerEvent[] triggerEventArray) {
        if (this.cancelled) {
            return;
        }
        boolean bl = this.executor.getCurrentStatus().isFinal();
        try {
            this.executor.triggerEvents(triggerEventArray);
        }
        catch (ModelException modelException) {
            throw new InvokerException(modelException.getMessage(), modelException.getCause());
        }
        if (!bl && this.executor.getCurrentStatus().isFinal()) {
            TriggerEvent triggerEvent = new TriggerEvent(new StringBuffer().append(this.eventPrefix).append(invokeDone).toString(), 3);
            new AsyncTrigger(this.parentSCInstance.getExecutor(), triggerEvent).start();
        }
    }

    @Override
    public void cancel() {
        this.cancelled = true;
        TriggerEvent triggerEvent = new TriggerEvent(new StringBuffer().append(this.eventPrefix).append(invokeCancelResponse).toString(), 3);
        new AsyncTrigger(this.parentSCInstance.getExecutor(), triggerEvent).start();
    }

    static {
        invokePrefix = ".invoke.";
        invokeDone = "done";
        invokeCancelResponse = "cancel.response";
    }
}

