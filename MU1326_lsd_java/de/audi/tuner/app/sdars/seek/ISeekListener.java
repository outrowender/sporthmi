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
    default public void updateSeekPossibility(SeekPossibility seekPossibility) {
    }

    default public void updateSeekList(SeekEntry[] seekEntryArray) {
    }

    default public void updateLeagueList(LeagueEntry[] leagueEntryArray) {
    }

    default public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray) {
    }

    default public void updateSeekAlert(SeekAlert seekAlert) {
    }

    default public void setSeekCommandResult(int n) {
    }

    default public void manageSeekResult(int n) {
    }

    default public void teamsOfLeague(TeamEntry[] teamEntryArray) {
    }

    default public void leagues(LeagueEntry[] leagueEntryArray) {
    }

    default public void updateRegisteredTeams(TeamEntry[] teamEntryArray) {
    }
}

