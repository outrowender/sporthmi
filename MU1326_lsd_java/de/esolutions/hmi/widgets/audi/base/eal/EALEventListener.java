/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.EALMergeEvent;
import de.audi.atip.log.LogChannel;
import de.esolutions.graphics.eal.CAbstractEventListener;
import de.esolutions.graphics.eal.FlagEvent;
import de.esolutions.graphics.eal.IEvent;
import de.esolutions.graphics.eal.IEventMerge;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.event_t;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public class EALEventListener
extends CAbstractEventListener {
    private LogChannel lc = IWidgetLogChannel.logChannel3DEngine;

    public EALEventListener(IManager iManager, FlagEvent flagEvent) {
        super(iManager, flagEvent);
    }

    @Override
    public String getName() {
        return "EALEventListener";
    }

    @Override
    public void process(IEvent iEvent) {
        if (iEvent.isMergeEvent()) {
            IEventMerge iEventMerge = iEvent.toEventMerge();
            if (iEvent.getType() == event_t.EVENTTYPE_MERGE_MERGED) {
                EALMergeEvent eALMergeEvent = new EALMergeEvent((ATIPEventListener)AbstractWidget.hmiService.getRootWindow(0), iEventMerge.getScreenMainPath());
                if (this.lc.isDebug()) {
                    this.lc.log(-2137614336, "EALEventListener#process posting merge event, nodeName: %1", (Object)eALMergeEvent.getNodeName());
                }
                AbstractWidget.hmiService.getEventDispatcher().postEvent(eALMergeEvent);
            }
        }
    }
}

