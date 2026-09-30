/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import org.dsi.ifc.sdars.SeekEntry;

public class SeekListSizeRestrictionHandlerSeparateSlots
extends AbstractSeekListSizeRistrictionHandler {
    private ChoiceModelApp seekListFullChoice;
    private int musicSlots;
    private int teamSlots;
    private int trafficWeatherSlots;
    private int lastMusicSeekCount = 0;
    private int lastTeamSeekCount = 0;
    private int lastTrafficWeatherSeekCount = 0;
    private boolean isFirstListDone = false;

    public SeekListSizeRestrictionHandlerSeparateSlots(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager, int n, int n2, int n3) {
        super(sDARSDSISeekDownManager);
        this.seekListFullChoice = tunerBasics.getModels().getChoiceModel(100719);
        this.musicSlots = n;
        this.teamSlots = n2;
        this.trafficWeatherSlots = n3;
    }

    protected void onDSIUpdateSeekList(SeekEntry[] seekEntryArray) {
        int n;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        block5: for (n = 0; n < seekEntryArray.length; ++n) {
            SeekEntry seekEntry = seekEntryArray[n];
            int n5 = seekEntry.getTypeOfContent();
            switch (n5) {
                case 1: {
                    ++n2;
                    continue block5;
                }
                case 2: 
                case 3: {
                    ++n3;
                    continue block5;
                }
                case 4: {
                    ++n4;
                    continue block5;
                }
            }
        }
        n = 0;
        if (this.isFirstListDone) {
            if (n2 != this.lastMusicSeekCount) {
                this.setSeekListFullChoice(n2 >= this.musicSlots);
                n = this.lastMusicSeekCount >= this.musicSlots != n2 >= this.musicSlots ? 1 : 0;
            } else if (n3 != this.lastTeamSeekCount) {
                this.setSeekListFullChoice(n3 >= this.teamSlots);
                n = this.lastTeamSeekCount >= this.teamSlots != n3 >= this.teamSlots ? 1 : 0;
            } else if (n4 != this.lastTrafficWeatherSeekCount) {
                this.setSeekListFullChoice(n4 >= this.trafficWeatherSlots);
                n = this.lastTrafficWeatherSeekCount >= this.trafficWeatherSlots != n4 >= this.trafficWeatherSlots ? 1 : 0;
            }
        }
        this.lastMusicSeekCount = n2;
        this.lastTeamSeekCount = n3;
        this.lastTrafficWeatherSeekCount = n4;
        this.isFirstListDone = true;
        if (n != 0) {
            this.dsi.setSeekPossibliltyNotification();
        }
    }

    private void setSeekListFullChoice(boolean bl) {
        if (this.seekListFullChoice != null) {
            this.seekListFullChoice.setValue(bl ? 1 : 0);
        }
    }

    public boolean isSeekListFull(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return this.getRemainingSpace(n) <= 0;
            }
        }
        return false;
    }

    public int getRemainingSpace(int n) {
        switch (n) {
            case 1: {
                return this.musicSlots - this.lastMusicSeekCount;
            }
            case 2: 
            case 3: {
                return this.teamSlots - this.lastTeamSeekCount;
            }
            case 4: {
                return this.trafficWeatherSlots - this.lastTrafficWeatherSeekCount;
            }
        }
        return 0;
    }
}

