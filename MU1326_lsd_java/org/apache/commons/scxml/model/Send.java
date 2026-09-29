/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.ExternalContent;
import org.apache.commons.scxml.model.TransitionTarget;

public class Send
extends Action
implements ExternalContent {
    private static final long serialVersionUID;
    private static final String TARGETTYPE_SCXML;
    private static final String EVENT_ERR_SEND_TARGETUNAVAILABLE;
    private String sendid;
    private String target;
    private String targettype;
    private String delay;
    private String hints;
    private String namelist;
    private List externalNodes = new ArrayList();
    private String event;
    private static final String MILLIS;
    private static final String SECONDS;
    private static final String MINUTES;
    private static final long MILLIS_IN_A_SECOND;
    private static final long MILLIS_IN_A_MINUTE;

    public final String getDelay() {
        return this.delay;
    }

    public final void setDelay(String string) {
        this.delay = string;
    }

    @Override
    public final List getExternalNodes() {
        return this.externalNodes;
    }

    public final void setExternalNodes(List list) {
        this.externalNodes = list;
    }

    public final String getHints() {
        return this.hints;
    }

    public final void setHints(String string) {
        this.hints = string;
    }

    public final String getNamelist() {
        return this.namelist;
    }

    public final void setNamelist(String string) {
        this.namelist = string;
    }

    public final String getSendid() {
        return this.sendid;
    }

    public final void setSendid(String string) {
        this.sendid = string;
    }

    public final String getTarget() {
        return this.target;
    }

    public final void setTarget(String string) {
        this.target = string;
    }

    public final String getTargettype() {
        return this.targettype;
    }

    public final void setTargettype(String string) {
        this.targettype = string;
    }

    public final void setEvent(String string) {
        this.event = string;
    }

    public final String getEvent() {
        return this.event;
    }

    @Override
    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) {
        Object object;
        TransitionTarget transitionTarget = this.getParentTransitionTarget();
        Context context = sCInstance.getContext(transitionTarget);
        context.setLocal(Send.getNamespacesKey(), this.getNamespaces());
        Evaluator evaluator = sCInstance.getEvaluator();
        Object object2 = null;
        if (!SCXMLHelper.isStringEmpty(this.hints)) {
            object2 = evaluator.eval(context, this.hints);
        }
        String string = this.target;
        if (!SCXMLHelper.isStringEmpty(this.target) && SCXMLHelper.isStringEmpty(string = (String)evaluator.eval(context, this.target)) && log.isWarnEnabled()) {
            log.warn(new StringBuffer().append("<send>: target expression \"").append(this.target).append("\" evaluated to null or empty String").toString());
        }
        String string2 = this.targettype;
        if (!SCXMLHelper.isStringEmpty(this.targettype)) {
            string2 = (String)evaluator.eval(context, this.targettype);
            if (SCXMLHelper.isStringEmpty(string2) && log.isWarnEnabled()) {
                log.warn(new StringBuffer().append("<send>: targettype expression \"").append(this.targettype).append("\" evaluated to null or empty String").toString());
            }
        } else {
            string2 = "scxml";
        }
        HashMap hashMap = null;
        if (!SCXMLHelper.isStringEmpty(this.namelist)) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.namelist);
            hashMap = new HashMap(stringTokenizer.countTokens());
            while (stringTokenizer.hasMoreTokens()) {
                String string3 = stringTokenizer.nextToken();
                object = context.get(string3);
                if (object == null) {
                    errorReporter.onError("UNDEFINED_VARIABLE", new StringBuffer().append(string3).append(" = null").toString(), transitionTarget);
                }
                hashMap.put(string3, object);
            }
        }
        long l = 0L;
        if (!SCXMLHelper.isStringEmpty(this.delay) && (object = evaluator.eval(context, this.delay)) != null) {
            String string4 = object.toString();
            l = this.parseDelay(string4, log);
        }
        object = this.event;
        if (!SCXMLHelper.isStringEmpty(this.event) && SCXMLHelper.isStringEmpty((String)(object = (String)evaluator.eval(context, this.event))) && log.isWarnEnabled()) {
            log.warn(new StringBuffer().append("<send>: event expression \"").append(this.event).append("\" evaluated to null or empty String").toString());
        }
        if (string2 != null && string2.trim().equalsIgnoreCase("scxml")) {
            if (SCXMLHelper.isStringEmpty(string)) {
                if (l == 0L) {
                    if (log.isDebugEnabled()) {
                        log.debug(new StringBuffer().append("<send>: Enqueued event '").append((String)object).append("' with no delay").toString());
                    }
                    collection.add(new TriggerEvent((String)object, 3, hashMap));
                    return;
                }
            } else {
                if (log.isWarnEnabled()) {
                    log.warn(new StringBuffer().append("<send>: Unavailable target - ").append(string).toString());
                }
                collection.add(new TriggerEvent("error.send.targetunavailable", 5));
                return;
            }
        }
        context.setLocal(Send.getNamespacesKey(), null);
        if (log.isDebugEnabled()) {
            log.debug(new StringBuffer().append("<send>: Dispatching event '").append((String)object).append("' to target '").append(string).append("' of target type '").append(string2).append("' with suggested delay of ").append(l).append("ms").toString());
        }
        eventDispatcher.send(this.sendid, string, string2, (String)object, hashMap, object2, l, this.externalNodes);
    }

    private long parseDelay(String string, Log log) {
        long l = 0L;
        long l2 = 1L;
        if (!SCXMLHelper.isStringEmpty(string)) {
            String string2;
            String string3 = string2 = string.trim();
            if (string2.endsWith("ms")) {
                string3 = string2.substring(0, string2.length() - 2);
            } else if (string2.endsWith("s")) {
                l2 = 0;
                string3 = string2.substring(0, string2.length() - 1);
            } else if (string2.endsWith("m")) {
                l2 = 0;
                string3 = string2.substring(0, string2.length() - 1);
            }
            try {
                l = Long.parseLong(string3);
            }
            catch (NumberFormatException numberFormatException) {
                log.error(numberFormatException.getMessage(), numberFormatException);
                throw new SCXMLExpressionException(numberFormatException.getMessage(), numberFormatException);
            }
            l *= l2;
        }
        return l;
    }
}

