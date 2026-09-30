/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.benchmark.AnimationStatistics;
import de.audi.atip.benchmark.IAnimationStatistics;
import de.audi.atip.benchmark.IImageLoaderStatistics;
import de.audi.atip.benchmark.IKZBStatistics;
import de.audi.atip.benchmark.IScreenStatistics;
import de.audi.atip.benchmark.IStatisticsInfoProvider;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.ImageLoaderStatistics;
import de.audi.atip.benchmark.KZBStatistics;
import de.audi.atip.benchmark.ScreenStatistics;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.RunnableEvent;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

public class StatisticsManager
implements IStatisticsManager {
    private static final String DUMP_DIR_QNX = "/eso/hmi/errlog/";
    private static final int DEFAULT_MAX_LOGS = 10;
    private static final int DISCARD_OLDEST = 0;
    private static final int DISCARD_NONE = 1;
    private static final int DISCARD_NEWEST = 2;
    private static final int DISCARD_CURRENT = 3;
    static final IStatisticsManager NULL_OBJECT;
    private volatile boolean isGathering = false;
    private static IStatisticsManager instance;
    private IScreenStatistics screenStatistics = ScreenStatistics.NULL_OBJECT;
    private IAnimationStatistics animationStatistics = AnimationStatistics.NULL_OBJECT;
    private IKZBStatistics resourceLoaderStatistics = KZBStatistics.NULL_OBJECT;
    private IImageLoaderStatistics imageLoaderStatistics = ImageLoaderStatistics.NULL_OBJECT;
    private final IFrameworkAccess framework;
    private final String dumpdir;
    private final int maxStatsLogs;
    private final int maxLogsExceededStrategy;

    private StatisticsManager(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.dumpdir = System.getProperty("ErrorDumpDir", iFrameworkAccess.isTarget() ? DUMP_DIR_QNX : new StringBuffer().append(System.getProperty("java.io.tmpdir")).append("errlog\\").toString());
        this.maxStatsLogs = Integer.getInteger("MaxStatsLogs", 10);
        this.maxLogsExceededStrategy = Integer.getInteger("MaxLogsExceededStrategy", 1);
    }

    public static final synchronized boolean createInstance(IFrameworkAccess iFrameworkAccess) {
        if (NULL_OBJECT.equals(instance)) {
            instance = new StatisticsManager(iFrameworkAccess);
            if (!INSTRUMENT_RES_LOADING_ON_DEMAND) {
                ((StatisticsManager)StatisticsManager.instance).resourceLoaderStatistics = new KZBStatistics((StatisticsManager)instance);
                ((StatisticsManager)StatisticsManager.instance).imageLoaderStatistics = new ImageLoaderStatistics((StatisticsManager)instance);
            }
            return true;
        }
        return false;
    }

    public static final synchronized IStatisticsManager instance() {
        return instance;
    }

    public void stopGathering(final String string) {
        if (INSTRUMENT_RES_LOADING_ON_DEMAND && !this.isGathering) {
            return;
        }
        this.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(new Runnable(){

            public void run() {
                StatisticsManager.this.dumpStatistics(string);
            }

            public String toString() {
                return "[DumpingGatheredStatistics]";
            }
        }));
    }

    public void startGathering(final int n) {
        if (0 == (n & 0xF)) {
            System.out.println(new StringBuffer().append("-------------------------- No statistics flags enabled: ").append(n).toString());
            return;
        }
        this.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(new Runnable(){

            public void run() {
                StatisticsManager.this.doStartGathering(n);
            }

            public String toString() {
                return "[EnablingStatistics]";
            }
        }));
    }

    public void doStartGathering(int n) {
        if (this.isGathering) {
            System.out.println("-------------------------- Already gathering statistics!");
            return;
        }
        if (0 != (n & 1)) {
            this.screenStatistics = new ScreenStatistics(this);
            this.isGathering = true;
        } else {
            this.screenStatistics = ScreenStatistics.NULL_OBJECT;
        }
        if (0 != (n & 2)) {
            this.animationStatistics = new AnimationStatistics(this);
            this.isGathering = true;
        } else {
            this.animationStatistics = AnimationStatistics.NULL_OBJECT;
        }
        if (INSTRUMENT_RES_LOADING_ON_DEMAND) {
            if (0 != (n & 4)) {
                this.resourceLoaderStatistics = new KZBStatistics(this);
                this.isGathering = true;
            } else {
                this.resourceLoaderStatistics = KZBStatistics.NULL_OBJECT;
            }
            if (0 != (n & 8)) {
                this.imageLoaderStatistics = new ImageLoaderStatistics(this);
                this.isGathering = true;
            } else {
                this.imageLoaderStatistics = ImageLoaderStatistics.NULL_OBJECT;
            }
        } else {
            this.isGathering = true;
        }
        if (this.isGathering) {
            System.out.println("-------------------------- Start gathering statistics!");
            this.framework.getHMIService().showVisualFeedback(3000L, "Gathering statistics!", 0);
        }
    }

    public ITimeSource getTimeSource() {
        return this.framework.getMonotonicTimeSource();
    }

    public HMITerminal getHMITerminal(int n) {
        return this.framework.getHMITerminalRegistry().getTerminal(n);
    }

    public IScreenStatistics getScreenStatistics() {
        return this.screenStatistics;
    }

    public IAnimationStatistics getAnimationStatistics() {
        return this.animationStatistics;
    }

    public IKZBStatistics getResourceLoaderStatistics() {
        return this.resourceLoaderStatistics;
    }

    public IImageLoaderStatistics getImageLoaderStatistics() {
        return this.imageLoaderStatistics;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpStatistics(String string) {
        if (!this.ensureMaxStatsCapacity()) {
            this.isGathering = false;
            return;
        }
        String string2 = new StringBuffer().append("stats_").append(string).append('_').append(this.framework.getMonotonicTime()).append(".zip").toString();
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(this.dumpdir, string2);
            if (file.exists()) {
                System.out.println(new StringBuffer().append("File '").append(file).append("' will be replaced!").toString());
            }
            fileOutputStream = new FileOutputStream(file, false);
            this.dumpStatistics(fileOutputStream);
            this.framework.getHMIService().showVisualFeedback(3000L, new StringBuffer().append("Wrote: ").append(string2).toString(), 0);
            System.out.println(new StringBuffer().append("-------------------------- Statistics written to: ").append(file).toString());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            this.screenStatistics = ScreenStatistics.NULL_OBJECT;
            this.animationStatistics = AnimationStatistics.NULL_OBJECT;
            if (INSTRUMENT_RES_LOADING_ON_DEMAND) {
                this.resourceLoaderStatistics = KZBStatistics.NULL_OBJECT;
                this.imageLoaderStatistics = ImageLoaderStatistics.NULL_OBJECT;
            }
            this.isGathering = false;
            System.out.println("-------------------------- Stop gathering statistics!");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpStatistics(OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream = null;
        ZipOutputStream zipOutputStream = null;
        PrintStream printStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            zipOutputStream = new ZipOutputStream(bufferedOutputStream);
            printStream = new PrintStream(zipOutputStream);
            if (!ScreenStatistics.NULL_OBJECT.equals(this.screenStatistics)) {
                this.dumpStatistics(this.screenStatistics, zipOutputStream, printStream);
            }
            if (!AnimationStatistics.NULL_OBJECT.equals(this.animationStatistics)) {
                this.dumpStatistics(this.animationStatistics, zipOutputStream, printStream);
            }
            if (!KZBStatistics.NULL_OBJECT.equals(this.resourceLoaderStatistics)) {
                this.dumpStatistics(this.resourceLoaderStatistics, zipOutputStream, printStream);
            }
            if (!ImageLoaderStatistics.NULL_OBJECT.equals(this.imageLoaderStatistics)) {
                this.dumpStatistics(this.imageLoaderStatistics, zipOutputStream, printStream);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            if (printStream != null) {
                printStream.close();
            }
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpStatistics(IStatisticsInfoProvider iStatisticsInfoProvider, ZipOutputStream zipOutputStream, PrintStream printStream) throws IOException {
        long l = this.framework.getMonotonicTime();
        boolean bl = false;
        try {
            zipOutputStream.putNextEntry(new ZipEntry(iStatisticsInfoProvider.getName()));
            bl = true;
            iStatisticsInfoProvider.dump(printStream, iStatisticsInfoProvider.getName());
        }
        catch (ZipException zipException) {
            try {
                Thread.sleep(2L);
                String string = new StringBuffer().append(new Random(System.currentTimeMillis()).nextInt()).append(iStatisticsInfoProvider.getName()).toString();
                zipOutputStream.putNextEntry(new ZipEntry(string));
                bl = true;
                iStatisticsInfoProvider.dump(printStream, string);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            long l2;
            printStream.flush();
            if (bl) {
                zipOutputStream.closeEntry();
            }
            if ((l2 = this.framework.getMonotonicTime() - l) > 1000L) {
                System.out.println(new StringBuffer().append("!!!! Writing statistics took: ").append(l2).toString());
            }
        }
    }

    private boolean ensureMaxStatsCapacity() {
        new File(this.dumpdir).mkdirs();
        Object[] objectArray = new File(this.dumpdir).list(new FilenameFilter(){

            public boolean accept(File file, String string) {
                return null != string && string.startsWith("stats_") && string.endsWith(".zip");
            }
        });
        if (objectArray == null) {
            return true;
        }
        Arrays.sort(objectArray);
        if (objectArray.length >= this.maxStatsLogs) {
            switch (this.maxLogsExceededStrategy) {
                case 0: {
                    new File(new StringBuffer().append(this.dumpdir).append("/").append((String)objectArray[0]).toString()).delete();
                    return true;
                }
                case 2: {
                    new File(new StringBuffer().append(this.dumpdir).append("/").append((String)objectArray[objectArray.length - 1]).toString()).delete();
                    return true;
                }
                case 3: {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    static {
        instance = NULL_OBJECT = INSTRUMENTATION_ENABLED ? new NullStatisticsManager() : null;
    }

    private static final class NullStatisticsManager
    implements IStatisticsManager {
        private NullStatisticsManager() {
        }

        public void stopGathering(String string) {
        }

        public void startGathering(int n) {
        }

        public IScreenStatistics getScreenStatistics() {
            return ScreenStatistics.NULL_OBJECT;
        }

        public IAnimationStatistics getAnimationStatistics() {
            return AnimationStatistics.NULL_OBJECT;
        }

        public IKZBStatistics getResourceLoaderStatistics() {
            return KZBStatistics.NULL_OBJECT;
        }

        public IImageLoaderStatistics getImageLoaderStatistics() {
            return null;
        }
    }
}

