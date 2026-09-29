/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener$UpdateDecoratorTask;
import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import de.audi.remotehmi.util.LogAppender;
import de.esolutions.fw.util.commons.Buffer;

class HMIViewGridListener$UpdateDecoratorTask$1
implements LogAppender {
    private final /* synthetic */ HMIViewGridListener$UpdateDecoratorTask this$1;

    HMIViewGridListener$UpdateDecoratorTask$1(HMIViewGridListener$UpdateDecoratorTask hMIViewGridListener$UpdateDecoratorTask) {
        this.this$1 = hMIViewGridListener$UpdateDecoratorTask;
    }

    @Override
    public void appendTo(Buffer buffer) {
        GeoPosition geoPosition;
        String string;
        if (HMIViewGridListener$UpdateDecoratorTask.access$000(this.this$1) == null) {
            buffer.append("null");
            return;
        }
        String string2 = HMIViewGridListener$UpdateDecoratorTask.access$000(this.this$1).getId();
        if (string2 != null) {
            buffer.append("gridId=");
            buffer.append(string2);
        }
        if ((string = HMIViewGridListener$UpdateDecoratorTask.access$000(this.this$1).getDecoratorImageUrl()) != null) {
            if (buffer.length() > 0) {
                buffer.append(";");
            }
            buffer.append("image=");
            buffer.append(string);
        }
        if ((geoPosition = HMIViewGridListener$UpdateDecoratorTask.access$000(this.this$1).getMapDecoratorGeoPosition()) != null) {
            if (buffer.length() > 0) {
                buffer.append(";");
            }
            buffer.append("coords=");
            buffer.append(geoPosition);
        }
    }

    @Override
    public int getEstimatedLength() {
        return 256;
    }
}

