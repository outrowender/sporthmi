/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;

class MapContentSyncHandler$8
extends NavCommand {
    private final /* synthetic */ MapContentSyncHandler this$0;

    MapContentSyncHandler$8(MapContentSyncHandler mapContentSyncHandler, String string) {
        this.this$0 = mapContentSyncHandler;
        super(string);
    }

    @Override
    public void execute() {
        int[] nArray = this.this$0.naviMap.getSetup().getPoiVisibleUid();
        boolean[] blArray = this.this$0.naviMap.getSetup().getPoiVisibleStatus();
        this.this$0.getLogger().log(-2137614336, "MapContentSyncHandler#backupDynamicPOIVisibilityAndHide(): uidOrig: %1, visibilityOrig: %2", nArray == null ? 0L : (long)nArray.length, blArray == null ? 0L : (long)blArray.length);
        if (nArray != null && blArray != null) {
            int[] nArray2 = new int[nArray.length];
            boolean[] blArray2 = new boolean[blArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                nArray2[i2] = nArray[i2];
                blArray2[i2] = false;
            }
            this.this$0.getLogger().log(-2137614336, "Context#performPoiTypeVisibilityBackup( %3 ): sSetupPoiVisibleUid.length: %1, sBackupPoiVisibleUid.length: %2", nArray == null ? 0L : (long)nArray.length, MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sBackupPoiVisibleUid == null ? 0L : (long)MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sBackupPoiVisibleUid.length);
            MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sPoiTypeVisibilityDirty = true;
            if (MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sBackupPoiVisibleUid == null) {
                MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sBackupPoiVisibleUid = new int[nArray.length];
                System.arraycopy((Object)nArray, 0, (Object)MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sBackupPoiVisibleUid, 0, nArray.length);
            }
            if (MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sBackupPoiVisibleStatus == null) {
                MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sBackupPoiVisibleStatus = new boolean[blArray.length];
                System.arraycopy((Object)blArray, 0, (Object)MapContentSyncHandler.access$300((MapContentSyncHandler)this.this$0).sBackupPoiVisibleStatus, 0, blArray.length);
            }
            this.this$0.naviMap.getMVRequest().ehSetCategoryVisibility(this.this$0.naviMap.getCurrentMapStyle(), nArray2, blArray2);
        }
        this.getCommandList().commandFinished();
    }
}

