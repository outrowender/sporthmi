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
    private static final String LOGCLASS;
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

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"CurrentPlayingTrackHandler");
        this.nowPlayingGroup.add(this.context.getLabelModel(433336320));
        this.nowPlayingGroup.add(this.context.getLabelModel(466890752));
        this.nowPlayingGroup.add(this.context.getLabelModel(500445184));
        this.nowPlayingGroup.add(this.context.getLabelModel(483667968));
        this.nowPlayingGroup.add(this.context.getLabelModel(517222400));
        this.nowPlayingGroup.add(this.context.getRangeModel(450113536));
        this.nowPlayingGroup.add(this.context.getChoiceModel(1154756608));
        this.context.getEventBus().registerListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"CurrentPlayingTrackHandler");
        this.context.getEventBus().unregisterListener(this);
    }

    @Override
    public void updateNowPlayingData(TrackDataChangedEvent trackDataChangedEvent) {
        this.logger.log(1078071040, "[%1.updateNowPlayingData]", (Object)"CurrentPlayingTrackHandler");
        this.context.getLabelModel(433336320).setText(trackDataChangedEvent.getTitle());
        this.context.getLabelModel(466890752).setText(trackDataChangedEvent.getAlbum());
        this.context.getLabelModel(500445184).setText(trackDataChangedEvent.getArtist());
    }

    @Override
    public void updatePlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
        boolean bl;
        boolean bl2 = trackPlayPositionEvent.getPlayTime() == 0 && trackPlayPositionEvent.getRemainTime() == 0 && this.stateHandler.getCurrentState().getStateForResource(Resource.AUDIO_MEDIA).is(ResourceState.NORMAL);
        boolean bl3 = bl = trackPlayPositionEvent.getTotalTimeOfTrack() == 0 && this.stateHandler.getCurrentState().getStateForResource(Resource.AUDIO_MEDIA).is(ResourceState.NORMAL);
        if (bl2 || bl) {
            this.context.getChoiceModel(1154756608).setValue(0);
        } else {
            this.context.getChoiceModel(1154756608).setValue(1);
            this.context.getLabelModel(483667968).setText(trackPlayPositionEvent.getRestrictedPlayTimeStr());
            this.context.getLabelModel(517222400).setText(trackPlayPositionEvent.getRemainTimeStr());
            RangeModelApp rangeModelApp = this.context.getRangeModel(450113536);
            rangeModelApp.setLimits(0, trackPlayPositionEvent.getRestrictedTotalTime(), 1);
            rangeModelApp.setValue(trackPlayPositionEvent.getRestrictedPlayTime());
        }
        this.nowPlayingGroup.flush();
    }
}

