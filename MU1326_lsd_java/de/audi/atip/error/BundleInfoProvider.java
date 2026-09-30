/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.base.IFrameworkAccess;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.Dictionary;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;

public class BundleInfoProvider
implements DumpInfoProvider {
    private IFrameworkAccess fw;

    BundleInfoProvider(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
    }

    public String getName() {
        return "BundleInfos";
    }

    String getBundleState(Bundle bundle) {
        switch (bundle.getState()) {
            case 2: {
                return "INSTALLED";
            }
            case 4: {
                return "RESOLVED";
            }
            case 8: {
                return "STARTING";
            }
            case 16: {
                return "STOPPING";
            }
            case 1: {
                return "UNINSTALLED";
            }
            case 32: {
                return "ACTIVE";
            }
        }
        return "?";
    }

    public void printBundleInformation(Bundle bundle, PrintStream printStream) {
        Dictionary dictionary = bundle.getHeaders();
        ServiceReference[] serviceReferenceArray = null;
        printStream.println("\n===== Bundle \"" + dictionary.get("Bundle-Name") + "\" =====");
        printStream.println("\tID: " + bundle.getBundleId());
        printStream.println("\tState: " + this.getBundleState(bundle));
        printStream.println("\tBundle-Activator:" + dictionary.get("Bundle-Activator"));
        if (Boolean.getBoolean("DumpExtendedBundleInformation")) {
            int n;
            printStream.println("\tService References: ");
            serviceReferenceArray = bundle.getRegisteredServices();
            if (serviceReferenceArray != null) {
                for (n = 0; n < serviceReferenceArray.length; ++n) {
                    printStream.println("\t\t<- " + serviceReferenceArray[n].toString());
                }
            }
            printStream.println("\tServices In Use: ");
            serviceReferenceArray = bundle.getServicesInUse();
            if (serviceReferenceArray != null) {
                for (n = 0; n < serviceReferenceArray.length; ++n) {
                    printStream.println("\t\t-> " + serviceReferenceArray[n].toString());
                }
            }
        }
    }

    public void dump(PrintStream printStream, String string) {
        Bundle[] bundleArray = this.fw.getBundleCxt().getBundles();
        for (int i2 = 0; i2 < bundleArray.length; ++i2) {
            this.printBundleInformation(bundleArray[i2], printStream);
        }
    }
}

