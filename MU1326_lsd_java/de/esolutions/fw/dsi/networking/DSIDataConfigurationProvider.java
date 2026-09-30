/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.networking;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.networking.DSIDataConfigurationReply;
import de.esolutions.fw.comm.dsi.networking.impl.DSIDataConfigurationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.DSIDataConfiguration;
import org.osgi.framework.BundleContext;

public class DSIDataConfigurationProvider
extends AbstractProvider
implements DSIDataConfiguration {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 6, 9, 12};
    private DSIDataConfigurationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfiguration;

    public DSIDataConfigurationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$networking$DSIDataConfiguration == null ? (class$org$dsi$ifc$networking$DSIDataConfiguration = DSIDataConfigurationProvider.class$("org.dsi.ifc.networking.DSIDataConfiguration")) : class$org$dsi$ifc$networking$DSIDataConfiguration).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSIDataConfigurationProxy(this.instance, (DSIDataConfigurationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void setDataProfile(CDataProfile cDataProfile) {
        try {
            this.proxy.setDataProfile(cDataProfile);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void automaticProfile(int n) {
        try {
            this.proxy.automaticProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setRoamingState(int n) {
        try {
            this.proxy.setRoamingState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setConnectionMode(int n) {
        try {
            this.proxy.setConnectionMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setRequestSetting(int n, int n2) {
        try {
            this.proxy.setRequestSetting(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void acceptDataRequest(int n, boolean bl) {
        try {
            this.proxy.acceptDataRequest(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void resetPacketCounter() {
        try {
            this.proxy.resetPacketCounter();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void restoreFactorySettings() {
        try {
            this.proxy.restoreFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
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

