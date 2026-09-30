/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.esolutions.fw.util.commons.Buffer;

public interface LogAppender {
    public void appendTo(Buffer var1);

    public int getEstimatedLength();

    public static class Factory {
        public static LogAppender fromString(final String string) {
            return new LogAppender(){

                public int getEstimatedLength() {
                    return string == null ? 0 : string.length();
                }

                public void appendTo(Buffer buffer) {
                    if (string != null) {
                        buffer.append(string);
                    }
                }
            };
        }

        public static LogAppender fromObject(final Object object, final int n) {
            return new LogAppender(){

                public int getEstimatedLength() {
                    return object == null ? 0 : n;
                }

                public void appendTo(Buffer buffer) {
                    if (object != null) {
                        buffer.append(object);
                    }
                }
            };
        }

        public static LogAppender fromInt(int n) {
            return Factory.fromInt(n, null);
        }

        public static LogAppender fromInt(final int n, final String string) {
            return new LogAppender(){

                public int getEstimatedLength() {
                    return 16 + (string == null ? 0 : string.length());
                }

                public void appendTo(Buffer buffer) {
                    if (string != null && string.length() > 0) {
                        buffer.append(string);
                        buffer.append("=");
                    }
                    buffer.append(n);
                }
            };
        }
    }
}

