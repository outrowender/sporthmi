/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rp;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.rp.TripHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TripSettingsListener
implements ChoiceListener {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private TripHandler tripHandler;

    public TripSettingsListener(NavigationEnv navigationEnv, TripHandler tripHandler, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.tripHandler = tripHandler;
        this.logChannel.log(10000000, "TripSettingsListener#TripSettingsListener() ");
        this.setListeners();
    }

    private void setListeners() {
        this.env.getChoiceModel(400800).setChoiceListener(this);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.itemSelected(n, n2, n3, n4, true);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelected(int n, int n2, int n3, int n4, boolean bl) {
        this.logChannel.log(10000000, "TripSettingsListener#itemSelected( %1, %2 ) ", (long)n, (long)n2);
        switch (n) {
            case 400800: {
                this.env.getChoiceModel(400800).setValue(n2);
                if (bl) {
                    this.saveState();
                }
                this.tripHandler.setTimeMode(n2);
                break;
            }
            default: {
                this.logChannel.log(10000, "TripSettingsListener#itemSelected() - unknown model id: %1! ", (long)n);
            }
        }
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
        this.itemSelected(400800, 0, 0, n, false);
        this.saveState();
    }

    void saveState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            State state = new State(iStorageAccess, this.logChannel);
            state.setTimeMode(this.env.getChoiceModel(400800).getValue());
            state.serializeAndWrite();
        } else {
            this.logChannel.log(10000, "TripSettingsListener#saveState() - no storage manager available!!! ");
        }
    }

    public void loadState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            State state = new State(iStorageAccess, this.logChannel);
            state.readAndDeserialize();
            this.env.getChoiceModel(400800).setValue(state.getTimeMode());
            this.tripHandler.setTimeMode(state.getTimeMode());
        } else {
            this.logChannel.log(10000, "TripSettingsListener#loadState() - no storage manager available!!! ");
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
        public static final int VERSION = 1;
        public static final int KEY = 1042;
        private int timeMode;

        public State(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 1, 1004, 1042, logChannel);
        }

        protected void initWithDefaultValues() {
            this.timeMode = 0;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.timeMode = iStorageAccess.getInt(1004, 360, 0);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.timeMode);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.timeMode = dataInputStream.readInt();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.getLogChannel().log(10000000, "TripSettingsListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.timeMode = dataInputStream.readInt();
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "TripSettingsListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        public int getTimeMode() {
            return this.timeMode;
        }

        public void setTimeMode(int n) {
            this.timeMode = n;
        }
    }
}

