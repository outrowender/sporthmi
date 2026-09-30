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
    public void setListener(BaseListModelListener var1);

    public void update(List var1, DabStation var2);

    public int getSelected();

    public DabListRow getRow(int var1);

    public int getIndexForUniqueID(long var1);

    public int getLength();

    public void setFolderStates(SimpleIntIntMap var1);

    public SimpleIntIntMap getFolderStates();

    public void setSelectedIndex(int var1, DabStation var2, int var3);

    public void setReceptionStatus(int var1, int var2);

    public void setPrefImgType(int var1);
}

