.version 50 0 
.class public super [53] 
.super [55] 
.implements [57] 
.field private [58] [59] 

.method public [61] : [62] 
    .attribute [60] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [60] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [6] 
L4:     aload_1 
L5:     invokevirtual [7] 
L8:     astore_2 
L9:     aload_2 
L10:    ifnull L18 
L13:    aload_2 
L14:    invokevirtual [8] 
L17:    areturn 
L18:    aconst_null 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [60] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [6] 
L4:     aload_1 
L5:     invokevirtual [7] 
L8:     astore_3 
L9:     aload_3 
L10:    ifnull L31 
L13:    aload_3 
L14:    iload_2 
L15:    invokevirtual [9] 
L18:    astore 4 
L20:    aload 4 
L22:    ifnull L31 
L25:    aload 4 
L27:    invokevirtual [8] 
L30:    areturn 
L31:    aconst_null 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [60] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [6] 
L4:     aload_1 
L5:     invokevirtual [7] 
L8:     astore_3 
L9:     aload_3 
L10:    ifnull L19 
L13:    aload_3 
L14:    iload_2 
L15:    invokevirtual [10] 
L18:    areturn 
L19:    aconst_null 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [13] 
.const [3] = Class [14] 
.const [4] = Class [15] 
.const [5] = Class [16] 
.const [6] = Field [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreEntityResolver 
.const [14] = Utf8 java/lang/Object 
.const [15] = Utf8 de/esolutions/fw/util/tracing/model/TraceModel 
.const [16] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [17] = Class [31] 
.const [18] = NameAndType [32] [33] 
.const [19] = Class [34] 
.const [20] = NameAndType [35] [36] 
.const [21] = Class [37] 
.const [22] = NameAndType [38] [39] 
.const [23] = Class [40] 
.const [24] = NameAndType [41] [42] 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Class [46] 
.const [28] = NameAndType [47] [48] 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreEntityResolver 
.const [32] = Utf8 model 
.const [33] = Utf8 Lde/esolutions/fw/util/tracing/model/TraceModel; 
.const [34] = Utf8 de/esolutions/fw/util/tracing/model/TraceModel 
.const [35] = Utf8 getEntity 
.const [36] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [37] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [38] = Utf8 getName 
.const [39] = Utf8 ()Ljava/lang/String; 
.const [40] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [41] = Utf8 findParent 
.const [42] = Utf8 (S)Lde/esolutions/fw/util/tracing/model/TraceEntity; 
.const [43] = Utf8 de/esolutions/fw/util/tracing/model/TraceEntity 
.const [44] = Utf8 getPath 
.const [45] = Utf8 (Z)Ljava/lang/String; 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 <init> 
.const [48] = Utf8 ()V 
.const [49] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreEntityResolver 
.const [50] = Utf8 model 
.const [51] = Utf8 Lde/esolutions/fw/util/tracing/model/TraceModel; 
.const [52] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreEntityResolver 
.const [53] = Class [52] 
.const [54] = Utf8 java/lang/Object 
.const [55] = Class [54] 
.const [56] = Utf8 de/esolutions/fw/util/tracing/format/ITraceEntityResolver 
.const [57] = Class [56] 
.const [58] = Utf8 model 
.const [59] = Utf8 Lde/esolutions/fw/util/tracing/model/TraceModel; 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 (Lde/esolutions/fw/util/tracing/model/TraceModel;)V 
.const [63] = Utf8 resolveName 
.const [64] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;)Ljava/lang/String; 
.const [65] = Utf8 resolveParentName 
.const [66] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;S)Ljava/lang/String; 
.const [67] = Utf8 resolvePath 
.const [68] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;Z)Ljava/lang/String; 
.end class 
