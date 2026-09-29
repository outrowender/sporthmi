/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;

class OnlineDSIPoiListener$2
extends CommandResponse {
    private final /* synthetic */ int val$source;
    private final /* synthetic */ String val$searchText;
    private final /* synthetic */ String[] val$suggestions;
    private final /* synthetic */ OnlineDSIPoiListener this$0;

    OnlineDSIPoiListener$2(OnlineDSIPoiListener onlineDSIPoiListener, int n, String string, String[] stringArray) {
        this.this$0 = onlineDSIPoiListener;
        this.val$source = n;
        this.val$searchText = string;
        this.val$suggestions = stringArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIPoiOnlineSearchListener)dSIListener).poiSpellingSuggestion(this.val$source, this.val$searchText, this.val$suggestions);
    }
}

