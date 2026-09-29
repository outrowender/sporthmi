.version 50 0 
.class public super [64] 
.super [66] 

.method public annotation [68] : [69] 
    .attribute [67] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [70] : [71] 
    .attribute [67] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [9] 
L4:     invokeinterface [14] 0 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [72] : [73] 
    .attribute [67] .code stack 9 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     i2l 
L10:    lload_2 
L11:    iload 4 
L13:    i2l 
L14:    invokevirtual [11] 
L17:    pop 
L18:    iload_1 
L19:    ifeq L34 
L22:    aload_0 
L23:    invokevirtual [12] 
L26:    iload 4 
L28:    i2l 
L29:    invokeinterface [15] 0 
L34:    aload_0 
L35:    invokevirtual [12] 
L38:    invokeinterface [16] 0 
L43:    return 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Class [21] 
.const [8] = Class [22] 
.const [9] = Method [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Method [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = InterfaceMethod [33] [34] 
.const [15] = InterfaceMethod [35] [36] 
.const [16] = InterfaceMethod [37] [38] 
.const [17] = Utf8 'TrStopTraceRecording#trStopTraceRecordingResultCode( trStopTraceRecordingResultCode: %1, timestamp: %2, errorCode: %3 )' 
.const [18] = Utf8 de/audi/tghu/navi/app/command/TrStopTraceRecording 
.const [19] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [20] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [21] = Utf8 de/audi/atip/log/LogChannel 
.const [22] = Utf8 de/audi/tghu/command/ICommandList 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Class [57] 
.const [36] = NameAndType [58] [59] 
.const [37] = Class [60] 
.const [38] = NameAndType [61] [62] 
.const [39] = Utf8 de/audi/tghu/navi/app/command/TrStopTraceRecording 
.const [40] = Utf8 getDSINavigation 
.const [41] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [42] = Utf8 de/audi/tghu/navi/app/command/TrStopTraceRecording 
.const [43] = Utf8 logger 
.const [44] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 log 
.const [47] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [48] = Utf8 de/audi/tghu/navi/app/command/TrStopTraceRecording 
.const [49] = Utf8 getCommandList 
.const [50] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [51] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [52] = Utf8 <init> 
.const [53] = Utf8 ()V 
.const [54] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [55] = Utf8 trStopTraceRecording 
.const [56] = Utf8 ()V 
.const [57] = Utf8 de/audi/tghu/command/ICommandList 
.const [58] = Utf8 commandAborted 
.const [59] = Utf8 (J)V 
.const [60] = Utf8 de/audi/tghu/command/ICommandList 
.const [61] = Utf8 commandFinished 
.const [62] = Utf8 ()V 
.const [63] = Utf8 de/audi/tghu/navi/app/command/TrStopTraceRecording 
.const [64] = Class [63] 
.const [65] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [66] = Class [65] 
.const [67] = Utf8 Code 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 execute 
.const [71] = Utf8 ()V 
.const [72] = Utf8 trStopTraceRecordingResult 
.const [73] = Utf8 (IJI)V 
.end class 
