/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class BundlesInfo {
    private final BundleContext bundleContext;
    private final ListModelApp detectedBundlesList;

    protected BundlesInfo(BundleContext bundleContext, ListModelApp listModelApp) {
        this.bundleContext = bundleContext;
        this.detectedBundlesList = listModelApp;
    }

    public String getCurrentBundleInfo(boolean bl) {
        Bundle[] bundleArray = this.bundleContext.getBundles();
        int n = bundleArray.length;
        if (bl) {
            this.detectedBundlesList.clear();
            this.detectedBundlesList.setMaxRows(n);
            this.detectedBundlesList.setMaxColumns(3);
        }
        Buffer buffer = new Buffer(3500);
        buffer.append("BundleList;");
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 != 0) {
                buffer.append(';');
            }
            String string = this.stripBundleName(bundleArray[i2]);
            String string2 = this.getState(bundleArray[i2]);
            ListCell[] listCellArray = new ListCell[]{new TextListCell(string), new TextListCell(string2), new IntegerListCell(i2)};
            listCellArray[0] = new TextListCell(string + ": " + string2);
            if (bl) {
                this.detectedBundlesList.addRow(listCellArray);
            }
            buffer.append(string);
            buffer.append(" --> ");
            buffer.append(string2);
        }
        return buffer.toString();
    }

    private String stripBundleName(Bundle bundle) {
        String string = bundle.getLocation();
        int n = string.lastIndexOf(47) + 1;
        int n2 = string.lastIndexOf(".jar");
        if (n2 == -1) {
            n2 = string.length();
        }
        return string.substring(n, n2);
    }

    private String getState(Bundle bundle) {
        String string = null;
        switch (bundle.getState()) {
            case 1: {
                string = "rem";
                break;
            }
            case 2: {
                string = "ins";
                break;
            }
            case 4: {
                string = "res";
                break;
            }
            case 8: {
                string = "sta";
                break;
            }
            case 16: {
                string = "sto";
                break;
            }
            case 32: {
                string = "act";
                break;
            }
            default: {
                string = "ukn";
            }
        }
        return string;
    }
}

