/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.util.Map;
import java.util.TimerTask;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.env.SimpleScheduler;
import org.apache.commons.scxml.model.ModelException;

class SimpleScheduler$DelayedEventTask
extends TimerTask {
    private String sendId;
    private String event;
    private Map payload;
    private final /* synthetic */ SimpleScheduler this$0;

    SimpleScheduler$DelayedEventTask(SimpleScheduler simpleScheduler, String string, String string2) {
        this(simpleScheduler, string, string2, null);
    }

    SimpleScheduler$DelayedEventTask(SimpleScheduler simpleScheduler, String string, String string2, Map map) {
        this.this$0 = simpleScheduler;
        this.sendId = string;
        this.event = string2;
        this.payload = map;
    }

    @Override
    public void run() {
        try {
            SimpleScheduler.access$000(this.this$0).triggerEvent(new TriggerEvent(this.event, 3, this.payload));
        }
        catch (ModelException modelException) {
            SimpleScheduler.access$100(this.this$0).error(modelException.getMessage(), modelException);
        }
        SimpleScheduler.access$200(this.this$0).remove(this.sendId);
        if (SimpleScheduler.access$100(this.this$0).isDebugEnabled()) {
            SimpleScheduler.access$100(this.this$0).debug(new StringBuffer().append("Fired event '").append(this.event).append("' as scheduled by ").append("<send> with id '").append(this.sendId).append("'").toString());
        }
    }
}

