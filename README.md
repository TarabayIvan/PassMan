# ✨ PassMan - Password Generator

A simple password generator built with JavaFX.

![PassMan Screenshot](screenshot.png)

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Maven (for building)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/PassMan.git
cd PassMan
```

2. Build the project and create a standalone application:
```bash
mvn clean javafx:jlink
```

3. Run the application:
```bash
# On Windows
target\PassMan\bin\PassMan.bat

# On Linux/Mac
target/PassMan/bin/PassMan
```

## 💻 Usage

1. Enter your desired password length (default is 16 characters)
2. Select whether to include numbers and/or special characters
3. Click "Generate Password" to create a new password
4. Use the "Copy to Clipboard" button to copy the generated password
