/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange;

import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;

public class VCardExchangeViewListener
implements ButtonListener,
ChoiceListener {
    private LogChannel log;
    private IHMIServiceApp hmiService;
    private VCardExchangeADBHandler vCardExchangeADBHandler;

    public VCardExchangeViewListener(LogChannel logChannel, VCardExchangeADBHandler vCardExchangeADBHandler) {
        this.log = logChannel;
        this.vCardExchangeADBHandler = vCardExchangeADBHandler;
        this.hmiService = vCardExchangeADBHandler.getHMIService();
        this.hmiService.getButtonModel(632293888).setButtonListener(this);
        this.hmiService.getButtonModel(649071104).setButtonListener(this);
        this.hmiService.getButtonModel(665848320).setButtonListener(this);
        this.hmiService.getButtonModel(1773144576).setButtonListener(this);
        this.hmiService.getButtonModel(2008025600).setButtonListener(this);
        this.hmiService.getButtonModel(766511616).setButtonListener(this);
        this.hmiService.getButtonModel(984615424).setButtonListener(this);
        this.hmiService.getButtonModel(1001392640).setButtonListener(this);
        this.hmiService.getButtonModel(1018169856).setButtonListener(this);
        this.hmiService.getButtonModel(1789921792).setButtonListener(this);
        this.hmiService.getButtonModel(900729344).setButtonListener(this);
        this.hmiService.getButtonModel(1169164800).setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.log.log(-2137614336, "VCardExchangeViewListener#keyPressed(): called, model ID %1", (long)n);
        switch (n) {
            case 700453: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Export to left SD card selected. Switching to ADB entry list.");
                this.hmiService.getChoiceModel(615516672).setValue(1);
                this.vCardExchangeADBHandler.startExportListView(1);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700454: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Export to right SD card selected. Switching to ADB entry list.");
                this.hmiService.getChoiceModel(615516672).setValue(2);
                this.vCardExchangeADBHandler.startExportListView(2);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700455: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Export to USB1 device selected. Switching to ADB entry list.");
                this.hmiService.getChoiceModel(615516672).setValue(3);
                this.vCardExchangeADBHandler.startExportListView(3);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700521: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Export to USB2 device selected. Switching to ADB entry list.");
                this.hmiService.getChoiceModel(615516672).setValue(4);
                this.vCardExchangeADBHandler.startExportListView(4);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700461: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Export button pressed.");
                if (this.hmiService.getLabelModel(1336936960).getStatus() != 0) {
                    this.vCardExchangeADBHandler.exportVCards();
                } else {
                    this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Export already in progress.");
                }
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700474: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Import from left SD card selected. Switching to entry list for that storage device.");
                this.hmiService.getChoiceModel(850397696).setValue(0);
                this.vCardExchangeADBHandler.startFileBrowsing(1);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700475: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Import from right SD card selected. Switching to entry list for that storage device.");
                this.hmiService.getChoiceModel(850397696).setValue(1);
                this.vCardExchangeADBHandler.startFileBrowsing(2);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700476: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Import from USB 1 device selected. Switching to entry list for that storage device.");
                this.hmiService.getChoiceModel(850397696).setValue(2);
                this.vCardExchangeADBHandler.startFileBrowsing(3);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700522: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Import from USB 2 device selected. Switching to entry list for that storage device.");
                this.hmiService.getChoiceModel(850397696).setValue(3);
                this.vCardExchangeADBHandler.startFileBrowsing(4);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700469: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Back button (folder up) pressed.");
                this.vCardExchangeADBHandler.oneFolderUp();
                break;
            }
            case 700485: {
                this.log.log(1078071040, "VCardExchangeViewListener#keyPressed(): Import button pressed.");
                this.vCardExchangeADBHandler.importVCards();
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000, "VCardExchangeViewListener#keyPressed(): Unknown model ID %1.", (long)n);
            }
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "VCardExchangeViewListener#itemSelected(): called, model ID %1", (long)n);
        switch (n) {
            case 700535: {
                boolean bl = n2 == 0;
                this.log.log(1078071040, "VCardExchangeViewListener#itemSelected(ADR_EXPORT_SK_ALL_CHOICE): setting listModePositive to %1.", bl);
                this.vCardExchangeADBHandler.getVCardExportListHandler().toggleListMode(bl);
                break;
            }
            default: {
                this.log.log(10000, "VCardExchangeViewListener#itemSelected(): Unknown model ID %1.", (long)n);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

