# Sistema de Gerenciamento de Biblioteca

Aplicação de console em Java para verificar a elegibilidade de empréstimos e calcular multas por atraso na devolução de livros.

## Estrutura

```text
TP1/
├── src/
│   ├── Biblioteca.java
│   └── Main.java
├── .gitignore
└── README.md
```

## Requisitos

- JDK instalado

## Compilar e executar

No PowerShell, na pasta raiz do projeto:

```powershell
javac -d out src\Main.java src\Biblioteca.java
java -cp out Main
```

O programa apresenta um menu para verificar empréstimos, calcular multas ou sair.
