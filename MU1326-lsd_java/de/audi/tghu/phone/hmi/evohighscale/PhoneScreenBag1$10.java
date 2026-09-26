/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.phone.hmi.evohighscale.PhoneScreenFactory;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ImageDecoratorRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SelectionCursorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ImageDecoratorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class PhoneScreenBag1$10
implements ListItemFactory {
    private final /* synthetic */ PhoneScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    PhoneScreenBag1$10(PhoneScreenFactory phoneScreenFactory, int n) {
        this.val$factory = phoneScreenFactory;
        this.val$terminalID = n;
    }

    /*
     * Exception decompiling
     */
    @Override
    public AbstractWidgetController createListItem(int var1, ListCell[] var2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.ArrayIndexOutOfBoundsException
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public AbstractWidgetController createListItemNoData() {
        return null;
    }

    public AbstractWidgetController createCell(int n) {
        switch (n) {
            case 0: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{1972634624});
                iconRendererHigh.setAlignment(3, 6);
                return iconController;
            }
            case 1: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{1989411840, 127, 127});
                iconController.setModelColumn(9);
                iconRendererHigh.setAlignment(1, 6);
                return iconController;
            }
            case 2: {
                ImageDecoratorController imageDecoratorController = new ImageDecoratorController();
                ImageDecoratorRenderer imageDecoratorRenderer = new ImageDecoratorRenderer(imageDecoratorController);
                imageDecoratorController.setRenderer(imageDecoratorRenderer);
                imageDecoratorController.setBounds(0, 0, 100, 100);
                imageDecoratorController.setModelColumn(11);
                imageDecoratorController.setPreferredHeight(90);
                imageDecoratorController.setPreferredWidth(90);
                return imageDecoratorController;
            }
            case 3: {
                ImageDecoratorController imageDecoratorController = new ImageDecoratorController();
                ImageDecoratorRenderer imageDecoratorRenderer = new ImageDecoratorRenderer(imageDecoratorController);
                imageDecoratorController.setRenderer(imageDecoratorRenderer);
                imageDecoratorController.setBitmaps(new int[]{127, 127, 1871971328});
                imageDecoratorController.setModelColumn(9);
                return imageDecoratorController;
            }
            case 4: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{319, 320, 321, 322, 323, 324, 325, 326, 327, 127, 328, 318});
                iconController.setModelColumn(2);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(5);
                labelRendererHigh.setAlignment(3, 5);
                return labelController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-526646272, -509869056, -493091840, 1016923136});
                labelController.setModelColumn(13);
                return labelController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-174586880, 1117586432, 1134363648});
                labelController.setModelColumn(15);
                return labelController;
            }
            case 9: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{56, 56, 0x49940400, 127});
                iconController.setModelColumn(10);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 10: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-795343872, -778566656, -174586880});
                labelController.setModelColumn(4);
                return labelController;
            }
            case 11: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-476314624});
                return labelController;
            }
            case 12: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{714605568, -442760192, 748160000, 748160000, 781714432, -392428544, 815268864, 832046080, 798622720, 865600512, 882377728, 899154944, 915932160, 815268864, 832046080});
                labelController.setModelColumn(6);
                return labelController;
            }
            case 13: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-795343872, -778566656, -174586880});
                labelController.setColorIndices(new int[]{4, 4, 4, 4});
                labelController.setEnabled(false);
                labelController.setModelColumn(4);
                return labelController;
            }
            case 14: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-241433600, -224656384});
                labelController.setModelColumn(14);
                return labelController;
            }
            case 15: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setModelColumn(5);
                labelRendererHigh.setAlignment(3, 5);
                return labelController;
            }
            case 16: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-526646272, -509869056, -493091840, 1016923136});
                labelController.setColorIndices(new int[]{4, 4, 4, 4});
                labelController.setModelColumn(13);
                return labelController;
            }
            case 17: {
                SelectionCursorController selectionCursorController = new SelectionCursorController();
                SelectionCursorRendererHigh selectionCursorRendererHigh = new SelectionCursorRendererHigh(selectionCursorController);
                selectionCursorController.setRenderer(selectionCursorRendererHigh);
                selectionCursorController.setBounds(0, 0, 100, 100);
                selectionCursorController.setColorIndices(new int[]{1, 2, 4, 0});
                selectionCursorController.setSeparatorPosition(74);
                selectionCursorController.setSeparatorWidth(550);
                selectionCursorRendererHigh.setBackgroundMode(1);
                return selectionCursorController;
            }
            case 18: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{2090075136, 127, -2137783296});
                iconController.setModelColumn(9);
                iconController.setPreferredHeight(84);
                iconController.setPreferredWidth(95);
                iconRendererHigh.setAlignment(3, 5);
                iconRendererHigh.setScaleMode(1);
                return iconController;
            }
            case 19: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                iconController.setModelColumn(11);
                iconController.setPreferredHeight(84);
                iconController.setPreferredWidth(95);
                iconRendererHigh.setAlignment(3, 5);
                iconRendererHigh.setScaleMode(1);
                return iconController;
            }
            case 20: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-476314624});
                labelController.setColorIndices(new int[]{4, 4, 4, 4});
                return labelController;
            }
            case 21: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{1033700352, 1050477568, -1986198528, -1986198528, -1969421312, -56884224, -1952644096, -1935866880, -1919089664, -1902312448, -1885535232, -1868758016, -1851980800, -1952644096, -1935866880});
                labelController.setColorIndices(new int[]{4, 4, 4, 4});
                labelController.setModelColumn(6);
                return labelController;
            }
            case 22: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-241433600, -224656384});
                labelController.setColorIndices(new int[]{4, 4, 4, 4});
                labelController.setModelColumn(14);
                return labelController;
            }
            case 23: {
                SelectionCursorController selectionCursorController = new SelectionCursorController();
                SelectionCursorRendererHigh selectionCursorRendererHigh = new SelectionCursorRendererHigh(selectionCursorController);
                selectionCursorController.setRenderer(selectionCursorRendererHigh);
                selectionCursorController.setBounds(0, 0, 100, 100);
                selectionCursorController.setColorIndices(new int[]{1, 2, 4, 0});
                selectionCursorController.setDimmed(true);
                selectionCursorController.setSeparatorPosition(74);
                selectionCursorController.setSeparatorWidth(550);
                selectionCursorRendererHigh.setBackgroundMode(1);
                return selectionCursorController;
            }
            case 24: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{2090075136, 127, -2137783296});
                iconController.setModelColumn(9);
                iconController.setOpacityGuide(-842249153);
                iconController.setPreferredHeight(84);
                iconController.setPreferredWidth(95);
                iconRendererHigh.setAlignment(3, 5);
                iconRendererHigh.setScaleMode(1);
                return iconController;
            }
            case 25: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                iconController.setModelColumn(11);
                iconController.setOpacityGuide(-842249153);
                iconController.setPreferredHeight(84);
                iconController.setPreferredWidth(95);
                iconRendererHigh.setAlignment(3, 5);
                iconRendererHigh.setScaleMode(1);
                return iconController;
            }
        }
        return null;
    }
}

