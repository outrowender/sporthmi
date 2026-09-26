.version 50 0 
.class public super [39] 
.super [41] 
.field private [42] [43] 

.method public [45] : [46] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [9] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [47] : [48] 
    .attribute [44] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [49] : [50] 
    .attribute [44] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [6] 
L5:     aload_0 
L6:     getfield [6] 
L9:     iload_1 
L10:    ior 
L11:    invokevirtual [7] 
L14:    ifeq L27 
L17:    aload_0 
L18:    dup 
L19:    getfield [6] 
L22:    iload_1 
L23:    ior 
L24:    putfield [9] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [51] : [52] 
    .attribute [44] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [6] 
L5:     aload_0 
L6:     getfield [6] 
L9:     iload_1 
L10:    iconst_m1 
L11:    ixor 
L12:    iand 
L13:    invokevirtual [7] 
L16:    ifeq L31 
L19:    aload_0 
L20:    dup 
L21:    getfield [6] 
L24:    iload_1 
L25:    iconst_m1 
L26:    ixor 
L27:    iand 
L28:    putfield [9] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [53] : [54] 
    .attribute [44] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [6] 
L5:     iload_1 
L6:     invokevirtual [7] 
L9:     ifeq L17 
L12:    aload_0 
L13:    iload_1 
L14:    putfield [9] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [55] : [56] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     iload_1 
L5:     iand 
L6:     ifle L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     iload_1 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     invokestatic [2] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [10] [11] 
.const [3] = Class [12] 
.const [4] = Class [13] 
.const [5] = Class [14] 
.const [6] = Field [15] [16] 
.const [7] = Method [17] [18] 
.const [8] = Method [19] [20] 
.const [9] = Field [21] [22] 
.const [10] = Class [23] 
.const [11] = NameAndType [24] [25] 
.const [12] = Utf8 de/audi/tghu/navi/app/map/utils/BitState 
.const [13] = Utf8 java/lang/Object 
.const [14] = Utf8 java/lang/Integer 
.const [15] = Class [26] 
.const [16] = NameAndType [27] [28] 
.const [17] = Class [29] 
.const [18] = NameAndType [30] [31] 
.const [19] = Class [32] 
.const [20] = NameAndType [33] [34] 
.const [21] = Class [35] 
.const [22] = NameAndType [36] [37] 
.const [23] = Utf8 java/lang/Integer 
.const [24] = Utf8 toBinaryString 
.const [25] = Utf8 (I)Ljava/lang/String; 
.const [26] = Utf8 de/audi/tghu/navi/app/map/utils/BitState 
.const [27] = Utf8 rgState 
.const [28] = Utf8 I 
.const [29] = Utf8 de/audi/tghu/navi/app/map/utils/BitState 
.const [30] = Utf8 isValid 
.const [31] = Utf8 (II)Z 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 <init> 
.const [34] = Utf8 ()V 
.const [35] = Utf8 de/audi/tghu/navi/app/map/utils/BitState 
.const [36] = Utf8 rgState 
.const [37] = Utf8 I 
.const [38] = Utf8 de/audi/tghu/navi/app/map/utils/BitState 
.const [39] = Class [38] 
.const [40] = Utf8 java/lang/Object 
.const [41] = Class [40] 
.const [42] = Utf8 rgState 
.const [43] = Utf8 I 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 isValid 
.const [48] = Utf8 (II)Z 
.const [49] = Utf8 add 
.const [50] = Utf8 (I)V 
.const [51] = Utf8 remove 
.const [52] = Utf8 (I)V 
.const [53] = Utf8 set 
.const [54] = Utf8 (I)V 
.const [55] = Utf8 has 
.const [56] = Utf8 (I)Z 
.const [57] = Utf8 is 
.const [58] = Utf8 (I)Z 
.const [59] = Utf8 toString 
.const [60] = Utf8 ()Ljava/lang/String; 
.end class 
