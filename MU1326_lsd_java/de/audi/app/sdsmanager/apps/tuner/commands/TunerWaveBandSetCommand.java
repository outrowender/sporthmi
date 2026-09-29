/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;

public class TunerWaveBandSetCommand
extends AbstractSystemCallCommand {
    private static final byte WAVEBAND_FM;
    private static final byte WAVEBAND_AM;
    private static final byte WAVEBAND_DAB;
    private static final byte WAVEBAND_SAT;
    private static final byte WAVEBAND_COMMON;
    private static final byte WAVEBAND_HISTORY;
    private static final byte WAVEBAND_FAVORITE;
    private static final byte WAVEBAND_SIRIUS_SEEK;
    private static byte[][] waveBandToTunerWaveBand;
    private static int[][] waveBandToSDSResult;
    private final byte waveBand;
    private final TunerService tunerService;

    public TunerWaveBandSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, TunerService tunerService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.tunerService = tunerService;
        this.waveBand = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        byte by;
        int n;
        this.logger.log(-2137614336, "%1#execute: waveBand=%2", (Object)this.getName(), (long)this.waveBand);
        byte by2 = SDSUtils.translate(this.waveBand, waveBandToTunerWaveBand);
        if (by2 == -128) {
            this.logger.log(-1601830656, "%1#getTunerWaveBand: Unhandled waveBand %1, assuming FM!", (Object)this.getName(), (long)this.waveBand);
            by2 = 1;
        }
        if ((n = SDSUtils.translate((int)(by = this.tunerService.selectWaveBand(by2)), waveBandToSDSResult)) == 128) {
            this.logger.log(-1601830656, "%1#execute: Unhandled wavebandSetReply %2, assuming OK!", (Object)this.getName(), (long)by);
            n = 10008;
        }
        this.logger.log(-2137614336, "%1#execute: result=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }

    static {
        waveBandToTunerWaveBand = new byte[][]{{0, 1}, {1, 4}, {2, 5}, {3, 7}, {4, 9}, {5, 11}, {6, 10}, {7, 14}};
        waveBandToSDSResult = new int[][]{{0, 10005}, {1, 10008}, {2, 10007}};
    }
}

