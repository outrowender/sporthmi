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
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.NullSimpleTuner$1;
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

    @Override
    public void setNotification(int[] nArray) {
        super.log();
    }

    @Override
    public void clearNotification(int[] nArray) {
        super.log();
    }

    @Override
    public int init() {
        super.log();
        return 0;
    }

    @Override
    public void deinit() {
        super.log();
    }

    @Override
    public boolean isDsiFound() {
        super.log();
        return false;
    }

    @Override
    public ITunerGUIHandler getGUIHandler() {
        super.log();
        return null;
    }

    @Override
    public void setDeviceService(DSIBase dSIBase) {
        super.log();
    }

    @Override
    public void seekStation(int n, int n2) {
        super.log();
    }

    public int getType() {
        super.log();
        return 0;
    }

    @Override
    public void resetToDefaultSettings() {
        super.log();
    }

    @Override
    public void setComponentUsage(boolean bl) {
        super.log();
    }

    @Override
    public void setComponentUnused() {
        super.log();
    }

    @Override
    public boolean forceStationListUpdate(boolean bl) {
        super.log();
        return false;
    }

    @Override
    public boolean isDeviceInUse() {
        this.log();
        return false;
    }

    @Override
    public void register(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void register(IGracenoteRequest iGracenoteRequest) {
        this.log();
    }

    @Override
    public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        this.log();
    }

    @Override
    public IRadioCmdManager getCmdManager() {
        return new NullRadioCmdManager(this.basics);
    }

    @Override
    public void setInitDone() {
        this.log();
    }

    @Override
    public void audioManagementJustBecameAvailable() {
        this.log();
    }

    public boolean isInitDone() {
        this.log();
        return false;
    }

    @Override
    public void executeInitialCommands() {
        this.log();
    }

    @Override
    public void initSetup() {
        this.log();
    }

    public TunerActionProxyListener getActionProxyListener() {
        this.log();
        return new TunerActionProxyListener();
    }

    @Override
    public void registerDsiUpDownListener(RadioInfo radioInfo) {
        this.log();
    }

    @Override
    public CmdDefaultListener getDSIUpManager() {
        this.log();
        return null;
    }

    @Override
    public TunerObjectContainer[] startScan() {
        this.log();
        return new TunerObjectContainer[0];
    }

    @Override
    public void stopScan() {
        this.log();
    }

    @Override
    public void performLanguageChange() {
        this.log();
    }

    @Override
    public void register(ITaggingManager iTaggingManager) {
        this.log();
    }

    @Override
    public void reRequestCoverArt() {
        this.log();
    }

    @Override
    public IRadioDatabaseListener getDatabaseListener() {
        return new NullSimpleTuner$1(this);
    }
}

