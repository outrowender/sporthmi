/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.nbest.Picklist;
import de.audi.app.sdsmanager.nbest.PicklistElement;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;

public final class SDSUtils {
    public static final long ID_INVALID;
    public static final int TRANSLATION_NOT_FOUND_INT;
    public static final int TRANSLATION_NOT_FOUND_BYTE;
    public static final int SYSTEM_LIST_MODE_COM_DISAMBIGUATION;
    public static final int SYSTEM_LIST_MODE_FAV_DISAMBIGUATION;
    private static Set picklistModels;
    private static Set lockedPicklistModels;
    public static final int DO_NOT_GENERATE_PERMUTATIONS;
    public static final int GENERATE_ALL_PERMUTATIONS;
    public static final int GENERATE_SHORT_PERMUTATIONS;
    private static final byte NIBBLE_SIZE;

    private SDSUtils() {
    }

    public static void initPickList(BaseListModelApp baseListModelApp, int n, BaseListModelListener baseListModelListener) {
        if (baseListModelApp == null) {
            return;
        }
        picklistModels.add(new Integer(baseListModelApp.getID()));
        baseListModelApp.setListener(baseListModelListener);
        baseListModelApp.setSelectedIndex(-1);
    }

    public static boolean isPicklistModel(int n) {
        return picklistModels.contains(new Integer(n));
    }

    public static boolean isUnlockedPicklistModel(int n) {
        if (!picklistModels.contains(new Integer(n))) {
            return false;
        }
        return !lockedPicklistModels.contains(new Integer(n));
    }

    public static void handleDisambiguationLabels(NBestListEntry[] nBestListEntryArray) {
        if (nBestListEntryArray.length <= 1) {
            return;
        }
        Object[] objectArray = nBestListEntryArray[0].getSlots();
        Object[] objectArray2 = nBestListEntryArray[1].getSlots();
        if (SDSUtils.isEmpty(objectArray) || SDSUtils.isEmpty(objectArray2)) {
            return;
        }
        if (SDSManagerBaseActivator.getMapping().isSUIGrammar(nBestListEntryArray[0].getGrammarId())) {
            String[] stringArray = new String[]{SDSUtils.toString((NBestSlot[])objectArray, " "), SDSUtils.toString((NBestSlot[])objectArray2, " ")};
            SDSModelAccess.setDisambiguationLabel(stringArray);
        } else {
            int n = 0;
            while (objectArray[n] == null) {
                ++n;
            }
            if (n < objectArray.length && n < objectArray2.length) {
                String[] stringArray = new String[]{((NBestSlot)objectArray[n]).getRecognizedString(), ((NBestSlot)objectArray2[n]).getRecognizedString()};
                SDSModelAccess.setDisambiguationLabel(stringArray);
            }
        }
    }

    public static void handleDisambiguationLabels(IPicklist iPicklist) {
        if (SDSUtils.isEmpty(iPicklist) || iPicklist.getSize() <= 1) {
            return;
        }
        Object[] objectArray = iPicklist.get(0).getSlots();
        Object[] objectArray2 = iPicklist.get(1).getSlots();
        if (SDSUtils.isEmpty(objectArray) || SDSUtils.isEmpty(objectArray2)) {
            return;
        }
        if (SDSManagerBaseActivator.getMapping().isSUIGrammar(iPicklist.get(0).getRuleID())) {
            String[] stringArray = new String[]{SDSUtils.toString((IPicklistSlot[])objectArray, " "), SDSUtils.toString((IPicklistSlot[])objectArray2, " ")};
            SDSModelAccess.setDisambiguationLabel(stringArray);
        } else {
            String[] stringArray = new String[]{objectArray[0].getText(), objectArray2[0].getText()};
            SDSModelAccess.setDisambiguationLabel(stringArray);
        }
    }

    public static void handleItemSelected(int n, int n2, HMIService hMIService, ISDSApplication iSDSApplication, LogChannel logChannel) {
        BaseListModelApp baseListModelApp = hMIService.getBaseListModel(n);
        if (iSDSApplication.isListLineDataGetActive()) {
            logChannel.log(-2137614336, "SDSUtils#handleItemSelectedForPicklist: ListLineDataGet active, selecting line #%1!", (long)n2);
            baseListModelApp.setSelectedIndex(n2);
            if (baseListModelApp.getStatus() != 0) {
                SDSUtils.lockPicklistModel(n, baseListModelApp, hMIService, logChannel);
            }
            iSDSApplication.sdsListLineDataGet(n, n2);
        } else if (SDSUtils.isUnlockedPicklistModel(n)) {
            logChannel.log(-2137614336, "SDSUtils#handleItemSelected: ListLineDataGet NOT active!");
            SDSUtils.lockPicklistModel(n, baseListModelApp, hMIService, logChannel);
            iSDSApplication.entrySelected(n2);
        }
    }

    public static void lockPicklistModel(int n, HMIModelApp hMIModelApp, HMIService hMIService, LogChannel logChannel) {
        logChannel.log(-2137614336, "SDSUtils#lockPicklistModel: Locking list model %1 and firing event!", (long)n);
        hMIModelApp.setStatus(0);
        BaseListModelApp baseListModelApp = hMIService.getBaseListModel(n);
        MenuModelApp menuModelApp = baseListModelApp.getMenu();
        menuModelApp.setStatus(0);
        menuModelApp.fireEvent(0);
        lockedPicklistModels.add(new Integer(n));
    }

    public static void unlockPicklistModel(int n, IHMIServiceApp iHMIServiceApp, LogChannel logChannel) {
        logChannel.log(-2137614336, "SDSUtils#unlockPicklistModel: Resetting cursor position to -1 and unlocking list model %1!", (long)n);
        BaseListModelApp baseListModelApp = iHMIServiceApp.getBaseListModel(n);
        if (baseListModelApp == null) {
            logChannel.log(10000, "SDSUtils#unlockPicklistModel: no base list model with that id found!");
            return;
        }
        baseListModelApp.setSelectedIndex(-1);
        baseListModelApp.setStatus(1);
        baseListModelApp.fireEvent(0);
        MenuModelApp menuModelApp = baseListModelApp.getMenu();
        menuModelApp.setStatus(1);
        lockedPicklistModels.remove(new Integer(n));
    }

    public static void updateSDSNumbers(boolean bl) {
        SDSModelAccess.setSDSNumber(bl ? 1 : 0);
    }

    public static AbstractSystemCallCommand getActiveSystemCall() {
        CommandList commandList = SDSManagerBaseActivator.getSysCallCmdListManager().getActiveCommandList();
        if (commandList == null) {
            return null;
        }
        try {
            return (AbstractSystemCallCommand)commandList.getActiveCommand();
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    public static String[] expandName(String string, int n) {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = StringUtils.splitString(string, ' ');
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = stringArray[i2];
            if (string2.endsWith(",")) {
                string2 = string2.substring(0, Math.max(0, string2.length() - 1));
            }
            if (n == 2 && n2 < 4 || n == 1 && n2 < 5) {
                int n3 = arrayList.size();
                for (int i3 = 0; i3 < n3; ++i3) {
                    ArrayList arrayList2 = (ArrayList)arrayList.get(i3);
                    int n4 = arrayList2.size();
                    for (int i4 = 0; i4 <= n4; ++i4) {
                        ArrayList arrayList3 = (ArrayList)arrayList2.clone();
                        arrayList3.add(i4, string2);
                        arrayList.add(arrayList3);
                    }
                }
            }
            if (string2.length() < 2 || string2.length() == 2 && string2.substring(1).equals(".")) continue;
            ArrayList arrayList4 = new ArrayList(1);
            arrayList4.add(string2);
            arrayList.add(arrayList4);
        }
        return SDSUtils.convertToStringArray(arrayList);
    }

    private static String[] convertToStringArray(List list) {
        String[] stringArray = new String[list.size()];
        Iterator iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            List list2 = (List)iterator.next();
            stringArray[n++] = SDSUtils.concatenateStringList(list2, " ");
        }
        return stringArray;
    }

    public static long getSelectedObjectId(NBestStorageAccess nBestStorageAccess, LogChannel logChannel, int n) {
        IPicklistSlot iPicklistSlot = SDSUtils.getSelectedSlot(nBestStorageAccess, logChannel, n);
        long l = iPicklistSlot == null ? -1L : iPicklistSlot.getObjID();
        logChannel.log(-2137614336, "SDSUtils#selectEntryFromPicklist: objID=%1!", l);
        return l;
    }

    public static String getSelectedObjectStringId(NBestStorageAccess nBestStorageAccess, LogChannel logChannel, int n) {
        IPicklistSlot iPicklistSlot = SDSUtils.getSelectedSlot(nBestStorageAccess, logChannel, n);
        String string = iPicklistSlot == null ? "" : iPicklistSlot.getObjectStringID();
        logChannel.log(-2137614336, "SDSUtils#selectEntryFromPicklist: objectStringID=%1!", (Object)string);
        return string;
    }

    public static String getSelectedEntryString(NBestStorageAccess nBestStorageAccess, LogChannel logChannel, int n) {
        IPicklistSlot iPicklistSlot = SDSUtils.getSelectedSlot(nBestStorageAccess, logChannel, n);
        String string = iPicklistSlot == null ? "" : iPicklistSlot.getText();
        logChannel.log(-2137614336, "SDSUtils#selectEntryFromPicklist: slotText=%1!", (Object)string);
        return string;
    }

    public static IPicklistSlot getSelectedSlot(NBestStorageAccess nBestStorageAccess, LogChannel logChannel, int n) {
        IPicklist iPicklist = nBestStorageAccess.getMatchingPicklist((byte)0);
        logChannel.log(-2137614336, "SDSUtils#getSelectedSlot: picklist=%1!", (Object)iPicklist.toString());
        int n2 = Math.max(iPicklist.getLastRecogLineNumber(), 0);
        logChannel.log(-2137614336, "SDSUtils#getSelectedSlot: lastrecogline=%1!", (long)n2);
        return iPicklist.getSlot(n2, n);
    }

    public static String toString(Object[] objectArray, boolean bl) {
        int n = -1;
        try {
            n = objectArray.length - 1;
        }
        catch (NullPointerException nullPointerException) {
            return "[]";
        }
        if (n == -1) {
            return "[]";
        }
        String string = bl ? ",\n" : ", ";
        Buffer buffer = new Buffer().append("[ ");
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(SDSUtils.toString(objectArray[i2])).append(string);
        }
        buffer.append(SDSUtils.toString(objectArray[n])).append(" ]");
        return buffer.toString();
    }

    public static String toString(NBestSlot[] nBestSlotArray, String string) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (SDSUtils.isEmpty(nBestSlotArray)) {
            return stringBuffer.toString();
        }
        for (int i2 = 0; i2 < nBestSlotArray.length && nBestSlotArray[i2] != null && !SDSUtils.isEmpty(nBestSlotArray[i2].getRecognizedString()); ++i2) {
            stringBuffer.append(stringBuffer.length() == 0 ? "" : string).append(nBestSlotArray[i2].getRecognizedString());
        }
        return stringBuffer.toString();
    }

    public static String toString(IPicklistSlot[] iPicklistSlotArray, String string) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (SDSUtils.isEmpty(iPicklistSlotArray)) {
            return stringBuffer.toString();
        }
        for (int i2 = 0; i2 < iPicklistSlotArray.length && iPicklistSlotArray[i2] != null && !SDSUtils.isEmpty(iPicklistSlotArray[i2].getText()); ++i2) {
            stringBuffer.append(stringBuffer.length() == 0 ? "" : string).append(iPicklistSlotArray[i2].getText());
        }
        return stringBuffer.toString();
    }

    public static String toString(Object object) {
        return object != null ? object.toString() : "";
    }

    public static String toString(List list, boolean bl) {
        if (SDSUtils.isEmpty(list)) {
            return "[]";
        }
        return SDSUtils.toString(list.toArray(new Object[list.size()]), bl);
    }

    public static String toString(List list, String string) {
        if (SDSUtils.isEmpty(list)) {
            return "[]";
        }
        return SDSUtils.toString(list.toArray(new Object[list.size()]), string);
    }

    public static String concatenateStringList(List list, String string) {
        if (SDSUtils.isEmpty(list)) {
            return "";
        }
        String[] stringArray = (String[])list.toArray(new String[list.size()]);
        Buffer buffer = new Buffer();
        int n = stringArray.length - 1;
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(stringArray[i2]).append(string);
        }
        buffer.append(stringArray[n]);
        return buffer.toString();
    }

    public static String toString(int[] nArray) {
        if (SDSUtils.isEmpty(nArray)) {
            return "[]";
        }
        Buffer buffer = new Buffer().append('[');
        int n = nArray.length - 1;
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(nArray[i2]).append(',').append(' ');
        }
        buffer.append(nArray[n]).append(']');
        return buffer.toString();
    }

    public static String toString(long[] lArray) {
        if (SDSUtils.isEmpty(lArray)) {
            return "[]";
        }
        Buffer buffer = new Buffer().append('[');
        int n = lArray.length - 1;
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(lArray[i2]).append(',').append(' ');
        }
        buffer.append(lArray[n]).append(']');
        return buffer.toString();
    }

    public static String toString(String[] stringArray, boolean bl) {
        if (SDSUtils.isEmpty(stringArray)) {
            return bl ? "[]" : "";
        }
        Buffer buffer = new Buffer();
        if (!bl) {
            buffer.append('[');
        }
        int n = stringArray.length - 1;
        String string = bl ? ",\n" : ", ";
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(SDSUtils.removeBrackets(stringArray[i2])).append(string);
        }
        buffer.append(stringArray[n]);
        if (!bl) {
            buffer.append(']');
        }
        return buffer.toString();
    }

    public static String toString(Object[] objectArray, String string) {
        if (SDSUtils.isEmpty(objectArray)) {
            return "";
        }
        Buffer buffer = new Buffer();
        buffer.append('[');
        int n = objectArray.length - 1;
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(objectArray[i2].toString()).append(string);
        }
        buffer.append(objectArray[n]);
        buffer.append(']');
        return buffer.toString();
    }

    public static String toString(String[][] stringArray, boolean bl) {
        if (SDSUtils.isEmpty(stringArray)) {
            return bl ? "[]" : "";
        }
        Buffer buffer = new Buffer();
        if (!bl) {
            buffer.append('[');
        }
        int n = stringArray.length - 1;
        String string = bl ? ",\n" : ", ";
        for (int i2 = 0; i2 < n; ++i2) {
            String string2 = SDSUtils.toString(stringArray[i2], false);
            buffer.append(string2).append(string);
        }
        buffer.append(SDSUtils.toString(stringArray[n], false));
        if (!bl) {
            buffer.append(']');
        }
        return buffer.toString();
    }

    public static String toString(long[][] lArray, boolean bl) {
        if (SDSUtils.isEmpty((Object[])lArray)) {
            return "";
        }
        Buffer buffer = new Buffer().append('[');
        int n = lArray.length - 1;
        String string = bl ? ",\n" : ", ";
        for (int i2 = 0; i2 < n; ++i2) {
            String string2 = SDSUtils.toString(lArray[i2]);
            buffer.append(string2).append(string);
        }
        buffer.append(SDSUtils.toString(lArray[n])).append(']');
        return buffer.toString();
    }

    private static String removeBrackets(String string) {
        if (SDSUtils.isEmpty(string)) {
            return "";
        }
        Buffer buffer = new Buffer();
        int n = string.length();
        for (int i2 = 0; i2 < n; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == '<' || c2 == '>') continue;
            buffer.append(c2);
        }
        return buffer.toString();
    }

    public static boolean isSupported(String string, String[] stringArray) {
        if (stringArray == null) {
            return false;
        }
        int n = stringArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (!string.equalsIgnoreCase(stringArray[i2])) continue;
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isEmpty(String[] stringArray) {
        return stringArray == null || stringArray.length == 0 || SDSUtils.isEmpty(stringArray[0]);
    }

    public static boolean isEmpty(int[] nArray) {
        return nArray == null || nArray.length == 0;
    }

    public static boolean isEmpty(long[] lArray) {
        return lArray == null || lArray.length == 0;
    }

    private static boolean isEmpty(String[][] stringArray) {
        return stringArray == null || stringArray.length == 0 || SDSUtils.isEmpty(stringArray[0]) || SDSUtils.isEmpty(stringArray[0][0]);
    }

    public static boolean isEmpty(Object[] objectArray) {
        return objectArray == null || objectArray.length == 0;
    }

    public static boolean isEmpty(NaviService$OneshotData naviService$OneshotData) {
        return naviService$OneshotData == null || SDSUtils.isEmpty(naviService$OneshotData.getText());
    }

    public static boolean isEmpty(IPicklist iPicklist) {
        return iPicklist == null || iPicklist.getSize() == 0;
    }

    public static boolean isEmpty(NBestList nBestList) {
        return nBestList == null || SDSUtils.isEmpty(nBestList.getEntries());
    }

    public static String remove(String string, char c2) {
        if (string == null) {
            return "";
        }
        Buffer buffer = new Buffer();
        int n = string.length();
        for (int i2 = 0; i2 < n; ++i2) {
            char c3 = string.charAt(i2);
            if (c3 == c2) continue;
            buffer.append(c3);
        }
        return buffer.toString();
    }

    public static String[] concatenateEntryStrings(String[][] stringArray) {
        if (SDSUtils.isEmpty(stringArray)) {
            return new String[0];
        }
        int n = stringArray.length;
        String[] stringArray2 = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            String[] stringArray3 = stringArray[i2];
            if (stringArray3 == null) continue;
            Buffer buffer = new Buffer();
            for (String string : stringArray3) {
                if (SDSUtils.isEmpty(string)) continue;
                buffer.append(string).append(", ");
            }
            int n2 = buffer.length();
            stringArray2[i2] = n2 < 3 ? buffer.toString() : buffer.substring(0, n2 - 2);
        }
        return stringArray2;
    }

    public static long[] getColumnSlotIDs(long[][] lArray, int n) {
        if (lArray == null) {
            return new long[0];
        }
        int n2 = lArray.length;
        long[] lArray2 = new long[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            lArray2[i2] = lArray[i2] == null ? -1L : lArray[i2][n];
        }
        return lArray2;
    }

    public static boolean isSpeakable(String string) {
        return !SDSUtils.isEmpty(string) && (string.length() > 1 || Character.isLetterOrDigit(string.charAt(0)));
    }

    public static boolean isOnlineRecogActive(LogChannel logChannel) {
        logChannel.log(-2137614336, "SDSUtils#isOnlineRecogActive: called");
        return SDSModelAccess.isPOIOnlineRecogActive();
    }

    public static boolean checkReplyCodeForError(int n, LogChannel logChannel) {
        switch (n) {
            case 200: {
                logChannel.log(-2137614336, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates ABORTED - assuming no error!");
                return false;
            }
            case 111: {
                logChannel.log(-1601830656, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates GRAMMARS PARTIALLY NOT LOADED - assuming no error!");
                return true;
            }
            case 300: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates generic error!");
                return true;
            }
            case 31: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error AUDIO FAILURE!");
                return true;
            }
            case 15: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error BUSY!");
                return true;
            }
            case 26: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error EMPTY GRAMMAR!");
                return true;
            }
            case 25: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error ILLEGAL GRAMMAR!");
                return true;
            }
            case 24: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error ILLEGAL GRAMMAR TYPE!");
                return true;
            }
            case 18: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error ILLEGAL LANGUAGE!");
                return true;
            }
            case 38: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error ILLEGAL VOICETAG!");
                return true;
            }
            case 27: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error NO GRAMMAR!");
                return true;
            }
            case 12: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error NO INIT!");
                return true;
            }
            case 19: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error NO LANGUAGE!");
                return true;
            }
            case 11: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates fatal error OOM!");
                return true;
            }
            case 13: {
                logChannel.log(-1601830656, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error NO OPERATION PENDING!");
                return true;
            }
            case 30: {
                logChannel.log(-1601830656, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error NO RECOGNITION STARTED!");
                return true;
            }
            case 14: {
                logChannel.log(-1601830656, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error OPERATION NOT ABORTABLE!");
                return true;
            }
            case 32: {
                logChannel.log(-1601830656, "[SDSUtils#checkReplyCodeForError] ReplyCode indicates Error SR ENGINE FAILURE!");
                return true;
            }
        }
        logChannel.log(-2137614336, "[SDSUtils#checkReplyCodeForError] Unhandled replyCode %1, assuming no error!", (long)n);
        return false;
    }

    public static boolean checkReplyCodeForTimeout(int n, LogChannel logChannel) {
        switch (n) {
            case 101: {
                logChannel.log(-2137614336, "[SDSUtils#checkReplyCodeForTimeout] ReplyCode indicates Error TIMEOUT!");
                return true;
            }
        }
        logChannel.log(-2137614336, "[SDSUtils#checkReplyCodeForTimeout] Unhandled replyCode %1, assuming no error!", (long)n);
        return false;
    }

    public static boolean checkReplyCodeForNonSatisfyingRecognition(int n, LogChannel logChannel) {
        switch (n) {
            case 107: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForNonSatisfyingRecognition] ReplyCode indicates Error CONFIDENCE_TOO_LOW");
                return true;
            }
            case 106: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForNonSatisfyingRecognition] ReplyCode indicates Error NO_RECOGNITION_RESULT");
                return true;
            }
            case 102: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForNonSatisfyingRecognition] ReplyCode indicates Error UTTERANCE_TOO_LOUD");
                return true;
            }
            case 103: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForNonSatisfyingRecognition] ReplyCode indicates Error UTTERANCE_TOO_WEAK");
                return true;
            }
            case 118: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForNonSatisfyingRecognition] ReplyCode indicates Error RESPONSE_ALL_RECOGNITIONRESULTS_FILTERED_OUT");
                return true;
            }
            case 104: {
                logChannel.log(10000, "[SDSUtils#checkReplyCodeForNonSatisfyingRecognition] ReplyCode indicates Error RECOMMEND REPEAT");
                return true;
            }
        }
        logChannel.log(-2137614336, "[SDSUtils#checkReplyCodeForNonSatisfyingRecognition] Unhandled replyCode %1, assuming satisfying recognition!", (long)n);
        return false;
    }

    private static boolean isValid(ISystemCallParameter[] iSystemCallParameterArray, int n) {
        return iSystemCallParameterArray != null && iSystemCallParameterArray.length > n && iSystemCallParameterArray[n] != null;
    }

    public static boolean retrieveBoolean(ISystemCallParameter[] iSystemCallParameterArray, int n) {
        return SDSUtils.isValid(iSystemCallParameterArray, n) ? iSystemCallParameterArray[n].getBoolean() : false;
    }

    public static int retrieveInteger(ISystemCallParameter[] iSystemCallParameterArray, int n) {
        return SDSUtils.isValid(iSystemCallParameterArray, n) ? iSystemCallParameterArray[n].getInteger() : -1;
    }

    public static String retrieveString(ISystemCallParameter[] iSystemCallParameterArray, int n) {
        return SDSUtils.isValid(iSystemCallParameterArray, n) ? iSystemCallParameterArray[n].getString() : "";
    }

    public static int getLowNibble(long l) {
        return (int)(l & 0);
    }

    public static int getHighNibble(long l) {
        return (int)(l >> 8);
    }

    public static long compressValues(int n, int n2) {
        return n + (n2 << 8);
    }

    public static long getSlotObjIDForSlotIndex(IPicklistSlot iPicklistSlot, IPicklist iPicklist, LogChannel logChannel) {
        IPicklistElement iPicklistElement;
        int n = iPicklistSlot.getIndex();
        logChannel.log(-2137614336, "SDSUtils#getSlotObjIDForSlotIndex: Lookup picklist element for slotIndex %1!", (long)n);
        IPicklistElement iPicklistElement2 = iPicklistElement = iPicklist == null ? null : iPicklist.get(n);
        if (iPicklistElement == null) {
            logChannel.log(-1601830656, "SDSUtils#getSlotObjID: No picklist element for slotIndex %1!", (long)n);
            return -1L;
        }
        return iPicklistElement.getObjectID();
    }

    public static long[] getSlotObjIDsForGGIndex(IPicklist iPicklist, int n, LogChannel logChannel) {
        logChannel.log(-2137614336, "[SDSUtils#getObjIDsForGGIndex] for ggIndex %1", (long)n);
        if (n == -1 || iPicklist == null) {
            return new long[0];
        }
        int n2 = iPicklist.getSize();
        int n3 = 0;
        long[] lArray = new long[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            IPicklistElement iPicklistElement = iPicklist.get(i2);
            if (iPicklistElement.getGraphGroupIndex() != n) continue;
            long l = iPicklistElement.getObjectID();
            logChannel.log(-2137614336, "[SDSUtils#getObjIDsForGGIndex] found ggIndex at picklist entry index %1, id=%2", (long)i2, l);
            lArray[n3] = l;
            ++n3;
        }
        if (n3 == 0) {
            logChannel.log(-2137614336, "[SDSUtils#getObjIDsForGGIndex] no entries found for the ggIndex");
            return new long[0];
        }
        long[] lArray2 = new long[n3];
        System.arraycopy((Object)lArray, 0, (Object)lArray2, 0, n3);
        return lArray2;
    }

    public static long getSlotObjIDForGGIndex(IPicklist iPicklist, int n, LogChannel logChannel) {
        logChannel.log(-2137614336, "[SDSUtils#getObjIDForGGIndex] for ggIndex %1", (long)n);
        if (n == -1 || iPicklist == null) {
            return -1L;
        }
        logChannel.log(-2137614336, "[SDSUtils#getObjIDForGGIndex] picklistFlat=%1", (Object)iPicklist);
        int n2 = iPicklist.getSize();
        for (int i2 = 0; i2 < n2; ++i2) {
            IPicklistElement iPicklistElement = iPicklist.get(i2);
            if (iPicklistElement.getGraphGroupIndex() != n) continue;
            long l = iPicklistElement.getObjectID();
            logChannel.log(-2137614336, "[SDSUtils#getObjIDForGGIndex] found ggIndex at picklist entry index %1, id=%2", (long)i2, l);
            return l;
        }
        logChannel.log(-2137614336, "[SDSUtils#getObjIDForGGIndex] no entries found for the ggIndex");
        return -1L;
    }

    public static long getObjIDForFirstEntryOrGG(NBestStorageAccess nBestStorageAccess, LogChannel logChannel) {
        IPicklist iPicklist = nBestStorageAccess.getMatchingPicklist((byte)0);
        IPicklistSlot iPicklistSlot = iPicklist.getSlot(0, 0);
        if (iPicklistSlot == null) {
            logChannel.log(-1601830656, "SDSUtils#getObjIDViaFirstEntryOrGG: picklist slot null!");
            return -1L;
        }
        long l = iPicklistSlot.getObjID();
        if (l != -1L) {
            logChannel.log(-2137614336, "SDSUtils#getObjIDViaFirstEntryOrGG: id=%1", l);
            return l;
        }
        return SDSUtils.getObjIDForGraphGroupTitle(nBestStorageAccess, iPicklist, logChannel);
    }

    private static long getObjIDForGraphGroupTitle(NBestStorageAccess nBestStorageAccess, IPicklist iPicklist, LogChannel logChannel) {
        int n = iPicklist.get(0).getGraphGroupIndex();
        if (n != -1) {
            nBestStorageAccess.resetPicklistsWithHistory();
            IPicklist iPicklist2 = nBestStorageAccess.getMatchingPicklist((byte)0);
            return SDSUtils.getSlotObjIDForGGIndex(iPicklist2, n, logChannel);
        }
        logChannel.log(-1601830656, "SDSUtils#getObjIDViaFirstEntryOrGG: no valid GG-Index!");
        return -1L;
    }

    public static int getSlotIndexForGGIndex(IPicklist iPicklist, int n, LogChannel logChannel) {
        logChannel.log(-2137614336, "[SDSUtils#getSlotIndexForGGIndex] for ggIndex %1", (long)n);
        if (n == -1 || iPicklist == null) {
            return -1;
        }
        int n2 = iPicklist.getSize();
        for (int i2 = 0; i2 < n2; ++i2) {
            IPicklistElement iPicklistElement = iPicklist.get(i2);
            if (iPicklistElement.getGraphGroupIndex() != n) continue;
            logChannel.log(-2137614336, "[SDSUtils#getSlotIndexForGGIndex] found the ggIndex at picklist entry index %1", (long)i2);
            return i2;
        }
        return -1;
    }

    public static String getStringForObjID(long l, IPicklist iPicklist) {
        for (int i2 = 0; i2 < iPicklist.getSize(); ++i2) {
            Object[] objectArray;
            IPicklistElement iPicklistElement = iPicklist.get(i2);
            if (iPicklistElement == null || SDSUtils.isEmpty(objectArray = iPicklistElement.getSlots()) || objectArray[0].getObjID() != l) continue;
            return objectArray[0].getText();
        }
        return "";
    }

    public static NaviService$OneshotData matchSlotToOneshotPicklist(IPicklistSlot iPicklistSlot, IPicklist iPicklist, String[] stringArray, byte by, LogChannel logChannel) {
        IPicklistElement iPicklistElement;
        logChannel.log(-2137614336, "[SDSUtils#matchSlotToOneshotPicklist] for column %1", (long)by);
        if (iPicklistSlot == null || iPicklistSlot.getIndex() < 0) {
            logChannel.log(-1601830656, "[SDSUtils#matchSlotToOneshotPicklist] -> slot or index invalid");
            return null;
        }
        int n = iPicklistSlot.getIndex();
        IPicklistElement iPicklistElement2 = iPicklistElement = iPicklist == null ? null : iPicklist.get(n);
        if (iPicklistElement == null) {
            logChannel.log(-1601830656, "[SDSUtils#matchSlotToOneshotPicklist] -> no picklist element for index %1", (long)n);
            return null;
        }
        if (stringArray == null) {
            logChannel.log(-1601830656, "[SDSUtils#matchSlotToOneshotPicklist] -> invalid filter strings for column %1", (long)by);
            return null;
        }
        IPicklistSlot[] iPicklistSlotArray = iPicklistElement.getSlots();
        if (SDSUtils.areSlotsInvalidForColumn(iPicklistSlotArray, by)) {
            logChannel.log(-1601830656, "[SDSUtils#matchSlotToOneshotPicklist] Empty/invalid slot for entry!");
            return null;
        }
        boolean bl = SDSUtils.matchFilterStrings(stringArray, iPicklistSlotArray);
        logChannel.log(-2137614336, "[SDSUtils#matchSlotToOneshotPicklist] %1 entry!", (Object)(bl ? "Matching" : "Mismatch for"));
        if (!bl) {
            return null;
        }
        IPicklistSlot iPicklistSlot2 = iPicklistSlotArray[by];
        NaviService$OneshotData naviService$OneshotData = iPicklistSlot2 != null ? new NaviService$OneshotData(iPicklistSlot2.getText(), iPicklistSlot2.getObjectStringID(), iPicklistSlot2.getObjID()) : new NaviService$OneshotData("", "", -1L);
        return naviService$OneshotData;
    }

    public static boolean areSlotsInvalidForColumn(IPicklistSlot[] iPicklistSlotArray, int n) {
        return SDSUtils.isEmpty(iPicklistSlotArray) || iPicklistSlotArray.length <= n || iPicklistSlotArray[n] == null || SDSUtils.isEmpty(iPicklistSlotArray[n].getText());
    }

    public static boolean matchFilterStrings(String[] stringArray, IPicklistSlot[] iPicklistSlotArray) {
        if (stringArray == null || stringArray.length == 0) {
            return true;
        }
        int n = stringArray.length;
        if (iPicklistSlotArray == null || iPicklistSlotArray.length < n) {
            return false;
        }
        for (int i2 = 0; i2 < n; ++i2) {
            String string;
            IPicklistSlot iPicklistSlot = iPicklistSlotArray[i2];
            String string2 = stringArray[i2];
            String string3 = string = iPicklistSlot == null ? "" : iPicklistSlot.getText();
            if (string2 == null || string2.equalsIgnoreCase(string)) continue;
            return false;
        }
        return true;
    }

    public static void addToMatchingEntries(IPicklistElement iPicklistElement, IPicklistSlot iPicklistSlot, List list, LogChannel logChannel) {
        logChannel.log(-2137614336, "SDSUtils#addToMatchingEntries: called");
        PicklistElement picklistElement = new PicklistElement(iPicklistElement.getRuleID(), 0, -1, new IPicklistSlot[]{iPicklistSlot});
        logChannel.log(-2137614336, "SDSUtils#addToMatchingEntries: matchingElementReduced=%1!", (Object)picklistElement);
        if (!list.contains(picklistElement)) {
            logChannel.log(-2137614336, "SDSUtils#addToMatchingEntries: Adding to %1!", (Object)list);
            list.add(picklistElement);
            return;
        }
        logChannel.log(-2137614336, "SDSUtils#addToMatchingEntries: Already contained in %1!", (Object)list);
    }

    public static IPicklist thinOutEntryPicklist(IPicklist iPicklist, String[] stringArray, int n, LogChannel logChannel) {
        Object[] objectArray;
        int n2;
        logChannel.log(-2137614336, "SDSUtils#thinOutEntryPicklist: filterStrings=%1", (Object)stringArray);
        ArrayList arrayList = new ArrayList();
        int n3 = iPicklist == null ? 0 : iPicklist.getSize();
        for (n2 = 0; n2 < n3; ++n2) {
            objectArray = iPicklist.get(n2);
            IPicklistSlot[] iPicklistSlotArray = objectArray.getSlots();
            if (SDSUtils.areSlotsInvalidForColumn(iPicklistSlotArray, n)) {
                logChannel.log(-2137614336, "SDSUtils#thinOutEntryPicklist: %1 entry #%2!", (Object)"Empty/Invalid slot for", (long)n2);
                continue;
            }
            boolean bl = SDSUtils.matchFilterStrings(stringArray, iPicklistSlotArray);
            logChannel.log(-2137614336, "SDSUtils#thinOutEntryPicklist: %1 for entry #%2!", (Object)(bl ? "Match" : "NO match"), (long)n2);
            if (!bl) continue;
            SDSUtils.addToMatchingEntries((IPicklistElement)objectArray, iPicklistSlotArray[n], arrayList, logChannel);
        }
        n2 = arrayList.size();
        objectArray = (IPicklistElement[])arrayList.toArray(new IPicklistElement[n2]);
        logChannel.log(-2137614336, "SDSUtils#thinOutEntryPicklist: matchingSize=%2, matchingElements=%1!", (Object)SDSUtils.toString(objectArray, false), (long)n2);
        return new Picklist((IPicklistElement[])objectArray);
    }

    public static SDSListEntry[] createSDSListFromPicklist(IPicklist iPicklist) {
        if (SDSUtils.isEmpty(iPicklist)) {
            return new SDSListEntry[0];
        }
        int n = iPicklist.getSize();
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            PicklistElement picklistElement = (PicklistElement)iPicklist.get(i2);
            IPicklistSlot[] iPicklistSlotArray = picklistElement.getSlots();
            if (iPicklistSlotArray.length != 1) {
                return null;
            }
            long l = iPicklistSlotArray[0].getObjID();
            String string = iPicklistSlotArray[0].getText();
            sDSListEntryArray[i2] = new SDSListEntry(string, l);
        }
        return sDSListEntryArray;
    }

    public static boolean contains(String string, String[] stringArray) {
        if (SDSUtils.isEmpty(stringArray)) {
            return false;
        }
        boolean bl = false;
        for (String string2 : stringArray) {
            if (SDSUtils.isEmpty(string2) || !string2.equals(string)) continue;
            bl = true;
            break;
        }
        return bl;
    }

    public static boolean contains(int n, int[] nArray) {
        if (SDSUtils.isEmpty(nArray)) {
            return false;
        }
        for (int n2 : nArray) {
            if (n2 != n) continue;
            return true;
        }
        return false;
    }

    public static int translate(int n, int[][] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n != nArray[i2][0]) continue;
            return nArray[i2][1];
        }
        return 128;
    }

    public static int reverseTranslate(int n, int[][] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n != nArray[i2][1]) continue;
            return nArray[i2][0];
        }
        return 128;
    }

    public static byte translate(byte by, byte[][] byArray) {
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if (by != byArray[i2][0]) continue;
            return byArray[i2][1];
        }
        return -128;
    }

    public static byte getPicklistSizeConstant(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
        }
        return 3;
    }

    public static int[] translateMulti(int n, int[][] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2].length <= 2) {
                return new int[]{128, 128};
            }
            if (n != nArray[i2][0]) continue;
            return new int[]{nArray[i2][1], nArray[i2][2]};
        }
        return new int[]{128, 128};
    }

    public static SDSListEntry[] convertFirstSlotContentToSDSListEntryArray(IPicklistElement[] iPicklistElementArray) {
        if (iPicklistElementArray == null) {
            return new SDSListEntry[0];
        }
        int n = iPicklistElementArray.length;
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            IPicklistSlot iPicklistSlot;
            IPicklistSlot[] iPicklistSlotArray;
            IPicklistElement iPicklistElement = iPicklistElementArray[i2];
            if (iPicklistElement == null || (iPicklistSlotArray = iPicklistElement.getSlots()) == null || iPicklistSlotArray.length == 0 || (iPicklistSlot = iPicklistSlotArray[0]) == null) continue;
            sDSListEntryArray[i2] = new SDSListEntry(iPicklistSlot.getText(), iPicklistSlot.getObjID(), iPicklistElement.getGraphGroupSize());
        }
        return sDSListEntryArray;
    }

    public static SDSListEntry[] convertHighestAvailableSlotContentToSDSListEntryArray(IPicklistElement[] iPicklistElementArray) {
        if (iPicklistElementArray == null) {
            return new SDSListEntry[0];
        }
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[iPicklistElementArray.length];
        for (int i2 = 0; i2 < iPicklistElementArray.length; ++i2) {
            IPicklistSlot[] iPicklistSlotArray;
            IPicklistElement iPicklistElement = iPicklistElementArray[i2];
            if (iPicklistElement == null || (iPicklistSlotArray = iPicklistElement.getSlots()) == null) continue;
            IPicklistSlot iPicklistSlot = null;
            for (int i3 = iPicklistSlotArray.length - 1; i3 >= 0; --i3) {
                if (iPicklistSlotArray[i3] == null) continue;
                iPicklistSlot = iPicklistSlotArray[i3];
                break;
            }
            if (iPicklistSlot == null) continue;
            sDSListEntryArray[i2] = new SDSListEntry(iPicklistSlot.getText(), iPicklistSlot.getObjID(), iPicklistElement.getGraphGroupSize());
        }
        return sDSListEntryArray;
    }

    public static void printExceptionStackTrace(Exception exception, String string) {
        LogChannel logChannel = Logger.getMainLog();
        String string2 = new StringBuffer().append(string).append(": ").toString();
        logChannel.log(10000, new StringBuffer().append(string2).append(exception.toString()).toString());
        logChannel.log(10000, new StringBuffer().append(string2).append("STACKTRACE:").toString());
        StackTraceElement[] stackTraceElementArray = exception.getStackTrace();
        for (int i2 = 0; i2 < stackTraceElementArray.length; ++i2) {
            logChannel.log(10000, new StringBuffer().append(string2).append(stackTraceElementArray[i2].toString()).toString());
        }
    }

    public static String[][] convertToStringArray(LinkedList linkedList) {
        if (SDSUtils.isEmpty(linkedList)) {
            return new String[0][0];
        }
        int n = linkedList.size();
        String[][] stringArray = new String[n][];
        for (int i2 = 0; i2 < n; ++i2) {
            String[] stringArray2 = (String[])linkedList.get(i2);
            stringArray[i2] = stringArray2 == null ? new String[]{} : stringArray2;
        }
        return stringArray;
    }

    public static String convertToString(LinkedList linkedList) {
        if (SDSUtils.isEmpty(linkedList)) {
            return "";
        }
        int n = linkedList.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < n; ++i2) {
            String[] stringArray = (String[])linkedList.get(i2);
            if (i2 != 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(stringArray[0]);
        }
        return stringBuffer.toString();
    }

    public static void storeLineData(IPicklistElement iPicklistElement, LogChannel logChannel) {
        String string = SDSUtils.getFirstSlotText(iPicklistElement, logChannel);
        if (string == null) {
            logChannel.log(-1601830656, "SDSUtils#storeLineData: NULL first slot text!");
            return;
        }
        SDSModelAccess.setListLineDataGetModel(string);
    }

    public static void storeLineDataZipCode(IPicklist iPicklist, int n, LogChannel logChannel) {
        if (iPicklist == null) {
            return;
        }
        IPicklistElement iPicklistElement = iPicklist.get(n);
        if (iPicklistElement == null) {
            return;
        }
        SDSUtils.storeLineDataZipCode(iPicklistElement, logChannel);
    }

    public static void storeLineDataZipCode(IPicklistElement iPicklistElement, LogChannel logChannel) {
        String string = SDSUtils.getFirstSlotText(iPicklistElement, logChannel);
        if (string == null) {
            logChannel.log(-1601830656, "SDSUtils#storeLineDataZipCode: NULL first slot text!");
            return;
        }
        SDSUtils.storeLineDataZipCode(string, logChannel);
    }

    public static void storeLineDataZipCode(String string, LogChannel logChannel) {
        int n = string.indexOf(44);
        String string2 = n != -1 ? string.substring(0, n) : string;
        String string3 = n != -1 ? string.substring(n + 1).trim() : "";
        logChannel.log(-2137614336, "SDSUtils#storeLineDataZipCode: zip='%1', city='%2'", (Object)string2, (Object)string3);
        SDSModelAccess.setListLineDataGetModel(string2);
        SDSModelAccess.setListLineDataGetAdditionalModel(string3);
    }

    private static String getFirstSlotText(IPicklistElement iPicklistElement, LogChannel logChannel) {
        logChannel.log(-2137614336, "SDSUtils#getFirstSlotText: selectedElement=%1", (Object)iPicklistElement);
        Object[] objectArray = iPicklistElement.getSlots();
        if (SDSUtils.isEmpty(objectArray)) {
            logChannel.log(-1601830656, "SDSUtils#getFirstSlotText: selectedElement has no slots => NOP!");
            return null;
        }
        Object object = objectArray[0];
        if (object == null) {
            logChannel.log(-1601830656, "SDSUtils#getFirstSlotText: Empty first slot!");
            return null;
        }
        SDSUtils.fillSlotModelStringIDs((IPicklistSlot[])objectArray, logChannel);
        return object.getText();
    }

    private static void fillSlotModelStringIDs(IPicklistSlot[] iPicklistSlotArray, LogChannel logChannel) {
        int n = iPicklistSlotArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            IPicklistSlot iPicklistSlot = iPicklistSlotArray[i2];
            if (iPicklistSlot == null) {
                logChannel.log(-1601830656, "SDSUtils#fillSlotModelStringIDs: Slot #%1 is null!", (long)i2);
                continue;
            }
            SDSModelAccess.setSlotModelStringID(i2 + 1, iPicklistSlot.getObjectStringID());
        }
    }

    public static void main(String[] stringArray) {
        long l = SDSUtils.compressValues(5, 1);
        int n = SDSUtils.getLowNibble(l);
        int n2 = SDSUtils.getHighNibble(l);
        System.out.println(new StringBuffer().append(l).append(": ").append(n).append(", ").append(n2).toString());
        String[][] stringArray2 = new String[][]{{"Test1", "Test2"}, {"Test3", "Test4"}};
        System.out.println(SDSUtils.toString(stringArray2, false));
        long[][] lArrayArray = new long[][]{{1L, 0}, {0, 0}};
        System.out.println(SDSUtils.toString(lArrayArray, true));
    }

    static {
        picklistModels = new HashSet();
        lockedPicklistModels = new HashSet();
    }
}

