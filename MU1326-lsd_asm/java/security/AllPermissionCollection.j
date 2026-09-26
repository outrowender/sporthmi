.version 50 0 
.class super [91] 
.super [93] 
.field private static final [94] [95] 
.field [96] [97] 

.method [99] : [100] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [98] .code stack 3 locals 0 
L0:     aload_1 
L1:     instanceof [4] 
L4:     ifne L19 
L7:     new [21] 
L10:    dup 
L11:    aload_1 
L12:    invokevirtual [10] 
L15:    invokespecial [15] 
L18:    athrow 
L19:    aload_0 
L20:    invokevirtual [11] 
L23:    ifeq L34 
L26:    new [22] 
L29:    dup 
L30:    invokespecial [16] 
L33:    athrow 
L34:    aload_0 
L35:    iconst_1 
L36:    putfield [19] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [98] .code stack 3 locals 1 
L0:     new [23] 
L3:     dup 
L4:     invokespecial [17] 
L7:     astore_1 
L8:     aload_0 
L9:     getfield [9] 
L12:    ifeq L26 
L15:    aload_1 
L16:    new [20] 
L19:    dup 
L20:    invokespecial [18] 
L23:    invokevirtual [12] 
L26:    aload_1 
L27:    invokevirtual [13] 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = Class [25] 
.const [4] = Class [26] 
.const [5] = Class [27] 
.const [6] = Class [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Field [31] [32] 
.const [10] = Method [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Class [53] 
.const [21] = Class [54] 
.const [22] = Class [55] 
.const [23] = Class [56] 
.const [24] = Utf8 java/security/AllPermissionCollection 
.const [25] = Utf8 java/security/PermissionCollection 
.const [26] = Utf8 java/security/AllPermission 
.const [27] = Utf8 java/lang/IllegalArgumentException 
.const [28] = Utf8 java/security/Permission 
.const [29] = Utf8 java/lang/IllegalStateException 
.const [30] = Utf8 java/util/Vector 
.const [31] = Class [57] 
.const [32] = NameAndType [58] [59] 
.const [33] = Class [60] 
.const [34] = NameAndType [61] [62] 
.const [35] = Class [63] 
.const [36] = NameAndType [64] [65] 
.const [37] = Class [66] 
.const [38] = NameAndType [67] [68] 
.const [39] = Class [69] 
.const [40] = NameAndType [70] [71] 
.const [41] = Class [72] 
.const [42] = NameAndType [73] [74] 
.const [43] = Class [75] 
.const [44] = NameAndType [76] [77] 
.const [45] = Class [78] 
.const [46] = NameAndType [79] [80] 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Utf8 java/security/AllPermission 
.const [54] = Utf8 java/lang/IllegalArgumentException 
.const [55] = Utf8 java/lang/IllegalStateException 
.const [56] = Utf8 java/util/Vector 
.const [57] = Utf8 java/security/AllPermissionCollection 
.const [58] = Utf8 all_allowed 
.const [59] = Utf8 Z 
.const [60] = Utf8 java/security/Permission 
.const [61] = Utf8 toString 
.const [62] = Utf8 ()Ljava/lang/String; 
.const [63] = Utf8 java/security/AllPermissionCollection 
.const [64] = Utf8 isReadOnly 
.const [65] = Utf8 ()Z 
.const [66] = Utf8 java/util/Vector 
.const [67] = Utf8 addElement 
.const [68] = Utf8 (Ljava/lang/Object;)V 
.const [69] = Utf8 java/util/Vector 
.const [70] = Utf8 elements 
.const [71] = Utf8 ()Ljava/util/Enumeration; 
.const [72] = Utf8 java/security/PermissionCollection 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 java/lang/IllegalArgumentException 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (Ljava/lang/String;)V 
.const [78] = Utf8 java/lang/IllegalStateException 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 java/util/Vector 
.const [82] = Utf8 <init> 
.const [83] = Utf8 ()V 
.const [84] = Utf8 java/security/AllPermission 
.const [85] = Utf8 <init> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 java/security/AllPermissionCollection 
.const [88] = Utf8 all_allowed 
.const [89] = Utf8 Z 
.const [90] = Utf8 java/security/AllPermissionCollection 
.const [91] = Class [90] 
.const [92] = Utf8 java/security/PermissionCollection 
.const [93] = Class [92] 
.const [94] = Utf8 serialVersionUID 
.const [95] = Utf8 J 
.const [96] = Utf8 all_allowed 
.const [97] = Utf8 Z 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 add 
.const [102] = Utf8 (Ljava/security/Permission;)V 
.const [103] = Utf8 elements 
.const [104] = Utf8 ()Ljava/util/Enumeration; 
.const [105] = Utf8 implies 
.const [106] = Utf8 (Ljava/security/Permission;)Z 
.end class 
