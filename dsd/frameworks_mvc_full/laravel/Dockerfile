FROM php:8.4-cli

RUN apt-get update && apt-get install -y \
    unzip \
    sqlite3 \
    libsqlite3-dev

RUN docker-php-ext-install \
    pdo \
    pdo_sqlite

COPY --from=composer:latest \
    /usr/bin/composer \
    /usr/bin/composer

WORKDIR /app

COPY . .

RUN composer install

RUN touch database/database.sqlite

EXPOSE 8000

CMD sh -c "php artisan key:generate && php artisan migrate:fresh --seed && php artisan serve --host=0.0.0.0 --port=8000"