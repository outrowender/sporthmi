/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.TMDeviceStorekeeper;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.diagnosis.IDiagnosisManager;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.util.IStreamableStorageContainer;
import de.audi.atip.msg.MsgListener;
import java.util.ArrayList;
import org.osgi.framework.ServiceRegistration;

public class FactoryResetMessageHandler
implements ITerminalModeComponent {
    private final IServiceManager serviceManager;
    private final ISmartphoneIntegrationDSIController smartphoneIntegrationDSIController;
    private final IDiagnosisManager diagnosisManager;
    private final IStreamableStorageContainer storage;
    private final TMDeviceStorekeeper tmDeviceStorageKeeper;
    private ServiceRegistration registeredService;
    static /* synthetic */ Class class$de$audi$app$terminalmode$util$IStreamableStorageContainer;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceStorekeeper;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public FactoryResetMessageHandler(IContext iContext) {
        this.serviceManager = iContext.getServiceManager();
        this.smartphoneIntegrationDSIController = iContext.getSMIDSIController();
        this.diagnosisManager = iContext.getDiagnosisManager();
        this.storage = (IStreamableStorageContainer)iContext.get(class$de$audi$app$terminalmode$util$IStreamableStorageContainer == null ? (class$de$audi$app$terminalmode$util$IStreamableStorageContainer = FactoryResetMessageHandler.class$("de.audi.app.terminalmode.util.IStreamableStorageContainer")) : class$de$audi$app$terminalmode$util$IStreamableStorageContainer);
        this.tmDeviceStorageKeeper = (TMDeviceStorekeeper)iContext.get(class$de$audi$app$terminalmode$device$TMDeviceStorekeeper == null ? (class$de$audi$app$terminalmode$device$TMDeviceStorekeeper = FactoryResetMessageHandler.class$("de.audi.app.terminalmode.device.TMDeviceStorekeeper")) : class$de$audi$app$terminalmode$device$TMDeviceStorekeeper);
    }

    public void init() {
        this.registeredService = this.serviceManager.registerService(class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = FactoryResetMessageHandler.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener, new MsgListener(){

            public void processMsg(int n) {
                if (n == 94) {
                    FactoryResetMessageHandler.this.doFactoryReset();
                }
            }
        }, IServiceManager.EMPTY_PARAMETERS);
        this.diagnosisManager.addCommandProvider(-1, new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"requestFactoryReset"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                FactoryResetMessageHandler.this.doFactoryReset();
            }
        });
    }

    public void deinit() {
        this.registeredService.unregister();
    }

    private void doFactoryReset() {
        this.tmDeviceStorageKeeper.setFactoryResetRequested(true);
        this.storage.writeListToStorage(new ArrayList());
        this.smartphoneIntegrationDSIController.requestFactorySettings();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

