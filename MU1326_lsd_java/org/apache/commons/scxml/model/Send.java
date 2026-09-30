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
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.TransitionTarget;

public class Send
extends Action
implements ExternalContent {
    private static final long serialVersionUID = 1L;
    private static final String TARGETTYPE_SCXML = "scxml";
    private static final String EVENT_ERR_SEND_TARGETUNAVAILABLE = "error.send.targetunavailable";
    private String sendid;
    private String target;
    private String targettype;
    private String delay;
    private String hints;
    private String namelist;
    private List externalNodes = new ArrayList();
    private String event;
    private static final String MILLIS = "ms";
    private static final String SECONDS = "s";
    private static final String MINUTES = "m";
    private static final long MILLIS_IN_A_SECOND = 1000L;
    private static final long MILLIS_IN_A_MINUTE = 60000L;

    public final String getDelay() {
        return this.delay;
    }

    public final void setDelay(String string) {
        this.delay = string;
    }

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

    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) throws ModelException, SCXMLExpressionException {
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
            log.warn("<send>: target expression \"" + this.target + "\" evaluated to null or empty String");
        }
        String string2 = this.targettype;
        if (!SCXMLHelper.isStringEmpty(this.targettype)) {
            string2 = (String)evaluator.eval(context, this.targettype);
            if (SCXMLHelper.isStringEmpty(string2) && log.isWarnEnabled()) {
                log.warn("<send>: targettype expression \"" + this.targettype + "\" evaluated to null or empty String");
            }
        } else {
            string2 = TARGETTYPE_SCXML;
        }
        HashMap hashMap = null;
        if (!SCXMLHelper.isStringEmpty(this.namelist)) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.namelist);
            hashMap = new HashMap(stringTokenizer.countTokens());
            while (stringTokenizer.hasMoreTokens()) {
                String string3 = stringTokenizer.nextToken();
                object = context.get(string3);
                if (object == null) {
                    errorReporter.onError("UNDEFINED_VARIABLE", string3 + " = null", transitionTarget);
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
            log.warn("<send>: event expression \"" + this.event + "\" evaluated to null or empty String");
        }
        if (string2 != null && string2.trim().equalsIgnoreCase(TARGETTYPE_SCXML)) {
            if (SCXMLHelper.isStringEmpty(string)) {
                if (l == 0L) {
                    if (log.isDebugEnabled()) {
                        log.debug("<send>: Enqueued event '" + (String)object + "' with no delay");
                    }
                    collection.add(new TriggerEvent((String)object, 3, hashMap));
                    return;
                }
            } else {
                if (log.isWarnEnabled()) {
                    log.warn("<send>: Unavailable target - " + string);
                }
                collection.add(new TriggerEvent(EVENT_ERR_SEND_TARGETUNAVAILABLE, 5));
                return;
            }
        }
        context.setLocal(Send.getNamespacesKey(), null);
        if (log.isDebugEnabled()) {
            log.debug("<send>: Dispatching event '" + (String)object + "' to target '" + string + "' of target type '" + string2 + "' with suggested delay of " + l + MILLIS);
        }
        eventDispatcher.send(this.sendid, string, string2, (String)object, hashMap, object2, l, this.externalNodes);
    }

    private long parseDelay(String string, Log log) throws SCXMLExpressionException {
        long l = 0L;
        long l2 = 1L;
        if (!SCXMLHelper.isStringEmpty(string)) {
            String string2;
            String string3 = string2 = string.trim();
            if (string2.endsWith(MILLIS)) {
                string3 = string2.substring(0, string2.length() - 2);
            } else if (string2.endsWith(SECONDS)) {
                l2 = 1000L;
                string3 = string2.substring(0, string2.length() - 1);
            } else if (string2.endsWith(MINUTES)) {
                l2 = 60000L;
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

