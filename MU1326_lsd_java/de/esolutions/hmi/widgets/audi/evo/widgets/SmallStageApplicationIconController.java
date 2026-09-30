/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class SmallStageApplicationIconController
extends IconController {
    private static final int INDEX_AU334_LHD = 0;
    private static final int INDEX_AU334_RHD = 10;
    private static final int INDEX_AU335_LHD = 11;
    private static final int INDEX_AU335_RHD = 12;
    private static final int INDEX_AU724_LHD = 13;
    private static final int INDEX_AU724_RHD = 14;
    private static final int INDEX_AU7248_LHD = 15;
    private static final int INDEX_AU7248_RHD = 16;
    private static final int INDEX_AU7258_LHD = 17;
    private static final int INDEX_AU7258_RHD = 18;
    private static int correctCarPictureIndex = -1;

    protected void initializeWidget() {
        ScreenMainArea screenMainArea;
        super.initializeWidget();
        if (this.isSmallStageApplicationIcon() && this.initContext.getScreen() instanceof AbstractScreenWidget && (screenMainArea = ((AbstractScreenWidget)this.initContext.getScreen()).getMainArea()) != null) {
            screenMainArea.setNotFocusableIcon(this);
        }
    }

    private int calculateCorrectCarPictureIndex() {
        int n;
        int n2 = this.terminal.getCarCodingHelper().getCarType();
        boolean bl = AbstractWidget.isRightHandDrive();
        switch (n2) {
            case 20: {
                n = bl ? 10 : 0;
                break;
            }
            case 21: {
                n = bl ? 12 : 11;
                break;
            }
            case 40: 
            case 42: 
            case 44: {
                n = bl ? 14 : 13;
                break;
            }
            case 41: {
                n = bl ? 16 : 15;
                break;
            }
            case 43: {
                n = bl ? 18 : 17;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (!this.isSmallStageApplicationIcon()) {
            super.processModelUpdateEvent(modelUpdateEvent);
        }
    }

    protected Object calculateModelContent() {
        if (this.model instanceof ChoiceModelGUI) {
            int n = ((ChoiceModelGUI)this.model).getValue();
            if (n == 0) {
                if (correctCarPictureIndex == -1) {
                    correctCarPictureIndex = this.calculateCorrectCarPictureIndex();
                }
                if (this.hasBitmap(correctCarPictureIndex)) {
                    return new Integer(correctCarPictureIndex);
                }
            }
            return new Integer(n);
        }
        iconLogChannel.log(10000000, "SmallStageApplicatoinIconController#calculateModelContent internal model is not a choice model (expected).");
        return super.calculateModelContent();
    }

    protected boolean isSmallStageApplicationIcon() {
        return this.model != null && this.modelID == 138;
    }
}

