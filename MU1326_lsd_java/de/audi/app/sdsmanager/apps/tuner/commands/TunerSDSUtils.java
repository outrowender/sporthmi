/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.nbest.PicklistElement;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class TunerSDSUtils {
    static final byte TUNER_SOURCE_NBEST = 0;
    static final byte TUNER_SOURCE_PICKLIST = 1;
    static final byte TUNER_SOURCE_OTHER = 2;
    static final byte TUNER_LIST_MODE_STATIONLIST = 0;
    private static final byte TUNER_LIST_MODE_DAB = 1;
    static final byte TUNER_LIST_MODE_SAT = 2;
    private static final byte TUNER_LIST_MODE_GENRE = 3;
    private static final byte TUNER_LIST_MODE_ONLINE = 4;
    private static final TunerStationNameNormalizer STATION_NORMALIZER = new TunerStationNameNormalizer();
    public static final int[][] TUNER_LIST_MODE_TO_POPUP_MAPPING_ID = new int[][]{{1, 10}, {2, 10}, {4, 10}, {0, 10}, {3, 11}};

    static int getWBSResult(byte by, LogChannel logChannel) {
        logChannel.log(10000000, "TunerSDSUtils#getWBSResult: replyCode=%1", (long)by);
        switch (by) {
            case 0: {
                return 10005;
            }
            case 1: 
            case 6: {
                return 10000;
            }
            case 2: {
                return 10001;
            }
            case 3: {
                return 10002;
            }
            case 4: {
                return 10003;
            }
            case 5: {
                return 10004;
            }
            case 7: {
                return 10011;
            }
        }
        logChannel.log(100000, "TunerSDSUtils#sendWBSResult: Unhandled replyCode %1, assuming ERROR!", (long)by);
        return 3001;
    }

    public static TunerService.TunerListEntry[] combineEqualEntries(IPicklist iPicklist) {
        Object object;
        SDSListEntry[] sDSListEntryArray;
        Object object2;
        Object[] objectArray;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int n = iPicklist.getSize();
        for (int i2 = 0; i2 < n; ++i2) {
            PicklistElement picklistElement = (PicklistElement)iPicklist.get(i2);
            objectArray = picklistElement.getSlots();
            long l = objectArray[0].getObjID();
            object2 = objectArray[0].getText();
            sDSListEntryArray = TunerSDSUtils.normalizeStationName((String)object2);
            object = new SDSListEntry((String)object2, l);
            ArrayList arrayList = (ArrayList)linkedHashMap.get(sDSListEntryArray);
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(object);
                linkedHashMap.put(sDSListEntryArray, arrayList2);
                continue;
            }
            arrayList.add(object);
        }
        Collection collection = linkedHashMap.values();
        int n2 = collection.size();
        objectArray = new TunerService.TunerListEntry[n2];
        int n3 = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            object2 = (ArrayList)iterator.next();
            sDSListEntryArray = (SDSListEntry[])((ArrayList)object2).toArray(new SDSListEntry[((ArrayList)object2).size()]);
            object = new TunerService.TunerListEntry(sDSListEntryArray);
            objectArray[n3++] = object;
        }
        return objectArray;
    }

    public static long lookupSelectedTunerPicklistElement(NBestStorageAccess nBestStorageAccess, TunerService tunerService, LogChannel logChannel) {
        SDSListEntry sDSListEntry;
        logChannel.log(10000000, "TunerSDSUtils#lookupSelectedTunerPicklistElement: called");
        if (tunerService == null) {
            return 0L;
        }
        int n = nBestStorageAccess.getLastRecogLine();
        if (n == -1) {
            n = 0;
        }
        if ((sDSListEntry = tunerService.getTunerPicklistEntry(n)) == null || SDSUtils.isEmpty(sDSListEntry.getName())) {
            return 0L;
        }
        return sDSListEntry.getId();
    }

    public static String normalizeStationName(String string) {
        return TunerSDSUtils.STATION_NORMALIZER.normalize(string);
    }

    private static class TunerStationNameNormalizer {
        private final Set delChars = new HashSet();

        private TunerStationNameNormalizer() {
            this.delChars.add(new Character('_'));
            this.delChars.add(new Character('-'));
            this.delChars.add(new Character(' '));
        }

        private String normalize(String string) {
            if (SDSUtils.isEmpty(string)) {
                return "";
            }
            String string2 = string.toLowerCase().trim();
            Buffer buffer = new Buffer();
            int n = string2.length();
            for (int i2 = 0; i2 < n; ++i2) {
                char c2 = string2.charAt(i2);
                if (this.delChars.contains(new Character(c2))) continue;
                buffer.append(c2);
            }
            return buffer.toString();
        }
    }
}

