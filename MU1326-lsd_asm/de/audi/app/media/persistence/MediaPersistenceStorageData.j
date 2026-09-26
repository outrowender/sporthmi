.version 50 0 
.class public super [150] 
.super [152] 
.field private static final [153] [154] 
.field private final [155] [156] 
.field private volatile [157] [158] 

.method public [160] : [161] 
    .attribute [159] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     iconst_0 
L3:     sipush 1002 
L6:     sipush 270 
L9:     invokespecial [32] 
L12:    aload_0 
L13:    aload_1 
L14:    invokeinterface [36] 0 
L19:    putfield [37] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [159] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     ldc [4] 
L10:    invokevirtual [23] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [24] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [159] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     ldc [4] 
L10:    invokevirtual [23] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [25] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [166] : [167] 
    .attribute [159] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [2] 
L6:     ldc [6] 
L8:     ldc [4] 
L10:    invokevirtual [23] 
L13:    pop 
L14:    aload_0 
L15:    new [38] 
L18:    dup 
L19:    invokespecial [33] 
L22:    putfield [39] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [168] : [169] 
    .attribute [159] .code stack 5 locals 0 
L0:     aload_1 
L1:     instanceof [8] 
L4:     ifeq L33 
L7:     aload_0 
L8:     getfield [22] 
L11:    ldc [2] 
L13:    ldc [9] 
L15:    ldc [4] 
L17:    invokevirtual [23] 
L20:    pop 
L21:    aload_0 
L22:    new [38] 
L25:    dup 
L26:    invokespecial [33] 
L29:    putfield [39] 
L32:    return 
L33:    aload_0 
L34:    getfield [22] 
L37:    sipush 10000 
L40:    ldc [10] 
L42:    ldc [4] 
L44:    aload_1 
L45:    invokevirtual [27] 
L48:    pop 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected enum [170] : [171] 
    .attribute [159] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [172] : [173] 
    .attribute [159] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [2] 
L6:     ldc [11] 
L8:     ldc [4] 
L10:    invokevirtual [23] 
L13:    pop 
L14:    new [40] 
L17:    dup 
L18:    aload_1 
L19:    invokespecial [34] 
L22:    astore_2 
L23:    aload_2 
L24:    aload_0 
L25:    getfield [26] 
L28:    invokevirtual [28] 
L31:    return 
L32:    
    .end code 
.end method 

.method protected [174] : [175] 
    .attribute [159] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [2] 
L6:     ldc [13] 
L8:     ldc [4] 
L10:    invokevirtual [23] 
L13:    pop 
L14:    new [41] 
L17:    dup 
L18:    aload_1 
L19:    invokespecial [35] 
L22:    astore_2 
        .catch [15] from L23 to L34 using L37 
L23:    aload_0 
L24:    aload_2 
L25:    invokevirtual [29] 
L28:    checkcast [7] 
L31:    putfield [39] 
L34:    goto L54 
L37:    astore_3 
L38:    aload_0 
L39:    getfield [22] 
L42:    sipush 10000 
L45:    ldc [16] 
L47:    ldc [4] 
L49:    aload_3 
L50:    invokevirtual [27] 
L53:    pop 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [159] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     aload_1 
L5:     invokevirtual [30] 
L8:     checkcast [17] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [178] : [179] 
    .attribute [159] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     aload_1 
L5:     aload_2 
L6:     invokevirtual [31] 
L9:     checkcast [17] 
L12:    astore_3 
L13:    aload_0 
L14:    invokevirtual [25] 
L17:    aload_3 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [42] 
.const [4] = String [43] 
.const [5] = String [44] 
.const [6] = String [45] 
.const [7] = Class [46] 
.const [8] = Class [47] 
.const [9] = String [48] 
.const [10] = String [49] 
.const [11] = String [50] 
.const [12] = Class [51] 
.const [13] = String [52] 
.const [14] = Class [53] 
.const [15] = Class [54] 
.const [16] = String [55] 
.const [17] = Class [56] 
.const [18] = Class [57] 
.const [19] = Class [58] 
.const [20] = Class [59] 
.const [21] = Class [60] 
.const [22] = Field [61] [62] 
.const [23] = Method [63] [64] 
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
.const [36] = InterfaceMethod [89] [90] 
.const [37] = Field [91] [92] 
.const [38] = Class [93] 
.const [39] = Field [94] [95] 
.const [40] = Class [96] 
.const [41] = Class [97] 
.const [42] = Utf8 '[%1.init]' 
.const [43] = Utf8 MediaPersistenceStorageData 
.const [44] = Utf8 '[%1.deinit]' 
.const [45] = Utf8 '[%1.handleCRC32Error]' 
.const [46] = Utf8 java/util/HashMap 
.const [47] = Utf8 de/audi/atip/storage/ValueMissingException 
.const [48] = Utf8 '[%1.handleStorageReadError] Value missing, create new one.' 
.const [49] = Utf8 '[%1.handleStorageReadError]' 
.const [50] = Utf8 '[%1.serialize]' 
.const [51] = Utf8 java/io/ObjectOutputStream 
.const [52] = Utf8 '[%1.deserialize]' 
.const [53] = Utf8 java/io/ObjectInputStream 
.const [54] = Utf8 java/lang/ClassNotFoundException 
.const [55] = Utf8 '[%1.deserialize] %2' 
.const [56] = Utf8 de/audi/app/media/persistence/PersistentData 
.const [57] = Utf8 de/audi/app/media/persistence/MediaPersistenceStorageData 
.const [58] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [59] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Class [98] 
.const [62] = NameAndType [99] [100] 
.const [63] = Class [101] 
.const [64] = NameAndType [102] [103] 
.const [65] = Class [104] 
.const [66] = NameAndType [105] [106] 
.const [67] = Class [107] 
.const [68] = NameAndType [108] [109] 
.const [69] = Class [110] 
.const [70] = NameAndType [111] [112] 
.const [71] = Class [113] 
.const [72] = NameAndType [114] [115] 
.const [73] = Class [116] 
.const [74] = NameAndType [117] [118] 
.const [75] = Class [119] 
.const [76] = NameAndType [120] [121] 
.const [77] = Class [122] 
.const [78] = NameAndType [123] [124] 
.const [79] = Class [125] 
.const [80] = NameAndType [126] [127] 
.const [81] = Class [128] 
.const [82] = NameAndType [129] [130] 
.const [83] = Class [131] 
.const [84] = NameAndType [132] [133] 
.const [85] = Class [134] 
.const [86] = NameAndType [135] [136] 
.const [87] = Class [137] 
.const [88] = NameAndType [138] [139] 
.const [89] = Class [140] 
.const [90] = NameAndType [141] [142] 
.const [91] = Class [143] 
.const [92] = NameAndType [144] [145] 
.const [93] = Utf8 java/util/HashMap 
.const [94] = Class [146] 
.const [95] = NameAndType [147] [148] 
.const [96] = Utf8 java/io/ObjectOutputStream 
.const [97] = Utf8 java/io/ObjectInputStream 
.const [98] = Utf8 de/audi/app/media/persistence/MediaPersistenceStorageData 
.const [99] = Utf8 logger 
.const [100] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [104] = Utf8 de/audi/app/media/persistence/MediaPersistenceStorageData 
.const [105] = Utf8 readAndDeserialize 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/audi/app/media/persistence/MediaPersistenceStorageData 
.const [108] = Utf8 serializeAndWrite 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/app/media/persistence/MediaPersistenceStorageData 
.const [111] = Utf8 mediaPersistence 
.const [112] = Utf8 Ljava/util/HashMap; 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 log 
.const [115] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [116] = Utf8 java/io/ObjectOutputStream 
.const [117] = Utf8 writeObject 
.const [118] = Utf8 (Ljava/lang/Object;)V 
.const [119] = Utf8 java/io/ObjectInputStream 
.const [120] = Utf8 readObject 
.const [121] = Utf8 ()Ljava/lang/Object; 
.const [122] = Utf8 java/util/HashMap 
.const [123] = Utf8 get 
.const [124] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [125] = Utf8 java/util/HashMap 
.const [126] = Utf8 put 
.const [127] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [128] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Lde/audi/atip/storage/IStorageAccess;III)V 
.const [131] = Utf8 java/util/HashMap 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 java/io/ObjectOutputStream 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (Ljava/io/OutputStream;)V 
.const [137] = Utf8 java/io/ObjectInputStream 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Ljava/io/InputStream;)V 
.const [140] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [141] = Utf8 main 
.const [142] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [143] = Utf8 de/audi/app/media/persistence/MediaPersistenceStorageData 
.const [144] = Utf8 logger 
.const [145] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [146] = Utf8 de/audi/app/media/persistence/MediaPersistenceStorageData 
.const [147] = Utf8 mediaPersistence 
.const [148] = Utf8 Ljava/util/HashMap; 
.const [149] = Utf8 de/audi/app/media/persistence/MediaPersistenceStorageData 
.const [150] = Class [149] 
.const [151] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [152] = Class [151] 
.const [153] = Utf8 LOGCLASS 
.const [154] = Utf8 Ljava/lang/String; 
.const [155] = Utf8 logger 
.const [156] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [157] = Utf8 mediaPersistence 
.const [158] = Utf8 Ljava/util/HashMap; 
.const [159] = Utf8 Code 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Lde/audi/app/media/logger/IMediaLogger;Lde/audi/atip/storage/IStorageAccess;)V 
.const [162] = Utf8 init 
.const [163] = Utf8 ()V 
.const [164] = Utf8 deinit 
.const [165] = Utf8 ()V 
.const [166] = Utf8 handleCRC32Error 
.const [167] = Utf8 ()V 
.const [168] = Utf8 handleStorageReadError 
.const [169] = Utf8 (Ljava/lang/Exception;)V 
.const [170] = Utf8 convertContainer 
.const [171] = Utf8 (IILjava/io/DataInputStream;)V 
.const [172] = Utf8 serialize 
.const [173] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [174] = Utf8 deserialize 
.const [175] = Utf8 (Ljava/io/DataInputStream;)V 
.const [176] = Utf8 get 
.const [177] = Utf8 (Ljava/lang/String;)Lde/audi/app/media/persistence/PersistentData; 
.const [178] = Utf8 put 
.const [179] = Utf8 (Ljava/lang/String;Lde/audi/app/media/persistence/PersistentData;)Lde/audi/app/media/persistence/PersistentData; 
.end class 
