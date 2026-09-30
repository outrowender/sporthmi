/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.map.IView;

public interface IMapContentView
extends IView {
    public BaseListModelApp getStandardList();

    public BaseListModelApp getStandardListLevel2();

    public BaseListModelApp getStandardListLevel3();

    public ChoiceModelApp getCheckAllStandard();

    public BaseListModelApp getKMLLayersList();

    public BaseListModelApp getPPOIList();

    public void setMyAudiAvailable(boolean var1);
}

