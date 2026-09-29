.version 50 0 
.class public super [53] 
.super [55] 
.field private [56] [57] 

.method public annotation [59] : [60] 
    .attribute [58] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     invokespecial [7] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [58] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [8] 
L6:     aload_0 
L7:     aload_3 
L8:     putfield [9] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [58] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [6] 
L5:     invokeinterface [10] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [58] .code stack 2 locals 1 
L0:     aload_1 
L1:     invokeinterface [11] 0 
L6:     istore_2 
L7:     aload_0 
L8:     iload_2 
L9:     newarray byte 
L11:    putfield [9] 
L14:    aload_1 
L15:    aload_0 
L16:    getfield [6] 
L19:    invokeinterface [12] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [67] : [68] 
    .attribute [58] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
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
.const [9] = Field [23] [24] 
.const [10] = InterfaceMethod [25] [26] 
.const [11] = InterfaceMethod [27] [28] 
.const [12] = InterfaceMethod [29] [30] 
.const [13] = Utf8 de/esolutions/fw/comm/core/message/RawMessage 
.const [14] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [15] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [16] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
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
.const [31] = Utf8 de/esolutions/fw/comm/core/message/RawMessage 
.const [32] = Utf8 data 
.const [33] = Utf8 [B 
.const [34] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [35] = Utf8 <init> 
.const [36] = Utf8 (Lde/esolutions/fw/comm/core/message/MessageType;Lde/esolutions/fw/util/serializer/IDeserializer;Z)V 
.const [37] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [38] = Utf8 <init> 
.const [39] = Utf8 (Lde/esolutions/fw/comm/core/message/MessageType;Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [40] = Utf8 de/esolutions/fw/comm/core/message/RawMessage 
.const [41] = Utf8 data 
.const [42] = Utf8 [B 
.const [43] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [44] = Utf8 putRawBytes 
.const [45] = Utf8 ([B)V 
.const [46] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [47] = Utf8 bytesLeft 
.const [48] = Utf8 ()I 
.const [49] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [50] = Utf8 getRawBytes 
.const [51] = Utf8 ([B)V 
.const [52] = Utf8 de/esolutions/fw/comm/core/message/RawMessage 
.const [53] = Class [52] 
.const [54] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [55] = Class [54] 
.const [56] = Utf8 data 
.const [57] = Utf8 [B 
.const [58] = Utf8 Code 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Lde/esolutions/fw/comm/core/message/MessageType;Lde/esolutions/fw/util/serializer/IDeserializer;Z)V 
.const [61] = Utf8 <init> 
.const [62] = Utf8 (Lde/esolutions/fw/comm/core/message/MessageType;Lde/esolutions/fw/util/serializer/ISerializer;[B)V 
.const [63] = Utf8 serializeElements 
.const [64] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [65] = Utf8 deserializeElements 
.const [66] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [67] = Utf8 getData 
.const [68] = Utf8 ()[B 
.end class 
