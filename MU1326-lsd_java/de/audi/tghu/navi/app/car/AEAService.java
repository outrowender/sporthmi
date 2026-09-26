/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.car.AudiEnergyAssistService;
import de.audi.atip.interapp.car.AudiEnergyAssistStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.car.AEAService$1;

public class AEAService
implements AudiEnergyAssistStateListener {
    private NavigationEnv env;
    private LogChannel logger;
    public static final int AEA_NOT_AVAILABLE;
    public static final int AEA_ENABLED;
    public static final int AEA_DISABLED;
    private int mAEAAvailable = 1;
    private int aeaState = -1;
    private AudiEnergyAssistService aeaService;
    private ChoiceModelApp chkAudiEnergyAssist;

    public AEAService(NavigationEnv navigationEnv) {
        this.logger = navigationEnv.getLogChannel("App.Map.Main");
        this.env = navigationEnv;
        this.chkAudiEnergyAssist = navigationEnv.getChoiceModel(1059194368);
        this.chkAudiEnergyAssist.setChoiceListener(new AEAService$1(this));
        this.updateAEAAvailable(1);
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    public void setAudiEnergyAssistService(AudiEnergyAssistService audiEnergyAssistService) {
        this.getLogger().log(-2137614336, "AEAService#setAudiEnergyAssistService() - %1", (Object)audiEnergyAssistService);
        this.aeaService = audiEnergyAssistService;
        if (this.aeaService != null) {
            try {
                this.aeaService.registerStateListener(this);
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "AEAService#setAudiEnergyAssistService() - ERROR=%1", (Throwable)exception);
            }
        } else {
            this.cleanup();
        }
    }

    public void cleanup() {
        this.getLogger().log(-2137614336, "AEAService#cleanup()");
        this.mAEAAvailable = -1;
        if (this.aeaService != null) {
            try {
                this.aeaService.deRegisterStateListener(this);
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "AEAService#cleanup() - ERROR=%1", (Throwable)exception);
            }
        }
    }

    @Override
    public synchronized void updateAEAAvailable(int n) {
        this.getLogger().log(-2137614336, "AEAService#updateAEAAvailable( %1 )", (long)n);
        this.mAEAAvailable = n;
        this.refreshModel();
        if (this.isAvailable()) {
            this.activeService(true);
        }
    }

    @Override
    public synchronized void updateAEASystemActive(boolean bl) {
        this.getLogger().log(-2137614336, "AEAService#updateAEASystemActive( %1 )", bl);
    }

    @Override
    public synchronized void updateAEASystemState(int n) {
        this.getLogger().log(-2137614336, "AEAService#updateAEASystemState( %1 )", (long)n);
        this.aeaState = n;
        this.refreshModel();
    }

    private void refreshModel() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1059194368);
        choiceModelApp.setStatus(0);
    }

    public void activeService(boolean bl) {
        this.getLogger().log(-2137614336, "AEAService#activeService( %1 )", bl);
        if (this.aeaService != null) {
            try {
                this.aeaService.setAEASystemActive(bl);
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "AEAService#activeService() - ERROR=%1", (Throwable)exception);
            }
        } else {
            this.getLogger().log(-2137614336, "AEAService#activeService() - Audi Energy Service is not available");
        }
    }

    public boolean isActive() {
        return this.env.getChoiceModel(1059194368).getStatus() != 0;
    }

    public boolean isAvailable() {
        return this.mAEAAvailable == 0;
    }

    static /* synthetic */ LogChannel access$000(AEAService aEAService) {
        return aEAService.getLogger();
    }

    static /* synthetic */ ChoiceModelApp access$100(AEAService aEAService) {
        return aEAService.chkAudiEnergyAssist;
    }

    static /* synthetic */ AudiEnergyAssistService access$200(AEAService aEAService) {
        return aEAService.aeaService;
    }
}

