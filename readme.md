

#  AntiQueimada API

API RESTful para apoio ao monitoramento e combate a queimadas ilegais, com foco na proteção ambiental e suporte a pequenos agricultores. Desenvolvido em Java com Spring Boot.

---

##  Sumário

- [ Objetivo ]
- [ Estrutura do Projeto ]
- [ Como Executar]
- [ Tecnologias]
- [ Endpoints Principais]
- [ Equipe]
- [ Licença]

---

##  Objetivo

Desenvolver um sistema backend para registrar e rastrear focos de queimadas, emitir alertas, registrar denúncias e manter informações sobre agricultores e municípios afetados, permitindo futura integração com APIs externas como a do IPAM.

---

##  Estrutura do Projeto

<pre>
📦 AntiQueimada-java-main
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┗ 📂 com.queimazero.queimazeroAPI
 ┃ ┃ ┃ ┃ ┣ 📂 controllers
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 AgricultorController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 MunicipioController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📄 PontoQueimadaController.java
 ┃ ┃ ┃ ┃ ┣ 📂 dto
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 AgricultorDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 Denuncia.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 EnderecoAgricultorDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 MunicipioDTO.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📄 PontoQueimadaDTO.java
 ┃ ┃ ┃ ┃ ┣ 📂 models
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 Agricultor.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 Alerta.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 Coordenadas.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 EnderecoAgricultor.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 Municipio.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📄 PontoQueimada.java
 ┃ ┃ ┃ ┃ ┣ 📂 repositories
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 AgricultorRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 AlertaRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 MunicipioRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📄 PontoQueimadaRepository.java
 ┃ ┃ ┃ ┃ ┣ 📂 services
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 AgricultorService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 AlertaService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 GeolocalizacaoService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📄 MunicipioService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📄 PontoQueimadaService.java
 ┃ ┃ ┃ ┃ ┣ 📄 Main.java
 ┃ ┃ ┃ ┃ ┗ 📄 QueimazeroApiApplication.java
 ┃ ┃ ┗ 📂 resources
 ┃ ┃   ┗ 📄 application.properties
 ┃ ┗ 📂 test
 ┃   ┗ 📂 com.queimazero.queimazeroAPI
 ┃     ┗ 📄 (Testes unitários e de integração, se houver)
 ┣ 📄 pom.xml
 ┗ 📄 README.md
</pre>

---

##  Como Executar

###  Requisitos

- Java 17+
- Maven 3.8+
- IDE recomendada: IntelliJ IDEA ou VS Code com Extensão Java

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/AntiQueimada-java-main.git
cd AntiQueimada-java-main

# Build do projeto
mvn clean install

# Rodar a aplicação
mvn spring-boot:run
```

A API estará disponível por padrão em:  
 `http://localhost:8080`

---

##  Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 / PostgreSQL
- Maven
- Lombok

---

##  Endpoints Principais

| Recurso          | Método | Caminho                      | Descrição                          |
|------------------|--------|------------------------------|------------------------------------|
| Agricultores     | GET    | `/agricultores`              | Lista todos os agricultores        |
| Agricultores     | POST   | `/agricultores`              | Cadastra novo agricultor           |
| Pontos Queimada  | POST   | `/ponto-queimada`            | Registra ponto de queimada         |
| Municípios       | GET    | `/municipios`                | Lista municípios disponíveis       |
| Alertas          | GET    | `/alertas`                   | Lista alertas de queimadas         |
| Denúncias        | POST   | `/denuncias` (futuro)        | Registra denúncia                  |

---

##  Equipe

- Lucas Nunes Soares – RM: 566503
- Camily Vitória Pereira Macial – RM: 566520
- Gustavo Pinheiro de Oliveira – RM: 566358
---

## 📄 Licença

Projeto acadêmico da disciplina **Global Solution** - FIAP  
Uso educacional e experimental.  
 2025 - Todos os direitos reservados à equipe.

---
