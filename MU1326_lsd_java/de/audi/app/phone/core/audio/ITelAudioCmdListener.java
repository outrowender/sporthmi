/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.tghu.waveplayer.WavePlayerListener;
import org.dsi.ifc.audio.DSISoundListener;

public interface ITelAudioCmdListener
extends HMIAudioServiceListener,
WavePlayerListener,
DSISoundListener {
}

