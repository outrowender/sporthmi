/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark;

import de.dreisoft.lsd.benchmark.BenchmarkSuite;
import de.dreisoft.lsd.benchmark.Text;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BenchmarkResult {
    private static int baseResolution = 100;
    private Map svcCounterMap = new TreeMap();
    private Map trackerCounterMap = new TreeMap();
    private Map durationsMap = new TreeMap();

    public static void setBaseResolution(int n) {
        baseResolution = n;
    }

    public void addService(String string) {
        this.addServices(string, 1);
    }

    public void addServices(String string, int n) {
        ServiceCounter serviceCounter = this.getServiceCounter(string);
        serviceCounter.add(n);
    }

    public void addTracker(String string) {
        this.addTrackers(string, 1);
    }

    public void addTrackers(String string, int n) {
        ServiceCounter serviceCounter = this.getTrackerCounter(string);
        serviceCounter.add(n);
    }

    public void addDuration(int n, int n2, long l) {
        CategoryDurations categoryDurations = this.getCatDurations(n);
        categoryDurations.addDuration(n2, l);
    }

    public synchronized void printSummary() {
        this.printSummary(System.out);
    }

    public synchronized void printSummary(PrintStream printStream) {
        StringBuffer stringBuffer;
        int n;
        Comparable comparable;
        int n2 = 0;
        Iterator iterator = this.svcCounterMap.values().iterator();
        while (iterator.hasNext()) {
            comparable = (ServiceCounter)iterator.next();
            n = ((ServiceCounter)comparable).getValue();
            if (n == 0) continue;
            printStream.println(((ServiceCounter)comparable).toString());
            n2 += n;
        }
        if (n2 != 0) {
            printStream.println("------------");
            stringBuffer = Text.appendFixedNumber(new StringBuffer(), n2, 3);
            stringBuffer.append(" services");
            printStream.println(stringBuffer);
            printStream.println("---------------");
        }
        n2 = 0;
        iterator = this.trackerCounterMap.values().iterator();
        while (iterator.hasNext()) {
            comparable = (ServiceCounter)iterator.next();
            n = ((ServiceCounter)comparable).getValue();
            if (n == 0) continue;
            printStream.println(((ServiceCounter)comparable).toString());
            n2 += n;
        }
        if (n2 != 0) {
            printStream.println("------------");
            stringBuffer = Text.appendFixedNumber(new StringBuffer(), n2, 3);
            stringBuffer.append(" services tracked");
            printStream.println(stringBuffer);
            printStream.println("---------------");
        }
        iterator = this.durationsMap.values().iterator();
        while (iterator.hasNext()) {
            comparable = (CategoryDurations)iterator.next();
            printStream.println(((CategoryDurations)comparable).toString());
        }
    }

    private ServiceCounter getServiceCounter(String string) {
        ServiceCounter serviceCounter = (ServiceCounter)this.svcCounterMap.get(string);
        if (serviceCounter == null) {
            serviceCounter = new ServiceCounter("service", string);
            this.svcCounterMap.put(string, serviceCounter);
        }
        return serviceCounter;
    }

    private ServiceCounter getTrackerCounter(String string) {
        ServiceCounter serviceCounter = (ServiceCounter)this.trackerCounterMap.get(string);
        if (serviceCounter == null) {
            serviceCounter = new ServiceCounter("tracking service", string);
            this.trackerCounterMap.put(string, serviceCounter);
        }
        return serviceCounter;
    }

    private CategoryDurations getCatDurations(int n) {
        Integer n2 = new Integer(n);
        CategoryDurations categoryDurations = (CategoryDurations)this.durationsMap.get(n2);
        if (categoryDurations == null) {
            categoryDurations = new CategoryDurations(n);
            this.durationsMap.put(n2, categoryDurations);
        }
        return categoryDurations;
    }

    private static class ServiceCounter
    implements Comparable {
        public static final String TYPE_SERVICE = "service";
        public static final String TYPE_TRACKER = "tracking service";
        private final String type;
        private final String ifc;
        private int counter = 0;

        public ServiceCounter(String string, String string2) {
            this.type = string;
            this.ifc = string2;
        }

        public int getValue() {
            return this.counter;
        }

        public void add(int n) {
            this.counter += n;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(32);
            Text.appendFixedNumber(stringBuffer, this.counter, 3).append("x  ");
            stringBuffer.append(this.type).append("  ").append(this.ifc);
            return stringBuffer.toString();
        }

        public int compareTo(Object object) {
            ServiceCounter serviceCounter = (ServiceCounter)object;
            return this.ifc.compareTo(serviceCounter.ifc);
        }
    }

    private static class CategoryDurations
    implements Comparable {
        private static final int ACCURACY = 4;
        private final int category;
        private int samples = 0;
        private long minDuration = Integer.MAX_VALUE;
        private long maxDuration = Integer.MIN_VALUE;
        private long sumDuration = 0L;

        public CategoryDurations(int n) {
            this.category = n;
        }

        public void addDuration(int n, long l) {
            long l2 = (l <<= 4) / (long)n;
            if (l2 < this.minDuration) {
                this.minDuration = l2;
            }
            if (l2 > this.maxDuration) {
                this.maxDuration = l2;
            }
            this.sumDuration += l;
            this.samples += n;
        }

        public long getAvgDuration() {
            return this.getAvgDuration(1);
        }

        public long getAvgDuration(int n) {
            return this.sumDuration * (long)n / (long)this.samples >> 4;
        }

        public long getMaxDuration() {
            return this.maxDuration >> 4;
        }

        public long getMinDuration() {
            return this.minDuration >> 4;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(150);
            String string = BenchmarkSuite.getCategoryName(this.category);
            stringBuffer.append("[CAT-").append(this.category).append(" ").append(string).append("] ");
            Text.fillWithSpace(stringBuffer, 36);
            Text.appendFixedNumber(stringBuffer, this.samples, 5).append(" samples ");
            stringBuffer.append("| ");
            stringBuffer.append("min: ");
            Text.appendFixedNumber(stringBuffer, this.getMinDuration(), 6).append("ms ");
            stringBuffer.append("| ");
            stringBuffer.append("avg: ");
            Text.appendFixedNumber(stringBuffer, this.getAvgDuration(), 6).append("ms/s ");
            Text.appendFixedNumber(stringBuffer, this.getAvgDuration(baseResolution), 6).append("ms/" + baseResolution + "s ");
            Text.appendFixedNumber(stringBuffer, this.getAvgDuration(baseResolution * 10), 6).append("ms/" + baseResolution * 10 + "s ");
            stringBuffer.append("| ");
            stringBuffer.append("max: ");
            Text.appendFixedNumber(stringBuffer, this.getMaxDuration(), 6).append("ms ");
            return stringBuffer.toString();
        }

        public int compareTo(Object object) {
            CategoryDurations categoryDurations = (CategoryDurations)object;
            if (this.category < categoryDurations.category) {
                return -1;
            }
            if (this.category > categoryDurations.category) {
                return 1;
            }
            return 0;
        }
    }
}

