import { StyleSheet,Dimensions } from "react-native";

const height = Dimensions.get("window").height;
const width = Dimensions.get("window").width;

export const globalStyles = StyleSheet.create({
    mainBody: {
        height: height,
        width: width,
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        backgroundColor: 'silver',
    },
    btnPrimary: {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: '#0275d8',
    },
    btnPrimaryText: {
        color: '#fff',
    }
})
