/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.audio;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.audio.DSIAudioManagementReply;
import de.esolutions.fw.comm.dsi.audio.impl.DSIAudioManagementProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.osgi.framework.BundleContext;

public class DSIAudioManagementProvider
extends AbstractProvider
implements DSIAudioManagement {
    private static final int[] attributeIDs = new int[]{1, 2, 3};
    private DSIAudioManagementProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagement;

    public DSIAudioManagementProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = DSIAudioManagementProvider.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSIAudioManagementProxy(this.instance, (DSIAudioManagementReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void fadeToConnection(int n, int n2) {
        try {
            this.proxy.fadeToConnection(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void releaseConnection(int n, int n2) {
        try {
            this.proxy.releaseConnection(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getActiveConnection(int n) {
        try {
            this.proxy.getActiveConnection(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getActiveEntertainmentConnection(int n) {
        try {
            this.proxy.getActiveEntertainmentConnection(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestConnection(int n, int n2, int n3) {
        try {
            this.proxy.requestConnection(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setVolumelock(int n, int n2, boolean bl) {
        try {
            this.proxy.setVolumelock(n, n2, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getVolumelock(int n, int n2) {
        try {
            this.proxy.getVolumelock(n, n2);
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

