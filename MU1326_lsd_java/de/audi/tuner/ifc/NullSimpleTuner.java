/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.interapp.def.NullService;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.NullRadioCmdManager;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.itunes.ITaggingManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class NullSimpleTuner
extends NullService
implements ISimpleTuner {
    private TunerBasics basics;

    public NullSimpleTuner(TunerBasics tunerBasics) {
        super(tunerBasics.getLogger().main, "ISimpleTuner");
        this.basics = tunerBasics;
    }

    public void setNotification(int[] nArray) {
        super.log();
    }

    public void clearNotification(int[] nArray) {
        super.log();
    }

    public int init() {
        super.log();
        return 0;
    }

    public void deinit() {
        super.log();
    }

    public boolean isDsiFound() {
        super.log();
        return false;
    }

    public ITunerGUIHandler getGUIHandler() {
        super.log();
        return null;
    }

    public void setDeviceService(DSIBase dSIBase) {
        super.log();
    }

    public void seekStation(int n, int n2) {
        super.log();
    }

    public int getType() {
        super.log();
        return 0;
    }

    public void resetToDefaultSettings() {
        super.log();
    }

    public void setComponentUsage(boolean bl) {
        super.log();
    }

    public void setComponentUnused() {
        super.log();
    }

    public boolean forceStationListUpdate(boolean bl) {
        super.log();
        return false;
    }

    public boolean isDeviceInUse() {
        this.log();
        return false;
    }

    public void register(DSIListener dSIListener) {
        this.log();
    }

    public void register(IGracenoteRequest iGracenoteRequest) {
        this.log();
    }

    public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        this.log();
    }

    public IRadioCmdManager getCmdManager() {
        return new NullRadioCmdManager(this.basics);
    }

    public void setInitDone() {
        this.log();
    }

    public void audioManagementJustBecameAvailable() {
        this.log();
    }

    public boolean isInitDone() {
        this.log();
        return false;
    }

    public void executeInitialCommands() {
        this.log();
    }

    public void initSetup() {
        this.log();
    }

    public TunerActionProxyListener getActionProxyListener() {
        this.log();
        return new TunerActionProxyListener();
    }

    public void registerDsiUpDownListener(RadioInfo radioInfo) {
        this.log();
    }

    public CmdDefaultListener getDSIUpManager() {
        this.log();
        return null;
    }

    public TunerObjectContainer[] startScan() {
        this.log();
        return new TunerObjectContainer[0];
    }

    public void stopScan() {
        this.log();
    }

    public void performLanguageChange() {
        this.log();
    }

    public void register(ITaggingManager iTaggingManager) {
        this.log();
    }

    public void reRequestCoverArt() {
        this.log();
    }

    public IRadioDatabaseListener getDatabaseListener() {
        return new IRadioDatabaseListener(){

            public void databaseReady(ILogoDatabase iLogoDatabase) {
            }
        };
    }
}

