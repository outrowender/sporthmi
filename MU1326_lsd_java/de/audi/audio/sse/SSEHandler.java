/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sse;

import de.audi.audio.AudioEnv;
import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.sse.NullDSISSE;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sse.DSISSE;
import org.dsi.ifc.sse.DSISSEListener;

public class SSEHandler {
    public final DSISSEListener dsiListener = new SSEListener();
    public final IAudioListener audioListener = new AudioListener();
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
            this.env.lcDSI.log(10000000, "[SSEHandler.setDSISSE] restore last requesed mode %1", (long)this.lastRequestedMode);
            dSISSE.requestSetMode(this.lastRequestedMode);
        }
        int[] nArray = new int[]{2, 1, 3};
        dSISSE.setNotification(nArray, (DSIListener)this.dsiListener);
    }

    private void updatePhoneUplinkStatus(int n) {
        switch (n) {
            case 2: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] phone uplink started -> requestSetMode(HFP_ON)");
                this.lastRequestedMode = 1;
                this.dsi.requestSetMode(1);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] phone uplink paused|stopped -> requestSetMode(HFP_OFF)");
                this.lastRequestedMode = 0;
                this.dsi.requestSetMode(0);
                break;
            }
        }
    }

    private void updateSdsUplinkStatus(int n) {
        switch (n) {
            case 2: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] SDS uplink started -> requestSetMode(SDS_ON)");
                this.lastRequestedMode = 2;
                this.dsi.requestSetMode(2);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] SDS uplink paused|stopped -> requestSetMode(SDS_OFF)");
                this.lastRequestedMode = 3;
                this.dsi.requestSetMode(3);
                break;
            }
        }
    }

    private void updateGalPhoneInputStatus(int n, int n2) {
        switch (n2) {
            case 2: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] automotive link started connection: %1 -> requestSetMode(MODE_HFP_ON)", (long)n);
                this.lastRequestedMode = 1;
                this.dsi.requestSetMode(1);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] automotive link  paused|stopped connection: %1 -> requestSetMode(MODE_HFP_OFF)", (long)n);
                this.lastRequestedMode = 0;
                this.dsi.requestSetMode(0);
                break;
            }
        }
    }

    private void updateIosPhoneInputStatus(int n, int n2) {
        switch (n2) {
            case 2: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] automotive link started connection: %1 -> requestSetMode(MODE_TEL_SMARTPHONE_INT_ON)", (long)n);
                this.lastRequestedMode = 9;
                this.dsi.requestSetMode(9);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] automotive link  paused|stopped connection: %1 -> requestSetMode(MODE_TEL_SMARTPHONE_INT_OFF)", (long)n);
                this.lastRequestedMode = 10;
                this.dsi.requestSetMode(10);
                break;
            }
        }
    }

    private void updateSmartphoneSdsStatus(int n, int n2) {
        switch (n2) {
            case 2: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] automotive link started connection: %1 -> requestSetMode(MODE_SDS_SMARTPHONE_INT_ON)", (long)n);
                this.lastRequestedMode = 7;
                this.dsi.requestSetMode(7);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] automotive link  paused|stopped connection: %1 -> requestSetMode(MODE_SDS_SMARTPHONE_INT_OFF)", (long)n);
                this.lastRequestedMode = 8;
                this.dsi.requestSetMode(8);
                break;
            }
        }
    }

    private void updateExternalSdsStatus(int n) {
        switch (n) {
            case 2: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] Extern-SDS uplink started -> requestSetMode(MODE_SDS_EXTERN_ON)");
                this.lastRequestedMode = 4;
                this.dsi.requestSetMode(4);
                break;
            }
            case 4: 
            case 5: {
                this.env.lcDSI.log(10000000, "[SSEHandler.updateConnStatus] ExternSDS uplink paused|stopped -> requestSetMode(MODE_SDS_EXTERN_OFF)");
                this.lastRequestedMode = 5;
                this.dsi.requestSetMode(5);
                break;
            }
        }
    }

    private class SSEListener
    implements DSISSEListener {
        private SSEListener() {
        }

        public void asyncException(int n, String string, int n2) {
            ((SSEHandler)SSEHandler.this).env.lcDSI.log(10000, "[SSEHandler.asyncException] errorCode:%1 requestType:%2", (long)n, (long)n2);
        }

        public void responseSetMode(int n) {
            ((SSEHandler)SSEHandler.this).env.lcDSI.log(10000000, "[SSEHandler.responseSetMode] replyCode:%1", (long)n);
        }

        public void updateMode(int n, int n2) {
            ((SSEHandler)SSEHandler.this).env.lcDSI.log(10000000, "[SSEHandler.updateMode] mode:%1 validFlag:%2", (long)n, (long)n2);
        }

        public void updateMicGainLevel(int n, int n2) {
            ((SSEHandler)SSEHandler.this).env.lcDSI.log(10000000, "[SSEHandler.updateMicGainLevel] micGainLevel:%1 validFlag:%2", (long)n, (long)n2);
        }

        public void responseSetMicGainLevel(int n) {
            ((SSEHandler)SSEHandler.this).env.lcDSI.log(10000000, "[SSEHandler.responseSetMicGainLevel] replyCode:%1", (long)n);
        }

        public void updateMicMuteState(int n, int n2) {
            ((SSEHandler)SSEHandler.this).env.lcDSI.log(10000000, "[SSEHandler.updateMicMuteState] micMuteState:%1 validFlag:%2", (long)n, (long)n2);
        }

        public void responseSetMicMuteState(int n) {
            ((SSEHandler)SSEHandler.this).env.lcDSI.log(10000000, "[SSEHandler.responseSetMicMuteState] replyCode:%1", (long)n);
        }
    }

    private class AudioListener
    extends DefaultAudioListener {
        private AudioListener() {
        }

        public void updateConnStatus(int n, int n2, int n3) {
            if (n == 100) {
                SSEHandler.this.updatePhoneUplinkStatus(n2);
            }
            if (n == 113) {
                SSEHandler.this.updateSdsUplinkStatus(n2);
            }
            if (((SSEHandler)SSEHandler.this).env.framework.getSysConst(4065) == 1) {
                if (n == 164) {
                    SSEHandler.this.updateGalPhoneInputStatus(n, n2);
                }
                if (n == 163) {
                    SSEHandler.this.updateIosPhoneInputStatus(n, n2);
                }
                if (n == 159 || n == 153) {
                    SSEHandler.this.updateSmartphoneSdsStatus(n, n2);
                }
            }
            if (n == 137) {
                SSEHandler.this.updateExternalSdsStatus(n2);
            }
        }
    }
}

