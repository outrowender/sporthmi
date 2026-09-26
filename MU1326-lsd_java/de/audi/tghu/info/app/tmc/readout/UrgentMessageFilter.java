/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.TMCHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.dsi.ifc.tmc.TmcMessage;

public class UrgentMessageFilter {
    private HashMap shownMsgsMap;
    private ArrayList msgs;
    private LogChannel logger;

    public UrgentMessageFilter(LogChannel logChannel) {
        this.logger = logChannel;
        this.shownMsgsMap = new HashMap(16);
        this.msgs = new ArrayList(16);
        this.logger.log(-2137614336, "[UrgentMessageFilter#UrgentMessageFilter] Called.");
    }

    public void filterMessages(TmcMessage[] tmcMessageArray) {
        this.logger.log(-2137614336, "[UrgentMessageFilter#filterMessages] Called, messages: %1", (long)tmcMessageArray.length);
        this.msgs.clear();
        for (int i2 = 0; i2 < tmcMessageArray.length; ++i2) {
            if (this.shownMsgsMap.get(new Long(tmcMessageArray[i2].getMessageID())) == null) {
                if (this.logger.isDebug()) {
                    this.logger.log(-2137614336, "[UrgentMessageFilter#filterMessages] Message was not shown yet, add to internal queue! Message: %1", (Object)TMCHelper.formatTmcMessageForDebugging(tmcMessageArray[i2]));
                }
                this.msgs.add(tmcMessageArray[i2]);
                continue;
            }
            if (!this.logger.isDebug()) continue;
            this.logger.log(-2137614336, "[UrgentMessageFilter#filterMessages] Message was already shown, ignore it! Message: %1", (Object)TMCHelper.formatTmcMessageForDebugging(tmcMessageArray[i2]));
        }
        Set set = this.shownMsgsMap.keySet();
        Iterator iterator = set.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            Long l = (Long)iterator.next();
            for (int i3 = 0; i3 < tmcMessageArray.length; ++i3) {
                if (tmcMessageArray[i3].getMessageID() != l.longValue()) continue;
                bl = true;
            }
            if (!bl) {
                iterator.remove();
                this.logger.log(-2137614336, "[UrgentMessageFilter#filterMessages] Message with ID '%1' removed from map which contains shown msgs.", (long)l);
                continue;
            }
            bl = false;
        }
        this.logger.log(-2137614336, "[UrgentMessageFilter#filterMessages] Map containing shown messages is of size: %1", (long)this.shownMsgsMap.size());
    }

    public void setMessageAsShown(TmcMessage tmcMessage) {
        this.shownMsgsMap.put(new Long(tmcMessage.getMessageID()), tmcMessage);
    }

    public List getMessagesForShowing() {
        return this.msgs;
    }
}

