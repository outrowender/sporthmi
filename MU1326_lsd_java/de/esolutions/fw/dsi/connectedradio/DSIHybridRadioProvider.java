/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.connectedradio;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.connectedradio.DSIHybridRadio;
import org.dsi.ifc.connectedradio.RadioStation;
import org.osgi.framework.BundleContext;

public class DSIHybridRadioProvider
extends AbstractProvider
implements DSIHybridRadio {
    private static final int[] attributeIDs = new int[]{1, 2, 3};
    private DSIHybridRadioProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$DSIHybridRadio;

    public DSIHybridRadioProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$connectedradio$DSIHybridRadio == null ? (class$org$dsi$ifc$connectedradio$DSIHybridRadio = DSIHybridRadioProvider.class$("org.dsi.ifc.connectedradio.DSIHybridRadio")) : class$org$dsi$ifc$connectedradio$DSIHybridRadio).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSIHybridRadioProxy(this.instance, (DSIHybridRadioReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void getOnlineRadioAvailability(int n, RadioStation[] radioStationArray) {
        try {
            this.proxy.getOnlineRadioAvailability(n, radioStationArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getRadioStationLogo(int n, RadioStation[] radioStationArray, int n2) {
        try {
            this.proxy.getRadioStationLogo(n, radioStationArray, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void cancelGetRadioStationLogo(int n) {
        try {
            this.proxy.cancelGetRadioStationLogo(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getStream(int n, RadioStation radioStation) {
        try {
            this.proxy.getStream(n, radioStation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void startSlideshow(int n, RadioStation radioStation, int n2, int n3) {
        try {
            this.proxy.startSlideshow(n, radioStation, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void stopSlideshow(int n, RadioStation radioStation) {
        try {
            this.proxy.stopSlideshow(n, radioStation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void profileChange(int n) {
        try {
            this.proxy.profileChange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void profileCopy(int n, int n2) {
        try {
            this.proxy.profileCopy(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void profileReset(int n) {
        try {
            this.proxy.profileReset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void profileResetAll() {
        try {
            this.proxy.profileResetAll();
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

