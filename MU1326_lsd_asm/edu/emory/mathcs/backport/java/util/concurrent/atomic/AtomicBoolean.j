.version 50 0 
.class public super [39] 
.super [41] 
.implements [43] 
.field private static final [44] [45] 
.field private volatile [46] [47] 

.method public [49] : [50] 
    .attribute [48] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     aload_0 
L5:     iload_1 
L6:     ifeq L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    putfield [9] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public annotation [51] : [52] 
    .attribute [48] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [53] : [54] 
    .attribute [48] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     ifeq L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public final synchronized [55] : [56] 
    .attribute [48] .code stack 2 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [6] 
L5:     ifeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    if_icmpne L31 
L16:    aload_0 
L17:    iload_2 
L18:    ifeq L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    putfield [9] 
L29:    iconst_1 
L30:    areturn 
L31:    iconst_0 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public synchronized [57] : [58] 
    .attribute [48] .code stack 2 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [6] 
L5:     ifeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    if_icmpne L31 
L16:    aload_0 
L17:    iload_2 
L18:    ifeq L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    putfield [9] 
L29:    iconst_1 
L30:    areturn 
L31:    iconst_0 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public final synchronized [59] : [60] 
    .attribute [48] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     ifeq L9 
L5:     iconst_1 
L6:     goto L10 
L9:     iconst_0 
L10:    putfield [9] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public final synchronized [61] : [62] 
    .attribute [48] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     ifeq L9 
L5:     iconst_1 
L6:     goto L10 
L9:     iconst_0 
L10:    putfield [9] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public final synchronized [63] : [64] 
    .attribute [48] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [6] 
L4:     istore_2 
L5:     aload_0 
L6:     iload_1 
L7:     ifeq L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    putfield [9] 
L18:    iload_2 
L19:    ifeq L26 
L22:    iconst_1 
L23:    goto L27 
L26:    iconst_0 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [48] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
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
.const [12] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicBoolean 
.const [13] = Utf8 java/lang/Object 
.const [14] = Utf8 java/lang/Boolean 
.const [15] = Class [26] 
.const [16] = NameAndType [27] [28] 
.const [17] = Class [29] 
.const [18] = NameAndType [30] [31] 
.const [19] = Class [32] 
.const [20] = NameAndType [33] [34] 
.const [21] = Class [35] 
.const [22] = NameAndType [36] [37] 
.const [23] = Utf8 java/lang/Boolean 
.const [24] = Utf8 toString 
.const [25] = Utf8 (Z)Ljava/lang/String; 
.const [26] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicBoolean 
.const [27] = Utf8 value 
.const [28] = Utf8 I 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 <init> 
.const [31] = Utf8 ()V 
.const [32] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicBoolean 
.const [33] = Utf8 get 
.const [34] = Utf8 ()Z 
.const [35] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicBoolean 
.const [36] = Utf8 value 
.const [37] = Utf8 I 
.const [38] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicBoolean 
.const [39] = Class [38] 
.const [40] = Utf8 java/lang/Object 
.const [41] = Class [40] 
.const [42] = Utf8 java/io/Serializable 
.const [43] = Class [42] 
.const [44] = Utf8 serialVersionUID 
.const [45] = Utf8 J 
.const [46] = Utf8 value 
.const [47] = Utf8 I 
.const [48] = Utf8 Code 
.const [49] = Utf8 <init> 
.const [50] = Utf8 (Z)V 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 get 
.const [54] = Utf8 ()Z 
.const [55] = Utf8 compareAndSet 
.const [56] = Utf8 (ZZ)Z 
.const [57] = Utf8 weakCompareAndSet 
.const [58] = Utf8 (ZZ)Z 
.const [59] = Utf8 set 
.const [60] = Utf8 (Z)V 
.const [61] = Utf8 lazySet 
.const [62] = Utf8 (Z)V 
.const [63] = Utf8 getAndSet 
.const [64] = Utf8 (Z)Z 
.const [65] = Utf8 toString 
.const [66] = Utf8 ()Ljava/lang/String; 
.end class 
