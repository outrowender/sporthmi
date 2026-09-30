/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.etc.ETCModels;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.log.LogChannel;

public class ETCSettings
extends DefaultChoiceListener {
    static final int TOLL_AMOUNT_NOTICE_IDX = 0;
    static final int TOLL_AMOUNT_ANNOUNCEMENT_IDX = 1;
    static final int ETC_WARNING_IDX = 2;
    static final int ETC_CARD_REMINDER_IDX = 3;
    static final byte SETTINGS_PARAMETER_ON = 1;
    static final byte SETTINGS_PARAMETER_OFF = 0;
    final byte[] DEFAULT_SETTINGS = new byte[]{0, 1, 0, 1};
    SettingsEnv env;
    ETCModels models;
    LogChannel log;

    public ETCSettings(SettingsEnv settingsEnv, ETCModels eTCModels, LogChannel logChannel) {
        this.env = settingsEnv;
        this.models = eTCModels;
        this.log = logChannel;
        this.initModels();
        this.persistenceLoad();
    }

    private void initModels() {
        this.models.getETCAmountNoticeChoice().setChoiceListener(this);
        this.models.getETCAmountAnnouncementChoice().setChoiceListener(this);
        this.models.getETCWarningChoice().setChoiceListener(this);
        this.models.getETCCardPickUpReminderChoice().setChoiceListener(this);
    }

    private final ETCModels getModels() {
        return this.models;
    }

    private final SettingsEnv getEnv() {
        return this.env;
    }

    boolean isCardReminderOn() {
        return this.getSettingsParameter(3) == 1;
    }

    boolean isAmountNoticeOn() {
        if (this.getEnv().getFw().isEvoHighMMIKombi()) {
            return false;
        }
        return this.getSettingsParameter(0) == 1;
    }

    boolean isAmountAnnouncementOn() {
        return this.getSettingsParameter(1) == 1;
    }

    boolean isETCWarningOn() {
        return this.getSettingsParameter(2) == 1;
    }

    private byte[] getSettings() {
        byte[] byArray = new byte[]{(byte)this.getModels().getETCAmountNoticeChoice().getValue(), (byte)this.getModels().getETCAmountAnnouncementChoice().getValue(), (byte)this.getModels().getETCWarningChoice().getValue(), (byte)this.getModels().getETCCardPickUpReminderChoice().getValue()};
        return byArray;
    }

    private byte getSettingsParameter(int n) {
        byte by = 0;
        byte[] byArray = this.getSettings();
        if (n >= 0 && n < byArray.length) {
            by = byArray[n];
        } else {
            this.log.log(10000, "[ETCSettings] getSettingsById(%1): invalid index", (long)n);
        }
        return by;
    }

    private byte toggleParameterValue(byte by) {
        return by == 0 ? (byte)1 : 0;
    }

    private void setSettings(byte[] byArray) {
        if (byArray != null) {
            block6: for (int i2 = 0; i2 < byArray.length; ++i2) {
                switch (i2) {
                    case 0: {
                        this.getModels().getETCAmountNoticeChoice().setValue(byArray[i2]);
                        this.log.log(10000000, "[ETCSettings] setSettings(): TOLL_AMOUNT_NOTICE_IDX=%1", (long)byArray[i2]);
                        continue block6;
                    }
                    case 1: {
                        this.getModels().getETCAmountAnnouncementChoice().setValue(byArray[i2]);
                        this.log.log(10000000, "[ETCSettings] setSettings(): TOLL_AMOUNT_ANNOUNCEMENT_IDX=%1", (long)byArray[i2]);
                        continue block6;
                    }
                    case 2: {
                        this.getModels().getETCWarningChoice().setValue(byArray[i2]);
                        this.log.log(10000000, "[ETCSettings] setSettings(): ETC_WARNING_IDX=%1", (long)byArray[i2]);
                        continue block6;
                    }
                    case 3: {
                        this.log.log(10000000, "[ETCSettings] setSettings(): ETC_CARD_REMINDER_IDX=%1", (long)byArray[i2]);
                        this.getModels().getETCCardPickUpReminderChoice().setValue(byArray[i2]);
                        continue block6;
                    }
                    default: {
                        this.log.log(10000, "[ETCSettings] setSettings(): unknown settings parameter %1", (long)i2);
                    }
                }
            }
        }
    }

    private void persistenceStore() {
        this.log.log(1000000, "[ETCSettings] persistenceStore");
        byte[] byArray = this.getSettings();
        this.setSettings(byArray);
        this.getEnv().getStorageMgr().setByteArray(1111, 1, byArray);
    }

    private void persistenceLoad() {
        this.log.log(1000000, "[ETCSettings] persistenceLoad");
        this.setSettings(this.getEnv().getStorageMgr().getByteArray(1111, 1, this.DEFAULT_SETTINGS));
    }

    void restoreDefaultETCSettings() {
        this.log.log(1000000, "[ETCSettings] resetETCSettings");
        this.setSettings(this.DEFAULT_SETTINGS);
        this.getEnv().getStorageMgr().setByteArray(1111, 1, this.DEFAULT_SETTINGS);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(1000000, "[ETCSettings] itemSelected(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 1100261: {
                this.getModels().getETCAmountNoticeChoice().setValue(this.toggleParameterValue(this.getSettingsParameter(0)));
                break;
            }
            case 1100260: {
                this.getModels().getETCAmountAnnouncementChoice().setValue(this.toggleParameterValue(this.getSettingsParameter(1)));
                break;
            }
            case 1100259: {
                this.getModels().getETCWarningChoice().setValue(this.toggleParameterValue(this.getSettingsParameter(2)));
                break;
            }
            case 1100258: {
                this.getModels().getETCCardPickUpReminderChoice().setValue(this.toggleParameterValue(this.getSettingsParameter(3)));
                break;
            }
            default: {
                this.log.log(10000, "[ETCSettings] unknown modelID=%1", (long)n);
                return;
            }
        }
        this.persistenceStore();
    }
}

