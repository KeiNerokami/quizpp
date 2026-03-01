# Nata


Welcome, and thank you for using **Nata** a simple terminal-based quiz application written in Java.

This project was built for learning purposes and experimentation, much like many early-stage developer projects.

---

## Requirements

- Java JDK (8 or higher recommended)
- Gson library (`gson-2.10.1.jar`)
- (Optional) VSCode with Java extensions
    - suggest that you utilize `Extension Pack for Java` its pretty useful.

---

## Project Structure

```

.
├── nata/
│   ├── nata.java
│   └── shuf.java
├── assets/
│   ├── questions.json
│   ├── answers.json
│   └── config.json
└── lib/
    └── gson-2.10.1.jar

```

---

## How to Run (Manual Compilation)

### 1. Compile

### Windows
```

javac -cp ".;lib/gson-2.10.1.jar" nata/*.java

```

### Linux / macOS
```

javac -cp ".:lib/gson-2.10.1.jar" nata/*.java

```

---

### 2. Run

### Windows
```

java -cp ".;lib/gson-2.10.1.jar" nata.nata

```

### Linux / macOS
```

java -cp ".:lib/gson-2.10.1.jar" nata.nata

```

---

## Running in VSCode

Install the following extension:

- **Extension Pack for Java** by :contentReference[oaicite:0]{index=0}

If the IDE cannot resolve `com.google.gson`, create:

```

.vscode/settings.json

````

With:

```json
{
  "java.project.referencedLibraries": [
    "lib/gson-2.10.1.jar"
  ]
}
````

Reload VSCode after adding it.

---

## Notes

* Questions and answers are stored in JSON.
* Configuration is controlled via `assets/config.json`.
* No hardcoded quiz data inside the core logic.

That's all i think peace.



