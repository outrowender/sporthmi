/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.interapp.NaviOnlineService$MapStateService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;

public class MapStateServiceImpl
implements NaviOnlineService$MapStateService {
    private static final String MAP_VIEW_DAY;
    private static final String MAP_VIEW_NIGHT;
    private final LogChannel logChannel;
    private final RemoteHMIServiceEvo remoteHMIServiceEvo;

    public MapStateServiceImpl(LogChannel logChannel, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        this.logChannel = logChannel;
        this.remoteHMIServiceEvo = remoteHMIServiceEvo;
    }

    @Override
    public void onDayNightViewChanged(boolean bl) {
        this.logChannel.log(1078071040, "MapStateServiceImpl#onDayNightViewChanged: called with isNightView = %1", bl);
        String string = bl ? "night" : "day";
        RemoteHMIAction remoteHMIAction = this.remoteHMIServiceEvo.getAction(199357701);
        remoteHMIAction.getParameters().putString("mapViewStatus", string);
        this.remoteHMIServiceEvo.invokeAction(remoteHMIAction);
    }
}

