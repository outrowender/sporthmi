.version 50 0 
.class public super [47] 
.super [49] 

.method public annotation [51] : [52] 
    .attribute [50] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [53] : [54] 
    .attribute [50] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [6] 
L4:     invokeinterface [10] 0 
L9:     istore_1 
L10:    iconst_0 
L11:    istore_2 
L12:    iload_2 
L13:    iload_1 
L14:    if_icmpge L47 
L17:    aload_0 
L18:    getfield [6] 
L21:    iload_2 
L22:    invokeinterface [11] 0 
L27:    checkcast [2] 
L30:    checkcast [2] 
L33:    invokevirtual [7] 
L36:    ifeq L41 
L39:    iconst_1 
L40:    areturn 
L41:    iinc 2 1 
L44:    goto L12 
L47:    iconst_0 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [55] : [56] 
    .attribute [50] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [6] 
L4:     invokeinterface [10] 0 
L9:     istore_2 
L10:    iconst_0 
L11:    istore_3 
L12:    iload_3 
L13:    iload_2 
L14:    if_icmpge L48 
L17:    aload_0 
L18:    getfield [6] 
L21:    iload_3 
L22:    invokeinterface [11] 0 
L27:    checkcast [2] 
L30:    checkcast [2] 
L33:    aload_1 
L34:    invokevirtual [8] 
L37:    ifne L42 
L40:    iconst_0 
L41:    areturn 
L42:    iinc 3 1 
L45:    goto L12 
L48:    iconst_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [50] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Class [15] 
.const [6] = Field [16] [17] 
.const [7] = Method [18] [19] 
.const [8] = Method [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = InterfaceMethod [24] [25] 
.const [11] = InterfaceMethod [26] [27] 
.const [12] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition 
.const [13] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$And 
.const [14] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$Operation 
.const [15] = Utf8 java/util/List 
.const [16] = Class [28] 
.const [17] = NameAndType [29] [30] 
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
.const [28] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$And 
.const [29] = Utf8 terms 
.const [30] = Utf8 Ljava/util/List; 
.const [31] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition 
.const [32] = Utf8 hasDestinctServiceInterfaces 
.const [33] = Utf8 ()Z 
.const [34] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition 
.const [35] = Utf8 isFulfilled 
.const [36] = Utf8 (Ljava/util/Dictionary;)Z 
.const [37] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$Operation 
.const [38] = Utf8 <init> 
.const [39] = Utf8 ()V 
.const [40] = Utf8 java/util/List 
.const [41] = Utf8 size 
.const [42] = Utf8 ()I 
.const [43] = Utf8 java/util/List 
.const [44] = Utf8 get 
.const [45] = Utf8 (I)Ljava/lang/Object; 
.const [46] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$And 
.const [47] = Class [46] 
.const [48] = Utf8 de/dreisoft/lsd/ServiceFilter$Condition$Operation 
.const [49] = Class [48] 
.const [50] = Utf8 Code 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 hasDestinctServiceInterfaces 
.const [54] = Utf8 ()Z 
.const [55] = Utf8 isFulfilled 
.const [56] = Utf8 (Ljava/util/Dictionary;)Z 
.const [57] = Utf8 isServiceInterfaceList 
.const [58] = Utf8 ()Z 
.end class 
