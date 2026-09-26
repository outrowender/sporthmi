/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.HUDDisplaySection1;
import org.dsi.ifc.carkombi.HUDDisplaySection2;
import org.dsi.ifc.carkombi.HUDDisplaySection3;
import org.dsi.ifc.carkombi.HUDDisplaySection4;

public class HUDSectionConfigListRecord {
    public int pos;
    public int displaySection;
    public HUDDisplaySection1 displaySectionSetup1;
    public HUDDisplaySection2 displaySectionSetup2;
    public HUDDisplaySection3 displaySectionSetup3;
    public HUDDisplaySection4 displaySectionSetup4;
    public HUDDisplaySection1 displaySectionSelection1;
    public HUDDisplaySection2 displaySectionSelection2;
    public HUDDisplaySection3 displaySectionSelection3;
    public HUDDisplaySection4 displaySectionSelection4;

    public HUDSectionConfigListRecord() {
        this.pos = 0;
        this.displaySection = 0;
        this.displaySectionSetup1 = null;
        this.displaySectionSetup2 = null;
        this.displaySectionSetup3 = null;
        this.displaySectionSetup4 = null;
        this.displaySectionSelection1 = null;
        this.displaySectionSelection2 = null;
        this.displaySectionSelection3 = null;
        this.displaySectionSelection4 = null;
    }

    public HUDSectionConfigListRecord(int n, int n2, HUDDisplaySection1 hUDDisplaySection1, HUDDisplaySection2 hUDDisplaySection2, HUDDisplaySection3 hUDDisplaySection3, HUDDisplaySection4 hUDDisplaySection4, HUDDisplaySection1 hUDDisplaySection12, HUDDisplaySection2 hUDDisplaySection22, HUDDisplaySection3 hUDDisplaySection32, HUDDisplaySection4 hUDDisplaySection42) {
        this.pos = n;
        this.displaySection = n2;
        this.displaySectionSetup1 = hUDDisplaySection1;
        this.displaySectionSetup2 = hUDDisplaySection2;
        this.displaySectionSetup3 = hUDDisplaySection3;
        this.displaySectionSetup4 = hUDDisplaySection4;
        this.displaySectionSelection1 = hUDDisplaySection12;
        this.displaySectionSelection2 = hUDDisplaySection22;
        this.displaySectionSelection3 = hUDDisplaySection32;
        this.displaySectionSelection4 = hUDDisplaySection42;
    }

    public int getPos() {
        return this.pos;
    }

    public int getDisplaySection() {
        return this.displaySection;
    }

    public HUDDisplaySection1 getDisplaySectionSetup1() {
        return this.displaySectionSetup1;
    }

    public HUDDisplaySection2 getDisplaySectionSetup2() {
        return this.displaySectionSetup2;
    }

    public HUDDisplaySection3 getDisplaySectionSetup3() {
        return this.displaySectionSetup3;
    }

    public HUDDisplaySection4 getDisplaySectionSetup4() {
        return this.displaySectionSetup4;
    }

    public HUDDisplaySection1 getDisplaySectionSelection1() {
        return this.displaySectionSelection1;
    }

    public HUDDisplaySection2 getDisplaySectionSelection2() {
        return this.displaySectionSelection2;
    }

    public HUDDisplaySection3 getDisplaySectionSelection3() {
        return this.displaySectionSelection3;
    }

    public HUDDisplaySection4 getDisplaySectionSelection4() {
        return this.displaySectionSelection4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(8550);
        stringBuffer.append("HUDSectionConfigListRecord");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("displaySection");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySection);
        stringBuffer.append(',');
        stringBuffer.append("displaySectionSetup1");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySectionSetup1);
        stringBuffer.append(',');
        stringBuffer.append("displaySectionSetup2");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySectionSetup2);
        stringBuffer.append(',');
        stringBuffer.append("displaySectionSetup3");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySectionSetup3);
        stringBuffer.append(',');
        stringBuffer.append("displaySectionSetup4");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySectionSetup4);
        stringBuffer.append(',');
        stringBuffer.append("displaySectionSelection1");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySectionSelection1);
        stringBuffer.append(',');
        stringBuffer.append("displaySectionSelection2");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySectionSelection2);
        stringBuffer.append(',');
        stringBuffer.append("displaySectionSelection3");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySectionSelection3);
        stringBuffer.append(',');
        stringBuffer.append("displaySectionSelection4");
        stringBuffer.append('=');
        stringBuffer.append(this.displaySectionSelection4);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

