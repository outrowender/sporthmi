/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.oneshot.IOneshotDestinationTypeMapper;
import de.audi.app.sdsmanager.oneshot.IOneshotFilterStrategy;
import de.audi.app.sdsmanager.oneshot.IOneshotListModeMapper;
import de.audi.app.sdsmanager.oneshot.IOneshotPicklistHandling;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.LabelModelApp;

public class MediaG2POneshotHandler
extends OneshotHandler {
    public MediaG2POneshotHandler(HMIService hMIService, int n, IOneshotPicklistHandling iOneshotPicklistHandling, IOneshotListModeMapper iOneshotListModeMapper, IOneshotDestinationTypeMapper iOneshotDestinationTypeMapper, IOneshotFilterStrategy iOneshotFilterStrategy, int[] nArray) {
        super(hMIService, n, iOneshotPicklistHandling, iOneshotListModeMapper, iOneshotDestinationTypeMapper, iOneshotFilterStrategy, nArray);
    }

    protected void setOneshotLabelModel(int n, String string) {
        if (n > this.oneshotLevelToLabelModels.length || n < 0) {
            return;
        }
        LabelModelApp labelModelApp = this.hmi.getLabelModel(this.oneshotLevelToLabelModels[n]);
        if (labelModelApp == null) {
            return;
        }
        labelModelApp.setText(string);
    }

    public int determineCorrectOneshotEvent() {
        int n = 20001;
        int n2 = 0;
        for (int i2 = 0; i2 < this.oneshotDataStorage.length; ++i2) {
            if (this.oneshotDataStorage[i2].getText().equals("")) continue;
            block0 : switch (n2) {
                case 0: {
                    switch (i2) {
                        case 0: {
                            n = 20014;
                            break block0;
                        }
                        case 1: {
                            n = 20015;
                            break block0;
                        }
                        case 2: {
                            n = 20016;
                            break block0;
                        }
                    }
                    break;
                }
                case 1: {
                    n = 20017;
                    break;
                }
                case 2: {
                    n = 20000;
                    break;
                }
            }
            ++n2;
        }
        return n;
    }
}

