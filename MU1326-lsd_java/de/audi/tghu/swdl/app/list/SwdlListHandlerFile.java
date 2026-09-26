/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandlerDeviceInfo;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemFile;
import de.audi.tghu.swdl.app.list.SwdlListItemModule;

public class SwdlListHandlerFile
extends AbstractSwdlListHandlerDeviceInfo {
    static final int ITEM_CELL_COUNT;

    public SwdlListHandlerFile(SwdlEnv swdlEnv, IDeviceInfoManager iDeviceInfoManager, ListModelApp listModelApp) {
        super(iDeviceInfoManager, swdlEnv, listModelApp, listModelApp.getID(), 9);
    }

    public SwdlListItemFile getSwdlFile(int n) {
        SwdlListItemFile swdlListItemFile = null;
        if (this.getBase() != null) {
            swdlListItemFile = (SwdlListItemFile)this.getBase().getChild(n);
        }
        return swdlListItemFile;
    }

    @Override
    public ListCell[] getNewRow() {
        ListCell[] listCellArray = super.getNewRow();
        listCellArray[4] = new IntegerListCell(0, 1);
        listCellArray[5] = new TextListCell("");
        listCellArray[6] = new TextListCell("");
        listCellArray[7] = new IntegerListCell(0, 1);
        listCellArray[8] = new IntegerListCell(0, 3);
        return listCellArray;
    }

    public void updateList(String[] stringArray) {
        if (this.checkBase()) {
            this.logList("File", stringArray);
            this.adjustListLength(stringArray.length);
            ISwdlListItem[] iSwdlListItemArray = new SwdlListItemFile[stringArray.length];
            int n = this.getLayout();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                iSwdlListItemArray[i2] = new SwdlListItemFile(this.getDeviceInfoManager(), this.getBase(), i2, stringArray[i2], this.getTextFactory(), n, !this.isStandardSelection() && !this.isPrecondition());
            }
            this.setEntries(iSwdlListItemArray);
            this.updateList();
        }
    }

    public void setVersions(long[] lArray) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            SwdlListItemFile swdlListItemFile = this.getSwdlFile(i2);
            if (swdlListItemFile == null) continue;
            swdlListItemFile.setVersion(lArray[i2]);
        }
        this.updateList();
    }

    public void setTargetVersions(long[] lArray) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            SwdlListItemFile swdlListItemFile = this.getSwdlFile(i2);
            if (swdlListItemFile == null) continue;
            swdlListItemFile.setTargetVersion(lArray[i2]);
        }
        this.updateList();
    }

    public void setSelection(int n) {
        for (int i2 = 0; i2 < this.getEntries().length; ++i2) {
            SwdlListItemFile swdlListItemFile = (SwdlListItemFile)this.getEntries()[i2];
            if (swdlListItemFile.isChecked() && n == 0) {
                swdlListItemFile.select(i2);
                continue;
            }
            if (swdlListItemFile.isChecked() || n != 1) continue;
            swdlListItemFile.select(i2);
            if (((SwdlListItemModule)swdlListItemFile.getParent()).isNoExclusiveBoloUpdate) break;
        }
    }
}

