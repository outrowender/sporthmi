/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.sdars.seek.ISeekListener;
import org.dsi.ifc.sdars.DSISDARSSeekListener;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class DSISDARSSeekListenerImpl
implements DSISDARSSeekListener {
    private final LogChannel lc;
    private final ISeekListener seekListener;

    public DSISDARSSeekListenerImpl(LogChannel logChannel, ISeekListener iSeekListener) {
        this.lc = logChannel;
        this.seekListener = iSeekListener;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[DSISDARSSeekListenerImpl.asyncException]", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility, int n) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.updateSeekPossibility] %1 valid:%2", (Object)seekPossibility, (long)n);
        if (seekPossibility != null && n == 1) {
            try {
                this.seekListener.updateSeekPossibility(seekPossibility);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSSeekListenerImpl.updateSeekPossibility]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray, int n) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.updateSeekList] #list:%1 valid:%2", (long)this.size(seekEntryArray), (long)n);
        if (seekEntryArray != null && n == 1) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                    this.lc.log(14808325, "[DSISDARSSeekListenerImpl.updateSeekList] %2: %1", (Object)seekEntryArray[i2], (long)i2);
                }
            }
            try {
                this.seekListener.updateSeekList(seekEntryArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSSeekListenerImpl.updateSeekList]", (Throwable)exception);
            }
        }
    }

    private int size(Object[] objectArray) {
        return objectArray != null ? objectArray.length : -1;
    }

    @Override
    public void updateLeagueList(LeagueEntry[] leagueEntryArray, int n) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.updateLeagueList] #list:%1 valid:%2", (long)this.size(leagueEntryArray), (long)n);
        if (leagueEntryArray != null && n == 1) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < leagueEntryArray.length; ++i2) {
                    this.lc.log(14808325, "%2: %1", (Object)leagueEntryArray[i2], (long)i2);
                }
            }
            try {
                this.seekListener.updateLeagueList(leagueEntryArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSSeekListenerImpl.updateLeagueList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray, int n) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.updateTrafficWeatherList] #list:%1 valid:%2", (long)this.size(trafficWxEntryArray), (long)n);
        if (trafficWxEntryArray != null && n == 1) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < trafficWxEntryArray.length; ++i2) {
                    this.lc.log(14808325, "%2: %1", (Object)trafficWxEntryArray[i2], (long)i2);
                }
            }
            try {
                this.seekListener.updateTrafficWeatherList(trafficWxEntryArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSSeekListenerImpl.updateTrafficWeatherList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSeekAlert(SeekAlert seekAlert, int n) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.updateSeekAlert] %1 valid:%2", (Object)seekAlert, (long)n);
        if (seekAlert != null && n == 1) {
            try {
                this.seekListener.updateSeekAlert(seekAlert);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSSeekListenerImpl.updateSeekAlert]", (Throwable)exception);
            }
        }
    }

    @Override
    public void setSeekCommandResult(int n) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.setSeekCommandResult] %1", (long)n);
        try {
            this.seekListener.setSeekCommandResult(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSISDARSSeekListenerImpl.setSeekCommandResult]", (Throwable)exception);
        }
    }

    @Override
    public void manageSeekResult(int n) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.manageSeekResult] %1", (long)n);
        try {
            this.seekListener.manageSeekResult(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSISDARSSeekListenerImpl.manageSeekResult]", (Throwable)exception);
        }
    }

    @Override
    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.teamsOfLeague] #list:%1 ", (long)this.size(teamEntryArray));
        if (teamEntryArray != null) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < teamEntryArray.length; ++i2) {
                    this.lc.log(14808325, "%2: %1", (Object)teamEntryArray[i2], (long)i2);
                }
            }
            try {
                this.seekListener.teamsOfLeague(teamEntryArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSSeekListenerImpl.teamsOfLeague]", (Throwable)exception);
            }
        }
    }

    @Override
    public void leagues(LeagueEntry[] leagueEntryArray) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.leagues] #list:%1 valid:%2", (long)this.size(leagueEntryArray));
        if (leagueEntryArray != null) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < leagueEntryArray.length; ++i2) {
                    this.lc.log(14808325, "%2: %1", (Object)leagueEntryArray[i2], (long)i2);
                }
            }
            try {
                this.seekListener.leagues(leagueEntryArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSSeekListenerImpl.leagues]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateRegisteredTeams(TeamEntry[] teamEntryArray, int n) {
        this.lc.log(-2137614336, "[DSISDARSSeekListenerImpl.updateRegisteredTeams] #list:%1 valid:%2", (long)this.size(teamEntryArray), (long)n);
        if (teamEntryArray != null && n == 1) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < teamEntryArray.length; ++i2) {
                    this.lc.log(14808325, "%2: %1", (Object)teamEntryArray[i2], (long)i2);
                }
            }
            try {
                this.seekListener.updateRegisteredTeams(teamEntryArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSSeekListenerImpl.updateRegisteredTeams]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }
}

