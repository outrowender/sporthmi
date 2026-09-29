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
    private static final int CAR_GENERATION_2;

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

    @Override
    public boolean hasKnob() {
        return true;
    }

    @Override
    public boolean hasTouchpad() {
        return true;
    }

    @Override
    public String getScreenName() {
        return "Audi MMI";
    }

    @Override
    public boolean isAutoConnect() {
        return false;
    }

    @Override
    public boolean shouldShowDisclaimerAtLeastOnce() {
        return true;
    }

    @Override
    public boolean getStoreUserAcceptState() {
        return true;
    }

    @Override
    public boolean isKnobDirectionInverted() {
        return true;
    }

    public boolean useDSIAndroidAuto2() {
        return true;
    }

    @Override
    public boolean hasTouchscreenHigh() {
        return this.isAudiQ1;
    }

    @Override
    public boolean isTouchScreenInputWidget() {
        return true;
    }

    @Override
    public boolean hasTwoVirtualButtonModels() {
        return false;
    }

    @Override
    public int getCarPlayPhysicalDisplayHeight() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 73;
            }
        }
        return super.getCarPlayPhysicalDisplayHeight();
    }

    @Override
    public int getCarPlayPhysicalDisplayWidth() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 145;
            }
        }
        return super.getCarPlayPhysicalDisplayWidth();
    }

    @Override
    public int getScreenOffsetX() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 360;
            }
        }
        return super.getScreenOffsetX();
    }

    @Override
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

    @Override
    public int getWindowResolutionX() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 720;
            }
        }
        return super.getWindowResolutionX();
    }

    @Override
    public int getWindowResolutionY() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 360;
            }
        }
        return super.getWindowResolutionY();
    }

    @Override
    public int getScreenResolutionX() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 1440;
            }
        }
        return super.getScreenResolutionX();
    }

    @Override
    public int getScreenResolutionY() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 542;
            }
        }
        return super.getScreenResolutionY();
    }

    @Override
    public int getPhysicalDisplayHeight() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 108;
            }
        }
        return super.getPhysicalDisplayHeight();
    }

    @Override
    public int getPhysicalDisplayWidth() {
        switch (this.fw.getScreenRes()) {
            case 4: {
                return 290;
            }
        }
        return super.getPhysicalDisplayWidth();
    }

    @Override
    public boolean isOnHoldWhenPhoneCallActive() {
        return false;
    }
}

