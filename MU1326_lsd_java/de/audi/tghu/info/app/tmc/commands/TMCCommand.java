/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public abstract class TMCCommand
extends Command
implements DSITmcListener {
    protected AppTMC tmcApp;
    protected DSITmcListener defaultListener;

    public TMCCommand(AppTMC appTMC, LogChannel logChannel) {
        super(logChannel);
        this.tmcApp = appTMC;
        this.defaultListener = (DSITmcListener)this.tmcApp.getTMCHandler().getDSIDefaultHandler();
    }

    public TMCCommand(AppTMC appTMC, LogChannel logChannel, String string) {
        super(logChannel, string);
        this.tmcApp = appTMC;
        this.defaultListener = (DSITmcListener)this.tmcApp.getTMCHandler().getDSIDefaultHandler();
    }

    public String toString() {
        return this.getClass().getName();
    }

    public abstract void execute();

    public void updateEventsOnRoute(long l, int n) {
        this.defaultListener.updateEventsOnRoute(l, n);
    }

    public void updateIsEngineeringMode(boolean bl, int n) {
        this.defaultListener.updateIsEngineeringMode(bl, n);
    }

    public void updateIsTmcProAvailable(boolean bl, int n) {
        this.defaultListener.updateIsTmcProAvailable(bl, n);
    }

    public void windowChange(int n) {
        this.defaultListener.windowChange(n);
    }

    public void updateCurrentLanguage(String string, int n) {
        this.defaultListener.updateCurrentLanguage(string, n);
    }

    public void updateTmcState(int n, int n2) {
        this.defaultListener.updateTmcState(n, n2);
    }

    public void tmcWindowResult(int n, int n2, TmcListElement[] tmcListElementArray) {
        this.defaultListener.tmcWindowResult(n, n2, tmcListElementArray);
    }

    public void setMessageFilterResult(int n, int n2) {
        this.defaultListener.setMessageFilterResult(n, n2);
    }

    public void updateEventsTotal(int n, long l, long l2, int n2) {
        this.defaultListener.updateEventsTotal(n, l, l2, n2);
    }

    public void updateActiveTrafficSources(int[] nArray, int n) {
        this.logger.log(1000000, "TMCCommand#updateActiveTrafficSources: %1", (Object)nArray);
        this.defaultListener.updateActiveTrafficSources(nArray, n);
    }

    public void asyncException(int n, String string, int n2) {
        this.defaultListener.asyncException(n, string, n2);
        String string2 = new Buffer().append("asyncException(").append(n).append(", ").append(string).append(", ").append(n2).append(")").toString();
        this.getCommandList().commandAborted(string2);
    }

    public void getMessageIdsForListElementResult(long[] lArray) {
        this.defaultListener.getMessageIdsForListElementResult(lArray);
    }

    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
        this.defaultListener.getBoundingRectangleForTrafficMessagesResult(navRectangle);
    }

    public void updateAreaWarning(AreaWarningInfo areaWarningInfo, int n) {
        this.defaultListener.updateAreaWarning(areaWarningInfo, n);
    }

    public void updateAreaWarnings(AreaWarningInfo[] areaWarningInfoArray, int n) {
        this.defaultListener.updateAreaWarnings(areaWarningInfoArray, n);
    }

    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray, int n) {
        this.defaultListener.updateLocalHazardInformation(localHazardInformationArray, n);
    }

    public void updateTrafficFlowStatisticsStatus(boolean bl, int n) {
        this.defaultListener.updateTrafficFlowStatisticsStatus(bl, n);
    }

    public void updateTrafficSourceInformation(TrafficSource[] trafficSourceArray, int n) {
        this.defaultListener.updateTrafficSourceInformation(trafficSourceArray, n);
    }
}

