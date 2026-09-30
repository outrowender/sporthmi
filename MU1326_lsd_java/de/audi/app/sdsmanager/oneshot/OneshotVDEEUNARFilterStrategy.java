/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.Picklist;
import de.audi.app.sdsmanager.oneshot.OneshotFilterStrategy;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.List;

public class OneshotVDEEUNARFilterStrategy
extends OneshotFilterStrategy {
    public OneshotVDEEUNARFilterStrategy(LogChannel logChannel) {
        super(logChannel);
    }

    public IPicklist filterEntryPicklist(IPicklist iPicklist, String[] stringArray, int n) {
        Object[] objectArray;
        int n2;
        if (n != 2) {
            return super.filterEntryPicklist(iPicklist, stringArray, n);
        }
        this.logger.log(10000000, "NaviVDEOneshotHandler#filterEntryPicklist: housenumber filtering with filterStrings=%1", (Object)stringArray);
        ArrayList arrayList = new ArrayList();
        int n3 = iPicklist.getSize();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            objectArray = iPicklist.get(n2);
            if (objectArray == null) {
                this.logger.log(100000, "NaviVDEOneshotHandler#filterEntryPicklist: Empty curElement!");
                continue;
            }
            IPicklistSlot[] iPicklistSlotArray = objectArray.getSlots();
            boolean bl = SDSUtils.matchFilterStrings(stringArray, iPicklistSlotArray);
            this.logger.log(10000000, "NaviVDEOneshotHandler#filterEntryPicklist: %1 entry #%2!", (Object)(bl ? "Matching" : "Mismatch for"), (long)n2);
            if (!bl) continue;
            n4 += this.storeMatchingHousenumberElement((IPicklistElement)objectArray, iPicklistSlotArray[n], arrayList);
        }
        n2 = arrayList.size();
        if (n2 == 1 && n4 > 0) {
            this.logger.log(10000000, "NaviVDEOneshotHandler#filterEntryPicklist: 1 matching entry, but it is empty -> return empty list!");
            return new Picklist(new IPicklistElement[0]);
        }
        objectArray = (IPicklistElement[])arrayList.toArray(new IPicklistElement[n2]);
        this.logger.log(10000000, "NaviVDEOneshotHandler#filterEntryPicklist: matchingSize=%2, matchingElements=%3!", (Object)SDSUtils.toString(objectArray, false), (long)n2);
        return new Picklist((IPicklistElement[])objectArray);
    }

    private int storeMatchingHousenumberElement(IPicklistElement iPicklistElement, IPicklistSlot iPicklistSlot, List list) {
        this.logger.log(10000000, "NaviVDEOneshotHandler#storeMatchingHousenumberElement: called");
        int n = 0;
        if (iPicklistSlot == null || SDSUtils.isEmpty(iPicklistSlot.getText())) {
            this.logger.log(10000000, "NaviVDEOneshotHandler#storeMatchingHousenumberElement: Empty house number slot found!");
            ++n;
        }
        SDSUtils.addToMatchingEntries(iPicklistElement, iPicklistSlot, list, this.logger);
        return n;
    }
}

