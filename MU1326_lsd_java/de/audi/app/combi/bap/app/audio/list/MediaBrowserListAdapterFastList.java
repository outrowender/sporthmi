/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.bap.fw.arrays.AbstractArrayJobListMonitor;
import de.audi.app.bap.fw.arrays.ArrayJobHandler;
import de.audi.app.bap.fw.arrays.ArrayJobList;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.AbstractListAdapterFastListAudio;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListHandler;
import de.audi.app.combi.bap.dsi.fastlist.audio.DSIFastListMediaBrowser;
import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListMediaBrowser;
import de.audi.app.combi.bap.fw.arrays.GetArrayIndicationFastList;
import de.audi.app.combi.bap.fw.arrays.fastlist.ArrayHeaderFastList;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPMediaBrowserListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;

public final class MediaBrowserListAdapterFastList
extends AbstractListAdapterFastListAudio {
    private final IDSIFastListMediaBrowser dsiFastListControllerMediaBrowser = new DSIFastListMediaBrowser();
    private final ArrayJobHandler jobHandler;
    private volatile boolean currentListSizeNotification = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPMediaBrowserListEntry;

    public MediaBrowserListAdapterFastList(CombiModuleAudio combiModuleAudio, MediaBrowserListHandler mediaBrowserListHandler) {
        super(mediaBrowserListHandler);
        this.jobHandler = new ArrayJobHandler(combiModuleAudio, mediaBrowserListHandler);
    }

    private DataMediaBrowser convertArrayElement(CombiBAPArrayElement combiBAPArrayElement) {
        DataMediaBrowser dataMediaBrowser = new DataMediaBrowser();
        if (combiBAPArrayElement instanceof CombiBAPMediaBrowserListEntry) {
            CombiBAPMediaBrowserListEntry combiBAPMediaBrowserListEntry = (CombiBAPMediaBrowserListEntry)combiBAPArrayElement;
            dataMediaBrowser.pos = combiBAPMediaBrowserListEntry.getPosID();
            dataMediaBrowser.fileType = combiBAPMediaBrowserListEntry.getFileType();
            dataMediaBrowser.fileState = combiBAPMediaBrowserListEntry.getFileState();
            dataMediaBrowser.fileName = combiBAPMediaBrowserListEntry.getFileName();
        } else {
            this.logChannel.log(10000, "[MediaBrowserListAdapterFastList#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPMediaBrowserListEntry == null ? (class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPMediaBrowserListEntry = MediaBrowserListAdapterFastList.class$("de.audi.atip.interapp.combi.bap.audio.data.CombiBAPMediaBrowserListEntry")) : class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPMediaBrowserListEntry).getName(), (Object)combiBAPArrayElement.getClass().getName());
        }
        return dataMediaBrowser;
    }

    public boolean sendFullRangeUpdate() {
        if (this.dsiFastListControllerMediaBrowser != null) {
            this.sendCurrentListSize();
        }
        return false;
    }

    private void sendCurrentListSize() {
        this.logChannel.log(10000000, "[MediaBrowserListAdapterFastList#sendCurrentListSize] called (currentListSizeNotification=%1)", this.currentListSizeNotification);
        if (this.currentListSizeNotification) {
            this.dsiFastListControllerMediaBrowser.pushCurrentListSizeMediaBrowser(this.listHandler.getCurrentListSize());
        }
    }

    public boolean isSpontaneousStatusRequestSupported() {
        return false;
    }

    public void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray) {
        if (getArrayIndication.getArrayHeader() instanceof ArrayHeaderFastList) {
            if (this.dsiFastListControllerMediaBrowser != null) {
                int n;
                DataMediaBrowser[] dataMediaBrowserArray = new DataMediaBrowser[combiBAPArrayElementArray.length];
                for (n = 0; n < combiBAPArrayElementArray.length; ++n) {
                    dataMediaBrowserArray[n] = this.convertArrayElement(combiBAPArrayElementArray[n]);
                }
                n = this.jobHandler.isJobListActive() ? 2 : 0;
                int n2 = ((MediaBrowserListHandler)this.listHandler).isPlaybackFolder() ? 65535 : 0;
                this.dsiFastListControllerMediaBrowser.responseMediaBrowser(getArrayIndication.getAsgID(), getArrayIndication.getTaID(), this.listHandler.getCurrentListSize(), n2, n, ((ArrayHeaderFastList)getArrayIndication.getArrayHeader()).getArrayHeader());
                this.dsiFastListControllerMediaBrowser.responseMediaBrowserArray(dataMediaBrowserArray);
            }
            this.jobHandler.notifyStatusReceived(getArrayIndication);
        }
    }

    public void sendChangedArrayRequest(ListDelta listDelta) {
    }

    public void setNotificationReceptionList(boolean bl) {
    }

    public void setNotificationCurrentListSizes(boolean bl) {
        this.currentListSizeNotification = bl;
        if (bl) {
            this.sendCurrentListSize();
        }
    }

    public void addMediaBrowserJob(int n, int n2, ArrayHeader arrayHeader) {
        this.jobHandler.addSingleJob(new GetArrayIndicationFastList(n, n2, new ArrayHeaderFastList(arrayHeader)));
    }

    public void addMediaBrowserJobs(int n, int n2, ArrayHeader[] arrayHeaderArray) {
        GetArrayIndication[] getArrayIndicationArray = new GetArrayIndication[arrayHeaderArray.length];
        for (int i2 = 0; i2 < arrayHeaderArray.length; ++i2) {
            getArrayIndicationArray[i2] = new GetArrayIndicationFastList(n, n2, new ArrayHeaderFastList(arrayHeaderArray[i2]));
        }
        this.jobHandler.addJobList(getArrayIndicationArray, (AbstractArrayJobListMonitor)new MediaBrowserJobListMonitor(this.logChannel));
    }

    public int[] getDSINotifications() {
        return new int[0];
    }

    public IDSIController getDSIController() {
        return this.dsiFastListControllerMediaBrowser;
    }

    public int getDSIListID() {
        return -1;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class MediaBrowserJobListMonitor
    extends AbstractArrayJobListMonitor {
        public MediaBrowserJobListMonitor(LogChannel logChannel) {
            super(logChannel);
        }

        public void epilogue(CommandList commandList) {
            if (commandList instanceof ArrayJobList) {
                MediaBrowserListAdapterFastList.this.dsiFastListControllerMediaBrowser.responseMediaBrowserJobs(255, 10);
            }
            super.epilogue(commandList);
        }

        public void notifyJobFinished(int n) {
            MediaBrowserListAdapterFastList.this.dsiFastListControllerMediaBrowser.responseMediaBrowserJobs(n, 0);
        }

        public void notifyJobCancelled(int n) {
            MediaBrowserListAdapterFastList.this.dsiFastListControllerMediaBrowser.responseMediaBrowserJobs(n, 2);
        }
    }
}

