.version 50 0 
.class public final super [187] 
.super [189] 
.field private final [190] [191] 
.field private final [192] [193] 
.field private final [194] [195] 
.field private final [196] [197] 

.method public [199] : [200] 
    .attribute [198] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [35] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [37] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [38] 
L15:    aload_0 
L16:    iload 4 
L18:    putfield [39] 
L21:    aload_0 
L22:    aload 5 
L24:    putfield [40] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [198] .code stack 2 locals 0 
L0:     ldc_w [1] 
L3:     freturn 
L4:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [198] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [23] 
L11:    pop 
        .catch [4] from L12 to L22 using L25 
        .catch [4] from L12 to L52 using L55 
L12:    aload_0 
L13:    getfield [24] 
L16:    invokevirtual [25] 
L19:    invokevirtual [26] 
L22:    goto L33 
L25:    astore_1 
L26:    aload_0 
L27:    ldc [3] 
L29:    aload_1 
L30:    invokevirtual [27] 
L33:    aload_0 
L34:    getfield [28] 
L37:    aload_0 
L38:    getfield [18] 
L41:    aload_0 
L42:    getfield [19] 
L45:    aload_0 
L46:    getfield [20] 
L49:    invokevirtual [29] 
L52:    goto L69 
L55:    astore_1 
L56:    aload_0 
L57:    ldc [3] 
L59:    aload_1 
L60:    invokevirtual [27] 
L63:    aload_0 
L64:    iconst_0 
L65:    aconst_null 
L66:    invokespecial [34] 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [198] .code stack 5 locals 1 
        .catch [4] from L0 to L46 using L49 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [30] 
L13:    pop 
L14:    iload_1 
L15:    ifne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    istore_3 
L24:    iload_3 
L25:    ifeq L40 
L28:    aload_2 
L29:    ifnonnull L40 
L32:    aload_0 
L33:    ldc [6] 
L35:    invokevirtual [31] 
L38:    iconst_0 
L39:    istore_3 
L40:    aload_0 
L41:    iload_3 
L42:    aload_2 
L43:    invokespecial [34] 
L46:    goto L63 
L49:    astore_3 
L50:    aload_0 
L51:    ldc [6] 
L53:    aload_3 
L54:    invokevirtual [27] 
L57:    aload_0 
L58:    iconst_0 
L59:    aconst_null 
L60:    invokespecial [34] 
L63:    return 
L64:    
    .end code 
.end method 

.method private [207] : [208] 
    .attribute [198] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [2] 
L6:     ldc [7] 
L8:     iload_1 
L9:     invokevirtual [32] 
L12:    pop 
        .catch [4] from L13 to L28 using L40 
        .catch [0] from L13 to L28 using L60 
L13:    aload_0 
L14:    getfield [21] 
L17:    iload_1 
L18:    aload_2 
L19:    aload_0 
L20:    getfield [20] 
L23:    invokeinterface [41] 0 
L28:    aload_0 
L29:    getfield [33] 
L32:    invokeinterface [42] 0 
L37:    goto L74 
        .catch [0] from L40 to L48 using L60 
L40:    astore_3 
L41:    aload_0 
L42:    ldc [8] 
L44:    aload_3 
L45:    invokevirtual [27] 
L48:    aload_0 
L49:    getfield [33] 
L52:    invokeinterface [42] 0 
L57:    goto L74 
        .catch [0] from L60 to L62 using L60 
L60:    astore 4 
L62:    aload_0 
L63:    getfield [33] 
L66:    invokeinterface [42] 0 
L71:    aload 4 
L73:    athrow 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [198] .code stack 4 locals 0 
L0:     new [43] 
L3:     dup 
L4:     aload_0 
L5:     aload_0 
L6:     getfield [24] 
L9:     invokespecial [36] 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [211] : [212] 
    .attribute [198] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     invokespecial [34] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [45] 
.const [4] = Class [46] 
.const [5] = String [47] 
.const [6] = String [48] 
.const [7] = String [49] 
.const [8] = String [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = Class [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Field [60] [61] 
.const [19] = Field [62] [63] 
.const [20] = Field [64] [65] 
.const [21] = Field [66] [67] 
.const [22] = Field [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Field [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Field [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Field [98] [99] 
.const [38] = Field [100] [101] 
.const [39] = Field [102] [103] 
.const [40] = Field [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = Class [110] 
.const [44] = Int 549388800 
.const [45] = Utf8 '[GetMessageContentsCommand#execute]' 
.const [46] = Utf8 java/lang/Exception 
.const [47] = Utf8 '[GetMessageContentsCommand#getMessageContentsResponse] result = %1' 
.const [48] = Utf8 '[GetMessageContentsCommand#getMessageContentsResponse]' 
.const [49] = Utf8 '[GetMessageContentsCommand#signalResult] isResultOk = %1' 
.const [50] = Utf8 '[GetMessageContentsCommand#signalResult]' 
.const [51] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$1 
.const [52] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [53] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [54] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$ResultHandler 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [57] = Utf8 de/audi/app/messaging/core/compose/NewMessage 
.const [58] = Utf8 de/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess 
.const [59] = Utf8 de/audi/tghu/command/ICommandList 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Class [165] 
.const [97] = NameAndType [166] [167] 
.const [98] = Class [168] 
.const [99] = NameAndType [169] [170] 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Class [174] 
.const [103] = NameAndType [175] [176] 
.const [104] = Class [177] 
.const [105] = NameAndType [178] [179] 
.const [106] = Class [180] 
.const [107] = NameAndType [181] [182] 
.const [108] = Class [183] 
.const [109] = NameAndType [184] [185] 
.const [110] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$1 
.const [111] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [112] = Utf8 accountID 
.const [113] = Utf8 I 
.const [114] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [115] = Utf8 messageID 
.const [116] = Utf8 Ljava/lang/String; 
.const [117] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [118] = Utf8 download 
.const [119] = Utf8 I 
.const [120] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [121] = Utf8 resultHandler 
.const [122] = Utf8 Lde/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$ResultHandler; 
.const [123] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [124] = Utf8 logger 
.const [125] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [126] = Utf8 de/audi/atip/log/LogChannel 
.const [127] = Utf8 log 
.const [128] = Utf8 (ILjava/lang/String;)Z 
.const [129] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [130] = Utf8 msgApp 
.const [131] = Utf8 Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [132] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [133] = Utf8 getNewMessage 
.const [134] = Utf8 ()Lde/audi/app/messaging/core/compose/NewMessage; 
.const [135] = Utf8 de/audi/app/messaging/core/compose/NewMessage 
.const [136] = Utf8 indicateMessageDownload 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [139] = Utf8 logException 
.const [140] = Utf8 (Ljava/lang/String;Ljava/lang/Exception;)V 
.const [141] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [142] = Utf8 dsiMessagingAccess 
.const [143] = Utf8 Lde/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess; 
.const [144] = Utf8 de/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess 
.const [145] = Utf8 getMessageContentsRequest 
.const [146] = Utf8 (ILjava/lang/String;I)V 
.const [147] = Utf8 de/audi/atip/log/LogChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (ILjava/lang/String;J)Z 
.const [150] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [151] = Utf8 logNullParameter 
.const [152] = Utf8 (Ljava/lang/String;)V 
.const [153] = Utf8 de/audi/atip/log/LogChannel 
.const [154] = Utf8 log 
.const [155] = Utf8 (ILjava/lang/String;Z)Z 
.const [156] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [157] = Utf8 commandList 
.const [158] = Utf8 Lde/audi/tghu/command/ICommandList; 
.const [159] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [160] = Utf8 signalResult 
.const [161] = Utf8 (ZLorg/dsi/ifc/messaging/MessageDetails;)V 
.const [162] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [165] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$1 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (Lde/audi/app/messaging/core/viewmessage/GetMessageContentsCommand;Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [168] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [169] = Utf8 accountID 
.const [170] = Utf8 I 
.const [171] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [172] = Utf8 messageID 
.const [173] = Utf8 Ljava/lang/String; 
.const [174] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [175] = Utf8 download 
.const [176] = Utf8 I 
.const [177] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [178] = Utf8 resultHandler 
.const [179] = Utf8 Lde/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$ResultHandler; 
.const [180] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$ResultHandler 
.const [181] = Utf8 handleResult 
.const [182] = Utf8 (ZLorg/dsi/ifc/messaging/MessageDetails;I)V 
.const [183] = Utf8 de/audi/tghu/command/ICommandList 
.const [184] = Utf8 commandFinished 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [187] = Class [186] 
.const [188] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [189] = Class [188] 
.const [190] = Utf8 accountID 
.const [191] = Utf8 I 
.const [192] = Utf8 messageID 
.const [193] = Utf8 Ljava/lang/String; 
.const [194] = Utf8 download 
.const [195] = Utf8 I 
.const [196] = Utf8 resultHandler 
.const [197] = Utf8 Lde/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$ResultHandler; 
.const [198] = Utf8 Code 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;ILjava/lang/String;ILde/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$ResultHandler;)V 
.const [201] = Utf8 getTimeout 
.const [202] = Utf8 ()J 
.const [203] = Utf8 execute 
.const [204] = Utf8 ()V 
.const [205] = Utf8 getMessageContentsResponse 
.const [206] = Utf8 (ILorg/dsi/ifc/messaging/MessageDetails;)V 
.const [207] = Utf8 signalResult 
.const [208] = Utf8 (ZLorg/dsi/ifc/messaging/MessageDetails;)V 
.const [209] = Utf8 getErrorCommand 
.const [210] = Utf8 ()Lde/audi/tghu/command/Command; 
.const [211] = Utf8 access$000 
.const [212] = Utf8 (Lde/audi/app/messaging/core/viewmessage/GetMessageContentsCommand;ZLorg/dsi/ifc/messaging/MessageDetails;)V 
.end class 
