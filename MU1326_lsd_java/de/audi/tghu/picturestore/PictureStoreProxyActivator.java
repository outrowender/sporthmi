/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.picturestore.PictureStoreDSIDefaultListener;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.picturestore.DSIPictureStore;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PictureStoreProxyActivator
extends AbstractFrameworkActivator
implements IDSIClient {
    private static final int INSTANCE_ID = 0;
    private ServiceRegistration sRegPictureStoreProxy;
    private LogChannel logCh;
    private PictureStoreDSIListener pictureStoreDSIListener = null;
    private PictureStoreProxy pictureStoreProxy = null;
    private DSIActivator dsiActivator = null;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$DSIPictureStore;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$DSIPictureStoreListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$picturestore$PictureStoreProvider;

    public PictureStoreProxyActivator() {
        super("PictureStoreProxy");
    }

    public PictureStoreProxy getService() {
        return this.pictureStoreProxy;
    }

    protected void startInternal(BundleContext bundleContext) {
        this.logCh = this.framework.getLogChannel("Fw.PictureStore");
        this.logCh.log(10000000, "PictureStoreProxyActivator#startLastMode initialize and start cmdListMgr");
        CommandListManager commandListManager = new CommandListManager(new StringBuffer().append(this.getClass().getName()).append("_CmdListMgr").toString(), this.framework, this.logCh, null, null);
        commandListManager.start();
        this.logCh.log(10000000, "PictureStoreProxyActivator#startLastMode initialize PictureStore Proxy and PictureStoreDSIListener");
        PictureStoreDSIDefaultListener pictureStoreDSIDefaultListener = new PictureStoreDSIDefaultListener();
        this.pictureStoreProxy = new PictureStoreProxy(this.framework, commandListManager, this.logCh);
        this.pictureStoreProxy.setPictureStoreDSIDefaultHandler(pictureStoreDSIDefaultListener);
        this.pictureStoreDSIListener = new PictureStoreDSIListener(commandListManager, pictureStoreDSIDefaultListener);
        this.pictureStoreDSIListener.setPictureStoreProxy(this.pictureStoreProxy);
        this.logCh.log(10000000, "PictureStoreProxyActivator#start called");
        this.dsiActivator = new DSIActivator(this.framework, (class$org$dsi$ifc$picturestore$DSIPictureStore == null ? (class$org$dsi$ifc$picturestore$DSIPictureStore = PictureStoreProxyActivator.class$("org.dsi.ifc.picturestore.DSIPictureStore")) : class$org$dsi$ifc$picturestore$DSIPictureStore).getName(), (class$org$dsi$ifc$picturestore$DSIPictureStoreListener == null ? (class$org$dsi$ifc$picturestore$DSIPictureStoreListener = PictureStoreProxyActivator.class$("org.dsi.ifc.picturestore.DSIPictureStoreListener")) : class$org$dsi$ifc$picturestore$DSIPictureStoreListener).getName(), new Integer(0), this.pictureStoreDSIListener, this);
        this.dsiActivator.start(bundleContext);
    }

    public void stop(BundleContext bundleContext) {
        if (this.sRegPictureStoreProxy != null) {
            this.sRegPictureStoreProxy.unregister();
            this.sRegPictureStoreProxy = null;
        }
        if (this.dsiActivator != null) {
            this.dsiActivator.stop(bundleContext);
            this.dsiActivator = null;
        }
        super.stop(bundleContext);
    }

    public void setDSI(DSIBase dSIBase) {
        this.logCh.log(10000000, "PictureStoreProxyActivator#setDSI picture store DSI was found.");
        DSIPictureStore dSIPictureStore = (DSIPictureStore)dSIBase;
        this.pictureStoreProxy.setDSIPictureStore(dSIPictureStore);
        if (dSIBase == null) {
            if (this.sRegPictureStoreProxy != null) {
                this.sRegPictureStoreProxy.unregister();
                this.sRegPictureStoreProxy = null;
            }
        } else {
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$picturestore$PictureStoreProvider == null ? (class$de$audi$atip$interapp$picturestore$PictureStoreProvider = PictureStoreProxyActivator.class$("de.audi.atip.interapp.picturestore.PictureStoreProvider")) : class$de$audi$atip$interapp$picturestore$PictureStoreProvider).getName());
            this.sRegPictureStoreProxy = this.getBundleContext().registerService((class$de$audi$atip$interapp$picturestore$PictureStoreProvider == null ? (class$de$audi$atip$interapp$picturestore$PictureStoreProvider = PictureStoreProxyActivator.class$("de.audi.atip.interapp.picturestore.PictureStoreProvider")) : class$de$audi$atip$interapp$picturestore$PictureStoreProvider).getName(), (Object)this.pictureStoreProxy, (Dictionary)hashtable);
        }
    }

    public int[] getAutoNotifications() {
        return new int[0];
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

