/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.irc.InfotainmentRecorder;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent$1;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent$AbstractDiagnosisPlugin;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.List;

class DiagnosisComponent$InfotainmentRecorderPlugin
extends DiagnosisComponent$AbstractDiagnosisPlugin {
    private final /* synthetic */ DiagnosisComponent this$0;

    private DiagnosisComponent$InfotainmentRecorderPlugin(DiagnosisComponent diagnosisComponent) {
        this.this$0 = diagnosisComponent;
        super(diagnosisComponent, null);
    }

    @Override
    public void update(Object object, int n) {
        String string;
        switch (n) {
            case 0: {
                Buffer buffer = new Buffer();
                buffer.append("r:");
                buffer.append((String)object);
                string = buffer.toString();
                break;
            }
            case 1: {
                Buffer buffer = new Buffer();
                buffer.append("rs:");
                buffer.append((String)object);
                string = buffer.toString();
                break;
            }
            case 2: {
                Buffer buffer = new Buffer("Last sent OM Apps: ");
                DiagnosisComponent.access$100(this.this$0, (List)object, buffer, 2);
                string = buffer.toString();
                break;
            }
            case 3: {
                List list = Arrays.asList((String[])object);
                Buffer buffer = new Buffer("Connected Devices: ");
                DiagnosisComponent.access$100(this.this$0, list, buffer, 3);
                string = buffer.toString();
                break;
            }
            case 4: {
                string = (String)object;
                break;
            }
            case 5: {
                string = (String)object;
                break;
            }
            case 6: {
                string = (String)object;
                break;
            }
            case 7: {
                string = (String)object;
                break;
            }
            case 8: {
                string = (String)object;
                break;
            }
            case 9: {
                string = (String)object;
                break;
            }
            case 10: {
                string = (String)object;
                break;
            }
            case 11: {
                string = (String)object;
                break;
            }
            case 12: {
                string = (String)object;
                break;
            }
            case 13: {
                string = (String)object;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("TestSupportPlugin#update: update mode not defined: ").append(n).toString());
            }
        }
        this.logToIRC(string);
    }

    private void logToIRC(String string) {
        InfotainmentRecorder infotainmentRecorder = this.this$0.remoteHmiService.getFrameworkAccess().getInfotainmentrecorder();
        if (infotainmentRecorder == null) {
            this.this$0.logChannel.log(-1601830656, "InfotainmentRecorderComponent#logToIRC: infotainment recorder not available");
            return;
        }
        if (string == null) {
            return;
        }
        if (string.length() > 30) {
            string = string.substring(0, 30);
        }
        infotainmentRecorder.logRemoteHMI(string);
    }

    /* synthetic */ DiagnosisComponent$InfotainmentRecorderPlugin(DiagnosisComponent diagnosisComponent, DiagnosisComponent$1 diagnosisComponent$1) {
        this(diagnosisComponent);
    }
}

