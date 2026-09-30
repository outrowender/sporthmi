/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INightDayModeHandler;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.dsi.DefaultDSIGeneralVehicleStatesListener;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;

public class NightDayModeHandler
implements INightDayModeHandler,
ITerminalModeComponent {
    protected static final String LOGCLASS = "NightDayModeHandler";
    private final DSIActivator dsiGeneralVehicleStatesActivator;
    private final IContext context;
    private final LogChannel logger;
    private volatile boolean requestedDisplayNightDesign;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public NightDayModeHandler(IContext iContext, LogChannel logChannel) {
        this.context = iContext;
        this.logger = logChannel;
        this.dsiGeneralVehicleStatesActivator = new DSIActivator(iContext.getFramework(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = NightDayModeHandler.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = NightDayModeHandler.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener).getName(), new Integer(0), new DefaultDSIGeneralVehicleStatesListener(){

            public void updateDisplayDayNightDesign(boolean bl, int n) {
                NightDayModeHandler.this.logger.log(1000000, "<- [%1.updateDisplayDayNightDesign] %2", (Object)NightDayModeHandler.LOGCLASS, (Object)(bl ? "night" : "day"));
                NightDayModeHandler.this.updateRequestedNightDesign(bl);
            }
        }, new IDSIClient(){

            public void setDSI(DSIBase dSIBase) {
            }

            public int[] getAutoNotifications() {
                return new int[]{16};
            }
        });
        iContext.getDiagnosisManager().addCommandProvider(-1, new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"requestNightMode", "requestDayMode"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                NightDayModeHandler.this.updateRequestedNightDesign("requestNightMode".equals(string));
            }
        });
    }

    public void init() {
        this.dsiGeneralVehicleStatesActivator.start(this.context.getFramework().getBundleCxt());
    }

    public void deinit() {
    }

    public boolean getRequestedNightMode() {
        return this.requestedDisplayNightDesign;
    }

    private void updateRequestedNightDesign(boolean bl) {
        this.requestedDisplayNightDesign = bl;
        this.context.getCommandListHelper().create().addSingle(new NightModeRequest(this.context, this.requestedDisplayNightDesign)).execute("NightDayModeHandler.executeCommand()");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private static class NightModeRequest
    extends AbstractDSICommand {
        private static final String LOGCLASS = "NightModeRequest";
        private final boolean useNightMode;
        final IDSISmartphoneManager smartphoneDSIManager;

        public NightModeRequest(IContext iContext, boolean bl) {
            super(iContext.getLogger().main(), LOGCLASS, iContext, iContext.getSmartphoneDSIManager());
            this.useNightMode = bl;
            this.smartphoneDSIManager = iContext.getSmartphoneDSIManager();
        }

        public void execute() {
            this.logger.log(1000000, "[%1.execute] %2", (Object)LOGCLASS, (Object)(this.useNightMode ? "night" : "day"));
            this.smartphoneDSIManager.requestNightMode(this.useNightMode);
            this.getCommandList().commandFinished();
        }
    }
}

