/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory$1;
import de.audi.remotehmi.util.LogAppender$Factory$2;
import de.audi.remotehmi.util.LogAppender$Factory$3;

public class LogAppender$Factory {
    public static LogAppender fromString(String string) {
        return new LogAppender$Factory$1(string);
    }

    public static LogAppender fromObject(Object object, int n) {
        return new LogAppender$Factory$2(object, n);
    }

    public static LogAppender fromInt(int n) {
        return LogAppender$Factory.fromInt(n, null);
    }

    public static LogAppender fromInt(int n, String string) {
        return new LogAppender$Factory$3(string, n);
    }
}

