/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

public class ModelDescription {
    public static String getList(int n) {
        String string;
        switch (n) {
            case 2300157: {
                string = "mainScreen";
                break;
            }
            case 2300993: {
                string = "optionsScreen";
                break;
            }
            case 2300696: {
                string = "mainRightDrawer";
                break;
            }
            case 2300998: {
                string = "optionsRightDrawer";
                break;
            }
            default: {
                string = "id " + n;
            }
        }
        return string;
    }
}

