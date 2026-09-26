/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.sdis;

import de.audi.app.settings.SettingsEnv;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.sdis.ISDISBlockingListener;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.atip.interapp.sdis.ISDISHeadUnitService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.storage.IStorageAccess;

public abstract class AbstractSDISHandler
implements ButtonListener,
ChoiceListener,
ISDISBlockingListener,
MsgListener {
    public static final int CHECKBOX_ALLOW;
    public static final int CHECKBOX_BLOCK;
    public static final int POPUP_ALLOW;
    public static final int POPUP_DECLINE;
    public static final int POPUP_ON_DEMAND;
    private final SettingsEnv env;
    private final LogChannel log;
    private ISDISBlockingService sdisBlockingService = null;
    private ISDISHeadUnitService sdisHeadUnitService = null;
    private int currentLockState = 0;
    private int currentBlockState = 0;
    private int naviRequestMode;

    public AbstractSDISHandler(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.log = settingsEnv.getFw().getLogChannel("App.Settings.SDIS");
        this.getLockStateChoice().setChoiceListener(this);
        this.getBlockA2LSChoice().setChoiceListener(this);
        this.getBlockNaviChoice().setChoiceListener(this);
        this.getBlockMediaSourceChoice().setChoiceListener(this);
        this.getFactoryResetButton().setButtonListener(this);
        this.getResetLanguageButton().setButtonListener(this);
        this.getShowHomeScreenButton().setButtonListener(this);
        this.getShowLockScreenButton().setButtonListener(this);
        this.setNaviOnDemand(this.getStorageMgr().getInt(1010, 40, 0), false);
    }

    public final IStorageAccess getStorageMgr() {
        return this.getEnv().getFw().getStorageMgr();
    }

    public final void cleanup() {
        this.getLockStateChoice().setChoiceListener(null);
        this.getBlockA2LSChoice().setChoiceListener(null);
        this.getBlockMediaSourceChoice().setChoiceListener(null);
        this.getFactoryResetButton().setButtonListener(null);
        this.getResetLanguageButton().setButtonListener(null);
        this.getShowHomeScreenButton().setButtonListener(null);
        this.getShowLockScreenButton().setButtonListener(null);
        this.setSdisBlockingService(null);
        this.setSdisHeadUnitService(null);
    }

    public final void setSDISBlockingService(ISDISBlockingService iSDISBlockingService) {
        this.setSdisBlockingService(iSDISBlockingService);
    }

    public final void setSDISHeadUnitService(ISDISHeadUnitService iSDISHeadUnitService) {
        this.sdisHeadUnitService = iSDISHeadUnitService;
    }

    private final ChoiceModelApp getLockStateChoice() {
        return this.env.getChoiceModel(-691466240);
    }

    private final ChoiceModelApp getBlockA2LSChoice() {
        return this.env.getChoiceModel(4385);
    }

    private final ChoiceModelApp getBlockNaviChoice() {
        return this.env.getChoiceModel(415895552);
    }

    private final ChoiceModelApp getBlockMediaSourceChoice() {
        return this.env.getChoiceModel(-725020672);
    }

    private final ButtonModelApp getFactoryResetButton() {
        return this.env.getButtonModel(-708243456);
    }

    private final ButtonModelApp getResetLanguageButton() {
        return this.env.getButtonModel(-674689024);
    }

    private final ButtonModelApp getShowLockScreenButton() {
        return this.env.getButtonModel(-540471296);
    }

    private final ButtonModelApp getShowHomeScreenButton() {
        return this.env.getButtonModel(-657911808);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.getLog().log(1078071040, "AbstractSDISHandler.keyTyped(%1, %2)", (long)n, (long)n2);
        switch (n) {
            case 1100245: {
                this.getLog().log(1078071040, "AbstractSDISHandler.keyTyped: trigger factory reset");
                this.env.getFw().getMsgDistrib().sendMessage(85);
                break;
            }
            case 1100247: {
                this.getLog().log(1078071040, "AbstractSDISHandler.keyTyped: trigger Language reset");
                ISDISHeadUnitService iSDISHeadUnitService = this.sdisHeadUnitService;
                if (iSDISHeadUnitService == null) break;
                iSDISHeadUnitService.resetLanguage();
                break;
            }
            case 1100248: {
                this.getLog().log(1078071040, "AbstractSDISHandler.keyTyped: trigger home screen");
                ISDISBlockingService iSDISBlockingService = this.sdisBlockingService;
                if (iSDISBlockingService == null) break;
                iSDISBlockingService.enterAppContext(0, "Home");
                break;
            }
            case 1100255: {
                this.getLog().log(1078071040, "AbstractSDISHandler.keyTyped: trigger lock screen");
                ISDISBlockingService iSDISBlockingService = this.sdisBlockingService;
                if (iSDISBlockingService == null) break;
                iSDISBlockingService.enterAppContext(0, "Lock");
                break;
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    protected boolean isLocked(int n) {
        return 1 == n;
    }

    protected boolean isA2LSBlocked(int n) {
        return (3 & n) != 0;
    }

    public void setNaviOnDemand(int n, boolean bl) {
        this.naviRequestMode = n;
        this.getBlockNaviChoice().setValue(n);
        if (bl) {
            this.getStorageMgr().setInt(1010, 40, this.naviRequestMode);
        }
    }

    protected boolean isMediaSourceBlocked(int n) {
        return (5 & n) != 0;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLog().log(1078071040, "AbstractSDISHandler.itemSelected(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        ISDISBlockingService iSDISBlockingService = this.getSdisBlockingService();
        block0 : switch (n) {
            case 1100246: {
                this.getLog().log(1078071040, "AbstractSDISHandler.itemSelected: toggle lock state choice");
                if (iSDISBlockingService == null) break;
                iSDISBlockingService.setLockState(this.isLocked(this.getCurrentLockState()) ? 0 : 1);
                break;
            }
            case 4385: {
                this.getLog().log(1078071040, "AbstractSDISHandler.itemSelected: set block A2LS to %1", (long)n2);
                int n5 = this.getCurrentBlockState();
                switch (n2) {
                    case 0: {
                        n5 &= 0xFFFFFFFC;
                        break;
                    }
                    case 1: {
                        n5 |= 2;
                        break;
                    }
                    default: {
                        this.getLog().log(-1601830656, "AbstractSDISHandler.itemSelected; modelID = SDIS_BLOCK_STATE_A2_L_S_CHOICE: itemID = %1 not found", (long)n2);
                    }
                }
                if (iSDISBlockingService == null) break;
                iSDISBlockingService.setBlockState(n5);
                break;
            }
            case 1100312: {
                this.getLog().log(1078071040, "AbstractSDISHandler.itemSelected: set block Navi to %1", (long)n2);
                switch (n2) {
                    case 0: 
                    case 1: 
                    case 2: {
                        this.setNaviOnDemand(n2, true);
                        break block0;
                    }
                }
                this.getLog().log(-1601830656, "AbstractSDISHandler.itemSelected; modelID = NAV_SDIS_SETTINGS_REQUEST_MODE_CHOICE: itemID = %1 not found", (long)n2);
                break;
            }
            case 1100244: {
                this.getLog().log(1078071040, "SDISHandler.itemSelected: set block media to %1", (long)n2);
                int n6 = this.getCurrentBlockState();
                switch (n2) {
                    case 0: {
                        n6 |= 4;
                        break;
                    }
                    case 1: {
                        n6 &= 0xFFFFFFFA;
                        break;
                    }
                    default: {
                        this.getLog().log(-1601830656, "SDISHandler.itemSelected; itemID = %1 NOT FOUND", (long)n2);
                    }
                }
                if (iSDISBlockingService == null) break;
                iSDISBlockingService.setBlockState(n6);
                break;
            }
            default: {
                this.getLog().log(-1601830656, "AbstractSDISHandler.itemSelected; modelID = %1 NOT FOUND", (long)n);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateLockState(int n) {
        this.getLog().log(1078071040, "AbstractSDISHandler.updateLockState( %1 )", (long)n);
        this.currentLockState = n;
        this.getLockStateChoice().setValue(this.isLocked(n) ? 1 : 0);
    }

    @Override
    public void updateBlockState(int n) {
        this.getLog().log(1078071040, "AbstractSDISHandler.updateBLockState( %1 )", (long)n);
        this.currentBlockState = n;
        this.getBlockA2LSChoice().setValue(this.isA2LSBlocked(n) ? 1 : 0);
        this.getBlockMediaSourceChoice().setValue(this.isMediaSourceBlocked(n) ? 0 : 1);
    }

    @Override
    public void processMsg(int n) {
        if (n == 85) {
            this.getLog().log(1078071040, "AbstractSDISHandler: Reset sdis settings");
            int n2 = this.currentBlockState;
            n2 &= 0xFFFFFFFA;
            n2 &= 0xFFFFFFFC;
            if (this.env.getFw().getSysConst(4168) == 5) {
                this.setNaviOnDemand(0, true);
            } else {
                this.setNaviOnDemand(2, true);
            }
            if (this.getSdisBlockingService() != null) {
                this.getSdisBlockingService().setLockState(0);
                this.getSdisBlockingService().setBlockState(n2);
            }
        }
    }

    public ISDISBlockingService getSdisBlockingService() {
        return this.sdisBlockingService;
    }

    public void setSdisBlockingService(ISDISBlockingService iSDISBlockingService) {
        this.sdisBlockingService = iSDISBlockingService;
    }

    public ISDISHeadUnitService getSdisHeadUnitService() {
        return this.sdisHeadUnitService;
    }

    public void setSdisHeadUnitService(ISDISHeadUnitService iSDISHeadUnitService) {
        this.sdisHeadUnitService = iSDISHeadUnitService;
    }

    public int getCurrentLockState() {
        return this.currentLockState;
    }

    public void setCurrentLockState(int n) {
        this.currentLockState = n;
    }

    public int getCurrentBlockState() {
        return this.currentBlockState;
    }

    public void setCurrentBlockState(int n) {
        this.currentBlockState = n;
    }

    public int getNaviRequestMode() {
        return this.naviRequestMode;
    }

    public void setNaviRequestMode(int n) {
        this.naviRequestMode = n;
    }

    public SettingsEnv getEnv() {
        return this.env;
    }

    public LogChannel getLog() {
        return this.log;
    }
}

