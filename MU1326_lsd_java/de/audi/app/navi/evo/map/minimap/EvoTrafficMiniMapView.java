/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.minimap;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMapView;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public class EvoTrafficMiniMapView
extends AbstractTrafficMiniMapView
implements TimerListener {
    private static final long TIMER_DEFAULT_DELAY = 10000L;
    private final INaviAudioHandler naviAudioHandler;
    private IFrameworkAccess framework;
    private LogChannel logger;
    private Timer showTimer;

    public EvoTrafficMiniMapView(ITrafficMiniMap iTrafficMiniMap, IFrameworkAccess iFrameworkAccess, INaviAudioHandler iNaviAudioHandler, LogChannel logChannel) {
        super(iTrafficMiniMap, logChannel);
        this.framework = iFrameworkAccess;
        this.naviAudioHandler = iNaviAudioHandler;
        this.logger = logChannel;
        this.showTimer = new Timer("EvoTrafficMiniMapView#Timer", 10000L, true, this);
        this.init();
    }

    public void initModels() {
        this.choiceModelImageID = this.framework.getHMIService().getChoiceModel(402098);
        this.choiceModelSettingEnebled = this.framework.getHMIService().getChoiceModel(402110);
        this.choiceModelPopupControl = this.framework.getHMIService().getChoiceModel(402171);
    }

    public boolean displayMiniMap(ResourceInformation resourceInformation) {
        this.logger.log(1000000, "EvoTrafficMiniMapView#displayMiniMap resourceInformation=%1", (Object)resourceInformation);
        boolean bl = super.displayMiniMap(resourceInformation);
        this.logger.log(1000000, "EvoTrafficMiniMapView#displayMiniMap displayed=%1", bl);
        if (bl) {
            this.naviAudioHandler.requestBeepTone(120, 14);
            this.showTimer.restart();
        }
        return bl;
    }

    public void hideMiniMap() {
        this.logger.log(1000000, "EvoTrafficMiniMapView#hideMiniMap");
        super.hideMiniMap();
        this.showTimer.cancel();
    }

    public void fireTimer(Timer timer) {
        this.hideMiniMap();
    }

    public void cancelTimer(Timer timer) {
    }

    public void cleanup() {
        if (this.showTimer != null) {
            this.showTimer.cancel();
            this.showTimer = null;
        }
    }
}

