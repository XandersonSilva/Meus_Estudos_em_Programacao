import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import AppContacts from "./src/pages/AppContacts";
import Contacts from "./src/pages/Contacts"
import Information from "./src/pages/Information"

const Tab = createBottomTabNavigator()
const Stack = createNativeStackNavigator()

function Tabs(){
  return(
    <Tab.Navigator>
        <Tab.Screen 
        name="Home" component={AppContacts}/>
        <Tab.Screen name="Contacts" component={Contacts}/>

      </Tab.Navigator>
  )
}

export default function App(){
  return(
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="AppContacts" component={Tabs} options={{ headerShown: false }} />
        <Stack.Screen name="Information" component={Information}/>

      </Stack.Navigator>
    </NavigationContainer>
    
  )
}

// Jeito de fazer com Drawer:
// import { createDrawerNavigator } from '@react-navigation/drawer';



// import Contacts from "./src/pages/Contacts"
// import Information from "./src/pages/Information"


// const Drawer = createDrawerNavigator();

// export default function App(){
//   return(
//     <NavigationContainer>
//       <Drawer.Navigator>
//         <Drawer.Screen name="Contacts" component={Contacts}/>
//         <Drawer.Screen name="Information" component={Information}/>

//       </Drawer.Navigator>
//     </NavigationContainer>
    
//   )
// }
