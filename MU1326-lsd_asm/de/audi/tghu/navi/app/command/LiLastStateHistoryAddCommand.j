.version 50 0 
.class public super [126] 
.super [128] 
.field private [129] [130] 
.field private [131] [132] 
.field private [133] [134] 

.method public [136] : [137] 
    .attribute [135] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [25] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [26] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [135] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [15] 
L12:    invokestatic [4] 
L15:    aload_0 
L16:    getfield [16] 
L19:    invokestatic [5] 
L22:    aload_0 
L23:    getfield [17] 
L26:    invokevirtual [19] 
L29:    aload_0 
L30:    invokevirtual [20] 
L33:    aload_0 
L34:    getfield [15] 
L37:    aload_0 
L38:    getfield [16] 
L41:    aload_0 
L42:    getfield [17] 
L45:    invokeinterface [27] 0 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [135] .code stack 3 locals 0 
L0:     iload_1 
L1:     ifne L28 
L4:     aload_0 
L5:     getfield [18] 
L8:     ldc [2] 
L10:    ldc [6] 
L12:    invokevirtual [21] 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [22] 
L20:    invokeinterface [28] 0 
L25:    goto L52 
L28:    aload_0 
L29:    getfield [18] 
L32:    sipush 10000 
L35:    ldc [7] 
L37:    invokevirtual [21] 
L40:    pop 
L41:    aload_0 
L42:    invokevirtual [22] 
L45:    iload_1 
L46:    i2l 
L47:    invokeinterface [29] 0 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [30] 
.const [4] = Method [31] [32] 
.const [5] = Method [33] [34] 
.const [6] = String [35] 
.const [7] = String [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Field [44] [45] 
.const [16] = Field [46] [47] 
.const [17] = Field [48] [49] 
.const [18] = Field [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = Field [66] [67] 
.const [27] = InterfaceMethod [68] [69] 
.const [28] = InterfaceMethod [70] [71] 
.const [29] = InterfaceMethod [72] [73] 
.const [30] = Utf8 'LiLastStateHistoryAddCommand#execute() - calling liLastStateHistoryAdd(%1, %2, %3) ' 
.const [31] = Class [74] 
.const [32] = NameAndType [75] [76] 
.const [33] = Class [77] 
.const [34] = NameAndType [78] [79] 
.const [35] = Utf8 'LiLastStateHistoryAddCommand#liHistoryResult()' 
.const [36] = Utf8 'LiLastStateHistoryAddCommand#liHistoryResult() - commandAborted' 
.const [37] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [38] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [39] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [40] = Utf8 java/lang/Boolean 
.const [41] = Utf8 de/audi/atip/log/LogChannel 
.const [42] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [43] = Utf8 de/audi/tghu/command/ICommandList 
.const [44] = Class [80] 
.const [45] = NameAndType [81] [82] 
.const [46] = Class [83] 
.const [47] = NameAndType [84] [85] 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Class [98] 
.const [57] = NameAndType [99] [100] 
.const [58] = Class [101] 
.const [59] = NameAndType [102] [103] 
.const [60] = Class [104] 
.const [61] = NameAndType [105] [106] 
.const [62] = Class [107] 
.const [63] = NameAndType [108] [109] 
.const [64] = Class [110] 
.const [65] = NameAndType [111] [112] 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Class [116] 
.const [69] = NameAndType [117] [118] 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [75] = Utf8 formatLocationShort 
.const [76] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Ljava/lang/String; 
.const [77] = Utf8 java/lang/Boolean 
.const [78] = Utf8 toString 
.const [79] = Utf8 (Z)Ljava/lang/String; 
.const [80] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [81] = Utf8 location 
.const [82] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [83] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [84] = Utf8 hasCitys 
.const [85] = Utf8 Z 
.const [86] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [87] = Utf8 name 
.const [88] = Utf8 Ljava/lang/String; 
.const [89] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [90] = Utf8 logger 
.const [91] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [92] = Utf8 de/audi/atip/log/LogChannel 
.const [93] = Utf8 log 
.const [94] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [95] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [96] = Utf8 getDSINavigation 
.const [97] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [98] = Utf8 de/audi/atip/log/LogChannel 
.const [99] = Utf8 log 
.const [100] = Utf8 (ILjava/lang/String;)Z 
.const [101] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [102] = Utf8 getCommandList 
.const [103] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [104] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [108] = Utf8 location 
.const [109] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [110] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [111] = Utf8 hasCitys 
.const [112] = Utf8 Z 
.const [113] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [114] = Utf8 name 
.const [115] = Utf8 Ljava/lang/String; 
.const [116] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [117] = Utf8 liLastStateHistoryAdd 
.const [118] = Utf8 (Lorg/dsi/ifc/global/NavLocation;ZLjava/lang/String;)V 
.const [119] = Utf8 de/audi/tghu/command/ICommandList 
.const [120] = Utf8 commandFinished 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/audi/tghu/command/ICommandList 
.const [123] = Utf8 commandAborted 
.const [124] = Utf8 (J)V 
.const [125] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryAddCommand 
.const [126] = Class [125] 
.const [127] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [128] = Class [127] 
.const [129] = Utf8 hasCitys 
.const [130] = Utf8 Z 
.const [131] = Utf8 location 
.const [132] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [133] = Utf8 name 
.const [134] = Utf8 Ljava/lang/String; 
.const [135] = Utf8 Code 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lorg/dsi/ifc/global/NavLocation;ZLjava/lang/String;)V 
.const [138] = Utf8 execute 
.const [139] = Utf8 ()V 
.const [140] = Utf8 liHistoryResult 
.const [141] = Utf8 (I)V 
.end class 
