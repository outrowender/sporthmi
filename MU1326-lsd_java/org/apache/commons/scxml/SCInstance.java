/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.NotificationRegistry;
import org.apache.commons.scxml.SCXMLExecutor;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.invoke.Invoker;
import org.apache.commons.scxml.invoke.InvokerException;
import org.apache.commons.scxml.model.Datamodel;
import org.apache.commons.scxml.model.History;
import org.apache.commons.scxml.model.TransitionTarget;

public class SCInstance
implements Serializable {
    private static final long serialVersionUID;
    private NotificationRegistry notificationRegistry = new NotificationRegistry();
    private Map contexts = Collections.synchronizedMap(new HashMap());
    private Map histories = Collections.synchronizedMap(new HashMap());
    private Map completions;
    private Map invokerClasses = Collections.synchronizedMap(new HashMap());
    private Map invokers = Collections.synchronizedMap(new HashMap());
    private Evaluator evaluator = null;
    private Context rootContext = null;
    private SCXMLExecutor executor;

    SCInstance(SCXMLExecutor sCXMLExecutor) {
        this.completions = Collections.synchronizedMap(new HashMap());
        this.executor = sCXMLExecutor;
    }

    public Evaluator getEvaluator() {
        return this.evaluator;
    }

    void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    public Context getRootContext() {
        if (this.rootContext == null && this.evaluator != null) {
            this.rootContext = this.evaluator.newContext(null);
        }
        return this.rootContext;
    }

    void setRootContext(Context context) {
        this.rootContext = context;
    }

    public NotificationRegistry getNotificationRegistry() {
        return this.notificationRegistry;
    }

    void setNotificationRegistry(NotificationRegistry notificationRegistry) {
        this.notificationRegistry = notificationRegistry;
    }

    public Context getContext(TransitionTarget transitionTarget) {
        Context context = (Context)this.contexts.get(transitionTarget);
        if (context == null) {
            TransitionTarget transitionTarget2 = transitionTarget.getParent();
            context = transitionTarget2 == null ? this.evaluator.newContext(this.getRootContext()) : this.evaluator.newContext(this.getContext(transitionTarget2));
            Datamodel datamodel = transitionTarget.getDatamodel();
            SCXMLHelper.cloneDatamodel(datamodel, context, this.evaluator, null);
            this.contexts.put(transitionTarget, context);
        }
        return context;
    }

    Context lookupContext(TransitionTarget transitionTarget) {
        return (Context)this.contexts.get(transitionTarget);
    }

    void setContext(TransitionTarget transitionTarget, Context context) {
        this.contexts.put(transitionTarget, context);
    }

    public Set getLastConfiguration(History history) {
        Set set = (Set)this.histories.get(history);
        if (set == null) {
            set = new HashSet();
            this.histories.put(history, set);
        }
        return set;
    }

    public void setLastConfiguration(History history, Set set) {
        Set set2 = this.getLastConfiguration(history);
        set2.clear();
        set2.addAll(set);
    }

    public boolean isEmpty(History history) {
        Set set = (Set)this.histories.get(history);
        return set == null || set.isEmpty();
    }

    public void reset(History history) {
        Set set = (Set)this.histories.get(history);
        if (set != null) {
            set.clear();
        }
    }

    public SCXMLExecutor getExecutor() {
        return this.executor;
    }

    void registerInvokerClass(String string, Class clazz) {
        this.invokerClasses.put(string, clazz);
    }

    void unregisterInvokerClass(String string) {
        this.invokerClasses.remove(string);
    }

    public Invoker newInvoker(String string) {
        Class clazz = (Class)this.invokerClasses.get(string);
        if (clazz == null) {
            throw new InvokerException(new StringBuffer().append("No Invoker registered for targettype \"").append(string).append("\"").toString());
        }
        Invoker invoker = null;
        try {
            invoker = (Invoker)clazz.newInstance();
        }
        catch (InstantiationException instantiationException) {
            throw new InvokerException(instantiationException.getMessage(), instantiationException.getCause());
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new InvokerException(illegalAccessException.getMessage(), illegalAccessException.getCause());
        }
        return invoker;
    }

    public Invoker getInvoker(TransitionTarget transitionTarget) {
        return (Invoker)this.invokers.get(transitionTarget);
    }

    public void setInvoker(TransitionTarget transitionTarget, Invoker invoker) {
        this.invokers.put(transitionTarget, invoker);
    }

    public Map getInvokers() {
        return this.invokers;
    }

    public boolean isDone(TransitionTarget transitionTarget) {
        Boolean bl = (Boolean)this.completions.get(transitionTarget);
        if (bl == null) {
            return false;
        }
        return bl;
    }

    public void setDone(TransitionTarget transitionTarget, boolean bl) {
        this.completions.put(transitionTarget, bl ? Boolean.TRUE : Boolean.FALSE);
    }
}

