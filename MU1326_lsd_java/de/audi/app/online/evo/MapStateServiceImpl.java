/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;

public class MapStateServiceImpl
implements NaviOnlineService.MapStateService {
    private static final String MAP_VIEW_DAY = "day";
    private static final String MAP_VIEW_NIGHT = "night";
    private final LogChannel logChannel;
    private final RemoteHMIServiceEvo remoteHMIServiceEvo;

    public MapStateServiceImpl(LogChannel logChannel, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        this.logChannel = logChannel;
        this.remoteHMIServiceEvo = remoteHMIServiceEvo;
    }

    public void onDayNightViewChanged(boolean bl) {
        this.logChannel.log(1000000, "MapStateServiceImpl#onDayNightViewChanged: called with isNightView = %1", bl);
        String string = bl ? MAP_VIEW_NIGHT : MAP_VIEW_DAY;
        RemoteHMIAction remoteHMIAction = this.remoteHMIServiceEvo.getAction(100000011);
        remoteHMIAction.getParameters().putString("mapViewStatus", string);
        this.remoteHMIServiceEvo.invokeAction(remoteHMIAction);
    }
}

