.version 50 0 
.class super [112] 
.super [114] 
.implements [116] 
.field private final synthetic [117] [118] 

.method private [120] : [121] 
    .attribute [119] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [26] 
L5:     aload_0 
L6:     invokespecial [25] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [122] : [123] 
    .attribute [119] .code stack 4 locals 6 
L0:     aload_1 
L1:     ifnull L172 
L4:     iconst_0 
L5:     istore_2 
L6:     iload_2 
L7:     aload_1 
L8:     arraylength 
L9:     if_icmpge L169 
L12:    aload_1 
L13:    iload_2 
L14:    aaload 
L15:    astore_3 
L16:    aload_3 
L17:    ifnull L163 
L20:    aload_3 
L21:    invokestatic [2] 
L24:    istore 4 
L26:    aload_3 
L27:    invokevirtual [18] 
L30:    astore 5 
L32:    iload 4 
L34:    ifeq L57 
L37:    aload_0 
L38:    getfield [17] 
L41:    invokestatic [3] 
L44:    ldc [4] 
L46:    ldc [5] 
L48:    aload 5 
L50:    invokevirtual [19] 
L53:    pop 
L54:    goto L74 
L57:    aload_0 
L58:    getfield [17] 
L61:    invokestatic [6] 
L64:    ldc [4] 
L66:    ldc [7] 
L68:    aload 5 
L70:    invokevirtual [19] 
L73:    pop 
L74:    aload_0 
L75:    getfield [17] 
L78:    invokestatic [8] 
L81:    dup 
L82:    astore 6 
L84:    monitorenter 
        .catch [0] from L85 to L152 using L155 
L85:    iload 4 
L87:    ifeq L121 
L90:    aload_0 
L91:    getfield [17] 
L94:    invokestatic [8] 
L97:    aload 5 
L99:    invokevirtual [20] 
L102:   ifne L149 
L105:   aload_0 
L106:   getfield [17] 
L109:   invokestatic [8] 
L112:   aload 5 
L114:   invokevirtual [21] 
L117:   pop 
L118:   goto L149 
L121:   aload_0 
L122:   getfield [17] 
L125:   invokestatic [8] 
L128:   aload 5 
L130:   invokevirtual [20] 
L133:   ifeq L149 
L136:   aload_0 
L137:   getfield [17] 
L140:   invokestatic [8] 
L143:   aload 5 
L145:   invokevirtual [22] 
L148:   pop 
L149:   aload 6 
L151:   monitorexit 
L152:   goto L163 
        .catch [0] from L155 to L160 using L155 
L155:   astore 7 
L157:   aload 6 
L159:   monitorexit 
L160:   aload 7 
L162:   athrow 
L163:   iinc 2 1 
L166:   goto L6 
L169:   goto L188 
L172:   aload_0 
L173:   getfield [17] 
L176:   invokestatic [9] 
L179:   sipush 10000 
L182:   ldc [10] 
L184:   invokevirtual [23] 
L187:   pop 
L188:   return 
L189:   nop 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method synthetic [124] : [125] 
    .attribute [119] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [27] [28] 
.const [3] = Method [29] [30] 
.const [4] = Int -2137614336 
.const [5] = String [31] 
.const [6] = Method [32] [33] 
.const [7] = String [34] 
.const [8] = Method [35] [36] 
.const [9] = Method [37] [38] 
.const [10] = String [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Class [44] 
.const [16] = Class [45] 
.const [17] = Field [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Method [58] [59] 
.const [24] = Method [60] [61] 
.const [25] = Method [62] [63] 
.const [26] = Field [64] [65] 
.const [27] = Class [66] 
.const [28] = NameAndType [67] [68] 
.const [29] = Class [69] 
.const [30] = NameAndType [70] [71] 
.const [31] = Utf8 '[AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices] %1 connected via HFP or SAP' 
.const [32] = Class [72] 
.const [33] = NameAndType [73] [74] 
.const [34] = Utf8 '[AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices] %1 not connected via HFP or SAP' 
.const [35] = Class [75] 
.const [36] = NameAndType [76] [77] 
.const [37] = Class [78] 
.const [38] = NameAndType [79] [80] 
.const [39] = Utf8 'AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices trustedDevices is null' 
.const [40] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [43] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [44] = Utf8 de/audi/atip/log/LogChannel 
.const [45] = Utf8 java/util/LinkedList 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Class [105] 
.const [63] = NameAndType [106] [107] 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [67] = Utf8 access$100 
.const [68] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [69] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [70] = Utf8 access$200 
.const [71] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)Lde/audi/atip/log/LogChannel; 
.const [72] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [73] = Utf8 access$300 
.const [74] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)Lde/audi/atip/log/LogChannel; 
.const [75] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [76] = Utf8 access$400 
.const [77] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)Ljava/util/LinkedList; 
.const [78] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [79] = Utf8 access$500 
.const [80] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)Lde/audi/atip/log/LogChannel; 
.const [81] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener 
.const [82] = Utf8 this$0 
.const [83] = Utf8 Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler; 
.const [84] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [85] = Utf8 getDeviceAddress 
.const [86] = Utf8 ()Ljava/lang/String; 
.const [87] = Utf8 de/audi/atip/log/LogChannel 
.const [88] = Utf8 log 
.const [89] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [90] = Utf8 java/util/LinkedList 
.const [91] = Utf8 contains 
.const [92] = Utf8 (Ljava/lang/Object;)Z 
.const [93] = Utf8 java/util/LinkedList 
.const [94] = Utf8 add 
.const [95] = Utf8 (Ljava/lang/Object;)Z 
.const [96] = Utf8 java/util/LinkedList 
.const [97] = Utf8 remove 
.const [98] = Utf8 (Ljava/lang/Object;)Z 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 log 
.const [101] = Utf8 (ILjava/lang/String;)Z 
.const [102] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)V 
.const [105] = Utf8 java/lang/Object 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener 
.const [109] = Utf8 this$0 
.const [110] = Utf8 Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler; 
.const [111] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener 
.const [112] = Class [111] 
.const [113] = Utf8 java/lang/Object 
.const [114] = Class [113] 
.const [115] = Utf8 de/audi/app/phone/core/bluetooth/ITelBluetoothListener 
.const [116] = Class [115] 
.const [117] = Utf8 this$0 
.const [118] = Utf8 Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler; 
.const [119] = Utf8 Code 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)V 
.const [122] = Utf8 updateTrustedDevices 
.const [123] = Utf8 ([Lorg/dsi/ifc/bluetooth/TrustedDevice;)V 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler$1;)V 
.end class 
