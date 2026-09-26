/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.dsi.carlife.DSICarlifeDefaultListener;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeListenerDistributor;
import de.audi.app.terminalmode.smartphone.carlife.DSIMHIConstantsMapper;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.Resource;

public class CarlifeHMISetModeHandler
extends DSICarlifeDefaultListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IContext context;
    private final DSICarlife dsiCarlife;
    private final DSIMHIConstantsMapper mapper;
    private volatile IDSISmartphoneManager$RequestModeChangeCallback callback;

    public CarlifeHMISetModeHandler(LogChannel logChannel, IContext iContext, DSICarlife dSICarlife, DSIMHIConstantsMapper dSIMHIConstantsMapper, CarlifeListenerDistributor carlifeListenerDistributor) {
        this.logger = logChannel;
        this.context = iContext;
        this.dsiCarlife = dSICarlife;
        this.mapper = dSIMHIConstantsMapper;
        carlifeListenerDistributor.addListener(new DSICarlifeListener[]{this});
    }

    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager$RequestModeChangeCallback iDSISmartphoneManager$RequestModeChangeCallback) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[%1.requestModeChange]", (Object)"CarlifeHMISetModeHandler");
        }
        this.callback = iDSISmartphoneManager$RequestModeChangeCallback;
        this.dsiCarlife.setMode(this.mapper.createResources(tMState), this.mapper.createAppStates(tMState));
    }

    @Override
    public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
        if (null != this.callback) {
            this.callback.modeChanged();
            this.callback = null;
        } else {
            this.logger.log(10000, "[%1.responseSetMode] Response without request.", (Object)"CarlifeHMISetModeHandler");
        }
    }
}

