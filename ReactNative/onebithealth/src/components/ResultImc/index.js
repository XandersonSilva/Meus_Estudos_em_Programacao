import React from "react";
import { Text, View, Share, TouchableOpacity, Touchable, ViewBase} from "react-native";
import styles from "./style";

export default function ResultImc(props){
    const onShare = async () =>{
        const result = await Share.share({
            message:"Meu imc hoje é: "+ props.resultImc,
        }
        )
    }
    return(
        <View style={styles.resultImc}>            
            <Text style={styles.information}>
                {props.messageResultImc}
            </Text>
            <Text style={styles.numberImc}>
                {props.resultImc}
            </Text>

            <View style={styles.boxSharebutton}>
                {props.resultImc != null ?
                <TouchableOpacity 
                    onPress={onShare}
                    style={styles.shared}>
                        
                    <Text style={styles.sharedText}>
                        Compartilhar
                    </Text>
                </TouchableOpacity>
                :
                <View/>
                }
            </View>
        </View>
    );
}