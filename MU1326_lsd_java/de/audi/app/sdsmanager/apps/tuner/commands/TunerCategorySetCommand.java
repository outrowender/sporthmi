/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;

public class TunerCategorySetCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestHandler;
    private final TunerService tunerService;
    private final byte source;

    public TunerCategorySetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, TunerService tunerService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.nBestHandler = nBestStorageAccess;
        this.tunerService = tunerService;
        this.source = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

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
                this.logger.log(100000, "%1#execute: unknown parameter source=%2!", (Object)this.getName(), (long)this.source);
            }
        }
        if (l == 0L || l == -1L) {
            this.logger.log(100000, "%1#execute: Category ID not found: %2!", (Object)this.getName(), l);
            this.sendResult(10005);
            return;
        }
        this.logger.log(10000000, "%1#execute: categoryID=%2!", (Object)this.getName(), l);
        byte by = this.tunerService.tuneEnsembleByID(l);
        this.logger.log(10000000, "%1#execute: ensembleSetReply=%2!", (Object)this.getName(), (long)by);
        String string = SDSUtils.getStringForObjID(l, this.nBestHandler.getMatchingPicklist((byte)0));
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(100000, "%1#execute: no ensemble with id=%2 found", (Object)this.getName(), l);
            this.sendResult(10005);
            return;
        }
        SDSModelAccess.setListLineDataGetModel(string);
        this.sendResult(by == 0 ? 10005 : 10008);
    }

    protected void handleSDSLineNumbering() {
        SDSUtils.updateSDSNumbers(false);
    }
}

