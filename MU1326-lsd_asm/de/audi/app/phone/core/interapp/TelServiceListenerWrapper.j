.version 50 0 
.class public super [51] 
.super [53] 
.field private final [54] [55] 

.method public [57] : [58] 
    .attribute [56] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_1 
L5:     ifnonnull L18 
L8:     new [11] 
L11:    dup 
L12:    ldc [3] 
L14:    invokespecial [10] 
L17:    athrow 
L18:    aload_0 
L19:    aload_1 
L20:    putfield [12] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [56] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_0 
L5:     iload_1 
L6:     invokevirtual [8] 
L9:     invokeinterface [13] 0 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [61] : [62] 
    .attribute [56] .code stack 1 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            0 : L186 
            1 : L148 
            2 : L166 
            3 : L164 
            4 : L188 
            5 : L153 
            6 : L177 
            7 : L168 
            8 : L183 
            9 : L150 
            11 : L180 
            12 : L161 
            13 : L158 
            14 : L155 
            15 : L171 
            16 : L174 
            65541 : L190 
            default : L193 

L148:   iconst_1 
L149:   areturn 
L150:   bipush 9 
L152:   areturn 
L153:   iconst_5 
L154:   areturn 
L155:   bipush 14 
L157:   areturn 
L158:   bipush 13 
L160:   areturn 
L161:   bipush 12 
L163:   areturn 
L164:   iconst_3 
L165:   areturn 
L166:   iconst_2 
L167:   areturn 
L168:   bipush 7 
L170:   areturn 
L171:   bipush 15 
L173:   areturn 
L174:   bipush 16 
L176:   areturn 
L177:   bipush 6 
L179:   areturn 
L180:   bipush 11 
L182:   areturn 
L183:   bipush 8 
L185:   areturn 
L186:   iconst_0 
L187:   areturn 
L188:   iconst_4 
L189:   areturn 
L190:   bipush 16 
L192:   areturn 
L193:   iconst_4 
L194:   areturn 
L195:   nop 
L196:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = String [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Class [18] 
.const [7] = Field [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Class [27] 
.const [12] = Field [28] [29] 
.const [13] = InterfaceMethod [30] [31] 
.const [14] = Utf8 java/lang/IllegalArgumentException 
.const [15] = Utf8 'TelServiceListenerWrapper: serviceListener is null' 
.const [16] = Utf8 de/audi/app/phone/core/interapp/TelServiceListenerWrapper 
.const [17] = Utf8 de/audi/app/phone/core/dsi/TelDefaultDSIResponseListener 
.const [18] = Utf8 de/audi/atip/phone/ITelServiceListener 
.const [19] = Class [32] 
.const [20] = NameAndType [33] [34] 
.const [21] = Class [35] 
.const [22] = NameAndType [36] [37] 
.const [23] = Class [38] 
.const [24] = NameAndType [39] [40] 
.const [25] = Class [41] 
.const [26] = NameAndType [42] [43] 
.const [27] = Utf8 java/lang/IllegalArgumentException 
.const [28] = Class [44] 
.const [29] = NameAndType [45] [46] 
.const [30] = Class [47] 
.const [31] = NameAndType [48] [49] 
.const [32] = Utf8 de/audi/app/phone/core/interapp/TelServiceListenerWrapper 
.const [33] = Utf8 serviceListener 
.const [34] = Utf8 Lde/audi/atip/phone/ITelServiceListener; 
.const [35] = Utf8 de/audi/app/phone/core/interapp/TelServiceListenerWrapper 
.const [36] = Utf8 mapResultCode 
.const [37] = Utf8 (I)I 
.const [38] = Utf8 de/audi/app/phone/core/dsi/TelDefaultDSIResponseListener 
.const [39] = Utf8 <init> 
.const [40] = Utf8 ()V 
.const [41] = Utf8 java/lang/IllegalArgumentException 
.const [42] = Utf8 <init> 
.const [43] = Utf8 (Ljava/lang/String;)V 
.const [44] = Utf8 de/audi/app/phone/core/interapp/TelServiceListenerWrapper 
.const [45] = Utf8 serviceListener 
.const [46] = Utf8 Lde/audi/atip/phone/ITelServiceListener; 
.const [47] = Utf8 de/audi/atip/phone/ITelServiceListener 
.const [48] = Utf8 dialNumberResponse 
.const [49] = Utf8 (I)V 
.const [50] = Utf8 de/audi/app/phone/core/interapp/TelServiceListenerWrapper 
.const [51] = Class [50] 
.const [52] = Utf8 de/audi/app/phone/core/dsi/TelDefaultDSIResponseListener 
.const [53] = Class [52] 
.const [54] = Utf8 serviceListener 
.const [55] = Utf8 Lde/audi/atip/phone/ITelServiceListener; 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 (Lde/audi/atip/phone/ITelServiceListener;)V 
.const [59] = Utf8 responseDialNumber 
.const [60] = Utf8 (IILorg/dsi/ifc/telephoneng/SuppServiceResponseStruct;I)V 
.const [61] = Utf8 mapResultCode 
.const [62] = Utf8 (I)I 
.end class 
