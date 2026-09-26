/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import java.util.HashMap;
import java.util.Map;

public class TeamSeekInformationEnum {
    private static final Map ORDINAL_TO_ENUM_OBJECT = new HashMap();
    public static final TeamSeekInformationEnum TEAMA_NICKNAME = new TeamSeekInformationEnum(10, 9, true);
    public static final TeamSeekInformationEnum TEAMA_ABBREVIATION = new TeamSeekInformationEnum(11, 8, true);
    public static final TeamSeekInformationEnum TEAMA_LONGNAME = new TeamSeekInformationEnum(6, 7, true);
    public static final TeamSeekInformationEnum TEAMA_SHORTNAME = new TeamSeekInformationEnum(5, 6, true);
    public static final TeamSeekInformationEnum TEAMA_NAME = new TeamSeekInformationEnum(9, 5, true);
    public static final TeamSeekInformationEnum TEAMB_NICKNAME = new TeamSeekInformationEnum(13, 9, false);
    public static final TeamSeekInformationEnum TEAMB_ABBREVIATION = new TeamSeekInformationEnum(14, 8, false);
    public static final TeamSeekInformationEnum TEAMB_LONGNAME = new TeamSeekInformationEnum(8, 7, false);
    public static final TeamSeekInformationEnum TEAMB_SHORTNAME = new TeamSeekInformationEnum(7, 6, false);
    public static final TeamSeekInformationEnum TEAMB_NAME = new TeamSeekInformationEnum(12, 5, false);
    public final int importance;
    public final boolean isTeamA;

    private TeamSeekInformationEnum(int n, int n2, boolean bl) {
        this.importance = n2;
        this.isTeamA = bl;
        ORDINAL_TO_ENUM_OBJECT.put(new Integer(n), this);
    }

    public boolean isMoreImportantThan(TeamSeekInformationEnum teamSeekInformationEnum) {
        return this.isMoreImportantThan(teamSeekInformationEnum.importance);
    }

    public boolean isMoreImportantThan(int n) {
        return this.importance > n;
    }

    public static TeamSeekInformationEnum forOrdinal(int n) {
        return (TeamSeekInformationEnum)ORDINAL_TO_ENUM_OBJECT.get(new Integer(n));
    }
}

