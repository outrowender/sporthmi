.version 50 0 
.class super [138] 
.super [140] 
.field static [141] [142] 
.field static final [143] [144] 
.field static final [145] [146] 

.method static [148] : [149] 
    .attribute [147] .code stack 1 locals 0 
L0:     aconst_null 
L1:     putstatic [26] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method annotation [150] : [151] 
    .attribute [147] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     fload_2 
L3:     iload_3 
L4:     invokespecial [27] 
L7:     return 
L8:     
    .end code 
.end method 

.method protected [152] : [153] 
    .attribute [147] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [18] 
L4:     iconst_5 
L5:     if_icmple L10 
L8:     iconst_1 
L9:     areturn 
L10:    iconst_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method static [154] : [155] 
    .attribute [147] .code stack 5 locals 0 
L0:     invokestatic [6] 
L3:     getstatic [5] 
L6:     aload_0 
L7:     new [32] 
L10:    dup 
L11:    aload_1 
L12:    invokespecial [28] 
L15:    invokevirtual [19] 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method static [156] : [157] 
    .attribute [147] .code stack 4 locals 3 
L0:     invokestatic [6] 
L3:     getstatic [5] 
L6:     aload_0 
L7:     invokevirtual [20] 
L10:    checkcast [7] 
L13:    astore_1 
L14:    aload_1 
L15:    ifnull L101 
L18:    new [33] 
L21:    dup 
L22:    ldc [9] 
L24:    invokespecial [29] 
L27:    invokestatic [11] 
L30:    checkcast [12] 
L33:    astore_2 
L34:    bipush 10 
L36:    istore_3 
        .catch [17] from L37 to L52 using L52 
L37:    aload_2 
L38:    ifnull L53 
L41:    aload_2 
L42:    invokestatic [14] 
L45:    invokevirtual [21] 
L48:    istore_3 
L49:    goto L53 
L52:    pop 
L53:    iload_3 
L54:    ifne L68 
L57:    getstatic [5] 
L60:    invokevirtual [22] 
L63:    aconst_null 
L64:    astore_1 
L65:    goto L101 
L68:    iload_3 
L69:    iconst_m1 
L70:    if_icmpeq L101 
L73:    aload_1 
L74:    getfield [23] 
L77:    iload_3 
L78:    sipush 1000 
L81:    imul 
L82:    i2l 
L83:    ladd 
L84:    invokestatic [16] 
L87:    lcmp 
L88:    ifge L101 
L91:    getstatic [5] 
L94:    aload_0 
L95:    invokevirtual [24] 
L98:    pop 
L99:    aconst_null 
L100:   astore_1 
L101:   aload_1 
L102:   ifnull L110 
L105:   aload_1 
L106:   invokevirtual [25] 
L109:   areturn 
L110:   aconst_null 
L111:   areturn 
L112:   
    .end code 
.end method 

.method static [158] : [159] 
    .attribute [147] .code stack 5 locals 0 
L0:     getstatic [5] 
L3:     ifnonnull L21 
L6:     new [31] 
L9:     dup 
L10:    bipush 6 
L12:    ldc [4] 
L14:    iconst_1 
L15:    invokespecial [30] 
L18:    putstatic [26] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Int 16447 
.const [5] = Field [36] [37] 
.const [6] = Method [38] [39] 
.const [7] = Class [40] 
.const [8] = Class [41] 
.const [9] = String [42] 
.const [10] = Class [43] 
.const [11] = Method [44] [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Method [48] [49] 
.const [15] = Class [50] 
.const [16] = Method [51] [52] 
.const [17] = Class [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Field [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Method [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Method [78] [79] 
.const [31] = Class [80] 
.const [32] = Class [81] 
.const [33] = Class [82] 
.const [34] = Utf8 java/net/NegativeCache 
.const [35] = Utf8 java/util/LinkedHashMap 
.const [36] = Class [83] 
.const [37] = NameAndType [84] [85] 
.const [38] = Class [86] 
.const [39] = NameAndType [87] [88] 
.const [40] = Utf8 java/net/NegCacheElement 
.const [41] = Utf8 com/ibm/oti/util/PriviAction 
.const [42] = Utf8 'networkaddress.cache.negative.ttl' 
.const [43] = Utf8 java/security/AccessController 
.const [44] = Class [89] 
.const [45] = NameAndType [90] [91] 
.const [46] = Utf8 java/lang/String 
.const [47] = Utf8 java/lang/Integer 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Utf8 java/lang/System 
.const [51] = Class [95] 
.const [52] = NameAndType [96] [97] 
.const [53] = Utf8 java/lang/NumberFormatException 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
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
.const [80] = Utf8 java/net/NegativeCache 
.const [81] = Utf8 java/net/NegCacheElement 
.const [82] = Utf8 com/ibm/oti/util/PriviAction 
.const [83] = Utf8 java/net/NegativeCache 
.const [84] = Utf8 negCache 
.const [85] = Utf8 Ljava/net/NegativeCache; 
.const [86] = Utf8 java/net/NegativeCache 
.const [87] = Utf8 checkCacheExists 
.const [88] = Utf8 ()V 
.const [89] = Utf8 java/security/AccessController 
.const [90] = Utf8 doPrivileged 
.const [91] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [92] = Utf8 java/lang/Integer 
.const [93] = Utf8 decode 
.const [94] = Utf8 (Ljava/lang/String;)Ljava/lang/Integer; 
.const [95] = Utf8 java/lang/System 
.const [96] = Utf8 currentTimeMillis 
.const [97] = Utf8 ()J 
.const [98] = Utf8 java/net/NegativeCache 
.const [99] = Utf8 size 
.const [100] = Utf8 ()I 
.const [101] = Utf8 java/net/NegativeCache 
.const [102] = Utf8 put 
.const [103] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [104] = Utf8 java/net/NegativeCache 
.const [105] = Utf8 get 
.const [106] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [107] = Utf8 java/lang/Integer 
.const [108] = Utf8 intValue 
.const [109] = Utf8 ()I 
.const [110] = Utf8 java/net/NegativeCache 
.const [111] = Utf8 clear 
.const [112] = Utf8 ()V 
.const [113] = Utf8 java/net/NegCacheElement 
.const [114] = Utf8 timeAdded 
.const [115] = Utf8 J 
.const [116] = Utf8 java/net/NegativeCache 
.const [117] = Utf8 remove 
.const [118] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [119] = Utf8 java/net/NegCacheElement 
.const [120] = Utf8 hostName 
.const [121] = Utf8 ()Ljava/lang/String; 
.const [122] = Utf8 java/net/NegativeCache 
.const [123] = Utf8 negCache 
.const [124] = Utf8 Ljava/net/NegativeCache; 
.const [125] = Utf8 java/util/LinkedHashMap 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (IFZ)V 
.const [128] = Utf8 java/net/NegCacheElement 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/lang/String;)V 
.const [131] = Utf8 com/ibm/oti/util/PriviAction 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (Ljava/lang/String;)V 
.const [134] = Utf8 java/net/NegativeCache 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (IFZ)V 
.const [137] = Utf8 java/net/NegativeCache 
.const [138] = Class [137] 
.const [139] = Utf8 java/util/LinkedHashMap 
.const [140] = Class [139] 
.const [141] = Utf8 negCache 
.const [142] = Utf8 Ljava/net/NegativeCache; 
.const [143] = Utf8 MAX_NEGATIVE_ENTRIES 
.const [144] = Utf8 I 
.const [145] = Utf8 LOADING 
.const [146] = Utf8 F 
.const [147] = Utf8 Code 
.const [148] = Utf8 <clinit> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (IFZ)V 
.const [152] = Utf8 removeEldestEntry 
.const [153] = Utf8 (Ljava/util/Map$Entry;)Z 
.const [154] = Utf8 put 
.const [155] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [156] = Utf8 getFailedMessage 
.const [157] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [158] = Utf8 checkCacheExists 
.const [159] = Utf8 ()V 
.end class 
