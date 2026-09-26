/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$AbstractCandidateItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController$ConversionLineButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController$IButtonItem;

public class ConversionLineController$ButtonItem
extends AbstractConversionWidgetController$AbstractCandidateItem
implements ConversionLineController$IButtonItem {
    private static final String TYPE_KEY;
    private final ConversionLineController$ConversionLineButtonType type;

    public ConversionLineController$ButtonItem(ConversionLineController$ConversionLineButtonType conversionLineController$ConversionLineButtonType) {
        this.type = conversionLineController$ConversionLineButtonType;
    }

    @Override
    public ConversionLineController$ConversionLineButtonType getButtonType() {
        return this.type;
    }

    @Override
    public String getTypeKey() {
        return "ConversionLineController.ButtonItem";
    }

    @Override
    public String toString() {
        return new Buffer("ButtonItem[").append(this.type.getName()).append(']').toString();
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + (this.type == null ? 0 : this.type.hashCode());
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof ConversionLineController$ButtonItem)) {
            return false;
        }
        ConversionLineController$ButtonItem conversionLineController$ButtonItem = (ConversionLineController$ButtonItem)object;
        return !(this.type == null ? conversionLineController$ButtonItem.type != null : !this.type.equals(conversionLineController$ButtonItem.type));
    }
}

