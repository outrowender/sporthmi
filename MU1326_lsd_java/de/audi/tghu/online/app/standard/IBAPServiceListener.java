/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.interapp.bap.eni.data.Service;

public interface IBAPServiceListener {
    default public void onServiceList(Service[] serviceArray) {
    }
}

