/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.Picklist;
import de.audi.app.sdsmanager.oneshot.IOneshotFilterStrategy;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;

public class OneshotFilterStrategy
implements IOneshotFilterStrategy {
    LogChannel logger;

    public OneshotFilterStrategy(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public IPicklist filterEntryPicklist(IPicklist iPicklist, String[] stringArray, int n) {
        Object[] objectArray;
        int n2;
        this.logger.log(-2137614336, "OneshotHandler#filterEntryPicklist: filterStrings=%1", (Object)stringArray);
        ArrayList arrayList = new ArrayList();
        int n3 = iPicklist == null ? 0 : iPicklist.getSize();
        for (n2 = 0; n2 < n3; ++n2) {
            objectArray = iPicklist.get(n2);
            IPicklistSlot[] iPicklistSlotArray = objectArray.getSlots();
            if (SDSUtils.areSlotsInvalidForColumn(iPicklistSlotArray, n)) {
                this.logger.log(-2137614336, "OneshotHandler#filterEntryPicklist: %1 entry #%2!", (Object)"Empty/Invalid slot for", (long)n2);
                continue;
            }
            boolean bl = SDSUtils.matchFilterStrings(stringArray, iPicklistSlotArray);
            this.logger.log(-2137614336, "OneshotHandler#filterEntryPicklist: %1 for entry #%2!", (Object)(bl ? "Match" : "NO match"), (long)n2);
            if (!bl) continue;
            SDSUtils.addToMatchingEntries((IPicklistElement)objectArray, iPicklistSlotArray[n], arrayList, this.logger);
        }
        n2 = arrayList.size();
        objectArray = (IPicklistElement[])arrayList.toArray(new IPicklistElement[n2]);
        this.logger.log(-2137614336, "OneshotHandler#filterEntryPicklist: matchingSize=%2, matchingElements=%1!", (Object)SDSUtils.toString(objectArray, false), (long)n2);
        return new Picklist((IPicklistElement[])objectArray);
    }
}

