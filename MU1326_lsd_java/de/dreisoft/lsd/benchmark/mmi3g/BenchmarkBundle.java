/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark.mmi3g;

import de.dreisoft.lsd.benchmark.mmi3g.BasicBenchmarkSuite;
import de.dreisoft.lsd.benchmark.mmi3g.MMI3gBenchmarkSuite;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BenchmarkBundle
implements BundleActivator {
    BasicBenchmarkSuite basicSuite = BasicBenchmarkSuite.getInstance();
    private BundleContext bundleContext;

    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        MMI3gBenchmarkSuite.setBundle(this);
        BasicBenchmarkSuite.getInstance().setEndTag(1);
        MMI3gBenchmarkSuite.bundleStarted();
    }

    public void stop(BundleContext bundleContext) {
        this.bundleContext = null;
    }

    public BundleContext getContext() {
        return this.bundleContext;
    }
}

