/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi.ddp2;

import de.audi.atip.hmi.combi.ddp2.CombiElementConstantsDDP2;

public class FrameElementDDP2
implements CombiElementConstantsDDP2 {
    public int frameID = -1;

    public String toString() {
        switch (this.frameID) {
            case 0: {
                return "Navigation";
            }
            case 1: {
                return "Navigation Context";
            }
            case 2: {
                return "Media";
            }
            case 3: {
                return "Media Context";
            }
            case 4: {
                return "Telephone";
            }
            case 5: {
                return "Telephone Context";
            }
            case 6: {
                return "Telephone Popup";
            }
            case 15: {
                return "Fastscroll Media";
            }
            case 16: {
                return "Fastscroll Telephone";
            }
            case 17: {
                return "Fastscroll Navigation";
            }
            case 9: {
                return "Statusbar";
            }
            case 10: {
                return "RGI extended";
            }
            case 11: {
                return "MOST";
            }
            case 12: {
                return "Compass";
            }
            case 13: {
                return "Lane Guidance";
            }
            case 14: {
                return "Traffic Signs";
            }
        }
        return "undefined";
    }
}

