/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class Logger {
    public final LogChannel main;
    public final LogChannel hmi;
    public final LogChannel audio;
    public final LogChannel announce;
    public final LogChannel rse;
    public final LogChannel timer;
    public final LogChannel sm;
    public final LogChannel startup;
    public final LogChannel dd;
    public final LogChannel radioText;
    public final LogChannel jobs;
    public final LogChannel amfmDSI;
    public final LogChannel amfmGUI;
    public final LogChannel amfmList;
    public final LogChannel amfmDeepDebug;
    public final LogChannel sds;
    public final LogChannel combi;
    public LogChannel dabDSI;
    public LogChannel dabGUI;
    public LogChannel dabList;
    public LogChannel dabDeepDebug;
    public LogChannel dabData;
    public LogChannel uniDSI;
    public LogChannel uniList;
    public LogChannel sdarsDSI;
    public LogChannel sdarsList;
    public LogChannel sdarsSeekDSI;
    public LogChannel sdarsRadioText;
    public LogChannel sdarsEPG;
    public final LogChannel tagging;
    public LogChannel truffles;
    public LogChannel history;
    public final LogChannel benchmark;
    private final IFrameworkAccess framework;
    public final LogChannel gracenote;
    public final LogChannel rsdb;

    public Logger(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.main = iFrameworkAccess.getLogChannel("App.Tuner.Main");
        this.hmi = iFrameworkAccess.getLogChannel("App.Tuner.HMI");
        this.audio = iFrameworkAccess.getLogChannel("App.Tuner.Audio");
        this.announce = iFrameworkAccess.getLogChannel("App.Tuner.Announce");
        this.rse = iFrameworkAccess.getLogChannel("App.Tuner.RSE");
        this.radioText = iFrameworkAccess.getLogChannel("App.Tuner.RadioText");
        this.timer = iFrameworkAccess.getLogChannel("App.Tuner.Timer");
        this.sm = iFrameworkAccess.getLogChannel("App.Tuner.SM");
        this.startup = iFrameworkAccess.getLogChannel("App.Tuner.Startup");
        this.dd = iFrameworkAccess.getLogChannel("App.Tuner.DeepDebug");
        this.jobs = iFrameworkAccess.getLogChannel("App.Tuner.Jobs");
        this.amfmDSI = iFrameworkAccess.getLogChannel("App.Tuner.AMFM.DSI");
        this.amfmGUI = iFrameworkAccess.getLogChannel("App.Tuner.AMFM.GUI");
        this.amfmList = iFrameworkAccess.getLogChannel("App.Tuner.AMFM.List");
        this.amfmDeepDebug = iFrameworkAccess.getLogChannel("App.Tuner.AMFM.DeepDebug");
        this.sds = iFrameworkAccess.getLogChannel("App.Tuner.SDS");
        this.combi = iFrameworkAccess.getLogChannel("App.Tuner.Combi");
        this.tagging = iFrameworkAccess.getLogChannel("App.Tuner.Tagging");
        this.benchmark = iFrameworkAccess.getLogChannel("Ext.Benchmark");
        this.truffles = iFrameworkAccess.getLogChannel("App.Tuner.Truffles");
        this.gracenote = iFrameworkAccess.getLogChannel("App.Tuner.Gracenote");
        this.rsdb = iFrameworkAccess.getLogChannel("App.Tuner.RSDB");
        this.history = iFrameworkAccess.getLogChannel("App.Tuner.History");
        this.dabDSI = null;
        this.dabGUI = null;
        this.dabData = null;
        this.dabList = null;
        this.dabDeepDebug = null;
        this.uniDSI = null;
        this.uniList = null;
        this.sdarsDSI = null;
        this.sdarsList = null;
        this.sdarsSeekDSI = null;
        this.sdarsRadioText = null;
    }

    public void initDABLogChannels() {
        if (this.dabDSI == null) {
            this.dabDSI = this.framework.getLogChannel("App.Tuner.DAB.DSI");
        }
        if (this.dabGUI == null) {
            this.dabGUI = this.framework.getLogChannel("App.Tuner.DAB.GUI");
        }
        if (this.dabList == null) {
            this.dabList = this.framework.getLogChannel("App.Tuner.DAB.List");
        }
        if (this.dabDeepDebug == null) {
            this.dabDeepDebug = this.framework.getLogChannel("App.Tuner.DAB.DeepDebug");
        }
        if (this.dabData == null) {
            this.dabData = this.framework.getLogChannel("App.Tuner.DAB.Data");
        }
    }

    public void initUniLogChannels() {
        if (this.uniDSI == null) {
            this.uniDSI = this.framework.getLogChannel("App.Tuner.Uni.DSI");
        }
        if (this.uniList == null) {
            this.uniList = this.framework.getLogChannel("App.Tuner.Uni.List");
        }
    }

    public void initSDARSLogChannels() {
        if (this.sdarsDSI == null) {
            this.sdarsDSI = this.framework.getLogChannel("App.Tuner.SDARS.DSI");
        }
        if (this.sdarsList == null) {
            this.sdarsList = this.framework.getLogChannel("App.Tuner.SDARS.List");
        }
        if (this.sdarsSeekDSI == null) {
            this.sdarsSeekDSI = this.sdarsDSI;
        }
        if (this.sdarsRadioText == null) {
            this.sdarsRadioText = this.framework.getLogChannel("App.Tuner.SDARS.RadioText");
        }
        if (this.sdarsEPG == null) {
            this.sdarsEPG = this.framework.getLogChannel("App.Tuner.SDARS.EPG");
        }
    }
}

