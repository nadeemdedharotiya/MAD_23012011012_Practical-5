package com.example.a23012011030_mad_pr5.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

@Composable
fun FormField(
    label: String,
    textState: String,
    onTextChange: (String) -> Unit,
    isPasswordFiled: Boolean = false,
    isNumber: Boolean = false
) {
    OutlinedTextField(
        value = textState,
        onValueChange = {
            if (isNumber) {
                if (it.all { c -> c.isDigit() }) onTextChange(it)
            } else {
                onTextChange(it)
            }
        },
        label = { Text("Enter $label") },
        visualTransformation = if (isPasswordFiled)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
        keyboardOptions = if (isNumber)
            KeyboardOptions(keyboardType = KeyboardType.Number)
        else
            KeyboardOptions.Default,
        modifier = Modifier
    )
}
