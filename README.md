# 💬 JavaFX Multi-Client Chat Application

This is a real-time **multi-client chat application** built using Java, JavaFX, and Java Sockets. It allows multiple users to log in and chat through a clean JavaFX interface, while the server broadcasts messages to all connected clients.

---

## 📁 Project Structure

JavaFXChatApp/
├── ChatClient/
│ └── src/
│ ├── Client.java
│ ├── ClientHandler.java
│ ├── ChatUI.java
│ └── LoginUI.java
├── ChatServer/
│ └── src/
│ └── Server.java
├── javafx-sdk-17.0.16/ (Not uploaded — configure locally)
├── .vscode/
│ └── settings.json
├── README.md
└── .gitignore


---

## 🚀 Features

- Real-time message broadcasting to all connected clients
- Multiple clients can connect simultaneously
- Separate UI for login and chat
- Clean and user-friendly JavaFX GUI
- Server logs incoming connections and messages

---

## 🧠 How It Works

- The `Server.java` file runs the server and waits for incoming client connections.
- Each client runs the `Client.java` file, which starts with a login UI (`LoginUI.java`).
- On login, the client opens the chat window (`ChatUI.java`) and sends/receives messages.
- The `ClientHandler.java` on the server handles each client on a separate thread.
- Messages are broadcasted by the server to all connected clients.

---

## 🛠️ Technologies Used

- **Java**
- **JavaFX (UI framework)**
- **Java Sockets (network communication)**
- **Multithreading (client handling)**
- **VS Code / IntelliJ**
- **Git & GitHub**

---

## 🔧 How to Run the Project

### ✅ Prerequisites

- Java JDK 17 or higher installed
- JavaFX SDK 17 downloaded from [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)
- Code editor like VS Code or IntelliJ
- Terminal or Command Prompt

---

### ⚙️ Setting Up JavaFX in VS Code

1. Download and extract JavaFX SDK 17 from [here](https://gluonhq.com/products/javafx/).
2. Place it in a known location, e.g.,  
   `C:\Users\sneha\Downloads\openjfx-17.0.16_windows-x64_bin-sdk\javafx-sdk-17.0.16`
3. Go to `.vscode/settings.json` and set:

`json
{
  "java.project.referencedLibraries": [
    "lib/**/*.jar"
  ]
}


👩‍💻 About the Author

Sneha Dhir
🎓 B.Tech CSE (AIML)
🏫 University of Petroleum and Energy Studies (UPES), Dehradun
📧 Email: snehadhir7998@gmail.com
💬 Passionate about Java, software development, and building practical projects.

⸻


