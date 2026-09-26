/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

import org.apache.xerces.impl.dv.XSSimpleType;
import org.apache.xerces.xs.ShortList;

public class ValidatedInfo {
    public String normalizedValue;
    public Object actualValue;
    public short actualValueType;
    public XSSimpleType memberType;
    public XSSimpleType[] memberTypes;
    public ShortList itemValueTypes;

    public void reset() {
        this.normalizedValue = null;
        this.actualValue = null;
        this.memberType = null;
        this.memberTypes = null;
    }

    public String stringValue() {
        if (this.actualValue == null) {
            return this.normalizedValue;
        }
        return this.actualValue.toString();
    }

    public static boolean isComparable(ValidatedInfo validatedInfo, ValidatedInfo validatedInfo2) {
        short s;
        short s2 = ValidatedInfo.convertToPrimitiveKind(validatedInfo.actualValueType);
        if (s2 != (s = ValidatedInfo.convertToPrimitiveKind(validatedInfo2.actualValueType))) {
            return s2 == 1 && s == 2 || s2 == 2 && s == 1;
        }
        if (s2 == 44 || s2 == 43) {
            int n;
            ShortList shortList = validatedInfo.itemValueTypes;
            ShortList shortList2 = validatedInfo2.itemValueTypes;
            int n2 = shortList != null ? shortList.getLength() : 0;
            int n3 = n = shortList2 != null ? shortList2.getLength() : 0;
            if (n2 != n) {
                return false;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                short s3;
                short s4 = ValidatedInfo.convertToPrimitiveKind(shortList.item(i2));
                if (s4 == (s3 = ValidatedInfo.convertToPrimitiveKind(shortList2.item(i2))) || s4 == 1 && s3 == 2 || s4 == 2 && s3 == 1) continue;
                return false;
            }
        }
        return true;
    }

    private static short convertToPrimitiveKind(short s) {
        if (s <= 20) {
            return s;
        }
        if (s <= 29) {
            return 2;
        }
        if (s <= 42) {
            return 4;
        }
        return s;
    }
}

