/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.error.BundleInfoProvider;
import de.audi.atip.error.ErrorManager$1;
import de.audi.atip.error.ErrorManager$2;
import de.audi.atip.error.ErrorManager$BlackBoxProvider;
import de.audi.atip.error.ErrorManager$CmdInfoProvider;
import de.audi.atip.error.ErrorManager$EnvInfoProvider;
import de.audi.atip.error.ErrorManager$J9ThreadInfoProvider;
import de.audi.atip.error.ErrorManager$SystemInfoProvider;
import de.audi.atip.error.ErrorManager$ThreadInfoProvider;
import de.audi.atip.error.ErrorManager$VersionInfoProvider;
import de.audi.atip.error.ErrorManager$WatchDogAlarm;
import de.audi.atip.error.IErrorManager;
import de.audi.atip.error.Incident;
import de.audi.atip.error.IntegrityChecker;
import de.audi.atip.error.ShutdownGuard;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogSink;
import de.audi.atip.log.SPISink;
import de.audi.atip.timer.WatchDog;
import de.audi.tghu.log.BlackBox;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

public class ErrorManager
implements IErrorManager {
    private static final String DUMP_DIR_QNX;
    private final IFrameworkAccess framework;
    private BlackBox flightRecorder;
    private SPISink spiSink = null;
    private final List sources = new ArrayList(32);
    private List commands = new ArrayList(16);
    private int recursionCount = 0;
    private volatile int sessionID = -1;
    private volatile int sessionDumpCount = 0;
    private final String dumpdir;
    private final int maxErrlogDumps;
    private boolean discardWhenLimitExceeded = true;
    private boolean replaceOldErrlogs = false;
    private DumpInfoProvider active = null;
    static /* synthetic */ Class class$com$microdoc$j9$Tools;

    public ErrorManager(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.maxErrlogDumps = Integer.getInteger("ERROR_DUMP_MAX", 20);
        String string = System.getProperty("ERROR_DUMP_MAX_EXCEEDED");
        this.dumpdir = System.getProperty("ErrorDumpDir", iFrameworkAccess.isTarget() ? "/eso/hmi/errlog/" : new StringBuffer().append(System.getProperty("java.io.tmpdir")).append("errlog\\").toString());
        this.getLog().log(1078071040, "Write error dumps to %1", (Object)this.dumpdir);
        this.getLog().log(1078071040, "Write no more than %1 error dumps", (long)this.maxErrlogDumps);
        if (string != null) {
            if ("stdout".equals(string)) {
                this.discardWhenLimitExceeded = false;
            }
            if ("replace".equals(string)) {
                this.replaceOldErrlogs = true;
            }
        }
        if (this.discardWhenLimitExceeded) {
            this.getLog().log(1078071040, "Discard additional error dumps");
        } else {
            this.getLog().log(1078071040, "Write additional error dumps to System.out");
        }
        if (this.replaceOldErrlogs) {
            this.getLog().log(1078071040, "New error dumps replace older ones");
        } else {
            this.getLog().log(1078071040, "Oldest error dumps are kept");
        }
        if (iFrameworkAccess.isTarget()) {
            this.registerCommand(new ErrorManager$J9ThreadInfoProvider(this, null));
        } else {
            this.registerDumpInfoProvider(new ErrorManager$ThreadInfoProvider(null));
        }
        this.registerDumpInfoProvider(new ErrorManager$SystemInfoProvider(null));
        this.registerDumpInfoProvider(new ErrorManager$VersionInfoProvider(this, null));
        this.registerDumpInfoProvider(new ErrorManager$EnvInfoProvider(null));
        this.registerDumpInfoProvider(new ErrorManager$BlackBoxProvider(this));
        this.registerDumpInfoProvider(new BundleInfoProvider(iFrameworkAccess));
        if (iFrameworkAccess.isTarget()) {
            this.registerCommand(new ErrorManager$CmdInfoProvider("Sloginfo", "sloginfo", new String[]{"-t"}, null));
            this.registerCommand(new ErrorManager$CmdInfoProvider("Pidin", "pidin", new String[]{"arg"}, null));
            this.registerCommand(new ErrorManager$CmdInfoProvider("3D_out.txt", "cat", new String[]{"/tmp/out.txt"}, null));
        }
    }

    @Override
    public String[] getTargetIntegrityInfo() {
        return new IntegrityChecker(this.framework).getTargetIntegrityInfo();
    }

    private LogChannel getLog() {
        return this.framework.getLogChannel("Fw.Error");
    }

    @Override
    public final String getDumpDir() {
        return this.dumpdir;
    }

    @Override
    public final LogSink getFlightRecorder() {
        return this.flightRecorder;
    }

    private int getSessionId() {
        if (this.sessionID != -1) {
            return this.sessionID;
        }
        int n = 1078071040;
        String[] stringArray = new File(this.dumpdir).list();
        if (stringArray == null) {
            this.sessionID = n;
            return this.sessionID;
        }
        ArrayList arrayList = new ArrayList(stringArray.length);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (!this.isErrorDump(stringArray[i2])) continue;
            arrayList.add(stringArray[i2]);
        }
        Collections.sort(arrayList);
        if (!arrayList.isEmpty()) {
            try {
                String string = (String)arrayList.get(arrayList.size() - 1);
                this.sessionID = 1 + Integer.parseInt(string.substring(6, 13));
            }
            catch (Exception exception) {
                this.getLog().log(10000, "Exception:", (Throwable)exception);
                this.sessionID = n;
            }
        } else {
            this.sessionID = n;
        }
        return this.sessionID;
    }

    @Override
    public final synchronized void registerDumpInfoProvider(DumpInfoProvider dumpInfoProvider) {
        this.sources.add(dumpInfoProvider);
    }

    @Override
    public synchronized void unregisterDumpInfoProvider(DumpInfoProvider dumpInfoProvider) {
        this.sources.remove(dumpInfoProvider);
    }

    public synchronized void setSPISink(SPISink sPISink) {
        this.spiSink = sPISink;
    }

    private synchronized void registerCommand(DumpInfoProvider dumpInfoProvider) {
        this.getLog().log(1078071040, "registering command: %1", (Object)dumpInfoProvider.getName());
        this.commands.add(dumpInfoProvider);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpProvider(DumpInfoProvider dumpInfoProvider, String string, ZipOutputStream zipOutputStream, PrintStream printStream) {
        long l = this.framework.getMonotonicTime();
        this.active = dumpInfoProvider;
        boolean bl = false;
        try {
            this.getLog().log(1078071040, "writing error info: %1", (Object)dumpInfoProvider.getName());
            zipOutputStream.putNextEntry(new ZipEntry(new StringBuffer().append(dumpInfoProvider.getName()).append(".txt").toString()));
            bl = true;
            dumpInfoProvider.dump(printStream, string);
        }
        catch (ZipException zipException) {
            try {
                Thread.sleep(0);
                String string2 = new StringBuffer().append(dumpInfoProvider.getName()).append(new Random(System.currentTimeMillis()).nextInt()).toString();
                this.getLog().log(1078071040, "writing error info to random file: %1", (Object)string2);
                zipOutputStream.putNextEntry(new ZipEntry(new StringBuffer().append(string2).append(".txt").toString()));
                bl = true;
                dumpInfoProvider.dump(printStream, string);
            }
            catch (Exception exception) {
                this.getLog().log(10000, "problem during dump: ", (Throwable)exception);
            }
        }
        catch (Exception exception) {
            this.getLog().log(10000, "problem during dump: ", (Throwable)exception);
        }
        finally {
            long l2;
            this.active = null;
            printStream.flush();
            if (bl) {
                zipOutputStream.closeEntry();
            }
            if ((l2 = this.framework.getMonotonicTime() - l) > 0) {
                this.getLog().log(10000, "writing error info: %1 took too long: %2ms!", (Object)dumpInfoProvider.getName(), l2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpToFile(String string, boolean bl) {
        if (new File(string).exists()) {
            this.getLog().log(10000, "WTF!? The file %1 already exist! Rename it", (Object)string);
            string = string.concat("_WTF.zip");
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (this.spiSink != null) {
                this.spiSink.saveErrorDumpName(string);
            }
            fileOutputStream = new FileOutputStream(string, false);
            this.dumpToStream(fileOutputStream, string, bl);
        }
        finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                }
                catch (IOException iOException) {
                    this.getLog().log(10000, "problem during file.close()", (Throwable)iOException);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpToStream(OutputStream outputStream, String string, boolean bl) {
        BufferedOutputStream bufferedOutputStream = null;
        ZipOutputStream zipOutputStream = null;
        PrintStream printStream = null;
        try {
            Object object;
            int n;
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            zipOutputStream = new ZipOutputStream(bufferedOutputStream);
            printStream = new PrintStream(zipOutputStream);
            System.out.println(new StringBuffer().append("dumping error log: ").append(string).toString());
            this.getLog().log(10000, "dumping error log: %1", (Object)string);
            for (n = 0; n < this.sources.size(); ++n) {
                object = this.sources.get(n);
                if (!(object instanceof DumpInfoProvider)) continue;
                this.dumpProvider((DumpInfoProvider)object, string, zipOutputStream, printStream);
            }
            if (bl) {
                for (n = 0; n < this.commands.size(); ++n) {
                    object = this.commands.get(n);
                    if (!(object instanceof DumpInfoProvider)) continue;
                    this.dumpProvider((DumpInfoProvider)object, string, zipOutputStream, printStream);
                }
            }
        }
        finally {
            if (printStream != null) {
                printStream.close();
            }
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                }
                catch (IOException iOException) {
                    this.getLog().log(14808325, "problem during zip.close()", (Throwable)iOException);
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
                catch (IOException iOException) {
                    this.getLog().log(14808325, "problem during zip.close()", (Throwable)iOException);
                }
            }
        }
    }

    private void dumpSystemOut() {
        this.getLog().log(10000, "dumping error log to System.out");
        for (int i2 = 0; i2 < this.sources.size(); ++i2) {
            try {
                DumpInfoProvider dumpInfoProvider = (DumpInfoProvider)this.sources.get(i2);
                this.getLog().log(10000, "writing error info: %1", (Object)dumpInfoProvider.getName());
                dumpInfoProvider.dump(System.out, "System.out");
                continue;
            }
            catch (Exception exception) {
                this.getLog().log(10000, "problem during dump:", (Throwable)exception);
            }
        }
    }

    private String getSessionDumpCount() {
        return Integer.toString((++this.sessionDumpCount + 1000) % 10000).substring(1, 4);
    }

    private boolean isErrorDump(String string) {
        return string.startsWith("error_") && string.endsWith(".zip");
    }

    private void ensureMaxErrDumpCapacity() {
        new File(this.dumpdir).mkdirs();
        Object[] objectArray = new File(this.dumpdir).list(new ErrorManager$1(this));
        if (objectArray == null) {
            return;
        }
        Arrays.sort(objectArray);
        if (objectArray.length >= this.maxErrlogDumps) {
            this.getLog().log(10000, "Discarding error dump %1, too many error dumps are already present in %2", objectArray[0], (Object)this.dumpdir);
            new File(new StringBuffer().append(this.dumpdir).append("/").append((String)objectArray[0]).toString()).delete();
        }
    }

    private void dumpSync(Incident incident) {
        try {
            this.ensureMaxErrDumpCapacity();
            this.dumpToFile(new StringBuffer().append(this.dumpdir).append("error_").append(this.getSessionId()).append('-').append(this.getSessionDumpCount()).append(".zip").toString(), incident.needsReset() || incident.needsShutdown() || incident.isTriggeredManually());
        }
        catch (Exception exception) {
            this.getLog().log(10000, "IOException during error dump!", (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpAsync(Incident incident) {
        ArrayList arrayList = new ArrayList(2);
        Object object = arrayList;
        synchronized (object) {
            new Thread(new ErrorManager$2(this, incident, arrayList), "DumpAsync").start();
            try {
                super.wait(0);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
        }
        if (arrayList.isEmpty()) {
            object = this.active;
            this.getLog().log(10000, "Error handler: Writing ErrorDump failed, %1 did not finish!", (Object)(object != null ? object.getName() : "???"));
        }
    }

    private void handleError(Incident incident) {
        if (incident.ex != null) {
            this.getLog().log(10000, "Error handler called!", incident.ex);
        } else {
            this.getLog().log(10000, "Error handler called!");
        }
        this.getLog().log(10000, "Error handler: reason: %1", (Object)incident.reason);
        this.getLog().log(10000, "Error handler: component: %1", (long)incident.component);
        this.getLog().log(10000, "Error handler: affects: %1", (long)incident.affected);
        this.getLog().log(10000, "Error handler: persistence: %1", (long)incident.persistence);
        if (this.framework.isTarget() && (incident.needsReset() || incident.needsShutdown())) {
            this.dumpAsync(incident);
            this.getLog().log(1000, "Unrecoverable HMI Error, reset system! Reason: %1", (Object)incident.reason);
            System.out.println("Unrecoverable HMI Error, trigger a system reset!");
            System.out.println(new StringBuffer().append("Reason: ").append(incident.reason).toString());
            this.framework.getPowerMgr().rebootSystemCritical(true);
        } else {
            this.dumpAsync(incident);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void handleError(Throwable throwable, String string, int n, int n2, int n3, ShutdownGuard shutdownGuard) {
        if (this.recursionCount > 0) {
            this.getLog().log(1000, "Recursive Error Handler call! Recursion count: %1", (long)this.recursionCount);
        }
        if (this.recursionCount > 2) {
            this.getLog().log(1000, "Recursive Error Handler call! Max Recursion depth reached!");
            return;
        }
        try {
            ++this.recursionCount;
            this.handleError(new Incident(this.framework.getMonotonicTime(), throwable, string, n, n2, n3, shutdownGuard));
        }
        finally {
            --this.recursionCount;
        }
    }

    @Override
    public void handleError(Throwable throwable, String string, int n, int n2, int n3) {
        this.handleError(throwable, string, n, n2, n3, null);
    }

    @Override
    public WatchDog createWatchDog(long l, Runnable runnable, String string, int n, int n2, int n3) {
        return new WatchDog(string, l, this.getLog(), new ErrorManager$WatchDogAlarm(this, runnable, new Incident(this.framework.getMonotonicTime(), null, string, n, n2, n3, null), null));
    }

    @Override
    public WatchDog createWatchDog(long l, Runnable runnable, String string, int n, int n2, int n3, boolean bl) {
        return new WatchDog(string, l, this.getLog(), new ErrorManager$WatchDogAlarm(this, runnable, bl ? new Incident(this.framework.getMonotonicTime(), null, string, n, n2, n3, null) : null, null));
    }

    static /* synthetic */ IFrameworkAccess access$600(ErrorManager errorManager) {
        return errorManager.framework;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$700(ErrorManager errorManager) {
        return errorManager.getLog();
    }

    static /* synthetic */ BlackBox access$802(ErrorManager errorManager, BlackBox blackBox) {
        errorManager.flightRecorder = blackBox;
        return errorManager.flightRecorder;
    }

    static /* synthetic */ BlackBox access$800(ErrorManager errorManager) {
        return errorManager.flightRecorder;
    }

    static /* synthetic */ boolean access$900(ErrorManager errorManager, String string) {
        return errorManager.isErrorDump(string);
    }

    static /* synthetic */ void access$1000(ErrorManager errorManager, Incident incident) {
        errorManager.dumpSync(incident);
    }

    static /* synthetic */ void access$1200(ErrorManager errorManager, Incident incident) {
        errorManager.handleError(incident);
    }
}

