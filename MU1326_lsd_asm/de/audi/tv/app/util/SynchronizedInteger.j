.version 50 0 
.class public super [57] 
.super [59] 
.field private [60] [61] 

.method public [63] : [64] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     invokespecial [10] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [67] : [68] 
    .attribute [62] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [69] : [70] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [12] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [71] : [72] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [7] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [73] : [74] 
    .attribute [62] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [6] 
L5:     iload_1 
L6:     iadd 
L7:     putfield [12] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [75] : [76] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [8] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [77] : [78] 
    .attribute [62] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [6] 
L5:     iload_1 
L6:     isub 
L7:     putfield [12] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [79] : [80] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     iload_1 
L5:     if_icmple L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [81] : [82] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     iload_1 
L5:     if_icmple L12 
L8:     aload_0 
L9:     invokevirtual [9] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [83] : [84] 
    .attribute [62] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     invokestatic [2] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [13] [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Field [18] [19] 
.const [7] = Method [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = Class [32] 
.const [14] = NameAndType [33] [34] 
.const [15] = Utf8 de/audi/tv/app/util/SynchronizedInteger 
.const [16] = Utf8 java/lang/Object 
.const [17] = Utf8 java/lang/String 
.const [18] = Class [35] 
.const [19] = NameAndType [36] [37] 
.const [20] = Class [38] 
.const [21] = NameAndType [39] [40] 
.const [22] = Class [41] 
.const [23] = NameAndType [42] [43] 
.const [24] = Class [44] 
.const [25] = NameAndType [45] [46] 
.const [26] = Class [47] 
.const [27] = NameAndType [48] [49] 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Utf8 java/lang/String 
.const [33] = Utf8 valueOf 
.const [34] = Utf8 (I)Ljava/lang/String; 
.const [35] = Utf8 de/audi/tv/app/util/SynchronizedInteger 
.const [36] = Utf8 value 
.const [37] = Utf8 I 
.const [38] = Utf8 de/audi/tv/app/util/SynchronizedInteger 
.const [39] = Utf8 incrementBy 
.const [40] = Utf8 (I)V 
.const [41] = Utf8 de/audi/tv/app/util/SynchronizedInteger 
.const [42] = Utf8 decrementBy 
.const [43] = Utf8 (I)V 
.const [44] = Utf8 de/audi/tv/app/util/SynchronizedInteger 
.const [45] = Utf8 decrement 
.const [46] = Utf8 ()V 
.const [47] = Utf8 de/audi/tv/app/util/SynchronizedInteger 
.const [48] = Utf8 <init> 
.const [49] = Utf8 (I)V 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 de/audi/tv/app/util/SynchronizedInteger 
.const [54] = Utf8 value 
.const [55] = Utf8 I 
.const [56] = Utf8 de/audi/tv/app/util/SynchronizedInteger 
.const [57] = Class [56] 
.const [58] = Utf8 java/lang/Object 
.const [59] = Class [58] 
.const [60] = Utf8 value 
.const [61] = Utf8 I 
.const [62] = Utf8 Code 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ()V 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (I)V 
.const [67] = Utf8 get 
.const [68] = Utf8 ()I 
.const [69] = Utf8 setValue 
.const [70] = Utf8 (I)V 
.const [71] = Utf8 increment 
.const [72] = Utf8 ()V 
.const [73] = Utf8 incrementBy 
.const [74] = Utf8 (I)V 
.const [75] = Utf8 decrement 
.const [76] = Utf8 ()V 
.const [77] = Utf8 decrementBy 
.const [78] = Utf8 (I)V 
.const [79] = Utf8 isGreaterThan 
.const [80] = Utf8 (I)Z 
.const [81] = Utf8 decrementIfGreaterThan 
.const [82] = Utf8 (I)V 
.const [83] = Utf8 toString 
.const [84] = Utf8 ()Ljava/lang/String; 
.end class 
