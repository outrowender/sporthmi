.version 50 0 
.class super [147] 
.super [149] 
.field private static final [150] [151] 
.field [152] [153] 
.field [154] [155] 

.method public [157] : [158] 
    .attribute [156] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [29] 
L9:     aload_0 
L10:    new [30] 
L13:    dup 
L14:    bipush 8 
L16:    invokespecial [26] 
L19:    putfield [31] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [156] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [14] 
L4:     ifeq L15 
L7:     new [32] 
L10:    dup 
L11:    invokespecial [27] 
L14:    athrow 
L15:    aload_1 
L16:    invokevirtual [15] 
L19:    astore_2 
L20:    aload_0 
L21:    aload_0 
L22:    getfield [12] 
L25:    ifne L41 
L28:    aload_2 
L29:    ldc [7] 
L31:    invokevirtual [16] 
L34:    ifne L41 
L37:    iconst_0 
L38:    goto L42 
L41:    iconst_1 
L42:    putfield [29] 
L45:    aload_0 
L46:    getfield [13] 
L49:    aload_2 
L50:    aload_1 
L51:    invokevirtual [17] 
L54:    pop 
L55:    return 
L56:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [156] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokevirtual [18] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [156] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifeq L9 
L7:     iconst_1 
L8:     areturn 
L9:     aload_1 
L10:    invokevirtual [15] 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [13] 
L18:    aload_2 
L19:    invokevirtual [19] 
L22:    ifnull L27 
L25:    iconst_1 
L26:    areturn 
L27:    aload_2 
L28:    bipush 46 
L30:    invokevirtual [20] 
L33:    istore_3 
L34:    goto L94 
L37:    iload_3 
L38:    iconst_1 
L39:    iadd 
L40:    aload_2 
L41:    invokevirtual [21] 
L44:    if_icmpne L49 
L47:    iconst_0 
L48:    areturn 
L49:    aload_2 
L50:    iconst_0 
L51:    iload_3 
L52:    invokevirtual [22] 
L55:    astore_2 
L56:    aload_0 
L57:    getfield [13] 
L60:    new [33] 
L63:    dup 
L64:    aload_2 
L65:    invokestatic [10] 
L68:    invokespecial [28] 
L71:    ldc [11] 
L73:    invokevirtual [23] 
L76:    invokevirtual [24] 
L79:    invokevirtual [19] 
L82:    ifnull L87 
L85:    iconst_1 
L86:    areturn 
L87:    aload_2 
L88:    bipush 46 
L90:    invokevirtual [20] 
L93:    istore_3 
L94:    iload_3 
L95:    ifge L37 
L98:    iconst_0 
L99:    areturn 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Class [36] 
.const [5] = Class [37] 
.const [6] = Class [38] 
.const [7] = String [39] 
.const [8] = Class [40] 
.const [9] = Class [41] 
.const [10] = Method [42] [43] 
.const [11] = String [44] 
.const [12] = Field [45] [46] 
.const [13] = Field [47] [48] 
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
.const [28] = Method [77] [78] 
.const [29] = Field [79] [80] 
.const [30] = Class [81] 
.const [31] = Field [82] [83] 
.const [32] = Class [84] 
.const [33] = Class [85] 
.const [34] = Utf8 java/security/BasicPermissionCollection 
.const [35] = Utf8 java/security/PermissionCollection 
.const [36] = Utf8 java/util/Hashtable 
.const [37] = Utf8 java/lang/IllegalStateException 
.const [38] = Utf8 java/security/Permission 
.const [39] = Utf8 '*' 
.const [40] = Utf8 java/lang/String 
.const [41] = Utf8 java/lang/StringBuffer 
.const [42] = Class [86] 
.const [43] = NameAndType [87] [88] 
.const [44] = Utf8 '.*' 
.const [45] = Class [89] 
.const [46] = NameAndType [90] [91] 
.const [47] = Class [92] 
.const [48] = NameAndType [93] [94] 
.const [49] = Class [95] 
.const [50] = NameAndType [96] [97] 
.const [51] = Class [98] 
.const [52] = NameAndType [99] [100] 
.const [53] = Class [101] 
.const [54] = NameAndType [102] [103] 
.const [55] = Class [104] 
.const [56] = NameAndType [105] [106] 
.const [57] = Class [107] 
.const [58] = NameAndType [108] [109] 
.const [59] = Class [110] 
.const [60] = NameAndType [111] [112] 
.const [61] = Class [113] 
.const [62] = NameAndType [114] [115] 
.const [63] = Class [116] 
.const [64] = NameAndType [117] [118] 
.const [65] = Class [119] 
.const [66] = NameAndType [120] [121] 
.const [67] = Class [122] 
.const [68] = NameAndType [123] [124] 
.const [69] = Class [125] 
.const [70] = NameAndType [126] [127] 
.const [71] = Class [128] 
.const [72] = NameAndType [129] [130] 
.const [73] = Class [131] 
.const [74] = NameAndType [132] [133] 
.const [75] = Class [134] 
.const [76] = NameAndType [135] [136] 
.const [77] = Class [137] 
.const [78] = NameAndType [138] [139] 
.const [79] = Class [140] 
.const [80] = NameAndType [141] [142] 
.const [81] = Utf8 java/util/Hashtable 
.const [82] = Class [143] 
.const [83] = NameAndType [144] [145] 
.const [84] = Utf8 java/lang/IllegalStateException 
.const [85] = Utf8 java/lang/StringBuffer 
.const [86] = Utf8 java/lang/String 
.const [87] = Utf8 valueOf 
.const [88] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [89] = Utf8 java/security/BasicPermissionCollection 
.const [90] = Utf8 all_allowed 
.const [91] = Utf8 Z 
.const [92] = Utf8 java/security/BasicPermissionCollection 
.const [93] = Utf8 permissions 
.const [94] = Utf8 Ljava/util/Hashtable; 
.const [95] = Utf8 java/security/BasicPermissionCollection 
.const [96] = Utf8 isReadOnly 
.const [97] = Utf8 ()Z 
.const [98] = Utf8 java/security/Permission 
.const [99] = Utf8 getName 
.const [100] = Utf8 ()Ljava/lang/String; 
.const [101] = Utf8 java/lang/String 
.const [102] = Utf8 equals 
.const [103] = Utf8 (Ljava/lang/Object;)Z 
.const [104] = Utf8 java/util/Hashtable 
.const [105] = Utf8 put 
.const [106] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [107] = Utf8 java/util/Hashtable 
.const [108] = Utf8 elements 
.const [109] = Utf8 ()Ljava/util/Enumeration; 
.const [110] = Utf8 java/util/Hashtable 
.const [111] = Utf8 get 
.const [112] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [113] = Utf8 java/lang/String 
.const [114] = Utf8 lastIndexOf 
.const [115] = Utf8 (I)I 
.const [116] = Utf8 java/lang/String 
.const [117] = Utf8 length 
.const [118] = Utf8 ()I 
.const [119] = Utf8 java/lang/String 
.const [120] = Utf8 substring 
.const [121] = Utf8 (II)Ljava/lang/String; 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 append 
.const [124] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 toString 
.const [127] = Utf8 ()Ljava/lang/String; 
.const [128] = Utf8 java/security/PermissionCollection 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 java/util/Hashtable 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (I)V 
.const [134] = Utf8 java/lang/IllegalStateException 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Ljava/lang/String;)V 
.const [140] = Utf8 java/security/BasicPermissionCollection 
.const [141] = Utf8 all_allowed 
.const [142] = Utf8 Z 
.const [143] = Utf8 java/security/BasicPermissionCollection 
.const [144] = Utf8 permissions 
.const [145] = Utf8 Ljava/util/Hashtable; 
.const [146] = Utf8 java/security/BasicPermissionCollection 
.const [147] = Class [146] 
.const [148] = Utf8 java/security/PermissionCollection 
.const [149] = Class [148] 
.const [150] = Utf8 serialVersionUID 
.const [151] = Utf8 J 
.const [152] = Utf8 all_allowed 
.const [153] = Utf8 Z 
.const [154] = Utf8 permissions 
.const [155] = Utf8 Ljava/util/Hashtable; 
.const [156] = Utf8 Code 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 add 
.const [160] = Utf8 (Ljava/security/Permission;)V 
.const [161] = Utf8 elements 
.const [162] = Utf8 ()Ljava/util/Enumeration; 
.const [163] = Utf8 implies 
.const [164] = Utf8 (Ljava/security/Permission;)Z 
.end class 
