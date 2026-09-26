/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class MapcodeInputSequence$7
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$7(MapcodeInputSequence mapcodeInputSequence, NaviServiceListener naviServiceListener) {
        this.this$0 = mapcodeInputSequence;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseMapCodeResult((byte)3);
    }
}

