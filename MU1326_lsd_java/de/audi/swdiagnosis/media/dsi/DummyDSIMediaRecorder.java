/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaRecorder;

public class DummyDSIMediaRecorder
implements DSIMediaRecorder {
    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    @Override
    public void setActiveMedia(long l, long l2) {
    }

    @Override
    public void setSelection(int n) {
    }

    @Override
    public void startImport(boolean bl) {
    }

    @Override
    public void abortImport() {
    }

    @Override
    public void startDelete() {
    }

    @Override
    public void abortDelete() {
    }

    @Override
    public void setTargetMedia(long l, long l2) {
    }

    @Override
    public void setEncodingQuality(int n) {
    }
}

