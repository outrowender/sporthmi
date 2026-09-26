.version 50 0 
.class final super [177] 
.super [179] 
.field private volatile [180] [181] 
.field private final synthetic [182] [183] 

.method private [185] : [186] 
    .attribute [184] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [42] 
L5:     aload_0 
L6:     aload_2 
L7:     iload_3 
L8:     iload 4 
L10:    iload 5 
L12:    invokespecial [39] 
L15:    aload_0 
L16:    iconst_0 
L17:    anewarray [2] 
L20:    putfield [43] 
L23:    return 
L24:    
    .end code 
.end method 

.method private [187] : [188] 
    .attribute [184] .code stack 5 locals 0 
L0:     aconst_null 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_0 
L6:     areturn 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [43] 
L12:    aload_0 
L13:    invokevirtual [25] 
L16:    aload_0 
L17:    getfield [23] 
L20:    invokestatic [3] 
L23:    ldc [4] 
L25:    ldc [5] 
L27:    aload_0 
L28:    invokevirtual [26] 
L31:    i2l 
L32:    invokevirtual [27] 
L35:    pop 
L36:    iconst_1 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [189] : [190] 
    .attribute [184] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokevirtual [28] 
L4:     aload_0 
L5:     getfield [23] 
L8:     invokestatic [3] 
L11:    ldc [4] 
L13:    ldc [6] 
L15:    aload_0 
L16:    invokevirtual [26] 
L19:    i2l 
L20:    invokevirtual [27] 
L23:    pop 
L24:    aload_0 
L25:    getfield [24] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [191] : [192] 
    .attribute [184] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokestatic [3] 
L7:     ldc [7] 
L9:     ldc [8] 
L11:    invokevirtual [29] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method protected enum [193] : [194] 
    .attribute [184] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [195] : [196] 
    .attribute [184] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokestatic [3] 
L7:     ldc [7] 
L9:     ldc [9] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [30] 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method protected [197] : [198] 
    .attribute [184] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [24] 
L4:     arraylength 
L5:     istore_2 
L6:     aload_0 
L7:     getfield [23] 
L10:    invokestatic [3] 
L13:    ldc [4] 
L15:    ldc [10] 
L17:    iload_2 
L18:    i2l 
L19:    invokevirtual [27] 
L22:    pop 
L23:    aload_1 
L24:    iload_2 
L25:    invokevirtual [31] 
L28:    new [44] 
L31:    dup 
L32:    aload_1 
L33:    invokespecial [40] 
L36:    astore_3 
L37:    iconst_0 
L38:    istore 4 
L40:    iload 4 
L42:    iload_2 
L43:    if_icmpge L67 
L46:    aload_0 
L47:    getfield [24] 
L50:    iload 4 
L52:    aaload 
L53:    astore 5 
L55:    aload_3 
L56:    aload 5 
L58:    invokevirtual [32] 
L61:    iinc 4 1 
L64:    goto L40 
L67:    return 
L68:    
    .end code 
.end method 

.method protected [199] : [200] 
    .attribute [184] .code stack 5 locals 4 
L0:     aload_1 
L1:     invokevirtual [33] 
L4:     istore_2 
L5:     aload_0 
L6:     getfield [23] 
L9:     invokestatic [3] 
L12:    ldc [4] 
L14:    ldc [12] 
L16:    iload_2 
L17:    i2l 
L18:    invokevirtual [27] 
L21:    pop 
L22:    iconst_0 
L23:    iload_2 
L24:    if_icmpgt L34 
L27:    sipush 200 
L30:    iload_2 
L31:    if_icmpge L53 
L34:    aload_0 
L35:    getfield [23] 
L38:    invokestatic [3] 
L41:    sipush 10000 
L44:    ldc [13] 
L46:    iload_2 
L47:    i2l 
L48:    invokevirtual [27] 
L51:    pop 
L52:    return 
L53:    aload_0 
L54:    iload_2 
L55:    anewarray [2] 
L58:    putfield [43] 
L61:    new [45] 
L64:    dup 
L65:    aload_1 
L66:    invokespecial [41] 
L69:    astore_3 
L70:    iconst_0 
L71:    istore 4 
L73:    iload 4 
L75:    iload_2 
L76:    if_icmpge L126 
        .catch [15] from L79 to L97 using L100 
L79:    aload_3 
L80:    invokevirtual [34] 
L83:    checkcast [2] 
L86:    astore 5 
L88:    aload_0 
L89:    getfield [24] 
L92:    iload 4 
L94:    aload 5 
L96:    aastore 
L97:    goto L120 
L100:   astore 5 
L102:   aload_0 
L103:   getfield [23] 
L106:   invokestatic [3] 
L109:   sipush 10000 
L112:   ldc [16] 
L114:   aload 5 
L116:   invokevirtual [35] 
L119:   pop 
L120:   iinc 4 1 
L123:   goto L73 
L126:   return 
L127:   nop 
L128:   
    .end code 
.end method 

.method synthetic [201] : [202] 
    .attribute [184] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     iload 4 
L6:     iload 5 
L8:     invokespecial [38] 
L11:    return 
L12:    
    .end code 
.end method 

.method static synthetic [203] : [204] 
    .attribute [184] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [37] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [205] : [206] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = Method [47] [48] 
.const [4] = Int -2137614336 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = Int -1601830656 
.const [8] = String [51] 
.const [9] = String [52] 
.const [10] = String [53] 
.const [11] = Class [54] 
.const [12] = String [55] 
.const [13] = String [56] 
.const [14] = Class [57] 
.const [15] = Class [58] 
.const [16] = String [59] 
.const [17] = Class [60] 
.const [18] = Class [61] 
.const [19] = Class [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Class [65] 
.const [23] = Field [66] [67] 
.const [24] = Field [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Method [84] [85] 
.const [33] = Method [86] [87] 
.const [34] = Method [88] [89] 
.const [35] = Method [90] [91] 
.const [36] = Method [92] [93] 
.const [37] = Method [94] [95] 
.const [38] = Method [96] [97] 
.const [39] = Method [98] [99] 
.const [40] = Method [100] [101] 
.const [41] = Method [102] [103] 
.const [42] = Field [104] [105] 
.const [43] = Field [106] [107] 
.const [44] = Class [108] 
.const [45] = Class [109] 
.const [46] = Utf8 de/audi/app/car/core/hybrid/IMemoryBufferEntry 
.const [47] = Class [110] 
.const [48] = NameAndType [111] [112] 
.const [49] = Utf8 '[HistoryPersistenceHandler#write] storage size: %1' 
.const [50] = Utf8 '[HistoryPersistenceHandler#read] storage size: %1' 
.const [51] = Utf8 '[HistoryPersistenceHandler#handleCRC32Error]' 
.const [52] = Utf8 '[HistoryPersistenceHandler#convertContainer] persistedVersion=%1, containerVersion=%2' 
.const [53] = Utf8 '[HistoryPersistenceHandler#serialize] arrayLength=%1' 
.const [54] = Utf8 java/io/ObjectOutputStream 
.const [55] = Utf8 '[HistoryPersistenceHandler#deserialize] arrayLength=%1' 
.const [56] = Utf8 '[HistoryPersistenceHandler#deserialize] array length not valid: %1' 
.const [57] = Utf8 java/io/ObjectInputStream 
.const [58] = Utf8 java/lang/ClassNotFoundException 
.const [59] = Utf8 '[HistoryPersistenceHandler#deserialize] %1' 
.const [60] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [61] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [62] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 java/io/DataOutputStream 
.const [65] = Utf8 java/io/DataInputStream 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Class [116] 
.const [69] = NameAndType [117] [118] 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Class [125] 
.const [75] = NameAndType [126] [127] 
.const [76] = Class [128] 
.const [77] = NameAndType [129] [130] 
.const [78] = Class [131] 
.const [79] = NameAndType [132] [133] 
.const [80] = Class [134] 
.const [81] = NameAndType [135] [136] 
.const [82] = Class [137] 
.const [83] = NameAndType [138] [139] 
.const [84] = Class [140] 
.const [85] = NameAndType [141] [142] 
.const [86] = Class [143] 
.const [87] = NameAndType [144] [145] 
.const [88] = Class [146] 
.const [89] = NameAndType [147] [148] 
.const [90] = Class [149] 
.const [91] = NameAndType [150] [151] 
.const [92] = Class [152] 
.const [93] = NameAndType [153] [154] 
.const [94] = Class [155] 
.const [95] = NameAndType [156] [157] 
.const [96] = Class [158] 
.const [97] = NameAndType [159] [160] 
.const [98] = Class [161] 
.const [99] = NameAndType [162] [163] 
.const [100] = Class [164] 
.const [101] = NameAndType [165] [166] 
.const [102] = Class [167] 
.const [103] = NameAndType [168] [169] 
.const [104] = Class [170] 
.const [105] = NameAndType [171] [172] 
.const [106] = Class [173] 
.const [107] = NameAndType [174] [175] 
.const [108] = Utf8 java/io/ObjectOutputStream 
.const [109] = Utf8 java/io/ObjectInputStream 
.const [110] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager 
.const [111] = Utf8 access$600 
.const [112] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager;)Lde/audi/atip/log/LogChannel; 
.const [113] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [114] = Utf8 this$0 
.const [115] = Utf8 Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager; 
.const [116] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [117] = Utf8 storageDataArray 
.const [118] = Utf8 [Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [119] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [120] = Utf8 serializeAndWrite 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [123] = Utf8 getSize 
.const [124] = Utf8 ()I 
.const [125] = Utf8 de/audi/atip/log/LogChannel 
.const [126] = Utf8 log 
.const [127] = Utf8 (ILjava/lang/String;J)Z 
.const [128] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [129] = Utf8 readAndDeserialize 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/audi/atip/log/LogChannel 
.const [132] = Utf8 log 
.const [133] = Utf8 (ILjava/lang/String;)Z 
.const [134] = Utf8 de/audi/atip/log/LogChannel 
.const [135] = Utf8 log 
.const [136] = Utf8 (ILjava/lang/String;JJ)Z 
.const [137] = Utf8 java/io/DataOutputStream 
.const [138] = Utf8 writeInt 
.const [139] = Utf8 (I)V 
.const [140] = Utf8 java/io/ObjectOutputStream 
.const [141] = Utf8 writeObject 
.const [142] = Utf8 (Ljava/lang/Object;)V 
.const [143] = Utf8 java/io/DataInputStream 
.const [144] = Utf8 readInt 
.const [145] = Utf8 ()I 
.const [146] = Utf8 java/io/ObjectInputStream 
.const [147] = Utf8 readObject 
.const [148] = Utf8 ()Ljava/lang/Object; 
.const [149] = Utf8 de/audi/atip/log/LogChannel 
.const [150] = Utf8 log 
.const [151] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [152] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [153] = Utf8 read 
.const [154] = Utf8 ()[Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [155] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [156] = Utf8 write 
.const [157] = Utf8 ([Lde/audi/app/car/core/hybrid/IMemoryBufferEntry;)Z 
.const [158] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager;Lde/audi/atip/storage/IStorageAccess;III)V 
.const [161] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/audi/atip/storage/IStorageAccess;III)V 
.const [164] = Utf8 java/io/ObjectOutputStream 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Ljava/io/OutputStream;)V 
.const [167] = Utf8 java/io/ObjectInputStream 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Ljava/io/InputStream;)V 
.const [170] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [171] = Utf8 this$0 
.const [172] = Utf8 Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager; 
.const [173] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [174] = Utf8 storageDataArray 
.const [175] = Utf8 [Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [176] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler 
.const [177] = Class [176] 
.const [178] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [179] = Class [178] 
.const [180] = Utf8 storageDataArray 
.const [181] = Utf8 [Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [182] = Utf8 this$0 
.const [183] = Utf8 Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager; 
.const [184] = Utf8 Code 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager;Lde/audi/atip/storage/IStorageAccess;III)V 
.const [187] = Utf8 write 
.const [188] = Utf8 ([Lde/audi/app/car/core/hybrid/IMemoryBufferEntry;)Z 
.const [189] = Utf8 read 
.const [190] = Utf8 ()[Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [191] = Utf8 handleCRC32Error 
.const [192] = Utf8 ()V 
.const [193] = Utf8 handleStorageReadError 
.const [194] = Utf8 (Ljava/lang/Exception;)V 
.const [195] = Utf8 convertContainer 
.const [196] = Utf8 (IILjava/io/DataInputStream;)V 
.const [197] = Utf8 serialize 
.const [198] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [199] = Utf8 deserialize 
.const [200] = Utf8 (Ljava/io/DataInputStream;)V 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager;Lde/audi/atip/storage/IStorageAccess;IIILde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$1;)V 
.const [203] = Utf8 access$400 
.const [204] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler;[Lde/audi/app/car/core/hybrid/IMemoryBufferEntry;)Z 
.const [205] = Utf8 access$500 
.const [206] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$HistoryPersistenceHandler;)[Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.end class 
