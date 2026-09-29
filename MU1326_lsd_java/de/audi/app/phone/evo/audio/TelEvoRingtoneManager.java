/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelRingtoneManager;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager$RingtoneListDisplayFocusListener;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager$RingtoneListEnteredListener;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager$RingtoneListExitedListener;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager$StageSizeListener;
import de.audi.atip.mmicombi.IViewSizeListener;

public class TelEvoRingtoneManager
extends TelRingtoneManager
implements IViewSizeListener {
    private volatile boolean viewStageSmall;
    private volatile boolean focusLost;

    public TelEvoRingtoneManager(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new TelEvoRingtoneManager$RingtoneListDisplayFocusListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelEvoRingtoneManager$StageSizeListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelEvoRingtoneManager$RingtoneListEnteredListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelEvoRingtoneManager$RingtoneListExitedListener(this, iTelApplication));
    }

    @Override
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
            this.log.log(1078071040, "[TelRingtoneManager#ringtoneListLeft] entered=%1, ringing=%2 --> Not aborting ringtone", this.ringtoneListEntered, bl);
            this.setRingtoneListPlaybackStarted(false);
        } else {
            this.abortRingtoneListPlayback();
        }
    }

    static /* synthetic */ boolean access$002(TelEvoRingtoneManager telEvoRingtoneManager, boolean bl) {
        telEvoRingtoneManager.focusLost = bl;
        return telEvoRingtoneManager.focusLost;
    }

    static /* synthetic */ void access$100(TelEvoRingtoneManager telEvoRingtoneManager) {
        telEvoRingtoneManager.checkDoRingtoneListPlayback();
    }

    static /* synthetic */ boolean access$202(TelEvoRingtoneManager telEvoRingtoneManager, boolean bl) {
        telEvoRingtoneManager.viewStageSmall = bl;
        return telEvoRingtoneManager.viewStageSmall;
    }

    static /* synthetic */ boolean access$302(TelEvoRingtoneManager telEvoRingtoneManager, boolean bl) {
        telEvoRingtoneManager.ringtoneListEntered = bl;
        return telEvoRingtoneManager.ringtoneListEntered;
    }

    static /* synthetic */ boolean access$402(TelEvoRingtoneManager telEvoRingtoneManager, boolean bl) {
        telEvoRingtoneManager.ringtoneListEntered = bl;
        return telEvoRingtoneManager.ringtoneListEntered;
    }

    static /* synthetic */ void access$500(TelEvoRingtoneManager telEvoRingtoneManager) {
        telEvoRingtoneManager.ringtoneListLeft();
    }
}

