/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INightDayModeHandler;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.NightDayModeHandler$1;
import de.audi.app.terminalmode.NightDayModeHandler$2;
import de.audi.app.terminalmode.NightDayModeHandler$3;
import de.audi.app.terminalmode.NightDayModeHandler$NightModeRequest;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;

public class NightDayModeHandler
implements INightDayModeHandler,
ITerminalModeComponent {
    protected static final String LOGCLASS;
    private final DSIActivator dsiGeneralVehicleStatesActivator;
    private final IContext context;
    private final LogChannel logger;
    private volatile boolean requestedDisplayNightDesign;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public NightDayModeHandler(IContext iContext, LogChannel logChannel) {
        this.context = iContext;
        this.logger = logChannel;
        this.dsiGeneralVehicleStatesActivator = new DSIActivator(iContext.getFramework(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = NightDayModeHandler.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = NightDayModeHandler.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener).getName(), new Integer(0), new NightDayModeHandler$1(this), new NightDayModeHandler$2(this));
        iContext.getDiagnosisManager().addCommandProvider(-1, new NightDayModeHandler$3(this));
    }

    @Override
    public void init() {
        this.dsiGeneralVehicleStatesActivator.start(this.context.getFramework().getBundleCxt());
    }

    @Override
    public void deinit() {
    }

    @Override
    public boolean getRequestedNightMode() {
        return this.requestedDisplayNightDesign;
    }

    private void updateRequestedNightDesign(boolean bl) {
        this.requestedDisplayNightDesign = bl;
        this.context.getCommandListHelper().create().addSingle(new NightDayModeHandler$NightModeRequest(this.context, this.requestedDisplayNightDesign)).execute("NightDayModeHandler.executeCommand()");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(NightDayModeHandler nightDayModeHandler) {
        return nightDayModeHandler.logger;
    }

    static /* synthetic */ void access$100(NightDayModeHandler nightDayModeHandler, boolean bl) {
        nightDayModeHandler.updateRequestedNightDesign(bl);
    }
}

