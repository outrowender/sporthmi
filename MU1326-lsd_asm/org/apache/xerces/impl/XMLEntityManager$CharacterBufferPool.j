.version 50 0 
.class final super [125] 
.super [127] 
.field private static final [128] [129] 
.field private [130] [131] 
.field private [132] [133] 
.field private [134] [135] 
.field private [136] [137] 
.field private [138] [139] 
.field private [140] [141] 
.field private [142] [143] 

.method public [145] : [146] 
    .attribute [144] .code stack 4 locals 0 
L0:     aload_0 
L1:     iconst_3 
L2:     iload_1 
L3:     iload_2 
L4:     invokespecial [13] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     iload_2 
L6:     putfield [17] 
L9:     aload_0 
L10:    iload_3 
L11:    putfield [18] 
L14:    aload_0 
L15:    iload_1 
L16:    putfield [19] 
L19:    aload_0 
L20:    invokespecial [15] 
L23:    return 
L24:    
    .end code 
.end method 

.method private [149] : [150] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [8] 
L5:     anewarray [2] 
L8:     putfield [21] 
L11:    aload_0 
L12:    aload_0 
L13:    getfield [8] 
L16:    anewarray [2] 
L19:    putfield [22] 
L22:    aload_0 
L23:    iconst_m1 
L24:    putfield [23] 
L27:    aload_0 
L28:    iconst_m1 
L29:    putfield [24] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [144] .code stack 5 locals 0 
L0:     iload_1 
L1:     ifeq L42 
L4:     aload_0 
L5:     getfield [12] 
L8:     iconst_m1 
L9:     if_icmple L29 
L12:    aload_0 
L13:    getfield [10] 
L16:    aload_0 
L17:    dup 
L18:    getfield [12] 
L21:    dup_x1 
L22:    iconst_1 
L23:    isub 
L24:    putfield [24] 
L27:    aaload 
L28:    areturn 
L29:    new [20] 
L32:    dup 
L33:    iconst_1 
L34:    aload_0 
L35:    getfield [6] 
L38:    invokespecial [16] 
L41:    areturn 
L42:    aload_0 
L43:    getfield [11] 
L46:    iconst_m1 
L47:    if_icmple L67 
L50:    aload_0 
L51:    getfield [9] 
L54:    aload_0 
L55:    dup 
L56:    getfield [11] 
L59:    dup_x1 
L60:    iconst_1 
L61:    isub 
L62:    putfield [23] 
L65:    aaload 
L66:    areturn 
L67:    new [20] 
L70:    dup 
L71:    iconst_0 
L72:    aload_0 
L73:    getfield [7] 
L76:    invokespecial [16] 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [144] .code stack 4 locals 0 
L0:     aload_1 
L1:     invokestatic [3] 
L4:     ifeq L41 
L7:     aload_0 
L8:     getfield [12] 
L11:    aload_0 
L12:    getfield [10] 
L15:    arraylength 
L16:    iconst_1 
L17:    isub 
L18:    if_icmpge L72 
L21:    aload_0 
L22:    getfield [10] 
L25:    aload_0 
L26:    dup 
L27:    getfield [12] 
L30:    iconst_1 
L31:    iadd 
L32:    dup_x1 
L33:    putfield [24] 
L36:    aload_1 
L37:    aastore 
L38:    goto L72 
L41:    aload_0 
L42:    getfield [11] 
L45:    aload_0 
L46:    getfield [9] 
L49:    arraylength 
L50:    iconst_1 
L51:    isub 
L52:    if_icmpge L72 
L55:    aload_0 
L56:    getfield [9] 
L59:    aload_0 
L60:    dup 
L61:    getfield [11] 
L64:    iconst_1 
L65:    iadd 
L66:    dup_x1 
L67:    putfield [23] 
L70:    aload_1 
L71:    aastore 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     aload_0 
L7:     getfield [8] 
L10:    anewarray [2] 
L13:    putfield [22] 
L16:    aload_0 
L17:    iconst_m1 
L18:    putfield [24] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Method [26] [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Field [30] [31] 
.const [7] = Field [32] [33] 
.const [8] = Field [34] [35] 
.const [9] = Field [36] [37] 
.const [10] = Field [38] [39] 
.const [11] = Field [40] [41] 
.const [12] = Field [42] [43] 
.const [13] = Method [44] [45] 
.const [14] = Method [46] [47] 
.const [15] = Method [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Field [52] [53] 
.const [18] = Field [54] [55] 
.const [19] = Field [56] [57] 
.const [20] = Class [58] 
.const [21] = Field [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = Field [65] [66] 
.const [25] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBuffer 
.const [26] = Class [67] 
.const [27] = NameAndType [68] [69] 
.const [28] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [29] = Utf8 java/lang/Object 
.const [30] = Class [70] 
.const [31] = NameAndType [71] [72] 
.const [32] = Class [73] 
.const [33] = NameAndType [74] [75] 
.const [34] = Class [76] 
.const [35] = NameAndType [77] [78] 
.const [36] = Class [79] 
.const [37] = NameAndType [80] [81] 
.const [38] = Class [82] 
.const [39] = NameAndType [83] [84] 
.const [40] = Class [85] 
.const [41] = NameAndType [86] [87] 
.const [42] = Class [88] 
.const [43] = NameAndType [89] [90] 
.const [44] = Class [91] 
.const [45] = NameAndType [92] [93] 
.const [46] = Class [94] 
.const [47] = NameAndType [95] [96] 
.const [48] = Class [97] 
.const [49] = NameAndType [98] [99] 
.const [50] = Class [100] 
.const [51] = NameAndType [101] [102] 
.const [52] = Class [103] 
.const [53] = NameAndType [104] [105] 
.const [54] = Class [106] 
.const [55] = NameAndType [107] [108] 
.const [56] = Class [109] 
.const [57] = NameAndType [110] [111] 
.const [58] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBuffer 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Class [118] 
.const [64] = NameAndType [119] [120] 
.const [65] = Class [121] 
.const [66] = NameAndType [122] [123] 
.const [67] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBuffer 
.const [68] = Utf8 access$500 
.const [69] = Utf8 (Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer;)Z 
.const [70] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [71] = Utf8 fExternalBufferSize 
.const [72] = Utf8 I 
.const [73] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [74] = Utf8 fInternalBufferSize 
.const [75] = Utf8 I 
.const [76] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [77] = Utf8 fPoolSize 
.const [78] = Utf8 I 
.const [79] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [80] = Utf8 fInternalBufferPool 
.const [81] = Utf8 [Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer; 
.const [82] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [83] = Utf8 fExternalBufferPool 
.const [84] = Utf8 [Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer; 
.const [85] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [86] = Utf8 fInternalTop 
.const [87] = Utf8 I 
.const [88] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [89] = Utf8 fExternalTop 
.const [90] = Utf8 I 
.const [91] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (III)V 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [98] = Utf8 init 
.const [99] = Utf8 ()V 
.const [100] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBuffer 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (ZI)V 
.const [103] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [104] = Utf8 fExternalBufferSize 
.const [105] = Utf8 I 
.const [106] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [107] = Utf8 fInternalBufferSize 
.const [108] = Utf8 I 
.const [109] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [110] = Utf8 fPoolSize 
.const [111] = Utf8 I 
.const [112] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [113] = Utf8 fInternalBufferPool 
.const [114] = Utf8 [Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer; 
.const [115] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [116] = Utf8 fExternalBufferPool 
.const [117] = Utf8 [Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer; 
.const [118] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [119] = Utf8 fInternalTop 
.const [120] = Utf8 I 
.const [121] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [122] = Utf8 fExternalTop 
.const [123] = Utf8 I 
.const [124] = Utf8 org/apache/xerces/impl/XMLEntityManager$CharacterBufferPool 
.const [125] = Class [124] 
.const [126] = Utf8 java/lang/Object 
.const [127] = Class [126] 
.const [128] = Utf8 DEFAULT_POOL_SIZE 
.const [129] = Utf8 I 
.const [130] = Utf8 fInternalBufferPool 
.const [131] = Utf8 [Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer; 
.const [132] = Utf8 fExternalBufferPool 
.const [133] = Utf8 [Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer; 
.const [134] = Utf8 fExternalBufferSize 
.const [135] = Utf8 I 
.const [136] = Utf8 fInternalBufferSize 
.const [137] = Utf8 I 
.const [138] = Utf8 fPoolSize 
.const [139] = Utf8 I 
.const [140] = Utf8 fInternalTop 
.const [141] = Utf8 I 
.const [142] = Utf8 fExternalTop 
.const [143] = Utf8 I 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (II)V 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (III)V 
.const [149] = Utf8 init 
.const [150] = Utf8 ()V 
.const [151] = Utf8 getBuffer 
.const [152] = Utf8 (Z)Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer; 
.const [153] = Utf8 returnBuffer 
.const [154] = Utf8 (Lorg/apache/xerces/impl/XMLEntityManager$CharacterBuffer;)V 
.const [155] = Utf8 setExternalBufferSize 
.const [156] = Utf8 (I)V 
.end class 
