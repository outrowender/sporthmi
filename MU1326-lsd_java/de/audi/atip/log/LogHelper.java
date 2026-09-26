/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.esolutions.fw.util.commons.Buffer;

public class LogHelper {
    public static String getInvoker(int n) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[n];
        String string = stackTraceElement.getClassName();
        Buffer buffer = new Buffer();
        buffer.append('[').append(string.substring(string.lastIndexOf(46) + 1, string.length()));
        buffer.append('#').append(stackTraceElement.getMethodName()).append(']').append(' ');
        return buffer.toString();
    }
}

