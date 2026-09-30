/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IKZBStatistics;
import de.audi.atip.benchmark.IScreenStatistics;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.ScreenStatistics;
import de.audi.atip.benchmark.StatisticsManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class KZBStatistics
implements IKZBStatistics {
    static final String HEADER = "ScreenId;Screen Name;Type;KzbPath;Resource Info;Start(ms);End(ms);Time taken(ms);When;Error?";
    static final String HEADER_AGGREGATE = ";# KZBs in Paint;KZBs in Paint Total Time(ms);# KZBs in Connect;KZBs in Connect Total Time(ms)";
    static final String NOT_MEASURED = ";N/A;N/A;N/A;N/A";
    static final byte IN_CONNECT = 1;
    static final byte IN_PAINT = 2;
    static final byte UNDEF = 0;
    static final String[] TYPES = new String[]{"TYPE_TEMPLATE_NODE", "TYPE_MERGE_PROJECT", "TYPE_KZB_PATH", "TYPE_MATERIAL", "TYPE_MERGE_PROJECT_ASYNC", "TYPE_TEMPLATE_NODE_2D"};
    public static final int HEADER_ID = -1;
    static final IKZBStatistics NULL_OBJECT = IStatisticsManager.INSTRUMENTATION_ENABLED ? new NullKZBStatistics() : null;
    private long start;
    private int currentScreenId;
    private final ITimeSource timeSource;
    private final Map resLoadingStats;

    public KZBStatistics(StatisticsManager statisticsManager) {
        this.timeSource = statisticsManager.getTimeSource();
        this.resLoadingStats = new HashMap(1000);
    }

    public void reset() {
        this.resLoadingStats.clear();
    }

    public String getName() {
        return "KZBStatistics.csv";
    }

    public void dump(PrintStream printStream, String string) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            printStream.println("Exception while printing statistics: " + exception);
        }
    }

    public void loadStart(int n) {
        this.start = this.timeSource.getCurrentTime();
        this.currentScreenId = n;
    }

    public void loadEnd(String string, Object object, int n, boolean bl) {
        ScreenStatistics screenStatistics;
        List list = this.getResourceStatsForScreen(this.currentScreenId);
        ResourceMetrics resourceMetrics = new ResourceMetrics();
        list.add(resourceMetrics);
        resourceMetrics.start = this.start;
        resourceMetrics.end = this.timeSource.getCurrentTime();
        resourceMetrics.type = n;
        resourceMetrics.kzbPath = string;
        resourceMetrics.resourceInfo = object;
        resourceMetrics.error = bl;
        IScreenStatistics iScreenStatistics = StatisticsManager.instance().getScreenStatistics();
        resourceMetrics.when = iScreenStatistics instanceof ScreenStatistics ? ((screenStatistics = (ScreenStatistics)StatisticsManager.instance().getScreenStatistics()).isInConnect(this.currentScreenId) ? (byte)1 : (screenStatistics.isInPaint(this.currentScreenId) ? (byte)2 : (byte)0)) : (byte)0;
    }

    public String getStatisticsForScreen(int n) {
        if (this.resLoadingStats == null || this.resLoadingStats.isEmpty()) {
            return "";
        }
        if (0 > n) {
            return HEADER_AGGREGATE;
        }
        List list = this.getResourceStatsForScreen(n);
        if (null != list && !list.isEmpty()) {
            int[] nArray = new int[2];
            long[] lArray = new long[2];
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ResourceMetrics resourceMetrics = (ResourceMetrics)iterator.next();
                if (resourceMetrics.when <= 0) continue;
                int n2 = resourceMetrics.when - 1;
                nArray[n2] = nArray[n2] + 1;
                int n3 = resourceMetrics.when - 1;
                lArray[n3] = lArray[n3] + (resourceMetrics.end - resourceMetrics.start);
            }
            return new Buffer(64).append(";").append(nArray[1]).append(";").append(lArray[1]).append(";").append(nArray[0]).append(";").append(lArray[0]).toString();
        }
        return NOT_MEASURED;
    }

    private void doDump(PrintStream printStream) {
        if (this.resLoadingStats == null || this.resLoadingStats.isEmpty()) {
            printStream.println("No measurements have been collected");
            return;
        }
        printStream.println(HEADER);
        Iterator iterator = this.resLoadingStats.keySet().iterator();
        while (iterator.hasNext()) {
            Integer n = (Integer)iterator.next();
            List list = (List)this.resLoadingStats.get(n);
            if (null == list || list.isEmpty()) continue;
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                ResourceMetrics resourceMetrics = (ResourceMetrics)iterator2.next();
                Buffer buffer = new Buffer();
                buffer.append(n).append(";").append(ScreenStatistics.getScreenName(n)).append(";").append(this.type2String(resourceMetrics.type)).append(";").append(resourceMetrics.kzbPath).append(";").append(this.res2String(resourceMetrics.resourceInfo)).append(";").append(resourceMetrics.start).append(";").append(resourceMetrics.end).append(";").append(resourceMetrics.end - resourceMetrics.start).append(";").append(this.when2String(resourceMetrics.when)).append(";").append(resourceMetrics.error);
                printStream.println(buffer);
            }
        }
    }

    private Object res2String(Object object) {
        if (object instanceof Object[]) {
            Object[] objectArray = (Object[])object;
            Buffer buffer = new Buffer(32);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                buffer.append(String.valueOf(objectArray[i2]));
                if (i2 == objectArray.length - 1) continue;
                buffer.append(" & ");
            }
            return buffer;
        }
        return object;
    }

    private List getResourceStatsForScreen(int n) {
        Integer n2 = new Integer(n);
        List list = (List)this.resLoadingStats.get(n2);
        if (null == list) {
            list = new LinkedList();
            this.resLoadingStats.put(n2, list);
        }
        return list;
    }

    private String type2String(int n) {
        if (n <= 0 || n > TYPES.length) {
            return String.valueOf(n);
        }
        return TYPES[n - 1];
    }

    private String when2String(byte by) {
        switch (by) {
            case 2: {
                return "Paint";
            }
            case 1: {
                return "Connect";
            }
        }
        return "undef";
    }

    private static class ResourceMetrics {
        long start;
        long end;
        int type;
        String kzbPath;
        Object resourceInfo;
        byte when;
        boolean error;

        private ResourceMetrics() {
        }
    }

    private static final class NullKZBStatistics
    implements IKZBStatistics {
        private NullKZBStatistics() {
        }

        public void reset() {
        }

        public String getName() {
            return "KZBStatistics.csv";
        }

        public void dump(PrintStream printStream, String string) {
        }

        public void loadStart(int n) {
        }

        public void loadEnd(String string, Object object, int n, boolean bl) {
        }

        public String getStatisticsForScreen(int n) {
            return "";
        }
    }
}

