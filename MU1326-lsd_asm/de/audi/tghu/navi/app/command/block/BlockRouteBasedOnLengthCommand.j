.version 50 0 
.class public super [122] 
.super [124] 
.field public static final [125] [126] 
.field private final [127] [128] 
.field private final [129] [130] 

.method public [132] : [133] 
    .attribute [131] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [23] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [24] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [131] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [13] 
L12:    i2l 
L13:    aload_0 
L14:    getfield [14] 
L17:    i2l 
L18:    invokevirtual [16] 
L21:    pop 
L22:    aload_0 
L23:    invokevirtual [17] 
L26:    aload_0 
L27:    getfield [13] 
L30:    aload_0 
L31:    getfield [14] 
L34:    invokeinterface [25] 0 
L39:    return 
L40:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [131] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     invokevirtual [18] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [19] 
L16:    ldc [5] 
L18:    new [26] 
L21:    dup 
L22:    lload_1 
L23:    invokespecial [22] 
L26:    invokeinterface [27] 0 
L31:    iload_3 
L32:    ifne L47 
L35:    aload_0 
L36:    invokevirtual [19] 
L39:    invokeinterface [28] 0 
L44:    goto L73 
L47:    aload_0 
L48:    getfield [15] 
L51:    sipush 10000 
L54:    ldc [7] 
L56:    iload_3 
L57:    i2l 
L58:    invokevirtual [20] 
L61:    pop 
L62:    aload_0 
L63:    invokevirtual [19] 
L66:    iload_3 
L67:    i2l 
L68:    invokeinterface [29] 0 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [30] 
.const [4] = String [31] 
.const [5] = String [32] 
.const [6] = Class [33] 
.const [7] = String [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Class [39] 
.const [13] = Field [40] [41] 
.const [14] = Field [42] [43] 
.const [15] = Field [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Field [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = InterfaceMethod [64] [65] 
.const [26] = Class [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = InterfaceMethod [71] [72] 
.const [30] = Utf8 'BlockRouteBasedOnLengthCommand#execute() - calling blockRouteBasedOnLength( %1, %2 )' 
.const [31] = Utf8 'BlockRouteBasedOnLengthCommand#blockRouteBasedOnLengthResult()' 
.const [32] = Utf8 BLOCK_UID 
.const [33] = Utf8 java/lang/Long 
.const [34] = Utf8 'BlockRouteBasedOnLengthCommand#blockRouteBasedOnLengthResult() - got error code %1 !' 
.const [35] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [36] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Utf8 org/dsi/ifc/navigation/DSIBlocking 
.const [39] = Utf8 de/audi/tghu/command/ICommandList 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Utf8 java/lang/Long 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [74] = Utf8 offset 
.const [75] = Utf8 I 
.const [76] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [77] = Utf8 length 
.const [78] = Utf8 I 
.const [79] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [80] = Utf8 logger 
.const [81] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 log 
.const [84] = Utf8 (ILjava/lang/String;JJ)Z 
.const [85] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [86] = Utf8 getDSIBlocking 
.const [87] = Utf8 ()Lorg/dsi/ifc/navigation/DSIBlocking; 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;)Z 
.const [91] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [92] = Utf8 getCommandList 
.const [93] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;J)Z 
.const [97] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 java/lang/Long 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (J)V 
.const [103] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [104] = Utf8 offset 
.const [105] = Utf8 I 
.const [106] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [107] = Utf8 length 
.const [108] = Utf8 I 
.const [109] = Utf8 org/dsi/ifc/navigation/DSIBlocking 
.const [110] = Utf8 blockRouteBasedOnLength 
.const [111] = Utf8 (II)V 
.const [112] = Utf8 de/audi/tghu/command/ICommandList 
.const [113] = Utf8 put 
.const [114] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)V 
.const [115] = Utf8 de/audi/tghu/command/ICommandList 
.const [116] = Utf8 commandFinished 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/audi/tghu/command/ICommandList 
.const [119] = Utf8 commandAborted 
.const [120] = Utf8 (J)V 
.const [121] = Utf8 de/audi/tghu/navi/app/command/block/BlockRouteBasedOnLengthCommand 
.const [122] = Class [121] 
.const [123] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [124] = Class [123] 
.const [125] = Utf8 BLOCK_UID 
.const [126] = Utf8 Ljava/lang/String; 
.const [127] = Utf8 offset 
.const [128] = Utf8 I 
.const [129] = Utf8 length 
.const [130] = Utf8 I 
.const [131] = Utf8 Code 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (II)V 
.const [134] = Utf8 execute 
.const [135] = Utf8 ()V 
.const [136] = Utf8 blockRouteBasedOnLengthResult 
.const [137] = Utf8 (JI)V 
.end class 
