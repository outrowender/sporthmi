.version 50 0 
.class public super [99] 
.super [101] 
.field private final [102] [103] 
.field private final [104] [105] 

.method public [107] : [108] 
    .attribute [106] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [106] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     invokevirtual [13] 
L7:     aload_0 
L8:     getfield [10] 
L11:    aload_0 
L12:    getfield [11] 
L15:    invokeinterface [20] 0 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [106] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [10] 
L4:     ifne L62 
L7:     iconst_0 
L8:     istore_2 
L9:     iload_2 
L10:    aload_0 
L11:    getfield [11] 
L14:    arraylength 
L15:    if_icmpge L62 
L18:    aload_1 
L19:    iload_2 
L20:    laload 
L21:    ldc2_w [23] 
L24:    lcmp 
L25:    ifeq L43 
L28:    aload_0 
L29:    getfield [11] 
L32:    iload_2 
L33:    aaload 
L34:    aload_1 
L35:    iload_2 
L36:    laload 
L37:    putfield [21] 
L40:    goto L56 
L43:    aload_0 
L44:    getfield [14] 
L47:    sipush 10000 
L50:    ldc [2] 
L52:    invokevirtual [15] 
L55:    pop 
L56:    iinc 2 1 
L59:    goto L9 
L62:    aload_0 
L63:    invokevirtual [16] 
L66:    invokeinterface [22] 0 
L71:    return 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = Class [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Field [33] [34] 
.const [11] = Field [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = InterfaceMethod [53] [54] 
.const [21] = Field [55] [56] 
.const [22] = InterfaceMethod [57] [58] 
.const [23] = Long -1L 
.const [25] = Utf8 'MapFlagConfigure#configureFlags(): handle already set in map (handle is -1)' 
.const [26] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [27] = Utf8 de/audi/tghu/navi/app/map/command/MapCommand 
.const [28] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [29] = Utf8 de/audi/tghu/navi/app/map/dsi/IMapRequest 
.const [30] = Utf8 org/dsi/ifc/map/MapFlag 
.const [31] = Utf8 de/audi/atip/log/LogChannel 
.const [32] = Utf8 de/audi/tghu/command/ICommandList 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Class [62] 
.const [36] = NameAndType [63] [64] 
.const [37] = Class [65] 
.const [38] = NameAndType [66] [67] 
.const [39] = Class [68] 
.const [40] = NameAndType [69] [70] 
.const [41] = Class [71] 
.const [42] = NameAndType [72] [73] 
.const [43] = Class [74] 
.const [44] = NameAndType [75] [76] 
.const [45] = Class [77] 
.const [46] = NameAndType [78] [79] 
.const [47] = Class [80] 
.const [48] = NameAndType [81] [82] 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [60] = Utf8 command 
.const [61] = Utf8 I 
.const [62] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [63] = Utf8 mapFlags 
.const [64] = Utf8 [Lorg/dsi/ifc/map/MapFlag; 
.const [65] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [66] = Utf8 getMap 
.const [67] = Utf8 ()Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [68] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [69] = Utf8 getMVRequest 
.const [70] = Utf8 ()Lde/audi/tghu/navi/app/map/dsi/IMapRequest; 
.const [71] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [72] = Utf8 logger 
.const [73] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 log 
.const [76] = Utf8 (ILjava/lang/String;)Z 
.const [77] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [78] = Utf8 getCommandList 
.const [79] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [80] = Utf8 de/audi/tghu/navi/app/map/command/MapCommand 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [84] = Utf8 command 
.const [85] = Utf8 I 
.const [86] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [87] = Utf8 mapFlags 
.const [88] = Utf8 [Lorg/dsi/ifc/map/MapFlag; 
.const [89] = Utf8 de/audi/tghu/navi/app/map/dsi/IMapRequest 
.const [90] = Utf8 configureFlags 
.const [91] = Utf8 (I[Lorg/dsi/ifc/map/MapFlag;)V 
.const [92] = Utf8 org/dsi/ifc/map/MapFlag 
.const [93] = Utf8 handle 
.const [94] = Utf8 J 
.const [95] = Utf8 de/audi/tghu/command/ICommandList 
.const [96] = Utf8 commandFinished 
.const [97] = Utf8 ()V 
.const [98] = Utf8 de/audi/tghu/navi/app/map/command/MapFlagConfigure 
.const [99] = Class [98] 
.const [100] = Utf8 de/audi/tghu/navi/app/map/command/MapCommand 
.const [101] = Class [100] 
.const [102] = Utf8 command 
.const [103] = Utf8 I 
.const [104] = Utf8 mapFlags 
.const [105] = Utf8 [Lorg/dsi/ifc/map/MapFlag; 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (I[Lorg/dsi/ifc/map/MapFlag;)V 
.const [109] = Utf8 execute 
.const [110] = Utf8 ()V 
.const [111] = Utf8 configureFlags 
.const [112] = Utf8 ([J)V 
.end class 
