.version 50 0 
.class public super [131] 
.super [133] 
.implements [135] 
.field public [136] [137] 
.field public [138] [139] 
.field public [140] [141] 
.field public [142] [143] 

.method public [145] : [146] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     invokevirtual [10] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     aload_2 
L7:     aload_3 
L8:     aload 4 
L10:    invokevirtual [11] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     getfield [13] 
L5:     putfield [24] 
L8:     aload_0 
L9:     aload_1 
L10:    getfield [14] 
L13:    putfield [25] 
L16:    aload_0 
L17:    aload_1 
L18:    getfield [15] 
L21:    putfield [26] 
L24:    aload_0 
L25:    aload_1 
L26:    getfield [16] 
L29:    putfield [27] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [24] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [25] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [26] 
L15:    aload_0 
L16:    aload 4 
L18:    putfield [27] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [24] 
L5:     aload_0 
L6:     aconst_null 
L7:     putfield [25] 
L10:    aload_0 
L11:    aconst_null 
L12:    putfield [26] 
L15:    aload_0 
L16:    aconst_null 
L17:    putfield [27] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [144] .code stack 3 locals 0 
L0:     new [28] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [22] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnull L34 
L7:     aload_0 
L8:     getfield [16] 
L11:    invokevirtual [17] 
L14:    aload_0 
L15:    getfield [14] 
L18:    ifnull L31 
L21:    aload_0 
L22:    getfield [14] 
L25:    invokevirtual [17] 
L28:    goto L32 
L31:    iconst_0 
L32:    iadd 
L33:    areturn 
L34:    aload_0 
L35:    getfield [15] 
L38:    ifnull L51 
L41:    aload_0 
L42:    getfield [15] 
L45:    invokevirtual [17] 
L48:    goto L52 
L51:    iconst_0 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [144] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [2] 
L4:     ifeq L71 
L7:     aload_1 
L8:     checkcast [2] 
L11:    astore_2 
L12:    aload_2 
L13:    getfield [16] 
L16:    ifnull L47 
L19:    aload_0 
L20:    getfield [16] 
L23:    aload_2 
L24:    getfield [16] 
L27:    if_acmpne L45 
L30:    aload_0 
L31:    getfield [14] 
L34:    aload_2 
L35:    getfield [14] 
L38:    if_acmpne L45 
L41:    iconst_1 
L42:    goto L46 
L45:    iconst_0 
L46:    areturn 
L47:    aload_0 
L48:    getfield [16] 
L51:    ifnonnull L71 
L54:    aload_0 
L55:    getfield [15] 
L58:    aload_2 
L59:    getfield [15] 
L62:    if_acmpne L69 
L65:    iconst_1 
L66:    goto L70 
L69:    iconst_0 
L70:    areturn 
L71:    iconst_0 
L72:    areturn 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [144] .code stack 2 locals 2 
L0:     new [29] 
L3:     dup 
L4:     invokespecial [23] 
L7:     astore_1 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [13] 
L14:    ifnull L38 
L17:    aload_1 
L18:    ldc [4] 
L20:    invokevirtual [18] 
L23:    aload_0 
L24:    getfield [13] 
L27:    invokevirtual [18] 
L30:    bipush 34 
L32:    invokevirtual [19] 
L35:    pop 
L36:    iconst_1 
L37:    istore_2 
L38:    aload_0 
L39:    getfield [14] 
L42:    ifnull L77 
L45:    iload_2 
L46:    ifeq L56 
L49:    aload_1 
L50:    bipush 44 
L52:    invokevirtual [19] 
L55:    pop 
L56:    aload_1 
L57:    ldc [5] 
L59:    invokevirtual [18] 
L62:    aload_0 
L63:    getfield [14] 
L66:    invokevirtual [18] 
L69:    bipush 34 
L71:    invokevirtual [19] 
L74:    pop 
L75:    iconst_1 
L76:    istore_2 
L77:    aload_0 
L78:    getfield [15] 
L81:    ifnull L116 
L84:    iload_2 
L85:    ifeq L95 
L88:    aload_1 
L89:    bipush 44 
L91:    invokevirtual [19] 
L94:    pop 
L95:    aload_1 
L96:    ldc [6] 
L98:    invokevirtual [18] 
L101:   aload_0 
L102:   getfield [15] 
L105:   invokevirtual [18] 
L108:   bipush 34 
L110:   invokevirtual [19] 
L113:   pop 
L114:   iconst_1 
L115:   istore_2 
L116:   aload_0 
L117:   getfield [16] 
L120:   ifnull L153 
L123:   iload_2 
L124:   ifeq L134 
L127:   aload_1 
L128:   bipush 44 
L130:   invokevirtual [19] 
L133:   pop 
L134:   aload_1 
L135:   ldc [7] 
L137:   invokevirtual [18] 
L140:   aload_0 
L141:   getfield [16] 
L144:   invokevirtual [18] 
L147:   bipush 34 
L149:   invokevirtual [19] 
L152:   pop 
L153:   aload_1 
L154:   invokevirtual [20] 
L157:   areturn 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = Class [31] 
.const [4] = String [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Method [38] [39] 
.const [11] = Method [40] [41] 
.const [12] = Method [42] [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Field [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = Field [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Field [72] [73] 
.const [28] = Class [74] 
.const [29] = Class [75] 
.const [30] = Utf8 org/apache/xerces/xni/QName 
.const [31] = Utf8 java/lang/StringBuffer 
.const [32] = Utf8 'prefix="' 
.const [33] = Utf8 'localpart="' 
.const [34] = Utf8 'rawname="' 
.const [35] = Utf8 'uri="' 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 java/lang/String 
.const [38] = Class [76] 
.const [39] = NameAndType [77] [78] 
.const [40] = Class [79] 
.const [41] = NameAndType [80] [81] 
.const [42] = Class [82] 
.const [43] = NameAndType [83] [84] 
.const [44] = Class [85] 
.const [45] = NameAndType [86] [87] 
.const [46] = Class [88] 
.const [47] = NameAndType [89] [90] 
.const [48] = Class [91] 
.const [49] = NameAndType [92] [93] 
.const [50] = Class [94] 
.const [51] = NameAndType [95] [96] 
.const [52] = Class [97] 
.const [53] = NameAndType [98] [99] 
.const [54] = Class [100] 
.const [55] = NameAndType [101] [102] 
.const [56] = Class [103] 
.const [57] = NameAndType [104] [105] 
.const [58] = Class [106] 
.const [59] = NameAndType [107] [108] 
.const [60] = Class [109] 
.const [61] = NameAndType [110] [111] 
.const [62] = Class [112] 
.const [63] = NameAndType [113] [114] 
.const [64] = Class [115] 
.const [65] = NameAndType [116] [117] 
.const [66] = Class [118] 
.const [67] = NameAndType [119] [120] 
.const [68] = Class [121] 
.const [69] = NameAndType [122] [123] 
.const [70] = Class [124] 
.const [71] = NameAndType [125] [126] 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Utf8 org/apache/xerces/xni/QName 
.const [75] = Utf8 java/lang/StringBuffer 
.const [76] = Utf8 org/apache/xerces/xni/QName 
.const [77] = Utf8 clear 
.const [78] = Utf8 ()V 
.const [79] = Utf8 org/apache/xerces/xni/QName 
.const [80] = Utf8 setValues 
.const [81] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [82] = Utf8 org/apache/xerces/xni/QName 
.const [83] = Utf8 setValues 
.const [84] = Utf8 (Lorg/apache/xerces/xni/QName;)V 
.const [85] = Utf8 org/apache/xerces/xni/QName 
.const [86] = Utf8 prefix 
.const [87] = Utf8 Ljava/lang/String; 
.const [88] = Utf8 org/apache/xerces/xni/QName 
.const [89] = Utf8 localpart 
.const [90] = Utf8 Ljava/lang/String; 
.const [91] = Utf8 org/apache/xerces/xni/QName 
.const [92] = Utf8 rawname 
.const [93] = Utf8 Ljava/lang/String; 
.const [94] = Utf8 org/apache/xerces/xni/QName 
.const [95] = Utf8 uri 
.const [96] = Utf8 Ljava/lang/String; 
.const [97] = Utf8 java/lang/String 
.const [98] = Utf8 hashCode 
.const [99] = Utf8 ()I 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 append 
.const [102] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [103] = Utf8 java/lang/StringBuffer 
.const [104] = Utf8 append 
.const [105] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Utf8 toString 
.const [108] = Utf8 ()Ljava/lang/String; 
.const [109] = Utf8 java/lang/Object 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 org/apache/xerces/xni/QName 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lorg/apache/xerces/xni/QName;)V 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 <init> 
.const [117] = Utf8 ()V 
.const [118] = Utf8 org/apache/xerces/xni/QName 
.const [119] = Utf8 prefix 
.const [120] = Utf8 Ljava/lang/String; 
.const [121] = Utf8 org/apache/xerces/xni/QName 
.const [122] = Utf8 localpart 
.const [123] = Utf8 Ljava/lang/String; 
.const [124] = Utf8 org/apache/xerces/xni/QName 
.const [125] = Utf8 rawname 
.const [126] = Utf8 Ljava/lang/String; 
.const [127] = Utf8 org/apache/xerces/xni/QName 
.const [128] = Utf8 uri 
.const [129] = Utf8 Ljava/lang/String; 
.const [130] = Utf8 org/apache/xerces/xni/QName 
.const [131] = Class [130] 
.const [132] = Utf8 java/lang/Object 
.const [133] = Class [132] 
.const [134] = Utf8 java/lang/Cloneable 
.const [135] = Class [134] 
.const [136] = Utf8 prefix 
.const [137] = Utf8 Ljava/lang/String; 
.const [138] = Utf8 localpart 
.const [139] = Utf8 Ljava/lang/String; 
.const [140] = Utf8 rawname 
.const [141] = Utf8 Ljava/lang/String; 
.const [142] = Utf8 uri 
.const [143] = Utf8 Ljava/lang/String; 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lorg/apache/xerces/xni/QName;)V 
.const [151] = Utf8 setValues 
.const [152] = Utf8 (Lorg/apache/xerces/xni/QName;)V 
.const [153] = Utf8 setValues 
.const [154] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [155] = Utf8 clear 
.const [156] = Utf8 ()V 
.const [157] = Utf8 clone 
.const [158] = Utf8 ()Ljava/lang/Object; 
.const [159] = Utf8 hashCode 
.const [160] = Utf8 ()I 
.const [161] = Utf8 equals 
.const [162] = Utf8 (Ljava/lang/Object;)Z 
.const [163] = Utf8 toString 
.const [164] = Utf8 ()Ljava/lang/String; 
.end class 
