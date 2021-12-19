import React, { useState } from 'react'
import { View,Text, TextInput, Pressable, TouchableWithoutFeedback, Keyboard, Alert } from 'react-native'
import BasicApi from '../services/BasicApi'
import { globalStyles } from '../styles/globalStyles'
import { loginStyles } from '../styles/loginStyles'

export default function Login({navigation}) {

    const [user,setUser] = useState({
        email:'',password:''
    })
    const [errorMessage,setErrorMessage] = useState('Invalid Password')
    const [showError,setShowError] = useState(false)

    const handleLogin = () => {
        Keyboard.dismiss()
        BasicApi.login(user)
            .then(res => {
                if(res.status === 200){
                    console.log(res.data);
                }
                else{
                    setShowError(true)
                    setErrorMessage("Unknown Error Occured")
                }
            })
    }

    return (
            <View style={globalStyles.mainBody}>
                <View style={loginStyles.header}>
                    <Text style={loginStyles.headerText}>Society Name</Text>
                </View>
                <View style={loginStyles.bodyPart}>
                    {showError && <Text style={loginStyles.error}>{errorMessage}</Text>}
                    <TextInput style={loginStyles.input} 
                        keyboardType='email-address'
                        placeholder="Email" 
                        value={user.email}
                        onChangeText={(text) => setUser({...user,email:text})}/>
                    <TextInput style={loginStyles.input} 
                        secureTextEntry={true}
                        placeholder="Password" 
                        value={user.password}
                        onChangeText={(text) => setUser({...user,password:text})}/>
                    <Pressable onPress={handleLogin} style={[loginStyles.btn,globalStyles.btnPrimary]}>
                        <Text style={globalStyles.btnPrimaryText}>Login</Text>
                    </Pressable>
                </View>
                <View style={loginStyles.footer}>
                    <Text style={loginStyles.footerText}>Don't have an account?</Text>
                    <Pressable onPress={() => navigation.navigate("Register")} >
                        <Text style={[loginStyles.footerButton,loginStyles.footerText]}>Sign Up</Text>
                    </Pressable>
                </View>
            </View>
        // <TouchableWithoutFeedback onPress={ () => {Keyboard.dismiss()}}>
        // </TouchableWithoutFeedback>
    )
}
