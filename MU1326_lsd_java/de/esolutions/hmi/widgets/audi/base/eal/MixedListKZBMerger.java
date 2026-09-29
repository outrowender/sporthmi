/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IMixedListCallback;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger$1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MixedListKZBMerger {
    public static boolean kzbMerged = false;
    public static boolean isIconExtractorInitialized = false;
    private static EALManager ealManager;
    private static ServiceTracker hmiBundleTracker;
    public static Map mixedListCallbackListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIBundle;

    public static void kZBMergedCallback(String string) {
        INode2D iNode2D = ealManager.getProject().getNode2D(string);
        if (iNode2D == null) {
            IWidgetLogChannel.mixedListLogChannel.log(10000, "MixedListKZBMerger#kZBMergedCallback Merging KZB failed.");
        } else {
            ealManager.getMasterRoot().addAuto(iNode2D, -50);
            iNode2D.dispose();
            IWidgetLogChannel.mixedListLogChannel.log(-2137614336, "MixedListKZBMerger#kZBMergedCallback Merging successful.");
            kzbMerged = true;
        }
        Iterator iterator = mixedListCallbackListener.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            IMixedListCallback iMixedListCallback = (IMixedListCallback)map$Entry.getValue();
            iMixedListCallback.kZBMergedCallback(kzbMerged);
        }
    }

    public static void mergeKZBAsync(int n, int n2, EALManager eALManager) {
        IWidgetLogChannel.mixedListLogChannel.log(-2137614336, "MixedListKZBMerger#mergeKZBAsync");
        ealManager = eALManager;
        if (!kzbMerged && ealManager != null) {
            IWidgetLogChannel.mixedListLogChannel.log(-2137614336, "MixedListKZBMerger#mergeKZBAsync Start merging.");
            ealManager.mergeProjectAsync(n, -50, n2);
        }
    }

    public static void startTrackingAndMerge(BundleContext bundleContext, EALManager eALManager) {
        if (AbstractWidget.framework.isTarget()) {
            IWidgetLogChannel.mixedListLogChannel.log(-2137614336, "MixedListKZBMerger#startTrackingAndMerge");
            hmiBundleTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$hmi$HMIBundle == null ? (class$de$audi$atip$hmi$HMIBundle = MixedListKZBMerger.class$("de.audi.atip.hmi.HMIBundle")) : class$de$audi$atip$hmi$HMIBundle).getName(), (ServiceTrackerCustomizer)new MixedListKZBMerger$1());
            hmiBundleTracker.open();
        }
    }

    public static void addCallbackListener(IMixedListCallback iMixedListCallback) {
        if (mixedListCallbackListener != null && !mixedListCallbackListener.containsKey(iMixedListCallback)) {
            mixedListCallbackListener.put(iMixedListCallback, iMixedListCallback);
        }
    }

    public static void removeCallbackListener(IMixedListCallback iMixedListCallback) {
        if (mixedListCallbackListener != null && mixedListCallbackListener.containsKey(iMixedListCallback)) {
            mixedListCallbackListener.remove(iMixedListCallback);
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

    static /* synthetic */ ServiceTracker access$000() {
        return hmiBundleTracker;
    }

    static {
        mixedListCallbackListener = new HashMap();
    }
}

