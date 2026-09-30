/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.config;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.transport.config.ResManTransportParam;
import de.esolutions.fw.util.transport.config.TCPTransportParam;
import de.esolutions.fw.util.transport.config.TransportConfig;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TransportConfigGraph {
    private TransportConfig config;
    private SystemConfig sysConfig;

    private TransportConfigGraph(TransportConfig transportConfig) {
        this.config = transportConfig;
        this.sysConfig = transportConfig.getSystemConfig();
    }

    private String getLabel(IConfigQuery iConfigQuery) {
        TCPTransportParam tCPTransportParam = TCPTransportParam.create(iConfigQuery);
        ResManTransportParam resManTransportParam = ResManTransportParam.create(iConfigQuery);
        String string = "INVALID";
        if (tCPTransportParam != null) {
            string = tCPTransportParam.toString();
        } else if (resManTransportParam != null) {
            string = resManTransportParam.toString();
        }
        return string;
    }

    private void graph(PrintStream printStream, String string) {
        String string2;
        String[] stringArray;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        if (this.sysConfig.getNodeConfigByName(string) == null) {
            System.out.println("ERROR: Unknown node: " + string);
            return;
        }
        String string3 = "Transport Map for process " + this.sysConfig.getMyProcName() + " to node " + string;
        printStream.println("digraph \"" + string3 + "\" {");
        printStream.println("  ratio=fill; graph [ rankdir = \"LR\" ]; compount=true; size=\"16.4,11.4\";");
        printStream.println("  label=\"" + string3 + "\";");
        printStream.println("  node [shape=box];");
        printStream.println("  mynode [label=\"Proc: " + this.sysConfig.getMyProcName() + "(" + this.sysConfig.getMyProcId() + ")@" + this.sysConfig.getMyNodeName() + "\"];");
        String[] stringArray2 = this.config.getMyServiceNames();
        for (int i2 = 0; i2 < stringArray2.length; ++i2) {
            object5 = stringArray2[i2];
            object4 = "in_service_" + (String)object5;
            printStream.println("  \"" + (String)object4 + "\" [label=\"In: " + (String)object5 + "\",shape=diamond];");
            printStream.println("  \"" + (String)object4 + "\" -> mynode;");
            String[] stringArray3 = this.config.getMyReachableNodes((String)object5);
            if (stringArray3 == null) continue;
            for (int i3 = 0; i3 < stringArray3.length; ++i3) {
                object3 = stringArray3[i3];
                if (!string.equals(object3)) continue;
                object2 = "in_" + (String)object3;
                object = this.config.getQueryForMyService((String)object5, (String)object3);
                if (object == null) continue;
                printStream.println("  \"" + (String)object2 + "\" [label=\"@" + (String)object3 + "\"];");
                printStream.println("  \"" + (String)object2 + "\" -> \"" + (String)object4 + "\" [label=\"" + this.getLabel((IConfigQuery)object) + "\"];");
            }
        }
        String[] stringArray4 = this.config.getAllServiceNames();
        object5 = new HashSet();
        object4 = new HashMap();
        for (int i4 = 0; i4 < stringArray4.length; ++i4) {
            String string4 = stringArray4[i4];
            object3 = this.sysConfig.getProcNamesForNodeName(string);
            if (object3 != null) {
                for (int i5 = 0; i5 < ((String[])object3).length; ++i5) {
                    object = object3[i5];
                    stringArray = this.config.getQueryForService(string4, (String)object);
                    if (stringArray == null) continue;
                    object5.add(object);
                    string2 = string4 + ":" + (String)object;
                    object4.put(string2, stringArray);
                }
            }
            object2 = "out_service_" + string4;
            printStream.println("  \"" + (String)object2 + "\" [label=\"Out: " + string4 + "\",shape=diamond];");
            printStream.println("  mynode -> \"" + (String)object2 + "\";");
        }
        printStream.println("  subgraph \"cluster_" + string + "\" {");
        printStream.println("    label=\"Node: " + string + "\";");
        Iterator iterator = object5.iterator();
        while (iterator.hasNext()) {
            String string5 = (String)iterator.next();
            object3 = string5 + "(" + this.sysConfig.mapIdProc(string5) + ")";
            printStream.println("    \"" + string5 + "\" [label=\"" + (String)object3 + "\"];");
        }
        printStream.println("  }");
        Set set = object4.entrySet();
        object3 = set.iterator();
        while (object3.hasNext()) {
            object2 = (Map.Entry)object3.next();
            object = (String)object2.getKey();
            stringArray = StringUtils.splitString((String)object, ':');
            string2 = stringArray[0];
            String string6 = stringArray[1];
            IConfigQuery iConfigQuery = (IConfigQuery)object2.getValue();
            String string7 = this.getLabel(iConfigQuery);
            printStream.println("  \"out_service_" + string2 + "\" -> \"" + string6 + "\" [label=\"" + string7 + "\"];");
        }
        printStream.println("}");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean saveDot(String string, String string2) {
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            System.out.println("Writing " + string2);
            fileOutputStream = new FileOutputStream(string2);
            printStream = new PrintStream(fileOutputStream, true, "UTF-8");
            this.graph(printStream, string);
            boolean bl = true;
            return bl;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            boolean bl = false;
            return bl;
        }
        finally {
            if (printStream != null) {
                printStream.close();
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    public static void main(String[] stringArray) {
        TransportConfig transportConfig = TransportConfig.getInstance();
        if (!transportConfig.isValid()) {
            System.out.println("ERROR: Transport Config is not valid: " + transportConfig.getFailString());
            return;
        }
        TransportConfigGraph transportConfigGraph = new TransportConfigGraph(transportConfig);
        if (stringArray.length != 2) {
            System.out.println("Usage: <node> <output>");
            return;
        }
        transportConfigGraph.saveDot(stringArray[0], stringArray[1]);
    }
}

