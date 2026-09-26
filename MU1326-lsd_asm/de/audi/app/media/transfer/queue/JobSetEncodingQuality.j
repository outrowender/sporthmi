.version 50 0 
.class public super [165] 
.super [167] 
.field private static final [168] [169] 
.field private final [170] [171] 

.method public [173] : [174] 
    .attribute [172] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial [38] 
L9:     aload_0 
L10:    iload 5 
L12:    putfield [40] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [172] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [172] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [172] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [23] 
L6:     lookupswitch 
            0 : L32 
            1 : L37 
            default : L42 

L32:    iconst_0 
L33:    istore_1 
L34:    goto L42 
L37:    iconst_1 
L38:    istore_1 
L39:    goto L42 
L42:    aload_0 
L43:    invokevirtual [24] 
L46:    iload_1 
L47:    invokevirtual [25] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [172] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     ldc [5] 
L10:    invokevirtual [27] 
L13:    pop 
L14:    iload_1 
L15:    ifeq L33 
L18:    aload_0 
L19:    invokevirtual [28] 
L22:    iconst_4 
L23:    invokevirtual [29] 
L26:    aload_0 
L27:    invokevirtual [24] 
L30:    invokevirtual [30] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [172] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     ldc [5] 
L10:    iload_1 
L11:    i2l 
L12:    iload_2 
L13:    i2l 
L14:    invokevirtual [31] 
L17:    pop 
L18:    aload_0 
L19:    invokevirtual [32] 
L22:    iconst_1 
L23:    iconst_m1 
L24:    invokeinterface [41] 0 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [172] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     ldc [5] 
L10:    invokevirtual [27] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [32] 
L18:    iconst_0 
L19:    iload_1 
L20:    invokeinterface [41] 0 
L25:    aload_0 
L26:    invokevirtual [28] 
L29:    iconst_4 
L30:    invokevirtual [33] 
L33:    aload_0 
L34:    invokevirtual [34] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [172] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [9] 
L8:     ldc [5] 
L10:    invokevirtual [27] 
L13:    pop 
L14:    iconst_0 
L15:    iload_1 
L16:    if_icmpne L40 
L19:    aload_0 
L20:    invokevirtual [28] 
L23:    iconst_1 
L24:    invokevirtual [33] 
L27:    aload_0 
L28:    invokevirtual [32] 
L31:    invokeinterface [42] 0 
L36:    aload_0 
L37:    invokevirtual [34] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [172] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [10] 
L8:     ldc [5] 
L10:    invokevirtual [27] 
L13:    pop 
L14:    iconst_0 
L15:    iload_1 
L16:    if_icmpne L40 
L19:    aload_0 
L20:    invokevirtual [28] 
L23:    iconst_1 
L24:    invokevirtual [33] 
L27:    aload_0 
L28:    invokevirtual [32] 
L31:    invokeinterface [42] 0 
L36:    aload_0 
L37:    invokevirtual [34] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [172] .code stack 3 locals 1 
L0:     new [43] 
L3:     dup 
L4:     invokespecial [39] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [12] 
L11:    invokevirtual [35] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    invokevirtual [36] 
L20:    invokevirtual [35] 
L23:    pop 
L24:    aload_1 
L25:    ldc [13] 
L27:    invokevirtual [35] 
L30:    pop 
L31:    aload_1 
L32:    aload_0 
L33:    getfield [23] 
L36:    iconst_1 
L37:    if_icmpne L45 
L40:    ldc [14] 
L42:    goto L47 
L45:    ldc [15] 
L47:    invokevirtual [35] 
L50:    pop 
L51:    aload_1 
L52:    ldc [16] 
L54:    invokevirtual [35] 
L57:    pop 
L58:    aload_1 
L59:    invokevirtual [37] 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [44] 
.const [3] = Int 1078071040 
.const [4] = String [45] 
.const [5] = String [46] 
.const [6] = Int -1601830656 
.const [7] = String [47] 
.const [8] = String [48] 
.const [9] = String [49] 
.const [10] = String [50] 
.const [11] = Class [51] 
.const [12] = String [52] 
.const [13] = String [53] 
.const [14] = String [54] 
.const [15] = String [55] 
.const [16] = String [56] 
.const [17] = Class [57] 
.const [18] = Class [58] 
.const [19] = Class [59] 
.const [20] = Class [60] 
.const [21] = Class [61] 
.const [22] = Class [62] 
.const [23] = Field [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Method [81] [82] 
.const [33] = Method [83] [84] 
.const [34] = Method [85] [86] 
.const [35] = Method [87] [88] 
.const [36] = Method [89] [90] 
.const [37] = Method [91] [92] 
.const [38] = Method [93] [94] 
.const [39] = Method [95] [96] 
.const [40] = Field [97] [98] 
.const [41] = InterfaceMethod [99] [100] 
.const [42] = InterfaceMethod [101] [102] 
.const [43] = Class [103] 
.const [44] = Utf8 SetEncodingQuality 
.const [45] = Utf8 '[%1.abort]' 
.const [46] = Utf8 TransferJobSetEncodingQuality 
.const [47] = Utf8 "[%1.asyncException] requestType='%2' errorCode='%3'" 
.const [48] = Utf8 '[%1.encodingQualityChanged]' 
.const [49] = Utf8 '[%1.importStatusChanged]' 
.const [50] = Utf8 '[%1.deletionStatusChanged]' 
.const [51] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [52] = Utf8 '[name=' 
.const [53] = Utf8 ', encodingQuality=' 
.const [54] = Utf8 high 
.const [55] = Utf8 max 
.const [56] = Utf8 ']' 
.const [57] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [58] = Utf8 de/audi/app/media/transfer/queue/AbstractJobTransfer 
.const [59] = Utf8 de/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 de/audi/app/media/transfer/TransferController 
.const [62] = Utf8 de/audi/app/media/transfer/ITransferListener 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Class [116] 
.const [72] = NameAndType [117] [118] 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Class [125] 
.const [78] = NameAndType [126] [127] 
.const [79] = Class [128] 
.const [80] = NameAndType [129] [130] 
.const [81] = Class [131] 
.const [82] = NameAndType [132] [133] 
.const [83] = Class [134] 
.const [84] = NameAndType [135] [136] 
.const [85] = Class [137] 
.const [86] = NameAndType [138] [139] 
.const [87] = Class [140] 
.const [88] = NameAndType [141] [142] 
.const [89] = Class [143] 
.const [90] = NameAndType [144] [145] 
.const [91] = Class [146] 
.const [92] = NameAndType [147] [148] 
.const [93] = Class [149] 
.const [94] = NameAndType [150] [151] 
.const [95] = Class [152] 
.const [96] = NameAndType [153] [154] 
.const [97] = Class [155] 
.const [98] = NameAndType [156] [157] 
.const [99] = Class [158] 
.const [100] = NameAndType [159] [160] 
.const [101] = Class [161] 
.const [102] = NameAndType [162] [163] 
.const [103] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [104] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [105] = Utf8 encodingQuality 
.const [106] = Utf8 I 
.const [107] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [108] = Utf8 getMediaDSIRecorder 
.const [109] = Utf8 ()Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl; 
.const [110] = Utf8 de/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl 
.const [111] = Utf8 setEncodingQuality 
.const [112] = Utf8 (I)V 
.const [113] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [114] = Utf8 logger 
.const [115] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [116] = Utf8 de/audi/atip/log/LogChannel 
.const [117] = Utf8 log 
.const [118] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [119] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [120] = Utf8 getTransferController 
.const [121] = Utf8 ()Lde/audi/app/media/transfer/TransferController; 
.const [122] = Utf8 de/audi/app/media/transfer/TransferController 
.const [123] = Utf8 removeTransferState 
.const [124] = Utf8 (I)V 
.const [125] = Utf8 de/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl 
.const [126] = Utf8 abortImport 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/audi/atip/log/LogChannel 
.const [129] = Utf8 log 
.const [130] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [131] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [132] = Utf8 getTransferListener 
.const [133] = Utf8 ()Lde/audi/app/media/transfer/ITransferListener; 
.const [134] = Utf8 de/audi/app/media/transfer/TransferController 
.const [135] = Utf8 setTransferState 
.const [136] = Utf8 (I)V 
.const [137] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [138] = Utf8 jobFinished 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [141] = Utf8 append 
.const [142] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [143] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [144] = Utf8 getName 
.const [145] = Utf8 ()Ljava/lang/String; 
.const [146] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [147] = Utf8 toString 
.const [148] = Utf8 ()Ljava/lang/String; 
.const [149] = Utf8 de/audi/app/media/transfer/queue/AbstractJobTransfer 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/transfer/TransferController;Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl;Lde/audi/app/media/browser/AbstractMediaBrowser;)V 
.const [152] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [153] = Utf8 <init> 
.const [154] = Utf8 ()V 
.const [155] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [156] = Utf8 encodingQuality 
.const [157] = Utf8 I 
.const [158] = Utf8 de/audi/app/media/transfer/ITransferListener 
.const [159] = Utf8 encodingQualityChanged 
.const [160] = Utf8 (ZI)V 
.const [161] = Utf8 de/audi/app/media/transfer/ITransferListener 
.const [162] = Utf8 readyForTransfer 
.const [163] = Utf8 ()V 
.const [164] = Utf8 de/audi/app/media/transfer/queue/JobSetEncodingQuality 
.const [165] = Class [164] 
.const [166] = Utf8 de/audi/app/media/transfer/queue/AbstractJobTransfer 
.const [167] = Class [166] 
.const [168] = Utf8 LOGCLASS 
.const [169] = Utf8 Ljava/lang/String; 
.const [170] = Utf8 encodingQuality 
.const [171] = Utf8 I 
.const [172] = Utf8 Code 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/transfer/TransferController;Lde/audi/app/media/transfer/dsi/MediaDSIRecorderControllerImpl;Lde/audi/app/media/browser/AbstractMediaBrowser;I)V 
.const [175] = Utf8 getType 
.const [176] = Utf8 ()I 
.const [177] = Utf8 getName 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 start 
.const [180] = Utf8 ()V 
.const [181] = Utf8 abort 
.const [182] = Utf8 (Z)V 
.const [183] = Utf8 asyncException 
.const [184] = Utf8 (II)V 
.const [185] = Utf8 encodingQualityChanged 
.const [186] = Utf8 (I)V 
.const [187] = Utf8 importStatusChanged 
.const [188] = Utf8 (I)V 
.const [189] = Utf8 deletionStatusChanged 
.const [190] = Utf8 (I)V 
.const [191] = Utf8 toString 
.const [192] = Utf8 ()Ljava/lang/String; 
.end class 
