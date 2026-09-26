/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.nbest.IPicklist;
import org.dsi.ifc.speechrec.GraphemicGroup;

class PicklistHistoryElement {
    private final int nBestPicklistID;
    private final IPicklist flatPicklist;
    private final IPicklist mixedPicklist;
    private final GraphemicGroup[] ggInfo;

    PicklistHistoryElement(IPicklist iPicklist, IPicklist iPicklist2, int n, GraphemicGroup[] graphemicGroupArray) {
        this.flatPicklist = iPicklist;
        this.mixedPicklist = iPicklist2;
        this.nBestPicklistID = n;
        this.ggInfo = graphemicGroupArray;
    }

    public int getNBestPicklistID() {
        return this.nBestPicklistID;
    }

    public IPicklist getFlatPicklist() {
        return this.flatPicklist;
    }

    public IPicklist getMixedPicklist() {
        return this.mixedPicklist;
    }

    public IPicklist getPicklist(int n) {
        switch (n) {
            case 0: {
                return this.flatPicklist;
            }
            case 1: {
                return this.mixedPicklist;
            }
        }
        return null;
    }

    public GraphemicGroup[] getGgInfo() {
        return this.ggInfo;
    }
}

