/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephone;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephone.DSINADReply;
import de.esolutions.fw.comm.dsi.telephone.impl.DSINADProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.telephone.DSINAD;
import org.osgi.framework.BundleContext;

public class DSINADProvider
extends AbstractProvider
implements DSINAD {
    private static final int[] attributeIDs = new int[]{3, 4, 5, 16, 19, 20, 21, 22, 24, 27, 29};
    private DSINADProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSINAD;

    public DSINADProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$telephone$DSINAD == null ? (class$org$dsi$ifc$telephone$DSINAD = DSINADProvider.class$("org.dsi.ifc.telephone.DSINAD")) : class$org$dsi$ifc$telephone$DSINAD).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSINADProxy(this.instance, (DSINADReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void requestNetworkRegistration(String string, int n) {
        try {
            this.proxy.requestNetworkRegistration(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestAbortNetworkRegistration() {
        try {
            this.proxy.requestAbortNetworkRegistration();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestNetworkSearch() {
        try {
            this.proxy.requestNetworkSearch();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestAbortNetworkSearch() {
        try {
            this.proxy.requestAbortNetworkSearch();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestSetAutomaticPinEntryActive(boolean bl) {
        try {
            this.proxy.requestSetAutomaticPinEntryActive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestTelPower(int n) {
        try {
            this.proxy.requestTelPower(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestUnlockSIM(int n, String string, String string2) {
        try {
            this.proxy.requestUnlockSIM(n, string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestCheckSIMPINCode(String string) {
        try {
            this.proxy.requestCheckSIMPINCode(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestChangeSIMCode(int n, String string, String string2) {
        try {
            this.proxy.requestChangeSIMCode(n, string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestSIMPINRequired(String string, boolean bl) {
        try {
            this.proxy.requestSIMPINRequired(string, bl);
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

