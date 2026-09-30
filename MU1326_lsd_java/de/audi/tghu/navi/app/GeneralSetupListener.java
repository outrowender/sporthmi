/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class GeneralSetupListener
implements ChoiceListener {
    private final NavigationEnv env;
    private LogChannel logChannel;
    private TrafficRegulationService trafficRegulationService;

    public GeneralSetupListener(NavigationEnv navigationEnv, TrafficRegulationService trafficRegulationService) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.trafficRegulationService = trafficRegulationService;
        this.logChannel.log(10000000, "GeneralSetupListener#GeneralSetupListener() ");
        this.setListeners();
    }

    private void setListeners() {
        this.env.getChoiceModel(400801).setChoiceListener(this);
        this.env.getChoiceModel(400778).setChoiceListener(this);
        this.env.getChoiceModel(400669).setChoiceListener(this);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.itemSelected(n, n2, n3, n4, true);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelected(int n, int n2, int n3, int n4, boolean bl) {
        this.logChannel.log(10000000, "GeneralSetupListener#itemSelected( %1, %2 ) ", (long)n, (long)n2);
        switch (n) {
            case 400801: {
                this.env.getChoiceModel(400801).setValue(n2);
                if (bl) {
                    this.saveState();
                }
                this.trafficRegulationService.setEnableTrafficRegulationInfo(n2 == 1);
                break;
            }
            case 400669: {
                this.env.getChoiceModel(400669).setValue(n2);
                if (!bl) break;
                this.saveState();
                break;
            }
            case 400778: {
                this.env.getChoiceModel(400778).setValue(n2);
                break;
            }
            default: {
                this.logChannel.log(10000, "GeneralSetupListener#itemSelected() - unknown model id: %1! ", (long)n);
            }
        }
    }

    public boolean isRSEConfirmTransferEnabled() {
        return this.env.getChoiceModel(400669).getValue() == 0;
    }

    public int getTimeMode() {
        return this.env.getChoiceModel(400800).getValue();
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void resetSettings() {
        int n = this.env.getFramework().isFrontMU() ? 0 : 5;
        int n2 = TrafficRegulationService.isTrafficRegulationPresent(this.env) ? 1 : 0;
        this.itemSelected(400801, n2, 0, n, false);
        this.saveState();
    }

    void saveState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            State state = new State(iStorageAccess, this.logChannel);
            state.setTrafficSignDisplay(this.env.getChoiceModel(400801).getValue());
            state.setRseConfirmTransfer(this.env.getChoiceModel(400669).getValue());
            state.serializeAndWrite();
        } else {
            this.logChannel.log(10000, "Setup#saveState() - no storage manager available!!! ");
        }
    }

    public void loadState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            State state = new State(iStorageAccess, this.logChannel);
            state.readAndDeserialize();
            int n = !Util.isHURegionAsia() && this.env.getFramework().isEvoHigh() ? 1 : state.getTrafficSignDisplay();
            int n2 = TrafficRegulationService.isTrafficRegulationPresent(this.env) ? n : 0;
            this.env.getChoiceModel(400801).setValue(n2);
            this.trafficRegulationService.setEnableTrafficRegulationInfo(n2 == 1);
            this.env.getChoiceModel(400669).setValue(state.getRseConfirmTransfer());
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

    public static class State
    extends PersistentState {
        public static final int VERSION = 2;
        public static final int KEY = 840;
        private int trafficSignDisplay;
        private int rseConfirmTransfer;

        public State(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 2, 1004, 840, logChannel);
        }

        protected void initWithDefaultValues() {
            this.trafficSignDisplay = 1;
            this.rseConfirmTransfer = 0;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.trafficSignDisplay = iStorageAccess.getInt(1004, 370, 1);
            this.rseConfirmTransfer = iStorageAccess.getInt(1004, 390, 0);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.trafficSignDisplay);
            dataOutputStream.writeInt(this.rseConfirmTransfer);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.trafficSignDisplay = dataInputStream.readInt();
            this.rseConfirmTransfer = dataInputStream.readInt();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.getLogChannel().log(10000000, "GeneralSetupListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.trafficSignDisplay = dataInputStream.readInt();
                    this.rseConfirmTransfer = dataInputStream.readInt();
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "GeneralSetupListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        public int getTrafficSignDisplay() {
            return this.trafficSignDisplay;
        }

        public void setTrafficSignDisplay(int n) {
            this.trafficSignDisplay = n;
        }

        public int getRseConfirmTransfer() {
            return this.rseConfirmTransfer;
        }

        public void setRseConfirmTransfer(int n) {
            this.rseConfirmTransfer = n;
        }
    }
}

