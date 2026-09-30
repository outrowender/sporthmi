/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tghu.waveplayer.WavePlayerClient;
import de.audi.tghu.waveplayer.WavePlayerMaster;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.waveplayer.DSIWavePlayer;
import org.dsi.ifc.waveplayer.DSIWavePlayerListener;

public class WavePlayerImpl
implements WavePlayer {
    private final Object mutex = new Object();
    private WavePlayerMaster ringToneMaster;
    private WavePlayerMaster systemToneMaster;
    private int lastSessionID;
    private boolean waveplayerServiceRegistered = false;
    private IFrameworkAccess fw;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;

    WavePlayerImpl(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.lastSessionID = -1;
        this.ringToneMaster = new WavePlayerMaster(this, iFrameworkAccess, iFrameworkAccess.getLogChannel("Fw.Waveplayer.Ringtone"));
        this.systemToneMaster = new WavePlayerMaster(this, iFrameworkAccess, iFrameworkAccess.getLogChannel("Fw.Waveplayer.Systemtone"));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void registerWaveplayerService() {
        if (!this.waveplayerServiceRegistered) {
            this.ringToneMaster.lc.log(1000000, "WavePlayerImpl.registerWaveplayerService()");
            this.systemToneMaster.lc.log(1000000, "WavePlayerImpl.registerWaveplayerService()");
        }
        Object object = this.mutex;
        synchronized (object) {
            if (!this.waveplayerServiceRegistered) {
                this.fw.getBundleCxt().registerService((class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = WavePlayerImpl.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (Object)this, null);
                this.waveplayerServiceRegistered = true;
            }
        }
    }

    public DSIWavePlayerListener getRingToneListener() {
        return this.ringToneMaster.getDSIListener();
    }

    public DSIWavePlayerListener getSystemToneListener() {
        return this.systemToneMaster.getDSIListener();
    }

    public void registerRingTonePlayer(DSIWavePlayer dSIWavePlayer) {
        this.ringToneMaster.lc.log(10000000, "WavePlayerImpl.registerRingTonePlayer( %1 ) ", (Object)dSIWavePlayer);
        this.ringToneMaster.registerDSI(dSIWavePlayer);
        try {
            dSIWavePlayer.setNotification(new int[]{2, 1}, (DSIListener)this.ringToneMaster.getDSIListener());
        }
        catch (Exception exception) {
            this.ringToneMaster.lc.log(10000, "WavePlayerImpl.registerRingTonePlayer( %1 ): Setting notifications failed! ", (Object)dSIWavePlayer, (Throwable)exception);
        }
    }

    public void registerSystemTonePlayer(DSIWavePlayer dSIWavePlayer) {
        this.systemToneMaster.lc.log(10000000, "WavePlayerImpl.registerSystemTonePlayer( %1 ) ", (Object)dSIWavePlayer);
        this.systemToneMaster.registerDSI(dSIWavePlayer);
        try {
            dSIWavePlayer.setNotification(new int[]{2, 1}, (DSIListener)this.systemToneMaster.getDSIListener());
        }
        catch (Exception exception) {
            this.ringToneMaster.lc.log(10000, "WavePlayerImpl.registerSystemTonePlayer( %1 ): Setting notifications failed! ", (Object)dSIWavePlayer, (Throwable)exception);
        }
    }

    public RingTonePlayer getRingTonePlayer() {
        return new WavePlayerClient(this.ringToneMaster, this.nextSessionID());
    }

    public SystemTonePlayer getSystemTonePlayer() {
        return new WavePlayerClient(this.systemToneMaster, this.nextSessionID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public RingTonePlayer getRingTonePlayer(int n) throws IllegalArgumentException {
        WavePlayerImpl wavePlayerImpl = this;
        synchronized (wavePlayerImpl) {
            if (n <= this.lastSessionID) {
                throw new IllegalArgumentException(new StringBuffer().append("SessionID ").append(n).append(" already in use!").toString());
            }
        }
        return new WavePlayerClient(this.ringToneMaster, n);
    }

    private synchronized int nextSessionID() {
        ++this.lastSessionID;
        return this.lastSessionID;
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

