/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark.mmi3g;

import de.dreisoft.lsd.LSD;
import de.dreisoft.lsd.benchmark.mmi3g.BasicBenchmarkSuite;
import de.dreisoft.lsd.benchmark.mmi3g.MMI3gBenchmarkSuite;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Starter {
    private static BasicBenchmarkSuite basicSuite = BasicBenchmarkSuite.getInstance();

    public static void main(String[] stringArray) {
        System.out.println();
        System.out.println();
        System.out.println("+++ Start LSD Benchmark Suite +++");
        System.out.println();
        System.out.println();
        basicSuite.setStartTag(1);
        LSD.main(stringArray);
        try {
            if (MMI3gBenchmarkSuite.TARGET == 2) {
                Thread.sleep(60000L);
            } else {
                Thread.sleep(30000L);
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        MMI3gBenchmarkSuite.runAllTests();
        MMI3gBenchmarkSuite.analyzeAll();
        if (MMI3gBenchmarkSuite.getTarget() == 2) {
            File file = new File("/mnt/hdisk/lsd_benchmark.txt");
            try {
                PrintStream printStream = new PrintStream(new FileOutputStream(file));
                MMI3gBenchmarkSuite.printAllResults(printStream);
                printStream.close();
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        } else {
            File file = new File("C:/Dokumente und Einstellungen/thwe2283/Desktop/lsd_benchmark.txt");
            try {
                PrintStream printStream = new PrintStream(new FileOutputStream(file));
                MMI3gBenchmarkSuite.printAllResults(printStream);
                printStream.close();
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            MMI3gBenchmarkSuite.printAllResults(System.out);
        }
        System.out.println();
        System.out.println();
        System.out.println("+++ LSD Benchmark Suite completed +++");
        System.out.println();
        System.out.println();
    }
}

