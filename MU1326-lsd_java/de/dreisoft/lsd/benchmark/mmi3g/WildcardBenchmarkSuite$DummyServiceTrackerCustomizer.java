/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark.mmi3g;

import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.benchmark.mmi3g.WildcardBenchmarkSuite;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class WildcardBenchmarkSuite$DummyServiceTrackerCustomizer
implements ServiceTrackerCustomizer {
    private final String name;
    private final boolean setTags;
    private final /* synthetic */ WildcardBenchmarkSuite this$0;

    public WildcardBenchmarkSuite$DummyServiceTrackerCustomizer(WildcardBenchmarkSuite wildcardBenchmarkSuite, String string, boolean bl) {
        this.this$0 = wildcardBenchmarkSuite;
        this.name = string;
        this.setTags = bl;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ServiceInfo serviceInfo = (ServiceInfo)serviceReference;
        serviceInfo.getServiceInterfaces();
        long l = serviceInfo.getServiceID();
        if (this.setTags) {
            this.this$0.setTag(8, new StringBuffer().append(this.name).append(": service s").append(l).append(" added").toString());
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

