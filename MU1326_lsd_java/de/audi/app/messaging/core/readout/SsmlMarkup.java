/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.Markup;
import de.esolutions.fw.util.commons.Buffer;

public final class SsmlMarkup {
    private static final String TAG_NAME_SAY_AS = "say-as";
    private static final String ATTR_NAME_INTERPRET_AS = "interpret-as";
    private static final String ATTR_VALUE_INTERPRET_AS_NAME = "name";
    private static final String ATTR_VALUE_INTERPRET_AS_PHONE_NUMBER = "telephone";
    private static final String ATTR_VALUE_INTERPRET_AS_DATE = "date";
    private static final String ATTR_VALUE_INTERPRET_AS_TIME = "time";
    private static final String ATTR_VALUE_INTERPRET_AS_SMS = "sms";
    private static final int DEFAULT_BUFFER_SIZE = 1024;

    public static String toTtsReadableText(String string) {
        return Markup.escapeXml(string);
    }

    public static String asName(String string) {
        return SsmlMarkup.sayAs(ATTR_VALUE_INTERPRET_AS_NAME, string);
    }

    public static String asPhoneNumber(String string) {
        return SsmlMarkup.sayAs(ATTR_VALUE_INTERPRET_AS_PHONE_NUMBER, string);
    }

    public static String asDate(String string) {
        return SsmlMarkup.sayAs(ATTR_VALUE_INTERPRET_AS_DATE, string);
    }

    public static String asTime(String string) {
        return SsmlMarkup.sayAs(ATTR_VALUE_INTERPRET_AS_TIME, string);
    }

    public static String asSmsBody(String string) {
        return SsmlMarkup.sayAs(ATTR_VALUE_INTERPRET_AS_SMS, string);
    }

    private static String sayAs(String string, String string2) {
        Buffer buffer = new Buffer(1024);
        Markup.Attribute attribute = new Markup.Attribute(ATTR_NAME_INTERPRET_AS, string);
        Markup.Attribute[] attributeArray = new Markup.Attribute[]{attribute};
        Markup.openTag(buffer, TAG_NAME_SAY_AS, attributeArray);
        Markup.appendText(buffer, string2);
        Markup.closeTag(buffer, TAG_NAME_SAY_AS);
        return buffer.toString();
    }
}

