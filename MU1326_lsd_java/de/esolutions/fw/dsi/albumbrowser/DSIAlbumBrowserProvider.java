/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.albumbrowser;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.albumbrowser.DSIAlbumBrowserReply;
import de.esolutions.fw.comm.dsi.albumbrowser.impl.DSIAlbumBrowserProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowser;
import org.osgi.framework.BundleContext;

public class DSIAlbumBrowserProvider
extends AbstractProvider
implements DSIAlbumBrowser {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5};
    private DSIAlbumBrowserProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser;

    public DSIAlbumBrowserProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser = DSIAlbumBrowserProvider.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowser")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSIAlbumBrowserProxy(this.instance, (DSIAlbumBrowserReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void initializeBrowser(long l, long l2, int n) {
        try {
            this.proxy.initializeBrowser(l, l2, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void deinitializeBrowser() {
        try {
            this.proxy.deinitializeBrowser();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void startSingle() {
        try {
            this.proxy.startSingle();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void startPreview() {
        try {
            this.proxy.startPreview();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void startActive() {
        try {
            this.proxy.startActive();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void stop() {
        try {
            this.proxy.stop();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setScrollMode(int n) {
        try {
            this.proxy.setScrollMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void scrollTicks(long l) {
        try {
            this.proxy.scrollTicks(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void selectAlbum(long l) {
        try {
            this.proxy.selectAlbum(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void moveFocus(long l, int n) {
        try {
            this.proxy.moveFocus(l, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void albumIdxForFID(long l) {
        try {
            this.proxy.albumIdxForFID(l);
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

