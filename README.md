Notification System with Kafka and Spring Cloud

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring](https://img.shields.io/badge/Spring_Boot-3.1.5-green)
![Cloud](https://img.shields.io/badge/Spring_Cloud-2022.0.4-brightgreen)
![Kafka](https://img.shields.io/badge/Apache_Kafka-3.4.1-orange)
![Docker](https://img.shields.io/badge/Docker-lightblue)

*Микросервисная система для обработки и анализа уведомлений, построенная на Spring Cloud и Apache Kafka.*


## 🌟 Основные возможности
Многоканальная отправка уведомлений (SMS, Email, Push)

Сбор и анализ метрик в реальном времени

Масштабируемая архитектура на базе Spring Cloud

Автоматическое восстановление после сбоев

Мониторинг через Spring Boot Actuator и кастомные метрики

## 🏗️ Архитектура

<img width="744" height="751" alt="image" src="https://github.com/user-attachments/assets/5a5f9f17-0545-4e05-8d8b-cf11e2ae097a" />



## 🚀 Быстрый старт
Запуск build-and-run.sh

## 🛠 Технологический стек
Ядро: Java 17, Spring Boot 3, Spring Cloud

Брокер сообщений: Apache Kafka

База данных: MongoDB

Обнаружение сервисов: Eureka

API Gateway: Spring Cloud Gateway

Контейнеризация: Docker, Docker Compose

## 📊 Мониторинг
Доступные endpoints:

Eureka Dashboard: http://localhost:8761

Actuator Health: http://localhost:8080/actuator/health

All notification http://localhost:8080/api/metrics

TYPE notification http://localhost:8080/api/metrics/{TYPE}
