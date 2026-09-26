/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.fw.util.commons.Buffer;

public class ConversionLineController$ConversionLineButtonType {
    public static final ConversionLineController$ConversionLineButtonType MATRIX_BUTTON = new ConversionLineController$ConversionLineButtonType("MATRIX BUTTON", "matrixButtonImageNode", HMIImageConstantsSystem.mib2_conversionline_matrix_button, HMIImageConstantsSystem.mib2_conversionline_matrix_button_big);
    public static final ConversionLineController$ConversionLineButtonType TRUFFLE_BUTTON = new ConversionLineController$ConversionLineButtonType("TRUFFLE BUTTON", "truffleButtonImageNode", HMIImageConstantsSystem.mib2_speller_button_truffles_enabled, HMIImageConstantsSystem.mib2_speller_button_truffles_enabled_big);
    public static final ConversionLineController$ConversionLineButtonType NULL = new ConversionLineController$ConversionLineButtonType("NULL", "NULL", -1, -1);
    private final String name;
    private final String imageNodeName;
    private final int bitmapId;
    private final int bitmapIdHighlighted;

    private ConversionLineController$ConversionLineButtonType(String string, String string2, int n, int n2) {
        this.name = string;
        this.imageNodeName = string2;
        this.bitmapId = n;
        this.bitmapIdHighlighted = n2;
    }

    public String getName() {
        return this.name;
    }

    public String getImageNodeName() {
        return this.imageNodeName;
    }

    public int getBitmapId() {
        return this.bitmapId;
    }

    public int getBitmapIdHighlighted() {
        return this.bitmapIdHighlighted;
    }

    public String toString() {
        return new Buffer("ConversionLineButtonType[").append(this.name).append("]").toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.bitmapId;
        n = 31 * n + this.bitmapIdHighlighted;
        n = 31 * n + (this.imageNodeName == null ? 0 : this.imageNodeName.hashCode());
        n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof ConversionLineController$ConversionLineButtonType)) {
            return false;
        }
        ConversionLineController$ConversionLineButtonType conversionLineController$ConversionLineButtonType = (ConversionLineController$ConversionLineButtonType)object;
        if (this.bitmapId != conversionLineController$ConversionLineButtonType.bitmapId) {
            return false;
        }
        if (this.bitmapIdHighlighted != conversionLineController$ConversionLineButtonType.bitmapIdHighlighted) {
            return false;
        }
        if (this.imageNodeName == null ? conversionLineController$ConversionLineButtonType.imageNodeName != null : !this.imageNodeName.equals(conversionLineController$ConversionLineButtonType.imageNodeName)) {
            return false;
        }
        return !(this.name == null ? conversionLineController$ConversionLineButtonType.name != null : !this.name.equals(conversionLineController$ConversionLineButtonType.name));
    }
}

