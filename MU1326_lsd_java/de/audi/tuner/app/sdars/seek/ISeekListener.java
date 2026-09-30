/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public interface ISeekListener {
    public void updateSeekPossibility(SeekPossibility var1);

    public void updateSeekList(SeekEntry[] var1);

    public void updateLeagueList(LeagueEntry[] var1);

    public void updateTrafficWeatherList(TrafficWxEntry[] var1);

    public void updateSeekAlert(SeekAlert var1);

    public void setSeekCommandResult(int var1);

    public void manageSeekResult(int var1);

    public void teamsOfLeague(TeamEntry[] var1);

    public void leagues(LeagueEntry[] var1);

    public void updateRegisteredTeams(TeamEntry[] var1);
}

