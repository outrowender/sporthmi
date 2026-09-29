.version 50 0 
.class super [97] 
.super [99] 
.field private static final [100] [101] 
.field [102] [103] 

.method [105] : [106] 
    .attribute [104] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     new [20] 
L8:     dup 
L9:     bipush 8 
L11:    invokespecial [16] 
L14:    putfield [21] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [104] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     ifeq L15 
L7:     new [22] 
L10:    dup 
L11:    invokespecial [17] 
L14:    athrow 
L15:    aload_0 
L16:    getfield [9] 
L19:    aload_1 
L20:    invokevirtual [11] 
L23:    invokevirtual [12] 
L26:    checkcast [7] 
L29:    astore_2 
L30:    aload_2 
L31:    ifnonnull L55 
L34:    new [23] 
L37:    dup 
L38:    invokespecial [18] 
L41:    astore_2 
L42:    aload_0 
L43:    getfield [9] 
L46:    aload_1 
L47:    invokevirtual [11] 
L50:    aload_2 
L51:    invokevirtual [13] 
L54:    pop 
L55:    aload_2 
L56:    aload_1 
L57:    invokevirtual [14] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [104] .code stack 3 locals 0 
L0:     new [24] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [19] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [104] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method [113] : [114] 
    .attribute [104] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_1 
L5:     invokevirtual [12] 
L8:     checkcast [7] 
L11:    areturn 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = Class [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Field [32] [33] 
.const [10] = Method [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Class [54] 
.const [21] = Field [55] [56] 
.const [22] = Class [57] 
.const [23] = Class [58] 
.const [24] = Class [59] 
.const [25] = Utf8 java/security/UnresolvedPermissionCollection 
.const [26] = Utf8 java/security/PermissionCollection 
.const [27] = Utf8 java/util/Hashtable 
.const [28] = Utf8 java/lang/IllegalStateException 
.const [29] = Utf8 java/security/Permission 
.const [30] = Utf8 java/util/Vector 
.const [31] = Utf8 java/security/UnresolvedPermissionCollection$1 
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
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Utf8 java/util/Hashtable 
.const [55] = Class [93] 
.const [56] = NameAndType [94] [95] 
.const [57] = Utf8 java/lang/IllegalStateException 
.const [58] = Utf8 java/util/Vector 
.const [59] = Utf8 java/security/UnresolvedPermissionCollection$1 
.const [60] = Utf8 java/security/UnresolvedPermissionCollection 
.const [61] = Utf8 permissions 
.const [62] = Utf8 Ljava/util/Hashtable; 
.const [63] = Utf8 java/security/UnresolvedPermissionCollection 
.const [64] = Utf8 isReadOnly 
.const [65] = Utf8 ()Z 
.const [66] = Utf8 java/security/Permission 
.const [67] = Utf8 getName 
.const [68] = Utf8 ()Ljava/lang/String; 
.const [69] = Utf8 java/util/Hashtable 
.const [70] = Utf8 get 
.const [71] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [72] = Utf8 java/util/Hashtable 
.const [73] = Utf8 put 
.const [74] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [75] = Utf8 java/util/Vector 
.const [76] = Utf8 addElement 
.const [77] = Utf8 (Ljava/lang/Object;)V 
.const [78] = Utf8 java/security/PermissionCollection 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 java/util/Hashtable 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (I)V 
.const [84] = Utf8 java/lang/IllegalStateException 
.const [85] = Utf8 <init> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 java/util/Vector 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 java/security/UnresolvedPermissionCollection$1 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Ljava/security/UnresolvedPermissionCollection;)V 
.const [93] = Utf8 java/security/UnresolvedPermissionCollection 
.const [94] = Utf8 permissions 
.const [95] = Utf8 Ljava/util/Hashtable; 
.const [96] = Utf8 java/security/UnresolvedPermissionCollection 
.const [97] = Class [96] 
.const [98] = Utf8 java/security/PermissionCollection 
.const [99] = Class [98] 
.const [100] = Utf8 serialVersionUID 
.const [101] = Utf8 J 
.const [102] = Utf8 permissions 
.const [103] = Utf8 Ljava/util/Hashtable; 
.const [104] = Utf8 Code 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 add 
.const [108] = Utf8 (Ljava/security/Permission;)V 
.const [109] = Utf8 elements 
.const [110] = Utf8 ()Ljava/util/Enumeration; 
.const [111] = Utf8 implies 
.const [112] = Utf8 (Ljava/security/Permission;)Z 
.const [113] = Utf8 getPermissions 
.const [114] = Utf8 (Ljava/lang/String;)Ljava/util/Vector; 
.end class 
