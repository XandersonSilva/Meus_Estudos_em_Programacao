import { useEffect, useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, SafeAreaView } from 'react-native';
import { Camera, CameraType, CameraView } from 'expo-camera';

export default function App() {
  const [type, setType] = useState("back")
  const [hasPermission, setHaspermission] = useState(null)


  useEffect(()=>{
    (async () =>{
      const {status} = await Camera.requestCameraPermissionsAsync()
      setHaspermission(status === "granted")
    })();
  }, [])

  // if (hasPermission === null) {
  //   return <View/>
  // }
  // if (hasPermission === false) {
  //   return <Text>Acesso negado</Text>
  // }

  return (
    <View style={styles.container}>
      <Text>
        aaaaa
      </Text>
      <SafeAreaView
          style={styles.cameraContainer}
      >
        <CameraView
          style={styles.camera}
          facing={"back"}
        >
        </CameraView>

      </SafeAreaView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex:1,
    justifyContent: 'center',
  },
  camera:{
    flex:1
  },
  cameraContainer:{
    width:640,
    height:480
  }
});
