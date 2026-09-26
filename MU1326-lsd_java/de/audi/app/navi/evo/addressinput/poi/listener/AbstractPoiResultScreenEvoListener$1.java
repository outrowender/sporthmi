/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiResultScreenEvoListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AbstractPoiResultScreenEvoListener$1
implements NavLocationCallback {
    private final /* synthetic */ EvoListRow val$row;
    private final /* synthetic */ AbstractPoiResultScreenEvoListener this$0;

    AbstractPoiResultScreenEvoListener$1(AbstractPoiResultScreenEvoListener abstractPoiResultScreenEvoListener, EvoListRow evoListRow) {
        this.this$0 = abstractPoiResultScreenEvoListener;
        this.val$row = evoListRow;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AbstractPoiResultScreenEvoListener.access$000(this.this$0, navLocation, this.val$row);
        this.this$0.itemFocusedCallBack(navLocation);
    }
}

