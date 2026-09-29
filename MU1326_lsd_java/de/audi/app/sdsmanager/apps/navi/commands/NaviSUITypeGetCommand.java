/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;

public class NaviSUITypeGetCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;

    public NaviSUITypeGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
    }

    @Override
    public void execute() {
        IPicklistSlot iPicklistSlot = this.nBestStorage.getMatchingPicklist((byte)0).getSlot(0, 0);
        if (iPicklistSlot == null) {
            this.logger.log(-1601830656, "%1#execute: picklist slot null, sending ERROR!", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        int n = iPicklistSlot.getIndex();
        this.logger.log(-2137614336, "%1#execute: slotIndex=%2", (Object)this.getName(), (long)n);
        int n2 = this.nBestStorage.getMatchingPicklist((byte)0).get(0).getGraphGroupIndex();
        if (n == -1 && n2 == -1) {
            this.logger.log(-1601830656, "%1#execute: invalid slot index and no GG, sending ERROR!", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        this.nBestStorage.resetPicklistsWithHistory();
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
        int n3 = n == -1 ? SDSUtils.getSlotIndexForGGIndex(iPicklist, n2, this.logger) : iPicklist.getPositionForSlotIndex(n);
        if (n3 == -1) {
            this.logger.log(-1601830656, "%1#execute: elementPosition=-1, -> use the first entry instead!", (Object)this.getName(), (long)n);
            n3 = 0;
        }
        this.logger.log(-2137614336, "%1#execute: Storing elementPosition %2 in slot label!", (Object)this.getName(), (long)n3);
        SDSModelAccess.setSlotModel(1, String.valueOf(n3));
        this.sendResult(1083965440);
    }
}

