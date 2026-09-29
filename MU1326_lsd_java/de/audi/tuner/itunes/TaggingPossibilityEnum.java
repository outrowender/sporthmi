/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.tuner.app.amfm.HdStationInfoExt;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.itunes.ITaggingManager;

public class TaggingPossibilityEnum {
    public static final TaggingPossibilityEnum POSSIBLE = new TaggingPossibilityEnum(-1, true, true);
    public static final TaggingPossibilityEnum IMPOSSIBLE_UNKNOWN_CAUSE = new TaggingPossibilityEnum(0, false, false, -1);
    public static final TaggingPossibilityEnum IMPOSSIBLE_ALREADY_TAGGED = new TaggingPossibilityEnum(1, false, false, -2);
    public static final TaggingPossibilityEnum IMPOSSIBLE_MEMORY_FULL = new TaggingPossibilityEnum(2, false, true, 2);
    public static final TaggingPossibilityEnum IMPOSSIBLE_ITUNES_ID_MISSING = new TaggingPossibilityEnum(3, false, false, -1);
    public final int ordinal;
    public final boolean possible;
    public final boolean informUser;
    public final int secondOrdinal;

    private TaggingPossibilityEnum(int n, boolean bl, boolean bl2) {
        this(n, bl, bl2, 0);
    }

    private TaggingPossibilityEnum(int n, boolean bl, boolean bl2, int n2) {
        this.ordinal = n;
        this.possible = bl;
        this.informUser = bl2;
        this.secondOrdinal = n2;
    }

    public static TaggingPossibilityEnum forHd(HdStationInfoExt hdStationInfoExt, ITaggingManager iTaggingManager) {
        if (!iTaggingManager.isTaggingSpaceFree()) {
            return IMPOSSIBLE_MEMORY_FULL;
        }
        if (hdStationInfoExt.isAlreadyTaggedForITunes()) {
            return IMPOSSIBLE_ALREADY_TAGGED;
        }
        if (!hdStationInfoExt.artistAndTitleInformationAvailable()) {
            return IMPOSSIBLE_ITUNES_ID_MISSING;
        }
        return POSSIBLE;
    }

    public static TaggingPossibilityEnum forSdars(SdarsRadioText sdarsRadioText, ITaggingManager iTaggingManager) {
        if (sdarsRadioText == null) {
            return IMPOSSIBLE_UNKNOWN_CAUSE;
        }
        if (!sdarsRadioText.iTunesIdAvailable()) {
            return IMPOSSIBLE_ITUNES_ID_MISSING;
        }
        if (!iTaggingManager.isTaggingSpaceFree()) {
            return IMPOSSIBLE_MEMORY_FULL;
        }
        if (sdarsRadioText.isAlreadyTaggedForITunes()) {
            return IMPOSSIBLE_ALREADY_TAGGED;
        }
        return POSSIBLE;
    }
}

