/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rp;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rp.TripHandler;
import de.audi.tghu.navi.app.rp.TripSettingsListener$State;

public class TripSettingsListener
implements ChoiceListener {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private TripHandler tripHandler;

    public TripSettingsListener(NavigationEnv navigationEnv, TripHandler tripHandler, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.tripHandler = tripHandler;
        this.logChannel.log(-2137614336, "TripSettingsListener#TripSettingsListener() ");
        this.setListeners();
    }

    private void setListeners() {
        this.env.getChoiceModel(-1608710656).setChoiceListener(this);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.itemSelected(n, n2, n3, n4, true);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelected(int n, int n2, int n3, int n4, boolean bl) {
        this.logChannel.log(-2137614336, "TripSettingsListener#itemSelected( %1, %2 ) ", (long)n, (long)n2);
        switch (n) {
            case 400800: {
                this.env.getChoiceModel(-1608710656).setValue(n2);
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
        this.itemSelected(-1608710656, 0, 0, n, false);
        this.saveState();
    }

    void saveState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            TripSettingsListener$State tripSettingsListener$State = new TripSettingsListener$State(iStorageAccess, this.logChannel);
            tripSettingsListener$State.setTimeMode(this.env.getChoiceModel(-1608710656).getValue());
            tripSettingsListener$State.serializeAndWrite();
        } else {
            this.logChannel.log(10000, "TripSettingsListener#saveState() - no storage manager available!!! ");
        }
    }

    public void loadState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            TripSettingsListener$State tripSettingsListener$State = new TripSettingsListener$State(iStorageAccess, this.logChannel);
            tripSettingsListener$State.readAndDeserialize();
            this.env.getChoiceModel(-1608710656).setValue(tripSettingsListener$State.getTimeMode());
            this.tripHandler.setTimeMode(tripSettingsListener$State.getTimeMode());
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
}

