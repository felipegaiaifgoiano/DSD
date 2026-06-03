FROM ruby:3.3

WORKDIR /app

RUN apt-get update -y && apt-get install -y \
    build-essential \
    nodejs \
    sqlite3 \
    libsqlite3-dev

COPY Gemfile ./

RUN bundle install

COPY . .

EXPOSE 3000

CMD ["bash", "-c", "bundle exec rails db:migrate && bundle exec rails db:seed && bundle exec rails server -b 0.0.0.0"]