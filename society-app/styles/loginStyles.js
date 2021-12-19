import { Dimensions, StyleSheet } from "react-native";

const height = Dimensions.get("window").height;
const width = Dimensions.get("window").width;
const headerHeight = height * 0.1;
const bodyHeight = height * 0.35;
const bodyWidth = width * 0.8;
const footerHeight = height * 0.1;

export const loginStyles = StyleSheet.create({
    header: {
        height: headerHeight,
        width: width,
        paddingLeft: width * 0.15,
        display: "flex",
        justifyContent: "center",
    },
    headerText:{
        fontSize: 0.6 * headerHeight,
        color: "#0091ea",
        fontWeight: "400",
    },
    bodyPart:{
        height: bodyHeight,
        width: bodyWidth,
        backgroundColor: "white",
        borderRadius: 0.02 * bodyWidth,
        marginTop: 0.06 * height,
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
    },
    footer:{
        height: footerHeight,
        marginTop: 0.02 * height,
        width: width,
        display: "flex",
        flexDirection: "row",
        justifyContent: "center",
        alignItems: "center",
    },
    footerText:{
        fontSize: 0.25 * footerHeight,
    },
    footerButton:{
        color: "#03a9f4",
    },
    error:{
        width: bodyWidth,
        textAlign: "center",
        color: "red",
        fontSize: 0.25 * footerHeight,
        marginTop: 0.015 * height,
        marginBottom: 0.015 * height,
    },
    input: {
        height: 0.05 * height,
        width: 0.7 * bodyWidth,
        marginTop: 0.02 * height,
        marginBottom: 0.02 * height,
        paddingLeft:0.03 * width,
        borderBottomWidth: 0.001 * height,
        borderColor: "#a1a1a1",
        fontSize: 0.02 * height,
        backgroundColor: "white",
    },
    btn: {
        height: 0.05 * height,
        width: 0.5 * bodyWidth,
        marginTop: 0.02 * height,
        marginBottom: 0.02 * height,
        borderRadius: 0.02 * height,
    },
})