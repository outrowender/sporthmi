.version 50 0 
.class super [123] 
.super [125] 
.implements [127] 
.field [128] [129] 
.field [130] [131] 
.field [132] [133] 
.field [134] [135] 
.field final synthetic [136] [137] 

.method [139] : [140] 
    .attribute [138] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [20] 
L9:     aload_0 
L10:    aload_1 
L11:    getfield [10] 
L14:    invokevirtual [11] 
L17:    putfield [21] 
L20:    aload_0 
L21:    aload_0 
L22:    invokespecial [18] 
L25:    putfield [22] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [138] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L9 
L7:     iconst_1 
L8:     areturn 
L9:     iconst_0 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [138] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnonnull L15 
L7:     new [23] 
L10:    dup 
L11:    invokespecial [19] 
L14:    athrow 
L15:    aload_0 
L16:    getfield [13] 
L19:    astore_1 
L20:    aload_0 
L21:    aload_0 
L22:    invokespecial [18] 
L25:    putfield [22] 
L28:    aload_1 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [145] : [146] 
    .attribute [138] .code stack 2 locals 1 
L0:     goto L47 
L3:     aload_0 
L4:     aload_0 
L5:     getfield [12] 
L8:     invokeinterface [24] 0 
L13:    checkcast [8] 
L16:    putfield [25] 
L19:    aload_0 
L20:    aload_0 
L21:    getfield [14] 
L24:    invokevirtual [15] 
L27:    putfield [26] 
L30:    aload_0 
L31:    getfield [16] 
L34:    invokeinterface [27] 0 
L39:    ifne L47 
L42:    aload_0 
L43:    aconst_null 
L44:    putfield [25] 
L47:    aload_0 
L48:    getfield [14] 
L51:    ifnonnull L66 
L54:    aload_0 
L55:    getfield [12] 
L58:    invokeinterface [27] 0 
L63:    ifne L3 
L66:    aload_0 
L67:    getfield [14] 
L70:    ifnonnull L75 
L73:    aconst_null 
L74:    areturn 
L75:    aload_0 
L76:    getfield [16] 
L79:    invokeinterface [24] 0 
L84:    checkcast [9] 
L87:    astore_1 
L88:    aload_0 
L89:    getfield [16] 
L92:    invokeinterface [27] 0 
L97:    ifne L105 
L100:   aload_0 
L101:   aconst_null 
L102:   putfield [25] 
L105:   aload_1 
L106:   areturn 
L107:   nop 
L108:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Class [29] 
.const [4] = Class [30] 
.const [5] = Class [31] 
.const [6] = Class [32] 
.const [7] = Class [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Field [36] [37] 
.const [11] = Method [38] [39] 
.const [12] = Field [40] [41] 
.const [13] = Field [42] [43] 
.const [14] = Field [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Field [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Field [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Class [62] 
.const [24] = InterfaceMethod [63] [64] 
.const [25] = Field [65] [66] 
.const [26] = Field [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 java/util/Enumeration 
.const [31] = Utf8 java/security/Permissions 
.const [32] = Utf8 java/util/Hashtable 
.const [33] = Utf8 java/util/NoSuchElementException 
.const [34] = Utf8 java/security/PermissionCollection 
.const [35] = Utf8 java/security/Permission 
.const [36] = Class [71] 
.const [37] = NameAndType [72] [73] 
.const [38] = Class [74] 
.const [39] = NameAndType [75] [76] 
.const [40] = Class [77] 
.const [41] = NameAndType [78] [79] 
.const [42] = Class [80] 
.const [43] = NameAndType [81] [82] 
.const [44] = Class [83] 
.const [45] = NameAndType [84] [85] 
.const [46] = Class [86] 
.const [47] = NameAndType [87] [88] 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Class [92] 
.const [51] = NameAndType [93] [94] 
.const [52] = Class [95] 
.const [53] = NameAndType [96] [97] 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Class [104] 
.const [59] = NameAndType [105] [106] 
.const [60] = Class [107] 
.const [61] = NameAndType [108] [109] 
.const [62] = Utf8 java/util/NoSuchElementException 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Utf8 java/security/Permissions 
.const [72] = Utf8 perms 
.const [73] = Utf8 Ljava/util/Hashtable; 
.const [74] = Utf8 java/util/Hashtable 
.const [75] = Utf8 elements 
.const [76] = Utf8 ()Ljava/util/Enumeration; 
.const [77] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [78] = Utf8 enumMap 
.const [79] = Utf8 Ljava/util/Enumeration; 
.const [80] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [81] = Utf8 next 
.const [82] = Utf8 Ljava/security/Permission; 
.const [83] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [84] = Utf8 c 
.const [85] = Utf8 Ljava/security/PermissionCollection; 
.const [86] = Utf8 java/security/PermissionCollection 
.const [87] = Utf8 elements 
.const [88] = Utf8 ()Ljava/util/Enumeration; 
.const [89] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [90] = Utf8 enumC 
.const [91] = Utf8 Ljava/util/Enumeration; 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [96] = Utf8 findNextPermission 
.const [97] = Utf8 ()Ljava/security/Permission; 
.const [98] = Utf8 java/util/NoSuchElementException 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [102] = Utf8 this$0 
.const [103] = Utf8 Ljava/security/Permissions; 
.const [104] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [105] = Utf8 enumMap 
.const [106] = Utf8 Ljava/util/Enumeration; 
.const [107] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [108] = Utf8 next 
.const [109] = Utf8 Ljava/security/Permission; 
.const [110] = Utf8 java/util/Enumeration 
.const [111] = Utf8 nextElement 
.const [112] = Utf8 ()Ljava/lang/Object; 
.const [113] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [114] = Utf8 c 
.const [115] = Utf8 Ljava/security/PermissionCollection; 
.const [116] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [117] = Utf8 enumC 
.const [118] = Utf8 Ljava/util/Enumeration; 
.const [119] = Utf8 java/util/Enumeration 
.const [120] = Utf8 hasMoreElements 
.const [121] = Utf8 ()Z 
.const [122] = Utf8 java/security/Permissions$PermissionsEnumeration 
.const [123] = Class [122] 
.const [124] = Utf8 java/lang/Object 
.const [125] = Class [124] 
.const [126] = Utf8 java/util/Enumeration 
.const [127] = Class [126] 
.const [128] = Utf8 enumMap 
.const [129] = Utf8 Ljava/util/Enumeration; 
.const [130] = Utf8 c 
.const [131] = Utf8 Ljava/security/PermissionCollection; 
.const [132] = Utf8 enumC 
.const [133] = Utf8 Ljava/util/Enumeration; 
.const [134] = Utf8 next 
.const [135] = Utf8 Ljava/security/Permission; 
.const [136] = Utf8 this$0 
.const [137] = Utf8 Ljava/security/Permissions; 
.const [138] = Utf8 Code 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Ljava/security/Permissions;)V 
.const [141] = Utf8 hasMoreElements 
.const [142] = Utf8 ()Z 
.const [143] = Utf8 nextElement 
.const [144] = Utf8 ()Ljava/lang/Object; 
.const [145] = Utf8 findNextPermission 
.const [146] = Utf8 ()Ljava/security/Permission; 
.end class 
