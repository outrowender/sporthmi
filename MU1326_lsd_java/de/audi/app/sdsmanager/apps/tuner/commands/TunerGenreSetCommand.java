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
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;

public class TunerGenreSetCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestHandler;
    private final TunerService tunerService;
    private final TunerSDSHandler tunerSDSHandler;
    private byte source;

    public TunerGenreSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, TunerService tunerService, TunerSDSHandler tunerSDSHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.nBestHandler = nBestStorageAccess;
        this.tunerService = tunerService;
        this.tunerSDSHandler = tunerSDSHandler;
        this.source = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        long l = 0L;
        switch (this.source) {
            case 0: {
                l = SDSUtils.getObjIDForFirstEntryOrGG(this.nBestHandler, this.logger);
                break;
            }
            case 1: {
                l = TunerSDSUtils.lookupSelectedTunerPicklistElement(this.nBestHandler, this.tunerService, this.logger);
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: unknown parameter source=%2!", (Object)this.getName(), (long)this.source);
            }
        }
        SDSListEntry sDSListEntry = this.tunerSDSHandler.getGenreById(l);
        if (l == 0L || l == -1L || sDSListEntry == null) {
            this.logger.log(-1601830656, "%1#execute: Genre not found!", (Object)this.getName());
            this.sendResult(10005);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: recognizedGenreID=%2", (Object)this.getName(), l);
        SDSModelAccess.setListLineDataGetModel(sDSListEntry.getName());
        byte by = this.tunerService.selectGenre(l);
        int n = by == 1 ? 10008 : 10005;
        this.logger.log(-2137614336, "%1#execute: sdsResult=%2", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }

    @Override
    protected void handleSDSLineNumbering() {
        SDSUtils.updateSDSNumbers(false);
    }
}

