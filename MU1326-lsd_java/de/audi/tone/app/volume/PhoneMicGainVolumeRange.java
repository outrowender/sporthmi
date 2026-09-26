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
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-1656615168);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "PhoneMicGainVolumeRange");
    }

    @Override
    protected int getLimitsConnection() {
        return this.getForegroundConnection();
    }

    @Override
    protected boolean enableOnOffDDSMapping() {
        return false;
    }

    @Override
    protected void requestMenuConnection() {
        this.env.lcHMI.log(-2137614336, "[PhoneMicGainVolumeRange.requestMenuConnection] do not request menu connection");
    }

    @Override
    protected void releaseMenuConnection() {
        this.env.lcHMI.log(-2137614336, "[PhoneMicGainVolumeRange.releaseMenuConnection] do not release menu connection");
    }

    @Override
    protected int[] getVolumeConnections() {
        return new int[0];
    }

    @Override
    protected String getName() {
        return "PhoneMicGainVolumeRange";
    }

    @Override
    protected int getID() {
        return 10;
    }
}

