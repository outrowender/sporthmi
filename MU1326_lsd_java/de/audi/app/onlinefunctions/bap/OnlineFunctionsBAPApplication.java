/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.onlinefunctions.bap.DSIOnlineTrafficLightInfoListenerImpl;
import de.audi.app.onlinefunctions.bap.LoggerOnlineFunctionsBAP;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.base.IFrameworkAccess;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineTrafficLightInfo;
import org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OnlineFunctionsBAPApplication
extends AbstractBAPApplication
implements ServiceTrackerCustomizer {
    private DSIOnlineTrafficLightInfoListener dsiTrafficLightInfoListener = new DSIOnlineTrafficLightInfoListenerImpl(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo;

    protected OnlineFunctionsBAPApplication(IFrameworkAccess iFrameworkAccess, LoggerOnlineFunctionsBAP loggerOnlineFunctionsBAP) {
        super(iFrameworkAccess, loggerOnlineFunctionsBAP);
        this.logChannel.log(1078071040, " OnlineFunctionsBAPApplication has been started ");
    }

    public OnlineFunctionsBAPApplication(IFrameworkAccess iFrameworkAccess) {
        this(iFrameworkAccess, new LoggerOnlineFunctionsBAP(iFrameworkAccess));
    }

    @Override
    public String getName() {
        return "OnlineFunctionsBAPApplication";
    }

    @Override
    protected void activate(AbstractActivator abstractActivator) {
        super.activate(abstractActivator);
        if (this.dsiTrafficLightInfoListener != null) {
            this.registerDSIListener(abstractActivator);
        }
    }

    private void registerDSIListener(AbstractActivator abstractActivator) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener == null ? (class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener = OnlineFunctionsBAPApplication.class$("org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener")) : class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        hashtable.put("moduleID", new Integer(20));
        this.logChannel.log(1078071040, "[OnlineFunctionsBAPApplication#registerDSIListener] Registering %1", (Object)super.getClass());
        abstractActivator.registerService((class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener == null ? (class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener = OnlineFunctionsBAPApplication.class$("org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener")) : class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener).getName(), (Object)this.dsiTrafficLightInfoListener, (Dictionary)hashtable);
    }

    public DSIOnlineTrafficLightInfoListener getDSITrafficLightInfoListener() {
        return this.dsiTrafficLightInfoListener;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.logChannel.log(1078071040, "[OnlineFunctionsBAPApplication#addingService] called");
        Object object = this.getFrameworkAccess().getBundleCxt().getService(serviceReference);
        if ((class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo == null ? (class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo = OnlineFunctionsBAPApplication.class$("org.dsi.ifc.online.DSIOnlineTrafficLightInfo")) : class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo).isAssignableFrom(object.getClass())) {
            DSIOnlineTrafficLightInfo dSIOnlineTrafficLightInfo = (DSIOnlineTrafficLightInfo)object;
            dSIOnlineTrafficLightInfo.setNotification(new int[]{1, 2, 3}, (DSIListener)this.dsiTrafficLightInfoListener);
            this.logChannel.log(-2137614336, "[OnlineFunctionsBAPApplication#addingService] DSI notified");
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.logChannel.log(1078071040, " OnlineFunctionsBAPApplication#removedService() service removed");
        this.getFrameworkAccess().getBundleCxt().ungetService(serviceReference);
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

