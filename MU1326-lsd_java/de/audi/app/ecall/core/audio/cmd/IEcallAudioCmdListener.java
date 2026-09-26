/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.atip.audio.HMIAudioServiceListener;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIListener;

interface IEcallAudioCmdListener
extends HMIAudioServiceListener,
DSIListener,
DSISoundListener {
}

