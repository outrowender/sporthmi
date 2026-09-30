/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.audio;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.audio.DSISoundReply;
import de.esolutions.fw.comm.dsi.audio.impl.DSISoundProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.audio.DSISound;
import org.osgi.framework.BundleContext;

public class DSISoundProvider
extends AbstractProvider
implements DSISound {
    private static final int[] attributeIDs = new int[]{2, 3, 4, 5, 9, 10, 12, 13, 14, 17, 18, 19, 20, 21, 22, 24, 26, 27, 28, 31, 32, 33, 34, 35, 36, 37, 38, 39, 42, 43, 44, 45, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56};
    private DSISoundProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;

    public DSISoundProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = DSISoundProvider.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSISoundProxy(this.instance, (DSISoundReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void getVolume(int n, int n2) {
        try {
            this.proxy.getVolume(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setVolume(int n, int n2, short s) {
        try {
            this.proxy.setVolume(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseVolume(int n, int n2, short s) {
        try {
            this.proxy.decreaseVolume(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseVolume(int n, int n2, short s) {
        try {
            this.proxy.increaseVolume(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getBalance(int n, int n2) {
        try {
            this.proxy.getBalance(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setBalance(int n, int n2, short s) {
        try {
            this.proxy.setBalance(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseBalance(int n, int n2, short s) {
        try {
            this.proxy.decreaseBalance(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseBalance(int n, int n2, short s) {
        try {
            this.proxy.increaseBalance(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getBass(int n, int n2) {
        try {
            this.proxy.getBass(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setBass(int n, int n2, short s) {
        try {
            this.proxy.setBass(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseBass(int n, int n2, short s) {
        try {
            this.proxy.decreaseBass(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseBass(int n, int n2, short s) {
        try {
            this.proxy.increaseBass(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getTreble(int n, int n2) {
        try {
            this.proxy.getTreble(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setTreble(int n, int n2, short s) {
        try {
            this.proxy.setTreble(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseTreble(int n, int n2, short s) {
        try {
            this.proxy.decreaseTreble(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseTreble(int n, int n2, short s) {
        try {
            this.proxy.increaseTreble(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getFader(int n, int n2) {
        try {
            this.proxy.getFader(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setFader(int n, int n2, short s) {
        try {
            this.proxy.setFader(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseFader(int n, int n2, short s) {
        try {
            this.proxy.decreaseFader(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseFader(int n, int n2, short s) {
        try {
            this.proxy.increaseFader(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getSubwoofer(int n, int n2) {
        try {
            this.proxy.getSubwoofer(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setSubwoofer(int n, int n2, short s) {
        try {
            this.proxy.setSubwoofer(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getInputGainOffset(int n, int n2) {
        try {
            this.proxy.getInputGainOffset(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setInputGainOffset(int n, int n2, short s) {
        try {
            this.proxy.setInputGainOffset(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getInputGainOffsetRange(int n, int n2) {
        try {
            this.proxy.getInputGainOffsetRange(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getLoweringEntertainment(int n, int n2, int n3) {
        try {
            this.proxy.getLoweringEntertainment(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setLoweringEntertainment(int n, int n2, int n3, short s) {
        try {
            this.proxy.setLoweringEntertainment(n, n2, n3, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getMenuVolEntRange(int n) {
        try {
            this.proxy.getMenuVolEntRange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getMenuVolumeRange(int n, int n2) {
        try {
            this.proxy.getMenuVolumeRange(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getVolumeRange(int n, int n2) {
        try {
            this.proxy.getVolumeRange(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getSurroundLevel(int n, int n2) {
        try {
            this.proxy.getSurroundLevel(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setSurroundLevel(int n, int n2, short s) {
        try {
            this.proxy.setSurroundLevel(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setSurroundOnOff(int n, int n2, boolean bl) {
        try {
            this.proxy.setSurroundOnOff(n, n2, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void revertToFactorySettings(int n, int n2) {
        try {
            this.proxy.revertToFactorySettings(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void createExportFile(String string, int n) {
        try {
            this.proxy.createExportFile(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void importFile(String string, int n) {
        try {
            this.proxy.importFile(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getMiddle(int n, int n2) {
        try {
            this.proxy.getMiddle(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setMiddle(int n, int n2, short s) {
        try {
            this.proxy.setMiddle(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseMiddle(int n, int n2, short s) {
        try {
            this.proxy.decreaseMiddle(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseMiddle(int n, int n2, short s) {
        try {
            this.proxy.increaseMiddle(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setEqualizer(int n, int n2, int n3, int n4) {
        try {
            this.proxy.setEqualizer(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseEqualizer(int n, int n2, int n3, short s) {
        try {
            this.proxy.increaseEqualizer(n, n2, n3, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseEqualizer(int n, int n2, int n3, short s) {
        try {
            this.proxy.decreaseEqualizer(n, n2, n3, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getEqualizer(int n, int n2) {
        try {
            this.proxy.getEqualizer(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setOnVolumeLimit(int n) {
        try {
            this.proxy.setOnVolumeLimit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseOnVolumeLimit(short s) {
        try {
            this.proxy.increaseOnVolumeLimit(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseOnVolumeLimit(short s) {
        try {
            this.proxy.decreaseOnVolumeLimit(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseSubwoofer(int n, int n2, short s) {
        try {
            this.proxy.decreaseSubwoofer(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseSubwoofer(int n, int n2, short s) {
        try {
            this.proxy.increaseSubwoofer(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseInputGainOffset(int n, int n2, short s) {
        try {
            this.proxy.decreaseInputGainOffset(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseInputGainOffset(int n, int n2, short s) {
        try {
            this.proxy.increaseInputGainOffset(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseLoweringEntertainment(int n, int n2, int n3, short s) {
        try {
            this.proxy.decreaseLoweringEntertainment(n, n2, n3, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseLoweringEntertainment(int n, int n2, int n3, short s) {
        try {
            this.proxy.increaseLoweringEntertainment(n, n2, n3, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseSurroundLevel(int n, int n2, short s) {
        try {
            this.proxy.decreaseSurroundLevel(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseSurroundLevel(int n, int n2, short s) {
        try {
            this.proxy.increaseSurroundLevel(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setMicGainLevel(int n) {
        try {
            this.proxy.setMicGainLevel(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseMicGainLevel(short s) {
        try {
            this.proxy.decreaseMicGainLevel(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseMicGainLevel(short s) {
        try {
            this.proxy.increaseMicGainLevel(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getNoiseCompensation(int n, int n2) {
        try {
            this.proxy.getNoiseCompensation(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNoiseCompensation(int n, int n2, short s) {
        try {
            this.proxy.setNoiseCompensation(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void increaseNoiseCompensation(int n, int n2, short s) {
        try {
            this.proxy.increaseNoiseCompensation(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void decreaseNoiseCompensation(int n, int n2, short s) {
        try {
            this.proxy.decreaseNoiseCompensation(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getPresetEQ(int n, int n2) {
        try {
            this.proxy.getPresetEQ(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setPresetEQ(int n, int n2, int n3) {
        try {
            this.proxy.setPresetEQ(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getPresetPosition(int n, int n2) {
        try {
            this.proxy.getPresetPosition(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setPresetPosition(int n, int n2, int n3) {
        try {
            this.proxy.setPresetPosition(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void get3DMode(int n, int n2) {
        try {
            this.proxy.get3DMode(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void set3DMode(int n, int n2, int n3) {
        try {
            this.proxy.set3DMode(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setSubwooferActivity(int n, int n2, boolean bl) {
        try {
            this.proxy.setSubwooferActivity(n, n2, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setWidebandSpeech(int n, boolean bl) {
        try {
            this.proxy.setWidebandSpeech(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setDuration(int n, int n2) {
        try {
            this.proxy.setDuration(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getSoundShapeActive() {
        try {
            this.proxy.getSoundShapeActive();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setSoundShapeActive(boolean bl) {
        try {
            this.proxy.setSoundShapeActive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getSoundShape() {
        try {
            this.proxy.getSoundShape();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setSoundShape(short s, short s2, short s3) {
        try {
            this.proxy.setSoundShape(s, s2, s3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void profileChange(int n) {
        try {
            this.proxy.profileChange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void profileCopy(int n, int n2) {
        try {
            this.proxy.profileCopy(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void profileReset(int n) {
        try {
            this.proxy.profileReset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void profileResetAll() {
        try {
            this.proxy.profileResetAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

