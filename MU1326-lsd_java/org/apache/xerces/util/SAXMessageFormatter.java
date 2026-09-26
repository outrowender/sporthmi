/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SAXMessageFormatter {
    public static String formatMessage(Locale locale, String string, Object[] objectArray) {
        String string2;
        ResourceBundle resourceBundle = null;
        resourceBundle = locale != null ? PropertyResourceBundle.getBundle("org.apache.xerces.impl.msg.SAXMessages", locale) : PropertyResourceBundle.getBundle("org.apache.xerces.impl.msg.SAXMessages");
        try {
            string2 = resourceBundle.getString(string);
            if (objectArray != null) {
                try {
                    string2 = MessageFormat.format(string2, objectArray);
                }
                catch (Exception exception) {
                    string2 = resourceBundle.getString("FormatFailed");
                    string2 = new StringBuffer().append(string2).append(" ").append(resourceBundle.getString(string)).toString();
                }
            }
        }
        catch (MissingResourceException missingResourceException) {
            String string3 = resourceBundle.getString("BadMessageKey");
            throw new MissingResourceException(string, string3, string);
        }
        if (string2 == null) {
            string2 = string;
            if (objectArray.length > 0) {
                StringBuffer stringBuffer = new StringBuffer(string2);
                stringBuffer.append('?');
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    if (i2 > 0) {
                        stringBuffer.append('&');
                    }
                    stringBuffer.append(String.valueOf(objectArray[i2]));
                }
            }
        }
        return string2;
    }
}

