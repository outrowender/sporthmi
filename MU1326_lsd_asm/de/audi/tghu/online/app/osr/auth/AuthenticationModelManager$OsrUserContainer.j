.version 50 0 
.class public super [71] 
.super [73] 
.field [74] [75] 
.field [76] [77] 
.field [78] [79] 
.field private final synthetic [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [12] 
L5:     aload_0 
L6:     invokespecial [11] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [13] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [14] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [15] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [87] : [88] 
    .attribute [82] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [82] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnonnull L11 
L9:     iconst_0 
L10:    areturn 
L11:    aload_0 
L12:    getfield [6] 
L15:    ifnonnull L27 
L18:    aload_2 
L19:    getfield [6] 
L22:    ifnonnull L27 
L25:    iconst_1 
L26:    areturn 
L27:    aload_0 
L28:    getfield [6] 
L31:    ifnull L41 
L34:    aload_2 
L35:    getfield [6] 
L38:    ifnonnull L43 
L41:    iconst_0 
L42:    areturn 
L43:    aload_0 
L44:    getfield [6] 
L47:    getfield [8] 
L50:    aload_2 
L51:    getfield [6] 
L54:    getfield [8] 
L57:    invokevirtual [9] 
L60:    ifeq L87 
L63:    aload_0 
L64:    getfield [6] 
L67:    getfield [10] 
L70:    aload_2 
L71:    getfield [6] 
L74:    getfield [10] 
L77:    invokevirtual [9] 
L80:    ifeq L87 
L83:    iconst_1 
L84:    goto L88 
L87:    iconst_0 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [82] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = Class [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Field [20] [21] 
.const [7] = Field [22] [23] 
.const [8] = Field [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Field [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Utf8 de/audi/tghu/online/app/osr/auth/AuthenticationModelManager$OsrUserContainer 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 org/dsi/ifc/online/OSRUser 
.const [19] = Utf8 java/lang/String 
.const [20] = Class [40] 
.const [21] = NameAndType [41] [42] 
.const [22] = Class [43] 
.const [23] = NameAndType [44] [45] 
.const [24] = Class [46] 
.const [25] = NameAndType [47] [48] 
.const [26] = Class [49] 
.const [27] = NameAndType [50] [51] 
.const [28] = Class [52] 
.const [29] = NameAndType [53] [54] 
.const [30] = Class [55] 
.const [31] = NameAndType [56] [57] 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Utf8 de/audi/tghu/online/app/osr/auth/AuthenticationModelManager$OsrUserContainer 
.const [41] = Utf8 user 
.const [42] = Utf8 Lorg/dsi/ifc/online/OSRUser; 
.const [43] = Utf8 de/audi/tghu/online/app/osr/auth/AuthenticationModelManager$OsrUserContainer 
.const [44] = Utf8 cacheInfo 
.const [45] = Utf8 Lde/audi/remotehmi/IOsrUserCacheInformation; 
.const [46] = Utf8 org/dsi/ifc/online/OSRUser 
.const [47] = Utf8 portalUser 
.const [48] = Utf8 Ljava/lang/String; 
.const [49] = Utf8 java/lang/String 
.const [50] = Utf8 equals 
.const [51] = Utf8 (Ljava/lang/Object;)Z 
.const [52] = Utf8 org/dsi/ifc/online/OSRUser 
.const [53] = Utf8 authIdentifier 
.const [54] = Utf8 Ljava/lang/String; 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 de/audi/tghu/online/app/osr/auth/AuthenticationModelManager$OsrUserContainer 
.const [59] = Utf8 this$0 
.const [60] = Utf8 Lde/audi/tghu/online/app/osr/auth/AuthenticationModelManager; 
.const [61] = Utf8 de/audi/tghu/online/app/osr/auth/AuthenticationModelManager$OsrUserContainer 
.const [62] = Utf8 user 
.const [63] = Utf8 Lorg/dsi/ifc/online/OSRUser; 
.const [64] = Utf8 de/audi/tghu/online/app/osr/auth/AuthenticationModelManager$OsrUserContainer 
.const [65] = Utf8 source 
.const [66] = Utf8 Ljava/lang/String; 
.const [67] = Utf8 de/audi/tghu/online/app/osr/auth/AuthenticationModelManager$OsrUserContainer 
.const [68] = Utf8 cacheInfo 
.const [69] = Utf8 Lde/audi/remotehmi/IOsrUserCacheInformation; 
.const [70] = Utf8 de/audi/tghu/online/app/osr/auth/AuthenticationModelManager$OsrUserContainer 
.const [71] = Class [70] 
.const [72] = Utf8 java/lang/Object 
.const [73] = Class [72] 
.const [74] = Utf8 user 
.const [75] = Utf8 Lorg/dsi/ifc/online/OSRUser; 
.const [76] = Utf8 source 
.const [77] = Utf8 Ljava/lang/String; 
.const [78] = Utf8 cacheInfo 
.const [79] = Utf8 Lde/audi/remotehmi/IOsrUserCacheInformation; 
.const [80] = Utf8 this$0 
.const [81] = Utf8 Lde/audi/tghu/online/app/osr/auth/AuthenticationModelManager; 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/audi/tghu/online/app/osr/auth/AuthenticationModelManager;Lorg/dsi/ifc/online/OSRUser;Ljava/lang/String;)V 
.const [85] = Utf8 setCacheInfo 
.const [86] = Utf8 (Lde/audi/remotehmi/IOsrUserCacheInformation;)V 
.const [87] = Utf8 getCacheInfo 
.const [88] = Utf8 ()Lde/audi/remotehmi/IOsrUserCacheInformation; 
.const [89] = Utf8 equals 
.const [90] = Utf8 (Ljava/lang/Object;)Z 
.const [91] = Utf8 hashCode 
.const [92] = Utf8 ()I 
.end class 
