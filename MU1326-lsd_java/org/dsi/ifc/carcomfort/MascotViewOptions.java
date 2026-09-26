/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.MascotConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class MascotViewOptions {
    public CarViewOption mascotSetFactoryDefault;
    public CarViewOption mascotControl;
    public CarViewOption mascotMode;
    public MascotConfiguration configuration;

    public MascotViewOptions() {
        this.mascotSetFactoryDefault = null;
        this.mascotControl = null;
        this.mascotMode = null;
        this.configuration = null;
    }

    public MascotViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, MascotConfiguration mascotConfiguration) {
        this.mascotSetFactoryDefault = carViewOption;
        this.mascotControl = carViewOption2;
        this.mascotMode = carViewOption3;
        this.configuration = mascotConfiguration;
    }

    public CarViewOption getMascotSetFactoryDefault() {
        return this.mascotSetFactoryDefault;
    }

    public CarViewOption getMascotControl() {
        return this.mascotControl;
    }

    public CarViewOption getMascotMode() {
        return this.mascotMode;
    }

    public MascotConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4200);
        stringBuffer.append("MascotViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("mascotSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.mascotSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("mascotControl");
        stringBuffer.append('=');
        stringBuffer.append(this.mascotControl);
        stringBuffer.append(',');
        stringBuffer.append("mascotMode");
        stringBuffer.append('=');
        stringBuffer.append(this.mascotMode);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

