.version 50 0 
.class public super [39] 
.super [41] 
.field private final [42] [43] 
.field private [44] [45] 

.method public [47] : [48] 
    .attribute [46] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [7] 
L9:     aload_0 
L10:    new [8] 
L13:    dup 
L14:    invokespecial [6] 
L17:    putfield [9] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [49] : [50] 
    .attribute [46] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [5] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L14 using L17 
L7:     aload_0 
L8:     iload_1 
L9:     putfield [7] 
L12:    aload_2 
L13:    monitorexit 
L14:    goto L22 
        .catch [0] from L17 to L20 using L17 
L17:    astore_3 
L18:    aload_2 
L19:    monitorexit 
L20:    aload_3 
L21:    athrow 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [51] : [52] 
    .attribute [46] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [5] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L13 using L14 
L7:     aload_0 
L8:     getfield [4] 
L11:    aload_1 
L12:    monitorexit 
L13:    areturn 
        .catch [0] from L14 to L17 using L14 
L14:    astore_2 
L15:    aload_1 
L16:    monitorexit 
L17:    aload_2 
L18:    athrow 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [10] 
.const [3] = Class [11] 
.const [4] = Field [12] [13] 
.const [5] = Field [14] [15] 
.const [6] = Method [16] [17] 
.const [7] = Field [18] [19] 
.const [8] = Class [20] 
.const [9] = Field [21] [22] 
.const [10] = Utf8 java/lang/Object 
.const [11] = Utf8 de/audi/tuner/app/GeneralStatusHandler 
.const [12] = Class [23] 
.const [13] = NameAndType [24] [25] 
.const [14] = Class [26] 
.const [15] = NameAndType [27] [28] 
.const [16] = Class [29] 
.const [17] = NameAndType [30] [31] 
.const [18] = Class [32] 
.const [19] = NameAndType [33] [34] 
.const [20] = Utf8 java/lang/Object 
.const [21] = Class [35] 
.const [22] = NameAndType [36] [37] 
.const [23] = Utf8 de/audi/tuner/app/GeneralStatusHandler 
.const [24] = Utf8 status 
.const [25] = Utf8 I 
.const [26] = Utf8 de/audi/tuner/app/GeneralStatusHandler 
.const [27] = Utf8 mutex 
.const [28] = Utf8 Ljava/lang/Object; 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 <init> 
.const [31] = Utf8 ()V 
.const [32] = Utf8 de/audi/tuner/app/GeneralStatusHandler 
.const [33] = Utf8 status 
.const [34] = Utf8 I 
.const [35] = Utf8 de/audi/tuner/app/GeneralStatusHandler 
.const [36] = Utf8 mutex 
.const [37] = Utf8 Ljava/lang/Object; 
.const [38] = Utf8 de/audi/tuner/app/GeneralStatusHandler 
.const [39] = Class [38] 
.const [40] = Utf8 java/lang/Object 
.const [41] = Class [40] 
.const [42] = Utf8 mutex 
.const [43] = Utf8 Ljava/lang/Object; 
.const [44] = Utf8 status 
.const [45] = Utf8 I 
.const [46] = Utf8 Code 
.const [47] = Utf8 <init> 
.const [48] = Utf8 (I)V 
.const [49] = Utf8 setStatus 
.const [50] = Utf8 (I)V 
.const [51] = Utf8 getStatus 
.const [52] = Utf8 ()I 
.end class 
