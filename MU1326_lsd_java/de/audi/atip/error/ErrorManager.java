/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.error.BundleInfoProvider;
import de.audi.atip.error.IErrorManager;
import de.audi.atip.error.Incident;
import de.audi.atip.error.IntegrityChecker;
import de.audi.atip.error.ShutdownGuard;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogSink;
import de.audi.atip.log.SPISink;
import de.audi.atip.timer.WatchDog;
import de.audi.atip.util.CommandLineExecuter;
import de.audi.tghu.log.BlackBox;
import de.audi.tghu.log.LogServImpl;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

public class ErrorManager
implements IErrorManager {
    private static final String DUMP_DIR_QNX = "/eso/hmi/errlog/";
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
        this.dumpdir = System.getProperty("ErrorDumpDir", iFrameworkAccess.isTarget() ? DUMP_DIR_QNX : new StringBuffer().append(System.getProperty("java.io.tmpdir")).append("errlog\\").toString());
        this.getLog().log(1000000, "Write error dumps to %1", (Object)this.dumpdir);
        this.getLog().log(1000000, "Write no more than %1 error dumps", (long)this.maxErrlogDumps);
        if (string != null) {
            if ("stdout".equals(string)) {
                this.discardWhenLimitExceeded = false;
            }
            if ("replace".equals(string)) {
                this.replaceOldErrlogs = true;
            }
        }
        if (this.discardWhenLimitExceeded) {
            this.getLog().log(1000000, "Discard additional error dumps");
        } else {
            this.getLog().log(1000000, "Write additional error dumps to System.out");
        }
        if (this.replaceOldErrlogs) {
            this.getLog().log(1000000, "New error dumps replace older ones");
        } else {
            this.getLog().log(1000000, "Oldest error dumps are kept");
        }
        if (iFrameworkAccess.isTarget()) {
            this.registerCommand(new J9ThreadInfoProvider());
        } else {
            this.registerDumpInfoProvider(new ThreadInfoProvider());
        }
        this.registerDumpInfoProvider(new SystemInfoProvider());
        this.registerDumpInfoProvider(new VersionInfoProvider());
        this.registerDumpInfoProvider(new EnvInfoProvider());
        this.registerDumpInfoProvider(new BlackBoxProvider());
        this.registerDumpInfoProvider(new BundleInfoProvider(iFrameworkAccess));
        if (iFrameworkAccess.isTarget()) {
            this.registerCommand(new CmdInfoProvider("Sloginfo", "sloginfo", new String[]{"-t"}));
            this.registerCommand(new CmdInfoProvider("Pidin", "pidin", new String[]{"arg"}));
            this.registerCommand(new CmdInfoProvider("3D_out.txt", "cat", new String[]{"/tmp/out.txt"}));
        }
    }

    public String[] getTargetIntegrityInfo() {
        return new IntegrityChecker(this.framework).getTargetIntegrityInfo();
    }

    private LogChannel getLog() {
        return this.framework.getLogChannel("Fw.Error");
    }

    public final String getDumpDir() {
        return this.dumpdir;
    }

    public final LogSink getFlightRecorder() {
        return this.flightRecorder;
    }

    private int getSessionId() {
        if (this.sessionID != -1) {
            return this.sessionID;
        }
        int n = 1000000;
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

    public final synchronized void registerDumpInfoProvider(DumpInfoProvider dumpInfoProvider) {
        this.sources.add(dumpInfoProvider);
    }

    public synchronized void unregisterDumpInfoProvider(DumpInfoProvider dumpInfoProvider) {
        this.sources.remove(dumpInfoProvider);
    }

    public synchronized void setSPISink(SPISink sPISink) {
        this.spiSink = sPISink;
    }

    private synchronized void registerCommand(DumpInfoProvider dumpInfoProvider) {
        this.getLog().log(1000000, "registering command: %1", (Object)dumpInfoProvider.getName());
        this.commands.add(dumpInfoProvider);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpProvider(DumpInfoProvider dumpInfoProvider, String string, ZipOutputStream zipOutputStream, PrintStream printStream) throws IOException {
        long l = this.framework.getMonotonicTime();
        this.active = dumpInfoProvider;
        boolean bl = false;
        try {
            this.getLog().log(1000000, "writing error info: %1", (Object)dumpInfoProvider.getName());
            zipOutputStream.putNextEntry(new ZipEntry(new StringBuffer().append(dumpInfoProvider.getName()).append(".txt").toString()));
            bl = true;
            dumpInfoProvider.dump(printStream, string);
        }
        catch (ZipException zipException) {
            try {
                Thread.sleep(2L);
                String string2 = new StringBuffer().append(dumpInfoProvider.getName()).append(new Random(System.currentTimeMillis()).nextInt()).toString();
                this.getLog().log(1000000, "writing error info to random file: %1", (Object)string2);
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
            if ((l2 = this.framework.getMonotonicTime() - l) > 1000L) {
                this.getLog().log(10000, "writing error info: %1 took too long: %2ms!", (Object)dumpInfoProvider.getName(), l2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpToFile(String string, boolean bl) throws IOException {
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
    private void dumpToStream(OutputStream outputStream, String string, boolean bl) throws IOException {
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
                    this.getLog().log(100000000, "problem during zip.close()", (Throwable)iOException);
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
                catch (IOException iOException) {
                    this.getLog().log(100000000, "problem during zip.close()", (Throwable)iOException);
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
        Object[] objectArray = new File(this.dumpdir).list(new FilenameFilter(){

            public boolean accept(File file, String string) {
                return ErrorManager.this.isErrorDump(string);
            }
        });
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
    private void dumpAsync(final Incident incident) {
        final ArrayList arrayList = new ArrayList(2);
        Object object = arrayList;
        synchronized (object) {
            new Thread(new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void run() {
                    ErrorManager.this.dumpSync(incident);
                    arrayList.add(new Object());
                    List list = arrayList;
                    synchronized (list) {
                        arrayList.notifyAll();
                    }
                }
            }, "DumpAsync").start();
            try {
                arrayList.wait(20000L);
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

    public void handleError(Throwable throwable, String string, int n, int n2, int n3) {
        this.handleError(throwable, string, n, n2, n3, null);
    }

    public WatchDog createWatchDog(long l, Runnable runnable, String string, int n, int n2, int n3) {
        return new WatchDog(string, l, this.getLog(), new WatchDogAlarm(runnable, new Incident(this.framework.getMonotonicTime(), null, string, n, n2, n3, null)));
    }

    public WatchDog createWatchDog(long l, Runnable runnable, String string, int n, int n2, int n3, boolean bl) {
        return new WatchDog(string, l, this.getLog(), new WatchDogAlarm(runnable, bl ? new Incident(this.framework.getMonotonicTime(), null, string, n, n2, n3, null) : null));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class WatchDogAlarm
    implements Runnable {
        private Runnable payload = null;
        private Incident incident = null;

        private WatchDogAlarm(Runnable runnable, Incident incident) {
            this.payload = runnable;
            this.incident = incident;
        }

        public void run() {
            if (this.payload != null) {
                this.payload.run();
            }
            if (this.incident != null) {
                ErrorManager.this.handleError(this.incident);
            }
        }
    }

    private static class CmdInfoProvider
    implements DumpInfoProvider {
        private String name;
        private String cmd;
        private PrintStream[] additionalSinks;
        private String[] args;

        private CmdInfoProvider(String string, String string2, String[] stringArray, PrintStream[] printStreamArray) {
            this.name = string;
            this.cmd = string2;
            this.args = stringArray;
            this.additionalSinks = printStreamArray;
        }

        private CmdInfoProvider(String string, String string2, String[] stringArray) {
            this(string, string2, stringArray, (PrintStream[])null);
        }

        public void dump(PrintStream printStream, String string) {
            PrintStream[] printStreamArray;
            if (this.additionalSinks == null) {
                printStreamArray = new PrintStream[]{printStream};
            } else {
                printStreamArray = new PrintStream[this.additionalSinks.length + 1];
                System.arraycopy((Object)printStreamArray, 0, (Object)this.additionalSinks, 0, this.additionalSinks.length);
                printStreamArray[this.additionalSinks.length] = printStream;
            }
            CommandLineExecuter.executeCommand(this.cmd, this.args, printStreamArray);
        }

        public String getName() {
            return this.name;
        }
    }

    private static class EnvInfoProvider
    implements DumpInfoProvider {
        private EnvInfoProvider() {
        }

        public String getName() {
            return "Env";
        }

        public void dump(PrintStream printStream, String string) {
            Properties properties = System.getProperties();
            properties.list(printStream);
            printStream.println();
        }
    }

    private final class BlackBoxProvider
    implements DumpInfoProvider {
        BlackBoxProvider() {
            int n = 100;
            try {
                n = Integer.parseInt(System.getProperty("BLACKBOX_SIZE", "100"));
            }
            catch (NumberFormatException numberFormatException) {
                n = 100;
            }
            ErrorManager.this.flightRecorder = new BlackBox(n);
            ErrorManager.this.framework.getLogChannelAdmin().addLogSink(ErrorManager.this.flightRecorder);
            ErrorManager.this.flightRecorder.setConfiguration(LogServImpl.decodeLogConfig(System.getProperty("BLACKBOX_LOG")));
        }

        public String getName() {
            return "Logs";
        }

        public void dump(PrintStream printStream, String string) {
            printStream.println("-- BlackBox --");
            printStream.println(new StringBuffer().append("Blackbox log : ").append(System.getProperty("BLACKBOX_LOG")).toString());
            printStream.println(new StringBuffer().append("Blackbox size: ").append(System.getProperty("BLACKBOX_SIZE")).toString());
            printStream.println();
            ErrorManager.this.flightRecorder.dumpBuffer(printStream);
        }
    }

    private static class SystemInfoProvider
    implements DumpInfoProvider {
        private SystemInfoProvider() {
        }

        public String getName() {
            return "SystemState";
        }

        public void dump(PrintStream printStream, String string) {
            printStream.println("-- Java Information --");
            printStream.println(new StringBuffer().append("Java FreeMem:  ").append(Runtime.getRuntime().freeMemory() / 1024L).append("Kb").toString());
            printStream.println(new StringBuffer().append("Java TotalMem: ").append(Runtime.getRuntime().totalMemory() / 1024L).append("Kb").toString());
            printStream.println();
            printStream.println("-- DSI Information --");
            printStream.println(new StringBuffer().append("Channel:       ").append(System.getProperty("dsi.channel")).toString());
            printStream.println(new StringBuffer().append("Debuglevel:    ").append(System.getProperty("dsi.debuglevel")).toString());
            printStream.println();
        }
    }

    private static class ThreadInfoProvider
    implements DumpInfoProvider {
        private ThreadInfoProvider() {
        }

        public String getName() {
            return "ThreadState";
        }

        private ThreadGroup getRoot() {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            return threadGroup;
        }

        private void dumpThread(PrintStream printStream, Thread thread, String string) {
            printStream.print(new StringBuffer().append(string).append("Thread: ").append(thread.getName()).append(" Prio: ").append(thread.getPriority()).toString());
            if (!thread.isAlive()) {
                printStream.print(" ZOMBIE");
            }
            if (thread.isDaemon()) {
                printStream.print(" DAEMON");
            }
            if (thread.isInterrupted()) {
                printStream.print(" INTERRUPTED");
            }
            if (thread == Thread.currentThread()) {
                printStream.print(" CURRENT");
            }
            printStream.println();
            if (thread == Thread.currentThread()) {
                try {
                    throw new Exception();
                }
                catch (Exception exception) {
                    exception.printStackTrace(printStream);
                }
            }
        }

        private void dumpThreadGroup(PrintStream printStream, ThreadGroup threadGroup, String string) {
            printStream.println(new StringBuffer().append(string).append("ThreadGroup: ").append(threadGroup.getName()).toString());
            String string2 = new StringBuffer().append(string).append("  ").toString();
            Thread[] threadArray = new Thread[threadGroup.activeCount()];
            int n = threadGroup.enumerate(threadArray);
            for (int i2 = 0; i2 < n; ++i2) {
                if (threadArray[i2].getThreadGroup() != threadGroup) continue;
                this.dumpThread(printStream, threadArray[i2], string2);
            }
            ThreadGroup[] threadGroupArray = new ThreadGroup[threadGroup.activeGroupCount()];
            int n2 = threadGroup.enumerate(threadGroupArray);
            for (int i3 = 0; i3 < n2; ++i3) {
                if (threadGroupArray[i3].getParent() != threadGroup) continue;
                this.dumpThreadGroup(printStream, threadGroupArray[i3], string2);
            }
        }

        public void dump(PrintStream printStream, String string) {
            this.dumpThreadGroup(printStream, this.getRoot(), "");
            printStream.println();
        }
    }

    private class VersionInfoProvider
    implements DumpInfoProvider {
        private VersionInfoProvider() {
        }

        public String getName() {
            return "VersionInfo";
        }

        public void dump(PrintStream printStream, String string) {
            printStream.println("-- OS Information --");
            printStream.println(new StringBuffer().append("CPU:            ").append(System.getProperty("os.arch")).toString());
            printStream.println(new StringBuffer().append("OS:             ").append(System.getProperty("os.name")).toString());
            printStream.println(new StringBuffer().append("Version:        ").append(System.getProperty("os.version")).toString());
            printStream.println();
            printStream.println("-- Java Information --");
            printStream.println(new StringBuffer().append("Java Vendor:    ").append(System.getProperty("java.vendor")).toString());
            printStream.println(new StringBuffer().append("Java Version:   ").append(System.getProperty("java.vm.version")).toString());
            printStream.println(new StringBuffer().append("Java VM Info:   ").append(System.getProperty("java.vm.info")).toString());
            printStream.println(new StringBuffer().append("Class Version:  ").append(System.getProperty("java.class.version")).toString());
            printStream.println(new StringBuffer().append("JXE Romimage:   ").append(System.getProperty("jxe.current.romimage.version")).toString());
            printStream.println(new StringBuffer().append("Library Version:").append(System.getProperty("com.ibm.oti.vm.library.version")).toString());
            printStream.println();
            printStream.println("-- DSI Information --");
            printStream.println(new StringBuffer().append("DSI_IFC_Version: ").append(ErrorManager.this.framework.getVersionInfo().getDsiIfcVersion()).toString());
            printStream.println(new StringBuffer().append("Framework:       ").append(ErrorManager.this.framework.getVersionInfo().getFrameworkVersion()).toString());
            printStream.println();
            printStream.println("-- HMI Information --");
            printStream.println(new StringBuffer().append("Variant:         ").append(System.getProperty("variant.label")).toString());
            printStream.println(new StringBuffer().append("HMI Version:     ").append(ErrorManager.this.framework.getVersionInfo().getHMIVersion()).toString());
            printStream.println(new StringBuffer().append("Kanzi Version:   ").append(ErrorManager.this.framework.getVersionInfo().getKanziVersion()).toString());
            printStream.println(new StringBuffer().append("Texttool:        ").append(ErrorManager.this.framework.getVersionInfo().getTextToolVersion()).toString());
            printStream.println(new StringBuffer().append("Texttool_SDS:    ").append(ErrorManager.this.framework.getVersionInfo().getTextToolSDSVersion()).toString());
        }
    }

    private class J9ThreadInfoProvider
    implements DumpInfoProvider {
        private J9ThreadInfoProvider() {
        }

        public String getName() {
            return "ThreadState";
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void dump(PrintStream printStream, String string) {
            PrintStream printStream2 = System.out;
            try {
                System.setOut(printStream);
                if (ErrorManager.this.framework.isEvoStd()) {
                    try {
                        (class$com$microdoc$j9$Tools == null ? (class$com$microdoc$j9$Tools = ErrorManager.class$("com.microdoc.j9.Tools")) : class$com$microdoc$j9$Tools).getMethod("dumpThreadsInfo", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.TRUE});
                    }
                    catch (Exception exception) {
                        ErrorManager.this.getLog().log(10000, "Calling dumpThreadsInfo failed!", (Throwable)exception);
                    }
                } else {
                    try {
                        (class$com$microdoc$j9$Tools == null ? (class$com$microdoc$j9$Tools = ErrorManager.class$("com.microdoc.j9.Tools")) : class$com$microdoc$j9$Tools).getMethod("dumpThreadsInfo", new Class[0]).invoke(null, new Object[0]);
                    }
                    catch (Exception exception) {
                        ErrorManager.this.getLog().log(10000, "Calling dumpThreadsInfo failed!", (Throwable)exception);
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace(printStream);
            }
            finally {
                System.setOut(printStream2);
            }
        }
    }
}

