.version 50 0 
.class public super [122] 
.super [124] 
.field public static final [125] [126] 
.field private final [127] [128] 
.field private final [129] [130] 

.method public [132] : [133] 
    .attribute [131] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [25] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [131] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [15] 
L12:    invokestatic [4] 
L15:    aload_0 
L16:    getfield [16] 
L19:    i2l 
L20:    invokevirtual [18] 
L23:    pop 
L24:    aload_0 
L25:    invokevirtual [19] 
L28:    aload_0 
L29:    getfield [15] 
L32:    aload_0 
L33:    getfield [16] 
L36:    invokeinterface [26] 0 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [131] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     aload_1 
L9:     invokestatic [4] 
L12:    iload_2 
L13:    i2l 
L14:    invokevirtual [18] 
L17:    pop 
L18:    iload 4 
L20:    ifne L60 
L23:    aload_0 
L24:    getfield [17] 
L27:    ldc [2] 
L29:    ldc [6] 
L31:    aload_3 
L32:    invokevirtual [20] 
L35:    pop 
L36:    aload_0 
L37:    invokevirtual [21] 
L40:    ldc [7] 
L42:    aload_3 
L43:    invokeinterface [27] 0 
L48:    aload_0 
L49:    invokevirtual [21] 
L52:    invokeinterface [28] 0 
L57:    goto L88 
L60:    aload_0 
L61:    getfield [17] 
L64:    sipush 10000 
L67:    ldc [8] 
L69:    iload 4 
L71:    i2l 
L72:    invokevirtual [22] 
L75:    pop 
L76:    aload_0 
L77:    invokevirtual [21] 
L80:    iload 4 
L82:    i2l 
L83:    invokeinterface [29] 0 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [30] 
.const [4] = Method [31] [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Class [42] 
.const [15] = Field [43] [44] 
.const [16] = Field [45] [46] 
.const [17] = Field [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Field [61] [62] 
.const [25] = Field [63] [64] 
.const [26] = InterfaceMethod [65] [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = InterfaceMethod [71] [72] 
.const [30] = Utf8 'LiGetSpellableCharactersCommand#execute() - calling liGetSpellableCharacters( %1, %2 )' 
.const [31] = Class [73] 
.const [32] = NameAndType [74] [75] 
.const [33] = Utf8 'LiGetSpellableCharactersCommand#liGetSpellableCharactersResult() - using location: %1, criterion: %2' 
.const [34] = Utf8 "LiGetSpellableCharactersCommand#liGetSpellableCharactersResult() - got characters '%1'" 
.const [35] = Utf8 SPELLABLE_CHARACTERS_RESULT 
.const [36] = Utf8 'LiGetSpellableCharactersCommand#liGetSpellableCharactersResult() - got error code %1 !' 
.const [37] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [38] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [39] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [42] = Utf8 de/audi/tghu/command/ICommandList 
.const [43] = Class [76] 
.const [44] = NameAndType [77] [78] 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [74] = Utf8 formatLocationShort 
.const [75] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Ljava/lang/String; 
.const [76] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [77] = Utf8 location 
.const [78] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [79] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [80] = Utf8 criterion 
.const [81] = Utf8 I 
.const [82] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [83] = Utf8 logger 
.const [84] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Utf8 log 
.const [87] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [88] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [89] = Utf8 getDSINavigation 
.const [90] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [94] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [95] = Utf8 getCommandList 
.const [96] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;J)Z 
.const [100] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [104] = Utf8 location 
.const [105] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [106] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [107] = Utf8 criterion 
.const [108] = Utf8 I 
.const [109] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [110] = Utf8 liGetSpellableCharacters 
.const [111] = Utf8 (Lorg/dsi/ifc/global/NavLocation;I)V 
.const [112] = Utf8 de/audi/tghu/command/ICommandList 
.const [113] = Utf8 put 
.const [114] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)V 
.const [115] = Utf8 de/audi/tghu/command/ICommandList 
.const [116] = Utf8 commandFinished 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/audi/tghu/command/ICommandList 
.const [119] = Utf8 commandAborted 
.const [120] = Utf8 (J)V 
.const [121] = Utf8 de/audi/tghu/navi/app/command/LiGetSpellableCharactersCommand 
.const [122] = Class [121] 
.const [123] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [124] = Class [123] 
.const [125] = Utf8 RESULT 
.const [126] = Utf8 Ljava/lang/String; 
.const [127] = Utf8 location 
.const [128] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [129] = Utf8 criterion 
.const [130] = Utf8 I 
.const [131] = Utf8 Code 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (Lorg/dsi/ifc/global/NavLocation;I)V 
.const [134] = Utf8 execute 
.const [135] = Utf8 ()V 
.const [136] = Utf8 liGetSpellableCharactersResult 
.const [137] = Utf8 (Lorg/dsi/ifc/global/NavLocation;ILjava/lang/String;I)V 
.end class 
