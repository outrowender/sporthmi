.version 50 0 
.class final super [107] 
.super [109] 
.implements [111] 
.field private static final [112] [113] 
.field [114] [115] 

.method public [117] : [118] 
    .attribute [116] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     new [22] 
L8:     dup 
L9:     invokespecial [19] 
L12:    putfield [23] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [116] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     ifne L40 
L7:     aload_1 
L8:     instanceof [5] 
L11:    ifeq L25 
L14:    aload_0 
L15:    getfield [9] 
L18:    aload_1 
L19:    invokevirtual [11] 
L22:    goto L48 
L25:    new [24] 
L28:    dup 
L29:    aload_1 
L30:    invokevirtual [12] 
L33:    invokespecial [20] 
L36:    athrow 
L37:    goto L48 
L40:    new [25] 
L43:    dup 
L44:    invokespecial [21] 
L47:    athrow 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [116] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     invokevirtual [13] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [116] .code stack 3 locals 3 
L0:     aload_1 
L1:     instanceof [5] 
L4:     ifeq L84 
L7:     aload_1 
L8:     checkcast [5] 
L11:    astore_2 
L12:    iconst_0 
L13:    istore_3 
L14:    iconst_0 
L15:    istore 4 
L17:    goto L42 
L20:    iload_3 
L21:    aload_0 
L22:    getfield [9] 
L25:    iload 4 
L27:    invokevirtual [14] 
L30:    checkcast [5] 
L33:    aload_1 
L34:    invokevirtual [15] 
L37:    ior 
L38:    istore_3 
L39:    iinc 4 1 
L42:    iload 4 
L44:    aload_0 
L45:    getfield [9] 
L48:    invokevirtual [16] 
L51:    if_icmpge L67 
L54:    iload_3 
L55:    aload_2 
L56:    getfield [17] 
L59:    iand 
L60:    aload_2 
L61:    getfield [17] 
L64:    if_icmpne L20 
L67:    iload_3 
L68:    aload_2 
L69:    getfield [17] 
L72:    iand 
L73:    aload_2 
L74:    getfield [17] 
L77:    if_icmpne L82 
L80:    iconst_1 
L81:    areturn 
L82:    iconst_0 
L83:    areturn 
L84:    iconst_0 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Field [33] [34] 
.const [10] = Method [35] [36] 
.const [11] = Method [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Field [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Class [59] 
.const [23] = Field [60] [61] 
.const [24] = Class [62] 
.const [25] = Class [63] 
.const [26] = Utf8 java/io/FilePermissionCollection 
.const [27] = Utf8 java/security/PermissionCollection 
.const [28] = Utf8 java/util/Vector 
.const [29] = Utf8 java/io/FilePermission 
.const [30] = Utf8 java/lang/IllegalArgumentException 
.const [31] = Utf8 java/security/Permission 
.const [32] = Utf8 java/lang/IllegalStateException 
.const [33] = Class [64] 
.const [34] = NameAndType [65] [66] 
.const [35] = Class [67] 
.const [36] = NameAndType [68] [69] 
.const [37] = Class [70] 
.const [38] = NameAndType [71] [72] 
.const [39] = Class [73] 
.const [40] = NameAndType [74] [75] 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Utf8 java/util/Vector 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Utf8 java/lang/IllegalArgumentException 
.const [63] = Utf8 java/lang/IllegalStateException 
.const [64] = Utf8 java/io/FilePermissionCollection 
.const [65] = Utf8 permissions 
.const [66] = Utf8 Ljava/util/Vector; 
.const [67] = Utf8 java/io/FilePermissionCollection 
.const [68] = Utf8 isReadOnly 
.const [69] = Utf8 ()Z 
.const [70] = Utf8 java/util/Vector 
.const [71] = Utf8 addElement 
.const [72] = Utf8 (Ljava/lang/Object;)V 
.const [73] = Utf8 java/security/Permission 
.const [74] = Utf8 toString 
.const [75] = Utf8 ()Ljava/lang/String; 
.const [76] = Utf8 java/util/Vector 
.const [77] = Utf8 elements 
.const [78] = Utf8 ()Ljava/util/Enumeration; 
.const [79] = Utf8 java/util/Vector 
.const [80] = Utf8 elementAt 
.const [81] = Utf8 (I)Ljava/lang/Object; 
.const [82] = Utf8 java/io/FilePermission 
.const [83] = Utf8 impliesMask 
.const [84] = Utf8 (Ljava/security/Permission;)I 
.const [85] = Utf8 java/util/Vector 
.const [86] = Utf8 size 
.const [87] = Utf8 ()I 
.const [88] = Utf8 java/io/FilePermission 
.const [89] = Utf8 mask 
.const [90] = Utf8 I 
.const [91] = Utf8 java/security/PermissionCollection 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 java/util/Vector 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/lang/IllegalArgumentException 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (Ljava/lang/String;)V 
.const [100] = Utf8 java/lang/IllegalStateException 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 java/io/FilePermissionCollection 
.const [104] = Utf8 permissions 
.const [105] = Utf8 Ljava/util/Vector; 
.const [106] = Utf8 java/io/FilePermissionCollection 
.const [107] = Class [106] 
.const [108] = Utf8 java/security/PermissionCollection 
.const [109] = Class [108] 
.const [110] = Utf8 java/io/Serializable 
.const [111] = Class [110] 
.const [112] = Utf8 serialVersionUID 
.const [113] = Utf8 J 
.const [114] = Utf8 permissions 
.const [115] = Utf8 Ljava/util/Vector; 
.const [116] = Utf8 Code 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 add 
.const [120] = Utf8 (Ljava/security/Permission;)V 
.const [121] = Utf8 elements 
.const [122] = Utf8 ()Ljava/util/Enumeration; 
.const [123] = Utf8 implies 
.const [124] = Utf8 (Ljava/security/Permission;)Z 
.end class 
