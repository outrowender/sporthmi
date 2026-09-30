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
import org.apache.commons.scxml.model.ModelException;

public class SimpleScheduler
implements EventDispatcher,
Serializable {
    private static final long serialVersionUID = 1L;
    private Log log = LogFactory.getLog(class$org$apache$commons$scxml$env$SimpleScheduler == null ? (class$org$apache$commons$scxml$env$SimpleScheduler = SimpleScheduler.class$("org.apache.commons.scxml.env.SimpleScheduler")) : class$org$apache$commons$scxml$env$SimpleScheduler);
    private Map timers;
    private SCXMLExecutor executor;
    private static final String TARGETTYPE_SCXML = "scxml";
    private static final String EVENT_ERR_SEND_TARGETUNAVAILABLE = "error.send.targetunavailable";
    static /* synthetic */ Class class$org$apache$commons$scxml$env$SimpleScheduler;

    public SimpleScheduler(SCXMLExecutor sCXMLExecutor) {
        this.executor = sCXMLExecutor;
        this.timers = Collections.synchronizedMap(new HashMap());
    }

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
        if (SCXMLHelper.isStringEmpty(string3) || string3.trim().equalsIgnoreCase(TARGETTYPE_SCXML)) {
            if (!SCXMLHelper.isStringEmpty(string2)) {
                if (this.log.isWarnEnabled()) {
                    this.log.warn(new StringBuffer().append("<send>: Unavailable target - ").append(string2).toString());
                }
                try {
                    this.executor.triggerEvent(new TriggerEvent(EVENT_ERR_SEND_TARGETUNAVAILABLE, 5));
                }
                catch (ModelException modelException) {
                    this.log.error(modelException.getMessage(), modelException);
                }
                return;
            }
            if (l > 0L) {
                object2 = new Timer(true);
                ((Timer)object2).schedule((TimerTask)new DelayedEventTask(string, string4, map), l);
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

    class DelayedEventTask
    extends TimerTask {
        private String sendId;
        private String event;
        private Map payload;

        DelayedEventTask(String string, String string2) {
            this(string, string2, null);
        }

        DelayedEventTask(String string, String string2, Map map) {
            this.sendId = string;
            this.event = string2;
            this.payload = map;
        }

        public void run() {
            try {
                SimpleScheduler.this.executor.triggerEvent(new TriggerEvent(this.event, 3, this.payload));
            }
            catch (ModelException modelException) {
                SimpleScheduler.this.log.error(modelException.getMessage(), modelException);
            }
            SimpleScheduler.this.timers.remove(this.sendId);
            if (SimpleScheduler.this.log.isDebugEnabled()) {
                SimpleScheduler.this.log.debug(new StringBuffer().append("Fired event '").append(this.event).append("' as scheduled by ").append("<send> with id '").append(this.sendId).append("'").toString());
            }
        }
    }
}

