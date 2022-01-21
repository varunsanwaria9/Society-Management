import React from 'react'
import { View,Text, Pressable,StyleSheet,Dimensions } from 'react-native'
import { globalStyles } from '../styles/globalStyles'

const height = Dimensions.get('window').height
const width = Dimensions.get('window').width

export default function Home({navigation}) {
    return (
        <View style={globalStyles.mainBody}>
            <Pressable style={[globalStyles.btnPrimary,homeStyles.btn]} onPress={() => navigation.navigate("Login")}>
                <Text style={[globalStyles.btnPrimaryText,homeStyles.text]}>Login</Text>
            </Pressable>
            <Pressable style={[globalStyles.btnPrimary,homeStyles.btn]} onPress={() => navigation.navigate("Register")}>
                <Text style={[globalStyles.btnPrimaryText,homeStyles.text]}>Register</Text>
            </Pressable>
        </View>
    )
}

const homeStyles = StyleSheet.create({
    btn:{
        margin:0.02 * height,
        padding: 0.02 * height,
        width: 0.6 * width,
        borderRadius:10,
        height: 0.1 * height,        
    },
    text:{
        fontSize: 0.04 * height,
    }
})
