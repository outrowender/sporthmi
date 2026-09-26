/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$8;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class MapcodeInputSequence$8$1
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ MapcodeInputSequence$8 this$1;

    MapcodeInputSequence$8$1(MapcodeInputSequence$8 mapcodeInputSequence$8, NaviServiceListener naviServiceListener) {
        this.this$1 = mapcodeInputSequence$8;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseMapCodeResult((byte)3);
    }
}

