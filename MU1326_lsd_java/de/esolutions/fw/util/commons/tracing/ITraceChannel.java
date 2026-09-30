/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.tracing;

public interface ITraceChannel {
    public static final short TRACE = 0;
    public static final short DEBUG = 1;
    public static final short INFO = 2;
    public static final short WARN = 3;
    public static final short ERROR = 4;
    public static final short FATAL = 5;
    public static final short OFF = 6;
    public static final short NONE = 7;
    public static final short DISABLED = 8;
    public static final short _LAST = 9;
    public static final String[] levelNames = new String[]{"trace", "debug", "info", "warn", "ERROR", "FATAL", "OFF", "NONE", "Disabled"};

    public boolean log(short var1, short var2, short var3, byte[] var4);

    public boolean log(short var1, short var2, byte[] var3);

    public boolean log(short var1, String var2);

    public boolean log(short var1, String var2, Object var3);

    public boolean log(short var1, String var2, Object var3, Object var4);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object var12);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object var12, Object var13);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object var12, Object var13, Object var14);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object var12, Object var13, Object var14, Object var15);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object var12, Object var13, Object var14, Object var15, Object var16);

    public boolean log(short var1, String var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object var12, Object var13, Object var14, Object var15, Object var16, Object var17);

    public boolean log(short var1, String var2, Object[] var3);

    public boolean log(short var1, short var2, String var3);

    public boolean log(short var1, short var2, String var3, Object var4);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5, Object var6);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5, Object var6, Object var7);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5, Object var6, Object var7, Object var8);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object var12);

    public boolean log(short var1, short var2, String var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object var12, Object var13);

    public boolean log(short var1, short var2, String var3, Object[] var4);
}

