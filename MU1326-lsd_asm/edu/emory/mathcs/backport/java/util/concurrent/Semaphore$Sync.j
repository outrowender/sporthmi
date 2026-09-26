.version 50 0 
.class super abstract [25] 
.super [27] 
.implements [29] 
.field private static final [30] [31] 
.field [32] [33] 

.method protected [35] : [36] 
    .attribute [34] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [5] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [6] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method abstract [37] : [38] 
    .attribute [34] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method abstract [39] : [40] 
    .attribute [34] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [41] : [42] 
    .attribute [34] .code stack 3 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L25 using L30 
L4:     aload_0 
L5:     getfield [4] 
L8:     iload_1 
L9:     if_icmplt L26 
L12:    aload_0 
L13:    dup 
L14:    getfield [4] 
L17:    iload_1 
L18:    isub 
L19:    putfield [6] 
L22:    iconst_1 
L23:    aload_2 
L24:    monitorexit 
L25:    areturn 
        .catch [0] from L26 to L29 using L30 
L26:    iconst_0 
L27:    aload_2 
L28:    monitorexit 
L29:    areturn 
        .catch [0] from L30 to L33 using L30 
L30:    astore_3 
L31:    aload_2 
L32:    monitorexit 
L33:    aload_3 
L34:    athrow 
L35:    nop 
L36:    
    .end code 
.end method 

.method abstract [43] : [44] 
    .attribute [34] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method abstract [45] : [46] 
    .attribute [34] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public synchronized [47] : [48] 
    .attribute [34] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [49] : [50] 
    .attribute [34] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [4] 
L4:     istore_1 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [6] 
L10:    iload_1 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public synchronized [51] : [52] 
    .attribute [34] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [4] 
L5:     iload_1 
L6:     isub 
L7:     putfield [6] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method abstract [53] : [54] 
    .attribute [34] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method abstract [55] : [56] 
    .attribute [34] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method abstract [57] : [58] 
    .attribute [34] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [7] 
.const [3] = Class [8] 
.const [4] = Field [9] [10] 
.const [5] = Method [11] [12] 
.const [6] = Field [13] [14] 
.const [7] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [8] = Utf8 java/lang/Object 
.const [9] = Class [15] 
.const [10] = NameAndType [16] [17] 
.const [11] = Class [18] 
.const [12] = NameAndType [19] [20] 
.const [13] = Class [21] 
.const [14] = NameAndType [22] [23] 
.const [15] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [16] = Utf8 permits_ 
.const [17] = Utf8 I 
.const [18] = Utf8 java/lang/Object 
.const [19] = Utf8 <init> 
.const [20] = Utf8 ()V 
.const [21] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [22] = Utf8 permits_ 
.const [23] = Utf8 I 
.const [24] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [25] = Class [24] 
.const [26] = Utf8 java/lang/Object 
.const [27] = Class [26] 
.const [28] = Utf8 java/io/Serializable 
.const [29] = Class [28] 
.const [30] = Utf8 serialVersionUID 
.const [31] = Utf8 J 
.const [32] = Utf8 permits_ 
.const [33] = Utf8 I 
.const [34] = Utf8 Code 
.const [35] = Utf8 <init> 
.const [36] = Utf8 (I)V 
.const [37] = Utf8 acquireUninterruptibly 
.const [38] = Utf8 (I)V 
.const [39] = Utf8 acquire 
.const [40] = Utf8 (I)V 
.const [41] = Utf8 attempt 
.const [42] = Utf8 (I)Z 
.const [43] = Utf8 attempt 
.const [44] = Utf8 (IJ)Z 
.const [45] = Utf8 release 
.const [46] = Utf8 (I)V 
.const [47] = Utf8 getPermits 
.const [48] = Utf8 ()I 
.const [49] = Utf8 drain 
.const [50] = Utf8 ()I 
.const [51] = Utf8 reduce 
.const [52] = Utf8 (I)V 
.const [53] = Utf8 hasQueuedThreads 
.const [54] = Utf8 ()Z 
.const [55] = Utf8 getQueueLength 
.const [56] = Utf8 ()I 
.const [57] = Utf8 getQueuedThreads 
.const [58] = Utf8 ()Ljava/util/Collection; 
.end class 
