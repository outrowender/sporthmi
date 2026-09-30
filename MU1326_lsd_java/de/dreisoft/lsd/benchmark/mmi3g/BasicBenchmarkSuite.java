/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark.mmi3g;

import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceRegistry;
import de.dreisoft.lsd.benchmark.mmi3g.BenchmarkTestService;
import de.dreisoft.lsd.benchmark.mmi3g.MMI3gBenchmarkSuite;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class BasicBenchmarkSuite
extends MMI3gBenchmarkSuite {
    static /* synthetic */ Class class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService;

    private BasicBenchmarkSuite() {
        super("MMI3g Basic Suite");
    }

    public static BasicBenchmarkSuite getInstance() {
        return Suite.instance;
    }

    public void runTests() {
        System.out.println(new StringBuffer().append("run ").append(this.name).append(" tests").toString());
        if (bundle != null) {
            int n;
            int n2;
            Object object;
            Filter[] filterArray;
            String string;
            BundleContext bundleContext = bundle.getContext();
            ServiceRegistry serviceRegistry = MMI3gBenchmarkSuite.LSDFramework.getServiceRegistry();
            Set set = serviceRegistry.getServiceInterfaces();
            this.setCountTag(10, serviceRegistry.getObservers("*").size(), "*");
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                string = (String)iterator.next();
                filterArray = serviceRegistry.getServiceInfos(string);
                this.setCountTag(9, filterArray.size(), string);
                object = serviceRegistry.getObservers(string);
                this.setCountTag(10, object.size(), string);
            }
            filterArray = null;
            int n3 = 1 * SAMPLE_MULTIPLIER;
            System.out.println(new StringBuffer().append("benchmark ").append(n3).append(" simple trackers").toString());
            ServiceTracker[] serviceTrackerArray = new ServiceTracker[n3];
            object = "mx simple DSIListener tracker";
            this.setStartTag(6, n3, (String)object);
            for (n2 = 0; n2 < n3; ++n2) {
                serviceTrackerArray[n2] = new ServiceTracker(bundleContext, "org.dsi.ifc.base.DSIListener", (ServiceTrackerCustomizer)new DummyServiceTrackerCustomizer(new StringBuffer().append((String)object).append(" no").append(n2).toString(), false));
            }
            this.setEndTag(6, n3, (String)object);
            this.setStartTag(7, n3, (String)object);
            for (n2 = 0; n2 < n3; ++n2) {
                serviceTrackerArray[n2].open();
            }
            this.setEndTag(7, n3, (String)object);
            for (n2 = 0; n2 < n3; ++n2) {
                serviceTrackerArray[n2].close();
            }
            n3 = 10 * SAMPLE_MULTIPLIER;
            System.out.println(new StringBuffer().append("benchmark ").append(n3).append(" filter").toString());
            filterArray = new Filter[n3];
            string = "(& (objectClass = org.dsi.ifc.*.DSIListener) (DEVICE_NAME = *))";
            this.setStartTag(4, n3, string);
            for (n2 = 0; n2 < n3; ++n2) {
                try {
                    filterArray[n2] = bundleContext.createFilter(string);
                    continue;
                }
                catch (InvalidSyntaxException invalidSyntaxException) {
                    invalidSyntaxException.printStackTrace();
                }
            }
            this.setEndTag(4, n3, string);
            Hashtable hashtable = new Hashtable();
            ((Dictionary)hashtable).put("objectClass", new String[]{"org.dsi.ifc.base.DSIListener"});
            ((Dictionary)hashtable).put("DEVICE_NAME", "org.dsi.ifc.mediaplayer.DSIMediaPlayerListener");
            this.setStartTag(5, n3, string);
            for (n = 0; n < n3; ++n) {
                filterArray[n].match(hashtable);
            }
            this.setEndTag(5, n3, string);
            serviceTrackerArray = new ServiceTracker[25];
            for (n = 0; n < 25; ++n) {
                serviceTrackerArray[n] = new ServiceTracker(bundleContext, (class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService == null ? BasicBenchmarkSuite.class$("de.dreisoft.lsd.benchmark.mmi3g.BenchmarkTestService") : class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService).getName(), (ServiceTrackerCustomizer)new DummyServiceTrackerCustomizer(new StringBuffer().append("tracker no").append(n).toString(), false));
                serviceTrackerArray[n].open();
            }
            n3 = 1 * SAMPLE_MULTIPLIER;
            System.out.println(new StringBuffer().append("benchmark ").append(n3).append(" service registrations").toString());
            ServiceRegistration[] serviceRegistrationArray = new ServiceRegistration[n3];
            this.setStartTag(2, n3);
            for (n = 0; n < n3; ++n) {
                serviceRegistrationArray[n] = bundleContext.registerService((class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService == null ? BasicBenchmarkSuite.class$("de.dreisoft.lsd.benchmark.mmi3g.BenchmarkTestService") : class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService).getName(), (Object)new BenchmarkTestService(), null);
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

    private static class Suite {
        public static BasicBenchmarkSuite instance = new BasicBenchmarkSuite();

        private Suite() {
        }
    }

    private class DummyServiceTrackerCustomizer
    implements ServiceTrackerCustomizer {
        private final String name;
        private final boolean setTags;

        public DummyServiceTrackerCustomizer(String string, boolean bl) {
            this.name = string;
            this.setTags = bl;
        }

        public Object addingService(ServiceReference serviceReference) {
            ServiceInfo serviceInfo = (ServiceInfo)serviceReference;
            serviceInfo.getServiceInterfaces();
            long l = serviceInfo.getServiceID();
            if (this.setTags) {
                BasicBenchmarkSuite.this.setTag(8, new StringBuffer().append(this.name).append(": service s").append(l).append(" added").toString());
            }
            return null;
        }

        public void modifiedService(ServiceReference serviceReference, Object object) {
        }

        public void removedService(ServiceReference serviceReference, Object object) {
        }
    }
}

