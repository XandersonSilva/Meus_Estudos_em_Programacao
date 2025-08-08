import React, {useState} from "react";
import {
        Text,
        View,
        TextInput,
        TouchableOpacity,
        Pressable,
        Keyboard,
        Vibration
} from "react-native";
import ResultImc from "../ResultImc";
import styles from "./style"

export default function Form(){
    const [height, setHeight] = useState(null)
    const [weight, setWeight] = useState(null)
    const [messageImc, setMessageImc] = useState("Preencha o peso e a altura")
    const [imc, setImc] = useState(null)
    const [textButton, setTextButton] = useState("Calcular")
    const [errorMessage, setErrorMessage] = useState(null)


    function imcCalculator() {
        let heightFormat = height.replace(",", ".")
        let weightFormat = weight.replace(",", ".")
        return setImc((weightFormat/(heightFormat * heightFormat)).toFixed(2))
    }

    function verificationImc(){
        if(height == null || weight == null){
            Vibration.vibrate(70);
            setErrorMessage("campo obrigatório")
        }
    }

    function validationImc(){
        if (weight != null && height != null) {
            imcCalculator()
            setHeight(null)
            setWeight(null)
            setMessageImc("Seu IMC é igual: ")
            setTextButton("Calcular Novamente")

            setErrorMessage(null)
        }else{
            verificationImc()
    
            setImc(null)
            setTextButton("Calcular")
            setMessageImc("Preencha o peso e a altura")
        }

    }

    return(
        <View style={styles.formContext}>
            {imc == null ?  
            <Pressable 
                style={styles.form}
                onPress={Keyboard.dismiss}
            >
                <Text style={styles.formLabel}>Altura</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setHeight}
                    value={height}
                    placeholder="Ex. 1.75"
                    keyboardType="numeric"
                ></TextInput>
                <Text
                    style={styles.errorMessage}
                >{errorMessage}</Text>

                <Text style={styles.formLabel}>Peso</Text>

                <TextInput
                    style={styles.input}
                    onChangeText={setWeight}
                    value={weight}
                    placeholder="Ex. 75.52"
                    keyboardType="numeric"
                ></TextInput>

                <Text style={styles.errorMessage}>
                    {errorMessage}
                </Text>

                <TouchableOpacity
                    style={styles.buttonCalculator}
                    
                    onPress={() => {validationImc()}}
                >
                    <Text
                    style={styles.TextButtonCalculator}
                    >{textButton}</Text>
                </TouchableOpacity>
                
            </Pressable>
            : 
            <View style={styles.exhibitionResultImc}>
                <ResultImc 
                    messageResultImc={messageImc}
                    resultImc={imc}
                />
                <TouchableOpacity
                    style={styles.buttonCalculator}
                    
                    onPress={() => {validationImc()}}
                >
                    <Text
                    style={styles.TextButtonCalculator}
                    >{textButton}</Text>
                </TouchableOpacity>
            </View>
            }
              
        </View>
    );
}