.version 50 0 
.class public final super [47] 
.super [49] 

.method private annotation [51] : [52] 
    .attribute [50] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [53] : [54] 
    .attribute [50] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokeinterface [8] 0 
L6:     sipush 1115 
L9:     iconst_1 
L10:    aload_0 
L11:    invokestatic [2] 
L14:    invokeinterface [9] 0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public static [55] : [56] 
    .attribute [50] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokeinterface [8] 0 
L6:     sipush 1115 
L9:     iconst_1 
L10:    iload_1 
L11:    invokeinterface [10] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [57] : [58] 
    .attribute [50] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpne L9 
L5:     iconst_1 
L6:     goto L10 
L9:     iconst_0 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [59] : [60] 
    .attribute [50] .code stack 1 locals 0 
L0:     iload_0 
L1:     ifeq L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private static [61] : [62] 
    .attribute [50] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokeinterface [11] 0 
L6:     ifeq L11 
L9:     iconst_0 
L10:    areturn 
L11:    iconst_1 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [12] [13] 
.const [3] = Class [14] 
.const [4] = Class [15] 
.const [5] = Class [16] 
.const [6] = Class [17] 
.const [7] = Method [18] [19] 
.const [8] = InterfaceMethod [20] [21] 
.const [9] = InterfaceMethod [22] [23] 
.const [10] = InterfaceMethod [24] [25] 
.const [11] = InterfaceMethod [26] [27] 
.const [12] = Class [28] 
.const [13] = NameAndType [29] [30] 
.const [14] = Utf8 de/audi/tghu/exlap/ExlapUtil 
.const [15] = Utf8 java/lang/Object 
.const [16] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [17] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [18] = Class [31] 
.const [19] = NameAndType [32] [33] 
.const [20] = Class [34] 
.const [21] = NameAndType [35] [36] 
.const [22] = Class [37] 
.const [23] = NameAndType [38] [39] 
.const [24] = Class [40] 
.const [25] = NameAndType [41] [42] 
.const [26] = Class [43] 
.const [27] = NameAndType [44] [45] 
.const [28] = Utf8 de/audi/tghu/exlap/ExlapUtil 
.const [29] = Utf8 getExlapDefaultStatus 
.const [30] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)I 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 <init> 
.const [33] = Utf8 ()V 
.const [34] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [35] = Utf8 getStorageMgr 
.const [36] = Utf8 ()Lde/audi/atip/storage/IStorageAccess; 
.const [37] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [38] = Utf8 getInt 
.const [39] = Utf8 (III)I 
.const [40] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [41] = Utf8 setInt 
.const [42] = Utf8 (III)V 
.const [43] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [44] = Utf8 isBentley 
.const [45] = Utf8 ()Z 
.const [46] = Utf8 de/audi/tghu/exlap/ExlapUtil 
.const [47] = Class [46] 
.const [48] = Utf8 java/lang/Object 
.const [49] = Class [48] 
.const [50] = Utf8 Code 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 readExlapStatus 
.const [54] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)I 
.const [55] = Utf8 persistExlapStatus 
.const [56] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;I)V 
.const [57] = Utf8 convertExlapStatus 
.const [58] = Utf8 (I)Z 
.const [59] = Utf8 convertExlapStatus 
.const [60] = Utf8 (Z)I 
.const [61] = Utf8 getExlapDefaultStatus 
.const [62] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)I 
.end class 
