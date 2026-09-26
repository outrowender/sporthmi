/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.map.IView;

public interface IMapContentView
extends IView {
    default public BaseListModelApp getStandardList() {
    }

    default public BaseListModelApp getStandardListLevel2() {
    }

    default public BaseListModelApp getStandardListLevel3() {
    }

    default public ChoiceModelApp getCheckAllStandard() {
    }

    default public BaseListModelApp getKMLLayersList() {
    }

    default public BaseListModelApp getPPOIList() {
    }

    default public void setMyAudiAvailable(boolean bl) {
    }
}

