import { useRef, useState } from 'react';
import { StyleSheet, Text, View, SafeAreaView, TouchableOpacity, Image, Modal } from 'react-native';
import { useCameraPermissions, CameraView } from 'expo-camera';
import { FontAwesome } from "@expo/vector-icons"

export default function App() {
  const [type, setType] = useState("back")
  const [permission, requestPermission] = useCameraPermissions();
  const camRef = useRef(null)
  const [capturedPhoto, setCapturedPhoto] = useState(null)
  const [open, setOpen] = useState(false)

    if (permission === null) {
      return <View/>
    }
    if (permission === false) {
      return <Text>Acesso negado</Text>
    }

  async function takePicture() {
    if (camRef) {
      const data = await camRef.current.takePictureAsync()
      setCapturedPhoto(data.uri)
      setOpen(true)
    }
  }

  return (
    <View style={styles.container}>
        {capturedPhoto && (
          <Modal
          animationType='slide'
          transparent={true}
          visible={open}
          style={styles.contentModal}

          >
          <View 
            style={styles.contentModal}
          >
            <TouchableOpacity
              style={styles.closeButtron}
              onPress={() => {setOpen(false)}}
            >
              <FontAwesome name='close' size={23} color="#555"></FontAwesome>
            </TouchableOpacity>
            <Image style={styles.imgPhoto} source={{ uri: capturedPhoto }} />
          </View>
        </Modal>)}
      <SafeAreaView
          style={styles.cameraContainer}
      >
        <CameraView
          style={styles.camera}
          facing={type}
          ref={camRef}
        >

        <View 
          style={styles.contentButtons}
        >
          <TouchableOpacity
            style={styles.buttonFlip}
            onPress={ () => {
              setType(
                type === "back" ? "front" : "back"
              )
            }
            }
          >
            <FontAwesome name="exchange" size={23} color="red"></FontAwesome>
          </TouchableOpacity>
          <TouchableOpacity
            style={styles.buttonCamera}
            onPress={takePicture}
          >
            <FontAwesome name="camera" size={23} color="#333"></FontAwesome>
          </TouchableOpacity>
        </View>
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
  },
  contentButtons:{
    flex:1,
    backgroundColor:"transparent",
    flexDirection:"row"
  },
  buttonFlip:{
    position:"absolute",
    bottom:50,
    left:30,
    justifyContent: 'center',
    alignItems:"center",
    backgroundColor:"#ffffff",
    padding:10,
    borderRadius:32,
    margin:20,
    
  },
  buttonCamera:{
    position:"absolute",
    bottom:100,
    left:30,
    justifyContent: 'center',
    alignItems:"center",
    backgroundColor:"#ffffff",
    padding:10,
    borderRadius:32,
    margin:20,
  },
  contentModal:{
    flex:1,
    justifyContent:"center",
    alignItems:"center",
    margin:20
  },
  closeButtron:{
    position:"absolute",
    top:10,
    left:2,
    margin:10,
  },
  imgPhoto:{
    width:400,
    height:400,
    resizeMode: 'contain'
  }


});
