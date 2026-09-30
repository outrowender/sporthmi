/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.ISDARSRow;
import de.audi.tuner.app.sdars.SdarsRadioText;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.SeekState;

public class AddToSeeksPossibilityEnum {
    public static final AddToSeeksPossibilityEnum IMPOSSIBLE = new AddToSeeksPossibilityEnum(-1, false);
    public static final AddToSeeksPossibilityEnum POSSIBLE = new AddToSeeksPossibilityEnum(0, true);
    public static final AddToSeeksPossibilityEnum IMPOSSIBLE_ALREADY_STORED = new AddToSeeksPossibilityEnum(1, true);
    public static final AddToSeeksPossibilityEnum IMPOSSIBLE_MEMORY_FULL = new AddToSeeksPossibilityEnum(2, true);
    public static final AddToSeeksPossibilityEnum IMPOSSIBLE_MISSING_INFO = new AddToSeeksPossibilityEnum(3, true);
    public final int ordinal;
    public final boolean showOption;

    private AddToSeeksPossibilityEnum(int n, boolean bl) {
        this.ordinal = n;
        this.showOption = bl;
    }

    public static AddToSeeksPossibilityEnum forArtist(SdarsRadioText sdarsRadioText, SeekPossibility seekPossibility, ChoiceModelApp choiceModelApp) {
        int n = AddToSeeksPossibilityEnum.findSeekStateOfTypeIn(2, seekPossibility.seekState);
        return AddToSeeksPossibilityEnum.forMusic(sdarsRadioText, seekPossibility.typeOfContent, n, choiceModelApp);
    }

    public static AddToSeeksPossibilityEnum forSong(SdarsRadioText sdarsRadioText, SeekPossibility seekPossibility, ChoiceModelApp choiceModelApp) {
        int n = AddToSeeksPossibilityEnum.findSeekStateOfTypeIn(1, seekPossibility.seekState);
        return AddToSeeksPossibilityEnum.forMusic(sdarsRadioText, seekPossibility.typeOfContent, n, choiceModelApp);
    }

    public static AddToSeeksPossibilityEnum forTeamA(SeekPossibility seekPossibility, ChoiceModelApp choiceModelApp) {
        int n = AddToSeeksPossibilityEnum.findSeekStateOfTypeIn(4, seekPossibility.seekState);
        return AddToSeeksPossibilityEnum.forSport(seekPossibility.typeOfContent, n, choiceModelApp);
    }

    public static AddToSeeksPossibilityEnum forTeamB(SeekPossibility seekPossibility, ChoiceModelApp choiceModelApp) {
        int n = AddToSeeksPossibilityEnum.findSeekStateOfTypeIn(5, seekPossibility.seekState);
        return AddToSeeksPossibilityEnum.forSport(seekPossibility.typeOfContent, n, choiceModelApp);
    }

    public static void setSeekDependingModelsAndProperties(long l, SeekPossibility seekPossibility, SdarsRadioText sdarsRadioText, ISDARSRow iSDARSRow, TunerModels tunerModels) {
        ChoiceModelApp choiceModelApp = tunerModels.getChoiceModel(100719);
        AddToSeeksPossibilityEnum addToSeeksPossibilityEnum = AddToSeeksPossibilityEnum.forTeamA(seekPossibility, choiceModelApp);
        AddToSeeksPossibilityEnum addToSeeksPossibilityEnum2 = AddToSeeksPossibilityEnum.forTeamB(seekPossibility, choiceModelApp);
        SdarsRadioText sdarsRadioText2 = SdarsRadioText.EMPTY_RADIOTEXT;
        if (sdarsRadioText != null && (long)sdarsRadioText.sID == l) {
            sdarsRadioText2 = sdarsRadioText;
        }
        AddToSeeksPossibilityEnum addToSeeksPossibilityEnum3 = AddToSeeksPossibilityEnum.forArtist(sdarsRadioText2, seekPossibility, choiceModelApp);
        AddToSeeksPossibilityEnum addToSeeksPossibilityEnum4 = AddToSeeksPossibilityEnum.forSong(sdarsRadioText2, seekPossibility, choiceModelApp);
        iSDARSRow.setSeekPossibility(addToSeeksPossibilityEnum3, addToSeeksPossibilityEnum4, addToSeeksPossibilityEnum, addToSeeksPossibilityEnum2);
        tunerModels.getChoiceModel(100725).setValue(addToSeeksPossibilityEnum3.ordinal);
        tunerModels.getChoiceModel(100724).setValue(addToSeeksPossibilityEnum4.ordinal);
        tunerModels.getChoiceModel(100723).setValue(addToSeeksPossibilityEnum.ordinal);
        tunerModels.getChoiceModel(100726).setValue(addToSeeksPossibilityEnum2.ordinal);
    }

    private static AddToSeeksPossibilityEnum forMusic(SdarsRadioText sdarsRadioText, int n, int n2, ChoiceModelApp choiceModelApp) {
        if (n == 1) {
            if (n2 == 1) {
                return IMPOSSIBLE_ALREADY_STORED;
            }
            if (choiceModelApp.getValue() == 1) {
                return IMPOSSIBLE_MEMORY_FULL;
            }
            if (n2 == 2) {
                return POSSIBLE;
            }
            if (sdarsRadioText.artistOrTitleInformationAvailable()) {
                return IMPOSSIBLE_MISSING_INFO;
            }
        }
        return IMPOSSIBLE;
    }

    private static AddToSeeksPossibilityEnum forSport(int n, int n2, ChoiceModelApp choiceModelApp) {
        if (n == 3) {
            if (n2 == 1) {
                return IMPOSSIBLE_ALREADY_STORED;
            }
            if (choiceModelApp.getValue() == 1) {
                return IMPOSSIBLE_MEMORY_FULL;
            }
            if (n2 == 2) {
                return POSSIBLE;
            }
        }
        return IMPOSSIBLE;
    }

    private static int findSeekStateOfTypeIn(int n, SeekState[] seekStateArray) {
        if (seekStateArray != null) {
            for (int i2 = 0; i2 < seekStateArray.length; ++i2) {
                if (seekStateArray[i2].seekType != n) continue;
                return seekStateArray[i2].state;
            }
        }
        return -1;
    }
}

