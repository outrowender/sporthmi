/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;
import de.audi.atip.base.IFrameworkAccess;
import de.esolutions.fw.util.commons.Buffer;
import java.io.File;

public abstract class AbstractTerminalModeConfiguration
implements ITerminalModeConfiguration,
IDiagnosisDataProvider {
    private final boolean terminalMode;
    private final boolean rightHandDrive;
    protected final IFrameworkAccess fw;

    public AbstractTerminalModeConfiguration(IFrameworkAccess iFrameworkAccess) {
        boolean bl = new File("/var/smartphone_integration").exists();
        boolean bl2 = iFrameworkAccess.getSysConst(4237) == 1 || bl;
        boolean bl3 = iFrameworkAccess.getSysConst(4238) == 1 || bl;
        boolean bl4 = iFrameworkAccess.getSysConst(5571) == 1 || bl;
        bl2 = bl2 || System.getProperty("terminalmode.gal", "false").equals("true");
        bl3 = bl3 || System.getProperty("terminalmode.dio", "false").equals("true");
        bl4 = bl4 || System.getProperty("terminalmode.bcl", "false").equals("true");
        this.terminalMode = bl3 || bl2 || bl4 || iFrameworkAccess.isSimulator();
        this.rightHandDrive = iFrameworkAccess.getSysConst(464) == 1;
        this.fw = iFrameworkAccess;
    }

    public boolean isTerminalMode() {
        return this.terminalMode;
    }

    public boolean hasKnob() {
        return false;
    }

    public boolean hasTouchpad() {
        return false;
    }

    public boolean hasTouchscreenHigh() {
        return false;
    }

    public boolean hasTouchscreenLow() {
        return false;
    }

    public boolean hasTouchscreen() {
        return this.hasTouchscreenHigh() || this.hasTouchscreenLow();
    }

    public boolean isRightHandDrive() {
        return this.rightHandDrive;
    }

    public boolean isAutoConnect() {
        return false;
    }

    public String getDiagKey() {
        return "Configuration";
    }

    public String getDiagValue() {
        return this.toString();
    }

    public int getScreenResolutionX() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 1440;
            }
            case 1: {
                return 800;
            }
        }
        return 1024;
    }

    public int getScreenResolutionY() {
        return 480;
    }

    public int getWindowResolutionX() {
        return this.getScreenResolutionX();
    }

    public int getWindowResolutionY() {
        return this.getScreenResolutionY();
    }

    public int getTouchPadResolutionX() {
        return this.getSquareTouchPadResolution();
    }

    public int getTouchPadResolutionY() {
        return this.getSquareTouchPadResolution();
    }

    private int getSquareTouchPadResolution() {
        switch (this.fw.getHMIService().getHMITerminal(0).getKbdService().getCurrentKeyboardType()) {
            case 15: {
                return 256;
            }
            case 6: {
                return 1024;
            }
            case 5: {
                return 1024;
            }
        }
        return 256;
    }

    public int getPhysicalDisplayHeight() {
        switch (this.fw.getSysConst(522)) {
            case 2: {
                return 88;
            }
        }
        return 91;
    }

    public int getPhysicalDisplayWidth() {
        switch (this.fw.getSysConst(522)) {
            case 2: {
                return 188;
            }
        }
        return 152;
    }

    public int getDSICarPlayScreenResolution() {
        switch (this.fw.getScreenRes()) {
            case 2: 
            case 3: 
            case 5: 
            case 6: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 0: 
            case 1: {
                return 0;
            }
        }
        return 0;
    }

    public int getCarPlayPhysicalDisplayHeight() {
        return this.getPhysicalDisplayHeight();
    }

    public int getCarPlayPhysicalDisplayWidth() {
        return this.getPhysicalDisplayWidth();
    }

    public int getScreenOffsetX() {
        return 0;
    }

    public int getScreenOffsetY() {
        return 0;
    }

    public boolean isTouchScreenInputWidget() {
        return this.hasTouchscreen();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TerminalModeConfiguration [terminalMode=");
        buffer.append(this.terminalMode);
        buffer.append("]");
        return buffer.toString();
    }

    public boolean supportsDeletionOfConnectedDevices() {
        return false;
    }

    public boolean hasBothPhoneMFLKeys() {
        return false;
    }

    public boolean usesOldMediaConnector() {
        return false;
    }

    public int applicationOffset() {
        return 0;
    }

    public boolean hasTwoVirtualButtonModels() {
        return true;
    }

    protected IFrameworkAccess getFramework() {
        return this.fw;
    }

    public boolean isOnHoldWhenPhoneCallActive() {
        return false;
    }
}

