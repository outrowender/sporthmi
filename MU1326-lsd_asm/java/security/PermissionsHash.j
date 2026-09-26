.version 50 0 
.class super [91] 
.super [93] 
.field private static final [94] [95] 
.field [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     new [17] 
L8:     dup 
L9:     bipush 8 
L11:    invokespecial [15] 
L14:    putfield [18] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [98] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [9] 
L4:     ifeq L15 
L7:     new [19] 
L10:    dup 
L11:    invokespecial [16] 
L14:    athrow 
L15:    aload_0 
L16:    getfield [8] 
L19:    aload_1 
L20:    aload_1 
L21:    invokevirtual [10] 
L24:    pop 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [11] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [98] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     astore_2 
L5:     goto L26 
L8:     aload_2 
L9:     invokeinterface [20] 0 
L14:    checkcast [7] 
L17:    aload_1 
L18:    invokevirtual [13] 
L21:    ifeq L26 
L24:    iconst_1 
L25:    areturn 
L26:    aload_2 
L27:    invokeinterface [21] 0 
L32:    ifne L8 
L35:    iconst_0 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Field [28] [29] 
.const [9] = Method [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Method [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Class [46] 
.const [18] = Field [47] [48] 
.const [19] = Class [49] 
.const [20] = InterfaceMethod [50] [51] 
.const [21] = InterfaceMethod [52] [53] 
.const [22] = Utf8 java/security/PermissionsHash 
.const [23] = Utf8 java/security/PermissionCollection 
.const [24] = Utf8 java/util/Hashtable 
.const [25] = Utf8 java/lang/IllegalStateException 
.const [26] = Utf8 java/util/Enumeration 
.const [27] = Utf8 java/security/Permission 
.const [28] = Class [54] 
.const [29] = NameAndType [55] [56] 
.const [30] = Class [57] 
.const [31] = NameAndType [58] [59] 
.const [32] = Class [60] 
.const [33] = NameAndType [61] [62] 
.const [34] = Class [63] 
.const [35] = NameAndType [64] [65] 
.const [36] = Class [66] 
.const [37] = NameAndType [67] [68] 
.const [38] = Class [69] 
.const [39] = NameAndType [70] [71] 
.const [40] = Class [72] 
.const [41] = NameAndType [73] [74] 
.const [42] = Class [75] 
.const [43] = NameAndType [76] [77] 
.const [44] = Class [78] 
.const [45] = NameAndType [79] [80] 
.const [46] = Utf8 java/util/Hashtable 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Utf8 java/lang/IllegalStateException 
.const [50] = Class [84] 
.const [51] = NameAndType [85] [86] 
.const [52] = Class [87] 
.const [53] = NameAndType [88] [89] 
.const [54] = Utf8 java/security/PermissionsHash 
.const [55] = Utf8 perms 
.const [56] = Utf8 Ljava/util/Hashtable; 
.const [57] = Utf8 java/security/PermissionsHash 
.const [58] = Utf8 isReadOnly 
.const [59] = Utf8 ()Z 
.const [60] = Utf8 java/util/Hashtable 
.const [61] = Utf8 put 
.const [62] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [63] = Utf8 java/util/Hashtable 
.const [64] = Utf8 keys 
.const [65] = Utf8 ()Ljava/util/Enumeration; 
.const [66] = Utf8 java/security/PermissionsHash 
.const [67] = Utf8 elements 
.const [68] = Utf8 ()Ljava/util/Enumeration; 
.const [69] = Utf8 java/security/Permission 
.const [70] = Utf8 implies 
.const [71] = Utf8 (Ljava/security/Permission;)Z 
.const [72] = Utf8 java/security/PermissionCollection 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 java/util/Hashtable 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (I)V 
.const [78] = Utf8 java/lang/IllegalStateException 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 java/security/PermissionsHash 
.const [82] = Utf8 perms 
.const [83] = Utf8 Ljava/util/Hashtable; 
.const [84] = Utf8 java/util/Enumeration 
.const [85] = Utf8 nextElement 
.const [86] = Utf8 ()Ljava/lang/Object; 
.const [87] = Utf8 java/util/Enumeration 
.const [88] = Utf8 hasMoreElements 
.const [89] = Utf8 ()Z 
.const [90] = Utf8 java/security/PermissionsHash 
.const [91] = Class [90] 
.const [92] = Utf8 java/security/PermissionCollection 
.const [93] = Class [92] 
.const [94] = Utf8 serialVersionUID 
.const [95] = Utf8 J 
.const [96] = Utf8 perms 
.const [97] = Utf8 Ljava/util/Hashtable; 
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
