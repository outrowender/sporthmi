/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$8$2;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class MapcodeInputSequence$8$2$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ MapcodeInputSequence$8$2 this$2;

    MapcodeInputSequence$8$2$2(MapcodeInputSequence$8$2 mapcodeInputSequence$8$2, NaviServiceListener naviServiceListener) {
        this.this$2 = mapcodeInputSequence$8$2;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseMapCodeResult((byte)3);
    }
}

