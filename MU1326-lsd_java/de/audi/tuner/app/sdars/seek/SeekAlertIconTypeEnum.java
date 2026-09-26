/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.Utilities;
import org.dsi.ifc.sdars.SeekEntry;

class SeekAlertIconTypeEnum {
    public static final SeekAlertIconTypeEnum NO_TYPE = new SeekAlertIconTypeEnum(0, "NO_TYPE", false, false);
    public static final SeekAlertIconTypeEnum SEEK_TITLE = new SeekAlertIconTypeEnum(1, "SEEK_TITLE", false, true);
    public static final SeekAlertIconTypeEnum SEEK_ARTIST = new SeekAlertIconTypeEnum(2, "SEEK_ARTIST", false, true);
    public static final SeekAlertIconTypeEnum ALERT_GAME = new SeekAlertIconTypeEnum(3, "ALERT_GAME", true, false);
    public static final SeekAlertIconTypeEnum ALERT_TEAM = new SeekAlertIconTypeEnum(4, "ALERT_TEAM", true, false);
    public static final SeekAlertIconTypeEnum ALERT_LEAGUE = new SeekAlertIconTypeEnum(5, "ALERT_LEAGUE", true, false);
    final int ordinal;
    final String name;
    final boolean gameAlertRelated;
    final boolean musicSeekRelated;

    private SeekAlertIconTypeEnum(int n, String string, boolean bl, boolean bl2) {
        this.ordinal = n;
        this.name = string;
        this.gameAlertRelated = bl;
        this.musicSeekRelated = bl2;
    }

    static SeekAlertIconTypeEnum forSeekEntry(SeekEntry seekEntry) {
        if (seekEntry == null) {
            return NO_TYPE;
        }
        switch (seekEntry.typeOfContent) {
            case 3: {
                return ALERT_TEAM;
            }
            case 2: {
                return ALERT_LEAGUE;
            }
            case 1: {
                if (Utilities.isEmpty(seekEntry.title2)) {
                    return SEEK_ARTIST;
                }
                return SEEK_TITLE;
            }
        }
        return NO_TYPE;
    }
}

