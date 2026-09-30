/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.FrameworkAccess;
import de.audi.atip.config.carcoding.CodingReader;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.sysapp.carcoding.ICodingReader;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.lang.reflect.Field;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SysConstProvider
implements ServiceTrackerCustomizer {
    private volatile ISysConstManager sysConstManager;
    private BundleContext context;
    private SimpleIntIntMap sysConst2ValueIntMap;
    private ICodingReader codingReader;
    private FrameworkAccess frameworkAccess;
    private LogChannel log;
    static /* synthetic */ Class class$de$audi$atip$sysconfig$ICoreSysConfig;
    static /* synthetic */ Class class$de$audi$atip$sysapp$carcoding$ISysConstManager;

    public SysConstProvider(BundleContext bundleContext, FrameworkAccess frameworkAccess) {
        Object object;
        this.context = bundleContext;
        this.frameworkAccess = frameworkAccess;
        this.log = frameworkAccess.getLogChannel("Fw.Config.SysConstProvider");
        try {
            object = (class$de$audi$atip$sysconfig$ICoreSysConfig == null ? (class$de$audi$atip$sysconfig$ICoreSysConfig = SysConstProvider.class$("de.audi.atip.sysconfig.ICoreSysConfig")) : class$de$audi$atip$sysconfig$ICoreSysConfig).getFields();
            this.sysConst2ValueIntMap = new SimpleIntIntMap();
            Object object2 = new Object();
            for (int i2 = 0; i2 < ((Field[])object).length; ++i2) {
                Integer n;
                int n2 = object[i2].getInt(object2);
                if (n2 <= 50 || (n = Integer.getInteger(object[i2].getName())) == null) continue;
                this.sysConst2ValueIntMap.add(n2, n);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw new FrameworkException("Error in SysConstProvider init!");
        }
        object = new ServiceTracker(this.context, (class$de$audi$atip$sysapp$carcoding$ISysConstManager == null ? (class$de$audi$atip$sysapp$carcoding$ISysConstManager = SysConstProvider.class$("de.audi.atip.sysapp.carcoding.ISysConstManager")) : class$de$audi$atip$sysapp$carcoding$ISysConstManager).getName(), (ServiceTrackerCustomizer)this);
        ((ServiceTracker)object).open();
    }

    private int getEarlyAccessValue(int n) {
        int n2 = -1;
        ICodingReader iCodingReader = this.getCodingReader();
        Coding coding = null;
        if (iCodingReader != null) {
            coding = iCodingReader.getCarCoding();
        }
        switch (n) {
            case 541: {
                int n3 = this.getCodingReader().getAdaptationANP().getNavMapTransmissionMode();
                int n4 = this.getCodingReader().getAdaptationANP().getNavKDKTransmissionMode();
                if (n3 == 3 || n4 == 3) {
                    n2 = 2;
                    break;
                }
                if (n3 == 2 || n4 == 2) {
                    n2 = 1;
                    break;
                }
                n2 = 0;
                break;
            }
            case 4168: {
                if (coding == null) break;
                n2 = coding.getCarBrand();
                break;
            }
            case 466: {
                if (coding == null) break;
                n2 = coding.getCarClass();
                break;
            }
            case 469: {
                if (coding == null) break;
                n2 = coding.getCarGeneration();
                break;
            }
            case 467: {
                if (coding == null) break;
                n2 = coding.getCarDerivate();
                break;
            }
            case 474: {
                n2 = this.getCodingReader().getAdaptationANP().isRemoteHmiAvailable() ? 1 : 0;
                break;
            }
            case 464: {
                n2 = coding.getDriverSide();
                break;
            }
        }
        return n2;
    }

    private ICodingReader getCodingReader() {
        if (this.codingReader == null) {
            this.codingReader = new CodingReader(this.frameworkAccess);
        }
        return this.codingReader;
    }

    public int getSysConst(int n) {
        if (this.sysConstManager != null) {
            return this.sysConstManager.getSysConst(n);
        }
        this.log.log(100000, "Early acess to SysConst: Index %1", (long)n);
        int n2 = this.sysConst2ValueIntMap.get(n);
        if (n2 != -1) {
            return n2;
        }
        int n3 = this.getEarlyAccessValue(n);
        if (n3 != -1) {
            return n3;
        }
        throw new FrameworkException("ISysConstManager service not available!");
    }

    public ISysConstManager getSysConstManager() {
        if (this.sysConstManager == null) {
            throw new FrameworkException("ISysConstManager service not available!");
        }
        return this.sysConstManager;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.context.getService(serviceReference);
        if (object instanceof ISysConstManager) {
            this.log.log(10000000, "The ISysConstManager was added to the SysConstProvider");
            this.sysConstManager = (ISysConstManager)object;
            this.sysConstManager.initSysConstants(this.sysConst2ValueIntMap, this.getCodingReader());
            return object;
        }
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
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

