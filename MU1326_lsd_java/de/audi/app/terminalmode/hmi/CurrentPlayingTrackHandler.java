/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;

public class CurrentPlayingTrackHandler
extends DefaultEventListener
implements ITerminalModeComponent {
    private static final String LOGCLASS = "CurrentPlayingTrackHandler";
    private final LogChannel logger;
    private final IContext context;
    private final ModelGroup nowPlayingGroup;
    private final IStateHandler stateHandler;

    public CurrentPlayingTrackHandler(IContext iContext, IStateHandler iStateHandler) {
        this.context = iContext;
        this.logger = iContext.getLogger().hmi();
        this.nowPlayingGroup = new ModelGroup();
        this.stateHandler = iStateHandler;
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.nowPlayingGroup.add(this.context.getLabelModel(3200025));
        this.nowPlayingGroup.add(this.context.getLabelModel(3200027));
        this.nowPlayingGroup.add(this.context.getLabelModel(3200029));
        this.nowPlayingGroup.add(this.context.getLabelModel(3200028));
        this.nowPlayingGroup.add(this.context.getLabelModel(3200030));
        this.nowPlayingGroup.add(this.context.getRangeModel(3200026));
        this.nowPlayingGroup.add(this.context.getChoiceModel(3200068));
        this.context.getEventBus().registerListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.context.getEventBus().unregisterListener(this);
    }

    public void updateNowPlayingData(TrackDataChangedEvent trackDataChangedEvent) {
        this.logger.log(1000000, "[%1.updateNowPlayingData]", (Object)LOGCLASS);
        this.context.getLabelModel(3200025).setText(trackDataChangedEvent.getTitle());
        this.context.getLabelModel(3200027).setText(trackDataChangedEvent.getAlbum());
        this.context.getLabelModel(3200029).setText(trackDataChangedEvent.getArtist());
    }

    public void updatePlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
        boolean bl;
        boolean bl2 = trackPlayPositionEvent.getPlayTime() == 0 && trackPlayPositionEvent.getRemainTime() == 0 && this.stateHandler.getCurrentState().getStateForResource(Resource.AUDIO_MEDIA).is(ResourceState.NORMAL);
        boolean bl3 = bl = trackPlayPositionEvent.getTotalTimeOfTrack() == 0 && this.stateHandler.getCurrentState().getStateForResource(Resource.AUDIO_MEDIA).is(ResourceState.NORMAL);
        if (bl2 || bl) {
            this.context.getChoiceModel(3200068).setValue(0);
        } else {
            this.context.getChoiceModel(3200068).setValue(1);
            this.context.getLabelModel(3200028).setText(trackPlayPositionEvent.getRestrictedPlayTimeStr());
            this.context.getLabelModel(3200030).setText(trackPlayPositionEvent.getRemainTimeStr());
            RangeModelApp rangeModelApp = this.context.getRangeModel(3200026);
            rangeModelApp.setLimits(0, trackPlayPositionEvent.getRestrictedTotalTime(), 1);
            rangeModelApp.setValue(trackPlayPositionEvent.getRestrictedPlayTime());
        }
        this.nowPlayingGroup.flush();
    }
}

