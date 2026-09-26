/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CommandLineExecuter {
    public static void executeCommand(String string) {
        CommandLineExecuter.executeCommand(string, null, new PrintStream[]{System.out});
    }

    public static void executeCommmand(String string, PrintStream printStream) {
        CommandLineExecuter.executeCommand(string, null, new PrintStream[]{printStream});
    }

    public static void executeCommand(String string, PrintStream[] printStreamArray) {
        CommandLineExecuter.executeCommand(string, null, printStreamArray);
    }

    public static void executeCommand(String string, String[] stringArray) {
        CommandLineExecuter.executeCommand(string, stringArray, new PrintStream[]{System.out});
    }

    public static void executeCommand(String string, String[] stringArray, PrintStream printStream) {
        CommandLineExecuter.executeCommand(string, stringArray, new PrintStream[]{printStream});
    }

    public static void executeCommand(String string, String[] stringArray, PrintStream[] printStreamArray) {
        String[] stringArray2 = null;
        if (string != null && stringArray != null) {
            stringArray2 = new String[stringArray.length + 1];
            stringArray2[0] = string;
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                stringArray2[i2 + 1] = stringArray[i2];
            }
        } else if (string != null) {
            stringArray2 = new String[]{string};
        }
        if (stringArray2 != null) {
            try {
                Process process = Runtime.getRuntime().exec(stringArray2);
                CommandLineExecuter.writeToOutputStream(process, printStreamArray);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private static void writeToOutputStream(Process process, PrintStream[] printStreamArray) {
        if (process != null && printStreamArray != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String string = null;
            try {
                while ((string = bufferedReader.readLine()) != null) {
                    for (int i2 = 0; i2 < printStreamArray.length; ++i2) {
                        PrintStream printStream = printStreamArray[i2] != null ? printStreamArray[i2] : System.out;
                        printStream.println(string);
                    }
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

