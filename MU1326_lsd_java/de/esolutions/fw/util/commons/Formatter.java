/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Buffer;
import java.util.List;

public class Formatter {
    private static final Class BYTE_ARRAY_CLASS = array$B == null ? (array$B = Formatter.class$("[B")) : array$B;
    private static final Class INT_ARRAY_CLASS = array$I == null ? (array$I = Formatter.class$("[I")) : array$I;
    private static final Class SHORT_ARRAY_CLASS = array$S == null ? (array$S = Formatter.class$("[S")) : array$S;
    private static final Class STRING_ARRAY_CLASS = array$Ljava$lang$String == null ? (array$Ljava$lang$String = Formatter.class$("[Ljava.lang.String;")) : array$Ljava$lang$String;
    private static final Class LONG_ARRAY_CLASS = array$J == null ? (array$J = Formatter.class$("[J")) : array$J;
    private static final Class OBJECT_ARRAY_CLASS = array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = Formatter.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object;
    private static final int MAX_ARRAY = 10;
    private static final int MILLIS_IN_SECOND = 1000;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAY = 24;
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    static /* synthetic */ Class array$B;
    static /* synthetic */ Class array$I;
    static /* synthetic */ Class array$S;
    static /* synthetic */ Class array$Ljava$lang$String;
    static /* synthetic */ Class array$J;
    static /* synthetic */ Class array$Ljava$lang$Object;

    private static void formatArray(Buffer buffer, Accessor accessor, char c2, char c3) {
        if (accessor.isNull()) {
            buffer.append("null");
            return;
        }
        if (accessor.getLength() == 0) {
            buffer.append(c2);
            buffer.append(c3);
        } else {
            String string = String.valueOf(c2);
            for (int i2 = 0; i2 < accessor.getLength() && i2 < 10; ++i2) {
                buffer.append(string);
                buffer.append(String.valueOf(accessor.getValueAt(i2)));
                string = ", ";
            }
            if (accessor.getLength() > 10) {
                buffer.append(",...");
                buffer.append(c3);
            } else {
                buffer.append(c3);
            }
        }
    }

    private static void formatByteArray(Buffer buffer, final byte[] byArray) {
        Formatter.formatArray(buffer, new Accessor(){

            public boolean isNull() {
                return byArray == null;
            }

            public int getLength() {
                return byArray.length;
            }

            public String getValueAt(int n) {
                return String.valueOf(byArray[n]);
            }
        }, '[', ']');
    }

    private static void formatShortArray(Buffer buffer, final short[] sArray) {
        Formatter.formatArray(buffer, new Accessor(){

            public boolean isNull() {
                return sArray == null;
            }

            public int getLength() {
                return sArray.length;
            }

            public String getValueAt(int n) {
                return String.valueOf(sArray[n]);
            }
        }, '[', ']');
    }

    protected static void formatIntArray(Buffer buffer, final int[] nArray) {
        Formatter.formatArray(buffer, new Accessor(){

            public boolean isNull() {
                return nArray == null;
            }

            public int getLength() {
                return nArray.length;
            }

            public String getValueAt(int n) {
                return String.valueOf(nArray[n]);
            }
        }, '[', ']');
    }

    private static void formatLongArray(Buffer buffer, final long[] lArray) {
        Formatter.formatArray(buffer, new Accessor(){

            public boolean isNull() {
                return lArray == null;
            }

            public int getLength() {
                return lArray.length;
            }

            public String getValueAt(int n) {
                return String.valueOf(lArray[n]);
            }
        }, '[', ']');
    }

    private static void formatStringArray(Buffer buffer, final String[] stringArray) {
        Formatter.formatArray(buffer, new Accessor(){

            public boolean isNull() {
                return stringArray == null;
            }

            public int getLength() {
                return stringArray.length;
            }

            public String getValueAt(int n) {
                return new StringBuffer().append("\"").append(stringArray[n]).append("\"").toString();
            }
        }, '[', ']');
    }

    private static void formatObjectArray(Buffer buffer, final Object[] objectArray) {
        Formatter.formatArray(buffer, new Accessor(){

            public boolean isNull() {
                return objectArray == null;
            }

            public int getLength() {
                return objectArray.length;
            }

            public String getValueAt(int n) {
                Object object = objectArray[n];
                return object instanceof String ? new StringBuffer().append("\"").append(object).append("\"").toString() : object.toString();
            }
        }, '[', ']');
    }

    private static void formatList(Buffer buffer, final List list) {
        Formatter.formatArray(buffer, new Accessor(){

            public boolean isNull() {
                return list == null;
            }

            public int getLength() {
                return list.size();
            }

            public String getValueAt(int n) {
                Object object = list.get(n);
                return object == null ? "null" : (object instanceof String ? new StringBuffer().append("\"").append(object).append("\"").toString() : object.toString());
            }
        }, '(', ')');
    }

    public static void formatObject(Buffer buffer, Object object) {
        if (object != null) {
            if (object.getClass() == INT_ARRAY_CLASS) {
                Formatter.formatIntArray(buffer, (int[])object);
            } else if (object.getClass() == BYTE_ARRAY_CLASS) {
                Formatter.formatByteArray(buffer, (byte[])object);
            } else if (object.getClass() == STRING_ARRAY_CLASS) {
                Formatter.formatStringArray(buffer, (String[])object);
            } else if (object.getClass() == LONG_ARRAY_CLASS) {
                Formatter.formatLongArray(buffer, (long[])object);
            } else if (object.getClass() == SHORT_ARRAY_CLASS) {
                Formatter.formatShortArray(buffer, (short[])object);
            } else if (object.getClass() == OBJECT_ARRAY_CLASS) {
                Formatter.formatObjectArray(buffer, (Object[])object);
            } else if (object instanceof List) {
                Formatter.formatList(buffer, (List)object);
            } else {
                buffer.append(object.toString());
            }
        } else {
            buffer.append("null");
        }
    }

    public static void formatTimestamp(Buffer buffer, long l) {
        long l2 = l;
        int n = (int)(l2 % 1000L);
        int n2 = (int)((l2 /= 1000L) % 60L);
        int n3 = (int)((l2 /= 60L) % 60L);
        int n4 = (int)((l2 /= 60L) % 24L);
        if (n4 < 10) {
            buffer.append('0');
        }
        buffer.append(Integer.toString(n4));
        buffer.append(':');
        if (n3 < 10) {
            buffer.append('0');
        }
        buffer.append(Integer.toString(n3));
        buffer.append(':');
        if (n2 < 10) {
            buffer.append('0');
        }
        buffer.append(Integer.toString(n2));
        buffer.append('.');
        if (n < 100) {
            buffer.append('0');
            if (n < 10) {
                buffer.append('0');
            }
        }
        buffer.append(Integer.toString(n));
    }

    public static void standardTargetSysout(String string) {
        if (string.length() > 127) {
            String string2 = string.substring(0, 127);
            int n = string2.indexOf(LINE_SEPARATOR);
            if (n == -1) {
                System.out.println(string2);
                Formatter.standardTargetSysout(string.substring(127, string.length()));
            } else {
                System.out.println(string.substring(0, n));
                Formatter.standardTargetSysout(string.substring(n + LINE_SEPARATOR.length(), string.length()));
            }
        } else {
            System.out.println(string);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private static interface Accessor {
        public boolean isNull();

        public int getLength();

        public String getValueAt(int var1);
    }
}

