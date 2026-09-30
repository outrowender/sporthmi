/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swdlselection;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdlselection.DSISwdlSelectionReply;
import de.esolutions.fw.comm.dsi.swdlselection.impl.DSISwdlSelectionProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.swdlselection.DSISwdlSelection;
import org.osgi.framework.BundleContext;

public class DSISwdlSelectionProvider
extends AbstractProvider
implements DSISwdlSelection {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7};
    private DSISwdlSelectionProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelection;

    public DSISwdlSelectionProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$swdlselection$DSISwdlSelection == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelection = DSISwdlSelectionProvider.class$("org.dsi.ifc.swdlselection.DSISwdlSelection")) : class$org$dsi$ifc$swdlselection$DSISwdlSelection).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSISwdlSelectionProxy(this.instance, (DSISwdlSelectionReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void setUserSwdl(boolean bl) {
        try {
            this.proxy.setUserSwdl(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setGotFocus(boolean bl) {
        try {
            this.proxy.setGotFocus(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getMedia() {
        try {
            this.proxy.getMedia();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void storeNfsIpAddress(String string) {
        try {
            this.proxy.storeNfsIpAddress(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void storeNfsPath(String string) {
        try {
            this.proxy.storeNfsPath(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setMedium(int n) {
        try {
            this.proxy.setMedium(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setRelease(long l) {
        try {
            this.proxy.setRelease(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getUserDefinedAllowed() {
        try {
            this.proxy.getUserDefinedAllowed();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setInstallationType(boolean bl) {
        try {
            this.proxy.setInstallationType(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setTargetLanguage(short s) {
        try {
            this.proxy.setTargetLanguage(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getIncompatibleDevices() {
        try {
            this.proxy.getIncompatibleDevices();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void startDownload() {
        try {
            this.proxy.startDownload();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void createCriticalUnlock() {
        try {
            this.proxy.createCriticalUnlock();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void startVersionUpload() {
        try {
            this.proxy.startVersionUpload();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void abortVersionUpload() {
        try {
            this.proxy.abortVersionUpload();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void endVersionUpload() {
        try {
            this.proxy.endVersionUpload();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void storeCifsServer(String string) {
        try {
            this.proxy.storeCifsServer(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void storeCifsPath(String string) {
        try {
            this.proxy.storeCifsPath(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void storeCifsUser(String string) {
        try {
            this.proxy.storeCifsUser(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void storeCifsPassword(String string) {
        try {
            this.proxy.storeCifsPassword(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void storeFsPath(String string) {
        try {
            this.proxy.storeFsPath(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void checkConsistency() {
        try {
            this.proxy.checkConsistency();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void abortSetMedium() {
        try {
            this.proxy.abortSetMedium();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void abortSetRelease() {
        try {
            this.proxy.abortSetRelease();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getFinalizeTargets() {
        try {
            this.proxy.getFinalizeTargets();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setFinalizeTarget(int n) {
        try {
            this.proxy.setFinalizeTarget(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void enterComponentUpdateConfirmation(boolean bl) {
        try {
            this.proxy.enterComponentUpdateConfirmation(bl);
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

