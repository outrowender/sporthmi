/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.dumper;

import de.esolutions.graphics.eal.dumper.DumpInfoProvider;
import java.util.Dictionary;
import java.util.Properties;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator
implements BundleActivator {
    private ServiceRegistration dipServiceReg;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;

    public void start(BundleContext bundleContext) throws Exception {
        DumpInfoProvider dumpInfoProvider = new DumpInfoProvider();
        Properties properties = new Properties();
        this.dipServiceReg = bundleContext.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = Activator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)dumpInfoProvider, (Dictionary)properties);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        if (this.dipServiceReg != null) {
            this.dipServiceReg.unregister();
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

