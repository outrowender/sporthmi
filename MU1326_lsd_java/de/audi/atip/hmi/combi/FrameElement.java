/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

import de.audi.atip.hmi.combi.CombiElementConstants;

public class FrameElement
implements CombiElementConstants {
    public int frameID = -1;

    public String toString() {
        String string = null;
        switch (this.frameID) {
            case 0: {
                string = "Coordinates";
                break;
            }
            case 1: {
                string = "Navigation";
                break;
            }
            case 2: {
                string = "List";
                break;
            }
            case 3: {
                string = "Status";
                break;
            }
            default: {
                string = "undefined";
            }
        }
        return string;
    }
}

