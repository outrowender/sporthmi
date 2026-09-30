/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.volume.AbstractPhoneVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;

public class PhoneMicGainVolumeRange
extends AbstractPhoneVolumeRange {
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_PHONE_MIC_GAIN;
    private final String name;

    public PhoneMicGainVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, -1, -1, 0);
        this.name = "PhoneMicGainVolumeRange";
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1000093);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "PhoneMicGainVolumeRange");
    }

    protected int getLimitsConnection() {
        return this.getForegroundConnection();
    }

    protected boolean enableOnOffDDSMapping() {
        return false;
    }

    protected void requestMenuConnection() {
        this.env.lcHMI.log(10000000, "[PhoneMicGainVolumeRange.requestMenuConnection] do not request menu connection");
    }

    protected void releaseMenuConnection() {
        this.env.lcHMI.log(10000000, "[PhoneMicGainVolumeRange.releaseMenuConnection] do not release menu connection");
    }

    protected int[] getVolumeConnections() {
        return new int[0];
    }

    protected String getName() {
        return "PhoneMicGainVolumeRange";
    }

    protected int getID() {
        return 10;
    }
}

