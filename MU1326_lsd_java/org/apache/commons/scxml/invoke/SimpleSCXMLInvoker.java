/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.invoke;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
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
    private static final long serialVersionUID = 1L;
    private String parentStateId;
    private String eventPrefix;
    private SCInstance parentSCInstance;
    private SCXMLExecutor executor;
    private boolean cancelled;
    private static String invokePrefix = ".invoke.";
    private static String invokeDone = "done";
    private static String invokeCancelResponse = "cancel.response";

    public void setParentStateId(String string) {
        this.parentStateId = string;
        this.eventPrefix = this.parentStateId + invokePrefix;
        this.cancelled = false;
    }

    public void setSCInstance(SCInstance sCInstance) {
        this.parentSCInstance = sCInstance;
    }

    public void invoke(String string, Map map) throws InvokerException {
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
            Map.Entry entry = (Map.Entry)object.next();
            context.setLocal((String)entry.getKey(), entry.getValue());
        }
        this.executor.setRootContext(context);
        this.executor.setStateMachine(sCXML);
        this.executor.addListener(sCXML, (SCXMLListener)new SimpleSCXMLListener());
        this.executor.registerInvokerClass("scxml", this.getClass());
        try {
            this.executor.go();
        }
        catch (ModelException modelException) {
            throw new InvokerException(modelException.getMessage(), modelException.getCause());
        }
        if (this.executor.getCurrentStatus().isFinal()) {
            object = new TriggerEvent(this.eventPrefix + invokeDone, 3);
            new AsyncTrigger(this.parentSCInstance.getExecutor(), (TriggerEvent)object).start();
        }
    }

    public void parentEvents(TriggerEvent[] triggerEventArray) throws InvokerException {
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
            TriggerEvent triggerEvent = new TriggerEvent(this.eventPrefix + invokeDone, 3);
            new AsyncTrigger(this.parentSCInstance.getExecutor(), triggerEvent).start();
        }
    }

    public void cancel() throws InvokerException {
        this.cancelled = true;
        TriggerEvent triggerEvent = new TriggerEvent(this.eventPrefix + invokeCancelResponse, 3);
        new AsyncTrigger(this.parentSCInstance.getExecutor(), triggerEvent).start();
    }
}

