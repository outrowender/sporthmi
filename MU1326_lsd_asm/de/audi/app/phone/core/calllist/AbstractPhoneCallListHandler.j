.version 50 0 
.class public super abstract [160] 
.super [162] 
.implements [164] 
.field protected volatile [165] [166] 
.field protected final [167] [168] 

.method public [170] : [171] 
    .attribute [169] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [24] 
L6:     aload_0 
L7:     new [28] 
L10:    dup 
L11:    invokespecial [25] 
L14:    putfield [29] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [172] : [173] 
    .attribute [169] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     invokeinterface [30] 0 
L9:     aload_0 
L10:    invokeinterface [31] 0 
L15:    aload_0 
L16:    invokespecial [26] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [174] : [175] 
    .attribute [169] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     invokeinterface [30] 0 
L9:     aload_0 
L10:    invokeinterface [32] 0 
L15:    aload_0 
L16:    invokespecial [27] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [169] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L26 using L243 
L7:     aload_2 
L8:     ifnonnull L27 
L11:    aload_0 
L12:    getfield [16] 
L15:    sipush 10000 
L18:    ldc [3] 
L20:    invokevirtual [17] 
L23:    pop 
L24:    aload_3 
L25:    monitorexit 
L26:    return 
        .catch [0] from L27 to L74 using L243 
L27:    aload_0 
L28:    aload_2 
L29:    putfield [33] 
L32:    aload_2 
L33:    invokeinterface [34] 0 
L38:    invokeinterface [35] 0 
L43:    ifeq L75 
L46:    aload_2 
L47:    invokeinterface [34] 0 
L52:    invokeinterface [36] 0 
L57:    ifne L75 
L60:    aload_0 
L61:    getfield [16] 
L64:    ldc [4] 
L66:    ldc [5] 
L68:    invokevirtual [17] 
L71:    pop 
L72:    aload_3 
L73:    monitorexit 
L74:    return 
        .catch [0] from L75 to L240 using L243 
L75:    iload_1 
L76:    lookupswitch 
            65543 : L192 
            65544 : L200 
            65550 : L216 
            65553 : L208 
            131079 : L192 
            131080 : L200 
            131086 : L216 
            131089 : L208 
            196615 : L192 
            196616 : L200 
            196622 : L216 
            196625 : L208 
            262156 : L200 
            default : L224 

L192:   aload_0 
L193:   aload_2 
L194:   invokevirtual [19] 
L197:   goto L238 
L200:   aload_0 
L201:   aload_2 
L202:   invokevirtual [20] 
L205:   goto L238 
L208:   aload_0 
L209:   aload_2 
L210:   invokevirtual [21] 
L213:   goto L238 
L216:   aload_0 
L217:   aload_2 
L218:   invokevirtual [22] 
L221:   goto L238 
L224:   aload_0 
L225:   getfield [16] 
L228:   ldc [4] 
L230:   ldc [6] 
L232:   iload_1 
L233:   i2l 
L234:   invokevirtual [23] 
L237:   pop 
L238:   aload_3 
L239:   monitorexit 
L240:   goto L250 
        .catch [0] from L243 to L247 using L243 
L243:   astore 4 
L245:   aload_3 
L246:   monitorexit 
L247:   aload 4 
L249:   athrow 
L250:   return 
L251:   nop 
L252:   
    .end code 
.end method 

.method protected [178] : [179] 
    .attribute [169] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L13 using L14 
L7:     aload_0 
L8:     getfield [18] 
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

.method public abstract [180] : [181] 
    .attribute [169] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [182] : [183] 
    .attribute [169] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [184] : [185] 
    .attribute [169] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [186] : [187] 
    .attribute [169] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = String [38] 
.const [4] = Int -2137614336 
.const [5] = String [39] 
.const [6] = String [40] 
.const [7] = Class [41] 
.const [8] = Class [42] 
.const [9] = Class [43] 
.const [10] = Class [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Field [48] [49] 
.const [15] = Method [50] [51] 
.const [16] = Field [52] [53] 
.const [17] = Method [54] [55] 
.const [18] = Field [56] [57] 
.const [19] = Method [58] [59] 
.const [20] = Method [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Class [76] 
.const [29] = Field [77] [78] 
.const [30] = InterfaceMethod [79] [80] 
.const [31] = InterfaceMethod [81] [82] 
.const [32] = InterfaceMethod [83] [84] 
.const [33] = Field [85] [86] 
.const [34] = InterfaceMethod [87] [88] 
.const [35] = InterfaceMethod [89] [90] 
.const [36] = InterfaceMethod [91] [92] 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 'AbstractPhoneCallListHandler#updateGlobalTelephoneStateProperty stateStruct is null' 
.const [39] = Utf8 'AbstractPhoneCallListHandler#updateGlobalTelephoneStateProperty(): ecall is active' 
.const [40] = Utf8 '[AbstractPhoneCallListHandler#updateGlobalTelephoneStateProperty] no handling for key %1' 
.const [41] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [42] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [43] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [44] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [47] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [48] = Class [93] 
.const [49] = NameAndType [94] [95] 
.const [50] = Class [96] 
.const [51] = NameAndType [97] [98] 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Utf8 java/lang/Object 
.const [77] = Class [135] 
.const [78] = NameAndType [136] [137] 
.const [79] = Class [138] 
.const [80] = NameAndType [139] [140] 
.const [81] = Class [141] 
.const [82] = NameAndType [142] [143] 
.const [83] = Class [144] 
.const [84] = NameAndType [145] [146] 
.const [85] = Class [147] 
.const [86] = NameAndType [148] [149] 
.const [87] = Class [150] 
.const [88] = NameAndType [151] [152] 
.const [89] = Class [153] 
.const [90] = NameAndType [154] [155] 
.const [91] = Class [156] 
.const [92] = NameAndType [157] [158] 
.const [93] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [94] = Utf8 stateMutex 
.const [95] = Utf8 Ljava/lang/Object; 
.const [96] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [97] = Utf8 getApplication 
.const [98] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [99] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [100] = Utf8 log 
.const [101] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [102] = Utf8 de/audi/atip/log/LogChannel 
.const [103] = Utf8 log 
.const [104] = Utf8 (ILjava/lang/String;)Z 
.const [105] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [106] = Utf8 state 
.const [107] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [108] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [109] = Utf8 updateCallDurationList 
.const [110] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [111] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [112] = Utf8 updateCallList 
.const [113] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [114] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [115] = Utf8 updateMicMuteState 
.const [116] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [117] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [118] = Utf8 updateHandsfreeModeState 
.const [119] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 log 
.const [122] = Utf8 (ILjava/lang/String;J)Z 
.const [123] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [126] = Utf8 java/lang/Object 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [130] = Utf8 init 
.const [131] = Utf8 ()V 
.const [132] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [133] = Utf8 deinit 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [136] = Utf8 stateMutex 
.const [137] = Utf8 Ljava/lang/Object; 
.const [138] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [139] = Utf8 getGlobalTelephoneStateManager 
.const [140] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [141] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [142] = Utf8 registerListener 
.const [143] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [144] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [145] = Utf8 removeListener 
.const [146] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [147] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [148] = Utf8 state 
.const [149] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [150] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [151] = Utf8 getConnectedGatewayState 
.const [152] = Utf8 ()Lde/audi/atip/interapp/phone/IEcallState; 
.const [153] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [154] = Utf8 isCustomerCallNotAllowed 
.const [155] = Utf8 ()Z 
.const [156] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [157] = Utf8 isLowPrioritySOSEmergencyCallType 
.const [158] = Utf8 ()Z 
.const [159] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCallListHandler 
.const [160] = Class [159] 
.const [161] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [162] = Class [161] 
.const [163] = Utf8 de/audi/app/phone/core/calllist/ITelCallList 
.const [164] = Class [163] 
.const [165] = Utf8 state 
.const [166] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [167] = Utf8 stateMutex 
.const [168] = Utf8 Ljava/lang/Object; 
.const [169] = Utf8 Code 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [172] = Utf8 init 
.const [173] = Utf8 ()V 
.const [174] = Utf8 deinit 
.const [175] = Utf8 ()V 
.const [176] = Utf8 updateGlobalTelephoneStateProperty 
.const [177] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [178] = Utf8 getCurrentState 
.const [179] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [180] = Utf8 updateCallDurationList 
.const [181] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [182] = Utf8 updateCallList 
.const [183] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [184] = Utf8 updateMicMuteState 
.const [185] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [186] = Utf8 updateHandsfreeModeState 
.const [187] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.end class 
