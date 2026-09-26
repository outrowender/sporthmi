.version 50 0 
.class public super [159] 
.super [161] 
.field private [162] [163] 
.field private static [164] [165] 

.method static [167] : [168] 
    .attribute [166] .code stack 3 locals 0 
L0:     new [33] 
L3:     dup 
L4:     bipush 10 
L6:     invokespecial [27] 
L9:     putstatic [28] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     invokespecial [29] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [166] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [30] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [34] 
L10:    ldc [6] 
L12:    ldc [7] 
L14:    invokestatic [9] 
L17:    astore_2 
L18:    aload_0 
L19:    aload_2 
L20:    invokevirtual [20] 
L23:    astore_2 
L24:    aload_0 
L25:    aload_2 
L26:    invokestatic [11] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method [173] : [174] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     invokespecial [30] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [34] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [175] : [176] 
    .attribute [166] .code stack 3 locals 3 
L0:     aload_1 
L1:     aload_0 
L2:     invokestatic [13] 
L5:     astore_2 
L6:     aload_2 
L7:     ifnonnull L19 
L10:    new [35] 
L13:    dup 
L14:    aload_1 
L15:    invokespecial [31] 
L18:    athrow 
L19:    aload_2 
L20:    invokestatic [14] 
L23:    istore_3 
L24:    aload_0 
L25:    aload_2 
L26:    invokevirtual [21] 
L29:    astore 4 
L31:    aload 4 
L33:    ifnull L43 
L36:    aload_0 
L37:    aload 4 
L39:    iload_3 
L40:    invokevirtual [22] 
L43:    aload_2 
L44:    aload_0 
L45:    iload_3 
L46:    invokevirtual [23] 
L49:    invokestatic [15] 
L52:    aload_2 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method [177] : [178] 
    .attribute [166] .code stack 1 locals 0 
L0:     getstatic [5] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method protected synchronized [179] : [180] 
    .attribute [166] .code stack 4 locals 3 
L0:     invokestatic [16] 
L3:     astore_3 
L4:     aload_3 
L5:     ifnull L62 
L8:     aload_0 
L9:     getfield [19] 
L12:    ifne L62 
L15:    aload_1 
L16:    bipush 46 
L18:    invokevirtual [24] 
L21:    istore 4 
L23:    iload 4 
L25:    ifle L62 
        .catch [0] from L28 to L47 using L47 
L28:    aload_0 
L29:    iconst_1 
L30:    putfield [34] 
L33:    aload_3 
L34:    aload_1 
L35:    iconst_0 
L36:    iload 4 
L38:    invokevirtual [25] 
L41:    invokevirtual [26] 
L44:    goto L57 
L47:    astore 5 
L49:    aload_0 
L50:    iconst_0 
L51:    putfield [34] 
L54:    aload 5 
L56:    athrow 
L57:    aload_0 
L58:    iconst_0 
L59:    putfield [34] 
L62:    aload_0 
L63:    aload_1 
L64:    iload_2 
L65:    invokespecial [32] 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = Class [37] 
.const [4] = Class [38] 
.const [5] = Field [39] [40] 
.const [6] = String [41] 
.const [7] = String [42] 
.const [8] = Class [43] 
.const [9] = Method [44] [45] 
.const [10] = Class [46] 
.const [11] = Method [47] [48] 
.const [12] = Class [49] 
.const [13] = Method [50] [51] 
.const [14] = Method [52] [53] 
.const [15] = Method [54] [55] 
.const [16] = Method [56] [57] 
.const [17] = Class [58] 
.const [18] = Class [59] 
.const [19] = Field [60] [61] 
.const [20] = Method [62] [63] 
.const [21] = Method [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Field [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Class [88] 
.const [34] = Field [89] [90] 
.const [35] = Class [91] 
.const [36] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [37] = Utf8 com/ibm/oti/vm/AbstractClassLoader 
.const [38] = Utf8 java/util/Hashtable 
.const [39] = Class [92] 
.const [40] = NameAndType [93] [94] 
.const [41] = Utf8 'java.class.path' 
.const [42] = Utf8 '.' 
.const [43] = Utf8 java/lang/System 
.const [44] = Class [95] 
.const [45] = NameAndType [96] [97] 
.const [46] = Utf8 com/ibm/oti/vm/VM 
.const [47] = Class [98] 
.const [48] = NameAndType [99] [100] 
.const [49] = Utf8 java/lang/ClassNotFoundException 
.const [50] = Class [101] 
.const [51] = NameAndType [102] [103] 
.const [52] = Class [104] 
.const [53] = NameAndType [105] [106] 
.const [54] = Class [107] 
.const [55] = NameAndType [108] [109] 
.const [56] = Class [110] 
.const [57] = NameAndType [111] [112] 
.const [58] = Utf8 java/lang/String 
.const [59] = Utf8 java/lang/SecurityManager 
.const [60] = Class [113] 
.const [61] = NameAndType [114] [115] 
.const [62] = Class [116] 
.const [63] = NameAndType [117] [118] 
.const [64] = Class [119] 
.const [65] = NameAndType [120] [121] 
.const [66] = Class [122] 
.const [67] = NameAndType [123] [124] 
.const [68] = Class [125] 
.const [69] = NameAndType [126] [127] 
.const [70] = Class [128] 
.const [71] = NameAndType [129] [130] 
.const [72] = Class [131] 
.const [73] = NameAndType [132] [133] 
.const [74] = Class [134] 
.const [75] = NameAndType [135] [136] 
.const [76] = Class [137] 
.const [77] = NameAndType [138] [139] 
.const [78] = Class [140] 
.const [79] = NameAndType [141] [142] 
.const [80] = Class [143] 
.const [81] = NameAndType [144] [145] 
.const [82] = Class [146] 
.const [83] = NameAndType [147] [148] 
.const [84] = Class [149] 
.const [85] = NameAndType [150] [151] 
.const [86] = Class [152] 
.const [87] = NameAndType [153] [154] 
.const [88] = Utf8 java/util/Hashtable 
.const [89] = Class [155] 
.const [90] = NameAndType [156] [157] 
.const [91] = Utf8 java/lang/ClassNotFoundException 
.const [92] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [93] = Utf8 protectionDomainCache 
.const [94] = Utf8 Ljava/util/Hashtable; 
.const [95] = Utf8 java/lang/System 
.const [96] = Utf8 getProperty 
.const [97] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [98] = Utf8 com/ibm/oti/vm/VM 
.const [99] = Utf8 setClassPathImpl 
.const [100] = Utf8 (Ljava/lang/ClassLoader;Ljava/lang/String;)V 
.const [101] = Utf8 com/ibm/oti/vm/VM 
.const [102] = Utf8 findClassOrNull 
.const [103] = Utf8 (Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class; 
.const [104] = Utf8 com/ibm/oti/vm/VM 
.const [105] = Utf8 getCPIndexImpl 
.const [106] = Utf8 (Ljava/lang/Class;)I 
.const [107] = Utf8 com/ibm/oti/vm/VM 
.const [108] = Utf8 setPDImpl 
.const [109] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;)V 
.const [110] = Utf8 java/lang/System 
.const [111] = Utf8 getSecurityManager 
.const [112] = Utf8 ()Ljava/lang/SecurityManager; 
.const [113] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [114] = Utf8 checkingPackageAccess 
.const [115] = Utf8 Z 
.const [116] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [117] = Utf8 parsePath 
.const [118] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [119] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [120] = Utf8 getPackageName 
.const [121] = Utf8 (Ljava/lang/Class;)Ljava/lang/String; 
.const [122] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [123] = Utf8 definePackage 
.const [124] = Utf8 (Ljava/lang/String;I)V 
.const [125] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [126] = Utf8 getFilePD 
.const [127] = Utf8 (I)Ljava/lang/Object; 
.const [128] = Utf8 java/lang/String 
.const [129] = Utf8 lastIndexOf 
.const [130] = Utf8 (I)I 
.const [131] = Utf8 java/lang/String 
.const [132] = Utf8 substring 
.const [133] = Utf8 (II)Ljava/lang/String; 
.const [134] = Utf8 java/lang/SecurityManager 
.const [135] = Utf8 checkPackageAccess 
.const [136] = Utf8 (Ljava/lang/String;)V 
.const [137] = Utf8 java/util/Hashtable 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (I)V 
.const [140] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [141] = Utf8 protectionDomainCache 
.const [142] = Utf8 Ljava/util/Hashtable; 
.const [143] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [144] = Utf8 <init> 
.const [145] = Utf8 (Ljava/lang/ClassLoader;)V 
.const [146] = Utf8 com/ibm/oti/vm/AbstractClassLoader 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Ljava/lang/ClassLoader;)V 
.const [149] = Utf8 java/lang/ClassNotFoundException 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Ljava/lang/String;)V 
.const [152] = Utf8 com/ibm/oti/vm/AbstractClassLoader 
.const [153] = Utf8 loadClass 
.const [154] = Utf8 (Ljava/lang/String;Z)Ljava/lang/Class; 
.const [155] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [156] = Utf8 checkingPackageAccess 
.const [157] = Utf8 Z 
.const [158] = Utf8 com/ibm/oti/vm/AppClassLoader 
.const [159] = Class [158] 
.const [160] = Utf8 com/ibm/oti/vm/AbstractClassLoader 
.const [161] = Class [160] 
.const [162] = Utf8 checkingPackageAccess 
.const [163] = Utf8 Z 
.const [164] = Utf8 protectionDomainCache 
.const [165] = Utf8 Ljava/util/Hashtable; 
.const [166] = Utf8 Code 
.const [167] = Utf8 <clinit> 
.const [168] = Utf8 ()V 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Ljava/lang/ClassLoader;)V 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (Z)V 
.const [175] = Utf8 findClass 
.const [176] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [177] = Utf8 getProtectionDomainCache 
.const [178] = Utf8 ()Ljava/util/Hashtable; 
.const [179] = Utf8 loadClass 
.const [180] = Utf8 (Ljava/lang/String;Z)Ljava/lang/Class; 
.end class 
