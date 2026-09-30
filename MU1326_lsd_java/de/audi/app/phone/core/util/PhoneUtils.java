/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.util;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.emergency.IEmergencyTextFactory;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.lang.reflect.Field;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneUtils {
    public static final String STRING_EMPTY = "";
    private static final long SECS_PER_HOUR = 3600L;
    private static final long SECS_PER_MINUTE = 60L;

    public static String privatize(String string, boolean bl) {
        if (string == null || string.equals(STRING_EMPTY)) {
            return STRING_EMPTY;
        }
        if (bl) {
            return "********";
        }
        return string;
    }

    public static String getDisplayName(String string, String string2) {
        if (string == null || string.equals(STRING_EMPTY)) {
            if (string2 == null || string2.equals(STRING_EMPTY)) {
                return "UNKNOWN";
            }
            return string2;
        }
        return string;
    }

    public static String getDisplayNumber(String string, String string2) {
        String string3 = PhoneUtils.getDisplayName(string, string2);
        if (string2 == null || string3 != null && string3.equals(string2)) {
            return STRING_EMPTY;
        }
        return string2;
    }

    public static Buffer arrayToBuffer(Object[] objectArray) {
        Buffer buffer = new Buffer();
        if (objectArray == null) {
            buffer.append("null");
        } else if (objectArray.length == 0) {
            buffer.append("[]");
        } else {
            buffer.append("[");
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                buffer.append(objectArray[i2]);
                buffer.append(",");
            }
            buffer.append("]");
        }
        return buffer;
    }

    public static boolean isPictureAvailable(ResourceLocator resourceLocator) {
        if (resourceLocator == null) {
            return false;
        }
        if (resourceLocator.isIntResource()) {
            return resourceLocator.getId() != -1;
        }
        return resourceLocator.getUrl() != null && resourceLocator.getUrl().length() > 0;
    }

    public static boolean supportsFeature(int n, int n2) {
        return (n & n2) == n2;
    }

    public static boolean compareTelNumber(String string, String string2) {
        String string3 = PhoneUtils.getComparisonSubString(PhoneUtils.normalizeTelNumber(string));
        String string4 = PhoneUtils.getComparisonSubString(PhoneUtils.normalizeTelNumber(string2));
        if (string3 != null && string3.length() > 0 && string4 != null && string4.length() > 0) {
            return string3.equals(string4);
        }
        return false;
    }

    public static String normalizeTelNumber(String string) {
        return PhoneUtils.convertVanityNumbers(PhoneUtils.removeSeparators(string));
    }

    private static String getComparisonSubString(String string) {
        if (string != null && string.length() > 0) {
            if (string.length() > 7) {
                return string.substring(string.length() - 7, string.length());
            }
            return string;
        }
        return STRING_EMPTY;
    }

    public static String removeSeparators(String string) {
        if (string != null && string.length() > 0) {
            StringBuffer stringBuffer = new StringBuffer(string.length());
            char[] cArray = string.toCharArray();
            block3: for (int i2 = 0; i2 < cArray.length; ++i2) {
                switch (cArray[i2]) {
                    case ' ': 
                    case '(': 
                    case ')': 
                    case '-': 
                    case '.': 
                    case '/': 
                    case '@': {
                        continue block3;
                    }
                    default: {
                        stringBuffer.append(cArray[i2]);
                    }
                }
            }
            return stringBuffer.toString();
        }
        return STRING_EMPTY;
    }

    private static String convertVanityNumbers(String string) {
        if (string != null && string.length() > 0) {
            StringBuffer stringBuffer = new StringBuffer(string.length());
            PhoneUtils.convertCharacters(stringBuffer, string.toCharArray());
            return stringBuffer.toString();
        }
        return STRING_EMPTY;
    }

    private static void convertCharacters(StringBuffer stringBuffer, char[] cArray) {
        int[] nArray = new int[]{2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            char c2 = cArray[i2];
            if (c2 >= 'A' && c2 <= 'Z') {
                stringBuffer.append(nArray[c2 - 65]);
                continue;
            }
            stringBuffer.append(c2);
        }
    }

    private static String formatTime(long l) {
        long l2;
        Buffer buffer = new Buffer(10);
        long l3 = l / 3600L;
        if (l3 > 0L) {
            buffer.append(l3);
            buffer.append(':');
        }
        if ((l2 = l % 3600L / 60L) < 10L && l3 > 0L) {
            buffer.append('0');
        }
        buffer.append(l2);
        buffer.append(':');
        long l4 = l % 60L;
        if (l4 < 10L) {
            buffer.append('0');
        }
        buffer.append(l4);
        return buffer.toString();
    }

    public static String getDisplayCallDuration(int n, long l) {
        if (n == 4 || n == 6) {
            return PhoneUtils.formatTime(l);
        }
        return STRING_EMPTY;
    }

    public static void triggerJumpToPhone(IHMIServiceApp iHMIServiceApp) {
        ChoiceModelApp choiceModelApp = iHMIServiceApp.getChoiceModel(4135);
        choiceModelApp.setValue(choiceModelApp.getValue() + 1);
    }

    public static int[] cloneIntArray(int[] nArray) {
        if (nArray != null) {
            int n = nArray.length;
            int[] nArray2 = new int[n];
            System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, n);
            return nArray2;
        }
        return new int[0];
    }

    public static SimpleIntObjectMap getFieldNameMap(Class clazz, String string) {
        SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap();
        Field[] fieldArray = clazz.getFields();
        if (fieldArray != null) {
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                if (!fieldArray[i2].getName().startsWith(string)) continue;
                try {
                    simpleIntObjectMap.add(fieldArray[i2].getInt(null), fieldArray[i2].getName());
                    continue;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    illegalArgumentException.printStackTrace();
                    continue;
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        }
        return simpleIntObjectMap;
    }

    public static SimpleIntObjectMap getDSIAttributeFieldNames(Class clazz) {
        return PhoneUtils.getFieldNameMap(clazz, "ATTR_");
    }

    public static SimpleIntObjectMap getDSIRequestFieldNames(Class clazz) {
        return PhoneUtils.getFieldNameMap(clazz, "RT_");
    }

    public static SimpleIntObjectMap getDSIResponseFieldNames(Class clazz) {
        return PhoneUtils.getFieldNameMap(clazz, "RP_");
    }

    public static boolean isOnUnlockedRegistered(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState == null) {
            return false;
        }
        if (iTelDSIMobileEquipmentDeviceState.getActivationState() == null) {
            return false;
        }
        switch (iTelDSIMobileEquipmentDeviceState.getActivationState().getTelActivationState()) {
            case 2: 
            case 5: {
                break;
            }
            default: {
                return false;
            }
        }
        if (iTelDSIMobileEquipmentDeviceState.getLockState() == null) {
            return false;
        }
        switch (iTelDSIMobileEquipmentDeviceState.getLockState().getTelLockState()) {
            case 2: {
                break;
            }
            default: {
                return false;
            }
        }
        switch (iTelDSIMobileEquipmentDeviceState.getNadMode()) {
            case 1: 
            case 3: {
                break;
            }
            default: {
                return false;
            }
        }
        if (iTelDSIMobileEquipmentDeviceState.getRegisterState() == null) {
            return false;
        }
        switch (iTelDSIMobileEquipmentDeviceState.getRegisterState().getTelRegisterState()) {
            case 1: 
            case 2: {
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    public static String getSOSCallTextConstant(IEmergencyTextFactory iEmergencyTextFactory, String string) {
        if (iEmergencyTextFactory != null) {
            for (int i2 = 0; i2 < iEmergencyTextFactory.getEmergencyNumbers().length; ++i2) {
                if (!iEmergencyTextFactory.getEmergencyNumbers()[i2].equals(string)) continue;
                return iEmergencyTextFactory.getText(iEmergencyTextFactory.getEmergencyNumbersIDs()[i2]);
            }
            return iEmergencyTextFactory.getText(0);
        }
        return STRING_EMPTY;
    }
}

