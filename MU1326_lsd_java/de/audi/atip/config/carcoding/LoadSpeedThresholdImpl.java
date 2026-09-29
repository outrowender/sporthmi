/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.config.carcoding.BitHelper;
import de.audi.atip.sysapp.carcoding.LoadSpeedThreshold;
import de.esolutions.fw.util.commons.Buffer;

public final class LoadSpeedThresholdImpl
implements LoadSpeedThreshold {
    private byte[] upDownLoadData;

    public LoadSpeedThresholdImpl(byte[] byArray) {
        this.upDownLoadData = byArray;
    }

    @Override
    public int getVideoCutOffThreshold() {
        return this.getByte(0, 30);
    }

    @Override
    public int getVideoHysteresis() {
        return this.getHysteresis(1, 10, this.getVideoCutOffThreshold());
    }

    @Override
    public int getSlideshowCutOffThreshold() {
        return this.getByte(4, 30);
    }

    @Override
    public int getSlideshowHysteresis() {
        return this.getHysteresis(5, 10, this.getSlideshowCutOffThreshold());
    }

    @Override
    public int getSlideshowDisplayDuration1() {
        return (this.upDownLoadData[6] & 0xFF) << 8 | this.upDownLoadData[7] & 0xFF;
    }

    @Override
    public int getSlideshowDisplayDuration2() {
        return (this.upDownLoadData[8] & 0xFF) << 8 | this.upDownLoadData[9] & 0xFF;
    }

    @Override
    public int getDestinationInputCutOffThreshold() {
        return this.getByte(16, 30);
    }

    @Override
    public int getDestinationInputHysteresis() {
        return this.getHysteresis(17, 10, this.getDestinationInputCutOffThreshold());
    }

    @Override
    public int getBtBondingCutOffThreshold() {
        return this.getByte(18, 30);
    }

    @Override
    public int getBtBondingHysteresis() {
        return this.getHysteresis(19, 10, this.getBtBondingCutOffThreshold());
    }

    @Override
    public int getMessagingTextEditorCutOffThreshold() {
        return this.getByte(20, 30);
    }

    @Override
    public int getMessagingTextEditorHysteresis() {
        return this.getHysteresis(21, 10, this.getMessagingTextEditorCutOffThreshold());
    }

    @Override
    public int getRadioTextCutOffThreshold() {
        return this.getByte(22, 30);
    }

    @Override
    public int getRadioTextHysteresis() {
        return this.getHysteresis(23, 10, this.getRadioTextCutOffThreshold());
    }

    @Override
    public int getRadioTextDisplayTime() {
        return (this.upDownLoadData[24] & 0xFF) << 8 | this.upDownLoadData[25] & 0xFF;
    }

    private int getByte(int n, int n2) {
        return BitHelper.unsignedByteToInt(this.upDownLoadData[n]);
    }

    private int getHysteresis(int n, int n2, int n3) {
        int n4 = BitHelper.unsignedByteToInt(this.upDownLoadData[n]);
        if (n4 < n3) {
            return n4;
        }
        return n3 / 2;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        String string = "[ 0x";
        buffer.append("\n\nSpeedThresholdData");
        for (int i2 = 0; i2 < this.upDownLoadData.length; ++i2) {
            buffer.append(string);
            buffer.append(Integer.toHexString(this.upDownLoadData[i2]));
            string = ", 0x";
        }
        buffer.append(" ]\n");
        buffer.append("\nBtBondingCutOffThreshold: ").append(this.getBtBondingCutOffThreshold());
        buffer.append("\nBtBondingHysteresis: ").append(this.getBtBondingHysteresis());
        buffer.append("\nDestinationInputCutOffThreshold: ").append(this.getDestinationInputCutOffThreshold());
        buffer.append("\nDestinationInputHysteresis: ").append(this.getDestinationInputHysteresis());
        buffer.append("\nMessagingTextEditorCutOffThreshold: ").append(this.getMessagingTextEditorCutOffThreshold());
        buffer.append("\nMessagingTextEditorHysteresis: ").append(this.getMessagingTextEditorHysteresis());
        buffer.append("\nRadioTextCutOffThreshold: ").append(this.getRadioTextCutOffThreshold());
        buffer.append("\nRadioTextDisplayTime: ").append(this.getRadioTextDisplayTime());
        buffer.append("\nRadioTextHysteresis: ").append(this.getRadioTextHysteresis());
        buffer.append("\nSlideshowCutOffThreshold: ").append(this.getSlideshowCutOffThreshold());
        buffer.append("\nSlideshowDisplayDuration1: ").append(this.getSlideshowDisplayDuration1());
        buffer.append("\nSlideshowDisplayDuration2: ").append(this.getSlideshowDisplayDuration2());
        buffer.append("\nSlideshowHysteresis: ").append(this.getSlideshowHysteresis());
        buffer.append("\nVideoCutOffThreshold: ").append(this.getVideoCutOffThreshold());
        buffer.append("\nVideoHysteresis: ").append(this.getVideoHysteresis());
        return buffer.toString();
    }
}

