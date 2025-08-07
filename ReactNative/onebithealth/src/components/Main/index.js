import React from "react";
import { View } from "react-native";
import { StyleSheet } from "react-native";
import Form from "../Form";

export default function Main(){
    return(
        <View style={
            {alignItems:"center"}
        }>
            <Form/>
        </View>
    );
}