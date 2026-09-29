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

public class InfoAnnouncementVolumeRange
extends AbstractVolumeRange {
    private static final int CONNECTION;
    private final String DEFAULT_TEXT;
    private final TTSSamplePlayer player;
    private final int[] volumeConnections = new int[]{138, 140, 139};
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final String name;

    protected InfoAnnouncementVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, -1371402496, -1388179712, 139);
        this.DEFAULT_TEXT = "Text not available";
        this.name = "InfoAnnouncementVolumeRange";
        this.player = new TTSSamplePlayer(volumeRangeManager.env, volumeRangeManager.env.getTranslatedText(3, "Text not available"));
        ChoiceModelApp choiceModelApp = volumeRangeManager.env.getChoiceModel(-1354625280);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, volumeRangeManager.env.lcHMI, "InfoAnnouncementVolumeRange");
    }

    @Override
    protected void registerService(Object object) {
        super.registerService(object);
        this.volMenuManager.env.getChoiceModel(1396838144).setValue(1);
    }

    @Override
    protected void deregisterService(Object object) {
        super.deregisterService(object);
        this.volMenuManager.env.getChoiceModel(1396838144).setValue(0);
    }

    @Override
    protected void requestMenuConnection() {
        this.limitVolumeToHmiLimits();
        String string = this.env.getTranslatedText(3, "Text not available");
        this.player.setText(string);
        this.player.startSession();
    }

    @Override
    protected void releaseMenuConnection() {
        this.player.stopSession();
    }

    @Override
    protected ISamplePlayer getSamplePlayer() {
        return this.player;
    }

    @Override
    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    @Override
    protected String getName() {
        return "InfoAnnouncementVolumeRange";
    }

    @Override
    protected int getID() {
        return 12;
    }
}

