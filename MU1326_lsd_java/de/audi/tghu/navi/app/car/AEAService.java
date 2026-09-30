/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.car.AudiEnergyAssistService;
import de.audi.atip.interapp.car.AudiEnergyAssistStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.SimpleChoiceListener;

public class AEAService
implements AudiEnergyAssistStateListener {
    private NavigationEnv env;
    private LogChannel logger;
    public static final int AEA_NOT_AVAILABLE = 0;
    public static final int AEA_ENABLED = 1;
    public static final int AEA_DISABLED = 2;
    private int mAEAAvailable = 1;
    private int aeaState = -1;
    private AudiEnergyAssistService aeaService;
    private ChoiceModelApp chkAudiEnergyAssist;

    public AEAService(NavigationEnv navigationEnv) {
        this.logger = navigationEnv.getLogChannel("App.Map.Main");
        this.env = navigationEnv;
        this.chkAudiEnergyAssist = navigationEnv.getChoiceModel(401983);
        this.chkAudiEnergyAssist.setChoiceListener(new SimpleChoiceListener(){

            public void itemSelected(int n, int n2, int n3, int n4) {
                AEAService.this.getLogger().log(10000000, "AEAService<ChoiceListener>#itemSelected() - itemID:%1", (long)n2);
                AEAService.this.chkAudiEnergyAssist.setValue(n2);
                if (AEAService.this.aeaService != null) {
                    try {
                        AEAService.this.aeaService.setAEASystemActive(n2 == 1);
                    }
                    catch (Exception exception) {
                        AEAService.this.getLogger().log(10000, "AEAService<ChoiceListener>#itemSelected() - ERROR=%1", (Throwable)exception);
                    }
                } else {
                    AEAService.this.getLogger().log(10000000, "AEAService<ChoiceListener>#itemSelected() - Audi Energy Service is not available");
                }
            }
        });
        this.updateAEAAvailable(1);
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    public void setAudiEnergyAssistService(AudiEnergyAssistService audiEnergyAssistService) {
        this.getLogger().log(10000000, "AEAService#setAudiEnergyAssistService() - %1", (Object)audiEnergyAssistService);
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
        this.getLogger().log(10000000, "AEAService#cleanup()");
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

    public synchronized void updateAEAAvailable(int n) {
        this.getLogger().log(10000000, "AEAService#updateAEAAvailable( %1 )", (long)n);
        this.mAEAAvailable = n;
        this.refreshModel();
        if (this.isAvailable()) {
            this.activeService(true);
        }
    }

    public synchronized void updateAEASystemActive(boolean bl) {
        this.getLogger().log(10000000, "AEAService#updateAEASystemActive( %1 )", bl);
    }

    public synchronized void updateAEASystemState(int n) {
        this.getLogger().log(10000000, "AEAService#updateAEASystemState( %1 )", (long)n);
        this.aeaState = n;
        this.refreshModel();
    }

    private void refreshModel() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(401983);
        choiceModelApp.setStatus(0);
    }

    public void activeService(boolean bl) {
        this.getLogger().log(10000000, "AEAService#activeService( %1 )", bl);
        if (this.aeaService != null) {
            try {
                this.aeaService.setAEASystemActive(bl);
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "AEAService#activeService() - ERROR=%1", (Throwable)exception);
            }
        } else {
            this.getLogger().log(10000000, "AEAService#activeService() - Audi Energy Service is not available");
        }
    }

    public boolean isActive() {
        return this.env.getChoiceModel(401983).getStatus() != 0;
    }

    public boolean isAvailable() {
        return this.mAEAAvailable == 0;
    }
}

