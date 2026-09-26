/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ShutdownGuard;
import de.audi.atip.log.LogSink;
import de.audi.atip.timer.WatchDog;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;

public interface IErrorManager {
    public static final int ERROR_AFFECTED_NOTHING;
    public static final int ERROR_AFFECTED_FUNCTION;
    public static final int ERROR_AFFECTED_COMPONENT;
    public static final int ERROR_AFFECTED_SYSTEM;
    public static final int ERROR_PESISTENCE_RETRY;
    public static final int ERROR_PESISTENCE_RESTART;
    public static final int ERROR_PESISTENCE_RESET;
    public static final int ERROR_PESISTENCE_EVER;
    public static final int ERROR_PESISTENCE_MANUAL;

    default public String[] getTargetIntegrityInfo() {
    }

    default public void registerDumpInfoProvider(DumpInfoProvider dumpInfoProvider) {
    }

    default public void unregisterDumpInfoProvider(DumpInfoProvider dumpInfoProvider) {
    }

    default public String getDumpDir() {
    }

    default public LogSink getFlightRecorder() {
    }

    default public void handleError(Throwable throwable, String string, int n, int n2, int n3) {
    }

    default public void handleError(Throwable throwable, String string, int n, int n2, int n3, ShutdownGuard shutdownGuard) {
    }

    default public WatchDog createWatchDog(long l, Runnable runnable, String string, int n, int n2, int n3) {
    }

    default public WatchDog createWatchDog(long l, Runnable runnable, String string, int n, int n2, int n3, boolean bl) {
    }
}

