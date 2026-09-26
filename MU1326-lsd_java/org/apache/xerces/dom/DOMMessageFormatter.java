/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DOMMessageFormatter {
    public static final String DOM_DOMAIN;
    public static final String XML_DOMAIN;
    private static ResourceBundle domResourceBundle;
    private static ResourceBundle xmlResourceBundle;
    private static Locale locale;

    DOMMessageFormatter() {
        locale = Locale.getDefault();
    }

    public static String formatMessage(String string, String string2, Object[] objectArray) {
        String string3;
        ResourceBundle resourceBundle = DOMMessageFormatter.getResourceBundle(string);
        if (resourceBundle == null) {
            DOMMessageFormatter.init();
            resourceBundle = DOMMessageFormatter.getResourceBundle(string);
            if (resourceBundle == null) {
                throw new MissingResourceException(new StringBuffer().append("Unknown domain").append(string).toString(), null, string2);
            }
        }
        try {
            string3 = new StringBuffer().append(string2).append(": ").append(resourceBundle.getString(string2)).toString();
            if (objectArray != null) {
                try {
                    string3 = MessageFormat.format(string3, objectArray);
                }
                catch (Exception exception) {
                    string3 = resourceBundle.getString("FormatFailed");
                    string3 = new StringBuffer().append(string3).append(" ").append(resourceBundle.getString(string2)).toString();
                }
            }
        }
        catch (MissingResourceException missingResourceException) {
            String string4 = resourceBundle.getString("BadMessageKey");
            throw new MissingResourceException(string2, string4, string2);
        }
        if (string3 == null) {
            string3 = string2;
            if (objectArray.length > 0) {
                StringBuffer stringBuffer = new StringBuffer(string3);
                stringBuffer.append('?');
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    if (i2 > 0) {
                        stringBuffer.append('&');
                    }
                    stringBuffer.append(String.valueOf(objectArray[i2]));
                }
            }
        }
        return string3;
    }

    static ResourceBundle getResourceBundle(String string) {
        if (string == "http://www.w3.org/dom/DOMTR" || string.equals("http://www.w3.org/dom/DOMTR")) {
            return domResourceBundle;
        }
        if (string == "http://www.w3.org/TR/1998/REC-xml-19980210" || string.equals("http://www.w3.org/TR/1998/REC-xml-19980210")) {
            return xmlResourceBundle;
        }
        return null;
    }

    public static void init() {
        if (locale != null) {
            domResourceBundle = PropertyResourceBundle.getBundle("org.apache.xerces.impl.msg.DOMMessages", locale);
            xmlResourceBundle = PropertyResourceBundle.getBundle("org.apache.xerces.impl.msg.XMLMessages", locale);
        } else {
            domResourceBundle = PropertyResourceBundle.getBundle("org.apache.xerces.impl.msg.DOMMessages");
            xmlResourceBundle = PropertyResourceBundle.getBundle("org.apache.xerces.impl.msg.XMLMessages");
        }
    }

    public static void setLocale(Locale locale) {
        DOMMessageFormatter.locale = locale;
    }

    static {
        domResourceBundle = null;
        xmlResourceBundle = null;
        locale = null;
    }
}

