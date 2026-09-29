/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPMediaBrowserListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_Data;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class MediaBrowserListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPMediaBrowserListEntry;

    public MediaBrowserListAdapterBAP(AbstractCombiModule abstractCombiModule, MediaBrowserListHandler mediaBrowserListHandler) {
        super(abstractCombiModule, 36, mediaBrowserListHandler);
    }

    @Override
    protected void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray, StatusArray statusArray) {
        MediaBrowser_StatusArray mediaBrowser_StatusArray = (MediaBrowser_StatusArray)statusArray;
        mediaBrowser_StatusArray.activeListPos = ((MediaBrowserListHandler)this.listHandler).isPlaybackFolder() ? -65536 : 0;
        super.sendStatusRequest(getArrayIndication, combiBAPArrayElementArray, mediaBrowser_StatusArray);
    }

    @Override
    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        MediaBrowser_Data mediaBrowser_Data = new MediaBrowser_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPMediaBrowserListEntry) {
            CombiBAPMediaBrowserListEntry combiBAPMediaBrowserListEntry = (CombiBAPMediaBrowserListEntry)combiBAPArrayElement;
            mediaBrowser_Data.setPos(combiBAPMediaBrowserListEntry.getPosID());
            mediaBrowser_Data.fileType = combiBAPMediaBrowserListEntry.getFileType();
            mediaBrowser_Data.fileState.importNotPlayable = combiBAPMediaBrowserListEntry.hasFileState(64);
            mediaBrowser_Data.fileState.importPending = combiBAPMediaBrowserListEntry.hasFileState(32);
            mediaBrowser_Data.fileState.importRunning = combiBAPMediaBrowserListEntry.hasFileState(16);
            mediaBrowser_Data.fileState.deadLink = combiBAPMediaBrowserListEntry.hasFileState(8);
            mediaBrowser_Data.fileState.corruptedFileFolder = combiBAPMediaBrowserListEntry.hasFileState(4);
            mediaBrowser_Data.fileState.drmProteced = combiBAPMediaBrowserListEntry.hasFileState(2);
            mediaBrowser_Data.fileState.emptyFolder = combiBAPMediaBrowserListEntry.hasFileState(1);
            mediaBrowser_Data.fileName.setContent(combiBAPMediaBrowserListEntry.getFileName());
        } else {
            this.logChannel.log(10000, "[MediaBrowserListAdapterBAP#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPMediaBrowserListEntry == null ? (class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPMediaBrowserListEntry = MediaBrowserListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.audio.data.CombiBAPMediaBrowserListEntry")) : class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPMediaBrowserListEntry).getName(), (Object)super.getClass().getName());
        }
        return mediaBrowser_Data;
    }

    @Override
    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        MediaBrowser_Data mediaBrowser_Data = new MediaBrowser_Data(arrayHeader);
        mediaBrowser_Data.setPos(n);
        return mediaBrowser_Data;
    }

    @Override
    protected ChangedArray createChangedArraySerializer() {
        return new MediaBrowser_ChangedArray();
    }

    @Override
    protected StatusArray createStatusArraySerializer() {
        return new MediaBrowser_StatusArray();
    }

    @Override
    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[0] || blArray[15];
        boolean bl2 = blArray[0] || blArray[1];
        boolean bl3 = blArray[0] || blArray[1];
        boolean bl4 = blArray[0] || blArray[2];
        return CombiBAPMediaBrowserListEntry.getRecordAddress(bl, bl2, bl3, bl4);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

