/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.setup;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.setup.CommandSetConnectionMode;
import de.audi.app.data.core.setup.CommandSetRequestSetting;
import de.audi.app.data.core.setup.CommandSetRoamingState;
import de.audi.app.data.core.setup.IDataSetup;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public abstract class AbstractDataSetup
extends AbstractDataConfigurationComponent
implements IDataSetup,
ChoiceListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{4, 9, 3};
    private final ChoiceModelApp permissionChoice = this.getChoiceModel(740697600);
    private final ChoiceModelApp roamingChoice = this.getChoiceModel(891692544);
    private final ChoiceModelApp muOnlineChoice = this.getChoiceModel(757474816);
    private final ChoiceModelApp rseOnlineChoice = this.getChoiceModel(774252032);
    private final ChoiceModelApp wlanOnlineChoice = this.getChoiceModel(791029248);
    private final ChoiceModelApp localNetModeChoice = this.getChoiceModel(101);
    private final ChoiceModelApp dataRequestConfirmedChoice = this.getChoiceModel(1797662208);
    private int permissionGeneral;
    private int permissionMu;
    private int permissionWlan;
    private int permissionRse;
    private int permissionRoaming;

    public AbstractDataSetup(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    @Override
    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    protected final void enableLocalNetMode(boolean bl) {
        this.localNetModeChoice.setValue(bl ? 1 : 0);
    }

    @Override
    public boolean isLocalNetModeEnabled() {
        return this.localNetModeChoice.getValue() == 1;
    }

    @Override
    public void activateDataConnection() {
        if (this.permissionGeneral == 2) {
            this.onlinePermissionSelected(0);
        }
        if (this.permissionMu == 0) {
            this.applicationPermissionSelected(8, 1);
        }
    }

    @Override
    public void deactivateDataConnection() {
        this.onlinePermissionSelected(2);
    }

    @Override
    public void setOnlinePermissionToAlways() {
        this.onlinePermissionSelected(1);
    }

    @Override
    public void activateRoamingPermission() {
        this.roamingPermissionSelected(1);
    }

    @Override
    public void deactivateRoamingPermission() {
        this.roamingPermissionSelected(0);
    }

    @Override
    public void updateConnectionMode(int n, int n2) {
        int n3;
        this.log.log(1078071040, "AbstractDataSetup#updateConnectionMode(): mode=%2, valid=%1", (long)n2, (long)n);
        if (n2 != 1) {
            return;
        }
        switch (n) {
            case 0: {
                n3 = 1;
                break;
            }
            case 1: {
                n3 = 0;
                break;
            }
            case 2: {
                n3 = 2;
                break;
            }
            default: {
                this.log.log(10000, "AbstractDataSetup#updateConnectionMode(): UNKNOWN CONNECTIONMODE");
                return;
            }
        }
        this.permissionGeneral = n3;
        this.permissionChoice.setValue(this.permissionGeneral);
        this.dataApplication.getOnline().updatePermissionGeneral(this.permissionGeneral);
    }

    @Override
    public void updateRequestSetting(int n, int n2, int n3) {
        int n4;
        this.log.log(1078071040, "AbstractDataSetup#updateRequestSetting(): service=%1, allowed=%2, valid=%3", (long)n, (long)n2, (long)n3);
        if (n3 != 1) {
            return;
        }
        int n5 = n4 = n2 == 1 ? 1 : 0;
        if (n == 8) {
            if (n4 != this.permissionMu) {
                this.permissionMu = n4;
                this.muOnlineChoice.setValue(this.permissionMu);
            }
        } else if (n == 7) {
            if (n4 != this.permissionRse) {
                this.permissionRse = n4;
                this.rseOnlineChoice.setValue(this.permissionRse);
            }
        } else if (n == 6 && n4 != this.permissionWlan) {
            this.permissionWlan = n4;
            this.wlanOnlineChoice.setValue(this.permissionWlan);
        }
        this.dataApplication.getOnline().updatePermission(n, n4);
    }

    @Override
    public void updateRoamingState(int n, int n2) {
        int n3;
        this.log.log(1078071040, "AbstractDataSetup#updateRoamingState(): allowed=%1, valid=%2", (long)n, (long)n2);
        if (n2 != 1) {
            return;
        }
        int n4 = n3 = n == 0 ? 1 : 0;
        if (n3 != this.permissionRoaming) {
            this.permissionRoaming = n3;
            this.dataApplication.getOnline().updatePermissionRoaming(this.permissionRoaming);
            this.roamingChoice.setValue(this.permissionRoaming);
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(1078071040, "AbstractDataSetup#itemSelected(): modelID=%1, item=%2", (long)n, (long)n2);
        switch (n) {
            case 0x26262C: {
                this.onlinePermissionSelected(n2);
                break;
            }
            case 2500149: {
                this.roamingPermissionSelected(n2);
                break;
            }
            case 0x26262D: {
                this.applicationPermissionSelected(8, n2);
                break;
            }
            case 0x26262E: {
                this.applicationPermissionSelected(7, n2);
                break;
            }
            case 0x26262F: {
                this.applicationPermissionSelected(6, n2);
                break;
            }
        }
    }

    private void onlinePermissionSelected(int n) {
        if (n != this.permissionGeneral) {
            this.log.log(1078071040, "AbstractDataSetup#onlinePermissionSelected(): %1", (long)n);
            this.dataRequestConfirmedChoice.setValue(0);
            switch (n) {
                case 0: {
                    this.setConnectionMode(1);
                    break;
                }
                case 1: {
                    this.setConnectionMode(0);
                    break;
                }
                case 2: {
                    this.setConnectionMode(2);
                    break;
                }
                default: {
                    this.log.log(-1601830656, "AbstractDataSetup#onlinePermissionSelected(): Unexpected value: %1", (long)n);
                }
            }
            this.permissionChoice.setValue(n);
        } else {
            this.log.log(-2137614336, "AbstractDataSetup#onlinePermissionSelected(): Selected old setting, no change");
        }
    }

    private void setConnectionMode(int n) {
        CommandSetConnectionMode.schedule(this.dataApplication, this.dsiDataConfiguration, n);
    }

    private void roamingPermissionSelected(int n) {
        if (n != this.permissionRoaming) {
            boolean bl;
            this.log.log(1078071040, "AbstractDataSetup#roamingPermissionSelected(): %1", (long)n);
            boolean bl2 = bl = n == 1;
            if (!bl) {
                this.dataApplication.getOnline().roamingSettingDeactivatedByUser();
            }
            CommandSetRoamingState.schedule(this.dataApplication, this.dsiDataConfiguration, bl ? 0 : 1);
        } else {
            this.log.log(-2137614336, "AbstractDataSetup#roamingPermissionSelected(): Selected old setting, no change");
        }
    }

    private void applicationPermissionSelected(int n, int n2) {
        if (n == 6 && n2 != this.permissionWlan || n == 8 && n2 != this.permissionMu || n == 7 && n2 != this.permissionRse) {
            boolean bl = n2 == 1;
            this.log.log(1078071040, "AbstractDataSetup#applicationPermissionSelected(): ApplicationID=%2, permission=%1", bl, (long)n);
            CommandSetRequestSetting.schedule(this.dataApplication, this.dsiDataConfiguration, n, bl ? 1 : 2);
        } else {
            this.log.log(-2137614336, "AbstractDataSetup#applicationPermissionSelected(): Selected old setting, no change");
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void init() {
        super.init();
        this.permissionChoice.setChoiceListener(this);
        this.roamingChoice.setChoiceListener(this);
        this.muOnlineChoice.setChoiceListener(this);
        this.rseOnlineChoice.setChoiceListener(this);
        this.wlanOnlineChoice.setChoiceListener(this);
    }

    @Override
    public void deinit() {
        this.permissionChoice.resetListener();
        this.roamingChoice.resetListener();
        this.muOnlineChoice.resetListener();
        this.rseOnlineChoice.resetListener();
        this.wlanOnlineChoice.resetListener();
        super.deinit();
    }
}

