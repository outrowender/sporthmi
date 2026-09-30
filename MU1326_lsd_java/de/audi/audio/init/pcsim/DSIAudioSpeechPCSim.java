/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.init.pcsim;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIAudioManagementListener;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.base.DSIListener;

public class DSIAudioSpeechPCSim
implements DSIAudioManagement {
    private final LogChannel lc;
    private volatile DSIAudioManagementListener listener;
    private volatile int activeConn = 0;
    private volatile int activeEntConn = 0;

    public DSIAudioSpeechPCSim(LogChannel logChannel) {
        this.lc = logChannel;
        this.listener = new NullDSIAudioManagementListener(logChannel);
        logChannel.log(1000000, "[DSIAudioSpeechPCSim]");
    }

    public void requestConnection(int n, int n2, int n3) {
        if (n == 0) {
            return;
        }
        this.lc.log(1000000, "[DSIAudioSpeechPCSim.requestConnection] AC:%1 AT:%2", (long)n, (long)n2);
        switch (n) {
            case 8: {
                break;
            }
            default: {
                this.activeConn = n;
            }
        }
        switch (n) {
            case 12: 
            case 13: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 26: 
            case 28: 
            case 201: {
                this.activeEntConn = n;
                break;
            }
        }
        this.listener.startConnection(n, n2);
        this.getActiveConnection(n2);
        this.getActiveEntertainmentConnection(n2);
    }

    public void fadeToConnection(int n, int n2) {
        if (n == 0) {
            return;
        }
        this.lc.log(1000000, "[DSIAudioSpeechPCSim.fadeToConnection] AC:%1 AT:%2", (long)n, (long)n2);
        this.listener.fadedIn(n, n2);
    }

    public void releaseConnection(int n, int n2) {
        if (n == 0) {
            return;
        }
        this.lc.log(1000000, "[DSIAudioSpeechPCSim.releaseConnection] AC:%1 AT:%2", (long)n, (long)n2);
        this.listener.stopConnection(n, n2);
    }

    public void getActiveConnection(int n) {
        this.listener.updateActiveConnection(this.activeConn, n, 1);
    }

    public void getActiveEntertainmentConnection(int n) {
        this.listener.updateActiveEntertainmentConnection(this.activeEntConn, n, 1);
    }

    public void setVolumelock(int n, int n2, boolean bl) {
        this.lc.log(1000000, "[DSIAudioSpeechPCSim.setVolumelock] Not supported.");
    }

    public void getVolumelock(int n, int n2) {
        this.lc.log(1000000, "[DSIAudioSpeechPCSim.getVolumelock] Not supported.");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.setNotification(nArray[i2], dSIListener);
        }
    }

    public void setNotification(int n, DSIListener dSIListener) {
        if (dSIListener instanceof DSIAudioManagementListener) {
            this.listener = (DSIAudioManagementListener)dSIListener;
        } else {
            this.lc.log(10000, "[DSIAudioSpeechPCSim.setListener] Invalid listener:%1", (Object)dSIListener);
        }
        if (n == 1) {
            this.lc.log(1000000, "[DSIAudioSpeechPCSim.setNotification] attr:%1 --> send amAvailable", (long)n);
            this.listener.updateAMAvailable(3, 0, 1);
        }
    }

    public void setNotification(DSIListener dSIListener) {
        this.lc.log(10000, "[DSIAudioSpeechPCSim.setNotification] Not supported!");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.lc.log(10000, "[DSIAudioSpeechPCSim.clearNotification] Not supported!");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.lc.log(10000, "[DSIAudioSpeechPCSim.clearNotification] Not supported!");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.lc.log(10000, "[DSIAudioSpeechPCSim.clearNotification] Not supported!");
    }
}

