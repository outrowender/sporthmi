/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.GeneralSetupListener$State;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.util.Util;

public class GeneralSetupListener
implements ChoiceListener {
    private final NavigationEnv env;
    private LogChannel logChannel;
    private TrafficRegulationService trafficRegulationService;

    public GeneralSetupListener(NavigationEnv navigationEnv, TrafficRegulationService trafficRegulationService) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.trafficRegulationService = trafficRegulationService;
        this.logChannel.log(-2137614336, "GeneralSetupListener#GeneralSetupListener() ");
        this.setListeners();
    }

    private void setListeners() {
        this.env.getChoiceModel(-1591933440).setChoiceListener(this);
        this.env.getChoiceModel(-1977809408).setChoiceListener(this);
        this.env.getChoiceModel(488441344).setChoiceListener(this);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.itemSelected(n, n2, n3, n4, true);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelected(int n, int n2, int n3, int n4, boolean bl) {
        this.logChannel.log(-2137614336, "GeneralSetupListener#itemSelected( %1, %2 ) ", (long)n, (long)n2);
        switch (n) {
            case 400801: {
                this.env.getChoiceModel(-1591933440).setValue(n2);
                if (bl) {
                    this.saveState();
                }
                this.trafficRegulationService.setEnableTrafficRegulationInfo(n2 == 1);
                break;
            }
            case 400669: {
                this.env.getChoiceModel(488441344).setValue(n2);
                if (!bl) break;
                this.saveState();
                break;
            }
            case 400778: {
                this.env.getChoiceModel(-1977809408).setValue(n2);
                break;
            }
            default: {
                this.logChannel.log(10000, "GeneralSetupListener#itemSelected() - unknown model id: %1! ", (long)n);
            }
        }
    }

    public boolean isRSEConfirmTransferEnabled() {
        return this.env.getChoiceModel(488441344).getValue() == 0;
    }

    public int getTimeMode() {
        return this.env.getChoiceModel(-1608710656).getValue();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    public void resetSettings() {
        int n = this.env.getFramework().isFrontMU() ? 0 : 5;
        int n2 = TrafficRegulationService.isTrafficRegulationPresent(this.env) ? 1 : 0;
        this.itemSelected(-1591933440, n2, 0, n, false);
        this.saveState();
    }

    void saveState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            GeneralSetupListener$State generalSetupListener$State = new GeneralSetupListener$State(iStorageAccess, this.logChannel);
            generalSetupListener$State.setTrafficSignDisplay(this.env.getChoiceModel(-1591933440).getValue());
            generalSetupListener$State.setRseConfirmTransfer(this.env.getChoiceModel(488441344).getValue());
            generalSetupListener$State.serializeAndWrite();
        } else {
            this.logChannel.log(10000, "Setup#saveState() - no storage manager available!!! ");
        }
    }

    public void loadState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            GeneralSetupListener$State generalSetupListener$State = new GeneralSetupListener$State(iStorageAccess, this.logChannel);
            generalSetupListener$State.readAndDeserialize();
            int n = !Util.isHURegionAsia() && this.env.getFramework().isEvoHigh() ? 1 : generalSetupListener$State.getTrafficSignDisplay();
            int n2 = TrafficRegulationService.isTrafficRegulationPresent(this.env) ? n : 0;
            this.env.getChoiceModel(-1591933440).setValue(n2);
            this.trafficRegulationService.setEnableTrafficRegulationInfo(n2 == 1);
            this.env.getChoiceModel(488441344).setValue(generalSetupListener$State.getRseConfirmTransfer());
        } else {
            this.logChannel.log(10000, "Setup#loadState() - no storage manager available!!! ");
        }
    }

    public void triggerStorageFlush(boolean bl) {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (bl) {
            iStorageAccess.enterSetupScreen();
        } else {
            iStorageAccess.exitSetupScreen();
        }
    }
}

