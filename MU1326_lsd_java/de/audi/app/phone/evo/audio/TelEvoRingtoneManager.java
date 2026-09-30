/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.audio.TelRingtoneManager;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.util.AbstractDisplayFocusListener;
import de.audi.app.phone.evo.util.AbstractTelStageChangeListener;
import de.audi.atip.mmicombi.IViewSizeListener;
import java.util.Map;

public class TelEvoRingtoneManager
extends TelRingtoneManager
implements IViewSizeListener {
    private volatile boolean viewStageSmall;
    private volatile boolean focusLost;

    public TelEvoRingtoneManager(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new RingtoneListDisplayFocusListener(iTelApplication));
        this.addSubPhoneComponent(new StageSizeListener(iTelApplication));
        this.addSubPhoneComponent(new RingtoneListEnteredListener(iTelApplication));
        this.addSubPhoneComponent(new RingtoneListExitedListener(iTelApplication));
    }

    public void viewSizeChanged(int n) {
        if (n == 1) {
            this.viewStageSmall = true;
            this.checkDoRingtoneListPlayback();
        } else {
            this.viewStageSmall = false;
            this.checkDoRingtoneListPlayback();
        }
    }

    private void checkDoRingtoneListPlayback() {
        if (this.ringtoneListEntered) {
            if (this.viewStageSmall || this.focusLost) {
                this.ringtoneListLeft();
            } else if (!this.isRingtoneListPlaybackStarted()) {
                this.startRingtoneListPlayback();
            }
        }
    }

    private void ringtoneListLeft() {
        boolean bl;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
        boolean bl2 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null ? iGlobalTelephoneStateStruct.getCallState().getMpCallState() == 15 : (bl = false);
        if (bl) {
            this.log.log(1000000, "[TelRingtoneManager#ringtoneListLeft] entered=%1, ringing=%2 --> Not aborting ringtone", this.ringtoneListEntered, bl);
            this.setRingtoneListPlaybackStarted(false);
        } else {
            this.abortRingtoneListPlayback();
        }
    }

    private class StageSizeListener
    extends AbstractTelStageChangeListener {
        public StageSizeListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Audio");
        }

        protected void smallStageShown() {
            this.log.log(1000000, "[TelEvoRingtoneManager.StageSizeListener#smallStageShown]");
            TelEvoRingtoneManager.this.viewStageSmall = true;
            TelEvoRingtoneManager.this.checkDoRingtoneListPlayback();
        }

        protected void largeStateShown() {
            this.log.log(1000000, "[TelEvoRingtoneManager.StageSizeListener#largeStateShown]");
            TelEvoRingtoneManager.this.viewStageSmall = false;
            TelEvoRingtoneManager.this.checkDoRingtoneListPlayback();
        }
    }

    private class RingtoneListExitedListener
    extends AbstractTelActionProxyListener {
        public RingtoneListExitedListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Audio", 3);
        }

        protected void actionProxyCalled(Map map) {
            this.log.log(1000000, "[RingtoneListExitedListener#actionProxyCalled] CANCEL_RINGING_TONE");
            TelEvoRingtoneManager.this.ringtoneListEntered = false;
            TelEvoRingtoneManager.this.ringtoneListLeft();
        }
    }

    private class RingtoneListEnteredListener
    extends AbstractTelActionProxyListener {
        public RingtoneListEnteredListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Audio", 2);
        }

        protected void actionProxyCalled(Map map) {
            this.log.log(1000000, "[RingtoneListEnteredListener#actionProxyCalled] PHONE_TONE_SETUP_ENTERED");
            TelEvoRingtoneManager.this.ringtoneListEntered = true;
            TelEvoRingtoneManager.this.startRingtoneListPlayback();
        }
    }

    private class RingtoneListDisplayFocusListener
    extends AbstractDisplayFocusListener {
        public RingtoneListDisplayFocusListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Audio", 4026);
        }

        protected void focusLost() {
            this.log.log(1000000, "[TelEvoRingtoneManager.RingtoneListDisplayFocusListener#focusLost]");
            TelEvoRingtoneManager.this.focusLost = true;
            TelEvoRingtoneManager.this.checkDoRingtoneListPlayback();
        }

        protected void focusGained() {
            this.log.log(1000000, "[TelEvoRingtoneManager.RingtoneListDisplayFocusListener#focusGained]");
            TelEvoRingtoneManager.this.focusLost = false;
            TelEvoRingtoneManager.this.checkDoRingtoneListPlayback();
        }
    }
}

