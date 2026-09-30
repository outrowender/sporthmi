/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MediaListSourceStateDiffer {
    private static final String LOGCLASS = "MediaListSourceStateDiffer";
    private final LogChannel logger;
    private final ISourceStateUpdater sourceStateUpdater;
    private Map lastSourcesSlotListMap;
    private Map lastSourceTypeToAvailability;
    private Map lastSourceTypeToNumberOfSlots;

    public MediaListSourceStateDiffer(LogChannel logChannel, ISourceStateUpdater iSourceStateUpdater) {
        if (logChannel == null || iSourceStateUpdater == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }
        this.sourceStateUpdater = iSourceStateUpdater;
        this.logger = logChannel;
        this.lastSourcesSlotListMap = new HashMap();
        this.lastSourceTypeToAvailability = new HashMap();
        this.lastSourceTypeToNumberOfSlots = new HashMap();
    }

    public void updateSourceSlots(Map map) {
        Integer n;
        HashMap hashMap = new HashMap(2);
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            n = (Integer)iterator.next();
            List list = (List)map.get(n);
            if (((Object)list).equals(this.lastSourcesSlotListMap.get(n))) continue;
            this.logger.log(10000000, "[%1.updateSourceSlots] [%2] Changed", (Object)LOGCLASS, (Object)LogUtil.getSourceTypeStr(n));
            hashMap.put(n, list);
        }
        iterator = this.lastSourcesSlotListMap.keySet().iterator();
        while (iterator.hasNext()) {
            n = (Integer)iterator.next();
            if (map.containsKey(n)) continue;
            this.logger.log(10000000, "[%1.updateSourceSlots] [%2] Removed", (Object)LOGCLASS, (Object)LogUtil.getSourceTypeStr(n));
            hashMap.put(n, new ArrayList(0));
        }
        this.lastSourcesSlotListMap = map;
        this.sourceStateUpdater.updateSourceSlots(hashMap);
    }

    public void updateSourceAvailability(Map map) {
        HashMap hashMap = new HashMap(2);
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer n = (Integer)iterator.next();
            Boolean bl = (Boolean)map.get(n);
            if (bl.equals(this.lastSourceTypeToAvailability.get(n))) continue;
            hashMap.put(n, bl);
        }
        this.lastSourceTypeToAvailability = map;
        this.sourceStateUpdater.updateSourceAvailability(2, hashMap);
    }

    public void updateNumberOfSlots(Map map) {
        HashMap hashMap = new HashMap(2);
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer n = (Integer)iterator.next();
            Integer n2 = (Integer)map.get(n);
            if (n2.equals(this.lastSourceTypeToNumberOfSlots.get(n))) continue;
            hashMap.put(n, n2);
        }
        this.lastSourceTypeToNumberOfSlots = map;
        this.sourceStateUpdater.updateNumberOfSlots(hashMap);
    }
}

