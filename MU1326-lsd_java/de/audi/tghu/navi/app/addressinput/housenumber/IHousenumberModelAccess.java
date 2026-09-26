/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.housenumber;

import de.audi.tghu.navi.app.addressinput.IAddressInputModelAccess;
import org.dsi.ifc.global.NavLocation;

public interface IHousenumberModelAccess
extends IAddressInputModelAccess {
    public static final int HOUSENUMBER_VALID;
    public static final int HOUSENUMBER_INVALID;

    @Override
    default public void onStart(NavLocation navLocation) {
    }

    default public void onHousenumberValid() {
    }

    default public void onElementSelected(NavLocation navLocation) {
    }

    default public void onHousenumberInvalid(String string) {
    }

    default public void updatePreviewHousenumber(String string) {
    }
}

