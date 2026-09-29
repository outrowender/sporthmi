/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import org.dsi.ifc.global.NavLocation;

public interface ILocationHandler {
    default public NavLocation handleLocation(NavLocation navLocation) {
    }
}

