/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.msg;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import org.apache.xerces.util.MessageFormatter;

public class XMLMessageFormatter
implements MessageFormatter {
    public static final String XML_DOMAIN;
    public static final String XMLNS_DOMAIN;
    private Locale fLocale = null;
    private ResourceBundle fResourceBundle = null;

    @Override
    public String formatMessage(Locale locale, String string, Object[] objectArray) {
        String string2;
        if (this.fResourceBundle == null || locale != this.fLocale) {
            if (locale != null) {
                this.fResourceBundle = PropertyResourceBundle.getBundle("org.apache.xerces.impl.msg.XMLMessages", locale);
                this.fLocale = locale;
            }
            if (this.fResourceBundle == null) {
                this.fResourceBundle = PropertyResourceBundle.getBundle("org.apache.xerces.impl.msg.XMLMessages");
            }
        }
        try {
            string2 = this.fResourceBundle.getString(string);
            if (objectArray != null) {
                try {
                    string2 = MessageFormat.format(string2, objectArray);
                }
                catch (Exception exception) {
                    string2 = this.fResourceBundle.getString("FormatFailed");
                    string2 = new StringBuffer().append(string2).append(" ").append(this.fResourceBundle.getString(string)).toString();
                }
            }
        }
        catch (MissingResourceException missingResourceException) {
            String string3 = this.fResourceBundle.getString("BadMessageKey");
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

