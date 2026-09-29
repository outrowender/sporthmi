/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.nbest.PicklistElement;
import de.audi.app.sdsmanager.nbest.PicklistSlot;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;

public final class NBestUtils {
    private NBestUtils() {
    }

    public static void setChoiceModel(int n, LogChannel logChannel) {
        int n2;
        if (SDSModelAccess.isADBSelectionInterrupt()) {
            logChannel.log(-2137614336, "NBestUtils#setChoiceModel: nBestListModel not set because ADBSelectionInterrupt case");
            return;
        }
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        SDSModelAccess.setNBestListModel(n2);
    }

    public static void setLabelModel(NBestListEntry nBestListEntry, LogChannel logChannel) {
        String string = nBestListEntry.getRecognizedString();
        logChannel.log(-2137614336, "NBestUtils#setLabelModel: topRecognizedString=%1!", (Object)string);
        SDSModelAccess.setPromptModel(string);
    }

    public static void setTagModel(NBestListEntry nBestListEntry, LogChannel logChannel) {
        String string = nBestListEntry.getRecognizedTag();
        if (SDSUtils.isEmpty(string)) {
            SDSModelAccess.setTagModel(-1);
            return;
        }
        try {
            SDSModelAccess.setTagModel(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            logChannel.log(-1601830656, "NBestUtils#setTagModel: topRecognizedTag is no integer! -> %1", (Object)string);
        }
    }

    public static byte setSlotModels(NBestListEntry nBestListEntry, LogChannel logChannel) {
        int n;
        NBestSlot[] nBestSlotArray = nBestListEntry.getSlots();
        if (nBestSlotArray == null || nBestSlotArray.length < 1) {
            logChannel.log(-2137614336, "NBestUtils#setSlotModels: No slots in topEntry, clearing slotModels and returning C&C!");
            NBestUtils.clearSlotModels();
            return 0;
        }
        int n2 = nBestSlotArray.length;
        String[] stringArray = new String[5];
        String[] stringArray2 = new String[5];
        for (n = 0; n < n2; ++n) {
            NBestSlot nBestSlot = nBestSlotArray[n];
            stringArray[n] = nBestSlot == null ? "" : nBestSlot.getRecognizedString();
            stringArray2[n] = nBestSlot == null ? "" : nBestSlot.getObjectStringId();
            logChannel.log(-2137614336, "NBestUtils#setSlotModels: topEntrySlotString[%3]=%1 with stringID %2!", (Object)stringArray[n], (Object)stringArray2[n], (long)n);
        }
        NBestUtils.setSlotModels(stringArray, stringArray2, true);
        n = SDSManagerBaseActivator.getMapping().getSlotOrder(nBestListEntry.getGrammarId()) == null ? 1 : 0;
        logChannel.log(-2137614336, "NBestUtils#setSlotModels: singleSlot=%1!", n != 0);
        return n != 0 ? (byte)1 : 2;
    }

    private static void setSlotModels(String[] stringArray, String[] stringArray2, boolean bl) {
        if (bl) {
            SDSModelAccess.setListLineDataGetModel(stringArray[0]);
            SDSModelAccess.setListLineDataGetAdditionalModel("");
        }
        int n = stringArray.length;
        for (int n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
            SDSModelAccess.setSlotModel(n2 + 1, n > n2 ? stringArray[n2] : "");
            SDSModelAccess.setSlotModelStringID(n2 + 1, n > n2 ? stringArray2[n2] : "");
        }
    }

    private static void clearSlotModels() {
        Object[] objectArray = new String[5];
        Arrays.fill(objectArray, "");
        NBestUtils.setSlotModels((String[])objectArray, (String[])objectArray, false);
    }

    public static int containsFirstSlot(NBestSlot nBestSlot, Map map, LogChannel logChannel) {
        if (nBestSlot == null) {
            logChannel.log(-2137614336, "NBestUtils#containsFirstSlotID: Empty slot!");
            return -1;
        }
        if (SDSUtils.isEmpty(map)) {
            logChannel.log(-2137614336, "NBestUtils#containsFirstSlotID: Empty entries!");
            return -1;
        }
        long l = nBestSlot.getObjectId();
        String string = nBestSlot.getObjectStringId();
        String string2 = nBestSlot.getRecognizedString();
        logChannel.log(-2137614336, "NBestUtils#containsFirstSlotID: slotObjID=%2, slotStringID=%1!", (Object)string, l);
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer n = (Integer)iterator.next();
            NBestSlot nBestSlot2 = NBestUtils.getFirstSlot((NBestListEntry)map.get(n));
            if (nBestSlot2 == null || l != nBestSlot2.getObjectId()) continue;
            String string3 = nBestSlot2.getRecognizedString();
            if (SDSUtils.isEmpty(string) && SDSUtils.isEmpty(nBestSlot2.getObjectStringId())) {
                if (l == -1L && !string3.equals(string2)) continue;
                return n;
            }
            if (!string.equals(nBestSlot2.getObjectStringId())) continue;
            return n;
        }
        logChannel.log(-2137614336, "NBestUtils#containsFirstSlotID: slotObjID %1 is NOT contained in entries!", l);
        return -1;
    }

    public static boolean containsFirstSlotID(IPicklistSlot iPicklistSlot, ArrayList arrayList, LogChannel logChannel) {
        if (iPicklistSlot == null) {
            logChannel.log(-2137614336, "NBestUtils#containsFirstSlotID: Empty slot!");
            return false;
        }
        if (SDSUtils.isEmpty(arrayList)) {
            logChannel.log(-2137614336, "NBestUtils#containsFirstSlotID: Empty entries!");
            return false;
        }
        long l = iPicklistSlot.getObjID();
        String string = iPicklistSlot.getObjectStringID();
        logChannel.log(-2137614336, "NBestUtils#containsFirstSlotID: slotObjID=%2, slotStringID=%1!", (Object)string, l);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            IPicklistSlot iPicklistSlot2 = NBestUtils.getFirstSlot((PicklistElement)iterator.next());
            if (!iPicklistSlot.isDuplicateSlot(iPicklistSlot2)) continue;
            return true;
        }
        logChannel.log(-2137614336, "NBestUtils#containsFirstSlotID: slotObjID %1 is NOT contained in entries!", l);
        return false;
    }

    public static String[] getFirstSlotStringsFromRange(NBestStorageAccess nBestStorageAccess, LogChannel logChannel, int n, int n2) {
        logChannel.log(-1601830656, "NBestUtils#getFirstSlotStringsFromRange: firstRowIndex=%1, rangeSize=%2!", (long)n, (long)n2);
        Object[] objectArray = nBestStorageAccess.getMatchingPicklist((byte)0).getElements();
        if (SDSUtils.isEmpty(objectArray) || objectArray[0] == null || objectArray[0].getSlots() == null) {
            logChannel.log(-1601830656, "NBestUtils#getFirstSlotStringsFromRange: given nBestStorage has empty or null entries!");
            return new String[0];
        }
        int n3 = objectArray.length;
        if (n < 0 || n2 < 1 || n + n2 > n3) {
            logChannel.log(-1601830656, "NBestUtils#getFirstSlotStringsFromRange: maxSize=%1 => Access out of bounds!", (long)n3);
            return new String[0];
        }
        String[] stringArray = new String[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            IPicklistSlot iPicklistSlot = objectArray[n + i2].getSlots()[0];
            stringArray[i2] = iPicklistSlot == null ? "" : iPicklistSlot.getText();
        }
        return stringArray;
    }

    static NBestSlot getFirstSlot(NBestListEntry nBestListEntry) {
        if (nBestListEntry == null) {
            return null;
        }
        Object[] objectArray = nBestListEntry.getSlots();
        if (SDSUtils.isEmpty(objectArray) || objectArray.length > 1) {
            return null;
        }
        return objectArray[0];
    }

    static IPicklistSlot getFirstSlot(IPicklistElement iPicklistElement) {
        if (iPicklistElement == null) {
            return null;
        }
        Object[] objectArray = iPicklistElement.getSlots();
        if (SDSUtils.isEmpty(objectArray)) {
            return null;
        }
        return objectArray[0];
    }

    static void sortSlots(NBestListEntry[] nBestListEntryArray, LogChannel logChannel) {
        if (nBestListEntryArray == null || nBestListEntryArray.length == 0) {
            logChannel.log(-1601830656, "NBestUtils#sortSlots: No n-best entries given!");
            return;
        }
        int n = nBestListEntryArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            NBestListEntry nBestListEntry = nBestListEntryArray[i2];
            if (nBestListEntry == null) {
                logChannel.log(-1601830656, "NBestUtils#sortSlots: Empty entry %1 => NOP!", (long)i2);
                continue;
            }
            NBestSlot[] nBestSlotArray = nBestListEntry.getSlots();
            if (nBestSlotArray == null) {
                logChannel.log(-1601830656, "NBestUtils#sortSlots: No slots found in entry %1 => NOP!", (long)i2);
                continue;
            }
            int[] nArray = SDSManagerBaseActivator.getMapping().getSlotOrder(nBestListEntry.getGrammarId());
            if (nArray == null) {
                logChannel.log(-1601830656, "NBestUtils#sortSlots: No expected slots found for entry %1 => NOP!", (long)i2);
                continue;
            }
            nBestListEntry.slots = NBestUtils.sortSlotsWithinEntry(nBestSlotArray, nArray, logChannel);
        }
    }

    private static NBestSlot[] sortSlotsWithinEntry(NBestSlot[] nBestSlotArray, int[] nArray, LogChannel logChannel) {
        logChannel.log(-2137614336, "NBestUtils#sortSlotsWithinEntry: slots=%1, expectedSlotIDs=%2", (Object)SDSUtils.toString((Object[])nBestSlotArray, true), (Object)nArray);
        int n = nArray.length;
        NBestSlot[] nBestSlotArray2 = new NBestSlot[n];
        int n2 = nBestSlotArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl = false;
            int n3 = nArray[i2];
            for (int i3 = 0; i3 < n2; ++i3) {
                NBestSlot nBestSlot = nBestSlotArray[i3];
                int n4 = nBestSlot.getId();
                if (n4 != n3) continue;
                logChannel.log(-2137614336, "NBestUtils#sortSlotsWithinEntry: Slot with ID %1 found at #%2, inserting it at %3!", (long)n3, (long)i3, (long)i2);
                nBestSlotArray2[i2] = nBestSlot;
                bl = true;
                break;
            }
            if (bl) continue;
            logChannel.log(-2137614336, "NBestUtils#sortSlotsWithinEntry: Slot with ID %1 at expected #%2 NOT found!", (long)n3, (long)i2);
        }
        return nBestSlotArray2;
    }

    public static IPicklistElement[] makePicklistElements(NBestListEntry[] nBestListEntryArray, int[] nArray, LogChannel logChannel) {
        int[] nArray2 = new int[SDSUtils.isEmpty(nArray) ? 0 : nArray.length];
        Arrays.fill(nArray2, -1);
        return NBestUtils.makePicklistElements(nBestListEntryArray, nArray2, nArray, logChannel);
    }

    static IPicklistElement[] makePicklistElements(NBestListEntry[] nBestListEntryArray, int[] nArray, int[] nArray2, LogChannel logChannel) {
        logChannel.log(-2137614336, "NBestUtils#makePicklistElements: called");
        if (SDSUtils.isEmpty(nBestListEntryArray)) {
            return new PicklistElement[0];
        }
        int n = nBestListEntryArray.length;
        IPicklistElement[] iPicklistElementArray = new IPicklistElement[n];
        for (int i2 = 0; i2 < n; ++i2) {
            int n2;
            NBestListEntry nBestListEntry = nBestListEntryArray[i2];
            if (nBestListEntry == null) continue;
            NBestSlot[] nBestSlotArray = nBestListEntry.getSlots();
            IPicklistSlot[] iPicklistSlotArray = null;
            if (nBestSlotArray == null) continue;
            int n3 = nBestSlotArray.length;
            iPicklistSlotArray = new IPicklistSlot[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                NBestSlot nBestSlot = nBestSlotArray[n2];
                if (nBestSlot == null) continue;
                PicklistSlot picklistSlot = new PicklistSlot(nBestSlot.getRecognizedString(), nBestSlot.getObjectStringId(), nBestSlot.getObjectId(), nBestSlot.getIndex());
                iPicklistSlotArray[n2] = picklistSlot;
            }
            n2 = nBestListEntry.getGraphemicGroupIndex();
            if (n2 == -1) {
                iPicklistElementArray[i2] = new PicklistElement(nBestListEntry.getGrammarId(), nBestListEntry.getConfidence(), nArray2[i2], n2, iPicklistSlotArray);
                continue;
            }
            int n4 = n2;
            int n5 = nArray.length;
            for (int i3 = 0; i3 < n5; ++i3) {
                if (nArray[i3] != n2) continue;
                n4 = i3;
            }
            iPicklistElementArray[i2] = new PicklistElement(nBestListEntry.getGrammarId(), nBestListEntry.getConfidence(), nArray2[i2], n2, n4, iPicklistSlotArray);
        }
        return iPicklistElementArray;
    }

    static void printConfidences(NBestListEntry nBestListEntry, NBestListEntry[] nBestListEntryArray, LogChannel logChannel) {
        if (nBestListEntry == null) {
            logChannel.log(-1601830656, "NBestUtils#printConfidences: topEntry is null!");
            return;
        }
        logChannel.log(-2137614336, "NBestUtils#printConfidences: topConfidence = %1!", (long)nBestListEntry.getConfidence());
        int n = nBestListEntryArray.length;
        for (int i2 = 1; i2 < n; ++i2) {
            NBestListEntry nBestListEntry2 = nBestListEntryArray[i2];
            if (nBestListEntry2 == null) {
                logChannel.log(-1601830656, "NBestUtils#printConfidences: Entry #%1 is null!", (long)i2);
                continue;
            }
            logChannel.log(-2137614336, "NBestUtils#printConfidences: confidence[%1] = %2!", (long)i2, (long)nBestListEntry2.getConfidence());
        }
    }
}

