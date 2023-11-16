FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm config set fetch-retry-mintimeout 20000
RUN npm config set fetch-retry-maxtimeout 120000
RUN npm install -g npm@latest
RUN npm cache clean --force

FROM nginx:alpine
COPY --from=node /app/dist/crudtuto-Front /usr/share/nginx/html
