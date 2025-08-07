import React from "react";
import { Text, View } from "react-native";
import style from "./style"

export default function Title(){
    return(
        <View style={style.boxTitle}>
            <Text style={style.textTitle}>ONEBITHEALTH</Text>
        </View>
    );
}