.version 50 0 
.class public super [94] 
.super [96] 
.field private [97] [98] 

.method public [100] : [101] 
    .attribute [99] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [20] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [102] : [103] 
    .attribute [99] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [14] 
L4:     aload_0 
L5:     getfield [13] 
L8:     invokevirtual [15] 
L11:    invokeinterface [21] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [104] : [105] 
    .attribute [99] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     iload_2 
L10:    invokestatic [4] 
L13:    invokevirtual [17] 
L16:    aload_1 
L17:    ifnull L32 
L20:    aload_0 
L21:    invokevirtual [18] 
L24:    ldc [5] 
L26:    aload_1 
L27:    invokeinterface [22] 0 
L32:    aload_0 
L33:    invokevirtual [18] 
L36:    invokeinterface [23] 0 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [24] 
.const [4] = Method [25] [26] 
.const [5] = String [27] 
.const [6] = Class [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Class [31] 
.const [10] = Class [32] 
.const [11] = Class [33] 
.const [12] = Class [34] 
.const [13] = Field [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Field [49] [50] 
.const [21] = InterfaceMethod [51] [52] 
.const [22] = InterfaceMethod [53] [54] 
.const [23] = InterfaceMethod [55] [56] 
.const [24] = Utf8 'GetLastStateHistoryEntryCommand#liGetLastStateHistoryEntryResult(%1, %2)' 
.const [25] = Class [57] 
.const [26] = NameAndType [58] [59] 
.const [27] = Utf8 'NavLocation from History' 
.const [28] = Utf8 de/audi/tghu/navi/app/addressinput/commands/GetLastStateHistoryEntryCommand 
.const [29] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [30] = Utf8 org/dsi/ifc/navigation/LIStateHistoryEntry 
.const [31] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [32] = Utf8 java/lang/Boolean 
.const [33] = Utf8 de/audi/atip/log/LogChannel 
.const [34] = Utf8 de/audi/tghu/command/ICommandList 
.const [35] = Class [60] 
.const [36] = NameAndType [61] [62] 
.const [37] = Class [63] 
.const [38] = NameAndType [64] [65] 
.const [39] = Class [66] 
.const [40] = NameAndType [67] [68] 
.const [41] = Class [69] 
.const [42] = NameAndType [70] [71] 
.const [43] = Class [72] 
.const [44] = NameAndType [73] [74] 
.const [45] = Class [75] 
.const [46] = NameAndType [76] [77] 
.const [47] = Class [78] 
.const [48] = NameAndType [79] [80] 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Class [84] 
.const [52] = NameAndType [85] [86] 
.const [53] = Class [87] 
.const [54] = NameAndType [88] [89] 
.const [55] = Class [90] 
.const [56] = NameAndType [91] [92] 
.const [57] = Utf8 java/lang/Boolean 
.const [58] = Utf8 toString 
.const [59] = Utf8 (Z)Ljava/lang/String; 
.const [60] = Utf8 de/audi/tghu/navi/app/addressinput/commands/GetLastStateHistoryEntryCommand 
.const [61] = Utf8 lastState 
.const [62] = Utf8 Lorg/dsi/ifc/navigation/LIStateHistoryEntry; 
.const [63] = Utf8 de/audi/tghu/navi/app/addressinput/commands/GetLastStateHistoryEntryCommand 
.const [64] = Utf8 getDSINavigation 
.const [65] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [66] = Utf8 org/dsi/ifc/navigation/LIStateHistoryEntry 
.const [67] = Utf8 getId 
.const [68] = Utf8 ()J 
.const [69] = Utf8 de/audi/tghu/navi/app/addressinput/commands/GetLastStateHistoryEntryCommand 
.const [70] = Utf8 logger 
.const [71] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [72] = Utf8 de/audi/atip/log/LogChannel 
.const [73] = Utf8 log 
.const [74] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [75] = Utf8 de/audi/tghu/navi/app/addressinput/commands/GetLastStateHistoryEntryCommand 
.const [76] = Utf8 getCommandList 
.const [77] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [78] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 de/audi/tghu/navi/app/addressinput/commands/GetLastStateHistoryEntryCommand 
.const [82] = Utf8 lastState 
.const [83] = Utf8 Lorg/dsi/ifc/navigation/LIStateHistoryEntry; 
.const [84] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [85] = Utf8 liGetLastStateHistoryEntry 
.const [86] = Utf8 (J)V 
.const [87] = Utf8 de/audi/tghu/command/ICommandList 
.const [88] = Utf8 put 
.const [89] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)V 
.const [90] = Utf8 de/audi/tghu/command/ICommandList 
.const [91] = Utf8 commandFinished 
.const [92] = Utf8 ()V 
.const [93] = Utf8 de/audi/tghu/navi/app/addressinput/commands/GetLastStateHistoryEntryCommand 
.const [94] = Class [93] 
.const [95] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [96] = Class [95] 
.const [97] = Utf8 lastState 
.const [98] = Utf8 Lorg/dsi/ifc/navigation/LIStateHistoryEntry; 
.const [99] = Utf8 Code 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (Lorg/dsi/ifc/navigation/LIStateHistoryEntry;)V 
.const [102] = Utf8 execute 
.const [103] = Utf8 ()V 
.const [104] = Utf8 liGetLastStateHistoryEntryResult 
.const [105] = Utf8 (Lorg/dsi/ifc/global/NavLocation;Z)V 
.end class 
