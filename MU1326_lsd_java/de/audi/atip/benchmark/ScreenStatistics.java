/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IScreenStatistics;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.ScreenStatistics$NullScreenStatistics;
import de.audi.atip.benchmark.ScreenStatistics$ScreenMetrics;
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
    static final int SCREENS;
    static final String SUMMARY_HEADER;
    static final String HEADER;
    static final IScreenStatistics NULL_OBJECT;
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

    @Override
    public void paintStart(int n) {
        this.currentScreenId = n;
        this.start = this.timeSource.getCurrentTime();
        this.inPaint = true;
    }

    @Override
    public void paintEnd() {
        this.end = this.timeSource.getCurrentTime();
        this.inPaint = false;
    }

    @Override
    public void drawEnd() {
        this.registerStatistics(this.currentScreenId, this.end - this.start, this.timeSource.getCurrentTime() - this.end);
    }

    @Override
    public void increaseCacheHits(int n) {
        ++this.getStatisticsForScreen((int)n).cacheHits;
    }

    @Override
    public void getScreenStart(int n) {
        this.currentScreenId = n;
        this.start = this.timeSource.getCurrentTime();
    }

    @Override
    public void getScreenEnd() {
        ScreenStatistics$ScreenMetrics screenStatistics$ScreenMetrics = this.getStatisticsForScreen(this.currentScreenId);
        long l = this.timeSource.getCurrentTime() - this.start;
        if ((long)screenStatistics$ScreenMetrics.worstCreateTime < l) {
            screenStatistics$ScreenMetrics.worstCreateTime = (int)l;
        }
        screenStatistics$ScreenMetrics.totalCreateTime += l;
        ++screenStatistics$ScreenMetrics.createdCount;
    }

    @Override
    public void connectStart(int n) {
        this.currentScreenId = n;
        this.start = this.timeSource.getCurrentTime();
        this.inConnect = true;
    }

    @Override
    public void connectEnd() {
        ScreenStatistics$ScreenMetrics screenStatistics$ScreenMetrics = this.getStatisticsForScreen(this.currentScreenId);
        long l = this.timeSource.getCurrentTime() - this.start;
        ++screenStatistics$ScreenMetrics.connectCount;
        screenStatistics$ScreenMetrics.connectTotalTime += l;
        if (l > (long)screenStatistics$ScreenMetrics.worstConnectTime) {
            screenStatistics$ScreenMetrics.worstConnectTime = (int)l;
        }
        this.inConnect = false;
    }

    @Override
    public void reset() {
        this.paintScreenStatistics.clear();
    }

    void dump(PrintStream printStream) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            printStream.println(new StringBuffer().append("Exception while printing statistics: ").append(exception).toString());
        }
    }

    boolean isInPaint(int n) {
        return this.currentScreenId == n && this.inPaint;
    }

    boolean isInConnect(int n) {
        return this.currentScreenId == n && this.inConnect;
    }

    private void registerStatistics(int n, long l, long l2) {
        ScreenStatistics$ScreenMetrics screenStatistics$ScreenMetrics = this.getStatisticsForScreen(n);
        if ((long)screenStatistics$ScreenMetrics.worstGuiDrawTime < l2) {
            screenStatistics$ScreenMetrics.worstGuiDrawTime = (int)l2;
        }
        if ((long)screenStatistics$ScreenMetrics.worstPaintTime < l) {
            screenStatistics$ScreenMetrics.worstPaintTime = (int)l;
        }
        ++screenStatistics$ScreenMetrics.screenDraws;
        screenStatistics$ScreenMetrics.screenPaintTime += l;
        screenStatistics$ScreenMetrics.guiDrawTime += l2;
    }

    private ScreenStatistics$ScreenMetrics getStatisticsForScreen(int n) {
        Integer n2 = new Integer(n);
        ScreenStatistics$ScreenMetrics screenStatistics$ScreenMetrics = (ScreenStatistics$ScreenMetrics)this.paintScreenStatistics.get(n2);
        if (null == screenStatistics$ScreenMetrics) {
            screenStatistics$ScreenMetrics = new ScreenStatistics$ScreenMetrics(null);
            this.paintScreenStatistics.put(n2, screenStatistics$ScreenMetrics);
        }
        return screenStatistics$ScreenMetrics;
    }

    private void doDump(PrintStream printStream) {
        if (this.paintScreenStatistics.isEmpty()) {
            printStream.println("No measurements have been collected");
            return;
        }
        printStream.println("SUMMARY;Visited Screens;Total Screens;Percentage");
        int n = this.paintScreenStatistics.size();
        int n2 = ScreenStatistics.getNumberOfTotalScreens();
        String string = new DecimalFormat("0.00").format((float)n / (float)n2 * 51266);
        Buffer buffer = new Buffer(128).append(";").append(n).append(";").append(n2).append(";").append(string);
        printStream.println(buffer);
        Buffer buffer2 = new Buffer(128).append("ScreenId;Screen Name;Paint Count;Avg Paint Time;Avg Draw Time;Worst Paint Time;Worst Draw Time;Worst Create Time;Created Count;Cache hits;Avg Create Time;Connected Count;Avg Connect Time;Worst Connect Time").append(StatisticsManager.instance().getResourceLoaderStatistics().getStatisticsForScreen(-1));
        printStream.println(buffer2);
        Iterator iterator = this.paintScreenStatistics.keySet().iterator();
        while (iterator.hasNext()) {
            Integer n3 = (Integer)iterator.next();
            ScreenStatistics$ScreenMetrics screenStatistics$ScreenMetrics = (ScreenStatistics$ScreenMetrics)this.paintScreenStatistics.get(n3);
            Buffer buffer3 = new Buffer(256).append(n3).append(";").append(ScreenStatistics.getScreenName(n3)).append(";").append(screenStatistics$ScreenMetrics.screenDraws).append(";").append((float)screenStatistics$ScreenMetrics.screenPaintTime / (float)screenStatistics$ScreenMetrics.screenDraws).append(";").append((float)screenStatistics$ScreenMetrics.guiDrawTime / (float)screenStatistics$ScreenMetrics.screenDraws).append(";").append(screenStatistics$ScreenMetrics.worstPaintTime).append(";").append(screenStatistics$ScreenMetrics.worstGuiDrawTime).append(";").append(screenStatistics$ScreenMetrics.worstCreateTime).append(";").append(screenStatistics$ScreenMetrics.createdCount).append(";").append(screenStatistics$ScreenMetrics.cacheHits).append(";").append((float)screenStatistics$ScreenMetrics.totalCreateTime / (float)screenStatistics$ScreenMetrics.createdCount).append(";").append(screenStatistics$ScreenMetrics.connectCount).append(";").append((float)screenStatistics$ScreenMetrics.connectTotalTime / (float)screenStatistics$ScreenMetrics.connectCount).append(";").append(screenStatistics$ScreenMetrics.worstConnectTime).append(StatisticsManager.instance().getResourceLoaderStatistics().getStatisticsForScreen(n3));
            printStream.println(buffer3);
        }
    }

    @Override
    public String getName() {
        return "ScreenStatistics.csv";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            printStream.println(new StringBuffer().append("Exception while printing statistics: ").append(exception).toString());
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

    static {
        NULL_OBJECT = IStatisticsManager.INSTRUMENTATION_ENABLED ? new ScreenStatistics$NullScreenStatistics(null) : null;
    }
}

