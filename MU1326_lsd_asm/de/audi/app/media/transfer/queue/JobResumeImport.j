.version 50 0 
.class public super [193] 
.super [195] 
.implements [197] 
.field private static final [198] [199] 
.field private static final [200] [201] 
.field private static final [202] [203] 
.field private [204] [205] 
.field private final [206] [207] 
.field private [208] [209] 

.method public [211] : [212] 
    .attribute [210] .code stack 10 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     aload 5 
L8:     iconst_1 
L9:     iconst_1 
L10:    invokespecial [36] 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [41] 
L18:    aload_0 
L19:    aload 4 
L21:    putfield [42] 
L24:    aload_0 
L25:    new [43] 
L28:    dup 
L29:    ldc [3] 
L31:    iconst_5 
L32:    aconst_null 
L33:    aload_0 
L34:    ldc_w [1] 
L37:    iconst_1 
L38:    invokespecial [37] 
L41:    putfield [44] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [210] .code stack 1 locals 0 
L0:     iconst_4 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [210] .code stack 1 locals 0 
L0:     ldc [4] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [210] .code stack 4 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            8 : L20 
            default : L89 

L20:    aload_0 
L21:    invokevirtual [24] 
L24:    invokeinterface [45] 0 
L29:    aload_0 
L30:    getfield [22] 
L33:    iconst_1 
L34:    invokevirtual [25] 
L37:    ifeq L65 
L40:    aload_0 
L41:    getfield [26] 
L44:    ldc [5] 
L46:    ldc [6] 
L48:    ldc [7] 
L50:    invokevirtual [27] 
L53:    pop 
L54:    aload_0 
L55:    invokevirtual [28] 
L58:    iconst_0 
L59:    invokevirtual [29] 
L62:    goto L102 
L65:    aload_0 
L66:    getfield [26] 
L69:    ldc [8] 
L71:    ldc [9] 
L73:    ldc [7] 
L75:    invokevirtual [27] 
L78:    pop 
L79:    aload_0 
L80:    getfield [23] 
L83:    invokevirtual [30] 
L86:    goto L102 
L89:    aload_0 
L90:    getfield [23] 
L93:    invokevirtual [31] 
L96:    pop 
L97:    aload_0 
L98:    iload_1 
L99:    invokespecial [38] 
L102:   return 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [210] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [5] 
L6:     ldc [10] 
L8:     ldc [7] 
L10:    invokevirtual [27] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [32] 
L18:    bipush 8 
L20:    invokevirtual [33] 
L23:    aload_0 
L24:    invokevirtual [24] 
L27:    invokeinterface [46] 0 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [210] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [31] 
L7:     pop 
L8:     aload_0 
L9:     iload_1 
L10:    invokespecial [39] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [210] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [31] 
L7:     pop 
L8:     aload_0 
L9:     iload_1 
L10:    iload_2 
L11:    invokespecial [40] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [210] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     iconst_1 
L5:     invokevirtual [25] 
L8:     ifeq L42 
L11:    aload_0 
L12:    getfield [26] 
L15:    ldc [5] 
L17:    ldc [11] 
L19:    ldc [7] 
L21:    aload_0 
L22:    getfield [21] 
L25:    i2l 
L26:    ldc_w [1] 
L29:    invokevirtual [34] 
L32:    pop 
L33:    aload_0 
L34:    invokevirtual [28] 
L37:    iconst_0 
L38:    invokevirtual [29] 
L41:    return 
L42:    aload_0 
L43:    getfield [21] 
L46:    iconst_5 
L47:    if_icmpge L101 
L50:    aload_0 
L51:    getfield [22] 
L54:    iconst_1 
L55:    invokevirtual [25] 
L58:    ifne L101 
L61:    aload_0 
L62:    getfield [26] 
L65:    ldc [5] 
L67:    ldc [12] 
L69:    ldc [7] 
L71:    aload_0 
L72:    getfield [21] 
L75:    i2l 
L76:    ldc_w [1] 
L79:    invokevirtual [34] 
L82:    pop 
L83:    aload_0 
L84:    dup 
L85:    getfield [21] 
L88:    iconst_1 
L89:    iadd 
L90:    putfield [41] 
L93:    aload_0 
L94:    getfield [23] 
L97:    invokevirtual [30] 
L100:   return 
L101:   aload_0 
L102:   getfield [26] 
L105:   ldc [8] 
L107:   ldc [13] 
L109:   ldc [7] 
L111:   invokevirtual [27] 
L114:   pop 
L115:   aload_0 
L116:   invokevirtual [28] 
L119:   invokevirtual [35] 
L122:   return 
L123:   nop 
L124:   
    .end code 
.end method 

.method public enum [227] : [228] 
    .attribute [210] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [49] 
.const [3] = String [50] 
.const [4] = String [51] 
.const [5] = Int 1078071040 
.const [6] = String [52] 
.const [7] = String [53] 
.const [8] = Int -1601830656 
.const [9] = String [54] 
.const [10] = String [55] 
.const [11] = String [56] 
.const [12] = String [57] 
.const [13] = String [58] 
.const [14] = Class [59] 
.const [15] = Class [60] 
.const [16] = Class [61] 
.const [17] = Class [62] 
.const [18] = Class [63] 
.const [19] = Class [64] 
.const [20] = Class [65] 
.const [21] = Field [66] [67] 
.const [22] = Field [68] [69] 
.const [23] = Field [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Field [76] [77] 
.const [27] = Method [78] [79] 
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
.const [41] = Field [106] [107] 
.const [42] = Field [108] [109] 
.const [43] = Class [110] 
.const [44] = Field [111] [112] 
.const [45] = InterfaceMethod [113] [114] 
.const [46] = InterfaceMethod [115] [116] 
.const [47] = Int -402456576 
.const [48] = Int 83886080 
.const [49] = Utf8 de/audi/atip/timer/Timer 
.const [50] = Utf8 ImportResumeTimer 
.const [51] = Utf8 ResumeImport 
.const [52] = Utf8 '[%1.importStatusChanged] Start import.' 
.const [53] = Utf8 TransferJobResumeImport 
.const [54] = Utf8 '[%1.importStatusChanged] resources are locked, activate retry mechanism to resume import!' 
.const [55] = Utf8 '[%1.start]' 
.const [56] = Utf8 '[%1.fireTimer] Import ressources are available now. Start the import.' 
.const [57] = Utf8 '[%1.fireTimer] Restart %2/%3. Import ressources are still locked.' 
.const [58] = Utf8 '[%1.fireTimer] Import resume retry machanism timed out (resources are still locked) -> abort import!' 
.const [59] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [60] = Utf8 de/audi/app/media/transfer/queue/JobTransferring 
.const [61] = Utf8 de/audi/app/media/transfer/ITransferListener 
.const [62] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 de/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl 
.const [65] = Utf8 de/audi/app/media/transfer/TransferController 
.const [66] = Class [117] 
.const [67] = NameAndType [118] [119] 
.const [68] = Class [120] 
.const [69] = NameAndType [121] [122] 
.const [70] = Class [123] 
.const [71] = NameAndType [124] [125] 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Class [162] 
.const [97] = NameAndType [163] [164] 
.const [98] = Class [165] 
.const [99] = NameAndType [166] [167] 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Class [171] 
.const [103] = NameAndType [172] [173] 
.const [104] = Class [174] 
.const [105] = NameAndType [175] [176] 
.const [106] = Class [177] 
.const [107] = NameAndType [178] [179] 
.const [108] = Class [180] 
.const [109] = NameAndType [181] [182] 
.const [110] = Utf8 de/audi/atip/timer/Timer 
.const [111] = Class [183] 
.const [112] = NameAndType [184] [185] 
.const [113] = Class [186] 
.const [114] = NameAndType [187] [188] 
.const [115] = Class [189] 
.const [116] = NameAndType [190] [191] 
.const [117] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [118] = Utf8 timerRetries 
.const [119] = Utf8 I 
.const [120] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [121] = Utf8 transferLockHandler 
.const [122] = Utf8 Lde/audi/app/media/transfer/TransferLockHandler; 
.const [123] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [124] = Utf8 importResumeTimer 
.const [125] = Utf8 Lde/audi/atip/timer/Timer; 
.const [126] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [127] = Utf8 getTransferListener 
.const [128] = Utf8 ()Lde/audi/app/media/transfer/ITransferListener; 
.const [129] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [130] = Utf8 importActive 
.const [131] = Utf8 (Z)Z 
.const [132] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [133] = Utf8 logger 
.const [134] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [135] = Utf8 de/audi/atip/log/LogChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [138] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [139] = Utf8 getMediaDSIRecorder 
.const [140] = Utf8 ()Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl; 
.const [141] = Utf8 de/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl 
.const [142] = Utf8 startImport 
.const [143] = Utf8 (Z)V 
.const [144] = Utf8 de/audi/atip/timer/Timer 
.const [145] = Utf8 restart 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/audi/atip/timer/Timer 
.const [148] = Utf8 cancel 
.const [149] = Utf8 ()Z 
.const [150] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [151] = Utf8 getTransferController 
.const [152] = Utf8 ()Lde/audi/app/media/transfer/TransferController; 
.const [153] = Utf8 de/audi/app/media/transfer/TransferController 
.const [154] = Utf8 setTransferState 
.const [155] = Utf8 (I)V 
.const [156] = Utf8 de/audi/atip/log/LogChannel 
.const [157] = Utf8 log 
.const [158] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [159] = Utf8 de/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl 
.const [160] = Utf8 abortImport 
.const [161] = Utf8 ()V 
.const [162] = Utf8 de/audi/app/media/transfer/queue/JobTransferring 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/transfer/TransferController;Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl;Lde/audi/app/media/transfer/TransferLockHandler;Lde/audi/app/media/browser/AbstractMediaBrowser;ZZ)V 
.const [165] = Utf8 de/audi/atip/timer/Timer 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (Ljava/lang/String;ILde/audi/atip/log/LogChannel;Lde/audi/atip/timer/TimerListener;JZ)V 
.const [168] = Utf8 de/audi/app/media/transfer/queue/JobTransferring 
.const [169] = Utf8 importStatusChanged 
.const [170] = Utf8 (I)V 
.const [171] = Utf8 de/audi/app/media/transfer/queue/JobTransferring 
.const [172] = Utf8 abort 
.const [173] = Utf8 (Z)V 
.const [174] = Utf8 de/audi/app/media/transfer/queue/JobTransferring 
.const [175] = Utf8 asyncException 
.const [176] = Utf8 (II)V 
.const [177] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [178] = Utf8 timerRetries 
.const [179] = Utf8 I 
.const [180] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [181] = Utf8 transferLockHandler 
.const [182] = Utf8 Lde/audi/app/media/transfer/TransferLockHandler; 
.const [183] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [184] = Utf8 importResumeTimer 
.const [185] = Utf8 Lde/audi/atip/timer/Timer; 
.const [186] = Utf8 de/audi/app/media/transfer/ITransferListener 
.const [187] = Utf8 importWillBeResumed 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/app/media/transfer/ITransferListener 
.const [190] = Utf8 importIsSuspended 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/audi/app/media/transfer/queue/JobResumeImport 
.const [193] = Class [192] 
.const [194] = Utf8 de/audi/app/media/transfer/queue/JobTransferring 
.const [195] = Class [194] 
.const [196] = Utf8 de/audi/atip/timer/TimerListener 
.const [197] = Class [196] 
.const [198] = Utf8 LOGCLASS 
.const [199] = Utf8 Ljava/lang/String; 
.const [200] = Utf8 TIMER_TIMEOUT 
.const [201] = Utf8 J 
.const [202] = Utf8 MAX_TIMER_RETRIES_IMPORT_RESUME 
.const [203] = Utf8 I 
.const [204] = Utf8 transferLockHandler 
.const [205] = Utf8 Lde/audi/app/media/transfer/TransferLockHandler; 
.const [206] = Utf8 importResumeTimer 
.const [207] = Utf8 Lde/audi/atip/timer/Timer; 
.const [208] = Utf8 timerRetries 
.const [209] = Utf8 I 
.const [210] = Utf8 Code 
.const [211] = Utf8 <init> 
.const [212] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/transfer/TransferController;Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl;Lde/audi/app/media/transfer/TransferLockHandler;Lde/audi/app/media/browser/AbstractMediaBrowser;)V 
.const [213] = Utf8 getType 
.const [214] = Utf8 ()I 
.const [215] = Utf8 getName 
.const [216] = Utf8 ()Ljava/lang/String; 
.const [217] = Utf8 importStatusChanged 
.const [218] = Utf8 (I)V 
.const [219] = Utf8 start 
.const [220] = Utf8 ()V 
.const [221] = Utf8 abort 
.const [222] = Utf8 (Z)V 
.const [223] = Utf8 asyncException 
.const [224] = Utf8 (II)V 
.const [225] = Utf8 fireTimer 
.const [226] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [227] = Utf8 cancelTimer 
.const [228] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.end class 
