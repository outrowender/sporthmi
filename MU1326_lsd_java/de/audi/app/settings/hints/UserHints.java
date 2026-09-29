/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.hints;

import de.audi.app.settings.SettingsEnv;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import java.util.Arrays;

public final class UserHints
implements ChoiceListener,
ButtonListener,
MsgListener {
    private final SettingsEnv env;
    private final LogChannel lc;
    private int hintsActive = 1;
    private static final int PHONE_HINTS_POPUP;
    private static final int NAVI_HINTS_POPUP;
    private static final int MAP_UNLOCKED_HINTS_POPUP;
    private static final int MAP_LOCKED_HINTS_POPUP;
    private int[] userHintsPopups = new int[]{1, 1, 1, 1};

    public UserHints(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.lc = this.env.getFw().getLogChannel("App.Settings.Display");
        this.hintsActive = this.env.getFw().getStorageMgr().getInt(1011, 40, 1);
        this.readPopupHintsStorage();
        this.env.getChoiceModel(-2033643520).setValue(this.hintsActive);
        this.env.getChoiceModel(-2033643520).setChoiceListener(this);
        this.env.getButtonModel(-641134592).setButtonListener(this);
        this.env.getButtonModel(3951).setButtonListener(this);
        this.env.getButtonModel(3953).setButtonListener(this);
        this.env.getButtonModel(3974).setButtonListener(this);
        this.env.getButtonModel(3973).setButtonListener(this);
    }

    private void readPopupHintsStorage() {
        int[] nArray = this.env.getFw().getStorageMgr().getIntArray(1011, 41, this.userHintsPopups);
        if (nArray.length < this.userHintsPopups.length) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.userHintsPopups[i2] = nArray[i2];
            }
        } else {
            this.userHintsPopups = nArray;
        }
        this.lc.log(-2137614336, "readPopupHintsStorage(): %1", (Object)this.userHintsPopups);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.lc.log(-2137614336, "keyPressed modelID=%1, keyID=%2", (long)n, (long)n2);
        switch (n) {
            case 1100249: {
                if (this.hintsActive != 0) break;
                this.env.getChoiceModel(-2033643520).setValue(0);
                this.env.getButtonModel(-641134592).fireEvent(0);
                this.env.getFw().getStorageMgr().setInt(1011, 40, 0);
                Arrays.fill(this.userHintsPopups, 0);
                break;
            }
            case 3951: {
                this.userHintsPopups[0] = 0;
                break;
            }
            case 3953: {
                this.userHintsPopups[1] = 0;
                break;
            }
            case 3974: {
                this.userHintsPopups[2] = 0;
                break;
            }
            case 3973: {
                this.userHintsPopups[3] = 0;
                break;
            }
        }
        this.env.getFw().getStorageMgr().setIntArray(1011, 41, this.userHintsPopups);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.lc.log(-2137614336, "itemSelected itemID=%1", (long)n2);
        this.hintsActive = n2;
        if (n2 == 1) {
            this.activateUserHints();
        } else {
            this.env.getChoiceModel(-2033643520).fireEvent(0);
        }
    }

    private void activateUserHints() {
        this.env.getFw().getStorageMgr().setInt(1011, 40, 1);
        Arrays.fill(this.userHintsPopups, 1);
        this.env.getFw().getStorageMgr().setIntArray(1011, 41, this.userHintsPopups);
        this.env.getChoiceModel(-2033643520).forceUpdate(true);
        this.env.getChoiceModel(-2033643520).setValue(1);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void processMsg(int n) {
        if (n == 87) {
            this.activateUserHints();
        }
    }
}

