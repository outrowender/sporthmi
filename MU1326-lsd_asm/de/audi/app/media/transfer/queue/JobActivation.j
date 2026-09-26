.version 50 0 
.class public super [200] 
.super [202] 
.field private static final [203] [204] 
.field private final [205] [206] 
.field private static final [207] [208] 
.field private static final [209] [210] 
.field private volatile [211] [212] 
.field private volatile [213] [214] 

.method public [216] : [217] 
    .attribute [215] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 5 
L6:     invokespecial [41] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [45] 
L14:    aload_0 
L15:    iconst_m1 
L16:    putfield [46] 
L19:    aload_0 
L20:    aload 4 
L22:    putfield [47] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [218] : [219] 
    .attribute [215] .code stack 1 locals 0 
L0:     iconst_5 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [220] : [221] 
    .attribute [215] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [222] : [223] 
    .attribute [215] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [224] : [225] 
    .attribute [215] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     ldc [5] 
L10:    invokevirtual [28] 
L13:    pop 
L14:    iload_1 
L15:    lookupswitch 
            0 : L40 
            6 : L52 
            default : L110 

L40:    aload_0 
L41:    iconst_1 
L42:    putfield [46] 
L45:    aload_0 
L46:    invokespecial [42] 
L49:    goto L110 
L52:    aload_0 
L53:    getfield [26] 
L56:    iconst_0 
L57:    invokevirtual [29] 
L60:    pop 
L61:    aload_0 
L62:    invokevirtual [30] 
L65:    iconst_1 
L66:    invokevirtual [31] 
L69:    aload_0 
L70:    invokevirtual [30] 
L73:    new [48] 
L76:    dup 
L77:    aload_0 
L78:    getfield [27] 
L81:    aload_0 
L82:    invokevirtual [30] 
L85:    aload_0 
L86:    invokevirtual [32] 
L89:    aload_0 
L90:    getfield [26] 
L93:    aload_0 
L94:    invokevirtual [33] 
L97:    invokespecial [43] 
L100:   invokevirtual [34] 
L103:   aload_0 
L104:   invokevirtual [35] 
L107:   goto L110 
L110:   return 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [215] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     ldc [5] 
L10:    invokevirtual [28] 
L13:    pop 
L14:    iload_1 
L15:    lookupswitch 
            0 : L32 
            default : L44 

L32:    aload_0 
L33:    iconst_1 
L34:    putfield [45] 
L37:    aload_0 
L38:    invokespecial [42] 
L41:    goto L44 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [228] : [229] 
    .attribute [215] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     ldc [5] 
L10:    invokevirtual [28] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [32] 
L18:    invokevirtual [36] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public enum [230] : [231] 
    .attribute [215] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method private [232] : [233] 
    .attribute [215] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     iconst_1 
L5:     if_icmpne L60 
L8:     aload_0 
L9:     getfield [24] 
L12:    iconst_1 
L13:    if_icmpne L60 
L16:    aload_0 
L17:    getfield [27] 
L20:    ldc [3] 
L22:    ldc [9] 
L24:    ldc [5] 
L26:    invokevirtual [28] 
L29:    pop 
L30:    aload_0 
L31:    getfield [26] 
L34:    iconst_0 
L35:    invokevirtual [29] 
L38:    pop 
L39:    aload_0 
L40:    invokevirtual [30] 
L43:    iconst_1 
L44:    invokevirtual [31] 
L47:    aload_0 
L48:    invokevirtual [37] 
L51:    invokeinterface [49] 0 
L56:    aload_0 
L57:    invokevirtual [35] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [234] : [235] 
    .attribute [215] .code stack 3 locals 1 
L0:     new [50] 
L3:     dup 
L4:     invokespecial [44] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [11] 
L11:    invokevirtual [38] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    invokevirtual [39] 
L20:    invokevirtual [38] 
L23:    pop 
L24:    aload_1 
L25:    ldc [12] 
L27:    invokevirtual [38] 
L30:    pop 
L31:    aload_1 
L32:    aload_0 
L33:    getfield [24] 
L36:    iconst_1 
L37:    if_icmpne L45 
L40:    ldc [13] 
L42:    goto L47 
L45:    ldc [14] 
L47:    invokevirtual [38] 
L50:    pop 
L51:    aload_1 
L52:    ldc [15] 
L54:    invokevirtual [38] 
L57:    pop 
L58:    aload_1 
L59:    aload_0 
L60:    getfield [25] 
L63:    iconst_1 
L64:    if_icmpne L72 
L67:    ldc [13] 
L69:    goto L74 
L72:    ldc [14] 
L74:    invokevirtual [38] 
L77:    pop 
L78:    aload_1 
L79:    ldc [16] 
L81:    invokevirtual [38] 
L84:    pop 
L85:    aload_1 
L86:    invokevirtual [40] 
L89:    areturn 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [51] 
.const [3] = Int 1078071040 
.const [4] = String [52] 
.const [5] = String [53] 
.const [6] = Class [54] 
.const [7] = String [55] 
.const [8] = String [56] 
.const [9] = String [57] 
.const [10] = Class [58] 
.const [11] = String [59] 
.const [12] = String [60] 
.const [13] = String [61] 
.const [14] = String [62] 
.const [15] = String [63] 
.const [16] = String [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Class [70] 
.const [23] = Class [71] 
.const [24] = Field [72] [73] 
.const [25] = Field [74] [75] 
.const [26] = Field [76] [77] 
.const [27] = Field [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Method [98] [99] 
.const [38] = Method [100] [101] 
.const [39] = Method [102] [103] 
.const [40] = Method [104] [105] 
.const [41] = Method [106] [107] 
.const [42] = Method [108] [109] 
.const [43] = Method [110] [111] 
.const [44] = Method [112] [113] 
.const [45] = Field [114] [115] 
.const [46] = Field [116] [117] 
.const [47] = Field [118] [119] 
.const [48] = Class [120] 
.const [49] = InterfaceMethod [121] [122] 
.const [50] = Class [123] 
.const [51] = Utf8 Activation 
.const [52] = Utf8 '[%1.importStatusChanged]' 
.const [53] = Utf8 TransferJobActivation 
.const [54] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [55] = Utf8 '[%1.deletionStatusChanged]' 
.const [56] = Utf8 '[%1.start]' 
.const [57] = Utf8 '[%1.readyForTransfer]' 
.const [58] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [59] = Utf8 '[name=' 
.const [60] = Utf8 ', deleteState=' 
.const [61] = Utf8 ready 
.const [62] = Utf8 'not ready' 
.const [63] = Utf8 ', importState=' 
.const [64] = Utf8 ']' 
.const [65] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [66] = Utf8 de/audi/app/media/transfer/queue/AbstractJobTransfer 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [69] = Utf8 de/audi/app/media/transfer/TransferController 
.const [70] = Utf8 de/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl 
.const [71] = Utf8 de/audi/app/media/transfer/ITransferListener 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Class [148] 
.const [89] = NameAndType [149] [150] 
.const [90] = Class [151] 
.const [91] = NameAndType [152] [153] 
.const [92] = Class [154] 
.const [93] = NameAndType [155] [156] 
.const [94] = Class [157] 
.const [95] = NameAndType [158] [159] 
.const [96] = Class [160] 
.const [97] = NameAndType [161] [162] 
.const [98] = Class [163] 
.const [99] = NameAndType [164] [165] 
.const [100] = Class [166] 
.const [101] = NameAndType [167] [168] 
.const [102] = Class [169] 
.const [103] = NameAndType [170] [171] 
.const [104] = Class [172] 
.const [105] = NameAndType [173] [174] 
.const [106] = Class [175] 
.const [107] = NameAndType [176] [177] 
.const [108] = Class [178] 
.const [109] = NameAndType [179] [180] 
.const [110] = Class [181] 
.const [111] = NameAndType [182] [183] 
.const [112] = Class [184] 
.const [113] = NameAndType [185] [186] 
.const [114] = Class [187] 
.const [115] = NameAndType [188] [189] 
.const [116] = Class [190] 
.const [117] = NameAndType [191] [192] 
.const [118] = Class [193] 
.const [119] = NameAndType [194] [195] 
.const [120] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [121] = Class [196] 
.const [122] = NameAndType [197] [198] 
.const [123] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [124] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [125] = Utf8 dsiDeleteState 
.const [126] = Utf8 I 
.const [127] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [128] = Utf8 dsiImportState 
.const [129] = Utf8 I 
.const [130] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [131] = Utf8 transferLockHandler 
.const [132] = Utf8 Lde/audi/app/media/transfer/TransferLockHandler; 
.const [133] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [134] = Utf8 logger 
.const [135] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [136] = Utf8 de/audi/atip/log/LogChannel 
.const [137] = Utf8 log 
.const [138] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [139] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [140] = Utf8 importActive 
.const [141] = Utf8 (Z)Z 
.const [142] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [143] = Utf8 getTransferController 
.const [144] = Utf8 ()Lde/audi/app/media/transfer/TransferController; 
.const [145] = Utf8 de/audi/app/media/transfer/TransferController 
.const [146] = Utf8 setTransferState 
.const [147] = Utf8 (I)V 
.const [148] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [149] = Utf8 getMediaDSIRecorder 
.const [150] = Utf8 ()Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl; 
.const [151] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [152] = Utf8 getTransferBrowser 
.const [153] = Utf8 ()Lde/audi/app/media/browser/AbstractMediaBrowser; 
.const [154] = Utf8 de/audi/app/media/transfer/TransferController 
.const [155] = Utf8 enqueueTransferJob 
.const [156] = Utf8 (Lde/audi/app/media/transfer/queue/AbstractJobTransfer;)V 
.const [157] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [158] = Utf8 jobFinished 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl 
.const [161] = Utf8 startDSI 
.const [162] = Utf8 ()V 
.const [163] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [164] = Utf8 getTransferListener 
.const [165] = Utf8 ()Lde/audi/app/media/transfer/ITransferListener; 
.const [166] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [167] = Utf8 append 
.const [168] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [169] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [170] = Utf8 getName 
.const [171] = Utf8 ()Ljava/lang/String; 
.const [172] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [173] = Utf8 toString 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 de/audi/app/media/transfer/queue/AbstractJobTransfer 
.const [176] = Utf8 <init> 
.const [177] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/transfer/TransferController;Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl;Lde/audi/app/media/browser/AbstractMediaBrowser;)V 
.const [178] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [179] = Utf8 readyForTransfer 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/transfer/TransferController;Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl;Lde/audi/app/media/transfer/TransferLockHandler;Lde/audi/app/media/browser/AbstractMediaBrowser;)V 
.const [184] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [185] = Utf8 <init> 
.const [186] = Utf8 ()V 
.const [187] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [188] = Utf8 dsiDeleteState 
.const [189] = Utf8 I 
.const [190] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [191] = Utf8 dsiImportState 
.const [192] = Utf8 I 
.const [193] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [194] = Utf8 transferLockHandler 
.const [195] = Utf8 Lde/audi/app/media/transfer/TransferLockHandler; 
.const [196] = Utf8 de/audi/app/media/transfer/ITransferListener 
.const [197] = Utf8 readyForTransfer 
.const [198] = Utf8 ()V 
.const [199] = Utf8 de/audi/app/media/transfer/queue/JobActivation 
.const [200] = Class [199] 
.const [201] = Utf8 de/audi/app/media/transfer/queue/AbstractJobTransfer 
.const [202] = Class [201] 
.const [203] = Utf8 LOGCLASS 
.const [204] = Utf8 Ljava/lang/String; 
.const [205] = Utf8 transferLockHandler 
.const [206] = Utf8 Lde/audi/app/media/transfer/TransferLockHandler; 
.const [207] = Utf8 DSI_STATE_NOT_READY 
.const [208] = Utf8 I 
.const [209] = Utf8 DSI_STATE_READY 
.const [210] = Utf8 I 
.const [211] = Utf8 dsiDeleteState 
.const [212] = Utf8 I 
.const [213] = Utf8 dsiImportState 
.const [214] = Utf8 I 
.const [215] = Utf8 Code 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/transfer/TransferController;Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl;Lde/audi/app/media/transfer/TransferLockHandler;Lde/audi/app/media/browser/AbstractMediaBrowser;)V 
.const [218] = Utf8 getType 
.const [219] = Utf8 ()I 
.const [220] = Utf8 getName 
.const [221] = Utf8 ()Ljava/lang/String; 
.const [222] = Utf8 asyncException 
.const [223] = Utf8 (II)V 
.const [224] = Utf8 importStatusChanged 
.const [225] = Utf8 (I)V 
.const [226] = Utf8 deletionStatusChanged 
.const [227] = Utf8 (I)V 
.const [228] = Utf8 start 
.const [229] = Utf8 ()V 
.const [230] = Utf8 abort 
.const [231] = Utf8 (Z)V 
.const [232] = Utf8 readyForTransfer 
.const [233] = Utf8 ()V 
.const [234] = Utf8 toString 
.const [235] = Utf8 ()Ljava/lang/String; 
.end class 
