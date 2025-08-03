#!/usr/bin/env bash

PROJECT_ROOT=$(pwd)
COMPOSE_FILE="$PROJECT_ROOT/docker-compose.yml"

# Останавливаем контейнеры
docker-compose -f "$COMPOSE_FILE" down

# Очистка и пересборка проекта
mvn clean install -DskipTests

# Проверка сборки
if [ $? -ne 0 ]; then
    echo "Ошибка при сборке"
    exit 1
fi

# Сборка образов
docker-compose -f "$COMPOSE_FILE" build

# Запуск сервисов
docker-compose -f "$COMPOSE_FILE" up -d

# Проверка статуса
docker-compose -f "$COMPOSE_FILE" ps