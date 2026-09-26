.version 50 0 
.class public super [145] 
.super [147] 
.field private [148] [149] 

.method public [151] : [152] 
    .attribute [150] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     new [28] 
L8:     dup 
L9:     iload_1 
L10:    iload_2 
L11:    invokespecial [26] 
L14:    putfield [29] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [153] : [154] 
    .attribute [150] .code stack 2 locals 1 
L0:     new [30] 
L3:     dup 
L4:     invokespecial [27] 
L7:     astore_1 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [8] 
L13:    invokevirtual [9] 
L16:    pop 
L17:    aload_1 
L18:    invokevirtual [10] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [155] : [156] 
    .attribute [150] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [8] 
L4:     iload_2 
L5:     invokevirtual [11] 
L8:     astore 4 
L10:    aload_0 
L11:    getfield [8] 
L14:    iload_3 
L15:    invokevirtual [11] 
L18:    astore 5 
L20:    aload 4 
L22:    ifnull L30 
L25:    aload 5 
L27:    ifnonnull L32 
L30:    iconst_0 
L31:    areturn 
L32:    aload 4 
L34:    invokevirtual [12] 
L37:    iload_1 
L38:    if_icmpgt L54 
L41:    aload 5 
L43:    invokevirtual [12] 
L46:    iload_1 
L47:    if_icmpgt L54 
L50:    iconst_1 
L51:    goto L55 
L54:    iconst_0 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public synchronized [157] : [158] 
    .attribute [150] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_1 
L5:     invokevirtual [13] 
L8:     astore_2 
L9:     aload_2 
L10:    ifnull L31 
L13:    aload_2 
L14:    invokevirtual [14] 
L17:    invokevirtual [15] 
L20:    aload_1 
L21:    invokevirtual [15] 
L24:    if_icmpne L29 
L27:    aload_2 
L28:    areturn 
L29:    aconst_null 
L30:    areturn 
L31:    aload_2 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public synchronized [159] : [160] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [16] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [161] : [162] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     iload_1 
L5:     iload_2 
L6:     invokevirtual [17] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [163] : [164] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     iload_1 
L5:     iload_2 
L6:     invokevirtual [18] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [165] : [166] 
    .attribute [150] .code stack 8 locals 2 
L0:     aconst_null 
L1:     astore 8 
L3:     aload 6 
L5:     ifnull L19 
L8:     aload_0 
L9:     getfield [8] 
L12:    aload 6 
L14:    invokevirtual [13] 
L17:    astore 8 
L19:    aconst_null 
L20:    astore 9 
L22:    aload 8 
L24:    ifnonnull L41 
L27:    aload_0 
L28:    getfield [8] 
L31:    aload_3 
L32:    iload_2 
L33:    invokevirtual [19] 
L36:    astore 9 
L38:    goto L50 
L41:    aload 8 
L43:    aload_3 
L44:    iload_2 
L45:    invokevirtual [20] 
L48:    astore 9 
L50:    aload 9 
L52:    ifnull L71 
L55:    aload 9 
L57:    iload 4 
L59:    invokevirtual [21] 
L62:    aload 9 
L64:    iload_1 
L65:    invokevirtual [22] 
L68:    aload 9 
L70:    areturn 
L71:    aload_0 
L72:    getfield [8] 
L75:    iload_1 
L76:    iload_2 
L77:    aload_3 
L78:    iload 4 
L80:    iload 5 
L82:    aload 8 
L84:    aload 7 
L86:    invokevirtual [23] 
L89:    astore 9 
L91:    aload 9 
L93:    areturn 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public synchronized [167] : [168] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_1 
L5:     aload_2 
L6:     invokevirtual [24] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = Class [32] 
.const [4] = Class [33] 
.const [5] = Class [34] 
.const [6] = Class [35] 
.const [7] = Class [36] 
.const [8] = Field [37] [38] 
.const [9] = Method [39] [40] 
.const [10] = Method [41] [42] 
.const [11] = Method [43] [44] 
.const [12] = Method [45] [46] 
.const [13] = Method [47] [48] 
.const [14] = Method [49] [50] 
.const [15] = Method [51] [52] 
.const [16] = Method [53] [54] 
.const [17] = Method [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Class [77] 
.const [29] = Field [78] [79] 
.const [30] = Class [80] 
.const [31] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [32] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [33] = Utf8 de/esolutions/fw/util/tracing/model/TraceModel 
.const [34] = Utf8 java/lang/Object 
.const [35] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [36] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [37] = Class [81] 
.const [38] = NameAndType [82] [83] 
.const [39] = Class [84] 
.const [40] = NameAndType [85] [86] 
.const [41] = Class [87] 
.const [42] = NameAndType [88] [89] 
.const [43] = Class [90] 
.const [44] = NameAndType [91] [92] 
.const [45] = Class [93] 
.const [46] = NameAndType [94] [95] 
.const [47] = Class [96] 
.const [48] = NameAndType [97] [98] 
.const [49] = Class [99] 
.const [50] = NameAndType [100] [101] 
.const [51] = Class [102] 
.const [52] = NameAndType [103] [104] 
.const [53] = Class [105] 
.const [54] = NameAndType [106] [107] 
.const [55] = Class [108] 
.const [56] = NameAndType [109] [110] 
.const [57] = Class [111] 
.const [58] = NameAndType [112] [113] 
.const [59] = Class [114] 
.const [60] = NameAndType [115] [116] 
.const [61] = Class [117] 
.const [62] = NameAndType [118] [119] 
.const [63] = Class [120] 
.const [64] = NameAndType [121] [122] 
.const [65] = Class [123] 
.const [66] = NameAndType [124] [125] 
.const [67] = Class [126] 
.const [68] = NameAndType [127] [128] 
.const [69] = Class [129] 
.const [70] = NameAndType [130] [131] 
.const [71] = Class [132] 
.const [72] = NameAndType [133] [134] 
.const [73] = Class [135] 
.const [74] = NameAndType [136] [137] 
.const [75] = Class [138] 
.const [76] = NameAndType [139] [140] 
.const [77] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [81] = Utf8 de/esolutions/fw/util/tracing/model/TraceModel 
.const [82] = Utf8 pool 
.const [83] = Utf8 Lde/esolutions/fw/util/tracing/model/TraceEntityPool; 
.const [84] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [85] = Utf8 append 
.const [86] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 toString 
.const [89] = Utf8 ()Ljava/lang/String; 
.const [90] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [91] = Utf8 getById 
.const [92] = Utf8 (I)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [93] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [94] = Utf8 getFrontendFilterLevel 
.const [95] = Utf8 ()S 
.const [96] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [97] = Utf8 getByURI 
.const [98] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [99] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [100] = Utf8 getURI 
.const [101] = Utf8 ()Lde/esolutions/fw/util/tracing/entity/TraceEntityURI; 
.const [102] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [103] = Utf8 getType 
.const [104] = Utf8 ()S 
.const [105] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [106] = Utf8 getAllEntities 
.const [107] = Utf8 ()[Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [108] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [109] = Utf8 getAllCreatedEntitiesInRange 
.const [110] = Utf8 (II)[Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [111] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [112] = Utf8 getAllChangedOnlyEntitiesInRange 
.const [113] = Utf8 (II)[Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [114] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [115] = Utf8 findRootEntity 
.const [116] = Utf8 (Ljava/lang/String;S)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [117] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [118] = Utf8 findChild 
.const [119] = Utf8 (Ljava/lang/String;S)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [120] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [121] = Utf8 setFrontendFilterLevel 
.const [122] = Utf8 (S)V 
.const [123] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [124] = Utf8 setChangeEpoch 
.const [125] = Utf8 (I)V 
.const [126] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [127] = Utf8 createEntity 
.const [128] = Utf8 (ISLjava/lang/String;SSLde/esolutions/fw/util/tracing/model/TraceEntity;Ljava/lang/Object;)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [129] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [130] = Utf8 writeSemFile 
.const [131] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [132] = Utf8 java/lang/Object 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntityPool 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (II)V 
.const [138] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [139] = Utf8 <init> 
.const [140] = Utf8 ()V 
.const [141] = Utf8 de/esolutions/fw/util/tracing/model/TraceModel 
.const [142] = Utf8 pool 
.const [143] = Utf8 Lde/esolutions/fw/util/tracing/model/TraceEntityPool; 
.const [144] = Utf8 de/esolutions/fw/util/tracing/model/TraceModel 
.const [145] = Class [144] 
.const [146] = Utf8 java/lang/Object 
.const [147] = Class [146] 
.const [148] = Utf8 pool 
.const [149] = Utf8 Lde/esolutions/fw/util/tracing/model/TraceEntityPool; 
.const [150] = Utf8 Code 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (SI)V 
.const [153] = Utf8 toString 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 matchChannelAndThread 
.const [156] = Utf8 (SII)Z 
.const [157] = Utf8 getEntity 
.const [158] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [159] = Utf8 getAllEntities 
.const [160] = Utf8 (S)[Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [161] = Utf8 getAllCreatedEntitiesInRange 
.const [162] = Utf8 (II)[Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [163] = Utf8 getAllChangedOnlyEntitiesInRange 
.const [164] = Utf8 (II)[Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [165] = Utf8 createEntity 
.const [166] = Utf8 (ISLjava/lang/String;SSLde/esolutions/fw/util/tracing/entity/TraceEntityURI;Ljava/lang/Object;)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [167] = Utf8 writeSemFile 
.const [168] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.end class 
