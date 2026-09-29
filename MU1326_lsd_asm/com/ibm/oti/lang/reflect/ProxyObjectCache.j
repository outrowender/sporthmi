.version 50 0 
.class super [149] 
.super [151] 
.field [152] [153] 
.field [154] [155] 
.field [156] [157] 
.field [158] [159] 

.method [161] : [162] 
    .attribute [160] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     iload_1 
L5:     bipush 13 
L7:     if_icmpge L13 
L10:    bipush 13 
L12:    istore_1 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [29] 
L18:    aload_0 
L19:    iload_1 
L20:    i2f 
L21:    ldc [4] 
L23:    fmul 
L24:    f2i 
L25:    putfield [30] 
L28:    aload_0 
L29:    iload_1 
L30:    anewarray [3] 
L33:    putfield [31] 
L36:    aload_0 
L37:    iload_1 
L38:    newarray int 
L40:    putfield [32] 
L43:    return 
L44:    
    .end code 
.end method 

.method [163] : [164] 
    .attribute [160] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [15] 
L5:     istore_2 
L6:     goto L39 
L9:     aload_0 
L10:    getfield [13] 
L13:    iload_2 
L14:    aaload 
L15:    aload_1 
L16:    invokevirtual [16] 
L19:    ifeq L29 
L22:    aload_0 
L23:    getfield [14] 
L26:    iload_2 
L27:    iaload 
L28:    areturn 
L29:    iload_2 
L30:    iconst_1 
L31:    iadd 
L32:    aload_0 
L33:    getfield [13] 
L36:    arraylength 
L37:    irem 
L38:    istore_2 
L39:    aload_0 
L40:    getfield [13] 
L43:    iload_2 
L44:    aaload 
L45:    ifnonnull L9 
L48:    iconst_m1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method [165] : [166] 
    .attribute [160] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [17] 
L4:     ldc [5] 
L6:     iand 
L7:     aload_0 
L8:     getfield [13] 
L11:    arraylength 
L12:    irem 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method [167] : [168] 
    .attribute [160] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [15] 
L5:     istore_3 
L6:     goto L41 
L9:     aload_0 
L10:    getfield [13] 
L13:    iload_3 
L14:    aaload 
L15:    aload_1 
L16:    invokevirtual [16] 
L19:    ifeq L31 
L22:    aload_0 
L23:    getfield [14] 
L26:    iload_3 
L27:    iload_2 
L28:    dup_x2 
L29:    iastore 
L30:    areturn 
L31:    iload_3 
L32:    iconst_1 
L33:    iadd 
L34:    aload_0 
L35:    getfield [13] 
L38:    arraylength 
L39:    irem 
L40:    istore_3 
L41:    aload_0 
L42:    getfield [13] 
L45:    iload_3 
L46:    aaload 
L47:    ifnonnull L9 
L50:    aload_0 
L51:    getfield [13] 
L54:    iload_3 
L55:    aload_1 
L56:    aastore 
L57:    aload_0 
L58:    getfield [14] 
L61:    iload_3 
L62:    iload_2 
L63:    iastore 
L64:    aload_0 
L65:    dup 
L66:    getfield [11] 
L69:    iconst_1 
L70:    iadd 
L71:    dup_x1 
L72:    putfield [29] 
L75:    aload_0 
L76:    getfield [12] 
L79:    if_icmple L86 
L82:    aload_0 
L83:    invokespecial [25] 
L86:    iload_2 
L87:    areturn 
L88:    
    .end code 
.end method 

.method private [169] : [170] 
    .attribute [160] .code stack 4 locals 2 
L0:     new [28] 
L3:     dup 
L4:     aload_0 
L5:     getfield [13] 
L8:     arraylength 
L9:     iconst_2 
L10:    imul 
L11:    invokespecial [26] 
L14:    astore_1 
L15:    aload_0 
L16:    getfield [13] 
L19:    arraylength 
L20:    istore_2 
L21:    goto L50 
L24:    aload_0 
L25:    getfield [13] 
L28:    iload_2 
L29:    aaload 
L30:    ifnull L50 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [13] 
L38:    iload_2 
L39:    aaload 
L40:    aload_0 
L41:    getfield [14] 
L44:    iload_2 
L45:    iaload 
L46:    invokevirtual [18] 
L49:    pop 
L50:    iinc 2 -1 
L53:    iload_2 
L54:    ifge L24 
L57:    aload_0 
L58:    aload_1 
L59:    getfield [13] 
L62:    putfield [31] 
L65:    aload_0 
L66:    aload_1 
L67:    getfield [14] 
L70:    putfield [32] 
L73:    aload_0 
L74:    aload_1 
L75:    getfield [12] 
L78:    putfield [30] 
L81:    return 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method interface [171] : [172] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [160] .code stack 3 locals 3 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     istore_1 
L5:     new [33] 
L8:     dup 
L9:     invokespecial [27] 
L12:    astore_2 
L13:    aload_2 
L14:    ldc [7] 
L16:    invokevirtual [20] 
L19:    pop 
L20:    iconst_0 
L21:    istore_3 
L22:    goto L74 
L25:    aload_0 
L26:    getfield [13] 
L29:    iload_3 
L30:    aaload 
L31:    ifnull L59 
L34:    aload_2 
L35:    aload_0 
L36:    getfield [13] 
L39:    iload_3 
L40:    aaload 
L41:    invokevirtual [21] 
L44:    ldc [8] 
L46:    invokevirtual [20] 
L49:    aload_0 
L50:    getfield [14] 
L53:    iload_3 
L54:    iaload 
L55:    invokevirtual [22] 
L58:    pop 
L59:    iload_3 
L60:    iload_1 
L61:    if_icmpge L71 
L64:    aload_2 
L65:    ldc [9] 
L67:    invokevirtual [20] 
L70:    pop 
L71:    iinc 3 1 
L74:    iload_3 
L75:    iload_1 
L76:    if_icmplt L25 
L79:    aload_2 
L80:    ldc [10] 
L82:    invokevirtual [20] 
L85:    pop 
L86:    aload_2 
L87:    invokevirtual [23] 
L90:    areturn 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Int -1007343553 
.const [5] = Int -129 
.const [6] = Class [36] 
.const [7] = String [37] 
.const [8] = String [38] 
.const [9] = String [39] 
.const [10] = String [40] 
.const [11] = Field [41] [42] 
.const [12] = Field [43] [44] 
.const [13] = Field [45] [46] 
.const [14] = Field [47] [48] 
.const [15] = Method [49] [50] 
.const [16] = Method [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Class [75] 
.const [29] = Field [76] [77] 
.const [30] = Field [78] [79] 
.const [31] = Field [80] [81] 
.const [32] = Field [82] [83] 
.const [33] = Class [84] 
.const [34] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 java/lang/StringBuffer 
.const [37] = Utf8 '{' 
.const [38] = Utf8 '->' 
.const [39] = Utf8 ', ' 
.const [40] = Utf8 '}' 
.const [41] = Class [85] 
.const [42] = NameAndType [86] [87] 
.const [43] = Class [88] 
.const [44] = NameAndType [89] [90] 
.const [45] = Class [91] 
.const [46] = NameAndType [92] [93] 
.const [47] = Class [94] 
.const [48] = NameAndType [95] [96] 
.const [49] = Class [97] 
.const [50] = NameAndType [98] [99] 
.const [51] = Class [100] 
.const [52] = NameAndType [101] [102] 
.const [53] = Class [103] 
.const [54] = NameAndType [104] [105] 
.const [55] = Class [106] 
.const [56] = NameAndType [107] [108] 
.const [57] = Class [109] 
.const [58] = NameAndType [110] [111] 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Class [118] 
.const [64] = NameAndType [119] [120] 
.const [65] = Class [121] 
.const [66] = NameAndType [122] [123] 
.const [67] = Class [124] 
.const [68] = NameAndType [125] [126] 
.const [69] = Class [127] 
.const [70] = NameAndType [128] [129] 
.const [71] = Class [130] 
.const [72] = NameAndType [131] [132] 
.const [73] = Class [133] 
.const [74] = NameAndType [134] [135] 
.const [75] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [76] = Class [136] 
.const [77] = NameAndType [137] [138] 
.const [78] = Class [139] 
.const [79] = NameAndType [140] [141] 
.const [80] = Class [142] 
.const [81] = NameAndType [143] [144] 
.const [82] = Class [145] 
.const [83] = NameAndType [146] [147] 
.const [84] = Utf8 java/lang/StringBuffer 
.const [85] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [86] = Utf8 elementSize 
.const [87] = Utf8 I 
.const [88] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [89] = Utf8 threshold 
.const [90] = Utf8 I 
.const [91] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [92] = Utf8 keyTable 
.const [93] = Utf8 [Ljava/lang/Object; 
.const [94] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [95] = Utf8 valueTable 
.const [96] = Utf8 [I 
.const [97] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [98] = Utf8 hashCode 
.const [99] = Utf8 (Ljava/lang/Object;)I 
.const [100] = Utf8 java/lang/Object 
.const [101] = Utf8 equals 
.const [102] = Utf8 (Ljava/lang/Object;)Z 
.const [103] = Utf8 java/lang/Object 
.const [104] = Utf8 hashCode 
.const [105] = Utf8 ()I 
.const [106] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [107] = Utf8 put 
.const [108] = Utf8 (Ljava/lang/Object;I)I 
.const [109] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [110] = Utf8 size 
.const [111] = Utf8 ()I 
.const [112] = Utf8 java/lang/StringBuffer 
.const [113] = Utf8 append 
.const [114] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 append 
.const [117] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 toString 
.const [123] = Utf8 ()Ljava/lang/String; 
.const [124] = Utf8 java/lang/Object 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [128] = Utf8 rehash 
.const [129] = Utf8 ()V 
.const [130] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (I)V 
.const [133] = Utf8 java/lang/StringBuffer 
.const [134] = Utf8 <init> 
.const [135] = Utf8 ()V 
.const [136] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [137] = Utf8 elementSize 
.const [138] = Utf8 I 
.const [139] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [140] = Utf8 threshold 
.const [141] = Utf8 I 
.const [142] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [143] = Utf8 keyTable 
.const [144] = Utf8 [Ljava/lang/Object; 
.const [145] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [146] = Utf8 valueTable 
.const [147] = Utf8 [I 
.const [148] = Utf8 com/ibm/oti/lang/reflect/ProxyObjectCache 
.const [149] = Class [148] 
.const [150] = Utf8 java/lang/Object 
.const [151] = Class [150] 
.const [152] = Utf8 keyTable 
.const [153] = Utf8 [Ljava/lang/Object; 
.const [154] = Utf8 valueTable 
.const [155] = Utf8 [I 
.const [156] = Utf8 elementSize 
.const [157] = Utf8 I 
.const [158] = Utf8 threshold 
.const [159] = Utf8 I 
.const [160] = Utf8 Code 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (I)V 
.const [163] = Utf8 get 
.const [164] = Utf8 (Ljava/lang/Object;)I 
.const [165] = Utf8 hashCode 
.const [166] = Utf8 (Ljava/lang/Object;)I 
.const [167] = Utf8 put 
.const [168] = Utf8 (Ljava/lang/Object;I)I 
.const [169] = Utf8 rehash 
.const [170] = Utf8 ()V 
.const [171] = Utf8 size 
.const [172] = Utf8 ()I 
.const [173] = Utf8 toString 
.const [174] = Utf8 ()Ljava/lang/String; 
.end class 
