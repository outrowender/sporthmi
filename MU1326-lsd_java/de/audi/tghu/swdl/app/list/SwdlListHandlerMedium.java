/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandlerText;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemMedium;

public class SwdlListHandlerMedium
extends AbstractSwdlListHandlerText {
    private ISelectionManager selectionManager = null;
    private static final int[] SORTED_MEDIA_LIST = new int[]{4, 5, 2, 3, 6, 8, 1, 7};
    private int m_availableMediaFlags;
    private final boolean isSimulator;
    private int[] mediaInfo;

    public SwdlListHandlerMedium(SwdlEnv swdlEnv, ISelectionManager iSelectionManager, ListModelApp listModelApp) {
        super(swdlEnv, listModelApp, listModelApp.getID(), 2);
        this.selectionManager = iSelectionManager;
        this.isSimulator = swdlEnv.isSimulator();
        this.mediaInfo = new int[0];
    }

    final ISelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    @Override
    public ListCell[] getNewRow() {
        ListCell[] listCellArray = new ListCell[this.getNrCol()];
        listCellArray[0] = new IntegerListCell(-1, 99);
        listCellArray[1] = new IntegerListCell(1, 1);
        return listCellArray;
    }

    private boolean containsMedium(int n) {
        if (this.mediaInfo != null) {
            for (int i2 = 0; i2 < this.mediaInfo.length; ++i2) {
                if (n != this.mediaInfo[i2]) continue;
                return true;
            }
        }
        return false;
    }

    private boolean insertMissingMedia(byte by) {
        boolean bl = false;
        for (int i2 = 0; i2 < 8; ++i2) {
            if ((by & 1) == 1) {
                if (!this.containsMedium(i2 + 1)) {
                    int[] nArray = new int[this.mediaInfo.length + 1];
                    System.arraycopy((Object)this.mediaInfo, 0, (Object)nArray, 0, this.mediaInfo.length);
                    nArray[this.mediaInfo.length] = i2 + 1;
                    this.mediaInfo = nArray;
                    bl = true;
                    this.getLogHMI().log(-2137614336, "[SwdlListHandlerMedium] insertMissingMedia(): %1", (long)(i2 + 1));
                } else {
                    this.getLogHMI().log(-2137614336, "[SwdlListHandlerMedium] insertMissingMedia():  %1 is already inserted", (long)(i2 + 1));
                }
            }
            by = (byte)(by >> 1);
        }
        return bl;
    }

    public void updateList(int[] nArray) {
        this.getLogHMI().log(-2137614336, "[SwdlListHandlerMedium] New Medium Info received. ");
        if (nArray == null) {
            this.getLogHMI().log(-2137614336, "[SwdlListHandlerMedium] <null> list ");
            nArray = new int[]{};
        }
        this.mediaInfo = nArray;
        if (this.getLogHMI().getCurrentLogThreshold() == 14808325) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.getLogHMI().log(14808325, "[SwdlListHandlerMedium] Medium %1: %2 ", (long)i2, (long)nArray[i2]);
            }
        }
        this.adjustListLength(nArray.length);
        if (this.checkBase() && nArray.length > 0) {
            this.ensureCorrectMediaOrder(nArray);
            if (7 == nArray[nArray.length - 1]) {
                int[] nArray2 = new int[nArray.length - 1];
                System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, nArray2.length);
                nArray = nArray2;
                this.getList().removeRow(this.getList().getLength() - 1);
                this.getLogHMI().log(-2137614336, "[SwdlListHandlerMedium] updateList(): skip not allowed media %1", (long)0);
            }
            ISwdlListItem[] iSwdlListItemArray = new SwdlListItemMedium[nArray.length];
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                iSwdlListItemArray[i3] = new SwdlListItemMedium(this.getSelectionManager(), this.getBase(), nArray[i3], true, this.getTextFactory());
            }
            this.setEntries(iSwdlListItemArray);
            this.updateList();
            this.updateStateOfAvailableAndUnavailableMedia();
        }
    }

    private void ensureCorrectMediaOrder(int[] nArray) {
        int n = 0;
        block0: for (int i2 = 0; i2 < SORTED_MEDIA_LIST.length; ++i2) {
            int n2 = SORTED_MEDIA_LIST[i2];
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                int n3 = nArray[i3];
                if (n2 != n3) continue;
                nArray[i3] = nArray[n];
                nArray[n] = n3;
                ++n;
                continue block0;
            }
        }
    }

    public void updateAvailableMedia(byte by) {
        this.m_availableMediaFlags = (0xFF & by) << 1;
        if (this.insertMissingMedia(by)) {
            this.getLogHMI().log(-2137614336, "[SwdlListHandlerMedium] updateAvailableMedia(%1): update media list", (long)by);
            this.updateList(this.mediaInfo);
        } else {
            this.updateStateOfAvailableAndUnavailableMedia();
        }
    }

    private void updateStateOfAvailableAndUnavailableMedia() {
        if (this.checkBase() && !this.isSimulator) {
            ISwdlListItem[] iSwdlListItemArray = this.getEntries();
            if (null == iSwdlListItemArray || 0 == iSwdlListItemArray.length) {
                return;
            }
            for (int i2 = 0; i2 < iSwdlListItemArray.length; ++i2) {
                ISwdlListItem iSwdlListItem = iSwdlListItemArray[i2];
                int n = 1 << iSwdlListItem.getId();
                if (0 != (this.m_availableMediaFlags & n)) {
                    iSwdlListItem.setSelectable(true);
                    continue;
                }
                iSwdlListItem.setSelectable(false);
            }
            this.updateList();
        }
    }
}

