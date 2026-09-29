/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.util.List;

interface IFolderListModel {
    default public void setListener(BaseListModelListener baseListModelListener) {
    }

    default public void update(List list, DabStation dabStation) {
    }

    default public int getSelected() {
    }

    default public DabListRow getRow(int n) {
    }

    default public int getIndexForUniqueID(long l) {
    }

    default public int getLength() {
    }

    default public void setFolderStates(SimpleIntIntMap simpleIntIntMap) {
    }

    default public SimpleIntIntMap getFolderStates() {
    }

    default public void setSelectedIndex(int n, DabStation dabStation, int n2) {
    }

    default public void setReceptionStatus(int n, int n2) {
    }

    default public void setPrefImgType(int n) {
    }
}

