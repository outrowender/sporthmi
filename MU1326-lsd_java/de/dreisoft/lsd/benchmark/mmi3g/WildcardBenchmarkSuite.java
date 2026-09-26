/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark.mmi3g;

import de.dreisoft.lsd.benchmark.mmi3g.BenchmarkTestService;
import de.dreisoft.lsd.benchmark.mmi3g.MMI3gBenchmarkSuite;
import de.dreisoft.lsd.benchmark.mmi3g.WildcardBenchmarkSuite$DummyServiceTrackerCustomizer;
import de.dreisoft.lsd.benchmark.mmi3g.WildcardBenchmarkSuite$Suite;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class WildcardBenchmarkSuite
extends MMI3gBenchmarkSuite {
    static /* synthetic */ Class class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService;

    private WildcardBenchmarkSuite() {
        super("MMI3g Wildcard Suite");
    }

    public static WildcardBenchmarkSuite getInstance() {
        return WildcardBenchmarkSuite$Suite.instance;
    }

    @Override
    public void runTests() {
        System.out.println(new StringBuffer().append("run ").append(this.name).append(" tests").toString());
        if (bundle != null) {
            int n;
            int n2;
            BundleContext bundleContext = bundle.getContext();
            Filter filter = null;
            int n3 = 1 * SAMPLE_MULTIPLIER;
            System.out.println(new StringBuffer().append("benchmark ").append(n3).append(" wildcard tracker").toString());
            ServiceTracker[] serviceTrackerArray = new ServiceTracker[n3];
            String string = "mx wildcard DSIListener tracker";
            String string2 = "(& (objectClass = org.dsi.ifc.*.DSIListener) (DEVICE_NAME = *))";
            try {
                filter = bundleContext.createFilter(string2);
            }
            catch (InvalidSyntaxException invalidSyntaxException) {
                invalidSyntaxException.printStackTrace();
            }
            this.setStartTag(6, n3, string);
            for (n2 = 0; n2 < n3; ++n2) {
                serviceTrackerArray[n2] = new ServiceTracker(bundleContext, filter, (ServiceTrackerCustomizer)new WildcardBenchmarkSuite$DummyServiceTrackerCustomizer(this, new StringBuffer().append(string).append(" no").append(n2).toString(), false));
            }
            this.setEndTag(6, n3, string);
            this.setStartTag(7, n3, string);
            for (n2 = 0; n2 < n3; ++n2) {
                serviceTrackerArray[n2].open();
            }
            this.setEndTag(7, n3, string);
            for (n2 = 0; n2 < n3; ++n2) {
                serviceTrackerArray[n2].close();
            }
            string2 = "(& (objectClass = *.TestService) (DEVICE_NAME = *))";
            try {
                filter = bundleContext.createFilter(string2);
            }
            catch (InvalidSyntaxException invalidSyntaxException) {
                invalidSyntaxException.printStackTrace();
            }
            serviceTrackerArray = new ServiceTracker[25];
            for (n = 0; n < 25; ++n) {
                serviceTrackerArray[n] = new ServiceTracker(bundleContext, filter, (ServiceTrackerCustomizer)new WildcardBenchmarkSuite$DummyServiceTrackerCustomizer(this, new StringBuffer().append("tracker no").append(n).toString(), false));
                serviceTrackerArray[n].open();
            }
            n3 = 1 * SAMPLE_MULTIPLIER;
            System.out.println(new StringBuffer().append("benchmark ").append(n3).append(" service registrations").toString());
            ServiceRegistration[] serviceRegistrationArray = new ServiceRegistration[n3];
            this.setStartTag(2, n3);
            for (n = 0; n < n3; ++n) {
                serviceRegistrationArray[n] = bundleContext.registerService((class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService == null ? WildcardBenchmarkSuite.class$("de.dreisoft.lsd.benchmark.mmi3g.BenchmarkTestService") : class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService).getName(), (Object)new BenchmarkTestService(), null);
            }
            this.setEndTag(2, n3);
            this.setStartTag(3, n3);
            for (n = 0; n < n3; ++n) {
                serviceRegistrationArray[n].unregister();
            }
            this.setEndTag(3, n3);
            for (n = 0; n < 25; ++n) {
                serviceTrackerArray[n].close();
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

