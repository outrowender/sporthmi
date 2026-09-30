/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelAudioScenarioHandler;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.audio.TelEvoAudioTransferPopupHandler;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;

public class TelEvoAudioScenarioHandler
extends TelAudioScenarioHandler {
    public TelEvoAudioScenarioHandler(ITelApplication iTelApplication, TelEvoRingtoneManager telEvoRingtoneManager) {
        super(iTelApplication, telEvoRingtoneManager, new int[]{2, 3, 1});
        this.addSubPhoneComponent(new MuteRingtoneEvoButtonListener(iTelApplication));
        this.addSubPhoneComponent(new TelEvoAudioTransferPopupHandler(iTelApplication));
    }

    protected void ringtoneMuteSettingEnabled() {
        super.ringtoneMuteSettingEnabled();
        this.getChoiceModel(300462).setValue(1);
    }

    protected void ringtoneMuteSettingDisabled() {
        super.ringtoneMuteSettingDisabled();
        this.getChoiceModel(300462).setValue(0);
    }

    public void setCurrentAudioScenario(int n) {
        if (!this.ringtoneMuteSettingOn) {
            if (n == 5) {
                this.getChoiceModel(300462).setValue(1);
            } else {
                this.getChoiceModel(300462).setValue(0);
            }
        }
        super.setCurrentAudioScenario(n);
    }

    private IEntertainmentDrawerControllerNew getEntertainmentController() {
        return ((ITelEvoApplication)this.getApplication()).getNewEntertainmentDrawerController();
    }

    private class MuteRingtoneEvoButtonListener
    extends TelDefaultButtonListener {
        public MuteRingtoneEvoButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300451);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[MuteRingtoneEvoButtonListener#keyTyped] muting ringtone!");
            TelEvoAudioScenarioHandler.this.muteRingtone(true);
            TelEvoAudioScenarioHandler.this.getEntertainmentController().onIncomingCallMute();
        }
    }
}

