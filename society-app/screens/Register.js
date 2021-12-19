import React, { useState } from 'react'
import { View,Text, TextInput, Pressable, TouchableWithoutFeedback, Keyboard, Dimensions } from 'react-native'
import DatePicker from 'react-native-datepicker'
import { globalStyles } from '../styles/globalStyles'
import { registerStyles } from '../styles/registerStyles'

export default function Register({navigation}) {
    
    const [user,setUser] = useState({
        name:'',
        email:'',
        password:'',
        phone:'',
        dob:'',
    })
    const [confPwd,setConfPwd] = useState('')
    const [error,setError] = useState("")
    const [showError,setShowError] = useState(false)

    const handleRegister = () => {
        console.log(user);
    }

    return (
        <View style={globalStyles.mainBody}>
                <View style={registerStyles.header}>
                    <Text style={registerStyles.headerText}>Society Name</Text>
                </View>
                <View style={registerStyles.bodyPart}>
                    {showError && <Text style={registerStyles.error}>{error}</Text>}
                    <TextInput style={registerStyles.input} 
                        value={user.name}
                        onChangeText={(text)=>setUser({...user,name:text})}
                        placeholder="Name" />
                    <TextInput style={registerStyles.input}
                        keyboardType="email-address"
                        value={user.email}
                        onChangeText={(text)=>setUser({...user,email:text})}
                        placeholder="Email" />
                    <TextInput style={registerStyles.input}
                        keyboardType='visible-password'
                        secureTextEntry={true}
                        value={user.password}
                        onChangeText={(text)=>setUser({...user,password:text})}
                        placeholder="Password" />
                    <TextInput style={registerStyles.input}
                        value={confPwd}
                        onChangeText={(text)=>setConfPwd(text)}
                        placeholder="Confirm Password" />
                    <TextInput style={registerStyles.input}
                        keyboardType='phone-pad'
                        value={user.phone}
                        onChangeText={(text)=>setUser({...user,phone:text})}
                        placeholder="Phone" />
                    <DatePicker style={registerStyles.date}
                        date={user.dob}
                        mode="date"
                        placeholder="Date of Birth"
                        format="YYYY-MM-DD"
                        confirmBtnText="Confirm"
                        cancelBtnText="Cancel"
                        customStyles={{
                            dateIcon: {
                                position: 'absolute',
                                left: 0,
                                top: 4,
                                marginLeft: 0
                            },
                            dateInput: {
                                marginLeft: 36,
                                borderWidth: 0,
                                borderBottomWidth: 1,
                            }
                        }}
                        onDateChange={(date) => {setUser({...user,dob:date})}} />
                    <Pressable style={[registerStyles.btn,globalStyles.btnPrimary]} onPress={handleRegister}>
                        <Text style={globalStyles.btnPrimaryText}>Register</Text>
                    </Pressable>
                </View>
                <View style={registerStyles.footer}>
                    <Text style={registerStyles.footerText}>Already have an account?</Text>
                    <Pressable  onPress={()=>navigation.navigate('Login')}>
                        <Text style={[registerStyles.footerButton,registerStyles.footerText]}>Login</Text>
                    </Pressable>
                </View>    
            </View>
        // <TouchableWithoutFeedback onPress={() => Keyboard.dismiss()}>
        // </TouchableWithoutFeedback>
    )
}
