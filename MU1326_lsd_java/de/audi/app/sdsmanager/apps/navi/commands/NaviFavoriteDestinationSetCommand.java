/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviFavoriteDestinationSetCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandler sdsHandler;
    private final NaviService naviService;
    private final NBestStorageAccess nBestStorage;
    private final byte source;

    public NaviFavoriteDestinationSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSHandler naviSDSHandler, NaviService naviService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandler;
        this.naviService = naviService;
        this.nBestStorage = nBestStorageAccess;
        this.source = (byte)Math.max(SDSUtils.retrieveInteger(iSystemCallParameterArray, 0), 0);
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] source=%2", (Object)this.getName(), (long)this.source);
        switch (this.source) {
            case 0: {
                this.selectFavoriteFromNBest();
                return;
            }
            case 1: {
                this.selectFavoriteFromLine();
                return;
            }
        }
        this.logger.log(10000000, "[%1#execute] Unhandled source %2!", (Object)this.getName(), (long)this.source);
        this.sendResult(40001);
    }

    private void selectFavoriteFromLine() {
        this.logger.log(10000000, "[%1#selectFavoriteFromLine] called", (Object)this.getName());
        int n = SDSModelAccess.getEnumerationNumberStatus();
        if (n == -1) {
            this.sendResult(40007);
            return;
        }
        this.logger.log(10000000, "[%1#selectFavoriteFromLine] index of selected favorite=%2", (Object)this.getName(), (long)n);
        SDSModelAccess.setListLineDataGetModel(this.sdsHandler.getFavoriteDestinationByIndex(n));
        this.sdsHandler.setSDSAddressInputMode((byte)3);
        this.naviService.setFavoriteDestinationByIndex(n);
    }

    private void selectFavoriteFromNBest() {
        this.logger.log(10000000, "[%1#selectFavoriteFromNBest] called", (Object)this.getName());
        long l = SDSUtils.getSelectedObjectId(this.nBestStorage, this.logger, 0);
        this.logger.log(10000000, "[%1#selectFavoriteFromNBest] id of selected favorite=%2", (Object)this.getName(), l);
        SDSModelAccess.setListLineDataGetModel(this.sdsHandler.getFavoriteDestination(l));
        this.sdsHandler.setSDSAddressInputMode((byte)3);
        this.naviService.setFavoriteDestinationById(l);
    }

    public void responseFavoriteDestinationSet(byte by) {
        this.logger.log(10000000, "[%1#responseFavoriteDestinationSet] result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        this.logger.log(10000000, "[%1#responseFavoriteDestinationSet] sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

