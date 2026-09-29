/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCXMLExecutor;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.env.SimpleScheduler$DelayedEventTask;
import org.apache.commons.scxml.model.ModelException;

public class SimpleScheduler
implements EventDispatcher,
Serializable {
    private static final long serialVersionUID;
    private Log log = LogFactory.getLog(class$org$apache$commons$scxml$env$SimpleScheduler == null ? (class$org$apache$commons$scxml$env$SimpleScheduler = SimpleScheduler.class$("org.apache.commons.scxml.env.SimpleScheduler")) : class$org$apache$commons$scxml$env$SimpleScheduler);
    private Map timers;
    private SCXMLExecutor executor;
    private static final String TARGETTYPE_SCXML;
    private static final String EVENT_ERR_SEND_TARGETUNAVAILABLE;
    static /* synthetic */ Class class$org$apache$commons$scxml$env$SimpleScheduler;

    public SimpleScheduler(SCXMLExecutor sCXMLExecutor) {
        this.executor = sCXMLExecutor;
        this.timers = Collections.synchronizedMap(new HashMap());
    }

    @Override
    public void cancel(String string) {
        if (this.log.isInfoEnabled()) {
            this.log.info(new StringBuffer().append("cancel( sendId: ").append(string).append(")").toString());
        }
        if (!this.timers.containsKey(string)) {
            return;
        }
        Timer timer = (Timer)this.timers.get(string);
        if (timer != null) {
            timer.cancel();
            if (this.log.isDebugEnabled()) {
                this.log.debug(new StringBuffer().append("Cancelled event scheduled by <send> with id '").append(string).append("'").toString());
            }
        }
        this.timers.remove(string);
    }

    @Override
    public void send(String string, String string2, String string3, String string4, Map map, Object object, long l, List list) {
        Object object2;
        if (this.log.isInfoEnabled()) {
            object2 = new StringBuffer();
            ((StringBuffer)object2).append("send ( sendId: ").append(string);
            ((StringBuffer)object2).append(", target: ").append(string2);
            ((StringBuffer)object2).append(", targetType: ").append(string3);
            ((StringBuffer)object2).append(", event: ").append(string4);
            ((StringBuffer)object2).append(", params: ").append(String.valueOf(map));
            ((StringBuffer)object2).append(", hints: ").append(String.valueOf(object));
            ((StringBuffer)object2).append(", delay: ").append(l);
            ((StringBuffer)object2).append(')');
            this.log.info(((StringBuffer)object2).toString());
        }
        if (SCXMLHelper.isStringEmpty(string3) || string3.trim().equalsIgnoreCase("scxml")) {
            if (!SCXMLHelper.isStringEmpty(string2)) {
                if (this.log.isWarnEnabled()) {
                    this.log.warn(new StringBuffer().append("<send>: Unavailable target - ").append(string2).toString());
                }
                try {
                    this.executor.triggerEvent(new TriggerEvent("error.send.targetunavailable", 5));
                }
                catch (ModelException modelException) {
                    this.log.error(modelException.getMessage(), modelException);
                }
                return;
            }
            if (l > 0L) {
                object2 = new Timer(true);
                ((Timer)object2).schedule((TimerTask)new SimpleScheduler$DelayedEventTask(this, string, string4, map), l);
                this.timers.put(string, object2);
                if (this.log.isDebugEnabled()) {
                    this.log.debug(new StringBuffer().append("Scheduled event '").append(string4).append("' with delay ").append(l).append("ms, as specified by <send> with id '").append(string).append("'").toString());
                }
            }
        }
    }

    protected Log getLog() {
        return this.log;
    }

    protected Map getTimers() {
        return this.timers;
    }

    protected SCXMLExecutor getExecutor() {
        return this.executor;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ SCXMLExecutor access$000(SimpleScheduler simpleScheduler) {
        return simpleScheduler.executor;
    }

    static /* synthetic */ Log access$100(SimpleScheduler simpleScheduler) {
        return simpleScheduler.log;
    }

    static /* synthetic */ Map access$200(SimpleScheduler simpleScheduler) {
        return simpleScheduler.timers;
    }
}

