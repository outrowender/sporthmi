/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.Markup;
import de.audi.app.messaging.core.readout.Markup$Attribute;
import de.esolutions.fw.util.commons.Buffer;

public final class SsmlMarkup {
    private static final String TAG_NAME_SAY_AS;
    private static final String ATTR_NAME_INTERPRET_AS;
    private static final String ATTR_VALUE_INTERPRET_AS_NAME;
    private static final String ATTR_VALUE_INTERPRET_AS_PHONE_NUMBER;
    private static final String ATTR_VALUE_INTERPRET_AS_DATE;
    private static final String ATTR_VALUE_INTERPRET_AS_TIME;
    private static final String ATTR_VALUE_INTERPRET_AS_SMS;
    private static final int DEFAULT_BUFFER_SIZE;

    public static String toTtsReadableText(String string) {
        return Markup.escapeXml(string);
    }

    public static String asName(String string) {
        return SsmlMarkup.sayAs("name", string);
    }

    public static String asPhoneNumber(String string) {
        return SsmlMarkup.sayAs("telephone", string);
    }

    public static String asDate(String string) {
        return SsmlMarkup.sayAs("date", string);
    }

    public static String asTime(String string) {
        return SsmlMarkup.sayAs("time", string);
    }

    public static String asSmsBody(String string) {
        return SsmlMarkup.sayAs("sms", string);
    }

    private static String sayAs(String string, String string2) {
        Buffer buffer = new Buffer(1024);
        Markup$Attribute markup$Attribute = new Markup$Attribute("interpret-as", string);
        Markup$Attribute[] markup$AttributeArray = new Markup$Attribute[]{markup$Attribute};
        Markup.openTag(buffer, "say-as", markup$AttributeArray);
        Markup.appendText(buffer, string2);
        Markup.closeTag(buffer, "say-as");
        return buffer.toString();
    }
}

