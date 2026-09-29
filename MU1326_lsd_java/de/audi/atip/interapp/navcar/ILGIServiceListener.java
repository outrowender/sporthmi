/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.navcar;

import org.dsi.ifc.tmc.LocalHazardInformation;

public interface ILGIServiceListener {
    default public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
    }
}

