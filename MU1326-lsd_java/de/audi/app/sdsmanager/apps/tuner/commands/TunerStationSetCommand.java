/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.tuner.TunerSDSHandler;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.TunerService$TunerSettingResult;
import de.audi.atip.log.LogChannel;

public class TunerStationSetCommand
extends AbstractSystemCallCommand {
    protected final NBestStorageAccess nBestHandler;
    protected final TunerService tunerService;
    private final TunerSDSHandler tunerHandler;
    protected int source;

    public TunerStationSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, TunerService tunerService, TunerSDSHandler tunerSDSHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.nBestHandler = nBestStorageAccess;
        this.tunerService = tunerService;
        this.tunerHandler = tunerSDSHandler;
        this.source = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        long[] lArray = new long[1];
        switch (this.source) {
            case 0: {
                lArray = this.handleNBestSelection();
                break;
            }
            case 1: {
                long l = TunerSDSUtils.lookupSelectedTunerPicklistElement(this.nBestHandler, this.tunerService, this.logger);
                if (l != 0L && l != -1L) {
                    lArray[0] = l;
                }
                this.logger.log(-2137614336, "%1#execute: source=picklist, stationID=%2", (Object)this.getName(), l);
                break;
            }
            case 2: {
                this.logger.log(-2137614336, "%1#execute: source=other source");
                lArray = this.getStationIDsFromOtherSource();
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: Unrecognized source %2!", (Object)this.getName(), (long)this.source);
            }
        }
        if (SDSUtils.isEmpty(lArray)) {
            this.logger.log(-1601830656, "%1#execute: Invalid recognizedStationId!", (Object)this.getName());
            this.sendResult(10005);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: relevant stationIDs:%2", (Object)this.getName(), (Object)SDSUtils.toString(lArray));
        int n = this.tuneStationByID(lArray);
        this.sendResult(n);
    }

    protected long[] getStationIDsFromOtherSource() {
        long l = this.tunerHandler.getSelectedStationID();
        this.tunerHandler.setSelectedStationID(-1L);
        if (l != -1L) {
            return new long[]{l};
        }
        return new long[1];
    }

    protected int tuneStationByID(long[] lArray) {
        TunerService$TunerSettingResult tunerService$TunerSettingResult = this.tunerService.tuneStationByID(lArray);
        String string = this.getStationName(tunerService$TunerSettingResult);
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(-1601830656, "%1#tuneStationByID: no station with id=%2 found", (Object)this.getName(), tunerService$TunerSettingResult.getObjectID());
            return 10005;
        }
        SDSModelAccess.setListLineDataGetModel(string);
        int n = this.getStationSetReply(tunerService$TunerSettingResult, lArray);
        this.logger.log(-2137614336, "%1#tuneStationByID: tunerStationSetReply=%2!", (Object)this.getName(), (long)n);
        return n;
    }

    protected String getStationName(TunerService$TunerSettingResult tunerService$TunerSettingResult) {
        if (tunerService$TunerSettingResult == null) {
            return "";
        }
        long l = tunerService$TunerSettingResult.getObjectID();
        IPicklist iPicklist = this.nBestHandler.getMatchingPicklist((byte)0);
        return SDSUtils.getStringForObjID(l, iPicklist);
    }

    private long[] handleNBestSelection() {
        IPicklistSlot iPicklistSlot = this.nBestHandler.getMatchingPicklist((byte)0).getSlot(0, 0);
        if (iPicklistSlot == null) {
            this.logger.log(-1601830656, "%1#handleNBestSelection: picklist slot null!", (Object)this.getName());
            return new long[0];
        }
        long l = iPicklistSlot.getObjID();
        int n = this.nBestHandler.getMatchingPicklist((byte)0).get(0).getGraphGroupIndex();
        if (l != -1L && n == -1) {
            this.logger.log(-2137614336, "%1#handleNBestSelection: source=nbest, stationID=%2", (Object)this.getName(), l);
            return new long[]{l};
        }
        if (n == -1) {
            this.logger.log(10000, "%1#handleNBestSelection: picklist slot null!", (Object)this.getName());
            return new long[0];
        }
        this.nBestHandler.resetPicklistsWithHistory();
        IPicklist iPicklist = this.nBestHandler.getMatchingPicklist((byte)0);
        return SDSUtils.getSlotObjIDsForGGIndex(iPicklist, n, this.logger);
    }

    protected int getStationSetReply(TunerService$TunerSettingResult tunerService$TunerSettingResult, long[] lArray) {
        byte by = tunerService$TunerSettingResult.getResultCode();
        int n = TunerSDSUtils.getWBSResult(by, this.logger);
        this.logger.log(-2137614336, "%1#getStationSetReply: stationSetReplyCode=%2, wbsResult=%3!", (Object)this.getName(), (long)by, (long)n);
        if (n == 10005) {
            this.logger.log(-1601830656, "%1#getStationSetReply: Error occurred, clearing slot model!", (Object)this.getName());
            SDSModelAccess.setSlotModel(1, "");
            return n;
        }
        long l = tunerService$TunerSettingResult.getObjectID();
        int n2 = lArray.length;
        this.logger.log(-2137614336, "%1#getStationSetReply: stationIdToBeTuned=%2, recognitionLength=%3!", (Object)this.getName(), l, (long)n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            if (l != lArray[i2]) continue;
            IPicklistSlot iPicklistSlot = this.nBestHandler.getMatchingPicklist((byte)0).getSlot(i2, 0);
            SDSModelAccess.setSlotModel(1, iPicklistSlot != null ? iPicklistSlot.getText() : "");
        }
        return n;
    }

    @Override
    protected void handleSDSLineNumbering() {
        SDSUtils.updateSDSNumbers(false);
    }
}

