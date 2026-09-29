/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.SCXMLExecutor;
import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.env.AbstractStateMachine$EntryListener;
import org.apache.commons.scxml.env.SimpleDispatcher;
import org.apache.commons.scxml.env.SimpleErrorHandler;
import org.apache.commons.scxml.env.SimpleErrorReporter;
import org.apache.commons.scxml.env.jexl.JexlContext;
import org.apache.commons.scxml.env.jexl.JexlEvaluatorFactory;
import org.apache.commons.scxml.io.SCXMLParser;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.SCXML;
import org.xml.sax.SAXException;

public abstract class AbstractStateMachine {
    private SCXML stateMachine;
    private SCXMLExecutor engine;
    private Log log;
    private static final Class[] SIGNATURE = new Class[0];
    private static final Object[] PARAMETERS = new Object[0];

    public AbstractStateMachine(URL uRL) {
        this(uRL, (Context)new JexlContext(), new JexlEvaluatorFactory(false).createEvaluator());
    }

    public AbstractStateMachine(URL uRL, Context context, Evaluator evaluator) {
        this.log = LogFactory.getLog(super.getClass());
        SimpleErrorHandler simpleErrorHandler = new SimpleErrorHandler();
        try {
            this.stateMachine = SCXMLParser.parse(uRL, simpleErrorHandler);
        }
        catch (IOException iOException) {
            this.logError(iOException);
        }
        catch (SAXException sAXException) {
            this.logError(sAXException);
        }
        catch (ModelException modelException) {
            this.logError(modelException);
        }
        this.initialize(this.stateMachine, context, evaluator);
    }

    public AbstractStateMachine(SCXML sCXML) {
        this(sCXML, (Context)new JexlContext(), new JexlEvaluatorFactory(false).createEvaluator());
    }

    public AbstractStateMachine(SCXML sCXML, Context context, Evaluator evaluator) {
        this.initialize(sCXML, context, evaluator);
    }

    private void initialize(SCXML sCXML, Context context, Evaluator evaluator) {
        this.engine = new SCXMLExecutor(evaluator, new SimpleDispatcher(), new SimpleErrorReporter());
        this.engine.setStateMachine(sCXML);
        this.engine.setSuperStep(true);
        this.engine.setRootContext(context);
        this.engine.addListener(sCXML, (SCXMLListener)new AbstractStateMachine$EntryListener(this));
        try {
            this.engine.go();
        }
        catch (ModelException modelException) {
            this.logError(modelException);
        }
    }

    public boolean fireEvent(String string) {
        TriggerEvent[] triggerEventArray = new TriggerEvent[]{new TriggerEvent(string, 3, null)};
        try {
            this.engine.triggerEvents(triggerEventArray);
        }
        catch (ModelException modelException) {
            this.logError(modelException);
        }
        return this.engine.getCurrentStatus().isFinal();
    }

    public static SCXML getStateMachine() {
        return null;
    }

    public SCXMLExecutor getEngine() {
        return this.engine;
    }

    public Log getLog() {
        return this.log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public boolean invoke(String string) {
        Class clazz = super.getClass();
        try {
            Method method = clazz.getDeclaredMethod(string, SIGNATURE);
            method.invoke(this, PARAMETERS);
        }
        catch (SecurityException securityException) {
            this.logError(securityException);
            return false;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            this.logError(noSuchMethodException);
            return false;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.logError(illegalArgumentException);
            return false;
        }
        catch (IllegalAccessException illegalAccessException) {
            this.logError(illegalAccessException);
            return false;
        }
        catch (InvocationTargetException invocationTargetException) {
            this.logError(invocationTargetException);
            return false;
        }
        return true;
    }

    public boolean resetMachine() {
        try {
            this.engine.reset();
        }
        catch (ModelException modelException) {
            this.logError(modelException);
            return false;
        }
        return true;
    }

    protected void logError(Exception exception) {
        if (this.log.isErrorEnabled()) {
            this.log.error(exception.getMessage(), exception);
        }
    }
}

