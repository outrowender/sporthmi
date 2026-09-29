.version 50 0 
.class public super [161] 
.super [163] 

.method public annotation [165] : [166] 
    .attribute [164] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [167] : [168] 
    .attribute [164] .code stack 3 locals 3 
        .catch [6] from L0 to L39 using L42 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     astore_2 
L5:     aload_2 
L6:     aload_1 
L7:     aconst_null 
L8:     checkcast [3] 
L11:    invokevirtual [26] 
L14:    astore_3 
L15:    aload_3 
L16:    aconst_null 
L17:    aconst_null 
L18:    checkcast [4] 
L21:    invokevirtual [27] 
L24:    astore 4 
L26:    aload 4 
L28:    instanceof [5] 
L31:    ifeq L40 
L34:    aload 4 
L36:    checkcast [5] 
L39:    areturn 
        .catch [6] from L40 to L41 using L42 
L40:    aconst_null 
L41:    areturn 
L42:    astore_2 
L43:    aconst_null 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public static [169] : [170] 
    .attribute [164] .code stack 5 locals 10 
        .catch [6] from L0 to L125 using L126 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     astore_1 
L5:     aload_1 
L6:     invokevirtual [28] 
L9:     astore_2 
L10:    new [41] 
L13:    dup 
L14:    invokespecial [39] 
L17:    astore_3 
L18:    iconst_0 
L19:    istore 4 
L21:    iload 4 
L23:    aload_2 
L24:    arraylength 
L25:    if_icmpge L107 
L28:    aload_2 
L29:    iload 4 
L31:    aaload 
L32:    astore 5 
L34:    aload 5 
L36:    invokevirtual [29] 
L39:    istore 6 
L41:    bipush 25 
L43:    istore 7 
L45:    iload 6 
L47:    iload 7 
L49:    iand 
L50:    iload 7 
L52:    if_icmpne L101 
L55:    aload 5 
L57:    invokevirtual [30] 
L60:    astore 8 
L62:    aload 5 
L64:    aconst_null 
L65:    invokevirtual [31] 
L68:    astore 9 
L70:    aload 9 
L72:    instanceof [5] 
L75:    ifeq L101 
L78:    aload 9 
L80:    checkcast [5] 
L83:    astore 10 
L85:    aload_3 
L86:    new [42] 
L89:    dup 
L90:    aload 8 
L92:    aload 10 
L94:    invokespecial [40] 
L97:    invokevirtual [32] 
L100:   pop 
L101:   iinc 4 1 
L104:   goto L21 
L107:   aload_3 
L108:   invokevirtual [33] 
L111:   anewarray [8] 
L114:   astore 4 
L116:   aload_3 
L117:   aload 4 
L119:   invokevirtual [34] 
L122:   pop 
L123:   aload 4 
L125:   areturn 
L126:   astore_1 
L127:   aconst_null 
L128:   areturn 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public static [171] : [172] 
    .attribute [164] .code stack 2 locals 3 
L0:     aload_0 
L1:     invokestatic [9] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnonnull L11 
L9:     aconst_null 
L10:    areturn 
L11:    iconst_0 
L12:    istore_3 
L13:    iload_3 
L14:    aload_2 
L15:    arraylength 
L16:    if_icmpge L48 
L19:    aload_2 
L20:    iload_3 
L21:    aaload 
L22:    astore 4 
L24:    aload 4 
L26:    invokevirtual [35] 
L29:    aload_1 
L30:    invokevirtual [36] 
L33:    ifeq L42 
L36:    aload 4 
L38:    invokevirtual [37] 
L41:    areturn 
L42:    iinc 3 1 
L45:    goto L13 
L48:    aconst_null 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [173] : [174] 
    .attribute [164] .code stack 2 locals 0 
L0:     ldc [10] 
L2:     ldc [11] 
L4:     invokestatic [12] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [175] : [176] 
    .attribute [164] .code stack 2 locals 0 
L0:     ldc [13] 
L2:     ldc [14] 
L4:     invokestatic [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [177] : [178] 
    .attribute [164] .code stack 2 locals 0 
L0:     ldc [13] 
L2:     ldc [16] 
L4:     invokestatic [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [179] : [180] 
    .attribute [164] .code stack 2 locals 0 
L0:     ldc [13] 
L2:     ldc [17] 
L4:     invokestatic [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [181] : [182] 
    .attribute [164] .code stack 2 locals 0 
L0:     ldc [13] 
L2:     ldc [18] 
L4:     invokestatic [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [183] : [184] 
    .attribute [164] .code stack 2 locals 0 
L0:     ldc [13] 
L2:     ldc [19] 
L4:     invokestatic [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [185] : [186] 
    .attribute [164] .code stack 2 locals 0 
L0:     ldc [13] 
L2:     ldc [20] 
L4:     invokestatic [15] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [43] [44] 
.const [3] = Class [45] 
.const [4] = Class [46] 
.const [5] = Class [47] 
.const [6] = Class [48] 
.const [7] = Class [49] 
.const [8] = Class [50] 
.const [9] = Method [51] [52] 
.const [10] = String [53] 
.const [11] = String [54] 
.const [12] = Method [55] [56] 
.const [13] = String [57] 
.const [14] = String [58] 
.const [15] = Method [59] [60] 
.const [16] = String [61] 
.const [17] = String [62] 
.const [18] = String [63] 
.const [19] = String [64] 
.const [20] = String [65] 
.const [21] = Class [66] 
.const [22] = Class [67] 
.const [23] = Class [68] 
.const [24] = Class [69] 
.const [25] = Class [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Method [85] [86] 
.const [34] = Method [87] [88] 
.const [35] = Method [89] [90] 
.const [36] = Method [91] [92] 
.const [37] = Method [93] [94] 
.const [38] = Method [95] [96] 
.const [39] = Method [97] [98] 
.const [40] = Method [99] [100] 
.const [41] = Class [101] 
.const [42] = Class [102] 
.const [43] = Class [103] 
.const [44] = NameAndType [104] [105] 
.const [45] = Utf8 [Ljava/lang/Class; 
.const [46] = Utf8 [Ljava/lang/Object; 
.const [47] = Utf8 java/lang/String 
.const [48] = Utf8 java/lang/Throwable 
.const [49] = Utf8 java/util/ArrayList 
.const [50] = Utf8 de/esolutions/fw/util/commons/version/VersionTag 
.const [51] = Class [106] 
.const [52] = NameAndType [107] [108] 
.const [53] = Utf8 'de.esolutions.fw.util.commons.version.VersionInfo' 
.const [54] = Utf8 FRAMEWORK_VERSION 
.const [55] = Class [109] 
.const [56] = NameAndType [110] [111] 
.const [57] = Utf8 'org.dsi.ifc.VersionInfo' 
.const [58] = Utf8 asString 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Utf8 getBuildDate 
.const [62] = Utf8 getVersion 
.const [63] = Utf8 getNickname 
.const [64] = Utf8 getName 
.const [65] = Utf8 getVendor 
.const [66] = Utf8 de/esolutions/fw/util/commons/version/RuntimeVersion 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 java/lang/Class 
.const [69] = Utf8 java/lang/reflect/Method 
.const [70] = Utf8 java/lang/reflect/Field 
.const [71] = Class [115] 
.const [72] = NameAndType [116] [117] 
.const [73] = Class [118] 
.const [74] = NameAndType [119] [120] 
.const [75] = Class [121] 
.const [76] = NameAndType [122] [123] 
.const [77] = Class [124] 
.const [78] = NameAndType [125] [126] 
.const [79] = Class [127] 
.const [80] = NameAndType [128] [129] 
.const [81] = Class [130] 
.const [82] = NameAndType [131] [132] 
.const [83] = Class [133] 
.const [84] = NameAndType [134] [135] 
.const [85] = Class [136] 
.const [86] = NameAndType [137] [138] 
.const [87] = Class [139] 
.const [88] = NameAndType [140] [141] 
.const [89] = Class [142] 
.const [90] = NameAndType [143] [144] 
.const [91] = Class [145] 
.const [92] = NameAndType [146] [147] 
.const [93] = Class [148] 
.const [94] = NameAndType [149] [150] 
.const [95] = Class [151] 
.const [96] = NameAndType [152] [153] 
.const [97] = Class [154] 
.const [98] = NameAndType [155] [156] 
.const [99] = Class [157] 
.const [100] = NameAndType [158] [159] 
.const [101] = Utf8 java/util/ArrayList 
.const [102] = Utf8 de/esolutions/fw/util/commons/version/VersionTag 
.const [103] = Utf8 java/lang/Class 
.const [104] = Utf8 forName 
.const [105] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [106] = Utf8 de/esolutions/fw/util/commons/version/RuntimeVersion 
.const [107] = Utf8 getAllVersionTagsFromClass 
.const [108] = Utf8 (Ljava/lang/String;)[Lde/esolutions/fw/util/commons/version/VersionTag; 
.const [109] = Utf8 de/esolutions/fw/util/commons/version/RuntimeVersion 
.const [110] = Utf8 getVersionTagFromClass 
.const [111] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [112] = Utf8 de/esolutions/fw/util/commons/version/RuntimeVersion 
.const [113] = Utf8 getVersionFromClassAndGetter 
.const [114] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [115] = Utf8 java/lang/Class 
.const [116] = Utf8 getMethod 
.const [117] = Utf8 (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; 
.const [118] = Utf8 java/lang/reflect/Method 
.const [119] = Utf8 invoke 
.const [120] = Utf8 (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; 
.const [121] = Utf8 java/lang/Class 
.const [122] = Utf8 getFields 
.const [123] = Utf8 ()[Ljava/lang/reflect/Field; 
.const [124] = Utf8 java/lang/reflect/Field 
.const [125] = Utf8 getModifiers 
.const [126] = Utf8 ()I 
.const [127] = Utf8 java/lang/reflect/Field 
.const [128] = Utf8 getName 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 java/lang/reflect/Field 
.const [131] = Utf8 get 
.const [132] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [133] = Utf8 java/util/ArrayList 
.const [134] = Utf8 add 
.const [135] = Utf8 (Ljava/lang/Object;)Z 
.const [136] = Utf8 java/util/ArrayList 
.const [137] = Utf8 size 
.const [138] = Utf8 ()I 
.const [139] = Utf8 java/util/ArrayList 
.const [140] = Utf8 toArray 
.const [141] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [142] = Utf8 de/esolutions/fw/util/commons/version/VersionTag 
.const [143] = Utf8 getName 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 java/lang/String 
.const [146] = Utf8 equals 
.const [147] = Utf8 (Ljava/lang/Object;)Z 
.const [148] = Utf8 de/esolutions/fw/util/commons/version/VersionTag 
.const [149] = Utf8 getValue 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 java/lang/Object 
.const [152] = Utf8 <init> 
.const [153] = Utf8 ()V 
.const [154] = Utf8 java/util/ArrayList 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/util/commons/version/VersionTag 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [160] = Utf8 de/esolutions/fw/util/commons/version/RuntimeVersion 
.const [161] = Class [160] 
.const [162] = Utf8 java/lang/Object 
.const [163] = Class [162] 
.const [164] = Utf8 Code 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 getVersionFromClassAndGetter 
.const [168] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [169] = Utf8 getAllVersionTagsFromClass 
.const [170] = Utf8 (Ljava/lang/String;)[Lde/esolutions/fw/util/commons/version/VersionTag; 
.const [171] = Utf8 getVersionTagFromClass 
.const [172] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [173] = Utf8 getFWVersion 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 getDSIifcFullVersion 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 getDSIifcBuildDate 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 getDSIifcVersion 
.const [180] = Utf8 ()Ljava/lang/String; 
.const [181] = Utf8 getDSIifcNickname 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 getDSIifcName 
.const [184] = Utf8 ()Ljava/lang/String; 
.const [185] = Utf8 getDSIifcVendor 
.const [186] = Utf8 ()Ljava/lang/String; 
.end class 
