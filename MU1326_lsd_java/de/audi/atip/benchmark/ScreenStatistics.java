/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IScreenStatistics;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ScreenStatistics
implements IScreenStatistics {
    static final int SCREENS = 1000;
    static final String SUMMARY_HEADER = "SUMMARY;Visited Screens;Total Screens;Percentage";
    static final String HEADER = "ScreenId;Screen Name;Paint Count;Avg Paint Time;Avg Draw Time;Worst Paint Time;Worst Draw Time;Worst Create Time;Created Count;Cache hits;Avg Create Time;Connected Count;Avg Connect Time;Worst Connect Time";
    static final IScreenStatistics NULL_OBJECT = IStatisticsManager.INSTRUMENTATION_ENABLED ? new NullScreenStatistics() : null;
    private final ITimeSource timeSource;
    private final Map paintScreenStatistics = new HashMap(1000);
    private int currentScreenId;
    private long start;
    private long end;
    private boolean inConnect = false;
    private boolean inPaint = false;

    ScreenStatistics(StatisticsManager statisticsManager) {
        this.timeSource = statisticsManager.getTimeSource();
    }

    public void paintStart(int n) {
        this.currentScreenId = n;
        this.start = this.timeSource.getCurrentTime();
        this.inPaint = true;
    }

    public void paintEnd() {
        this.end = this.timeSource.getCurrentTime();
        this.inPaint = false;
    }

    public void drawEnd() {
        this.registerStatistics(this.currentScreenId, this.end - this.start, this.timeSource.getCurrentTime() - this.end);
    }

    public void increaseCacheHits(int n) {
        ++this.getStatisticsForScreen((int)n).cacheHits;
    }

    public void getScreenStart(int n) {
        this.currentScreenId = n;
        this.start = this.timeSource.getCurrentTime();
    }

    public void getScreenEnd() {
        ScreenMetrics screenMetrics = this.getStatisticsForScreen(this.currentScreenId);
        long l = this.timeSource.getCurrentTime() - this.start;
        if ((long)screenMetrics.worstCreateTime < l) {
            screenMetrics.worstCreateTime = (int)l;
        }
        screenMetrics.totalCreateTime += l;
        ++screenMetrics.createdCount;
    }

    public void connectStart(int n) {
        this.currentScreenId = n;
        this.start = this.timeSource.getCurrentTime();
        this.inConnect = true;
    }

    public void connectEnd() {
        ScreenMetrics screenMetrics = this.getStatisticsForScreen(this.currentScreenId);
        long l = this.timeSource.getCurrentTime() - this.start;
        ++screenMetrics.connectCount;
        screenMetrics.connectTotalTime += l;
        if (l > (long)screenMetrics.worstConnectTime) {
            screenMetrics.worstConnectTime = (int)l;
        }
        this.inConnect = false;
    }

    public void reset() {
        this.paintScreenStatistics.clear();
    }

    void dump(PrintStream printStream) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            printStream.println("Exception while printing statistics: " + exception);
        }
    }

    boolean isInPaint(int n) {
        return this.currentScreenId == n && this.inPaint;
    }

    boolean isInConnect(int n) {
        return this.currentScreenId == n && this.inConnect;
    }

    private void registerStatistics(int n, long l, long l2) {
        ScreenMetrics screenMetrics = this.getStatisticsForScreen(n);
        if ((long)screenMetrics.worstGuiDrawTime < l2) {
            screenMetrics.worstGuiDrawTime = (int)l2;
        }
        if ((long)screenMetrics.worstPaintTime < l) {
            screenMetrics.worstPaintTime = (int)l;
        }
        ++screenMetrics.screenDraws;
        screenMetrics.screenPaintTime += l;
        screenMetrics.guiDrawTime += l2;
    }

    private ScreenMetrics getStatisticsForScreen(int n) {
        Integer n2 = new Integer(n);
        ScreenMetrics screenMetrics = (ScreenMetrics)this.paintScreenStatistics.get(n2);
        if (null == screenMetrics) {
            screenMetrics = new ScreenMetrics();
            this.paintScreenStatistics.put(n2, screenMetrics);
        }
        return screenMetrics;
    }

    private void doDump(PrintStream printStream) {
        if (this.paintScreenStatistics.isEmpty()) {
            printStream.println("No measurements have been collected");
            return;
        }
        printStream.println(SUMMARY_HEADER);
        int n = this.paintScreenStatistics.size();
        int n2 = ScreenStatistics.getNumberOfTotalScreens();
        String string = new DecimalFormat("0.00").format((float)n / (float)n2 * 100.0f);
        Buffer buffer = new Buffer(128).append(";").append(n).append(";").append(n2).append(";").append(string);
        printStream.println(buffer);
        Buffer buffer2 = new Buffer(128).append(HEADER).append(StatisticsManager.instance().getResourceLoaderStatistics().getStatisticsForScreen(-1));
        printStream.println(buffer2);
        Iterator iterator = this.paintScreenStatistics.keySet().iterator();
        while (iterator.hasNext()) {
            Integer n3 = (Integer)iterator.next();
            ScreenMetrics screenMetrics = (ScreenMetrics)this.paintScreenStatistics.get(n3);
            Buffer buffer3 = new Buffer(256).append(n3).append(";").append(ScreenStatistics.getScreenName(n3)).append(";").append(screenMetrics.screenDraws).append(";").append((float)screenMetrics.screenPaintTime / (float)screenMetrics.screenDraws).append(";").append((float)screenMetrics.guiDrawTime / (float)screenMetrics.screenDraws).append(";").append(screenMetrics.worstPaintTime).append(";").append(screenMetrics.worstGuiDrawTime).append(";").append(screenMetrics.worstCreateTime).append(";").append(screenMetrics.createdCount).append(";").append(screenMetrics.cacheHits).append(";").append((float)screenMetrics.totalCreateTime / (float)screenMetrics.createdCount).append(";").append(screenMetrics.connectCount).append(";").append((float)screenMetrics.connectTotalTime / (float)screenMetrics.connectCount).append(";").append(screenMetrics.worstConnectTime).append(StatisticsManager.instance().getResourceLoaderStatistics().getStatisticsForScreen(n3));
            printStream.println(buffer3);
        }
    }

    public String getName() {
        return "ScreenStatistics.csv";
    }

    public void dump(PrintStream printStream, String string) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            printStream.println("Exception while printing statistics: " + exception);
        }
    }

    static String getScreenName(Integer n) {
        try {
            Class clazz = Class.forName("de.audi.atip.diag.HMIDiagScreenNameMapping");
            Method method = clazz.getDeclaredMethod("getScreenName", new Class[]{Integer.TYPE});
            return (String)method.invoke(null, new Object[]{n});
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    static int getNumberOfTotalScreens() {
        try {
            Class clazz = Class.forName("de.audi.atip.diag.HMIDiagScreenIds");
            int[][] nArray = (int[][])clazz.getDeclaredField("availableScreenIds").get(new int[0][]);
            int n = 0;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                n += nArray[i2].length;
            }
            return n;
        }
        catch (Exception exception) {
            return -1;
        }
    }

    private static class ScreenMetrics {
        int screenDraws;
        long screenPaintTime;
        long guiDrawTime;
        int worstPaintTime;
        int worstGuiDrawTime;
        int cacheHits;
        int createdCount;
        int worstCreateTime;
        long totalCreateTime;
        int connectCount;
        int worstConnectTime;
        long connectTotalTime;

        private ScreenMetrics() {
        }
    }

    private static final class NullScreenStatistics
    implements IScreenStatistics {
        private NullScreenStatistics() {
        }

        public String getName() {
            return "ScreenStatistics.csv";
        }

        public void dump(PrintStream printStream, String string) {
        }

        public void reset() {
        }

        public void paintStart(int n) {
        }

        public void paintEnd() {
        }

        public void drawEnd() {
        }

        public void increaseCacheHits(int n) {
        }

        public void getScreenStart(int n) {
        }

        public void getScreenEnd() {
        }

        public void connectStart(int n) {
        }

        public void connectEnd() {
        }
    }
}

