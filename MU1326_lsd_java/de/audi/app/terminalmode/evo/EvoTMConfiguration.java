/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.evo;

import de.audi.app.terminalmode.AbstractTerminalModeConfiguration;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.sysapp.carcoding.Coding;

public class EvoTMConfiguration
extends AbstractTerminalModeConfiguration {
    private final boolean isAudiQ1;
    private final boolean isAudiR8;
    private static final int CAR_GENERATION_2 = 2;

    public EvoTMConfiguration(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
        Coding coding = this.getFramework().getSysConstManager().getCarCoding();
        byte by = coding.getCarBrand();
        byte by2 = coding.getCarClass();
        byte by3 = coding.getCarGeneration();
        byte by4 = coding.getCarDerivate();
        this.isAudiQ1 = false;
        this.isAudiR8 = by == 1 && by2 == 7 && by3 == 2 && (by4 == 4 || by4 == 5);
    }

    public boolean hasKnob() {
        return true;
    }

    public boolean hasTouchpad() {
        return true;
    }

    public String getScreenName() {
        return "Audi MMI";
    }

    public boolean isAutoConnect() {
        return false;
    }

    public boolean shouldShowDisclaimerAtLeastOnce() {
        return true;
    }

    public boolean getStoreUserAcceptState() {
        return true;
    }

    public boolean isKnobDirectionInverted() {
        return true;
    }

    public boolean useDSIAndroidAuto2() {
        return true;
    }

    public boolean hasTouchscreenHigh() {
        return this.isAudiQ1;
    }

    public boolean isTouchScreenInputWidget() {
        return true;
    }

    public boolean hasTwoVirtualButtonModels() {
        return false;
    }

    public int getCarPlayPhysicalDisplayHeight() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 73;
            }
        }
        return super.getCarPlayPhysicalDisplayHeight();
    }

    public int getCarPlayPhysicalDisplayWidth() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 145;
            }
        }
        return super.getCarPlayPhysicalDisplayWidth();
    }

    public int getScreenOffsetX() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 360;
            }
        }
        return super.getScreenOffsetX();
    }

    public int getScreenOffsetY() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                if (this.isAudiR8) {
                    return 95;
                }
                return 105;
            }
        }
        return super.getScreenOffsetY();
    }

    public int getWindowResolutionX() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 720;
            }
        }
        return super.getWindowResolutionX();
    }

    public int getWindowResolutionY() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 360;
            }
        }
        return super.getWindowResolutionY();
    }

    public int getScreenResolutionX() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 1440;
            }
        }
        return super.getScreenResolutionX();
    }

    public int getScreenResolutionY() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 542;
            }
        }
        return super.getScreenResolutionY();
    }

    public int getPhysicalDisplayHeight() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 108;
            }
        }
        return super.getPhysicalDisplayHeight();
    }

    public int getPhysicalDisplayWidth() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 290;
            }
        }
        return super.getPhysicalDisplayWidth();
    }

    public boolean isOnHoldWhenPhoneCallActive() {
        return false;
    }
}

