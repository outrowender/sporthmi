/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.base.DSIBase;

public interface DSISDARSSeek
extends DSIBase {
    public static final String VERSION = "2.11.20";
    public static final int ATTR_SEEKPOSSIBILITY = 1;
    public static final int ATTR_SEEKLIST = 2;
    public static final int ATTR_SEEKALERT = 3;
    public static final int ATTR_LEAGUELIST = 4;
    public static final int ATTR_TRAFFICWEATHERLIST = 6;
    public static final int ATTR_REGISTEREDTEAMS = 7;
    public static final int ATTR_PROFILESTATE = 8;
    public static final int RT_SETSEEKCOMMAND = 1000;
    public static final int RT_MANAGESEEK = 1001;
    public static final int RT_RESET = 1002;
    public static final int RT_MANAGESEEK2 = 1003;
    public static final int RT_GETTEAMSOFLEAGUE = 1004;
    public static final int RT_GETLEAGUES = 1005;
    public static final int RT_PROFILECHANGE = 1006;
    public static final int RT_PROFILECOPY = 1007;
    public static final int RT_PROFILERESET = 1008;
    public static final int RT_PROFILERESETALL = 1009;
    public static final int RP_SETSEEKCOMMANDRESULT = 2000;
    public static final int RP_MANAGESEEKRESULT = 2001;
    public static final int RP_TEAMSOFLEAGUE = 2002;
    public static final int RP_LEAGUES = 2003;
    public static final int RP_PROFILECHANGED = 2004;
    public static final int RP_PROFILECOPIED = 2005;
    public static final int RP_PROFILERESET = 2006;
    public static final int RP_PROFILERESETALL = 2007;
    public static final int RESETTYPE_TO_DEFAULT = 1;
    public static final int TYPEOFCONTENT_UNKNOWN = 0;
    public static final int TYPEOFCONTENT_SONGARTIST = 1;
    public static final int TYPEOFCONTENT_LEAGUE = 2;
    public static final int TYPEOFCONTENT_TEAM = 3;
    public static final int TYPEOFCONTENT_TRAFFICWX = 4;
    public static final int SEEKCONTENTID_UNLINKED = 0;
    public static final int SEEKTYPE_UNKNOWN = 0;
    public static final int SEEKTYPE_SONG = 1;
    public static final int SEEKTYPE_ARTIST = 2;
    public static final int SEEKTYPE_LEAGUE = 3;
    public static final int SEEKTYPE_TEAMA = 4;
    public static final int SEEKTYPE_TEAMB = 5;
    public static final int SEEKTYPE_TRAFFICWX = 6;
    public static final int SEEKINFO_UNDEFINED = 0;
    public static final int SEEKINFO_SHORTARTISTNAME = 1;
    public static final int SEEKINFO_LONGARTISTNAME = 2;
    public static final int SEEKINFO_SHORTPROGRAMTITLE = 3;
    public static final int SEEKINFO_LONGPROGRAMTITLE = 4;
    public static final int SEEKINFO_SHORTTEAMA = 5;
    public static final int SEEKINFO_LONGTEAMA = 6;
    public static final int SEEKINFO_SHORTTEAMB = 7;
    public static final int SEEKINFO_LONGTEAMB = 8;
    public static final int SEEKINFO_NAMETEAMA = 9;
    public static final int SEEKINFO_NICKNAMETEAMA = 10;
    public static final int SEEKINFO_ABBREVIATIONTEAMA = 11;
    public static final int SEEKINFO_NAMETEAMB = 12;
    public static final int SEEKINFO_NICKNAMETEAMB = 13;
    public static final int SEEKINFO_ABBREVIATIONTEAMB = 14;
    public static final int SEEKINFO_LEAGUE_NAME = 15;
    public static final int SEEKINFO_LEAGUE_ABBREVIATION = 16;
    public static final int STATE_ACTIVATED = 1;
    public static final int STATE_INACTIVATED = 2;
    public static final int SEEKCOMMAND_ADD = 1;
    public static final int SEEKCOMMAND_REMOVE = 2;
    public static final int SEEKCOMMANDRESULT_OK = 1;
    public static final int SEEKCOMMANDRESULT_NOK = 2;
    public static final int SEEKMANAGEACTION_ACTIVATE = 1;
    public static final int SEEKMANAGEACTION_DEACTIVATE = 2;
    public static final int SEEKMANAGEACTION_DELETE = 3;
    public static final int SEEKMANAGEMENTRESULT_OK = 1;
    public static final int SEEKMANAGEMENTRESULT_NOK = 2;
    public static final int ALERTTYPE_START = 1;
    public static final int ALERTTYPE_END = 2;
    public static final int RESETSEEKTYPE_UNDEFINED = 0;
    public static final int RESETSEEKTYPE_TO_DEFAULT = 1;
    public static final int RESETSEEKTYPE_ANONYMIZE = 2;

    public void setSeekCommand(int var1, int var2, int var3);

    public void manageSeek(int var1, int var2);

    public void manageSeek2(int var1, int var2, int var3, int var4);

    public void getTeamsOfLeague(int var1);

    public void getLeagues();

    public void reset(int var1);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

