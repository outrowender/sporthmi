/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

final class BundleHandler {
    private BundleContext bc = null;
    private LogChannel log = null;
    private Map bundleMap = null;

    BundleHandler(BundleContext bundleContext, LogChannel logChannel) {
        this.bc = bundleContext;
        this.log = logChannel;
        this.initBundleMap();
    }

    final String getBundleName(Bundle bundle) {
        return bundle == null ? null : (String)bundle.getHeaders().get("Bundle-Name");
    }

    private final void initBundleMap() {
        Bundle[] bundleArray = this.bc.getBundles();
        this.bundleMap = new HashMap((int)Math.ceil((double)bundleArray.length / 0.75) + 1);
        for (int i2 = 0; i2 < bundleArray.length; ++i2) {
            Bundle bundle = bundleArray[i2];
            String string = this.getBundleName(bundle);
            if (string == null) continue;
            this.bundleMap.put(string, bundle);
        }
    }

    Bundle getBundle(String string) {
        return (Bundle)this.bundleMap.get(string);
    }

    void startBundle(Bundle bundle) throws BundleException {
        if (bundle == null) {
            return;
        }
        if (bundle.getState() < 4) {
            throw new BundleException("Bundle " + this.getBundleName(bundle) + " is not (yet) resolved!");
        }
        if (bundle.getState() != 32) {
            this.log.log(10000000, "BundleHandler: startBundle: %1 ", (Object)this.getBundleName(bundle));
            try {
                bundle.start();
            }
            catch (NoClassDefFoundError noClassDefFoundError) {
                throw new BundleException("Start of bundle " + this.getBundleName(bundle) + " failed due to undefined class!", noClassDefFoundError);
            }
        }
    }

    void stopBundle(Bundle bundle) throws BundleException {
        if (bundle == null) {
            return;
        }
        if (bundle.getState() < 4) {
            throw new BundleException("Bundle " + bundle.getBundleId() + " is not (yet) resolved!");
        }
        if (bundle.getState() != 4) {
            this.log.log(10000000, "BundleHandler: stopBundle: %1", (Object)this.getBundleName(bundle));
            try {
                bundle.stop();
            }
            catch (NoClassDefFoundError noClassDefFoundError) {
                throw new BundleException("Stop of bundle " + this.getBundleName(bundle) + " failed due to undefined class!", noClassDefFoundError);
            }
        }
    }
}

