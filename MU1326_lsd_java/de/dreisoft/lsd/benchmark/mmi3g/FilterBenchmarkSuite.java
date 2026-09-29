/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark.mmi3g;

import de.dreisoft.lsd.benchmark.mmi3g.FilterBenchmarkSuite$DummyServiceTrackerCustomizer;
import de.dreisoft.lsd.benchmark.mmi3g.FilterBenchmarkSuite$Suite;
import de.dreisoft.lsd.benchmark.mmi3g.MMI3gBenchmarkSuite;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class FilterBenchmarkSuite
extends MMI3gBenchmarkSuite {
    private FilterBenchmarkSuite() {
        super("MMI3g Filter Suite");
    }

    public static FilterBenchmarkSuite getInstance() {
        return FilterBenchmarkSuite$Suite.instance;
    }

    @Override
    public void runTests() {
        System.out.println(new StringBuffer().append("run ").append(this.name).append(" tests").toString());
        if (bundle != null) {
            int n;
            BundleContext bundleContext = bundle.getContext();
            Filter filter = null;
            Filter[] filterArray = null;
            int n2 = 10 * SAMPLE_MULTIPLIER;
            System.out.println(new StringBuffer().append("benchmark ").append(n2).append(" filter").toString());
            filterArray = new Filter[n2];
            String string = "(& (objectClass = org.dsi.ifc.base.DSIListener) (|(DEVICE_NAME = org.dsi.ifc.mediaplayer.DSIMediaPlayerListener)  (DEVICE_NAME = org.dsi.ifc.tvtuner.DSITVTunerListener)  (DEVICE_NAME = org.dsi.ifc.amfmtuner.DSIAmFmTunerListener)  (DEVICE_NAME = org.dsi.ifc.audiomanagement.DSIAudioManagementListener)  (DEVICE_NAME = org.dsi.ifc.sound.DSISoundListener)))";
            this.setStartTag(4, n2, string);
            for (int i2 = 0; i2 < n2; ++i2) {
                try {
                    filterArray[i2] = bundleContext.createFilter(string);
                    continue;
                }
                catch (InvalidSyntaxException invalidSyntaxException) {
                    invalidSyntaxException.printStackTrace();
                }
            }
            this.setEndTag(4, n2, string);
            Hashtable hashtable = new Hashtable();
            ((Dictionary)hashtable).put("objectClass", new String[]{"org.dsi.ifc.base.DSIListener"});
            ((Dictionary)hashtable).put("DEVICE_NAME", "org.dsi.ifc.mediaplayer.DSIMediaPlayerListener");
            this.setStartTag(5, n2, string);
            for (int i3 = 0; i3 < n2; ++i3) {
                filterArray[i3].match(hashtable);
            }
            this.setEndTag(5, n2, string);
            n2 = 1 * SAMPLE_MULTIPLIER;
            System.out.println(new StringBuffer().append("benchmark ").append(n2).append(" filtered trackers").toString());
            ServiceTracker[] serviceTrackerArray = new ServiceTracker[n2];
            String string2 = "mx filtered DSIListener tracker";
            string = "(& (objectClass = org.dsi.ifc.base.DSIListener) (|(DEVICE_NAME = org.dsi.ifc.mediaplayer.DSIMediaPlayerListener)  (DEVICE_NAME = org.dsi.ifc.tvtuner.DSITVTunerListener)  (DEVICE_NAME = org.dsi.ifc.amfmtuner.DSIAmFmTunerListener)  (DEVICE_NAME = org.dsi.ifc.audiomanagement.DSIAudioManagementListener)  (DEVICE_NAME = org.dsi.ifc.sound.DSISoundListener)))";
            try {
                filter = bundleContext.createFilter(string);
            }
            catch (InvalidSyntaxException invalidSyntaxException) {
                invalidSyntaxException.printStackTrace();
            }
            this.setStartTag(6, n2, string2);
            for (n = 0; n < n2; ++n) {
                serviceTrackerArray[n] = new ServiceTracker(bundleContext, filter, (ServiceTrackerCustomizer)new FilterBenchmarkSuite$DummyServiceTrackerCustomizer(this, new StringBuffer().append(string2).append(" no").append(n).toString(), false));
            }
            this.setEndTag(6, n2, string2);
            this.setStartTag(7, n2, string2);
            for (n = 0; n < n2; ++n) {
                serviceTrackerArray[n].open();
            }
            this.setEndTag(7, n2, string2);
            for (n = 0; n < n2; ++n) {
                serviceTrackerArray[n].close();
            }
        }
    }
}

