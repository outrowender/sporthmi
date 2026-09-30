/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.housenumber;

import de.audi.tghu.navi.app.addressinput.IAddressInputModelAccess;
import org.dsi.ifc.global.NavLocation;

public interface IHousenumberModelAccess
extends IAddressInputModelAccess {
    public static final int HOUSENUMBER_VALID = 1;
    public static final int HOUSENUMBER_INVALID = 0;

    public void onStart(NavLocation var1);

    public void onHousenumberValid();

    public void onElementSelected(NavLocation var1);

    public void onHousenumberInvalid(String var1);

    public void updatePreviewHousenumber(String var1);
}

