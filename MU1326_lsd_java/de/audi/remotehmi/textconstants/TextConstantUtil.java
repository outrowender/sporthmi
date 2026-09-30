/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.textconstants;

import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.esolutions.fw.util.commons.Buffer;

public class TextConstantUtil {
    public static String I18NCONSTANT = "{i18n:";
    public static String MEDIACONSTANT = "{media:";
    public static String TEXT_CONST_INFINITE = "TEXT_CONST_RHMI_INFINITE_LIST_WAIT";
    public static String TEXT_CONST_PREVIEW_ERROR = "TEXT_CONST_RHMI_PREVIEW_ERROR";
    public static String REMOTEHMI_TEXT_LOGIN = "TEXT_CONST_RHMI_TOP_WIZARD_RIGHT_DRAWER_LOGIN";
    public static String REMOTEHMI_TEXT_LOGOFF = "TEXT_CONST_RHMI_TOP_WIZARD_RIGHT_DRAWER_LOGOUT";

    public static String replaceConstants(String string, String string2, ITextConstantsConverter iTextConstantsConverter) {
        int n;
        if (string == null || string.length() == 0 || string.indexOf(string2) == -1) {
            return string;
        }
        String string3 = "}";
        if (string2.startsWith("$(")) {
            string3 = ")";
        }
        Buffer buffer = new Buffer(string.length());
        int n2 = 0;
        int n3 = string.length();
        while (n2 < n3 && (n = string.indexOf(string2, n2)) != -1) {
            buffer.append(string.substring(n2, n));
            n2 = n + string2.length();
            int n4 = string.indexOf(string3, n2);
            if (n4 == -1) {
                n2 = n3;
                break;
            }
            String string4 = string.substring(n2, n4);
            String string5 = iTextConstantsConverter.getText(string4);
            if (string5 == null) {
                string5 = "";
            }
            buffer.append(string5);
            n2 = n4 + 1;
        }
        buffer.append(string.substring(n2));
        return buffer.toString();
    }

    public static String replaceI18NConstants(String string, ITextConstantsConverter iTextConstantsConverter) {
        return TextConstantUtil.replaceConstants(string, I18NCONSTANT, iTextConstantsConverter);
    }

    public static String replaceSingleI18NConstant(String string, ITextConstantsConverter iTextConstantsConverter) {
        return TextConstantUtil.replaceConstants(I18NCONSTANT + string + "}", I18NCONSTANT, iTextConstantsConverter);
    }

    public static boolean containsTextConstant(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        int n = string.indexOf("{");
        if (n == -1) {
            return false;
        }
        int n2 = string.indexOf(":", n + 1);
        if (n2 == -1) {
            return false;
        }
        String string2 = string.substring(n, n2);
        return string2.length() != 0 && string2.indexOf(" ") == -1;
    }
}

