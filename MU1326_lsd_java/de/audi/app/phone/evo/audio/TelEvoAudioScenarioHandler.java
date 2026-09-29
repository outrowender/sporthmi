/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelAudioScenarioHandler;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.audio.TelEvoAudioScenarioHandler$MuteRingtoneEvoButtonListener;
import de.audi.app.phone.evo.audio.TelEvoAudioTransferPopupHandler;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;

public class TelEvoAudioScenarioHandler
extends TelAudioScenarioHandler {
    public TelEvoAudioScenarioHandler(ITelApplication iTelApplication, TelEvoRingtoneManager telEvoRingtoneManager) {
        super(iTelApplication, telEvoRingtoneManager, new int[]{2, 3, 1});
        this.addSubPhoneComponent(new TelEvoAudioScenarioHandler$MuteRingtoneEvoButtonListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelEvoAudioTransferPopupHandler(iTelApplication));
    }

    @Override
    protected void ringtoneMuteSettingEnabled() {
        super.ringtoneMuteSettingEnabled();
        this.getChoiceModel(-1365965824).setValue(1);
    }

    @Override
    protected void ringtoneMuteSettingDisabled() {
        super.ringtoneMuteSettingDisabled();
        this.getChoiceModel(-1365965824).setValue(0);
    }

    @Override
    public void setCurrentAudioScenario(int n) {
        if (!this.ringtoneMuteSettingOn) {
            if (n == 5) {
                this.getChoiceModel(-1365965824).setValue(1);
            } else {
                this.getChoiceModel(-1365965824).setValue(0);
            }
        }
        super.setCurrentAudioScenario(n);
    }

    private IEntertainmentDrawerControllerNew getEntertainmentController() {
        return ((ITelEvoApplication)this.getApplication()).getNewEntertainmentDrawerController();
    }

    static /* synthetic */ IEntertainmentDrawerControllerNew access$000(TelEvoAudioScenarioHandler telEvoAudioScenarioHandler) {
        return telEvoAudioScenarioHandler.getEntertainmentController();
    }
}

