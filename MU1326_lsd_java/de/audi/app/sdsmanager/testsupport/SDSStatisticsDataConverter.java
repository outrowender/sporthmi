/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.testsupport.SLMRulesMap;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;

public class SDSStatisticsDataConverter {
    private static final String EMPTY_STR;
    private static final String[] TXT_BLOCK_DELIM;
    private static Map map;
    private String[] currentCommand = new String[0];

    public SDSStatisticsDataConverter(SLMRulesMap sLMRulesMap) {
        map = sLMRulesMap.getMap();
    }

    public static String getSLMRulesLogging(NBestListEntry[] nBestListEntryArray) {
        if (SDSUtils.isEmpty(nBestListEntryArray)) {
            return "[null/empty!]";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < nBestListEntryArray.length; ++i2) {
            NBestListEntry nBestListEntry = nBestListEntryArray[i2];
            NBestListEntry nBestListEntry2 = null == nBestListEntry ? new NBestListEntry() : nBestListEntry;
            int n = nBestListEntry2.getGrammarId();
            Integer n2 = new Integer(n);
            if (!map.containsKey(n2)) {
                return "[NO MAPPING!]";
            }
            String[] stringArray = (String[])map.get(n2);
            String string = SDSUtils.toString(stringArray, false);
            buffer.append(string);
            if (i2 >= nBestListEntryArray.length - 1) continue;
            buffer.append(", ");
        }
        return buffer.toString();
    }

    String[] getLastSDSCommandInfos(NBestListEntry nBestListEntry) {
        NBestListEntry nBestListEntry2 = null == nBestListEntry ? new NBestListEntry() : nBestListEntry;
        String[] stringArray = this.currentCommand;
        int n = nBestListEntry2.getGrammarId();
        if (n == -1) {
            this.currentCommand = new String[]{"NO RECOGNIZER RESULT!"};
            return SDSStatisticsDataConverter.concatArrayOfStringArrays(new String[][]{TXT_BLOCK_DELIM, stringArray, TXT_BLOCK_DELIM, this.currentCommand, TXT_BLOCK_DELIM});
        }
        String string = nBestListEntry2.getRecognizedString();
        int n2 = nBestListEntry2.getConfidence();
        int n3 = nBestListEntry2.getGraphemicGroupIndex();
        String string2 = SDSUtils.isEmpty(string) ? "S-L-M" : "B-N-F";
        String[] stringArray2 = new String[]{new Buffer().append("Type: ").append(string2).append(" | Id: ").append(n).append(" | GraphGrIdx: ").append(n3).append(" | Conf: ").append(n2).toString()};
        String[] stringArray3 = string2.equalsIgnoreCase("S-L-M") ? SDSStatisticsDataConverter.getLastCommandSLMRuleEntries(n) : new String[]{new Buffer().append("Rec: ").append(string).toString()};
        String[] stringArray4 = SDSStatisticsDataConverter.getLastCommandSlotEntries(nBestListEntry2);
        String[] stringArray5 = SDSStatisticsDataConverter.concatArrayOfStringArrays(new String[][]{stringArray2, stringArray3, stringArray4});
        this.currentCommand = stringArray5;
        return SDSStatisticsDataConverter.concatArrayOfStringArrays(new String[][]{TXT_BLOCK_DELIM, stringArray, TXT_BLOCK_DELIM, this.currentCommand, TXT_BLOCK_DELIM});
    }

    private static String[] concatArrayOfStringArrays(String[][] stringArray) {
        if (SDSUtils.isEmpty((Object[])stringArray)) {
            return new String[0];
        }
        int n = 0;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (SDSUtils.isEmpty(stringArray[i2])) {
                stringArray[i2] = new String[0];
                continue;
            }
            n += stringArray[i2].length;
        }
        String[] stringArray2 = new String[n];
        int n2 = 0;
        for (int i3 = 0; i3 < stringArray.length; ++i3) {
            int n3 = i3 == 0 ? 0 : stringArray[i3 - 1].length;
            System.arraycopy((Object)stringArray[i3], 0, (Object)stringArray2, n2 += n3, stringArray[i3].length);
        }
        return stringArray2;
    }

    private static String[] getLastCommandSLMRuleEntries(int n) {
        String[] stringArray;
        Integer n2 = new Integer(n);
        String[] stringArray2 = stringArray = map.containsKey(n2) ? (String[])map.get(n2) : new String[]{};
        if (SDSUtils.isEmpty(stringArray)) {
            return new String[]{"NO MAPPING ID!"};
        }
        String[] stringArray3 = stringArray.length == 1 ? new String[]{new Buffer().append("Rule: ").append(stringArray[0]).toString()} : SDSStatisticsDataConverter.concatArrayOfStringArrays(new String[][]{{"Rules:"}, stringArray});
        return stringArray3;
    }

    private static String[] getLastCommandSlotEntries(NBestListEntry nBestListEntry) {
        String[] stringArray;
        NBestListEntry nBestListEntry2 = nBestListEntry == null ? new NBestListEntry() : nBestListEntry;
        Object[] objectArray = nBestListEntry2.getSlots();
        if (SDSUtils.isEmpty(objectArray)) {
            return new String[0];
        }
        if (objectArray.length == 1) {
            stringArray = new String[]{new Buffer().append("Slot: ").append(SDSStatisticsDataConverter.getLastCommandSlotData((NBestSlot)objectArray[0])).toString()};
        } else {
            stringArray = new String[1 + objectArray.length];
            stringArray[0] = "Slots:";
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Object object = objectArray[i2];
                stringArray[1 + i2] = SDSStatisticsDataConverter.getLastCommandSlotData((NBestSlot)object);
            }
        }
        return stringArray;
    }

    private static String getLastCommandSlotData(NBestSlot nBestSlot) {
        if (nBestSlot == null) {
            return "IS NULL!";
        }
        int n = nBestSlot.getId();
        String string = nBestSlot.getRecognizedString();
        int n2 = nBestSlot.getIndex();
        long l = nBestSlot.getObjectId();
        String string2 = nBestSlot.getObjectStringId();
        Buffer buffer = new Buffer();
        buffer.append("Id: ").append(n).append(" | Rec: ").append(SDSUtils.isEmpty(string) ? "---" : string).append(" | Idx: ").append(n2).append(" | ObjId: ").append(l).append(" | StrId: ").append(SDSUtils.isEmpty(string2) ? "---" : string2);
        return buffer.toString();
    }

    static {
        TXT_BLOCK_DELIM = new String[]{"-----------------------------------------"};
    }
}

