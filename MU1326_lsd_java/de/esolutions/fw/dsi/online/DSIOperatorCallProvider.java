/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOperatorCallReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOperatorCallProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.online.DSIOperatorCall;
import org.dsi.ifc.online.OperatorCallData;
import org.osgi.framework.BundleContext;

public class DSIOperatorCallProvider
extends AbstractProvider
implements DSIOperatorCall {
    private static final int[] attributeIDs = new int[0];
    private DSIOperatorCallProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOperatorCall;

    public DSIOperatorCallProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$online$DSIOperatorCall == null ? (class$org$dsi$ifc$online$DSIOperatorCall = DSIOperatorCallProvider.class$("org.dsi.ifc.online.DSIOperatorCall")) : class$org$dsi$ifc$online$DSIOperatorCall).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSIOperatorCallProxy(this.instance, (DSIOperatorCallReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void requestOperatorCallResult(String string, int n) {
        try {
            this.proxy.requestOperatorCallResult(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void requestOperatorPhoneNumber(int n, OperatorCallData operatorCallData, boolean bl) {
        try {
            this.proxy.requestOperatorPhoneNumber(n, operatorCallData, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setLanguage(String string) {
        try {
            this.proxy.setLanguage(string);
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

