package com.ivantarabay.passman;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class FormController {
    @FXML
    private TextField lengthField;
    
    @FXML
    private CheckBox numbersCheckBox;
    
    @FXML
    private CheckBox specialCharsCheckBox;
    
    @FXML
    private TextField passwordField;
    
    private final PasswordGenerator passwordGenerator = new PasswordGenerator();

    @FXML
    protected void onGenerateButtonClick() {
        try {
            int length = Integer.parseInt(lengthField.getText());
            boolean includeNumbers = numbersCheckBox.isSelected();
            boolean includeSpecialChars = specialCharsCheckBox.isSelected();
            
            String password = passwordGenerator.generate(length, includeNumbers, includeSpecialChars);
            passwordField.setText(password);
        } catch (NumberFormatException e) {
            showError("Invalid length", "Please enter a valid number for password length.");
        } catch (IllegalArgumentException e) {
            showError("Invalid input", e.getMessage());
        }
    }
    
    @FXML
    protected void onCopyButtonClick() {
        String password = passwordField.getText();
        if (!password.isEmpty()) {
            ClipboardContent content = new ClipboardContent();
            content.putString(password);
            Clipboard.getSystemClipboard().setContent(content);
            
            // Show a tooltip to confirm the copy
            Tooltip tooltip = new Tooltip("Password copied to clipboard!");
            tooltip.setAutoHide(true);
            tooltip.show(passwordField, 
                passwordField.getScene().getWindow().getX() + passwordField.getLayoutX(),
                passwordField.getScene().getWindow().getY() + passwordField.getLayoutY() + 30);
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}