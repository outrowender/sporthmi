/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.interapp.displaymanager.Cropping;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIDisplayManagement;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSIHandler$BlockedDSITVImpl;
import de.audi.tv.app.dsi.DSIHandler$DSIDownCallLock;
import de.audi.tv.app.dsi.DSIHandler$DSITVImpl;
import de.audi.tv.app.dsi.DSIHandler$TuneUpdateListener;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.dsi.NullDSITVTuner;
import de.audi.tv.app.settings.AVNorm;
import de.audi.tv.app.settings.ICroppingAdjuster;
import de.audi.tv.app.storage.ActiveServiceStorage;
import de.esolutions.fw.util.commons.Converter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.tvtuner.DSITVTuner;
import org.dsi.ifc.tvtuner.DSITVTunerListener;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class DSIHandler
implements DSITV {
    private final LogChannel lc;
    private DSITVTuner dsi;
    private DSIDisplayManagement dsiDisplay;
    private IDisplayManagerService displayManager;
    private DSICallListener[] dsiCallListeners = new DSICallListener[0];
    private volatile DSITV activeDsitv;
    private final DSITV dsitv;
    private final DSITV blockedDsitv;
    private final List dsiLocks;
    private final TVEventDispatcher tvEventDispatcher;
    private ICroppingAdjuster croppingAdjuster = ICroppingAdjuster.DEFAULT;
    private volatile ServiceInfo lastSelectedService = null;
    public final TVEventDefaultListener tuneUpdateListener = new DSIHandler$TuneUpdateListener(this, null);

    public DSIHandler(LogChannel logChannel, TVEventDispatcher tVEventDispatcher) {
        this.lc = logChannel;
        this.dsi = new NullDSITVTuner(logChannel);
        this.dsiDisplay = new NullDSIDisplayManagement(logChannel);
        this.dsiLocks = new ArrayList(2);
        this.dsitv = new DSIHandler$DSITVImpl(this, null);
        this.blockedDsitv = new DSIHandler$BlockedDSITVImpl(this, null);
        this.activeDsitv = this.dsitv;
        this.tvEventDispatcher = tVEventDispatcher;
    }

    public void addListeners(DSICallListener[] dSICallListenerArray) {
        DSICallListener[] dSICallListenerArray2 = new DSICallListener[this.dsiCallListeners.length + dSICallListenerArray.length];
        System.arraycopy((Object)this.dsiCallListeners, 0, (Object)dSICallListenerArray2, 0, this.dsiCallListeners.length);
        System.arraycopy((Object)dSICallListenerArray, 0, (Object)dSICallListenerArray2, this.dsiCallListeners.length, dSICallListenerArray.length);
        this.dsiCallListeners = dSICallListenerArray2;
    }

    public void setCroppingAdjuster(ICroppingAdjuster iCroppingAdjuster) {
        if (iCroppingAdjuster == null) {
            iCroppingAdjuster = ICroppingAdjuster.DEFAULT;
        }
        this.croppingAdjuster = iCroppingAdjuster;
    }

    public void setNotification(int[] nArray, DSITVTunerListener dSITVTunerListener) {
        this.dsi.setNotification(nArray, (DSIListener)dSITVTunerListener);
    }

    public void clearNotification(int[] nArray, DSITVTunerListener dSITVTunerListener) {
        this.dsi.clearNotification(nArray, (DSIListener)dSITVTunerListener);
    }

    public void register(DSITVTuner dSITVTuner) {
        if (dSITVTuner == null) {
            throw new IllegalArgumentException("Don't register NULL DSIs!");
        }
        this.lc.log(1078071040, "[DSIHandler.register] %1", (Object)dSITVTuner);
        this.dsi = dSITVTuner;
    }

    public void register(IDisplayManagerService iDisplayManagerService) {
        if (this.dsi == null) {
            throw new IllegalArgumentException("Don't register NULL DSIs!");
        }
        this.lc.log(1078071040, "[DSIHandler.register] %1", (Object)iDisplayManagerService);
        this.displayManager = iDisplayManagerService;
    }

    public void register(DSIDisplayManagement dSIDisplayManagement) {
        if (this.dsi == null) {
            throw new IllegalArgumentException("Don't register NULL DSIs!");
        }
        this.lc.log(1078071040, "[DSIHandler.register] %1", (Object)dSIDisplayManagement);
        this.dsiDisplay = dSIDisplayManagement;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DSIHandler$DSIDownCallLock createDownCallLock(String string) {
        DSIHandler$DSIDownCallLock dSIHandler$DSIDownCallLock = new DSIHandler$DSIDownCallLock(this, string, null);
        List list = this.dsiLocks;
        synchronized (list) {
            this.dsiLocks.add(dSIHandler$DSIDownCallLock);
        }
        return dSIHandler$DSIDownCallLock;
    }

    @Override
    public void setNormAreaSubList(int[] nArray) {
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "-> [DSIHandler.setNormAreaSubList] %1", (Object)Converter.array2String(nArray));
        }
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setNormAreaSubList(nArray);
        }
    }

    @Override
    public void setNormArea(int n) {
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "-> [DSIHandler.setNormArea] 0x%1", (Object)Integer.toHexString(n));
        }
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setNormArea(n);
        }
        this.activeDsitv.setNormArea(n);
    }

    @Override
    public void setAudioChannel(int n) {
        this.lc.log(-2137614336, "-> [DSIHandler.setAudioChannel] channelID:%1", (long)n);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setAudioChannel(n);
        }
        this.activeDsitv.setAudioChannel(n);
    }

    @Override
    public void enableServiceLinking(boolean bl) {
        this.lc.log(-2137614336, "-> [DSIHandler.enableServiceLinking] linkingState:%1", bl);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].enableServiceLinking(bl);
        }
        this.activeDsitv.enableServiceLinking(bl);
    }

    @Override
    public void enableSubtitle(boolean bl) {
        this.lc.log(-2137614336, "-> [DSIHandler.subtitleState] linkingState:%1", bl);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].enableSubtitle(bl);
        }
        this.activeDsitv.enableSubtitle(bl);
    }

    @Override
    public void setBrowserListSort(int n) {
        this.lc.log(-2137614336, "-> [DSIHandler.setBrowserListSort] sorting:%1", (long)n);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setBrowserListSort(n);
        }
        this.activeDsitv.setBrowserListSort(n);
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        int n;
        this.lc.log(-2137614336, "-> [DSIHandler.selectService] %1", (Object)serviceInfo);
        if (serviceInfo == ActiveServiceStorage.DEFAULT_SERVICE_INFO) {
            this.lc.log(-1601830656, "-> [DSIHandler.selectService] Don't tune fallback service: %1", (Object)serviceInfo);
            return;
        }
        for (n = 0; n < this.dsiCallListeners.length; ++n) {
            this.dsiCallListeners[n].selectService(serviceInfo, bl);
        }
        this.lastSelectedService = serviceInfo;
        this.activeDsitv.selectService(serviceInfo, bl);
        for (n = 0; n < this.dsiCallListeners.length; ++n) {
            this.dsiCallListeners[n].afterSelectService(serviceInfo, bl);
        }
    }

    @Override
    public void changeService(ServiceInfo serviceInfo, boolean bl) {
        this.lc.log(-2137614336, "-> [DSIHandler.changeService] %1", (Object)serviceInfo);
        boolean bl2 = TVUtil.equalsFullPID(serviceInfo, this.lastSelectedService);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].changeService(serviceInfo, bl, bl2);
        }
        if (bl2) {
            this.lc.log(-2137614336, "-> [DSIHandler.changeService] service already selected");
        } else {
            this.selectService(serviceInfo, bl);
        }
    }

    @Override
    public void selectNextService(int n) {
        this.lc.log(-2137614336, "-> [DSIHandler.selectNextService] direction:%1 seekMode:%2", (long)n, (long)0);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].selectNextService(n);
        }
        this.lastSelectedService = null;
        this.activeDsitv.selectNextService(n);
    }

    @Override
    public void abortSeek() {
        this.lc.log(-2137614336, "-> [DSIHandler.abortSeek]");
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].abortSeek();
        }
        this.activeDsitv.abortSeek();
    }

    @Override
    public void switchSource(int n, boolean bl) {
        this.lc.log(-2137614336, "-> [DSIHandler.switchSource] %1(%2)", (Object)(n == 0 ? "TV" : "AV"), (long)n);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].switchSource(n, bl);
        }
        this.activeDsitv.switchSource(n, bl);
    }

    @Override
    public void setTerminalMode(int n, int n2) {
        this.lc.log(-2137614336, "-> [DSIHandler.setTerminalMode] terminalMode:0x%1 screenMode:0x%2", (long)n, (long)n2);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setTerminalMode(n, n2);
        }
        this.activeDsitv.setTerminalMode(n, n2);
    }

    @Override
    public void setTMTVKeyPanel(short s, short s2) {
        this.lc.log(-2137614336, "-> [DSIHandler.setTMTVKeyPanel] dsiKeyPanelID:0x%1 keyStatus:0x%2", (long)s, (long)s2);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setTMTVKeyPanel(s, s2);
        }
        this.activeDsitv.setTMTVKeyPanel(s, s2);
    }

    @Override
    public void incMoved(int n) {
        this.lc.log(-2137614336, "-> [DSIHandler.incMoved] steps:%1", (long)n);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].incMoved(n);
        }
        this.activeDsitv.incMoved(n);
    }

    @Override
    public void setAVNorm(int n) {
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "-> [DSIHandler.setAVNorm] %1(%2)", (Object)AVNorm.toString(n), (long)n);
        }
        this.activeDsitv.setAVNorm(n);
    }

    @Override
    public void setCropping(Cropping cropping, int n, int n2, int n3, int n4, int n5, int n6) {
        this.lc.log(-2137614336, "-> [DSIHandler.setCropping] %1", (Object)cropping);
        Cropping cropping2 = this.croppingAdjuster.adjustIfNecessary(cropping);
        if (!cropping2.equals(cropping)) {
            this.lc.log(-2137614336, "-> [DSIHandler.setCropping] adjusted to %1", (Object)cropping2);
        }
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setCropping(cropping2);
        }
        this.activeDsitv.setCropping(cropping2, n, n2, n3, n4, n5, n6);
    }

    @Override
    public void setBrightness(int n, int n2) {
        this.lc.log(-2137614336, "-> [DSIHandler.setBrightness] %1", (long)n2);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setBrightness(n, n2);
        }
        this.activeDsitv.setBrightness(n, n2);
    }

    @Override
    public void setContrast(int n, int n2) {
        this.lc.log(-2137614336, "-> [DSIHandler.setContrast] %1", (long)n2);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setContrast(n, n2);
        }
        this.activeDsitv.setContrast(n, n2);
    }

    @Override
    public void setColor(int n, int n2) {
        this.lc.log(-2137614336, "-> [DSIHandler.setColor] %1", (long)n2);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setColor(n, n2);
        }
        this.activeDsitv.setColor(n, n2);
    }

    @Override
    public void setTint(int n, int n2) {
        this.lc.log(-2137614336, "-> [DSIHandler.setTint] %1", (long)n2);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].setTint(n, n2);
        }
        this.activeDsitv.setTint(n, n2);
    }

    @Override
    public void startComponent(int n) {
        this.startComponent(n, 0, 0);
    }

    @Override
    public void startComponent(int n, int n2, int n3) {
        this.lc.log(-2137614336, "-> [DSIHandler.startComponent] %1 %2", (long)n2, (long)n);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].startComponent(n, n2, n3);
        }
        this.activeDsitv.startComponent(n, n2, n3);
    }

    @Override
    public void stopComponent(int n) {
        this.stopComponent(n, 0, 0);
    }

    @Override
    public void stopComponent(int n, int n2, int n3) {
        this.lc.log(-2137614336, "-> [DSIHandler.stopComponent] %1 %2", (long)n2, (long)n);
        for (int i2 = 0; i2 < this.dsiCallListeners.length; ++i2) {
            this.dsiCallListeners[i2].stopComponent(n, n2, n3);
        }
        this.activeDsitv.stopComponent(n, n2, n3);
    }

    public boolean isBlocked() {
        return this.activeDsitv == this.blockedDsitv;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateLocks() {
        boolean bl = false;
        List list = this.dsiLocks;
        synchronized (list) {
            Iterator iterator = this.dsiLocks.iterator();
            while (iterator.hasNext()) {
                DSIHandler$DSIDownCallLock dSIHandler$DSIDownCallLock = (DSIHandler$DSIDownCallLock)iterator.next();
                if (!DSIHandler$DSIDownCallLock.access$600(dSIHandler$DSIDownCallLock)) continue;
                bl |= true;
                this.lc.log(-2137614336, "[DSIHandler.updateLocks] '%1' is locked", (Object)DSIHandler$DSIDownCallLock.access$700(dSIHandler$DSIDownCallLock));
            }
        }
        if (bl) {
            if (!this.activeDsitv.equals(this.blockedDsitv)) {
                this.activeDsitv = this.blockedDsitv;
                this.lc.log(-2137614336, "[DSIHandler.updateLocks] locked DSI downcalls");
                this.tvEventDispatcher.updateDSILocked();
            }
        } else if (!this.activeDsitv.equals(this.dsitv)) {
            this.activeDsitv = this.dsitv;
            this.lc.log(-2137614336, "[DSIHandler.updateLocks] unlocked DSI downcalls");
            this.tvEventDispatcher.updateDSIUnlocked();
        }
    }

    static /* synthetic */ LogChannel access$000(DSIHandler dSIHandler) {
        return dSIHandler.lc;
    }

    static /* synthetic */ void access$100(DSIHandler dSIHandler) {
        dSIHandler.updateLocks();
    }

    static /* synthetic */ ServiceInfo access$802(DSIHandler dSIHandler, ServiceInfo serviceInfo) {
        dSIHandler.lastSelectedService = serviceInfo;
        return dSIHandler.lastSelectedService;
    }

    static /* synthetic */ DSITVTuner access$900(DSIHandler dSIHandler) {
        return dSIHandler.dsi;
    }

    static /* synthetic */ DSIDisplayManagement access$1000(DSIHandler dSIHandler) {
        return dSIHandler.dsiDisplay;
    }

    static /* synthetic */ IDisplayManagerService access$1100(DSIHandler dSIHandler) {
        return dSIHandler.displayManager;
    }
}

