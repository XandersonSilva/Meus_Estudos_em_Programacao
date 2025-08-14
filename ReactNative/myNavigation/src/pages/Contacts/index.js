import React from "react";
import { View, Text, TouchableOpacity } from "react-native";


export default function Contacts({navigation}){
  return(
    <View>
        
        <View>
            <Text>
                Nome: Pedro Cardosso
            </Text>
            <Text>
                Telefone: (71) 998453554
            </Text>
            <TouchableOpacity
                onPress={() => {navigation.navigate("Information", {
                    nome: "Pedro Cardosso",
                    telefone: "(71) 998453554",
                    endereco: "Rua das Flores",
                    email: "pedrocardosso@mail.com",
                })}}
            >
                <Text>Information...</Text>
            </TouchableOpacity>
        </View>

        <View style={{marginTop:30}}>
            <Text>
                Nome: Lara Rosa
            </Text>
            <Text>
                Telefone: (11) 999176454
            </Text>
    
            <TouchableOpacity
                onPress={() => {navigation.navigate("Information", {
                    nome: "Lara Rosa",
                    telefone: "(11) 999176454",
                    endereco: "Travessa lua nova",
                    email: "lararosa@mail.com",
                })}}
            >
                <Text>Information...</Text>
            </TouchableOpacity>
        </View>
    </View>
  )
  }