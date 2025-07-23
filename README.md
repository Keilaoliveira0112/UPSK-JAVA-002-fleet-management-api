# 🚕 Fleet Management API — Projeto de Gestão de Frotas

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7-brightgreen.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

[![Deploy on Vercel](https://vercel.com/button)](https://vercel.com/import/project)

---

## 👋 Sobre o Projeto

Este projeto foi desenvolvido durante meu aprendizado em back-end com Java. A proposta era criar uma **API REST capaz de consultar localizações de veículos de uma frota de táxis em Pequim**, utilizando dados reais e em grande volume.

Foi desafiador e muito enriquecedor! Mais do que entregar um sistema funcional, esse projeto me ajudou a aplicar conceitos importantes e a lidar com problemas reais, como performance, importação massiva de dados e estruturação de código limpo.

---

## 🎯 O que eu aprendi com esse projeto

Durante o desenvolvimento, explorei diversos conceitos técnicos importantes:

- Criação de APIs REST com **Spring Boot**
- Persistência com **Hibernate** e **PostgreSQL**
- **Programação Orientada a Objetos (POO)** aplicada na prática
- Testes com **JUnit** e **Mockito**
- Organização e versionamento com **Git/GitHub**
- Uso de CLI para importação de dados em massa
- Otimização de performance no banco de dados com **índices** e **paginações**

---

## 🛠️ Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Hibernate  
- JUnit + Mockito  
- Swagger (em implementação)  
- Git + GitHub  

---

## 💻 **Destaque: CLI para Importação de Dados**

Uma das partes mais desafiadoras (e divertidas) desse projeto foi criar uma **Interface de Linha de Comando (CLI)** para importar os dados dos táxis e das trajetórias, que estavam disponíveis em mais de 10 mil arquivos `.txt`.

Com a CLI, é possível:

- Carregar **táxis** ou **trajetórias** diretamente do terminal
- Configurar banco de dados, host, porta e usuário de forma parametrizada
- Garantir performance e escalabilidade na hora da ingestão dos dados

### Exemplo de uso:

```bash
java UploadGPSData.java <path-to-files> \
--type=taxis|trajectories \
--dbname=<dbname> \
--host=<hostname> \
--port=<port> \
--username=<username>
````

📌 A senha do banco é solicitada dinamicamente no terminal, garantindo maior segurança.

---

## 🌐 Destaque: Endpoints da API REST (em evolução)

Os endpoints estão em processo de refinamento, com melhorias sendo feitas continuamente em performance, documentação e testes. 💪

📋 Endpoints previstos:

* `GET /taxis`
  Retorna a lista de táxis (com paginação)

* `GET /taxis/{id}/locations?date=YYYY-MM-DD`
  Consulta o histórico de localizações de um táxi em uma data específica

* `GET /taxis/last-location`
  Exibe a última localização registrada de cada táxi

* `GET /taxis/{id}/locations/export?date=YYYY-MM-DD`
  (Hacker edition!) Exporta os dados de localização para arquivo Excel

---

## 🔧 Em breve:

✅ Documentação com Swagger
✅ Testes automatizados
✅ Melhorias de performance e experiência do usuário

---

## 📊 Curiosidades

Os dados utilizados vieram do projeto **T-Drive da Microsoft**, com mais de 33 mil registros por táxi em um único dia.

Trabalhei com importação de arquivos reais, grandes volumes de dados e otimização de queries no banco.

---

## 🚀 Próximos Passos

* Implementar autenticação com Spring Security
* Automatizar o deploy com Docker
* Refinar os endpoints com testes E2E
* Enviar relatórios por e-mail como alternativa ao download Excel

---

## ✍️ Considerações Finais

Esse projeto tem um grande valor pessoal. Ele representa uma **virada de chave** na minha jornada rumo à tecnologia e me mostrou, na prática, o impacto que soluções bem pensadas podem causar — mesmo nos bastidores.

Se quiser trocar uma ideia sobre **Java**, **APIs**, **transição de carreira** ou só bater um papo, estou por aqui! 😄

---

## 📫 Contato

🔗 [Meu LinkedIn](https://www.linkedin.com/in/keilaoliveiradev/)
Vamos conversar sobre tecnologia, carreira e aprendizado contínuo!

---



