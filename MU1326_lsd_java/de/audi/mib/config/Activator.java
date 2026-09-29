/*
 * Decompiled with CFR 0.152.
 */
package de.audi.mib.config;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.audi.mib.config.SysConstManagerEvoHighScale;
import org.osgi.framework.BundleContext;

public class Activator
extends AbstractActivator {
    private ISysConstManager manager;
    private LogChannel lc;
    static /* synthetic */ Class class$de$audi$atip$sysapp$carcoding$ISysConstManager;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.lc = this.framework.getLogChannel("Fw.Config.Mngr");
        this.manager = new SysConstManagerEvoHighScale(this.framework, this.isScale());
        this.registerService((class$de$audi$atip$sysapp$carcoding$ISysConstManager == null ? (class$de$audi$atip$sysapp$carcoding$ISysConstManager = Activator.class$("de.audi.atip.sysapp.carcoding.ISysConstManager")) : class$de$audi$atip$sysapp$carcoding$ISysConstManager).getName(), (Object)this.manager, null);
    }

    private boolean isScale() {
        String string = this.readString(-1945800920, 12, "FMU-HS-TND-EU-AU-MQB");
        this.lc.log(-2137614336, "ATIPConfigEvoHighScaleActivator#readVersionInfo: %1 )", (Object)string);
        return string.indexOf("-HS-") >= 0;
    }

    private String readString(int n, int n2, String string) {
        return this.framework.getStorageMgr().getString(n, n2, string);
    }

    private byte[] readBytes(int n, int n2, byte[] byArray) {
        return this.framework.getStorageMgr().getByteArray(n, n2, byArray);
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

