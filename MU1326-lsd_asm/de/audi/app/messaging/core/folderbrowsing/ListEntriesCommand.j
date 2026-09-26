.version 50 0 
.class final super [171] 
.super [173] 
.field static final [174] [175] 
.field private static final [176] [177] 
.field private final [178] [179] 
.field private final [180] [181] 

.method [183] : [184] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [33] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [37] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [36] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [182] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [21] 
L11:    pop 
        .catch [4] from L12 to L40 using L43 
L12:    aload_0 
L13:    getfield [22] 
L16:    aload_0 
L17:    getfield [18] 
L20:    invokevirtual [23] 
L23:    aload_0 
L24:    getfield [18] 
L27:    invokevirtual [24] 
L30:    aload_0 
L31:    getfield [18] 
L34:    invokevirtual [25] 
L37:    invokevirtual [26] 
L40:    goto L70 
L43:    astore_1 
L44:    aload_0 
L45:    ldc [3] 
L47:    aload_1 
L48:    invokevirtual [27] 
L51:    aload_0 
L52:    aload_0 
L53:    getfield [18] 
L56:    invokevirtual [23] 
L59:    iconst_1 
L60:    iconst_0 
L61:    anewarray [5] 
L64:    iconst_m1 
L65:    iconst_m1 
L66:    iconst_m1 
L67:    invokespecial [32] 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [182] .code stack 2 locals 0 
L0:     ldc_w [1] 
L3:     freturn 
L4:     
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [182] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [2] 
L6:     ldc [6] 
L8:     iload_2 
L9:     i2l 
L10:    invokevirtual [28] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    iload_2 
L17:    aload_3 
L18:    iload 4 
L20:    iload 5 
L22:    iload 6 
L24:    invokespecial [32] 
L27:    return 
L28:    
    .end code 
.end method 

.method private [191] : [192] 
    .attribute [182] .code stack 9 locals 3 
        .catch [4] from L0 to L71 using L83 
        .catch [0] from L0 to L71 using L105 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [2] 
L6:     ldc [7] 
L8:     iload_2 
L9:     i2l 
L10:    invokevirtual [28] 
L13:    pop 
L14:    aload_3 
L15:    astore 7 
L17:    iload_2 
L18:    ifne L37 
L21:    aload_3 
L22:    ifnonnull L37 
L25:    aload_0 
L26:    ldc [8] 
L28:    invokevirtual [29] 
L31:    iconst_0 
L32:    anewarray [5] 
L35:    astore 7 
L37:    new [38] 
L40:    dup 
L41:    aload_0 
L42:    getfield [18] 
L45:    iload_1 
L46:    iload_2 
L47:    aload 7 
L49:    iload 4 
L51:    iload 5 
L53:    iload 6 
L55:    invokespecial [34] 
L58:    astore 8 
L60:    aload_0 
L61:    getfield [19] 
L64:    aload 8 
L66:    invokeinterface [39] 0 
L71:    aload_0 
L72:    getfield [30] 
L75:    invokeinterface [40] 0 
L80:    goto L119 
        .catch [0] from L83 to L93 using L105 
L83:    astore 7 
L85:    aload_0 
L86:    ldc [8] 
L88:    aload 7 
L90:    invokevirtual [27] 
L93:    aload_0 
L94:    getfield [30] 
L97:    invokeinterface [40] 0 
L102:   goto L119 
        .catch [0] from L105 to L107 using L105 
L105:   astore 9 
L107:   aload_0 
L108:   getfield [30] 
L111:   invokeinterface [40] 0 
L116:   aload 9 
L118:   athrow 
L119:   return 
L120:   
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [182] .code stack 4 locals 0 
L0:     new [41] 
L3:     dup 
L4:     aload_0 
L5:     aload_0 
L6:     getfield [31] 
L9:     invokespecial [35] 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [195] : [196] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [197] : [198] 
    .attribute [182] .code stack 7 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     aload_3 
L4:     iload 4 
L6:     iload 5 
L8:     iload 6 
L10:    invokespecial [32] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [43] 
.const [4] = Class [44] 
.const [5] = Class [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = String [48] 
.const [9] = Class [49] 
.const [10] = Class [50] 
.const [11] = Class [51] 
.const [12] = Class [52] 
.const [13] = Class [53] 
.const [14] = Class [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Field [58] [59] 
.const [19] = Field [60] [61] 
.const [20] = Field [62] [63] 
.const [21] = Method [64] [65] 
.const [22] = Field [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Field [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Method [92] [93] 
.const [36] = Field [94] [95] 
.const [37] = Field [96] [97] 
.const [38] = Class [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = InterfaceMethod [101] [102] 
.const [41] = Class [103] 
.const [42] = Int 1223164160 
.const [43] = Utf8 '[ListEntriesCommand#execute]' 
.const [44] = Utf8 java/lang/Exception 
.const [45] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [46] = Utf8 '[ListEntriesCommand#listEntriesResponse] result = %1' 
.const [47] = Utf8 '[ListEntriesCommand#signalResult] result = %1' 
.const [48] = Utf8 '[ListEntriesCommand#signalResult]' 
.const [49] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListDataResponse 
.const [50] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$1 
.const [51] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [52] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [53] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$ResultHandler 
.const [54] = Utf8 de/audi/atip/log/LogChannel 
.const [55] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListDataRequest 
.const [56] = Utf8 de/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess 
.const [57] = Utf8 de/audi/tghu/command/ICommandList 
.const [58] = Class [104] 
.const [59] = NameAndType [105] [106] 
.const [60] = Class [107] 
.const [61] = NameAndType [108] [109] 
.const [62] = Class [110] 
.const [63] = NameAndType [111] [112] 
.const [64] = Class [113] 
.const [65] = NameAndType [114] [115] 
.const [66] = Class [116] 
.const [67] = NameAndType [117] [118] 
.const [68] = Class [119] 
.const [69] = NameAndType [120] [121] 
.const [70] = Class [122] 
.const [71] = NameAndType [123] [124] 
.const [72] = Class [125] 
.const [73] = NameAndType [126] [127] 
.const [74] = Class [128] 
.const [75] = NameAndType [129] [130] 
.const [76] = Class [131] 
.const [77] = NameAndType [132] [133] 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Class [140] 
.const [83] = NameAndType [141] [142] 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Class [146] 
.const [87] = NameAndType [147] [148] 
.const [88] = Class [149] 
.const [89] = NameAndType [150] [151] 
.const [90] = Class [152] 
.const [91] = NameAndType [153] [154] 
.const [92] = Class [155] 
.const [93] = NameAndType [156] [157] 
.const [94] = Class [158] 
.const [95] = NameAndType [159] [160] 
.const [96] = Class [161] 
.const [97] = NameAndType [162] [163] 
.const [98] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListDataResponse 
.const [99] = Class [164] 
.const [100] = NameAndType [165] [166] 
.const [101] = Class [167] 
.const [102] = NameAndType [168] [169] 
.const [103] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$1 
.const [104] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [105] = Utf8 listDataRequest 
.const [106] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/ListDataRequest; 
.const [107] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [108] = Utf8 resultHandler 
.const [109] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$ResultHandler; 
.const [110] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [111] = Utf8 logger 
.const [112] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 log 
.const [115] = Utf8 (ILjava/lang/String;)Z 
.const [116] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [117] = Utf8 dsiMessagingAccess 
.const [118] = Utf8 Lde/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess; 
.const [119] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListDataRequest 
.const [120] = Utf8 getRequestId 
.const [121] = Utf8 ()I 
.const [122] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListDataRequest 
.const [123] = Utf8 getOffset 
.const [124] = Utf8 ()I 
.const [125] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListDataRequest 
.const [126] = Utf8 getLength 
.const [127] = Utf8 ()I 
.const [128] = Utf8 de/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess 
.const [129] = Utf8 listEntriesRequest 
.const [130] = Utf8 (III)V 
.const [131] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [132] = Utf8 logException 
.const [133] = Utf8 (Ljava/lang/String;Ljava/lang/Exception;)V 
.const [134] = Utf8 de/audi/atip/log/LogChannel 
.const [135] = Utf8 log 
.const [136] = Utf8 (ILjava/lang/String;J)Z 
.const [137] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [138] = Utf8 logNullParameter 
.const [139] = Utf8 (Ljava/lang/String;)V 
.const [140] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [141] = Utf8 commandList 
.const [142] = Utf8 Lde/audi/tghu/command/ICommandList; 
.const [143] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [144] = Utf8 msgApp 
.const [145] = Utf8 Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [146] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [147] = Utf8 signalResult 
.const [148] = Utf8 (II[Lorg/dsi/ifc/messaging/ListEntry;III)V 
.const [149] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [152] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListDataResponse 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/ListDataRequest;II[Lorg/dsi/ifc/messaging/ListEntry;III)V 
.const [155] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$1 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/ListEntriesCommand;Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [158] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [159] = Utf8 listDataRequest 
.const [160] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/ListDataRequest; 
.const [161] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [162] = Utf8 resultHandler 
.const [163] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$ResultHandler; 
.const [164] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$ResultHandler 
.const [165] = Utf8 handleResult 
.const [166] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/ListDataResponse;)V 
.const [167] = Utf8 de/audi/tghu/command/ICommandList 
.const [168] = Utf8 commandFinished 
.const [169] = Utf8 ()V 
.const [170] = Utf8 de/audi/app/messaging/core/folderbrowsing/ListEntriesCommand 
.const [171] = Class [170] 
.const [172] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [173] = Class [172] 
.const [174] = Utf8 TIMEOUT 
.const [175] = Utf8 J 
.const [176] = Utf8 VALUE_INVALID 
.const [177] = Utf8 I 
.const [178] = Utf8 resultHandler 
.const [179] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$ResultHandler; 
.const [180] = Utf8 listDataRequest 
.const [181] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/ListDataRequest; 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;Lde/audi/app/messaging/core/folderbrowsing/ListEntriesCommand$ResultHandler;Lde/audi/app/messaging/core/folderbrowsing/ListDataRequest;)V 
.const [185] = Utf8 execute 
.const [186] = Utf8 ()V 
.const [187] = Utf8 getTimeout 
.const [188] = Utf8 ()J 
.const [189] = Utf8 listEntriesResponse 
.const [190] = Utf8 (II[Lorg/dsi/ifc/messaging/ListEntry;III)V 
.const [191] = Utf8 signalResult 
.const [192] = Utf8 (II[Lorg/dsi/ifc/messaging/ListEntry;III)V 
.const [193] = Utf8 getErrorCommand 
.const [194] = Utf8 ()Lde/audi/tghu/command/Command; 
.const [195] = Utf8 access$000 
.const [196] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/ListEntriesCommand;)Lde/audi/app/messaging/core/folderbrowsing/ListDataRequest; 
.const [197] = Utf8 access$100 
.const [198] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/ListEntriesCommand;II[Lorg/dsi/ifc/messaging/ListEntry;III)V 
.end class 
