/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;
import de.audi.tone.app.volume.samples.ISamplePlayer;
import de.audi.tone.app.volume.samples.TTSSamplePlayer;

public class WirelessChargingVolumeRange
extends AbstractVolumeRange {
    public static final int REMINDER_SIGNAL_OFF;
    public static final int REMINDER_SIGNAL_BEEP;
    public static final int REMINDER_SIGNAL_TEXT_MESSAGE;
    private static final int REMINDER_SIGNAL_OPTION_COUNT;
    private static final String BEEP;
    private static final int CONNECTION;
    private final int[] volumeConnections = new int[]{142, 143};
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final String name;
    private final ChoiceModelApp ddbModel;
    private final TTSSamplePlayer samplePlayer;
    private final String DEFAULT_TEXT;

    public WirelessChargingVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, -1488843008, -1455288576, 143);
        this.name = "WirelessChargingVolumeRange";
        this.DEFAULT_TEXT = "Text not available";
        this.ddbModel = volumeRangeManager.env.getChoiceModel(-1505620224);
        this.ddbModel.setChoiceListener(this);
        ChoiceModelApp choiceModelApp = volumeRangeManager.env.getChoiceModel(-1472065792);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, volumeRangeManager.env.lcHMI, "WirelessChargingVolumeRange");
        this.samplePlayer = new TTSSamplePlayer(volumeRangeManager.env, "Text not available");
    }

    @Override
    protected void init() {
        super.init();
        int n = this.volMenuManager.env.getStorageAccess().getInt(1009, 1, 2);
        this.samplePlayer.setText(this.getText(n));
        this.ddbModel.setValue(n);
    }

    private String getText(int n) {
        if (n > 0 && n < 3) {
            this.volMenuManager.env.lcHMI.log(1078071040, "[WirelessChargingVolumeRange.getText] textId: %1", (long)n);
            switch (n) {
                case 1: {
                    return "<audio src=\"WLC-reminder.wav\"/>";
                }
                case 2: {
                    return this.env.getTranslatedText(2, "Text not available");
                }
            }
            this.volMenuManager.env.lcHMI.log(10000, "[WirelessChargingVolumeRange.getText] Invalid textId %1", (long)n);
        }
        this.volMenuManager.env.lcHMI.log(1078071040, "[WirelessChargingVolumeRange.getText]  wrong textId: %1", (long)n);
        return "Text not available";
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.ddbModel.getID()) {
            this.volMenuManager.env.lcHMI.log(1078071040, "[WirelessChargingVolumeRange.itemSelected] itemID : %1", (long)n2);
            this.volMenuManager.env.getStorageAccess().setInt(1009, 1, n2);
            this.samplePlayer.setText(this.getText(n2));
            this.ddbModel.setValue(n2);
        } else {
            this.volMenuManager.env.lcHMI.log(1078071040, "[WirelessChargingVolumeRange.itemSelected]   modelID: %1 handle in superclass", (long)n);
            super.itemSelected(n, n2, n3, n4);
        }
    }

    @Override
    protected void requestMenuConnection() {
        this.limitVolumeToHmiLimits();
        int n = this.env.getStorageAccess().getInt(1009, 1, 2);
        this.samplePlayer.setText(this.getText(n));
        this.samplePlayer.startSession();
    }

    @Override
    protected void releaseMenuConnection() {
        this.samplePlayer.stopSession();
    }

    @Override
    protected void registerService(Object object) {
        this.samplePlayer.registerService(object);
    }

    @Override
    protected void deregisterService(Object object) {
        this.samplePlayer.deregisterService(object);
    }

    @Override
    protected ISamplePlayer getSamplePlayer() {
        return this.samplePlayer;
    }

    @Override
    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    @Override
    protected String getName() {
        return "WirelessChargingVolumeRange";
    }

    @Override
    protected int getID() {
        return 11;
    }
}

