/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public interface DSISDARSSeekListener
extends DSIListener {
    public void updateSeekPossibility(SeekPossibility var1, int var2);

    public void updateSeekList(SeekEntry[] var1, int var2);

    public void updateLeagueList(LeagueEntry[] var1, int var2);

    public void updateTrafficWeatherList(TrafficWxEntry[] var1, int var2);

    public void updateSeekAlert(SeekAlert var1, int var2);

    public void setSeekCommandResult(int var1);

    public void manageSeekResult(int var1);

    public void teamsOfLeague(TeamEntry[] var1);

    public void leagues(LeagueEntry[] var1);

    public void updateRegisteredTeams(TeamEntry[] var1, int var2);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

