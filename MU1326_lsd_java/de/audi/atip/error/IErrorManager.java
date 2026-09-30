/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ShutdownGuard;
import de.audi.atip.log.LogSink;
import de.audi.atip.timer.WatchDog;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;

public interface IErrorManager {
    public static final int ERROR_AFFECTED_NOTHING = 0;
    public static final int ERROR_AFFECTED_FUNCTION = 1;
    public static final int ERROR_AFFECTED_COMPONENT = 2;
    public static final int ERROR_AFFECTED_SYSTEM = 3;
    public static final int ERROR_PESISTENCE_RETRY = 0;
    public static final int ERROR_PESISTENCE_RESTART = 1;
    public static final int ERROR_PESISTENCE_RESET = 2;
    public static final int ERROR_PESISTENCE_EVER = 3;
    public static final int ERROR_PESISTENCE_MANUAL = 4;

    public String[] getTargetIntegrityInfo();

    public void registerDumpInfoProvider(DumpInfoProvider var1);

    public void unregisterDumpInfoProvider(DumpInfoProvider var1);

    public String getDumpDir();

    public LogSink getFlightRecorder();

    public void handleError(Throwable var1, String var2, int var3, int var4, int var5);

    public void handleError(Throwable var1, String var2, int var3, int var4, int var5, ShutdownGuard var6);

    public WatchDog createWatchDog(long var1, Runnable var3, String var4, int var5, int var6, int var7);

    public WatchDog createWatchDog(long var1, Runnable var3, String var4, int var5, int var6, int var7, boolean var8);
}

