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
    private static final long TIMER_DEFAULT_DELAY;
    private final INaviAudioHandler naviAudioHandler;
    private IFrameworkAccess framework;
    private LogChannel logger;
    private Timer showTimer;

    public EvoTrafficMiniMapView(ITrafficMiniMap iTrafficMiniMap, IFrameworkAccess iFrameworkAccess, INaviAudioHandler iNaviAudioHandler, LogChannel logChannel) {
        super(iTrafficMiniMap, logChannel);
        this.framework = iFrameworkAccess;
        this.naviAudioHandler = iNaviAudioHandler;
        this.logger = logChannel;
        this.showTimer = new Timer("EvoTrafficMiniMapView#Timer", 0, true, this);
        this.init();
    }

    @Override
    public void initModels() {
        this.choiceModelImageID = this.framework.getHMIService().getChoiceModel(-1306393088);
        this.choiceModelSettingEnebled = this.framework.getHMIService().getChoiceModel(-1105066496);
        this.choiceModelPopupControl = this.framework.getHMIService().getChoiceModel(-81656320);
    }

    @Override
    public boolean displayMiniMap(ResourceInformation resourceInformation) {
        this.logger.log(1078071040, "EvoTrafficMiniMapView#displayMiniMap resourceInformation=%1", (Object)resourceInformation);
        boolean bl = super.displayMiniMap(resourceInformation);
        this.logger.log(1078071040, "EvoTrafficMiniMapView#displayMiniMap displayed=%1", bl);
        if (bl) {
            this.naviAudioHandler.requestBeepTone(120, 14);
            this.showTimer.restart();
        }
        return bl;
    }

    @Override
    public void hideMiniMap() {
        this.logger.log(1078071040, "EvoTrafficMiniMapView#hideMiniMap");
        super.hideMiniMap();
        this.showTimer.cancel();
    }

    @Override
    public void fireTimer(Timer timer) {
        this.hideMiniMap();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    public void cleanup() {
        if (this.showTimer != null) {
            this.showTimer.cancel();
            this.showTimer = null;
        }
    }
}

