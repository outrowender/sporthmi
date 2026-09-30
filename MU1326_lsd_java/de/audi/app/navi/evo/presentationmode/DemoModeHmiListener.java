/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.presentationmode;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.demomode.IDemoModeHmiListener;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;

public class DemoModeHmiListener
implements IDemoModeHmiListener,
ChoiceListener,
SpeedThresholdListener {
    private DemoModeManager demoModeManager;
    private NavigationEnv env;
    private LogChannel logChannel;
    private MapInterface iMap;
    private ButtonModelApp btnSelectInMap;

    public DemoModeHmiListener(final NavigationEnv navigationEnv, final DemoModeManager demoModeManager, int n, MapInterface mapInterface) {
        this.demoModeManager = demoModeManager;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getDemoModeLogChannel();
        this.iMap = mapInterface;
        this.setListeners(n);
        this.btnSelectInMap = navigationEnv.getButtonModel(402764);
        this.btnSelectInMap.setButtonListener(new SimpleButtonListener(){

            public void keyPressed(int n, int n2, int n3) {
                DemoModeHmiListener.this.btnSelectInMap.fireEvent(DemoModeHmiListener.this.btnSelectInMap.getTerminalID());
                navigationEnv.getChoiceModel(401246).setValue(1);
                DemoModeHmiListener.this.iMap.crosshairEnterInMap(demoModeManager.getStartPosition());
            }
        });
    }

    private void setListeners(int n) {
        try {
            this.env.getChoiceModel(n).setChoiceListener(this);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "DemoModeHmiListener#setListeners() - ERROR registering as a ChioceListener: %1", (Throwable)exception);
        }
        try {
            this.env.getFramework().getSysApp().registerSpeedThresholdListener(this, 1);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "DemoModeHmiListener#setListeners() - ERROR registering as a SpeedThresholgListener: %1", (Throwable)exception);
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 402566: {
                this.changeDemoMode(n2);
                break;
            }
            default: {
                this.logChannel.log(10000, "DemoModeHmiListener#itemSelected() - modelID = %1 does not match an expected model", (long)n);
            }
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void changeDemoMode(int n) {
        if (!this.demoModeManager.isCarMoving()) {
            this.logChannel.log(10000000, "DemoModeHmiListener#changeDemoMode() - ITEM-ID is = %1", (long)n);
            boolean bl = n == 1;
            this.logChannel.log(10000000, "DemoModeHmiListener#changeDemoMode() - Try to set DemoMode to = %1", bl);
            this.demoModeManager.setDemoModeState(bl);
        } else {
            this.logChannel.log(10000, "DemoModeHmiListener#changeDemoMode() - The car is currently moving, no demo mode allowed!");
        }
    }

    public void exceedsUpperThreshold(int n) {
        this.logChannel.log(10000000, "DemoModeHmiListener#exceedsUpperThreshold() - invoked thresholdID = %1", (long)n);
        if (n == 1) {
            this.demoModeManager.setIsCarMoving(true);
            this.demoModeManager.setDemoStatus(0);
            if (this.env.getContainer().isEtcDemoMode()) {
                this.demoModeManager.setDemoModeState(false);
            }
        }
    }

    public void belowLowerThreshold(int n) {
        this.logChannel.log(10000000, "DemoModeHmiListener#belowLowerThreshold() - invoked thresholdID = %1", (long)n);
        if (n == 1) {
            this.demoModeManager.setIsCarMoving(false);
            this.demoModeManager.setDemoStatus(1);
        }
    }

    public synchronized void cleanup() {
        try {
            this.env.getFramework().getSysApp().unregisterSpeedThresholdListener(this);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "DemoModeHmiListener#cleanup() - ERROR unregistering: %1", (Throwable)exception);
        }
        this.demoModeManager.stopCurrentDemoModeGuidance();
        this.demoModeManager = null;
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

