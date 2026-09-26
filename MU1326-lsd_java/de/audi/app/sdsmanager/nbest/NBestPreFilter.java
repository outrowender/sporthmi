/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;

public class NBestPreFilter {
    public static NBestList filterLowConfidenceEntries(NBestList nBestList, SDSAdapter sDSAdapter, LogChannel logChannel) {
        nBestList.entries = NBestPreFilter.filterEntries(nBestList.entries, sDSAdapter.getTopEntryThreshold(), sDSAdapter.getFollowupEntryThreshold(), logChannel);
        nBestList.graphemicGroups = NBestPreFilter.correctGraphemicGroups(nBestList, logChannel);
        return nBestList;
    }

    private static NBestListEntry[] filterEntries(NBestListEntry[] nBestListEntryArray, float f2, float f3, LogChannel logChannel) {
        int n;
        if (nBestListEntryArray == null || (n = nBestListEntryArray.length) == 0) {
            logChannel.log(-1601830656, "NBestPreFilter#filterEntries: no entry. nothing to do here");
            return nBestListEntryArray;
        }
        if (nBestListEntryArray[0] == null) {
            logChannel.log(-1601830656, "NBestPreFilter#filterEntries: top entry was null");
            return nBestListEntryArray;
        }
        float f4 = nBestListEntryArray[0].confidence;
        ArrayList arrayList = new ArrayList(n);
        arrayList.add(nBestListEntryArray[0]);
        for (int i2 = 1; i2 < n; ++i2) {
            if (nBestListEntryArray[i2] != null) {
                float f5 = nBestListEntryArray[i2].confidence;
                float f6 = nBestListEntryArray[i2 - 1].confidence;
                if ((f4 - f5) / f4 > f2) {
                    logChannel.log(-2137614336, "NBestPreFilter#filterEntries: entry %1 is filtered out. Confidence is ABOVE the top entry threshold!", (Object)nBestListEntryArray[i2]);
                    break;
                }
                if ((f6 - f5) / f6 > f3) {
                    logChannel.log(-2137614336, "NBestPreFilter#filterEntries: entry %1 is filtered out. Confidence is ABOVE the followup entry threshold!", (Object)nBestListEntryArray[i2]);
                    break;
                }
                arrayList.add(nBestListEntryArray[i2]);
                continue;
            }
            logChannel.log(-1601830656, "NBestPreFilter#filterEntries: entry %1 is null!", (long)i2);
        }
        return (NBestListEntry[])arrayList.toArray(new NBestListEntry[arrayList.size()]);
    }

    private static GraphemicGroup[] correctGraphemicGroups(NBestList nBestList, LogChannel logChannel) {
        GraphemicGroup[] graphemicGroupArray = nBestList.graphemicGroups;
        NBestListEntry[] nBestListEntryArray = nBestList.entries;
        if (graphemicGroupArray == null || nBestListEntryArray == null) {
            return graphemicGroupArray;
        }
        int n = graphemicGroupArray.length;
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            GraphemicGroup graphemicGroup = graphemicGroupArray[i2];
            if (graphemicGroup != null) {
                int n2 = 0;
                for (int i3 = 0; i3 < nBestListEntryArray.length; ++i3) {
                    if (nBestListEntryArray[i3].getGraphemicGroupIndex() != i2) continue;
                    ++n2;
                }
                if (n2 <= 0) continue;
                graphemicGroup.graphemicGroupSize = n2;
                arrayList.add(graphemicGroup);
                continue;
            }
            logChannel.log(-1601830656, "NBestPreFilter#correctGraphemicGroups: GG with index=%1 was null", (long)i2);
        }
        return (GraphemicGroup[])arrayList.toArray(new GraphemicGroup[arrayList.size()]);
    }
}

