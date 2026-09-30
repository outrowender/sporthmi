/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark.mmi3g;

import de.dreisoft.lsd.ServiceRegistry;
import de.dreisoft.lsd.benchmark.BenchmarkResult;
import de.dreisoft.lsd.benchmark.BenchmarkSuite;
import de.dreisoft.lsd.benchmark.mmi3g.BasicBenchmarkSuite;
import de.dreisoft.lsd.benchmark.mmi3g.BenchmarkBundle;
import de.dreisoft.lsd.benchmark.mmi3g.FilterBenchmarkSuite;
import de.dreisoft.lsd.benchmark.mmi3g.WildcardBenchmarkSuite;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.osgi.service.log.LogService;

public abstract class MMI3gBenchmarkSuite
extends BenchmarkSuite {
    protected static BenchmarkBundle bundle;
    public static final int TARGET_PC = 1;
    public static final int TARGET_BECKER = 2;
    public static final int TARGET;
    protected static final int SAMPLE_MULTIPLIER;
    private static List suites;

    public static int getTarget() {
        return TARGET;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MMI3gBenchmarkSuite(String string) {
        super(string);
        List list = suites;
        synchronized (list) {
            suites.add(this);
        }
    }

    static void setBundle(BenchmarkBundle benchmarkBundle) {
        bundle = benchmarkBundle;
    }

    static void bundleStarted() {
        BasicBenchmarkSuite.getInstance();
        WildcardBenchmarkSuite.getInstance();
        FilterBenchmarkSuite.getInstance();
    }

    static void bundleStopped() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void runAllTests() {
        List list = suites;
        synchronized (list) {
            for (int i2 = 0; i2 < suites.size(); ++i2) {
                System.out.println();
                BenchmarkSuite benchmarkSuite = (BenchmarkSuite)suites.get(i2);
                benchmarkSuite.runTests();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void analyzeAll() {
        List list = suites;
        synchronized (list) {
            for (int i2 = 0; i2 < suites.size(); ++i2) {
                BenchmarkSuite benchmarkSuite = (BenchmarkSuite)suites.get(i2);
                benchmarkSuite.analyze();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void printAllResults() {
        List list = suites;
        synchronized (list) {
            for (int i2 = 0; i2 < suites.size(); ++i2) {
                BenchmarkSuite benchmarkSuite = (BenchmarkSuite)suites.get(i2);
                benchmarkSuite.printResults();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void printAllResults(PrintStream printStream) {
        List list = suites;
        synchronized (list) {
            for (int i2 = 0; i2 < suites.size(); ++i2) {
                BenchmarkSuite benchmarkSuite = (BenchmarkSuite)suites.get(i2);
                benchmarkSuite.printResults(printStream);
            }
        }
    }

    static {
        suites = new ArrayList(10);
        if (System.getProperty("os.name").toLowerCase().indexOf("qnx") >= 0) {
            TARGET = 2;
            SAMPLE_MULTIPLIER = 100;
        } else {
            TARGET = 1;
            SAMPLE_MULTIPLIER = 1000;
        }
        BenchmarkResult.setBaseResolution(SAMPLE_MULTIPLIER);
    }

    protected static class LSDFramework
    extends de.dreisoft.lsd.LSDFramework {
        protected LSDFramework() {
        }

        public static ServiceRegistry getServiceRegistry() {
            return serviceRegistry;
        }

        public static LogService getLogService() {
            return logService;
        }
    }
}

