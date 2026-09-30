/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.IServiceDelegateConfigurator;
import de.dreisoft.lsd.IServiceDelegator;
import de.dreisoft.lsd.ServiceInfo;
import java.util.Dictionary;
import org.osgi.framework.ServiceRegistration;

public final class ServiceDelegator
implements IServiceDelegator {
    private BundleInfo mBundleInfo;
    public static final String PROP_KEY_DELEGATE_CONFIGURATOR = "de.audi.tghu.serviceDelegateConfigurator";
    private static final String DEFAULT_CONFIGURATOR_CLASS = "de.audi.tghu.dsitrace.TraceConfigurator";
    private static IServiceDelegateConfigurator configurator;
    static /* synthetic */ Class class$de$dreisoft$lsd$IServiceDelegateConfigurator;

    public static ServiceInfo getServiceInfo(BundleInfo bundleInfo, String string, Object object, Dictionary dictionary) {
        return ServiceDelegator.getServiceInfo(bundleInfo, new String[]{string}, object, dictionary);
    }

    public static ServiceInfo getServiceInfo(BundleInfo bundleInfo, String[] stringArray, Object object, Dictionary dictionary) {
        ServiceRegistration serviceRegistration;
        if (configurator != null && (serviceRegistration = configurator.getServiceRegistration(new ServiceDelegator(bundleInfo), stringArray, object, dictionary)) != null) {
            return (ServiceInfo)serviceRegistration;
        }
        return new ServiceInfo(bundleInfo, stringArray, object, dictionary);
    }

    private ServiceDelegator(BundleInfo bundleInfo) {
        this.mBundleInfo = bundleInfo;
    }

    public ServiceRegistration createServiceRegistration(String string, Object object, Dictionary dictionary) {
        return new ServiceInfo(this.mBundleInfo, string, object, dictionary);
    }

    public ServiceRegistration createServiceRegistration(String[] stringArray, Object object, Dictionary dictionary) {
        return new ServiceInfo(this.mBundleInfo, stringArray, object, dictionary);
    }

    static void initConfigurator(String string) {
        if (string != null) {
            System.out.println(new StringBuffer().append("Installing service delegator: ").append(string).toString());
            try {
                Class clazz = Class.forName(string);
                if (clazz != null && (class$de$dreisoft$lsd$IServiceDelegateConfigurator == null ? (class$de$dreisoft$lsd$IServiceDelegateConfigurator = ServiceDelegator.class$("de.dreisoft.lsd.IServiceDelegateConfigurator")) : class$de$dreisoft$lsd$IServiceDelegateConfigurator).isAssignableFrom(clazz)) {
                    Object object = clazz.newInstance();
                    IServiceDelegateConfigurator iServiceDelegateConfigurator = (IServiceDelegateConfigurator)object;
                    iServiceDelegateConfigurator.initConfigurator();
                    configurator = iServiceDelegateConfigurator;
                }
            }
            catch (Exception exception) {
                configurator = null;
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

