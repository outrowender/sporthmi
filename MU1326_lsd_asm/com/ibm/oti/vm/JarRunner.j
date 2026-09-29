.version 50 0 
.class public super [145] 
.super [147] 

.method public annotation [149] : [150] 
    .attribute [148] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [151] : [152] 
    .attribute [148] .code stack 6 locals 7 
L0:     aload_0 
L1:     iconst_0 
L2:     aaload 
L3:     invokestatic [4] 
L6:     astore_1 
L7:     aload_1 
L8:     ifnonnull L26 
L11:    getstatic [6] 
L14:    ldc [7] 
L16:    aload_0 
L17:    iconst_0 
L18:    aaload 
L19:    invokestatic [9] 
L22:    invokevirtual [26] 
L25:    return 
L26:    aload_1 
L27:    invokestatic [11] 
L30:    astore_2 
L31:    aload_2 
L32:    ifnonnull L50 
L35:    getstatic [6] 
L38:    ldc [12] 
L40:    aload_0 
L41:    iconst_0 
L42:    aaload 
L43:    invokestatic [9] 
L46:    invokevirtual [26] 
L49:    return 
L50:    aload_2 
L51:    iconst_1 
L52:    invokestatic [14] 
L55:    invokestatic [16] 
L58:    astore_3 
L59:    iconst_1 
L60:    anewarray [15] 
L63:    astore 4 
L65:    aload 4 
L67:    iconst_0 
L68:    aload_0 
L69:    invokespecial [34] 
L72:    aastore 
L73:    aload_3 
L74:    ldc [17] 
L76:    aload 4 
L78:    invokevirtual [27] 
L81:    astore 5 
L83:    iconst_1 
L84:    anewarray [3] 
L87:    astore 6 
L89:    aload_0 
L90:    arraylength 
L91:    iconst_1 
L92:    isub 
L93:    anewarray [18] 
L96:    astore 7 
L98:    aload_0 
L99:    iconst_1 
L100:   aload 7 
L102:   iconst_0 
L103:   aload_0 
L104:   arraylength 
L105:   iconst_1 
L106:   isub 
L107:   invokestatic [19] 
L110:   aload 6 
L112:   iconst_0 
L113:   aload 7 
L115:   aastore 
L116:   aload 5 
L118:   aconst_null 
L119:   aload 6 
L121:   invokevirtual [28] 
L124:   pop 
L125:   return 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method private static [153] : [154] 
    .attribute [148] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     astore_1 
L5:     aload_1 
L6:     getstatic [23] 
L9:     invokevirtual [30] 
L12:    astore_2 
L13:    aload_2 
L14:    ifnull L26 
L17:    aload_2 
L18:    bipush 47 
L20:    bipush 46 
L22:    invokevirtual [31] 
L25:    astore_2 
L26:    aload_2 
L27:    areturn 
L28:    
    .end code 
.end method 

.method private static [155] : [156] 
    .attribute [148] .code stack 3 locals 1 
L0:     new [36] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [35] 
L8:     astore_1 
L9:     aload_1 
L10:    invokevirtual [32] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = Class [38] 
.const [4] = Method [39] [40] 
.const [5] = Class [41] 
.const [6] = Field [42] [43] 
.const [7] = String [44] 
.const [8] = Class [45] 
.const [9] = Method [46] [47] 
.const [10] = Class [48] 
.const [11] = Method [49] [50] 
.const [12] = String [51] 
.const [13] = Class [52] 
.const [14] = Method [53] [54] 
.const [15] = Class [55] 
.const [16] = Method [56] [57] 
.const [17] = String [58] 
.const [18] = Class [59] 
.const [19] = Method [60] [61] 
.const [20] = Class [62] 
.const [21] = Class [63] 
.const [22] = Class [64] 
.const [23] = Field [65] [66] 
.const [24] = Class [67] 
.const [25] = Class [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Method [81] [82] 
.const [33] = Method [83] [84] 
.const [34] = Method [85] [86] 
.const [35] = Method [87] [88] 
.const [36] = Class [89] 
.const [37] = Utf8 com/ibm/oti/vm/JarRunner 
.const [38] = Utf8 java/lang/Object 
.const [39] = Class [90] 
.const [40] = NameAndType [91] [92] 
.const [41] = Utf8 java/lang/System 
.const [42] = Class [93] 
.const [43] = NameAndType [94] [95] 
.const [44] = Utf8 K0222 
.const [45] = Utf8 com/ibm/oti/util/Msg 
.const [46] = Class [96] 
.const [47] = NameAndType [97] [98] 
.const [48] = Utf8 java/io/PrintStream 
.const [49] = Class [99] 
.const [50] = NameAndType [100] [101] 
.const [51] = Utf8 K01c6 
.const [52] = Utf8 java/lang/ClassLoader 
.const [53] = Class [102] 
.const [54] = NameAndType [103] [104] 
.const [55] = Utf8 java/lang/Class 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Utf8 main 
.const [59] = Utf8 java/lang/String 
.const [60] = Class [108] 
.const [61] = NameAndType [109] [110] 
.const [62] = Utf8 java/lang/reflect/Method 
.const [63] = Utf8 java/util/jar/Manifest 
.const [64] = Utf8 java/util/jar/Attributes$Name 
.const [65] = Class [111] 
.const [66] = NameAndType [112] [113] 
.const [67] = Utf8 java/util/jar/Attributes 
.const [68] = Utf8 java/util/jar/JarFile 
.const [69] = Class [114] 
.const [70] = NameAndType [115] [116] 
.const [71] = Class [117] 
.const [72] = NameAndType [118] [119] 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Class [129] 
.const [80] = NameAndType [130] [131] 
.const [81] = Class [132] 
.const [82] = NameAndType [133] [134] 
.const [83] = Class [135] 
.const [84] = NameAndType [136] [137] 
.const [85] = Class [138] 
.const [86] = NameAndType [139] [140] 
.const [87] = Class [141] 
.const [88] = NameAndType [142] [143] 
.const [89] = Utf8 java/util/jar/JarFile 
.const [90] = Utf8 com/ibm/oti/vm/JarRunner 
.const [91] = Utf8 getManifest 
.const [92] = Utf8 (Ljava/lang/String;)Ljava/util/jar/Manifest; 
.const [93] = Utf8 java/lang/System 
.const [94] = Utf8 err 
.const [95] = Utf8 Ljava/io/PrintStream; 
.const [96] = Utf8 com/ibm/oti/util/Msg 
.const [97] = Utf8 getString 
.const [98] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String; 
.const [99] = Utf8 com/ibm/oti/vm/JarRunner 
.const [100] = Utf8 mainClassName 
.const [101] = Utf8 (Ljava/util/jar/Manifest;)Ljava/lang/String; 
.const [102] = Utf8 java/lang/ClassLoader 
.const [103] = Utf8 getSystemClassLoader 
.const [104] = Utf8 ()Ljava/lang/ClassLoader; 
.const [105] = Utf8 java/lang/Class 
.const [106] = Utf8 forName 
.const [107] = Utf8 (Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class; 
.const [108] = Utf8 java/lang/System 
.const [109] = Utf8 arraycopy 
.const [110] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [111] = Utf8 java/util/jar/Attributes$Name 
.const [112] = Utf8 MAIN_CLASS 
.const [113] = Utf8 Ljava/util/jar/Attributes$Name; 
.const [114] = Utf8 java/io/PrintStream 
.const [115] = Utf8 println 
.const [116] = Utf8 (Ljava/lang/String;)V 
.const [117] = Utf8 java/lang/Class 
.const [118] = Utf8 getMethod 
.const [119] = Utf8 (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; 
.const [120] = Utf8 java/lang/reflect/Method 
.const [121] = Utf8 invoke 
.const [122] = Utf8 (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; 
.const [123] = Utf8 java/util/jar/Manifest 
.const [124] = Utf8 getMainAttributes 
.const [125] = Utf8 ()Ljava/util/jar/Attributes; 
.const [126] = Utf8 java/util/jar/Attributes 
.const [127] = Utf8 getValue 
.const [128] = Utf8 (Ljava/util/jar/Attributes$Name;)Ljava/lang/String; 
.const [129] = Utf8 java/lang/String 
.const [130] = Utf8 replace 
.const [131] = Utf8 (CC)Ljava/lang/String; 
.const [132] = Utf8 java/util/jar/JarFile 
.const [133] = Utf8 getManifest 
.const [134] = Utf8 ()Ljava/util/jar/Manifest; 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 java/lang/Object 
.const [139] = Utf8 getClass 
.const [140] = Utf8 ()Ljava/lang/Class; 
.const [141] = Utf8 java/util/jar/JarFile 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Ljava/lang/String;)V 
.const [144] = Utf8 com/ibm/oti/vm/JarRunner 
.const [145] = Class [144] 
.const [146] = Utf8 java/lang/Object 
.const [147] = Class [146] 
.const [148] = Utf8 Code 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 main 
.const [152] = Utf8 ([Ljava/lang/String;)V 
.const [153] = Utf8 mainClassName 
.const [154] = Utf8 (Ljava/util/jar/Manifest;)Ljava/lang/String; 
.const [155] = Utf8 getManifest 
.const [156] = Utf8 (Ljava/lang/String;)Ljava/util/jar/Manifest; 
.end class 
