/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;

public class TunerFrequencySetCommand
extends AbstractSystemCallCommand {
    private static final int FREQUENCY_THRESHOLD = 200;
    private final NBestStorageAccess nBestHandler;
    private final TunerService tunerService;
    private final byte[][] tagToHDSubchannelMapping = new byte[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, {8, 8}};

    public TunerFrequencySetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, TunerService tunerService) {
        super(logChannel, string, sDSHandlerService);
        this.nBestHandler = nBestStorageAccess;
        this.tunerService = tunerService;
    }

    public void execute() {
        long l = this.getKHzFormattedFrequency();
        this.logger.log(10000000, "%1#execute: frequency=%2", (Object)this.getName(), l);
        if (l == -1L) {
            this.sendResult(10005);
            return;
        }
        byte by = SDSUtils.translate((byte)SDSModelAccess.getTagModel(), this.tagToHDSubchannelMapping);
        if (by == -128) {
            by = 0;
        }
        byte by2 = this.tunerService.tuneFrequency(l, by);
        this.sendResult(TunerSDSUtils.getWBSResult(by2, this.logger));
    }

    private long getKHzFormattedFrequency() {
        this.logger.log(10000000, "%1#getKHzFormattedFrequency: called", (Object)this.getName());
        IPicklistSlot iPicklistSlot = this.nBestHandler.getSlotForPicklistElement(0, 0, (byte)0, true);
        if (iPicklistSlot == null) {
            return -1L;
        }
        String string = iPicklistSlot.getText();
        int n = string.indexOf(44);
        if (n != -1) {
            StringBuffer stringBuffer = new StringBuffer(string.substring(0, n).trim());
            String string2 = string.substring(n + 1);
            stringBuffer = stringBuffer.append(".").append(string2.trim());
            string = stringBuffer.toString();
            SDSModelAccess.setSlotModel(0, string.replace('.', ','));
        }
        this.logger.log(10000000, "%1#getKHzFormattedFrequency: freqStr=%2", (Object)this.getName(), (Object)string);
        double d2 = Double.parseDouble(string);
        double d3 = d2 < 200.0 ? d2 * 1000.0 : d2;
        return (long)d3;
    }

    protected void handleSDSLineNumbering() {
        SDSUtils.updateSDSNumbers(false);
    }
}

