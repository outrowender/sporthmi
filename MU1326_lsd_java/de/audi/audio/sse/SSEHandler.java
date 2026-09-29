/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sse;

import de.audi.audio.AudioEnv;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.sse.NullDSISSE;
import de.audi.audio.sse.SSEHandler$AudioListener;
import de.audi.audio.sse.SSEHandler$SSEListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sse.DSISSE;
import org.dsi.ifc.sse.DSISSEListener;

public class SSEHandler {
    public final DSISSEListener dsiListener = new SSEHandler$SSEListener(this, null);
    public final IAudioListener audioListener = new SSEHandler$AudioListener(this, null);
    private final AudioEnv env;
    private volatile DSISSE dsi;
    private volatile int lastRequestedMode = -1;

    public SSEHandler(AudioEnv audioEnv) {
        this.env = audioEnv;
        this.dsi = new NullDSISSE(audioEnv.lcDSI);
    }

    public void setDSISSE(DSISSE dSISSE) {
        this.dsi = dSISSE;
        if (this.lastRequestedMode != -1) {
            this.env.lcDSI.log(-2137614336, "[SSEHandler.setDSISSE] restore last requesed mode %1", (long)this.lastRequestedMode);
            dSISSE.requestSetMode(this.lastRequestedMode);
        }
        int[] nArray = new int[]{2, 1, 3};
        dSISSE.setNotification(nArray, (DSIListener)this.dsiListener);
    }

    private void updatePhoneUplinkStatus(int n) {
        switch (n) {
            case 2: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] phone uplink started -> requestSetMode(HFP_ON)");
                this.lastRequestedMode = 1;
                this.dsi.requestSetMode(1);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] phone uplink paused|stopped -> requestSetMode(HFP_OFF)");
                this.lastRequestedMode = 0;
                this.dsi.requestSetMode(0);
                break;
            }
        }
    }

    private void updateSdsUplinkStatus(int n) {
        switch (n) {
            case 2: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] SDS uplink started -> requestSetMode(SDS_ON)");
                this.lastRequestedMode = 2;
                this.dsi.requestSetMode(2);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] SDS uplink paused|stopped -> requestSetMode(SDS_OFF)");
                this.lastRequestedMode = 3;
                this.dsi.requestSetMode(3);
                break;
            }
        }
    }

    private void updateGalPhoneInputStatus(int n, int n2) {
        switch (n2) {
            case 2: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] automotive link started connection: %1 -> requestSetMode(MODE_HFP_ON)", (long)n);
                this.lastRequestedMode = 1;
                this.dsi.requestSetMode(1);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] automotive link  paused|stopped connection: %1 -> requestSetMode(MODE_HFP_OFF)", (long)n);
                this.lastRequestedMode = 0;
                this.dsi.requestSetMode(0);
                break;
            }
        }
    }

    private void updateIosPhoneInputStatus(int n, int n2) {
        switch (n2) {
            case 2: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] automotive link started connection: %1 -> requestSetMode(MODE_TEL_SMARTPHONE_INT_ON)", (long)n);
                this.lastRequestedMode = 9;
                this.dsi.requestSetMode(9);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] automotive link  paused|stopped connection: %1 -> requestSetMode(MODE_TEL_SMARTPHONE_INT_OFF)", (long)n);
                this.lastRequestedMode = 10;
                this.dsi.requestSetMode(10);
                break;
            }
        }
    }

    private void updateSmartphoneSdsStatus(int n, int n2) {
        switch (n2) {
            case 2: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] automotive link started connection: %1 -> requestSetMode(MODE_SDS_SMARTPHONE_INT_ON)", (long)n);
                this.lastRequestedMode = 7;
                this.dsi.requestSetMode(7);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] automotive link  paused|stopped connection: %1 -> requestSetMode(MODE_SDS_SMARTPHONE_INT_OFF)", (long)n);
                this.lastRequestedMode = 8;
                this.dsi.requestSetMode(8);
                break;
            }
        }
    }

    private void updateExternalSdsStatus(int n) {
        switch (n) {
            case 2: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] Extern-SDS uplink started -> requestSetMode(MODE_SDS_EXTERN_ON)");
                this.lastRequestedMode = 4;
                this.dsi.requestSetMode(4);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(-2137614336, "[SSEHandler.updateConnStatus] ExternSDS uplink paused|stopped -> requestSetMode(MODE_SDS_EXTERN_OFF)");
                this.lastRequestedMode = 5;
                this.dsi.requestSetMode(5);
                break;
            }
        }
    }

    static /* synthetic */ void access$200(SSEHandler sSEHandler, int n) {
        sSEHandler.updatePhoneUplinkStatus(n);
    }

    static /* synthetic */ void access$300(SSEHandler sSEHandler, int n) {
        sSEHandler.updateSdsUplinkStatus(n);
    }

    static /* synthetic */ AudioEnv access$400(SSEHandler sSEHandler) {
        return sSEHandler.env;
    }

    static /* synthetic */ void access$500(SSEHandler sSEHandler, int n, int n2) {
        sSEHandler.updateGalPhoneInputStatus(n, n2);
    }

    static /* synthetic */ void access$600(SSEHandler sSEHandler, int n, int n2) {
        sSEHandler.updateIosPhoneInputStatus(n, n2);
    }

    static /* synthetic */ void access$700(SSEHandler sSEHandler, int n, int n2) {
        sSEHandler.updateSmartphoneSdsStatus(n, n2);
    }

    static /* synthetic */ void access$800(SSEHandler sSEHandler, int n) {
        sSEHandler.updateExternalSdsStatus(n);
    }
}

