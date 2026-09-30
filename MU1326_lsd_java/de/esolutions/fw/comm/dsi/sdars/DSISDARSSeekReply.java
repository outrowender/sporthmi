/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public interface DSISDARSSeekReply {
    public static final String IPL_COMM_UUID = "aad0da89-00fe-53a6-9ddd-4c4d8882a364";
    public static final String IPL_COMM_INTERFACE_KEY = "22be2a53-fa6a-58fd-a5af-f425ae6fb99c";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.20";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.20";

    public void updateSeekPossibility(SeekPossibility var1, int var2) throws MethodException;

    public void updateSeekList(SeekEntry[] var1, int var2) throws MethodException;

    public void updateLeagueList(LeagueEntry[] var1, int var2) throws MethodException;

    public void updateTrafficWeatherList(TrafficWxEntry[] var1, int var2) throws MethodException;

    public void updateSeekAlert(SeekAlert var1, int var2) throws MethodException;

    public void setSeekCommandResult(int var1) throws MethodException;

    public void manageSeekResult(int var1) throws MethodException;

    public void teamsOfLeague(TeamEntry[] var1) throws MethodException;

    public void leagues(LeagueEntry[] var1) throws MethodException;

    public void updateRegisteredTeams(TeamEntry[] var1, int var2) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

