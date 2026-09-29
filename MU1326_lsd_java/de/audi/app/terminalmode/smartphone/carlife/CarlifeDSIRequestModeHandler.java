/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.dsi.carlife.DSICarlifeDefaultListener;
import de.audi.app.terminalmode.smartphone.carlife.ApplicationUpdate;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIRequestModeHandler$1;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeListenerDistributor;
import de.audi.app.terminalmode.smartphone.carlife.DSIMHIConstantsMapper;
import de.audi.app.terminalmode.smartphone.carlife.ResourceUpdate;
import de.audi.app.terminalmode.smartphone.carlife.UpdateCarlifeModes;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.Generics;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.Resource;

public class CarlifeDSIRequestModeHandler
extends DSICarlifeDefaultListener
implements ITerminalModeComponent {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IStateHandler stateHandler;
    private final IContext context;
    private final DSICarlife dsiCarlife;
    private final DSIMHIConstantsMapper mapper;

    public CarlifeDSIRequestModeHandler(IStateHandler iStateHandler, IContext iContext, LogChannel logChannel, CarlifeListenerDistributor carlifeListenerDistributor, DSICarlife dSICarlife, DSIMHIConstantsMapper dSIMHIConstantsMapper) {
        this.stateHandler = iStateHandler;
        this.context = iContext;
        this.logger = logChannel;
        this.dsiCarlife = dSICarlife;
        this.mapper = dSIMHIConstantsMapper;
        this.dsiCarlife.setNotification(new int[]{3000}, null);
        carlifeListenerDistributor.addListener(new DSICarlifeListener[]{this});
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        if (!((Boolean)this.stateHandler.getServiceStartedProperty().get()).booleanValue()) {
            this.logger.log(-1601830656, "[%1.requestModeChange] southside error: before STARTED", (Object)"CarlifeDSIEventMaanager");
            TMState tMState = this.stateHandler.getCurrentState();
            this.dsiCarlife.responseModeChange(this.mapper.createResources(tMState), this.mapper.createAppStates(tMState));
            return;
        }
        GCopyOnWriteList gCopyOnWriteList = Generics.newCopyOnWriteArrayList();
        for (int i2 = 0; i2 < resourceArray.length; ++i2) {
            de.audi.app.terminalmode.statemachine.Resource resource = this.mapper.mapResource(resourceArray[i2].getResourceID());
            if (de.audi.app.terminalmode.statemachine.Resource.AUDIO_MEDIA.is(resource) && this.stateHandler.getCurrentState().getStateForResource(de.audi.app.terminalmode.statemachine.Resource.AUDIO_MEDIA).is(new ResourceState[]{ResourceState.PAUSED, ResourceState.PAUSED_BY_MUTE})) continue;
            gCopyOnWriteList.add(new ResourceUpdate(this.mapper.mapResource(resourceArray[i2].getResourceID()), this.mapper.mapResourceOwner(resourceArray[i2].getOwner())));
        }
        GCopyOnWriteList gCopyOnWriteList2 = Generics.newCopyOnWriteArrayList();
        for (int i3 = 0; i3 < appStateArray.length; ++i3) {
            gCopyOnWriteList2.add(new ApplicationUpdate(this.mapper.mapApplication(appStateArray[i3].getAppStateID()), this.mapper.mapAppOwner(appStateArray[i3].getOwner())));
        }
        this.context.getCommandListHelper().create().addSingle(new UpdateCarlifeModes(this.context, gCopyOnWriteList, gCopyOnWriteList2, this.stateHandler, new CarlifeDSIRequestModeHandler$1(this))).execute("CarlifeDSIEventMaanager.updateCarlifeModes");
    }

    static /* synthetic */ DSIMHIConstantsMapper access$000(CarlifeDSIRequestModeHandler carlifeDSIRequestModeHandler) {
        return carlifeDSIRequestModeHandler.mapper;
    }

    static /* synthetic */ DSICarlife access$100(CarlifeDSIRequestModeHandler carlifeDSIRequestModeHandler) {
        return carlifeDSIRequestModeHandler.dsiCarlife;
    }
}

