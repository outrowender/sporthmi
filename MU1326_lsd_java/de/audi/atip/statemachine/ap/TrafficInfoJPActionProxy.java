/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface TrafficInfoJPActionProxy
extends ActionProxy {
    public void vicsMenuEntered(int var1);

    public void vicsMenuLeft(int var1);

    public void focusPreviewMapOnCCP(int var1);

    public void vicsApplicationLeft(int var1);

    public void vicsGlobalShowInMapLeft(int var1);
}

