/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.volume.AbstractPhoneVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;

public class RingtoneSelectionVolumeRange
extends AbstractPhoneVolumeRange {
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_PHONE;
    private final String name;

    public RingtoneSelectionVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, -1, -1, 0);
        this.name = "RingtoneSelectionVolumeRange";
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1000094);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "RingtoneSelectionVolumeRange");
    }

    protected int[] getVolumeConnections() {
        return new int[0];
    }

    protected String getName() {
        return "RingtoneSelectionVolumeRange";
    }

    protected int getID() {
        return 9;
    }

    protected boolean enableOnOffDDSMapping() {
        return false;
    }

    protected void requestMenuConnection() {
        this.env.lcMain.log(10000000, "[RingtoneSelectionVolumeRange.requestMenuConnection] do not request any connection");
    }

    protected void releaseMenuConnection() {
        this.env.lcMain.log(10000000, "[RingtoneSelectionVolumeRange.releaseMenuConnection] do menu connection requested ");
    }

    protected int getLimitsConnection() {
        return this.getForegroundConnection();
    }
}

