/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.audio.TerminalMapper;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSISound;
import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundS;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.audio.DSISound;

public class ASIHMISyncSoundImpl
extends ASIHMISyncSoundAbstractBaseService
implements ASIHMISyncSoundS,
IASIProvider {
    private final ASIHMISyncSoundService asiSoundService;
    private DSISound dsi;
    private final LogChannel lc;
    private int activeEntertainmentConnection;

    public ASIHMISyncSoundImpl(int n, LogChannel logChannel) {
        this.lc = logChannel;
        this.asiSoundService = new ASIHMISyncSoundService(n, this);
        this.activeEntertainmentConnection = 0;
        this.dsi = new NullDSISound(logChannel);
    }

    public void init() {
        try {
            this.updateASIVersion("1.2.00");
            this.updateSoundState(1);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[ASIHMISyncSoundImpl.init] error on updating sound state:%1", 1L);
        }
    }

    public void registerDSISound(DSISound dSISound) {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.registerDSI] %1", (Object)dSISound);
        this.dsi = dSISound;
    }

    public void deregisterDSISound() {
        this.lc.log(1000000, "[ASIHMISyncSoundImpl.deregisterDSISound]");
        this.dsi = new NullDSISound(this.lc);
    }

    public void setBassValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setBassValue] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setBass(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), (short)n);
    }

    public void setTrebleValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setTrebleValue] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setTreble(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), (short)n);
    }

    public void setBalanceValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setBalanceValue] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setBalance(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), (short)n);
    }

    public void setFaderValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setFaderValue] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setFader(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), (short)n);
    }

    public void setSubwooferValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setSubwooferValue] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setSubwoofer(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), (short)n);
    }

    public void setSurroundValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setSurroundValue] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setSurroundLevel(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), (short)n);
    }

    public void setNoiseCompensationValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setNoiseCompensationValue] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setNoiseCompensation(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), (short)n);
    }

    public void setPresetPosition(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setPresetPosition] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setPresetPosition(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), n);
    }

    public void updateActiveConnection(int n, int n2) {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.updateActiveConnection] AC:%1", (long)n);
    }

    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.updateActiveEntertainmentConnection] AC:%1", (long)n);
        this.activeEntertainmentConnection = n;
    }

    public IService getService() {
        return this.asiSoundService;
    }

    public void attachStub(IStub iStub) {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.attachStub] %1", (Object)iStub);
    }

    public void detachStub(IStub iStub) {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.detachStub] %1", (Object)iStub);
    }

    public void setThreeDModeValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setThreeDModeValue] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.set3DMode(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), n);
    }

    public void setPresetEQ(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setPresetEQ] value:%1 AEC:%2", (long)n, (long)this.activeEntertainmentConnection);
        this.dsi.setPresetEQ(this.activeEntertainmentConnection, TerminalMapper.toAudioTerminal(0), n);
    }

    public void setSoundShape(int n, int n2, int n3, ASIHMISyncSoundReply aSIHMISyncSoundReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncSoundImpl.setSoundShape] nothing to do");
    }
}

