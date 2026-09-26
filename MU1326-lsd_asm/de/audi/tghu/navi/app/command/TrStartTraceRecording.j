.version 50 0 
.class public super [84] 
.super [86] 
.field private final [87] [88] 

.method public [90] : [91] 
    .attribute [89] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [92] : [93] 
    .attribute [89] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [10] 
L12:    i2l 
L13:    invokevirtual [12] 
L16:    pop 
L17:    aload_0 
L18:    invokevirtual [13] 
L21:    aload_0 
L22:    getfield [10] 
L25:    invokeinterface [18] 0 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [94] : [95] 
    .attribute [89] .code stack 9 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     iload_1 
L9:     i2l 
L10:    lload_2 
L11:    iload 4 
L13:    i2l 
L14:    invokevirtual [14] 
L17:    pop 
L18:    iload_1 
L19:    ifeq L34 
L22:    aload_0 
L23:    invokevirtual [15] 
L26:    iload 4 
L28:    i2l 
L29:    invokeinterface [19] 0 
L34:    aload_0 
L35:    invokevirtual [15] 
L38:    invokeinterface [20] 0 
L43:    return 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [21] 
.const [4] = String [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Field [28] [29] 
.const [11] = Field [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = InterfaceMethod [44] [45] 
.const [19] = InterfaceMethod [46] [47] 
.const [20] = InterfaceMethod [48] [49] 
.const [21] = Utf8 'TrStartTraceRecording#execute( recordingMode: %1 )' 
.const [22] = Utf8 'TrStartTraceRecording#trStartTraceRecordingResult( %1, %2, %3 )' 
.const [23] = Utf8 de/audi/tghu/navi/app/command/TrStartTraceRecording 
.const [24] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [25] = Utf8 de/audi/atip/log/LogChannel 
.const [26] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [27] = Utf8 de/audi/tghu/command/ICommandList 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Class [56] 
.const [33] = NameAndType [57] [58] 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Utf8 de/audi/tghu/navi/app/command/TrStartTraceRecording 
.const [51] = Utf8 recordingMode 
.const [52] = Utf8 I 
.const [53] = Utf8 de/audi/tghu/navi/app/command/TrStartTraceRecording 
.const [54] = Utf8 logger 
.const [55] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 log 
.const [58] = Utf8 (ILjava/lang/String;J)Z 
.const [59] = Utf8 de/audi/tghu/navi/app/command/TrStartTraceRecording 
.const [60] = Utf8 getDSINavigation 
.const [61] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [62] = Utf8 de/audi/atip/log/LogChannel 
.const [63] = Utf8 log 
.const [64] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [65] = Utf8 de/audi/tghu/navi/app/command/TrStartTraceRecording 
.const [66] = Utf8 getCommandList 
.const [67] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [68] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 de/audi/tghu/navi/app/command/TrStartTraceRecording 
.const [72] = Utf8 recordingMode 
.const [73] = Utf8 I 
.const [74] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [75] = Utf8 trStartTraceRecording 
.const [76] = Utf8 (I)V 
.const [77] = Utf8 de/audi/tghu/command/ICommandList 
.const [78] = Utf8 commandAborted 
.const [79] = Utf8 (J)V 
.const [80] = Utf8 de/audi/tghu/command/ICommandList 
.const [81] = Utf8 commandFinished 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/audi/tghu/navi/app/command/TrStartTraceRecording 
.const [84] = Class [83] 
.const [85] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [86] = Class [85] 
.const [87] = Utf8 recordingMode 
.const [88] = Utf8 I 
.const [89] = Utf8 Code 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (I)V 
.const [92] = Utf8 execute 
.const [93] = Utf8 ()V 
.const [94] = Utf8 trStartTraceRecordingResult 
.const [95] = Utf8 (IJI)V 
.end class 
